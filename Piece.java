package Echec;

/**
 * Classe mere des differentes pieces
 */

public abstract class Piece {
	

	/**
	 * Le nom de la pi�ce.
	 */
	
	protected String nom;
	
	/**
	 * la couleur de la pi�ce
	 */
	
	protected String c;
	
	/**
	 * Position en abscisse.
	 */
	
	protected int abscisse;
	
	/**
	 * Position en ordonn�e.
	 */
	protected int ordonnee;
	
	
	/**
     * V�rifie si la pi�ce � d�j� boug�.
     */
	
	protected boolean premierMouvement;
	
	
	private int mvt;
	
	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param c La couleur de cette pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param p v�rifie si la pi�ce � d�j� boug�.
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
		 * @return le nom de la pi�ce.
		 */
		 
		public String getNom()
		{
			return this.nom;
		}
		
		/**
		 * Getter de C.
		 * @return la couleur de la pi�ce.
		 */
		
		 public String getC()
		 {
				return this.c;
		 }
		
		 
		 /**
			* Getter de abscisse.
			* @return l'abscisse de la pi�ce.
			*/
			
			public int getAbscisse()
			{
				return this.abscisse;
			}
			
			/**
			* Getter de ordonn�e.
			* @return l'ordonn�e de la pi�ce.
			*/
			
			public int getOrdonnee()
			{
				return this.ordonnee;
			}
			
			/**
			 * Getter de premierMouvement.
			 * @return true si c'est le premier mouvement de la pi�ce et false sinon.
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
			* Setter de ordonn�e.
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
			 * M�thode permettant de comparer les couleurs de 2 pi�ces.
			 * @return vrai si elle ont la m�me couleur et faux sinon.
			 */
			
			 public boolean equalsCouleur( Object o )
			{
						if( !(o instanceof Piece ) )// On v�rifie si o d�signe une Piece.*
						{
							return false;
						}
						
						Piece e1 = (Piece ) o; // On caste o en Piece.
						
						return  this.getC().equals(e1.getC());// Je compare la couleur de la piece courante avec celle pass�e en param�tre.
						
			}

			public int getMvt() {
				return mvt;
			}

			public void setMvt(int mvt) {
				this.mvt = mvt;
			}	

}
