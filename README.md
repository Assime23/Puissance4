# RAPPORT DE PROJET INFORMATIQUE – AUTEURS : KERE ASSIME & YODA NICOLAS
UNIVERSITE NORBERT ZONGO
UNITE DE FORMATION ET DE RECHERCHE EN SCIENCES ET TECHNOLOGIES
--------------------------------------------------------------------------------------------------------------------------------------
RAPPORT DE PROJET JAVA
----------------
Réalisé en Juillet 2022 par KERE Assime
&
YODA Nicolas
-----------------------------------
Enseignant : Dr Moustapha BIKIENGA
Filière : INFORMATIQUE Niveau
d’étude : Licence 2, Semestre 4 Année
académique : 2020-2021
1RAPPORT DE PROJET INFORMATIQUE – AUTEURS : KERE ASSIME & YODA NICOLAS
Sommaire
Introduction ..................................................................................... 2
I. Description et Fonctionnalités du jeu............................................ 2
II. Architecture ................................................................................ 3
II.1. Principales classes .................................................................... 3
II.2. Diagramme de classes UML ............................................. 5
Conclusion ....................................................................................... 5
Introduction
Ce document fait office de rapport pour notre premier projet en programmation
orienté objet dont le but était de coder un jeu de plateforme PUISSANCE 4 en
mode terminal.
Après de nombreuses réflexions, nous avons établi les principales règles de
gestion de notre jeu ainsi que les diagrammes de classe en nous servant entre
autres de la méthode MERISE vue en cours de Système d’informations puis
nous sommes passés au codage en JAVA.
Dans notre présent rapport nous décrirons d’une part le jeu, d’autre part les
différentes classes utilisés.
I.
Description et Fonctionnalités du jeu
Puissance 4 est un jeu dont le but consiste à d’aligner 4 pions. Ce jeu se joue
avec deux joueurs dont chacun possède son pion et les place dans une grille de
taille par défaut (6*7), l’utilisateur pourra aussi configurer la taille sous certaines
contraintes : la taille de la grille doit être pair et supérieur ou égale à 8 et aussi le
nombre de colonne doit dépasser 4.
2RAPPORT DE PROJET INFORMATIQUE – AUTEURS : KERE ASSIME & YODA NICOLAS
Le premier joueur à pouvoir aligner 4 pions de manière vertical, horizontal,
oblique (slash ou antislash) gagne la manche.
Par défaut le jeu se termine lorsqu’un joueur remporte 3 manches, mais il est
possible de configurer le nombre de manches à gagner.
Aussi l’utilisateur peut arrêter le jeu à tout moment en cliquant sur (-1) ou
redémarrer le jeu en cliquant sur (0) .
II. Architecture
II.1. Principales classes
Nous avons choisi dans ce paragraphe d’écrire les attributs en rouges et les classes en gras et les
méthodes en vert.
- Grille : Chaque objet Grille a un attribut tab de type tableau à deux
dimensions de caractères. Le choix du tableau à deux dimensions comme
attribut se justifie par le fait que nous souhaitions avoir un plateau
permettant de placer les pions.
• Les méthode principales méthodes dans cette classe sont :
•La méthode d’affichage(affichage()) permettant d’afficher la grille.
•La méthode d’initialisation de la grille ( init() ) permettant d’initialiser
la grille à l’état initiale.
les commutateurs et accesseurs (getCaractere(int i, int j), setPion(char
c,int i,int j) ) de pion qui vas permettre soit de récupérer soit de mettre
un caractère dans une position donnée de la grille.
Les différentes méthodes de vérification permettant de vérifier si 4
pions sont alignés.
•
•
- Joueur : cette classe est une classe abstraite et vas permettre à ces classe
filles Joueur_humain et Joueur_IA d’hériter d’elle. Comme attribut
dans cette classe on a :
o nom de type chaine de caractère permettant de représenter le nom
d’un joueur. o pion de type caractère permettant de représenter le
pion d’un joueur ;
o point de type entier permettant de stocker le nombre de point d’un
joueur.
Ces principales méthodes sont
• Les accesseurs et les commutateurs de pion, nom ;
3RAPPORT DE PROJET INFORMATIQUE – AUTEURS : KERE ASSIME & YODA NICOLAS
• La méthode ajoutePoint() permettant d’incrémenter à 1 les points
d’un Joueur.
• Deux méthodes abstraite getType() et Saisir(Grille, Joueur,
Scanner) qui seront redéfinit dans ces classes filles
Joueur_humain et Joueur_IA.
- Joueur_IA : cette classe hérite de la classe Joueur et redéfinie les
méthodes abstraites de Joueur de manière a ce que la méthode Saisir
génère automatiquement des nombres aléatoires.
- Joueur_humain : Cette classe hérite de la classe Joueur et redéfinie les
méthodes abstraites de Joueur de sorte que sa méthode Saisir fait rentrer
des entiers valides.
- Jouer : Cette classe possède comme attribut un tableau de Joueur (
joueur[]) et une grille. Ces principales méthodes sont :
• placePiont (Grille, Joueur, int) permettant de placer un pion dans
une colonne.
• saisieConfig( Grille, int) permettant de configurer avant le début
du jeu.
• gestion(Grille, Joueur, Joueur, int) permettant de gérer les début et
fin de manche, l’alternance des Joueurs, la fin de la partie.
• gestionPartie qui est une méthode qui permet à un joueur de quitter
la partie avec (-1) ou de redémarrer le jeu avec (0)
- ExceptionT : C’est une classe permettant de gérer les différentes
exceptions. Elle a comme méthodes :
• ExceptionTaille (Grille) qui gère les exceptions liées a la taille de
la grille.
• ExceptionTail(intx, int y) permettant de gérer une exception de
type intervalle, c’est à dire gérer l’exception lorsque l’utilisateur
tape un nombre qui n’est pas compris dans l’intervalle [x,y]
• ExceptionType(Grille) qui gère les exception lorsque l’utilisateur
tape un type incompatible dans le jeu.
4RAPPORT DE PROJET INFORMATIQUE – AUTEURS : KERE ASSIME & YODA NICOLAS
• ExceptionTyp(int x, int y) qui gère une exception de type
incompatible et lorsque l’utilisateur doit taper un entier compris
entre un intervalle [x, y].
- Puissance4 qui contient la classe main et qui a comme attribut Jouer et
une fonction acceuil() permettant de lancer le jeu.
II.2. Diagramme de classes UML
Conclusion
Ce projet nous a permis de renforcer d’une part nos connaissances en java et
d’autres part sur la programmation orienté d’une marinière générale et enfin
d’avoir une petite expérience du travail collaboratif.
En effet ce projet nous a permis de mettre en pratique nos connaissances vue en
cours notamment le concept de l’orienté objet qu’on avait du mal à cerner,
l’encapsulation, l’interaction entre les objets, l’héritage, les exceptions, le
diagramme de classe UML, et bien d’autres notions.
5
