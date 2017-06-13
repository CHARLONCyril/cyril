package Echec;

/**
 * Classe mere des differentes pieces
 */

public abstract class Piece {
	

	/**
	 * Le nom de la pièce.
	 */
	
	protected String nom;
	
	/**
	 * la couleur de la pièce
	 */
	
	protected String c;
	
	/**
	 * Position en abscisse.
	 */
	
	protected int abscisse;
	
	/**
	 * Position en ordonnée.
	 */
	protected int ordonnee;
	
	
	/**
     * Vérifie si la pièce à déjà bougé.
     */
	
	protected boolean premierMouvement;
	
	
	private int mvt;
	
	/**
	 * Le constructeur champ à champ:
	 * @param n Le nom de la pièce.
	 * @param c La couleur de cette pièce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonnée.
	 * @param p vérifie si la pièce à déjà bougé.
	 */
	
	 public Piece(String n, String c1, int x, int y,boolean p,int m)
	 {
		this.nom = n;
		this.c = c1;
		this.abscisse = x;
		this.ordonnee = y;
		this.premierMouvement = p;
		this.mvt = m;
	}
	 
	 /**
	  * Constructeur par copie.
	  */
	 public Piece ( Piece p1 ) 
	 {
		 this.nom = new String(p1.getNom());
		 this.c = new String (p1.getC());
		 this.abscisse = p1.getAbscisse();
		 this.ordonnee = p1.getOrdonnee();
		 this.premierMouvement = p1.getPremierMouvement();
		 this.mvt = p1.getMvt();
	 }
	 
	 /**
		 * Getter de nom.
		 * @return le nom de la pièce.
		 */
		 
		public String getNom()
		{
			return this.nom;
		}
		
		/**
		 * Getter de C.
		 * @return la couleur de la pièce.
		 */
		
		 public String getC()
		 {
				return this.c;
		 }
		
		 
		 /**
			* Getter de abscisse.
			* @return l'abscisse de la pièce.
			*/
			
			public int getAbscisse()
			{
				return this.abscisse;
			}
			
			/**
			* Getter de ordonnée.
			* @return l'ordonnée de la pièce.
			*/
			
			public int getOrdonnee()
			{
				return this.ordonnee;
			}
			
			/**
			 * Getter de premierMouvement.
			 * @return true si c'est le premier mouvement de la pièce et false sinon.
			 */

			public boolean getPremierMouvement()
			{
				return this.premierMouvement;
			}
			
			
			/**
			* Setter de nom.
			*/
			
			public void setNom(String value) 
			{
				this.nom = value;
			}
			
			/**
			* Setter de c.
			*/
			
			public void setC( String c1 )
			{
				this.c = c1;
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
			 * Setter de premierMouvement.
			 */
			
			public void setPremierMouvement( boolean p1 )
			{
				this.premierMouvement = p1;
			}
			
			
			/**
			 * 
			 * Méthode permettant de comparer les couleurs de 2 pièces.
			 * @return vrai si elle ont la même couleur et faux sinon.
			 */
			
			 public boolean equalsCouleur( Object o )
			{
						if( !(o instanceof Piece ) )// On vérifie si o désigne une Piece.*
						{
							return false;
						}
						
						Piece e1 = (Piece ) o; // On caste o en Piece.
						
						return  this.getC().equals(e1.getC());// Je compare la couleur de la piece courante avec celle passée en paramètre.
						
			}

			public int getMvt() {
				return mvt;
			}

			public void setMvt(int mvt) {
				this.mvt = mvt;
			}	

}
