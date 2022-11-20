import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionT extends Exception{
	/**
	 * 
	 */
	//private int m;
	public ExceptionT() {
		
	}
	public int ExceptionTaille(Grille g) {
		
		
		Scanner s=new Scanner(System.in);
		 int m=-2;
		while((m<-1 ||m>g.getColonne())) {
			System.out.println("Erreur! Tapez un nombre compris entre -1 et "+g.getColonne());
			m=(int) s.nextInt();
		}
		return m;
	}
public int ExceptionTail(int x, int y) {
		
		
		Scanner s=new Scanner(System.in);
		 int m=-2;
		while((m<x ||m>y)) {
			System.out.println("Erreur! Tapez un nombre compris entre "+x+" et "+y);
			m=(int) s.nextInt();
		}
		return m;
	}
	public int ExceptioType(Grille g) {
		int m=-2;
		try { 
			Scanner s=new Scanner(System.in);
		    System.out.println(" Entrer un entier");
		     m=(int) s.nextInt();
		if(m<-1 || m>g.getColonne()) {
			ExceptionT o= new ExceptionT();
			 return o.ExceptionTaille(g);
		}
	}catch(InputMismatchException e1) {
		ExceptionT o=new ExceptionT();
		return o.ExceptioType(g);
		
		
	}
		//}
		return m;

 }
	public int ExceptioTyp(int x, int y) {
		int m=-2;
		try { 
			Scanner s=new Scanner(System.in);
		    System.out.println(" Entrer un entier");
		     m=(int) s.nextInt();
		if(m<x || m>y) {
			ExceptionT o= new ExceptionT();
			 return o.ExceptionTail(x,y);
		}
	}catch(InputMismatchException e1) {
		ExceptionT o=new ExceptionT();
		return o.ExceptioTyp(x,y);
		
		
	}
		return m;
	}

}
