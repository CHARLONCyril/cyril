package Echecs;

import javax.swing.ImageIcon;


/**
 * Defini le mouvement du roi.
 */

public class Roi extends Piece
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
	
	public Roi( String n, Joueur j,int x, int y,ImageIcon i, boolean p )
	{
		super(n,j,x,y,i);
		this.premierMouvement = p;
	}
	
	public String toString()
	{
		return getNom();
	}
}
