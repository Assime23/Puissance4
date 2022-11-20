import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Puissance4 {
	/*
	 * La methode acceuil permet de debuter le jeu
	 */
	
	public static void acceuil() throws ExceptionT, IOException, InterruptedException {
		 Jouer e=new Jouer();
	Scanner s=new Scanner(System.in);
	for(int i=0;i<10;i++) {
		for(int j=0;j<16;j++) {
			if((j>0&&j<15 )&&(i==1||i==8)) {
				TimeUnit.MILLISECONDS.sleep(20);
				System.out.print("❖❖");
			}
			//if(i==6&& j<=5 && j>=11) System.out.println("  ");
			//if(i==6 &&j>5&&j<11) System.out.print("✵✵");
			if(i==0 || i==9 || j==0 || j==15 ) {
				TimeUnit.MILLISECONDS.sleep(20);
				System.out.print("░░");
			}else if(i==5 && j==1){
				String h="BIENVENUE DANS PUISSANCE 4😎";
				for(int l=0;l<h.length();l++) {
					TimeUnit.MILLISECONDS.sleep(120);
					System.out.print(h.charAt(l));
				}
				TimeUnit.MILLISECONDS.sleep(120);
			}
			else if(i!=5 && i!=1 && i!=8){
				System.out.print("  ");
			}else if((i==j && i!=4 && i!=6) || j-i==2) {
				System.out.print("");
			}

		}
		System.out.println();
	}
	TimeUnit.MILLISECONDS.sleep(150);
	System.out.print("\n   ○");
	TimeUnit.MILLISECONDS.sleep(150);
	System.out.print("     ◔");
	TimeUnit.MILLISECONDS.sleep(150);
	System.out.print("       ◑");
	TimeUnit.MILLISECONDS.sleep(150);
	System.out.println("          ●\n");
	TimeUnit.MILLISECONDS.sleep(500);
	System.out.println("* Veuillez faire un choix entre *");
	TimeUnit.MILLISECONDS.sleep(200);
	System.out.println("▬►1: PUISSANCE 4 par defaut\n▬►2: Configurer avant de jouer");
	int x;
	try{
		x=(int)s.nextInt();
		if(x<1 || x>2) {
			ExceptionT o=new ExceptionT();
			x=o.ExceptionTail(1, 2);
		}
	}catch(InputMismatchException e1) {
		ExceptionT o=new ExceptionT();
		x=o.ExceptioTyp(1, 2);
	}
	if(x==1) {
		Grille g=new Grille(6,7);
		//Joueur j1=,j2=new Joueur();
		e.saisieConfig(g,3);
		
	}else {
		System.out.println("\n\nChoisir entre \n1: Configurer la taille de la grille\n2: Configurer le nombre de manche à gagner\n3: Faire 1 puis 2");
		try{
			x=(int)s.nextInt();
			if(x<1 || x>3) {
				ExceptionT o=new ExceptionT();
				o.ExceptionTail(1, 3);
			}
		}catch(InputMismatchException e1) {
				ExceptionT o=new ExceptionT();
				x=o.ExceptioTyp(1, 3);
		}
		if(x==1) {
			int c=3,l=3 ;
			while(c*l%2!=0 || l*c<=8) {
				System.out.println("Veuillez a ce que le nombre de ligne multiplié\n   par le nombre de colonne soit pair et superieur ou egale à 8\n ");
				try {
					System.out.println("Entrer le nombre de ligne");
					 l=(int)s.nextInt();
					if(l<0) {
						ExceptionT o=new ExceptionT();
						l=o.ExceptionTail(1, 500);
					}
				}catch(InputMismatchException e1) {
						ExceptionT o=new ExceptionT();
						l=o.ExceptioTyp(1, 500);

					
				}
				try {
					System.out.println("\nEntrer le nombre de colonne: ");
					c=(int)s.nextInt();
					if(c<5) {
						ExceptionT o=new ExceptionT();
						c=o.ExceptionTail(5, 500);
					}
				}catch(InputMismatchException e1) {
						ExceptionT o=new ExceptionT();
						c=o.ExceptioTyp(1, 500);
					
				}
				
				
			}
			
						
			Grille g=new Grille(l,c);
			//Joueur j1=new Joueur(),j2=new Joueur();
			e.saisieConfig(g,3);
			//gestion(g,j1,j2,3);
			s.close();
			
		}else 
			if(x==2) {
			    int n;
				try {
					System.out.println("\n\nEntrer le nombre de manche pour gagner");
					n=(int)s.nextInt();
					if(n<0) {
						ExceptionT o=new ExceptionT();
						n=o.ExceptionTail(1, 500);
					}
				}catch(InputMismatchException e1) {
						ExceptionT o=new ExceptionT();
						n=o.ExceptioTyp(1, 500);

					
				}
				
				Grille g=new Grille(6,7);
				e.saisieConfig(g,n);
				s.close();
			}else {
				
				int c=3,l=3 ;
				while(c*l%2!=0 || l*c<=8) {
					System.out.println("\n\nVeuillez a ce que le nombre de ligne multiplié par\n  le nombre de colonne soit pair et superieur ou égal à 8\n");
					try {
						System.out.println("\nEntrer le nombre de ligne");
						 l=(int)s.nextInt();
						if(l<0) {
							ExceptionT o=new ExceptionT();
							l=o.ExceptionTail(1, 500);
						}
					}catch(InputMismatchException e1) {
							ExceptionT o=new ExceptionT();
							l=o.ExceptioTyp(1, 500);

						
					}
					try {
						System.out.println("Entrer le nombre de colonne: ");
						c=(int)s.nextInt();
						if(c<5) {
							ExceptionT o=new ExceptionT();
							c=o.ExceptionTail(5, 500);
						}
					}catch(InputMismatchException e1) {
							ExceptionT o=new ExceptionT();
							c=o.ExceptioTyp(1, 500);
						
					}
					
					
				}
				int n;
				try {
					System.out.println("Entrer le nombre de manche pour gagner");
					n=(int)s.nextInt();
					if(n<0) {
						ExceptionT o=new ExceptionT();
						n=o.ExceptionTail(1, 500);
					}
				}catch(InputMismatchException e1) {
						ExceptionT o=new ExceptionT();
						n=o.ExceptioTyp(1, 500);

					
				}
				Grille g=new Grille(l,c);
				//Joueur j1=new Joueur(),j2=new Joueur();
				e.saisieConfig(g,n);
				s.close();
				
			}
	
	}
	}
		public static void main(String arg[]) throws IOException, ExceptionT,  InterruptedException {
		    // Jouer e=new Jouer();
		     acceuil();
	}
}
