package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.QuizQuestion;
import service.QuizService;

import java.util.List;

public class QuizController {

    @FXML
    private Label questionLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button answerBtn1;

    @FXML
    private Button answerBtn2;

    @FXML
    private Button answerBtn3;

    @FXML
    private Button answerBtn4;

    private QuizService quizService;
    private QuizQuestion currentQuestion;
    private int score = 0;

    @FXML
    public void initialize() {
        quizService = new QuizService();
        updateScoreLabel();
        loadQuestion();
    }

    private void loadQuestion() {
        currentQuestion = quizService.getNextQuestion();
        questionLabel.setText(currentQuestion.getQuestion());

        List<String> answers = quizService.getShuffledAnswers(currentQuestion);

        answerBtn1.setText(answers.get(0));
        answerBtn2.setText(answers.get(1));
        answerBtn3.setText(answers.get(2));
        answerBtn4.setText(answers.get(3));
        resultLabel.setText("");
    }

    private void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            score++;
            resultLabel.setText("Correct !");
        } else {
            resultLabel.setText("Incorrect ! Bonne réponse : " + currentQuestion.getCorrectAnswer());
        }

        updateScoreLabel();

        if (score >= 5) {
            openFinalDialogue();
        } else {
            loadQuestion();
        }
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Bonnes réponses : " + score + " / 5");
    }

    private void openFinalDialogue() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dialogue.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            DialogueController controller = loader.getController();
            controller.setMode("ENDING");
            Stage stage = (Stage) questionLabel.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAnswer1() {
        checkAnswer(answerBtn1.getText());
    }

    @FXML
    private void handleAnswer2() {
        checkAnswer(answerBtn2.getText());
    }

    @FXML
    private void handleAnswer3() {
        checkAnswer(answerBtn3.getText());
    }

    @FXML
    private void handleAnswer4() {
        checkAnswer(answerBtn4.getText());
    }
}