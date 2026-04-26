module ucr.algoritmos.pg03algoritmos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens ucr.algoritmos.pg03algoritmos to javafx.fxml;
    opens ucr.algoritmos.pg03algoritmos.model to javafx.base;
    exports ucr.algoritmos.pg03algoritmos;
    exports ucr.algoritmos.pg03algoritmos.controller;
    opens ucr.algoritmos.pg03algoritmos.controller to javafx.fxml;
    exports util;
    opens util to javafx.fxml;
}