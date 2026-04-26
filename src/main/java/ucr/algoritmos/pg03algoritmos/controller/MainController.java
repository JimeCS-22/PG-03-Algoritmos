package ucr.algoritmos.pg03algoritmos.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ucr.algoritmos.pg03algoritmos.model.LinkedList;
import ucr.algoritmos.pg03algoritmos.model.MillerRabinResult;
import ucr.algoritmos.pg03algoritmos.model.Node;
import ucr.algoritmos.pg03algoritmos.model.Node.*;
import ucr.algoritmos.pg03algoritmos.model.Probabilistic;
import ucr.algoritmos.pg03algoritmos.util.BigIntegerSpinnerValueFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MainController {

    @FXML private Spinner<BigInteger> spParams;

    BigInteger min = new BigInteger("1");
    BigInteger max = new BigInteger("999999999999999999");
    BigInteger initial = new BigInteger("1000000000000");
    BigInteger step = new BigInteger("1");

    @FXML private Canvas canvasBin;
    @FXML private Button btnMillerRabin;
    @FXML private TextField txfBigInteger;
    @FXML private Button btnClean;
    @FXML private Button btnCleanField;
    @FXML private ListView<String> listViewOperations;

    @FXML private TableView<MillerRabinResult> tableResults;
    @FXML private TableColumn<MillerRabinResult, String> colNumber;
    @FXML private TableColumn<MillerRabinResult, String> colResult;


    //atributos Tab Random Search and List
    @FXML
    private TextField ArrayText;

    @FXML
    private Button btnAgregarFinal;

    @FXML
    private Button btnAgregarInicio;


    @FXML
    private Button btnClearList;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnRandomSearch;

    @FXML
    private TableColumn<?, ?> colAttempts;
    @FXML
    private TableColumn<?, ?> colIndex;
    @FXML
    private TableColumn<?, ?> colMaxAttempts;

    @FXML
    private Button btnSearch;
    @FXML
    private Canvas canvasListDraw;
    @FXML
    private TableView<NodeInfo> tableLinkedList;
    @FXML
    private TableColumn<NodeInfo, String> colInsert;
    @FXML
    private TableColumn<NodeInfo, String> colValue;
    @FXML
    private TableColumn<NodeInfo, String> colPosition;

    @FXML
    private ListView<String> listViewOperationsList;

    @FXML
    private ListView<?> listViewOperationsRandom;

    @FXML
    private TabPane mainTabs;

    @FXML
    private Slider sliderPara;



    @FXML
    private TableView<?> tableResults1;

    @FXML
    private TextField textFieldValue;

    @FXML
    private TextArea txAreaNodeStructure;

    @FXML
    private Label txFieldNodeRepre;

    @FXML
    private Label txtInsertadoIn;

    @FXML
    private TextField txtMaxAttempts;

    @FXML
    private TextField txtValue;
    private final SecureRandom random = new SecureRandom();

    //atributos para Linked List
    private LinkedList<String> list = new LinkedList<>();
    private ObservableList<NodeInfo> dataTable = FXCollections.observableArrayList();
    private int contadorPosicion = 0; // atributo en tu Controller

    @FXML
    public void initialize() {
        setupMillerRabin();
        setupLinkedListTab();
        setupRandomSearch();
    }

    private void setupMillerRabin() {
        spParams.setValueFactory(
                new BigIntegerSpinnerValueFactory(min, max, initial, step)
        );

        spParams.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txfBigInteger.setText(newVal.toString());
            }
        });

        txfBigInteger.textProperty().addListener((obs, oldVal, newVal) -> {
            clearCanvasMiller();
        });

        colNumber.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getNumber()));

        colResult.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getResult()));

        colResult.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);

                    if (item.contains("Probablemente Primo")) {
                        setStyle("-fx-background-color: #b6ffb3; -fx-text-fill: black;");
                    } else {
                        setStyle("-fx-background-color: #ffb3b3; -fx-text-fill: black;");
                    }
                }
            }
        });

        colNumber.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    setStyle("-fx-font-weight: bold;");
                }
            }
        });

        btnMillerRabin.setOnAction(e -> runMillerRabin());
        btnClean.setOnAction(e -> reset());
        btnCleanField.setOnAction(e -> txfBigInteger.setText(""));
    }

    private void runMillerRabin() {

        String input = txfBigInteger.getText().trim();

        if (input.isEmpty()) {
            showAlert("Error", "Debe ingresar un número");
            return;
        }

        try {
            Probabilistic p = new Probabilistic();
            String result = p.millerRabin(input);

            boolean isPrime = result.contains("probably prime");

            ObservableList<String> items = FXCollections.observableArrayList(listViewOperations.getItems());
            items.add(input + " → " + (isPrime ? "✔ Primo" : "✘ No primo"));
            listViewOperations.setItems(items);

            tableResults.getItems().add(
                    new MillerRabinResult(
                            input,
                            isPrime ? "Probablemente Primo" : "No Primo"
                    )
            );

            drawCircle(input, isPrime);

        } catch (Exception e) {
            showAlert("Error", "Número inválido");
        }
    }

    private void drawCircle(String number, boolean isPrime) {

        GraphicsContext gc = canvasBin.getGraphicsContext2D();

        clearCanvasMiller();

        double size = 120;

        double x = (canvasBin.getWidth() - size) / 2;
        double y = (canvasBin.getHeight() - size) / 2;

        gc.setFill(isPrime ? Color.LIMEGREEN : Color.RED);
        gc.fillOval(x, y, size, size);

        gc.setStroke(Color.BLACK);
        gc.strokeOval(x, y, size, size);

        gc.setFill(Color.WHITE);
        gc.setFont(new Font(14));

        String text = number.length() > 10 ? number.substring(0, 10) + "..." : number;

        double textWidth = text.length() * 7;
        double textX = x + (size - textWidth) / 2;
        double textY = y + size / 2;

        gc.fillText(text, textX, textY);
    }

    private void clearCanvasMiller() {
        GraphicsContext gc = canvasBin.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasBin.getWidth(), canvasBin.getHeight());
    }

    @FXML
    private void generarAleatorio() {
        BigInteger rand = new BigInteger(50, random);
        txfBigInteger.setText(rand.toString());
    }

    private void reset() {
        listViewOperations.getItems().clear();
        tableResults.getItems().clear();
        clearCanvasMiller();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Methods Controller for Random Search @Alexander

    private void setupRandomSearch() {
        //config objetos
//        btnAgregarInicio.setOnAction(e -> addFirst());
//        btnAgregarFinal.setOnAction(e -> addLast());
//        btnSearch.setOnAction(e -> runSearchInLinkedList());
//        btnDelete.setOnAction(e -> cleanListTab());
//        btnClearList.setOnAction(e -> runSearchInLinkedList());
    }





    //Methods Controller for Linked List - Camila

    private void setupLinkedListTab() {
        colPosition.setCellValueFactory(new PropertyValueFactory<>("posicion"));
        colValue.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colInsert.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        tableLinkedList.setItems(dataTable);
        //config botones de operaciones
        btnAgregarInicio.setOnAction(e -> addFirst());
        btnAgregarFinal.setOnAction(e -> addLast());
        btnSearch.setOnAction(e -> runSearchInLinkedList());
        btnDelete.setOnAction(e -> remove());
        btnClearList.setOnAction(e -> cleanListTab());

    }


    private void addFirst() {
        String input = textFieldValue.getText().trim();

        if (input.isEmpty()) {
            showAlert("Error", "Debe ingresar un valor");
            return;
        }

        try {
            list.addFirst(input);
            String result = list.toString();
            //mostrar la Representación de la lista
            txFieldNodeRepre.setText(result);

           // colocar el registro de operaciones
            ObservableList<String> itemsResult = FXCollections.observableArrayList(result);
            listViewOperationsList.setItems(itemsResult);

            //llenado tabla
            // agregar fila a la tabla
            contadorPosicion++;
            int posicion = list.indexOf(input); //String.valueOf(posicion)

            dataTable.add(new NodeInfo(String.valueOf(contadorPosicion), input, "Inicio"));


            drawLinkedList(input);//dibujar la acción de addFirst en el Canvas

        } catch (Exception e) {
            showAlert("Error", "Valor inválido");
        }

    }

    private void addLast() {

            String input = textFieldValue.getText().trim();

            if (input.isEmpty()) {
                showAlert("Error", "Debe ingresar un valor");
                return;
            }

            try {
                list.addLast(input);
                txFieldNodeRepre.setText(list.toString());

                ObservableList<String> itemsResult = FXCollections.observableArrayList(list.toString());
                listViewOperationsList.setItems(itemsResult);

                contadorPosicion++;
                dataTable.add(new NodeInfo(
                        String.valueOf(contadorPosicion),
                        input,
                        "Final"
                ));

                drawLinkedList(input);

            } catch (Exception e) {
                showAlert("Error", "Valor inválido");
            }

    }

    private void runSearchInLinkedList() {

    }

    private void remove() {

    }
    private void cleanListTab() {
        txFieldNodeRepre.setText("");
        txtInsertadoIn.setText("");
        textFieldValue.setText("");
        listViewOperationsList.getItems().clear();
        tableLinkedList.getItems().clear();
        clearCanvasList();
    }

    private void clearCanvasList() {
        GraphicsContext gc = canvasListDraw.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasListDraw.getWidth(), canvasListDraw.getHeight());
    }

    private void drawLinkedList(String input) {

    }
    private void runLinkedList() {

        String input = textFieldValue.getText().trim();

        if (input.isEmpty()) {
            showAlert("Error", "Debe ingresar un valor");
            return;
        }

        try {
//            LinkedList<String> list = new LinkedList<>();
//            String result = list.add(input);
//
//            boolean isPrime = result.contains("probably prime");
//
//            ObservableList<String> items = FXCollections.observableArrayList(listViewOperations.getItems());
//            items.add(input + " → " + (isPrime ? "✔ Primo" : "✘ No primo"));
//            tableLinkedList.setItems(items);
//
//            tableResults.getItems().add(
//                    new MillerRabinResult(
//                            input,
//                            isPrime ? "Probablemente Primo" : "No Primo"
//                    )
//            );
//
//            drawCircle(input, isPrime);

        } catch (Exception e) {
            showAlert("Error", "Valor inválido");
        }
    }


}