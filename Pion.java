package Echec;

/**
 * Defini le mouvement du pion.
 */

public class Pion extends Piece
{
	

	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param c La couleur de cette pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param p v�rifie si la pi�ce � d�j� boug�.
	 */
	
	
	
	public Pion( String n, String c,int x, int y, boolean p,int m )
	{
		super(n,c,x,y,p,m);
	}
	
	/**
	 * Constructeur par copie.
	 */
	
	public Pion ( Pion p1 )
	{
		super(p1);
	}
	
	/**
	 * M�thode v�rifiant si le d�placement du pion blanc est correcte.
	 */
	
	public boolean DeplacerPionBlanc( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se d�placer en dehors de l'�chiquier.
			return false;
		
		if ( this.getAbscisse() == x && this.getOrdonnee() == y ) // On ne peut pas se d�placer sur sa case d'origine;
			return false;
		
		if( this.getAbscisse() - 2 == x && this.getOrdonnee() == y ) //je me d�place de 2 lignes.
		{
			return true;
		}
			
		if( this.getAbscisse() - 1 == x && this.getOrdonnee() == y )// je me d�place de 1 lignes.
		{
			return true;
		}
			
		if (this.getAbscisse() - 1 == x && this.getOrdonnee() +1 == y ) // je mange vers la droite.
		{
			return true;
		}
			
		if (this.getAbscisse() - 1 == x && this.getOrdonnee() - 1 == y ) // je manger vers la gauche.
		{
			return true;
		}
			
		return false; // Le mouvement du pion blanc n'est pas correcte.
	}

	/**
	 * M�thode v�rifiant si le d�placement du pion blanc est correcte.
	 */
	
	public boolean DeplacerPionNoir( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se d�placer en dehors de l'�chiquier.
			return false;
		
		if ( this.getAbscisse() == x && this.getOrdonnee() == y )// On ne peut pas se d�placer sur sa case d'origine;
			return false;
		
		if( this.getAbscisse() + 2 == x && this.getOrdonnee() == y )//je me d�place de 2 lignes.
		{
			return true;
		}
			
		if( this.getAbscisse() + 1 == x && this.getOrdonnee() == y )// je me d�place de 1 lignes.
		{
			return true;
		}
			
		if (this.getAbscisse() + 1 == x && this.getOrdonnee() +1 == y ) // je mange vers la droite.
		{
			return true;
		}
			
		if (this.getAbscisse() + 1 == x && this.getOrdonnee() - 1 == y ) // je manger vers la gauche.
		{
			return true;
		}
		
		return false; // Le mouvement du pion noir n'est pas correcte.
	}


}
	