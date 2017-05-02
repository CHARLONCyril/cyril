package Echecs;

import javax.swing.ImageIcon;


public class Fou extends Piece
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
	
	public Fou( String n, Joueur j,int x, int y, ImageIcon i)
	{
		super(n,j,x,y,i);
	}
	
	public String toString()
	{
		return getNom();
	}
}
	
