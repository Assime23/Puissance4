import java.util.Scanner;

// La classe joueur permettant 
public abstract class Joueur {
	protected String nom;
	protected char pion;
	protected int point;
	protected String type;
	
	//Le constructeur sans paramètre
	public Joueur() {
		this.nom=null;
		this.pion= ' ';
		this.point=0;
		
	}
	
	
	//Le constructeur avec paramètre
	public Joueur(String n, char p) {
		this.nom=n;
		this.pion=p;
		this.point=0;
		
	}
	public char getPiontJoueursuivant() {
		if(this.pion=='X') return 'O';
		return 'X';
	}
	// L'accessseur du piont
	public char getPion() {
		return this.pion;
	}
	
	// L'accesseur de point
	public int getPoint() {
		return point;
	}
	
	
	//la methode d'ajout de 1 point
	public void ajoutePoint() {
		point++;
	}
	
	//Accesseur du nom du joueur
	public String getNom() {
		return this.nom;
	}
	public void setNom(String s) {
		this.nom=s;
	}
	public void setPiont(char c) {
		this.pion=c;
	}
	
	//Accesseur du type de joueur 
	protected abstract String getType() ;


	protected abstract int Saisir(Grille g, Joueur j1, Scanner s) throws InterruptedException;

}
