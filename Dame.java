package Echec;



/**
 * Defini le mouvement de la dame.
 */
public class Dame extends Piece
{
	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param j Le joueur qui poss�de cette pi�ce.
	 * @param i	L'image de la pi�ce.
	 * @param t1 Les diff�rentes coordonn�es possible de la pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param e1 Fait r�f�rence � l'�chiquier.
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
		
		if(this.abscisse == x  && this.ordonnee == y) // On ne peut pas se d�placer sur sa case initiale.
			return false;
		
		// Mouvement similaire � la tour.
		if(this.abscisse == x  ||  this.ordonnee == y) // Soit la tour fait un mouvement horizontale donc sa ligne est la m�me mais sa colonne change soit 
			return true;							   // elle fait un mouvement verticale et c'est le contraire.
		
		// Mouvement similaire au fou.
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
