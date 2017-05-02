package Echecs;

import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		Echiquier ech = new Echiquier();
		ech.initEchiquier();
		int cpt = 0;
		ech.afficheEchiquier();
		do
		{
			
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			System.out.println("************************************************************");
			ech.seDeplacer(ech, a, b, c, d);
			cpt ++;
		}while(cpt<3 );
			

	}

}
