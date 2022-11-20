import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Jouer{
	private Joueur[] joueur=new Joueur[2];
	private Grille grille;
	public Jouer() {
		
	}
	// Le constructeur
	public Jouer(Grille g,Joueur j1, Joueur j2) {
		this.joueur[0]=j1;
		this.joueur[1]=j2;
		this.grille=g;
	}

		
	
	/* La méthode placePiont permet de placer le piont a la colonne j à la ligne non occupée i*/
			public int placePiont(Grille g, Joueur jr,int j) {
				int i;
						for(i=g.getLigne()-1;i>=0;i--) {
						if(g.getCaractere(i, j)=='.') {
							g.setCaractere(jr.getPion(), i, j);
							return i;
							
				    }
				}
						return i;
			}	
			

	public void saisieConfig(Grille g,int x) throws ExceptionT, IOException, InterruptedException {
		Scanner s=new Scanner(System.in);
		System.out.println("Tapez : \n ▬►1: pour jouer avec une autre personne 😐\n ▬►2: pour jouer contre une IA 🂡 ");
		int n;
		try{
			n=(int)s.nextInt();
			if(n<1 || n>2) {
				ExceptionT c=new ExceptionT();
				c.ExceptionTail(1, 2);
			}
		}catch(InputMismatchException e1) {
				ExceptionT c=new ExceptionT();
				n=c.ExceptioTyp(1, 2);
		}
		String nom_j1;
    	String nom_j2;
	    if(n==1){
	    	System.out.println("Entrer le nom du joueur 1: ");
	    	nom_j1= s.next();
	    	System.out.println("Entrer le nom du joueur 2: ");
	    	nom_j2=s.next();
	    	Joueur_humain j1=new Joueur_humain(nom_j1, 'X');
    		Joueur_humain j2=new Joueur_humain(nom_j2,'O');
    		gestion(g,j1,j2,x);
			s.close();
	         }else{
	        	 System.out.println("Tapez : \n ▬►1 : Si vous voulez être le Joueur 1"
	        	 		+ "\n ▬►2: pour que l'IA soit le Joueur 1");
	        	 try {
	        		 n=0;
	        		  n=s.nextInt();
	        		 if(n<1 || n>2) {
	        			 ExceptionT c=new ExceptionT();
	     				c.ExceptionTail(1, 2);
	        		 }
	        	 }catch(InputMismatchException e1) {
	        			ExceptionT c=new ExceptionT();
	    				n=c.ExceptioTyp(1, 2);
	        	 }
	     
	        	 System.out.println("Entrer votre nom : ");
		 	    	nom_j1= s.next();
		 	    	System.out.println("Entrer le nom de l'IA: ");
		 	    	nom_j2=s.next();
	        	 if(n==1) {
	        		 Joueur_humain j1=new Joueur_humain(nom_j1, 'X');
	        		Joueur_IA j2=new Joueur_IA(nom_j2,'O');
	        		 
	        		 gestion(g,j1,j2,x);
	        			s.close();
	        	 }else {
	        		 String temp=nom_j1;
	        		 nom_j1=nom_j2;
	        		 nom_j2=temp;
	        		 Joueur_IA j1=new Joueur_IA(nom_j1, 'X');
		        		Joueur_humain j2=new Joueur_humain(nom_j2,'O');
		        		gestion(g,j1,j2,x);
		        		s.close();
	        	 }
	        	
	        	// h="ia";
	         }
	
		
		 
		
		}
	
	
	/*
	 * La methode gestion permet de decider quel joueur vas joueur 
	 * controle l'etat de la grille
	 * 
	 */
	
	
	
	
	private void gestion(Grille g, Joueur j1, Joueur j2, int x) throws ExceptionT, IOException, InterruptedException {
		Scanner s=new Scanner(System.in);
		int i=1,temp=0,m=0;
		FileWriter fw=new FileWriter("log.txt");
		BufferedWriter brw= new BufferedWriter(fw);
		brw.write("Joueur 1 est un "+j1.getType()+" du nom : "+j1.getNom()+"\nJoueur 2 est un "+j2.getType()+" du nom : "+j2.getNom());
		System.out.println("Début de la manche N°1");
		brw.write("\n\nManche N°"+(temp+1)+" commence");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.print("\n   ○");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.print("     ◔");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.print("       ◑");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("          ●\n");
		TimeUnit.MILLISECONDS.sleep(500);
		g.affichage();
		while(j1.getPoint()<x && j2.getPoint()<x  ) {
		if(i<=g.getLigne()*g.getColonne()+temp) {
			
			if(i%2!=0) {
			    System.out.println("Joueur 1: "+j1.getNom()+"▬►");
			    
				m=j1.Saisir(g,j1,s);
				if(gestionPartie( g,j1, j2, i, m, x, temp,brw,  s )) {
					 if(j1.getPoint()<x) {
						 temp++;
						 i=temp;
						 brw.write("\n\nManche N°"+(temp+1)+" commence");
						 g.init();
						 System.out.println("\n\nDébut de la manche N°"+(temp+1));
						 TimeUnit.MILLISECONDS.sleep(500);
							System.out.print("\n   ○");
							TimeUnit.MILLISECONDS.sleep(500);
							System.out.print("     ◔");
							TimeUnit.MILLISECONDS.sleep(500);
							System.out.print("       ◑");
							TimeUnit.MILLISECONDS.sleep(500);
							System.out.println("          ●\n");
							TimeUnit.MILLISECONDS.sleep(500);
						 g.affichage();
						 
						 
					 }else {
						 System.out.println(j1.getNom()+" remporte la victoire");
						 TimeUnit.SECONDS.sleep(1);
						 brw.write("\n"+j1.getNom()+" remporte la victoire");				 
						 brw.close();
						 System.exit(-1);
					 }
				}
			  
			}else {
				System.out.println("Joueur 2: "+j2.getNom()+"▬►");
				m=j2.Saisir(g,j2,s);
				if(gestionPartie( g,j2, j1, i, m, x, temp,brw,  s )) {
					 if(j1.getPoint()<x) {
						 temp++;
						 i=temp;
						 brw.write("\\nnManche N°"+(temp+1)+" commence");
						 g.init();
						 System.out.println("\n\nDébut de la manche N°"+(temp+1));
						 TimeUnit.MILLISECONDS.sleep(500);
							System.out.print("\n   ○");
							TimeUnit.MILLISECONDS.sleep(500);
							System.out.print("     ◔");
							TimeUnit.MILLISECONDS.sleep(500);
							System.out.print("       ◑");
							TimeUnit.MILLISECONDS.sleep(500);
							System.out.println("          ●\n");
							TimeUnit.MILLISECONDS.sleep(500);
						 g.affichage();
						 
						 
					 }else {
						 System.out.println(j1.getNom()+" remporte la victoire");
						 TimeUnit.SECONDS.sleep(1);
						 brw.write("\n"+j1.getNom()+" remporte la victoire");				 
						 brw.close();
						 System.exit(-1);
					 }	
			}
			}
			i++;
		}else {
			System.out.println("\n\nEgalité pour la manche N°"+(temp+1));
			brw.write("\nEgalité pour cette manche");
			brw.write("\nScore "+j1.getPoint()+" - "+j2.getPoint());
			 System.out.println("\nScore "+j1.getPoint()+" - "+j2.getPoint());
			 TimeUnit.SECONDS.sleep(1);
			temp++;
			 i=temp+1;
			 brw.write("\n\nManche N°+"+(temp+1)+" commnce");
			 g.init();
			 System.out.println("\nDébut de la manche N°"+(temp+1));
			 TimeUnit.MILLISECONDS.sleep(500);
				System.out.print("\n   ○");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.print("     ◔");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.print("       ◑");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("          ●\n");
				TimeUnit.MILLISECONDS.sleep(500);
			 g.affichage();
			 
			
		   }
		}
	}
		
	
	
	private boolean gestionPartie(Grille g, Joueur j1, Joueur j2,int i, int m,int x,int temp,BufferedWriter brw, Scanner s ) throws IOException,  ExceptionT, InterruptedException {
	
		if(m==0) {
			brw.write("\nReprise de la partie");
			Puissance4.acceuil();
		}
		else
		if(m==-1) {
			System.out.println("Partie quittée avec success!");
			brw.write("\nPartie quittée avec success");
			brw.close();
			System.exit(m);
		}
		else {
		 int i1=placePiont(g, j1, m-1);
		 brw.write("\n"+j1.getNom()+" joue "+m);
		 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		 g.affichage();
		 if(g.verifie(g, i1, m-1)==true) {
			 System.out.println("\n\n");
			 g.affichage();
			 j1.ajoutePoint();
			 
			 System.out.println(j1.getNom()+" a gagné la manche N°"+(temp+1)+"\n");
			 brw.write("\n"+j1.getNom()+" remporte la manche N°"+(temp+1));
			 brw.write("\nScore "+j1.getPoint()+" - "+j2.getPoint());
			 System.out.println("\nScore "+j1.getPoint()+" - "+j2.getPoint());
			return true;
			
			
		    }
		}
		return false;
		 
	}
	
	
	
	

}
