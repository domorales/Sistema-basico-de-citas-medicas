module ec.edu.espol.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
   requires javafx.media;

    opens ec.edu.espol.gui to javafx.fxml;
    opens ec.edu.espol.controller to javafx.media;
    exports ec.edu.espol.gui;
    exports ec.edu.espol.controller;
    exports ec.edu.espol.model;
    exports ec.edu.espol.model.util;

}
