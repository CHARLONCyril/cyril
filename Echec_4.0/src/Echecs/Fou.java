package Echecs;

import javax.swing.ImageIcon;


public class Fou extends Piece
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
	
	public Fou( String n, Joueur j,int x, int y, ImageIcon i)
	{
		super(n,j,x,y,i);
	}
	
	public String toString()
	{
		return getNom();
	}
}
	
