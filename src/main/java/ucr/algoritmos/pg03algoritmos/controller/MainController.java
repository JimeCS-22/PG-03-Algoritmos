package ucr.algoritmos.pg03algoritmos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ucr.algoritmos.pg03algoritmos.model.MillerRabinResult;
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

    private final SecureRandom random = new SecureRandom();

    @FXML
    public void initialize() {

        spParams.setValueFactory(
                new BigIntegerSpinnerValueFactory(min, max, initial, step)
        );

        spParams.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txfBigInteger.setText(newVal.toString());
            }
        });

        txfBigInteger.textProperty().addListener((obs, oldVal, newVal) -> {
            clearCanvas();
        });

        colNumber.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getNumber()));

        colResult.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getResult()));

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

        clearCanvas();

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

    private void clearCanvas() {
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
        clearCanvas();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}