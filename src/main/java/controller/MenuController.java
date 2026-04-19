package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void handleNouvellePartie() {
        System.out.println("Nouvelle game");
    }

    @FXML
    private void handleQuitter() {
        Platform.exit();
    }
}