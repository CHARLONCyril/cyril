package Echec;



/**
 * Defini le mouvement de la dame.
 */
public class Dame extends Piece
{
	/**
	 * Le constructeur champ à champ:
	 * @param n Le nom de la pièce.
	 * @param j Le joueur qui possède cette pièce.
	 * @param i	L'image de la pièce.
	 * @param t1 Les différentes coordonnées possible de la pièce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonnée.
	 * @param e1 Fait référence à l'échiquier.
	 */
	
	public Dame( String n, String c,int x, int y,boolean p,int m)
	{
		super(n,c,x,y,p,m);
	}
	
	public Dame ( Dame d1 )
	{
		super( d1 );
	}
	
	
	public boolean DeplacerDame( int x, int y )
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 )
			return false;
		
		if(this.abscisse == x  && this.ordonnee == y) // On ne peut pas se déplacer sur sa case initiale.
			return false;
		
		// Mouvement similaire à la tour.
		if(this.abscisse == x  ||  this.ordonnee == y) // Soit la tour fait un mouvement horizontale donc sa ligne est la même mais sa colonne change soit 
			return true;							   // elle fait un mouvement verticale et c'est le contraire.
		
		// Mouvement similaire au fou.
		boolean res = false;
		int cpt = 0;
		while ( cpt < 8 && res != true)
		{
			if( this.abscisse + cpt == x && this.ordonnee + cpt == y ) // Mouvement du bas vers le haut à droite
				res = true;
			
			if( this.abscisse - cpt == x && this.ordonnee - cpt == y ) // Mouvement du haut vers le bas à gauche
				res = true;
			
			if(this.abscisse + cpt == x && this.ordonnee - cpt == y ) // Mouvement du bas vers le haut à gauche
				res = true;
			
			if(this.abscisse - cpt == x && this.ordonnee + cpt == y ) // Mouvement du haut vers le bas à droite
				res = true;
			cpt ++;
		}
	
		return res;
		
	}

}
