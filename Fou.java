package Echec;


public class Fou extends Piece
{
	/**
	 * Le constructeur champ à champ:
	 * @param n Le nom de la pièce.
	 * @param c La couleur de cette pièce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonnée.
	 * @param p vérifie si la pièce à déjà bougé.
	 */
	
	public Fou( String n, String c,int x, int y,boolean p,int m)
	{
		super(n,c,x,y,p, m);
	}
	
	/**
	 * Constructeur par copie.
	 */
	
	public Fou ( Fou f1 )
	{
		super(f1);
	}
	
	
	/**
	 * Méthode vérifiant si le déplacement du fou est correcte.
	 */
	
	public boolean DeplacerFou( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se déplacer en dehors de l'échiquier.
			return false;
	
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
	
