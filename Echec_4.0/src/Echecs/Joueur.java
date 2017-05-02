package Echecs;



public class Joueur 
{

	/**
	 * La couleur du joueur.
	 */
	protected String couleur;

	/**
	 * Constructeur champ � champ:
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
	 * M�thode v�rifiant si les deux joueurs ont la m�me couleur.
	 * @param o Un joueur
	 * @return vrai s'ils ont la m�me couleur.
	 */
	
	 public boolean equalsCouleur( Object o )
		{
				if( !(o instanceof Joueur ) )// On v�rifie si o d�signe un joueur.
					return false;
				Joueur e1 = (Joueur ) o;
				return  this.getCouleur() == e1.getCouleur();// Je compare les couleur des joueurs
				
		}
	
	
	
}

