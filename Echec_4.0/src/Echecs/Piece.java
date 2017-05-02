package Echecs;

import javax.swing.ImageIcon;
	
public abstract class Piece {
		

		/**
		 * Le nom de la pièce.
		 */
		
		protected String nom;
		
		/**
		 * Référence au joueur.
		 */
		
		protected Joueur j;
		
		/**
		 * L'image de la pièce.
		 */
		
		protected int abscisse;
		
		/**
		 * Position en ordonnée.
		 */
		protected int ordonnee;
		
		/**
		 * L'image de la pièce.
		 */
		
		protected ImageIcon img;
		
		
		 public Piece(String n, Joueur j1, int x, int y, ImageIcon i )
		 {
			this.nom = n;
			this.j = j1;
			this.abscisse = x;
			this.ordonnee = y;
			this.img = i;
		}
		 
		 public Piece ( Piece p1 ) 
		 {
			 this.nom = new String(p1.getNom());
			 this.j = new Joueur ( p1.getJ());
			 this.abscisse = p1.getAbscisse();
			 this.ordonnee = p1.getOrdonnee();
			 this.img = p1.getImg();
		 }
		 
		 /**
			 * Getter de nom.
			 * @return nom.
			 */
			 
			public String getNom()
			{
				return this.nom;
			}
			
			/**
			 * Getter de j.
			 * @return j.
			 */
			
			 public Joueur getJ()
			{
					return this.j;
			}
			
			 
			 /**
				* Getter de abscisse.
				* @return abscisse.
				*/
				
				public int getAbscisse()
				{
					return this.abscisse;
				}
				
				/**
				* Getter de ordonnée.
				* @return ordonnée.
				*/
				
				public int getOrdonnee()
				{
					return this.ordonnee;
				}
				
				
				/**
				* Getter de img.
				* @return img.
				*/
				 
				public ImageIcon getImg()
				{ 
					return this.img;
				}
				
				/**
				* Setter de nom.
				*/
				
				public void setNom(String value) 
				{
					this.nom = value;
				}
				
				/**
				* Setter de j.
				*/
				
				public void setJ( Joueur j1 )
				{
					this.j = j1;
				}
				


				/**
				* Setter de abscisse.
				*/
				
				public void setAbscisse( int x)
				{
					 this.abscisse = x;
				}
				
				/**
				* Setter de ordonnée.
				*/
				
				public void setOrdonnee( int y )
				{
					 this.ordonnee = y;
				}
				
				/**
				* Setter de img.
				*/
				
				public void setImg( ImageIcon i )
				{
					this.img = i;
				}
				
				
}
