# Java Escape - Guide d'utilisation

## Lancer le jeu

Ouvrir un terminal dans le dossier du projet (où se trouve le fichier pom.xml), puis exécuter :

```
mvn clean javafx:run
```

Si sa n'a pas marché, installé Maven

---

## Utilisation

Menu :

* Cliquer sur "Nouvelle partie" pour commencer
* Cliquer sur "Quitter" pour fermer le jeu

Dialogues :

* Le texte s’affiche progressivement
* Appuyer sur la touche ESPACE :
  * pendant l’animation : affiche tout le texte
  * après : passe au dialogue suivant

Quiz :

* Répondre aux questions en cliquant sur une réponse
* Objectif : obtenir 5 bonnes réponses
* Les questions sont aléatoires
* Si toutes les questions sont utilisées, elles recommencent

Fin :

* Une fois 5 bonnes réponses atteintes, un dialogue final s’affiche
* Le jeu se termine
