package ucr.algoritmos.pg03algoritmos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import ucr.algoritmos.pg03algoritmos.model.Probabilistic;

import java.math.BigInteger;
import java.util.List;

public class MainController {
    @javafx.fxml.FXML
    private TabPane mainTabs;

    @javafx.fxml.FXML
    private Spinner<BigInteger> spParams;

    //TAB-1 - ATRIBUTOS INTERNOS
    BigInteger min = new BigInteger("0");
    BigInteger max = new BigInteger("1000000000000000000");
    BigInteger initial = new BigInteger("1000000000000");
    BigInteger step = new BigInteger("1");
    @FXML
    private Canvas canvasBin;
    @FXML
    private Button btnMillerRabin;
    @FXML
    private TextField txfBigInteger;
    @FXML
    private Button btnClean;
    @FXML
    private Button btnCleanField;
    @FXML
    private ListView listViewOperations;

    @FXML
    public void initialize() {
        setUpMillerRabin();

    }

    private void setUpMillerRabin() {

        //spParams.setValueFactory(new BigIntegerSpinnerValueFactory(min,max,initial,step));
        spParams.valueProperty().addListener((obs, oldValue, newValue) -> {
           txfBigInteger.setText(newValue.toString());
        });

        btnMillerRabin.setOnAction(e -> runMillerRabin());
        btnClean.setOnAction(e->reset(1));
        btnCleanField.setOnAction(e-> txfBigInteger.setText(""));
    }

    private void runMillerRabin() {

        Probabilistic p = new Probabilistic();
        String result = p.millerRabin(txfBigInteger.getText());
        ObservableList<String> items = FXCollections.observableArrayList(result);
        if(result.contains("is probably prime.")){
            //Tenemos que agregarlo al tableView
            items.add(result+="✔");
        }else{
            items.add(result+="✘");
        }

        listViewOperations.setItems(items);

    }

    private void reset(int i) {

        switch (i) {
            case 1: //Tab-1
                listViewOperations.getItems().clear();
                break;

            case 2 :
                break;
        }


    }


}
