package Echec;

import java.util.ArrayList;
import java.util.Scanner; // permet de saisir au clavier

public class Jouer 
{
	/**
	 * Le nombre de tour.
	 */
	
	private int tour;
	
	/**
	 * permet de savoir si c'est au blanc de jouer.
	 */
	
	private boolean tourBlanc;
	
	/**
	 * permet d'avoir la couleur du joueur.
	 */
	
	private String j;
	
	/**
	 * Constructeur par défaut.
	 */
	public Jouer()
	{
		this.tour = 0;
		this.tourBlanc = true;
		this.j = "blanc";
	}
	
	public Jouer( String c)
	{
		this.tour = 0;
		this.tourBlanc = true;
		this.j = c;
	}
	
	/**
	 * Getter de tour
	 * @return le nombre de tour.
	 */
	
	public int getTour()
	{
		return this.tour;
	}
	
	/**
	 * Setter de tour
	 */
	
	public void setTour( int t)
	{
		this.tour = t;
	}
	
	/**
	 * Getter de tourBlanc.
	 * @return true si c'est au blanc de jouer et false sinon..
	 */
	
	public boolean getTourBlanc() 
	{
		return tourBlanc;
	}

	/**
	 * Setter de tourBlanc.
	 */
	
	public void setTourBlanc(boolean tourBlanc) 
	{
		this.tourBlanc = tourBlanc;
	}
	
	/**
	 * Getter de j
	 * @return la couleur du joueur.
	 */
	
	public String getJ() 
	{
		return j;
	}

	/**
	 * Setter de j
	 */
	
	public void setJ(String j) 
	{
		this.j = j;
	}
	
	/**
	 * méthode permettant de démarrer une partie.
	 */
	public void demarrerPartie () {
		int cpt = 1;
		int t = 0;
		boolean winner = false;
		Echiquier e= new Echiquier(); // Création d'un objet Echiquier.
		FenetrePrincipale i=new FenetrePrincipale();// Création d'un objet FenetrePrincipale.
		e.initEchiquier(); // Méthode permettant d'initialiser l'objet Echiquier créé précédement.
		i.remplirLettre(); // Méthode permettant de remplir le jLabel lettre.
		i.remplirChiffre(); // Méthode permettant de remplir le jLabel chiffre
		
		do{
			System.out.println("Tour n° : "+getTour());
			i.afficherEch(); // Méthode permettant d'afficher l'échiquier sur la fenêtre. 
			i.positionnerCases(); // Méthode permettant de positonner les cases.
			i.afficherPieces(e); // Méthode permettant d'afficher les pièces..
			i.revalidate();// Méthode permettant de mettre à jour la fenêtre.
			
			if(tour%2==0 && t != 1) 
			{
					this.jouerModeClavier(this,e);
					setJ("noir");
			}
			
			else if (tour%2!=0 && t != 1) 
			{
					this.jouerModeClavier(this,e);
					setJ("blanc");
			}
			
			setTour(cpt);
			cpt++;
			
			if (e.getWinner().equals("noir") || (e.getWinner().equals("blanc") || e.getWinner().equals("null")))
			{
				winner = true;
				t ++;
			}
		}while((winner != true || t !=2));
		
		
		if ( e.getWinner().equals("noir"))
			
			System.out.println("Le joueur noir remporte la partie.");
		
		else if (e.getWinner().equals("blanc"))
			
			System.out.println("Le joueur blanc remporte la partie.");
		
		else
			
			System.out.println("Vous êtes pat.");
	}
	
	public void jouerModeClavier(Jouer c, Echiquier ech)
	{
		int abs = 0;
		int ord = 0;
		int x = 0;
		int y = 0;		
		String str= "";
		String c1 ="";
		char inter = '\0';
		String joueur = "";
		boolean maPiece;
		boolean mouvementValide;
		do
		{
			maPiece = true;
			mouvementValide = true;
			Scanner sc=new Scanner(System.in);
			System.out.println("joueur "+c.getJ());
			System.out.println("Veuillez saisir les coordonnées de votre pièce ");
			str = sc.nextLine();
			try
			{
				if ( str.charAt(1) == 'a'|| str.charAt(1) == 'b'|| str.charAt(1) == 'c'|| str.charAt(1) == 'd'|| str.charAt(1) == 'e'|| str.charAt(1) == 'f'|| str.charAt(1) == 'g'|| str.charAt(1) == 'h')
				{
					abs = (int) str.charAt(0) -48;
					inter = Character.toUpperCase(str.charAt(1));
					ord = (int) inter -65;
				
				}
				else
				{
					abs = (int) str.charAt(0) -48;
					ord = (int) str.charAt(1) -65;
				}
			}
			catch( ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e)
			{
				System.out.println("Les coordonées saisie sont invalides");
			}
			
			System.out.println("Veuillez saisir les coordonnées d'arrivée de votre pièce ");
			
			c1 = sc.nextLine();
			try
			{
				if ( c1.charAt(1) == 'a'|| c1.charAt(1) == 'b'|| c1.charAt(1) == 'c'|| c1.charAt(1) == 'd'|| c1.charAt(1) == 'e'|| c1.charAt(1) == 'f'|| c1.charAt(1) == 'g'|| c1.charAt(1) == 'h')
				{
					x = (int) c1.charAt(0) -48;
					inter = Character.toUpperCase(c1.charAt(1));
					y = (int) inter -65;
				}
				else
				{
						x = (int) c1.charAt(0) -48;
						y = (int) c1.charAt(1) -65;
				}
			}
			catch(ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e)
			{
				System.out.println("Les coordonées saisie sont invalides");
			};
			
			
			if ( c.getJ()=="blanc") // Si c'est au joueur blanc de jouer.
				setTourBlanc(true);
			else
				setTourBlanc(false);
			
			if ( tourBlanc) 
			{
				 joueur = "noire";
				 setTourBlanc(false);
			}
			
			else
			{
				 joueur = "blanche";
				 setTourBlanc(true);
			}
			
			ech.setRois();
			if ( x == ech.getRoiN().getAbscisse() && y == ech.getRoiN().getOrdonnee() || x == ech.getRoiB().getAbscisse() && y == ech.getRoiB().getOrdonnee())
			{
				System.out.println("Vous ne pouvez pas manger le roi adverse");
				mouvementValide = false;
			}
			
			try
			{
				if ( (ech.estOccupee(ech.getTab(abs, ord).getAbscisse(),ech.getTab(abs, ord).getOrdonnee())))
					System.out.println("");
			}
			catch(NullPointerException | ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Vous ne pouvez pas saisir les coordonnées de cette case dans le tableau étant donnée qu'elle est innocupée. ");
			}
			
			try	
			{
				if (!(c.CompareCouleur(ech.getTab(abs,ord))) && (ech.estOccupee(ech.getTab(abs, ord).getAbscisse(),ech.getTab(abs, ord).getOrdonnee()))) // Je ne peut pas déplacer une pièce qui n'est pas de ma couleur.
				{
					System.out.println("Vous ne pouvez pas bouger les pieces " + joueur+" car vous êtes le joueur " + c.getJ());
					maPiece = false;
				}

				if ( !(ech.DeplacementEstValide(ech.getTab(abs,ord), x, y)))
				{
						System.out.println("Le mouvement que vous avez sélectionner n'est pas valide ");
						mouvementValide = false;
				}
			}
			catch(ArrayIndexOutOfBoundsException | NullPointerException  e)
			{
				System.out.println(" Les Coordonnées saisies sont invalides");
				maPiece = false;
				mouvementValide = false;
			}
			
			try
			{
				if ( ech.getTab(abs,ord) instanceof Roi )
				{
			
					if ( ech.getTab(abs,ord).getC().equals("noir"))
					{
						ArrayList<Piece> listPiece = new ArrayList<Piece>();
						for(int i=0;i<8;i++)
						{
							for(int j=0;j<8;j++)
							{
								if ((ech.estOccupee(i,j)))
								{
									if (ech.getTab(i,j).getC().equals("blanc"))
									{									
										listPiece.add(ech.getTab(i,j));
									}
								}
							}
						}
						
						if ( ech.getTab(abs, ord).getOrdonnee() > ech.getTab(x, y).getOrdonnee())
						 {
							    boolean roqueEstPossible = true;
								int cpt = 0;
								while (cpt < listPiece.size() && roqueEstPossible != false )
								{
									
									if ( ech.DeplacementEstValide(listPiece.get(cpt), 0, 2))
									{
										roqueEstPossible = false;
									}
									cpt ++;
								}
								
								if( !(roqueEstPossible))
								{
									System.out.println("Vous ne pouvez pas effectuer de roque car la case d'arrivée du roi à la fin du roque est controlé par une pièce adverse.");
									mouvementValide = false;
									
								}
						 }
						 else
						 {
							   boolean roqueEstPossible = true;
								int cpt = 0;
								while (cpt < listPiece.size() && roqueEstPossible != false )
								{
									if ( ech.DeplacementEstValide(listPiece.get(cpt), 0, 6))
									{
										roqueEstPossible = false;
									}
									cpt ++;
								}
								
								if( !(roqueEstPossible))
								{
									System.out.println("Vous ne pouvez pas effectuer de roque car la case d'arrivée du roi à la fin du roque est controlé par une pièce adverse.");
									mouvementValide = false;
									
								}
						 }
						
						
					}
					else
					 {
						 ArrayList<Piece> listPiece = new ArrayList<Piece>();
						 for(int i=0;i<8;i++)
						 {
								for(int j=0;j<8;j++)
								{
									if ((ech.estOccupee(i,j)))
									{
										if (ech.getTab(i,j).getC().equals("noir"))
										{									
											listPiece.add(ech.getTab(i,j));
										}
									}
								}
						 }
						 
						 if ( ech.getTab(abs, ord).getOrdonnee() > ech.getTab(x, y).getOrdonnee())
						 {
							 boolean roqueEstPossible = true;
								int cpt = 0;
								while (cpt < listPiece.size() && roqueEstPossible != false )
								{
									if ( ech.DeplacementEstValide(listPiece.get(cpt), 7, 2))
									{
										roqueEstPossible = false;
									}
									cpt ++;
								}
								
								if( !(roqueEstPossible))
								{
									System.out.println("Vous ne pouvez pas effectuer de roque car la case d'arrivée du roi à la fin du roque  est controlé par une pièce adverse.");
									mouvementValide = false;
									
								}
						 }
						 else
						 {
							 boolean roqueEstPossible = true;
							int cpt = 0;
							while (cpt < listPiece.size() && roqueEstPossible != false )
							{
								if ( ech.DeplacementEstValide(listPiece.get(cpt), 7, 6))
								{
									roqueEstPossible = false;
								}
								cpt ++;
							}
							
							if( !(roqueEstPossible))
							{
								System.out.println("Vous ne pouvez pas effectuer de roque car la case d'arrivée du roi à la fin du roque  est controlé par une pièce adverse.");
								mouvementValide = false;
								
							}
						 }
				}
					
				}
			}
			catch(ArrayIndexOutOfBoundsException | NullPointerException  e)
			{
					System.out.println(" Les Coordonnées saisies sont invalides.");
			}
				 
				 
			
					
			
		}while (x > 8 || x < 0 || y>8 || y <0 || !(maPiece)|| !(mouvementValide) );
		
		try
		{
			ech.DeplacerPiece(ech.getTab(abs,ord), x, y);
		}
		catch (ArrayIndexOutOfBoundsException | NullPointerException e)
		{
			System.out.println("Le déplacement de votre pièce est impossible. Veuillez vérifier les coordonnées que vous avez saisies");
		}
	
		
	}
	
	
	/**
	 * Méthode permettant de comparer la couleur du joueur à celle de la pièce.
	 */
	
	public boolean CompareCouleur( Object o )
	{
		
		if ( !(o instanceof Piece ))
			return false;
		
		Piece str = (Piece) o;
		return this.getJ() == ( str.getC());
		
	}
	
	

}
