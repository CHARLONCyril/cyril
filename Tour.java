package Echec;

/**
 * Defini le mouvement de la Tour
 */

public class Tour extends Piece 
{
	
	/**
	 * Le constructeur champ à champ:
	 * @param n Le nom de la pièce.
	 * @param c La couleur de cette pièce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonnée.
	 * @param p vérifie si la pièce à déjà bougé.
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
	 * Méthode vérifiant si le déplacement de la tour est correcte.
	 */
	
	public boolean DeplacerTour( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se déplacer en dehors de l'échiquier.
			return false;
		
		if(this.abscisse == x  && this.ordonnee == y) // On ne peut pas se déplacer sur sa case initiale.
			return false;
		
		if(this.abscisse == x  ||  this.ordonnee == y) // Soit la tour fait un mouvement horizontale donc sa ligne est la même mais sa colonne change soit 
													  // elle fait un mouvement verticale et c'est le contraire.
			return true;	
		
		
		return false; // Le mouvement de la tour n'est pas correcte.
		
	}
}