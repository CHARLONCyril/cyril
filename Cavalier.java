package Echec;


/**
 * Defini le mouvement du cavalier.
 */
public class Cavalier extends Piece
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
	
	public Cavalier( String n, String c,int x, int y,boolean p,int m)
	{
		super(n,c,x,y,p, m);
	}
	
	public Cavalier ( Cavalier c )
	{
		super (c);
	}
	
	
	public boolean DeplacerCavalier( int x, int y )
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 )
			return false;
		

		if(this.abscisse == x  && this.ordonnee == y) // On ne peut pas se déplacer sur sa case initiale.
			return false;
		
		if ( this.abscisse + 2 == x) // Si le cavalier avance de 2 lignes.
		{
			if ( this.ordonnee - 1 == y ) // Si le cavalier recule de 1 colonne.
				return true;
			
			else if ( this.ordonnee + 1 == y )// Si le cavalier avance de 1 colonne 
				return true;
			
			else
				return false;
		}
		
		if ( this.abscisse - 2 == x) // Si le cavalier recule de 2 lignes 
		{
			if ( this.ordonnee - 1 == y )// Si le cavalier recule de 1 colonne.
				return true;
			
			else if ( this.ordonnee + 1 == y ) // Si le cavalier avance de 1 colonne. 
				return true;
			
			else
				return false;
		}
		
		if ( this.ordonnee + 2 == y) // Si le cavalier avance de 2  colonnes 
		{
			if ( this.abscisse - 1 == x ) // Si le cavalier recule de 1  ligne 
				return true;
			
			else if ( this.abscisse + 1 == x ) // Si le cavalier avance de 1 ligne 
				return true;
			
			else
				return false;
		}
		
		if ( this.ordonnee - 2 == y) // Si le cavalier recule de 2 colonnes. 
		{
			if ( this.abscisse - 1 == x ) // Si le cavalier recule de 1 ligne 
				return true;
			
			else if ( this.abscisse + 1 == x ) // Si le cavalier avance de 1 ligne 
				return true;
			
			else
				return false;
		}
		
		return false;
	}
}
	
