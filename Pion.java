package Echec;





/**
 * Defini le mouvement du pion.
 */

public class Pion extends Piece
{
	/**
     * V�rifie si la pi�ce � d�j� boug�.
     */
	
	private boolean premierMouvement;

	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param j Le joueur qui poss�de cette pi�ce.
	 * @param i	L'image de la pi�ce.
	 * @param t1 Les diff�rentes coordonn�es possible de la pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param e1 Fait r�f�rence � l'�chiquier.
	 * @param p v�rifie si la pi�ce � d�j� boug�.
	 */
	
	public Pion( String n, String c,int x, int y, boolean p )
	{
		super(n,c,x,y);
		this.premierMouvement = p;
	}
	
	public Pion ( Pion p1 )
	{
		super(p1);
		this.premierMouvement = p1.getPremierMouvement();
	}
	
	public boolean getPremierMouvement()
	{
		return this.premierMouvement;
	}
	
	/**
	 * Setter de premierMouvement.
	 */
	public void setPremierMouvement( boolean p1 )
	{
		this.premierMouvement = p1;
	}
	
	public boolean DeplacerPionBlanc( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 )
			return false;
		
		if ( this.getAbscisse() == x && this.getOrdonnee() == y )// On ne peut pas se d�placer sur sa case d'origine;
			return false;
		
		if ( premierMouvement )
		{
			if( this.getAbscisse() - 2 == x && this.getOrdonnee() == y )//je me d�place de 2 lignes.
			{
				setPremierMouvement(false);
				return true;
			}
			
			if( this.getAbscisse() - 1 == x && this.getOrdonnee() == y )// je me d�place de 1 lignes.
			{
				setPremierMouvement(false);
				return true;
			}
			
			if (this.getAbscisse() - 1 == x && this.getOrdonnee() +1 == y ) // je mange vers la droite.
			{
				setPremierMouvement(false);
				return true;
			}
			
			if (this.getAbscisse() - 1 == x && this.getOrdonnee() - 1 == y ) // je manger vers la gauche.
			{
				setPremierMouvement(false);
				return true;
			}
		}
		else
		{
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
		}
		return false;
	}

	
	public boolean DeplacerPionNoir( int x, int y)
	{
		if( x > 8 || y > 8 || x < 0 || y < 0 )
			return false;
		if ( this.getAbscisse() == x && this.getOrdonnee() == y )// On ne peut pas se d�placer sur sa case d'origine;
			return false;
		
		if ( premierMouvement )
		{
			if( this.getAbscisse() + 2 == x && this.getOrdonnee() == y )//je me d�place de 2 lignes.
			{
				setPremierMouvement(false);
				return true;
			}
			
			if( this.getAbscisse() + 1 == x && this.getOrdonnee() == y )// je me d�place de 1 lignes.
			{
				setPremierMouvement(false);
				return true;
			}
			
			if (this.getAbscisse() + 1 == x && this.getOrdonnee() +1 == y ) // je mange vers la droite.
			{
				setPremierMouvement(false);
				return true;
			}
			
			if (this.getAbscisse() + 1 == x && this.getOrdonnee() - 1 == y ) // je manger vers la gauche.
			{
				setPremierMouvement(false);
				return true;
			}
		}
		else
		{
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
		}
		
		return false;
	}
	
}
	