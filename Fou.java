package Echec;


public class Fou extends Piece
{
	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param c La couleur de cette pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param p v�rifie si la pi�ce � d�j� boug�.
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
	 * M�thode v�rifiant si le d�placement du fou est correcte.
	 */
	
	public boolean DeplacerFou( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se d�placer en dehors de l'�chiquier.
			return false;
	
		boolean res = false;
		int cpt = 0;
		while ( cpt < 8 && res != true)
		{
			if( this.abscisse + cpt == x && this.ordonnee + cpt == y ) // Mouvement du bas vers le haut � droite
				res = true;
			
			if( this.abscisse - cpt == x && this.ordonnee - cpt == y ) // Mouvement du haut vers le bas � gauche
				res = true;
			
			if(this.abscisse + cpt == x && this.ordonnee - cpt == y ) // Mouvement du bas vers le haut � gauche
				res = true;
			
			if(this.abscisse - cpt == x && this.ordonnee + cpt == y ) // Mouvement du haut vers le bas � droite
				res = true;
			cpt ++;
		}
		
		return res;
	}
	
}
	
