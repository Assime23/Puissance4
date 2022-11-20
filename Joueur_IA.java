import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Joueur_IA extends Joueur {
	public Joueur_IA(String n, char p) {
		super(n,p);
		this.type="ia";
	}

	/* La methode saisir permettant a un joueur de saisir une colonne valide et non pleine*/
	public int Saisir(Grille g, Joueur j1, Scanner s) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(200);
		System.out.print("\n😇○");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print(" ◔");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.print("  ◑");
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.println("   ●\n");
		TimeUnit.MILLISECONDS.sleep(400);
		int m=(int) ((Math.random()*(g.getColonne()-1))+1);
		/*if(g.verifieVertical(g,a,z)==2) {
		if(z==0 || z==g.getColonne()-1 && g.getCaractere(a,3)=='.') {
			m=4;
		}else if(z==1 && g.getCaractere(a,z-1)=='.') {
			m=z-1;
		}else if(z==g.getColonne()-1 && g.getCaractere(a,z)=='.') {
			m=z+2;
		}else if(z==5 && g.getCaractere(a,z+1)=='.') {
			m=z+1;
			
		}else if(g.getCaractere(a,z-2)=='.') {
			m=z-2;
		}else if(z+3<g.getColonne()){
			for(int i=z+1;i<z+3;i++) {
				if(g.verifieDroite(g, a, i-1)&& g.getCaractere(a,i)=='.') {
					m=z;
				}else if(z-3>0) {
					for(int j=z;j>1;j--) {
						if(g.verifieDroite(g, a, i-1)&& g.getCaractere(a,i)=='.') {
							m=z;
						}
						
					}
				}
			}
		}
			
			
		
		
		
		
		
		/*if(z==0 || z==6 && g.tab[a][3]=='.') {
			m=3;
		}else if(z==1 &&g.tab[a][z-1]=='X') {
			   m=z+2;
		    }else{
			m=z-1;
		    }else 
			if(z==5 &&g.tab[a][z-1]=='X') {
                   m=z+1;
                   
			}else if(z!=7 && g.tab[a][z+1]=='.'){
				m=z+1;
			} else if(a!=6 && g.tab[a-1][z]=='.') {
				m=z;
			}
		
		
//	}
	

}*/
		//return m;
		if(m!=0 && m!=-1) {
			if(g.getCaractere(0,m-1)!='.') {
				System.out.println("Colonne "+m+" est remplie, Rejouez "+j1.getNom());
				 return Saisir(g,j1,s);
			
		}
		}
		return m ;
	
	}
	public String getType() {
		return "ia";
	}
	

}
