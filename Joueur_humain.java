
import java.util.InputMismatchException;
import java.util.Scanner;

public class Joueur_humain extends Joueur{
	public Joueur_humain(String n, char p) {
		super(n,p);
		this.type="humain";
	}
	
	/* La methode saisir permettant a un joueur de saisir une colonne valide et non pleine*/
	public int Saisir(Grille g,Joueur j1, Scanner s) {
		int m = -5;
		if(!j1.getType().equalsIgnoreCase("ia")) {
		try {
				m=(int) s.nextInt();
				
				if((m<-1 || m>g.getColonne())) {
					ExceptionT o= new ExceptionT();
					m=o.ExceptionTaille(g);
				}
			}catch(InputMismatchException e1) {
				ExceptionT o= new ExceptionT();
				m=o.ExceptioType(g);
			}
		}
		if(m!=0 && m!=-1) {
			if(g.getCaractere(0,m-1)!='.') {
				System.out.println("Colonne "+m+" est remplie, Rejouez "+j1.getNom());
				 return Saisir(g,j1,s);
			
		}
		}
		return m ;
	}
	public String getType() {
		return "humain";
	}

}
