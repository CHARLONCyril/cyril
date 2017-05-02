package Echecs;



public class Joueur 
{

	/**
	 * La couleur du joueur.
	 */
	protected String couleur;

	/**
	 * Constructeur champ à champ:
	 * @param c La couleur.
	 */
	
	public Joueur( String c )
	{
		this.couleur = c;
	}
	
	public Joueur( Joueur j1 )
	{
		this.couleur = j1.getCouleur();
	}
	
	/**
	 * Getter de couleur.
	 * @return la couleur
	 */
	
	public String getCouleur()
	{
		return this.couleur;
	}

	/**
	 * Setter de couleur.
	 */
	
	public void setCouleur(String value)
	{
		this.couleur = value;
	}
	
	/**
	 * Méthode vérifiant si les deux joueurs ont la même couleur.
	 * @param o Un joueur
	 * @return vrai s'ils ont la même couleur.
	 */
	
	 public boolean equalsCouleur( Object o )
		{
				if( !(o instanceof Joueur ) )// On vérifie si o désigne un joueur.
					return false;
				Joueur e1 = (Joueur ) o;
				return  this.getCouleur() == e1.getCouleur();// Je compare les couleur des joueurs
				
		}
	
	
	
}

