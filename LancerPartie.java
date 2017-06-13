package Echec;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JOptionPane;



/**
 * Classe permettant de lancer une partie d'échec.
 */

public class LancerPartie 
{
	
	protected static String mes;

	public static void main(String[] arg) 
	{
		boolean res = true;
		Jouer j = new Jouer();
		FenetrePrincipale f1 = new FenetrePrincipale();
		f1.remplirLettre(); // Méthode permettant de remplir le jLabel lettre.
		f1.remplirChiffre(); // Méthode permettant de remplir le jLabel chiffre
		f1.afficherEch(); // Méthode permettant d'afficher l'échiquier sur la fenêtre. 
		f1.positionnerCases(); // Méthode permettant de positonner les cases.
		f1.revalidate();
		Echiquier ech = null;
		System.out.println("Voulez-vous commencecez ou continuer une partie en cours ?");
		System.out.println("Taper le bouton correspondant et 1 pour une nouvelle partie et 2 pour en charger une partie ");
		int choix = 0;
		Scanner sc = new Scanner( System.in);
		
			f1.getNouvellePartie().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				j.demarrerPartie(f1);
				}
			});
			f1.getCharge().addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
				
					 mes = (String)JOptionPane.showInputDialog(null,"Quelle est le nom de votre fichier");
					JOptionPane.showMessageDialog(null, "La partie que vous aviez stopper vient de reprendre");	
					Echiquier ech = new Echiquier(j.charge(mes));
					j.demarrerPartie(f1,ech);
				}});
			choix = sc.nextInt();
			if ( choix == 1 )
			{
				Echiquier ec = new Echiquier();
				ec.initEchiquier();
				j.partie(f1,ec);
				
			}
			else
			{
				try
				{
					
					Echiquier e = new Echiquier();
					
					e.Echange(j.charge(getMes()));
					
					String jou1 = j.chargeJoueur(getMes());
					
					String jou2 = j.chargeJoueur2(getMes());
					
					String cou = j.chargeCouleur(getMes());
					
					int nbTour = j.chargeTour(getMes());
					
					boolean estBlanc = j.auBlanc(getMes());
					
					j.partieCharger(f1, e,jou1,jou2,cou,nbTour,estBlanc);
				}catch( Exception e){};
			}
		
		}

	public static String getMes() {
		return mes;
	}

	public static void setMes(String mes) {
		LancerPartie.mes = mes;
	}
		
	
	
}
