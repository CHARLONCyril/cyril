package Echec;

import java.util.Scanner;

public class Jouer {
	
	private int tour;
	
	public Jouer()
	{
		this.tour = 0;
	}
	
	public int getTour()
	{
		return this.tour;
	}
	
	
	public void setTour( int t)
	{
		this.tour = t;
	}
	
	public void demarrerPartie () {
		int cpt = 0;
		Echiquier e= new Echiquier();
		FenetrePrincipale i=new FenetrePrincipale();
		e.initEchiquier();
		i.remplirLettre();
		i.remplirChiffre();
		do{
			i.afficherEch();//--A mettre dans le do while-------------
			i.positionnerCases();
			i.afficherPieces(e);
			i.revalidate();
			if(tour%2==0)
				this.jouerModeClavier("blanc",e);
		cpt++;
		}while(cpt < 5);
	}
	
	public void jouerModeClavier(String c, Echiquier ech)
	{
		Scanner sc=new Scanner(System.in);
		int cpt = 0;
		int abs,ord,x,y;
		String str= "";
		String c1 ="";
		do
		{
			System.out.println("joueur"+c);
			System.out.println("Veuillez saisir les coordonnées de votre pièce");
			str = sc.nextLine();
			abs = (int) str.charAt(0)-65;
			ord = (int) str.charAt(1)-48;
			System.out.println("Veuillez saisir les coordonnées d'arrivée de votre pièce");
			c1 = sc.nextLine();
			x = (int) c1.charAt(0) -65;
			y = (int) c1.charAt(1) -48;
			ech.DeplacementEstValide(ech.getTab(abs,ord), x, y);
			cpt++;
			
		}while (cpt <1);
		sc.close();
		
	}

}
