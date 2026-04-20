package service;

import model.QuizQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizService {

    private final List<QuizQuestion> allQuestions = new ArrayList<>();
    private final List<QuizQuestion> remainingQuestions = new ArrayList<>();

    public QuizService() {
        initQuestions();
        refillQuestionsIfNeeded();
    }

    private void initQuestions() {
        allQuestions.add(new QuizQuestion("Quelle est la capitale de la France ?",
                Arrays.asList("Paris", "Lyon", "Marseille", "Nice"), "Paris"));

        allQuestions.add(new QuizQuestion("Combien font 2 + 2 ?",
                Arrays.asList("3", "4", "5", "6"), "4"));

        allQuestions.add(new QuizQuestion("Quelle planète est appelée la planète rouge ?",
                Arrays.asList("Mars", "Terre", "Jupiter", "Vénus"), "Mars"));

        allQuestions.add(new QuizQuestion("Quel langage utilise JavaFX ?",
                Arrays.asList("Java", "Python", "C", "PHP"), "Java"));

        allQuestions.add(new QuizQuestion("Combien y a-t-il de jours dans une semaine ?",
                Arrays.asList("5", "6", "7", "8"), "7"));

        allQuestions.add(new QuizQuestion("Quelle est la couleur du ciel par temps clair ?",
                Arrays.asList("Bleu", "Rouge", "Vert", "Noir"), "Bleu"));

        allQuestions.add(new QuizQuestion("Quel animal aboie ?",
                Arrays.asList("Chat", "Chien", "Poisson", "Oiseau"), "Chien"));

        allQuestions.add(new QuizQuestion("Quel est le résultat de 10 / 2 ?",
                Arrays.asList("2", "3", "5", "8"), "5"));

        allQuestions.add(new QuizQuestion("Combien de continents existe-t-il ?",
                Arrays.asList("5", "6", "7", "8"), "7"));

        allQuestions.add(new QuizQuestion("Quel océan borde la côte ouest de la France ?",
                Arrays.asList("Atlantique", "Pacifique", "Indien", "Arctique"), "Atlantique"));

        allQuestions.add(new QuizQuestion("Quel est le plus grand mammifère ?",
                Arrays.asList("Éléphant", "Baleine bleue", "Lion", "Girafe"), "Baleine bleue"));

        allQuestions.add(new QuizQuestion("Quelle saison vient après le printemps ?",
                Arrays.asList("Automne", "Hiver", "Été", "Saison des pluies"), "Été"));

        allQuestions.add(new QuizQuestion("Quel instrument a 6 cordes le plus souvent ?",
                Arrays.asList("Piano", "Guitare", "Flûte", "Violon"), "Guitare"));

        allQuestions.add(new QuizQuestion("Quelle est la racine carrée de 81 ?",
                Arrays.asList("7", "8", "9", "10"), "9"));

        allQuestions.add(new QuizQuestion("Quel pays a la forme d’un hexagone en Europe ?",
                Arrays.asList("Italie", "France", "Espagne", "Belgique"), "France"));

        allQuestions.add(new QuizQuestion("Quel métal précieux est jaune ?",
                Arrays.asList("Argent", "Cuivre", "Or", "Fer"), "Or"));

        allQuestions.add(new QuizQuestion("Combien font 3 x 4 ?",
                Arrays.asList("7", "10", "12", "14"), "12"));

        allQuestions.add(new QuizQuestion("Quel est le contraire de grand ?",
                Arrays.asList("Long", "Petit", "Fort", "Large"), "Petit"));

        allQuestions.add(new QuizQuestion("Quel organe permet de respirer ?",
                Arrays.asList("Cœur", "Foie", "Poumons", "Estomac"), "Poumons"));

        allQuestions.add(new QuizQuestion("Dans quel pays se trouve Tokyo ?",
                Arrays.asList("Chine", "Japon", "Corée", "Thaïlande"), "Japon"));

        allQuestions.add(new QuizQuestion("Quel est le premier mois de l’année ?",
                Arrays.asList("Mars", "Janvier", "Juin", "Décembre"), "Janvier"));

        allQuestions.add(new QuizQuestion("Quel sport se joue avec un ballon rond ?",
                Arrays.asList("Football", "Tennis", "Natation", "Boxe"), "Football"));

        allQuestions.add(new QuizQuestion("Quelle couleur obtient-on avec bleu + jaune ?",
                Arrays.asList("Rouge", "Vert", "Violet", "Orange"), "Vert"));

        allQuestions.add(new QuizQuestion("Quel est l’animal symbole de la lenteur ?",
                Arrays.asList("Guépard", "Escargot", "Aigle", "Requin"), "Escargot"));

        allQuestions.add(new QuizQuestion("Combien d’heures y a-t-il dans une journée ?",
                Arrays.asList("12", "18", "24", "48"), "24"));

        allQuestions.add(new QuizQuestion("Quel est le plus petit nombre pair positif ?",
                Arrays.asList("0", "1", "2", "4"), "2"));

        allQuestions.add(new QuizQuestion("Quel fruit est jaune et courbé ?",
                Arrays.asList("Pomme", "Banane", "Fraise", "Cerise"), "Banane"));

        allQuestions.add(new QuizQuestion("Quel continent contient le désert du Sahara ?",
                Arrays.asList("Asie", "Afrique", "Europe", "Océanie"), "Afrique"));

        allQuestions.add(new QuizQuestion("Quel gaz respirons-nous principalement pour vivre ?",
                Arrays.asList("Oxygène", "Hydrogène", "Hélium", "Azote"), "Oxygène"));

        allQuestions.add(new QuizQuestion("Quelle matière étudie les calculs ?",
                Arrays.asList("Histoire", "Mathématiques", "SVT", "Musique"), "Mathématiques"));
    }

    private void refillQuestionsIfNeeded() {
        if (remainingQuestions.isEmpty()) {
            remainingQuestions.addAll(allQuestions);
            Collections.shuffle(remainingQuestions);
        }
    }

    public QuizQuestion getNextQuestion() {
        refillQuestionsIfNeeded();
        return remainingQuestions.remove(0);
    }

    public List<String> getShuffledAnswers(QuizQuestion question) {
        List<String> shuffledAnswers = new ArrayList<>(question.getAnswers());
        Collections.shuffle(shuffledAnswers);
        return shuffledAnswers;
    }
}