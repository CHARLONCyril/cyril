package Echecs;

import javax.swing.ImageIcon;



public class Echiquier 
{
	private Piece [][] tab;
	/**
	 * Les images des différentes pièces.
	 */
	private ImageIcon imgCavalierB,imgCavalierN,imgFouB,imgFouN,imgPionB,imgPionN,imgReineB,imgReineN,imgRoiB, imgRoiN, imgTourB,imgTourN;
	
	
	public Echiquier()
	{
		tab = new Piece [8][8];
		imgCavalierB = new ImageIcon(getClass().getResource("/img/cavalier_b.png"));
		imgCavalierN = new ImageIcon(getClass().getResource("/img/cavalier_n.png"));
		imgFouB = new ImageIcon(getClass().getResource("/img/fou_b.png"));
		imgFouN = new ImageIcon(getClass().getResource("/img/fou_n.png"));
	    imgPionB = new ImageIcon(getClass().getResource("/img/pion_b.png"));
		imgPionN = new ImageIcon(getClass().getResource("/img/pion_n.png"));
		imgReineB = new ImageIcon(getClass().getResource("/img/reine_b.png"));
	    imgReineN = new ImageIcon(getClass().getResource("/img/reine_n.png"));
		imgRoiB = new ImageIcon(getClass().getResource("/img/roi_b.png"));
		imgRoiN = new ImageIcon(getClass().getResource("/img/roi_n.png"));
		imgTourB = new ImageIcon(getClass().getResource("/img/tour_b.png"));
		imgTourN = new ImageIcon(getClass().getResource("/img/tour_n.png"));
	}
	
	public void initEchiquier()
	{
			 setTab(0,0,(new Tour("NT",new Joueur("noir"),0,0,imgTourN,true)));
			 setTab(1,0,(new Cavalier("NC",new Joueur("noir"),1,0,imgCavalierN)));
			 setTab(2,0,(new Fou("NF",new Joueur("noir"),2,0,imgFouN)));
			 setTab(3,0,(new Dame("ND",new Joueur("noir"),3,0,imgReineN)));
			 setTab(4,0,(new Roi("NR",new Joueur("noir"),4,0,imgRoiN,true)));
			 setTab(5,0,(new Fou("NF",new Joueur("noir"),5,0,imgFouN)));
			 setTab(6,0,(new Cavalier("NC",new Joueur("noir"),6,0,imgCavalierN)));
			 setTab(7,0,(new Tour("NT",new Joueur("noir"),7,0,imgTourN,true)));
			 for(int i = 0; i <= 7; i++){
					setTab(i, 1, new Pion("NB",new Joueur("noir"),i, 1,imgPionN,true));
					setTab(i, 6, new Pion("BP",new Joueur("blanc"),i, 6,imgPionB, true));
			 }
			
			 setTab(0,7,(new Tour("BT",new Joueur("blanc"),0,7,imgTourB,true)));
			 setTab(1,7,( new Cavalier("BC",new Joueur("blanc"),1,7,imgCavalierB)));
			 setTab(2,7,( new Fou("BF",new Joueur("blanc"),2,7,imgFouB)));
			 setTab(3,7,(new Dame("BD",new Joueur("blanc"),3,7,imgReineB)));
			 setTab(4,7,( new Roi("BR",new Joueur("blanc"),4,7,imgRoiB,true)));
			 setTab(5,7,( new Fou("BF",new Joueur("blanc"),5,7,imgFouB)));
			 setTab(6,7,( new Cavalier("BC",new Joueur("blanc"),6,7,imgCavalierB)));
			 setTab(7,7,( new Tour("BT",new Joueur("blanc"),7,7,imgTourB,true)));
	}
	
	

	 /**
	  * Méthode insérant une pièce dans une case.
	  * @param x L'abscisse de la case
	  * @param y L'ordonnée de la case
	  * @param a La pièce à insérer dans cette case.
	  */
	
	public void setTab( int x, int y, Piece p1 )
	{
		if (x < 0 || x > 7 || y < 0 || y > 7){
			System.out.println("Erreur dans la coordonnee sur l'axe des abscisse ou des coordonnées: ("+x+","+y);
		}
		this.tab[x][y]=p1;
	}
	
	
	/**
	  * Cette méthode retourne si elle existe la piece d'une des case du tableau.
	  * @param x L'abscisse de la case
	  * @param y L'ordonnée de la case
	  * @return soit la pièce contenue dans cette case soit null car il y a eut une erreur dans les coordonnées. 
	  */
	 
	 public Piece getTab(int x, int y)
	 {
		 if (x < 0 || x > 7 || y < 0 || y > 7){
				System.out.println("Erreur ces coordonnées n'existe pas: ("+x+","+y);
			}
			return tab[x][y];
	}
	 
	 
	 /**
		 *Si une case est occupée.
		 *@param x Abscisse de la case
		 *@param y Ordonnee de la case
		 *@return true si elle est occupée sinon return false.
		 */
	 
		 public boolean estOccupe( int x, int y)
			{
				 boolean res = false;
				if (tab[x][y] != null);// Si notre case est occupée
				{
					res = true;
					 
				}
				return res;
			}
		 
		 public void seDeplacer( Echiquier ech, int abs, int ord, int x, int y)
		 {
			 if( ech.getTab(abs,ord) instanceof Pion)
			 {
				 if ( ech.getTab(abs,ord).getJ().equalsCouleur(new Joueur("noir"))) // Si c'est un pion du joueur noir.
				 {
					 Pion p1 = new Pion ( (Pion ) ech.getTab(abs, ord));
					 if ( p1.DeplacerPionNoir(x,y,p1)) 
					 {
					 	ech.setTab(p1.getAbscisse(),p1.getOrdonnee(),null);
						p1.setAbscisse(y);
						p1.setOrdonnee(x);
						ech.setTab(p1.getAbscisse(),p1.getOrdonnee(),p1);
						ech.setTab(p1.getAbscisse(),p1.getOrdonnee(),p1);
						ech.afficheEchiquier();
					 }
					 else
						 System.out.println("mouvement impossible NP");
				 }
				 else
				 {
					 Pion p1 = new Pion ( (Pion ) ech.getTab(abs, ord));
				 	if ( p1.DeplacerPionBlanc(x,y,p1)) 
				 	{
				 		ech.setTab(p1.getAbscisse(),p1.getOrdonnee(),null);
				 		p1.setAbscisse(y);
				 		p1.setOrdonnee(x);
				 		ech.setTab(p1.getAbscisse(),p1.getOrdonnee(),p1);
				 		ech.afficheEchiquier();
				 	}
				 	else
						System.out.println("mouvement impossible BP");
						
				 }
			
			 }
			 else
				System.out.println("Ce n'est pas un pion ");
		 }
		 
		 
		 
		 public void afficheEchiquier()
		 {
			 for ( int i = 0; i < 8; i ++ )
			 {
				 for( int j = 0; j < 8 ; j++ )
				 {
					 System.out.print(tab[i][j] + "|");
				 }
				 System.out.print("\n");
			 }
		 }
	 
}
