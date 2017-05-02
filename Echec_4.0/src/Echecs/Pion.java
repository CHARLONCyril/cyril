package Echecs;
import javax.swing.ImageIcon;



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
	
	public Pion( String n, Joueur j,int x, int y, ImageIcon i, boolean p )
	{
		super(n,j,x,y,i);
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
	
	public boolean DeplacerPionNoir( int x, int y, Pion p1)
	{
		boolean res = false;
		if ( getPremierMouvement() )
		{
			if( p1.getAbscisse() == x &&  y < 4 )
			{
				res = true;
				setPremierMouvement(false);		
			}
		}
		else
			if( p1.getAbscisse() == x &&  y <=7 )
			{
				res = true;
			}
		
		return res;
	}
	
	public boolean DeplacerPionBlanc( int x, int y, Pion p1)
	{
		boolean res = false;
		if ( getPremierMouvement() )
		{
			if( p1.getAbscisse() == x &&  y >3 )
			{
				res = true;
				setPremierMouvement(false);		
			}
		}
		else
			if( p1.getAbscisse() == x &&  y >=0 )
			{
				res = true;
			}
		
		return res;
	}
	
	
	
	public String toString()
	{
		return getNom();
	}
}
	
