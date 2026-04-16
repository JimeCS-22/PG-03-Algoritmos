package ucr.algoritmos.pg03algoritmos.controller;

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
    private Button btnGenRandom;
    @javafx.fxml.FXML
    private Button btnClean;
    @javafx.fxml.FXML
    private Button btnMillerRabin;
    @javafx.fxml.FXML
    private Canvas canvasMiller;
    @javafx.fxml.FXML
    private Spinner<BigInteger> spParams;
    @javafx.fxml.FXML
    private TableView<List<String>> tableViewBigNumber;
    @javafx.fxml.FXML
    private Button btnCleanField;
    @javafx.fxml.FXML
    private TextField txfBigInteger;
    @javafx.fxml.FXML
    private ListView listViewOperations;

    //TAB-1 - ATRIBUTOS INTERNOS
    BigInteger min = new BigInteger("0");
    BigInteger max = new BigInteger("1000000000000000000");
    BigInteger initial = new BigInteger("1000000000000");
    BigInteger step = new BigInteger("1");

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
