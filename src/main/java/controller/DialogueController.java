package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DialogueController {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label dialogueLabel;

    @FXML
    private ImageView characterImage;

    private String mode = "INTRO";
    private String[] dialogues;

    private int index = 0;
    private int charIndex = 0;
    private boolean texteFini = false;
    private Timeline timeline;

    @FXML
    public void initialize() {
        updateDialogues();
        characterImage.setImage(
                new Image(getClass().getResource("/images/policier.png").toExternalForm())
        );
        Platform.runLater(() -> rootPane.requestFocus());
        afficherDialogue();
    }

    public void setMode(String mode) {
        this.mode = mode;
        updateDialogues();
        index = 0;
        if (dialogueLabel != null) {
            afficherDialogue();
        }
    }

    private void updateDialogues() {
        if ("ENDING".equals(mode)) {
            dialogues = new String[] {
                    "Bien joué. Tu as réussi le quiz et récupéré les informations nécessaires.",
                    "Grâce à toi, nous savons désormais comment éviter la catastrophe.",
                    "La mission est un succès. La ville est sauvée.",
                    "Félicitations, agent."
            };
        } else {
            dialogues = new String[] {
                    "Écoute-moi bien. Une bombe a été placée quelque part en ville, et tout repose sur toi.",
                    "Tu vas devoir résoudre une série d'énigmes pour obtenir les bonnes informations.",
                    "Ton premier défi est un quiz. Il te faudra atteindre 5 bonnes réponses.",
                    "Reste concentré. La ville compte sur toi."
            };
        }
    }

    private void afficherDialogue() {
        if (timeline != null) {
            timeline.stop();
        }
        dialogueLabel.setText("");
        charIndex = 0;
        texteFini = false;
        String texte = dialogues[index];
        timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            if (charIndex < texte.length()) {
                dialogueLabel.setText(dialogueLabel.getText() + texte.charAt(charIndex));
                charIndex++;
            } else {
                texteFini = true;
            }
        }));

        timeline.setCycleCount(texte.length() + 1);
        timeline.play();
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            handleNext();
        }
    }

    private void handleNext() {
        if (!texteFini) {
            timeline.stop();
            dialogueLabel.setText(dialogues[index]);
            texteFini = true;
        } else {
            index++;
            if (index < dialogues.length) {
                afficherDialogue();
            } else {
                if ("INTRO".equals(mode)) {
                    openQuiz();
                } else {
                    dialogueLabel.setText("Fin du jeu.");
                }
            }
        }
    }

    private void openQuiz() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/quiz.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}