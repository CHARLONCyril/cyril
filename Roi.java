package Echec;

/**
 * Defini le mouvement du roi.
 */

public class Roi extends Piece
{

	/**
	 * Le constructeur champ à champ:
	 * @param n Le nom de la pièce.
	 * @param c La couleur de cette pièce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonnée.
	 * @param p vérifie si la pièce à déjà bougé.
	 */
	
	public Roi( String n, String c,int x, int y,boolean p,int m)
	{
		super(n,c,x,y,p, m);
	}
	
	/**
	 * Constructeur par copie.
	 */
	
	public Roi( Roi r)
	{
		super ( r );
	}
	
	
	/**
	 * Méthode vérifiant si le déplacement du roi est correcte.
	 */
	
	public boolean DeplacerRoi( int x, int y, Echiquier ech )
	{
		
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se déplacer en dehors de l'échiquier.
			return false;
		
		if(this.abscisse == x && this.ordonnee == y ) 
			return false;
		
		if(this.abscisse + 1 == x || this.abscisse - 1 == x )//Soit le roi avance de 1 ligne ou recule de 1 ligne.
		{
			if(this.ordonnee - 1 == y || this.ordonnee + 1 == y || this.ordonnee == y) //Soit le roi recule d'une colonne, reste sur la même colonne ou avance d'une colonne.
				return true;
			else
				return false;
		}
		
		if(this.abscisse == 7 && this.ordonnee == 4 && x == 7 && y ==7 && !(ech.estOccupee(7, 5)) &&!(ech.estOccupee(7, 5))) // pour le petit roque blanc
			 return true;
		
		if(this.abscisse == 0 && this.ordonnee == 4 && x == 0 && y == 7 /*&& !(ech.estOccupee(0,5)) && !(ech.estOccupee(0,6))*/) // pour le petit roque noir
			return true;
		
		if(this.abscisse == 7 && this.ordonnee == 4 && x == 7 && y == 0 && !(ech.estOccupee(7,1)) && !(ech.estOccupee(7,2)) && !(ech.estOccupee(7,3))) // pour le grand roque blanc  
			return true;
		
		if(this.abscisse == 0 && this.ordonnee == 4 && x == 0 && y == 0 /*&& !(ech.estOccupee(0,1)) && !(ech.estOccupee(0,2)) && !(ech.estOccupee(0,3))*/) // pour le grand roque noir
			 return true;
	
		
		
		if(this.abscisse == x )// Le roi reste sur la même ligne
		{
			if(this.ordonnee + 1 == y || this.ordonnee -1 == y ) // Le roi se déplace de une colonne vers la gauche ou une colonne vers la droite.
				return true;
			else
				return false;
		}
		
		
		return false; // Le mouvement du roi n'est pas correcte.
	}
}
