import java.util.concurrent.TimeUnit;

public class Grille {
	private char tab[][];
	
	public Grille() {
		
	}
	// Le constructeur permettant l'initialisation de la grille
	public Grille(int l, int c) {
		tab=new char[l][c];
		for(int i=0;i<l;i++) {
			for(int j=0;j<c;j++) {
				this.tab[i][j]='.';
			}
		}
	}
	
	
	/*La methode getCaractere permettant d'avoir le caractere situé a la position i,j*/
	/*public char getCaractere(int i, int j) {
		return this.tab[i][j];
		
	}
	/* La methode ini() permettant de renitialiser la grille a l'etat initiale*/
	public void init() {
		for(int i=0;i<tab.length;i++) {
			for(int j=0;j<tab[0].length;j++) {
				this.tab[i][j]='.';
			}
		}
	}
	/* La methode affiche permettant d'afficher la grille*/
	public void affichage() throws InterruptedException {
		for(int l=0;l<tab[0].length;l++) {
			TimeUnit.MILLISECONDS.sleep(1);
			if(l<9) {
				System.out.print(l+1+"   "); // Affiche des valeurs numeriques au dessus de la grille
			}else {
				System.out.print(l+1+"  ");
			}
		}
		System.out.print("\n");
		for(int i=0;i<tab.length;i++) {
			for(int j=0;j<tab[0].length;j++) {
				TimeUnit.MILLISECONDS.sleep(1);
				System.out.print(this.tab[i][j]+"   ");
			}
			if(i==0) {
				//TimeUnit.SECONDS.convert(3, null);
				System.out.print("     Taper sur :");
			}
			if(i==1) System.out.print("     1,2,...à "+this.tab[0].length+" pour joueur ▦");
			if(i==2) System.out.print("     -1 pour quitter la partie ⊗");
			if(i==3)System.out.print("     0 pour redemarrer la partie ░");
			System.out.print("\n\n");
		}
	}
	
	/* La methode setPion() permettant de mettre un pion dans la grille*/
	public void setCaractere(char c,int i,int j) {
		this.tab[i][j]=c;
	}
	/* La methode getPion permettant d'avoir le pion à sa position*/
	public char getCaractere(int i,int j) {
		return this.tab[i][j];
	}
	/*getLine() permet de connaitre le nombre de ligne*/
	public int getLigne() {
    	return tab.length;
    }
	/*getLine() permet de connaitre le nombre de colonne*/
    public int getColonne() {
    	return tab[0].length;
    }
	
	/* La methode de verification de la gauche du pion courant*/
	private boolean verifieGauche(Grille g, int i,int j) {
		
		if(g.tab[i][j]==g.tab[i][j-1]) return true;
		return false;
	}
	/* La methode permettant la verification de la droite du pion courant*/
	private boolean verifieDroite(Grille g, int i, int j) {
		if(g.tab[i][j]==g.tab[i][j+1]) return true;
		return false;
	}
	/* La methode permettant de verifier le bas du pion courant*/
	private boolean verifieBas(Grille g, int i, int j) {
		if(g.tab[i][j]==g.tab[i+1][j]) return true;
		return false;
		
	}
	
	/* La methode permettant de vérifier la position Oblique Droite Bas*/
	private boolean verifieODB(Grille g, int i, int j) {
		if(g.tab[i][j]==g.tab[i+1][j+1]) return true;
		return false;
		
	}
	
	/* Verifie Oblique Gauche Bas*/
	private boolean verifieOGB(Grille g, int i, int j) {
		if(g.tab[i][j]==g.tab[i+1][j-1]) return true;
		return false;
		
	}
	/* Verifie Oblique Droite Haut*/
	private boolean verifieODH(Grille g, int i, int j) {
		if(g.tab[i][j]==g.tab[i-1][j+1]) return true;
		return false;
		
	}
	
	/*Verifie Oblique Gauche Haut*/
	private boolean verifieOGH(Grille g, int i, int j) {
		if(g.tab[i][j]==g.tab[i-1][j-1]) return true;
		return false;
	}
	/* La methode verifie Vertical permettant de  la verification horizontalement s'il y'a 4 pionts alignés*/
	public int verifieHorizontal(Grille g, int i, int j) {
		int compte=0;
			int p=j;
			int p1=j;
			while(p>j-3 || p1<j+3) {
				if(p>0) {
				   if(g.verifieGauche(g, i, p)!=false) {
					  compte++;
					  p--;
				   }else {
				   p=0;}
				}
				else if(p1<g.tab[0].length-1){
					if(g.verifieDroite(g, i, p1)!=false) {
						compte++;
						p1++;
			       }else {
					p1=g.tab[0].length;
					}
				}else {
					break;
				}	
			}
		return compte;
	}
	/*La methode verifieHorizontal permettant verticalement si 4 pionts identiques sont alignés*/  
	public int verifieVertical(Grille g, int i, int j) {
			int compte=0;
			int i1=i;
			int i2=i;
			while(i1>i-3 || i2<i+3) {
	        if(i2<g.tab.length-1 ){
					if(g.verifieBas(g, i2, j)!=false) {
						compte++;
						i2++;
						
						
			       }else {
			    	   i2=g.tab.length;
					}
				}else {
					
					break;
				}
			}
			return compte;
	}	   
	/* VerifieSlash verifie d'une maniere oblique slash(/)*/
	public int verifieSlash(Grille g, int i, int j) {
		int compte=0;
		int i1=i,i2=i;
		int j2=j,j3=j;
		while((i1>i-3 && i1<i+3) &&  (j2<j+3 && j2>j-3)) {
			if(i1>0 && j2<g.tab[0].length-1) {
			   if(g.verifieODH(g, i1, j2)!=false) {
				  compte++;
				  i1--;
				  j2++;
				 
			   }else {
			   i1=0;
			   }				
			}
		
			else if(i2<g.tab.length-1 && j3>0){
				if(g.verifieOGB(g, i2, j3)!=false) {
					compte++;
					i2++;
					j3--;
		       }else {
				i2=g.tab.length;
				//j3=0;
				}
			}else {
				break;
			}
		}
		return compte;
	}
	
	/* verifieAntislash verifie d'une manière antislash(\)*/
    private int verifieAntislash(Grille g, int i, int j) {	
		int compte=0;
		int i1=i,i2=i;
		int j2=j,j3=j;
		while((i1<i+3 && i1>i-3 ) && (j2<j+3 && j2>j-3)) {
			
			if(i1<g.tab.length-1 && j2<g.tab[0].length-1) {
			   if(g.verifieODB(g, i1, j2)!=false) {
				  compte++;
				  i1++;
				  j2++;
			   }else {
			   i1=g.tab.length;
			   j2=g.tab.length;
			   }				
			}
			else if(i2>0 && j3>0){
				if(g.verifieOGH(g, i2, j3)!=false) {
					compte++;
					i2--;
					j3--;
		       }
				else {
					i2=0;
					j3=0;
					}
		        }else {
					
             break;
			          }
		}
		return compte;
	}
    
    /* Verifie renvoie true( vraie) au cas ou il y'a alignement de 4 pionts identiques*/ 
	public boolean verifie(Grille g, int i, int j) {
		if(verifieHorizontal(g, i,  j)>=3) {
			return true;
		}else {
			if(verifieVertical( g, i, j)>=3) {
				return true;
			}else {
				if(verifieSlash(g, i,j)>=3) {
					return true;
				}else 
					if(verifieAntislash(g,i,j)>=3) {
					return true;
				}
			}
		}
		return false;
	}
}

