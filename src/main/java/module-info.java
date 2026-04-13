module ucr.algoritmos.pg03algoritmos {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucr.algoritmos.pg03algoritmos to javafx.fxml;
    exports ucr.algoritmos.pg03algoritmos;
    exports ucr.algoritmos.pg03algoritmos.controller;
    opens ucr.algoritmos.pg03algoritmos.controller to javafx.fxml;
}