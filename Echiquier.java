package Echec;
import javax.swing.ImageIcon;

public class Echiquier
{
	private Piece [][] tab;
		
	
	public  Echiquier ()
	{
		tab = new Piece [8][8];
	
	}
		
		public void initEchiquier()
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					tab[i][j]=null;
				}
			}
			setTab((new Tour("NT","noir",0,0,true)));
			setTab((new Cavalier("NC","noir",0,1)));
			setTab((new Fou("NF","noir",0,2)));
		    setTab((new Dame("ND","noir",0,3)));
		    setTab((new Roi("NR","noir",0,4,true)));
		    setTab((new Fou("NF","noir",0,5)));
		    setTab((new Cavalier("NC","noir",0,6)));
			setTab((new Tour("NT","noir",0,7,true)));
		    for(int i = 0; i <= 7; i++)
		    {
				setTab( new Pion("NP","noir",1, i,true));
				setTab( new Pion("BP","blanc",6, i,true));
			}
				
			setTab((new Tour("BT","blanc",7,0,true)));
			setTab(( new Cavalier("BC","blanc",7,1)));
		    setTab(( new Fou("BF","blanc",7,2)));
		    setTab((new Dame("BD","blanc",7,3)));
	        setTab(( new Roi("BR","blanc",7,4,true)));
		    setTab(( new Fou("BF","blanc",7,5)));
			setTab(( new Cavalier("BC","blanc",7,6)));
			setTab(( new Tour("BT","blanc",7,7,true)));
		}
		
	

	/**
	  * Cette méthode retourne si elle existe la piece d'une des Tab du tableau.
	  * @param x L'abscisse de la Tab
	  * @param y L'ordonnée de la Tab
	  * @return soit la pièce contenue dans cette Tab soit null car il y a eut une erreur dans les coordonnées. 
	  */
	 
		public Piece getTab(int x, int y) {
			return this.tab[x][y];
		}
	 
	 /**
	  * Méthode insérant une pièce dans une case de  Tab.
	  * @param x L'abscisse de la Tab
	  * @param y L'ordonnée de la Tab
	  * @param a La pièce à insérer dans  Tab.
	  */
				public void setTab(Piece p) {
					this.tab[p.getAbscisse()][p.getOrdonnee()]=p;
				}
	 /**
		 *Si une case du tableau est occupée.
		 *@param x Abscisse de la case
		 *@param y Ordonnee de la case
		 *@return true si elle est occupée sinon return false.
		 */
		 
		 public boolean estOccupee ( int x, int y)
		 {
			 if (this.tab[x][y]==null) 
				 return false;
			 
			return true;
		 }
		 
		 
		 public boolean DeplacementEstValide(Piece p1, int x, int y)
		 {
			 if( p1 instanceof Pion )
			 {
				 Pion p = new Pion ((Pion)p1);// On caste la Pièce en Pion
				 if( p.getC() == "noir") // Si c'est un Pion Noir
				 {
					 if ( p.DeplacerPionNoir(x,y)) // Si les coordonnées saisie par le joueur sont valides.
					 {
						 if(estOccupee(x, y) && p.getC()==(getTab(x,y)).getC()) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces.
							 return false;
						 
						 if(y == p.getOrdonnee() && x == p.getAbscisse()+1 && estOccupee(x,y)) // On ne peut pas se deplacer sur case qui contient deja une pièce 
							 return false;													   // Le pion peut manger uniquement en diagonale. 
		
						if(x == p.getAbscisse()+1 && y == p.getOrdonnee()-1) // Si je veut manger vers la gauche
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma gauche.
									return false;
						}
						
						if( x == p.getAbscisse()+1 && y == p.getOrdonnee()+1) // Si je veut manger vers la droite
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma droite.
									return false;
						}
						
						if( x == p.getAbscisse()+2 && y == p.getOrdonnee() && !p.getPremierMouvement() ) // Je peut uniquement avancer de 2 lignes 
							return false;																// lors de mon premier Déplacement.
						
						if( x == p.getAbscisse()+2 && y == p.getOrdonnee() && estOccupee(x,y))  // Je ne peut pas avancer de 2 lignes si cette dernière 
							return false;														// est déja occupée par une autre pièce.
						
						if( x == p.getAbscisse()+2 && y == p.getOrdonnee() && estOccupee(x-1,y)) // Mon pion ne peut pas enjamber d'autre pièce.
							return false;
						
						return true; // Le déplacement du pion est correcte.
					 }
					 else
						 return false; // Le déplacement n'est pas valide.
				 }
				 else // C'est un pion blanc
				 {
					 if ( p.DeplacerPionBlanc(x,y)) // Si les coordonnées saisie par le joueur sont valides.
					 {
						 if(estOccupee(x, y) && p.getC()==(getTab(x,y)).getC()) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces.
							 return false;
						 
						 if(y == p.getOrdonnee() && x == p.getAbscisse()- 1 && estOccupee(x,y)) // On ne peut pas se deplacer sur case qui contient deja une pièce 
							 return false;													   // Le pion peut manger uniquement en diagonale. 
		
						if(x == p.getAbscisse()-1 && y == p.getOrdonnee()-1) // Si je veut manger vers la gauche
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma gauche.
									return false;
						}
						
						if( x == p.getAbscisse()-1 && y == p.getOrdonnee()+1) // Si je veut manger vers la droite
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma droite.
									return false;
						}
						
						if( x == p.getAbscisse()-2 && y == p.getOrdonnee() && !p.getPremierMouvement() ) // Je peut uniquement avancer de 2 lignes 
							return false;																// lors de mon premier Déplacement.
						
						if( x == p.getAbscisse()-2 && y == p.getOrdonnee() && estOccupee(x,y))  // Je ne peut pas avancer de 2 lignes si cette dernière 
							return false;														// est déja occupée par une autre pièce.
						
						if( x == p.getAbscisse()-2 && y == p.getOrdonnee() && estOccupee(x+1,y)) // Mon pion ne peut pas enjamber d'autre pièce.
							return false;
						
						return true; // Le déplacement du pion est correcte.
					 }
					 else
						 return false; // Le déplacement n'est pas valide.
				 }
				 
			 }
		 } 
		 
		 
		 
		 public  void enlevePiece(Piece p) 
		 {
			if (this.tab[p.getAbscisse()][p.getOrdonnee()]!=null)
			{
				this.tab[p.getAbscisse()][p.getOrdonnee()]= null;
			}
		 }		
		 
		

		 
}
