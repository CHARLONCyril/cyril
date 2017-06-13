package Echec;

/**
 * Defini le mouvement de la Tour
 */

public class Tour extends Piece 
{
	
	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param c La couleur de cette pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param p v�rifie si la pi�ce � d�j� boug�.
	 */
	
	public Tour( String n, String c,int x, int y,boolean p,int m)
	{
		super(n,c,x,y,p, m);
	}
	
	/**
	 * Constructeur par copie.
	 */
	
	public Tour ( Tour t1 )
	{
		super(t1);
	}
	
	
	/**
	 * M�thode v�rifiant si le d�placement de la tour est correcte.
	 */
	
	public boolean DeplacerTour( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se d�placer en dehors de l'�chiquier.
			return false;
		
		if(this.abscisse == x  && this.ordonnee == y) // On ne peut pas se d�placer sur sa case initiale.
			return false;
		
		if(this.abscisse == x  ||  this.ordonnee == y) // Soit la tour fait un mouvement horizontale donc sa ligne est la m�me mais sa colonne change soit 
													  // elle fait un mouvement verticale et c'est le contraire.
			return true;	
		
		
		return false; // Le mouvement de la tour n'est pas correcte.
		
	}
}