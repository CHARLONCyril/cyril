package Echec;

/**
 * Defini le mouvement du roi.
 */

public class Roi extends Piece
{

	/**
	 * Le constructeur champ � champ:
	 * @param n Le nom de la pi�ce.
	 * @param c La couleur de cette pi�ce.
	 * @param x Sa position en abscisse.
	 * @param y Sa position en ordonn�e.
	 * @param p v�rifie si la pi�ce � d�j� boug�.
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
	 * M�thode v�rifiant si le d�placement du roi est correcte.
	 */
	
	public boolean DeplacerRoi( int x, int y, Echiquier ech )
	{
		
		if( x > 8 || y > 8 || x < 0 || y < 0 ) // On ne peut pas se d�placer en dehors de l'�chiquier.
			return false;
		
		if(this.abscisse == x && this.ordonnee == y ) 
			return false;
		
		if(this.abscisse + 1 == x || this.abscisse - 1 == x )//Soit le roi avance de 1 ligne ou recule de 1 ligne.
		{
			if(this.ordonnee - 1 == y || this.ordonnee + 1 == y || this.ordonnee == y) //Soit le roi recule d'une colonne, reste sur la m�me colonne ou avance d'une colonne.
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
	
		
		
		if(this.abscisse == x )// Le roi reste sur la m�me ligne
		{
			if(this.ordonnee + 1 == y || this.ordonnee -1 == y ) // Le roi se d�place de une colonne vers la gauche ou une colonne vers la droite.
				return true;
			else
				return false;
		}
		
		
		return false; // Le mouvement du roi n'est pas correcte.
	}
}
