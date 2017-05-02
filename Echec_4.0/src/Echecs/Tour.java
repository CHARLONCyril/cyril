package Echecs;

import javax.swing.ImageIcon;



/**
 * Defini le mouvement de la Tour
 */
public class Tour extends Piece 
{
	
	/**
     * Vérifie si la pièce à déjà bougé.
     */
	
	private boolean premierMouvement;
	
	/**
	 * Le constructeur champ à champ:
	 * @param n Le nom de la pièce.
	 * @param j Le joueur qui possède cette pièce.
	 * @param i	L'image de la pièce.
	 * @param t1 Les différentes coordonnées possible de la pièce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonnée.
	 * @param e1 Fait référence à l'échiquier.
	 * @param p vérifie si la pièce à déjà bougé.
	 */
	
	public Tour( String n, Joueur j,int x, int y,ImageIcon i, boolean p1 )
	{
		super(n,j,x,y,i);
		this.premierMouvement = p1;
	}
	
	public String toString()
	{
		return getNom();
	}
}
