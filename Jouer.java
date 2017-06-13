package Echec;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner; // permet de saisir au clavier
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;







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
	
	private boolean aublanc;
	
	/**
	 * Constructeur par défaut.
	 */
	public Jouer()
	{
		this.tour = 0;
		this.tourBlanc = true;
		this.j = "blanc";
		this.aublanc = false;
		
		
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
	public void demarrerPartie ( FenetrePrincipale f1) 
	{
		Echiquier ec = new Echiquier();
		ec.initEchiquier(); // Méthode permettant d'initialiser l'objet Echiquier créé précédement.
		f1.afficherEch(); // Méthode permettant d'afficher l'échiquier sur la fenêtre. 
		f1.positionnerCases(); // Méthode permettant de positonner les cases.
		f1.afficherPieces(ec); // Méthode permettant d'afficher les pièces..
		f1.revalidate();// Méthode permettant de mettre à jour la fenêtre.
	

	}
	
	public void partie( FenetrePrincipale f1,Echiquier ec)
	{
		
		int cpt = 1;
		int t = 0;
		boolean winner = false;	
		Random rand = new Random();
		int turn = rand.nextInt(2 - 1 + 1) + 1;
		 try 
		    {
		    	Thread.sleep(1300); //Ici, une pause 
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		String j1 = (String)JOptionPane.showInputDialog(null,"Quelle est  votre Pseudo Joueur 1");
		String[] couleurs = {"Les Blancs", "Les Noirs"};
	    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    int rang = jop.showOptionDialog(null, 
	      "Veuillez chosir la couleur de vos pions "+j1,
	      "Le choix des pièces",
	      JOptionPane.YES_NO_CANCEL_OPTION,
	      JOptionPane.QUESTION_MESSAGE,
	      null,
	      couleurs,
	      couleurs[0]);
	    jop2.showMessageDialog(null, j1 +" vous avez décider de jouer avec " + couleurs[rang], "Informations", JOptionPane.INFORMATION_MESSAGE);
		String j2 = (String)JOptionPane.showInputDialog(null,"Quelle est  votre Pseudo Joueur 2");
		int couleurJ1 = 0;
		
		if(rang == 0)
		{
			JOptionPane.showMessageDialog(null,j1+" a décidé de choisir "+couleurs[0]+", par conséquent "+j2+" vous aller être "+couleurs[1]);
			couleurJ1 = 0;
			
		}
		else if ( rang == 1)
		{
			JOptionPane.showMessageDialog(null,j1+" a décidé de choisir "+couleurs[1]+", par conséquent "+j2+" vous aller être "+couleurs[0]);
			couleurJ1 = 1;
			
		}
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/sablier.gif"));
		
		JOptionPane.showMessageDialog(null,"Un tirage au sort est en train d'être effectué entre "+j1+" et "+j2+" pour savoir qui va commencer.","Le tirage au sort",JOptionPane.INFORMATION_MESSAGE,icon);
		
		
		try 
	    {
	    	Thread.sleep(200); //Ici, une pause d'une seconde
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
		
		
		
		
		if ( turn ==  1 )
		{
			setJ("blanc");
			if ( couleurJ1 == 0)
			{
				JOptionPane.showMessageDialog(null,"Cest "+j1+" qui vas commencer la partie.","Résultat",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Cest "+j2+" qui vas commencer la partie.","Résultat",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else
		{
			setJ("noir");
			if ( couleurJ1 == 1)
			{
				JOptionPane.showMessageDialog(null,"Cest "+j1+" qui vas commencer la partie.","Résultat",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Cest "+j2+" qui vas commencer la partie.","Résultat",JOptionPane.INFORMATION_MESSAGE);
			}
		}

		
		
		f1.getSauve().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				
					String mes = (String)JOptionPane.showInputDialog(null,"Quelle est le nom de votre fichier");
					JOptionPane.showMessageDialog(null, "La Partie vient d'être sauvegarder.");	
					sauvegarde(mes,ec,j1,j2,getJ(),getTour(),getAublanc());
			}});
		do
		{
			
			
			
			System.out.println("Tour n° : "+getTour());
			f1.afficherEch(); // Méthode permettant d'afficher l'échiquier sur la fenêtre. 
			f1.positionnerCases(); // Méthode permettant de positonner les cases.
			f1.afficherPieces(ec); // Méthode permettant d'afficher les pièces.
			f1.revalidate();// Méthode permettant de mettre à jour la fenêtre.
			
			if(getJ().equals("blanc") && t != 1) 
			{
					setAublanc(true);
					if ( couleurJ1 == 0)
					{
						this.jouerModeClavier(this,ec,j1);
						setJ("noir");
						
					}
					else
					{
						this.jouerModeClavier(this,ec,j2);
						setJ("noir");
					}
			}
			
			else if (getJ().equals("noir") && t != 1) 
			{
				setAublanc(false); 
				if ( couleurJ1 == 1)
				{
					this.jouerModeClavier(this,ec,j1);
					setJ("blanc");
				}
				else
				{
					this.jouerModeClavier(this,ec,j2);
					setJ("blanc");
				}
			}
			
			setTour(cpt);
			cpt++;
			
			if (ec.getWinner().equals("noir") || (ec.getWinner().equals("blanc") || ec.getWinner().equals("null"))|| ec.getWinner().equals("deuce"))
			{
				winner = true;
				t ++;
			}
			
		}while((winner != true || t !=2));
		
		
		
		if ( ec.getWinner().equals("noir"))
			
			System.out.println("Le joueur noir remporte la partie.");
		
		else if (ec.getWinner().equals("blanc"))
			
			System.out.println("Le joueur blanc remporte la partie.");
		
		else if (ec.getWinner().equals("null"))
			
			System.out.println("Vous êtes pat.");
		else
			System.out.println("C'est une égualité");
			
	
	
	}
	

	public void jouerModeClavier(Jouer c, Echiquier ech,String s)
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
			System.out.println("joueur "+c.getJ()+" "+s);
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
			try
			{
				if ( x == ech.getRoiN().getAbscisse() && y == ech.getRoiN().getOrdonnee() || x == ech.getRoiB().getAbscisse() && y == ech.getRoiB().getOrdonnee())
				{
					System.out.println("Vous ne pouvez pas manger le roi adverse");
					mouvementValide = false;
				}
			}catch( Exception e){System.out.println(e);}
			
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
						if ( ech.getTab(x,y) instanceof Tour &&  ech.getTab(x,y).getC().equals("noir"))
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
						
					}
					if ( ech.getTab(abs,ord) instanceof Roi )
					{
						
						if ( ech.getTab(abs,ord).getC().equals("blanc"))
						{
							if ( ech.getTab(x,y) instanceof Tour &&  ech.getTab(x,y).getC().equals("blanc"))
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
		return this.getJ().equals(( str.getC()));
		
	}
	
	
	
	
	public void sauvegarde(String s,Echiquier ech,String j1,String j2, String c, int nbTour, boolean monTour)
	{
			
			try{
				FileWriter f = new FileWriter("Sauvegarde/"+s);
				BufferedWriter b = new BufferedWriter(f);
				
				for(int i=0; i<8; i++){
					for ( int j = 0; j < 8;j++)
					{
						if ( ech.estOccupee(i, j))
						{
							b.write(ech.getTab(i, j).getNom()+ "\t");
							b.write(ech.getTab(i, j).getC()+ "\t");
							b.write(ech.getTab(i, j).getAbscisse()+ "\t");
							b.write(ech.getTab(i, j).getOrdonnee()+ "\t");
							b.write(ech.getTab(i, j).getPremierMouvement()+ "\t");
							b.write(ech.getTab(i, j).getMvt()+ "\t");
							b.write("\n");
							
						}
						else
						{
							b.write("null"+"\t");
							b.write("null"+"\t");
							b.write("null"+"\t");
							b.write("null"+"\t");
							b.write("null"+"\t");
							b.write("null"+"\t");
							b.write("\n");
						}
					}
					
				}
				b.write("JO"+j1);
				b.write("\n");
				b.write("CO"+c);
				b.write("\n");
				b.write("J2"+j2);
				b.write("\n");
				b.write("TO"+nbTour);
				b.write("\n");
				b.write("MO"+monTour);
				b.close();
				f.close();		
			}catch(IOException | NullPointerException e){
				e.printStackTrace();
			}		
			

	}
	
public Echiquier charge(String nom) {
		
		FileReader fr = null;
		try {
			fr = new FileReader("Sauvegarde/"+nom);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		
		try{
			line = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Echiquier ec = new Echiquier();
		while(line!=null)
		{
			
			StringTokenizer st = new StringTokenizer(line,"\t");
			
			
			
			
						String tmp = line.substring(0, 2);
						if (( tmp.equals("NT")))
						{
							
							Tour t = new Tour(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
							ec.setTab(t);					
							
						}
						
						else if ((  tmp.equals("NF")))
						{
							Fou f = new Fou(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
							ec.setTab(f);
							
							
						}
					
						else if ((  tmp.equals("NC")))
					{
						
						Cavalier c = new Cavalier(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(c);
						
						
					}
					
						else if ((  tmp.equals("ND")))
					{
						
						Dame d = new Dame(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(d);
						
						
					}
						else if ((  tmp.equals("NR")))
					{
						
						Roi r = new Roi(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(r);
						
						
					}
					
						else if (( tmp.equals("NP")))
					{
						Pion p = new Pion(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(p);
						
						
					}
					
						else if ((tmp.equals("BT")))
					{
						
						Tour t = new Tour(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(t);
						
						
					}
						else if ((  tmp.equals("BF")))
					{
						
						Fou f = new Fou(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(f);
						
						
					}
					
						else if ((  tmp.equals("BC")))
					{
						
						Cavalier c = new Cavalier(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(c);
						
						
					}
					
						else if ((  tmp.equals("BD")))
					{
						
						Dame d = new Dame(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(d);
						
						
					}
						else if ((  tmp.equals("BR")))
					{
						
						Roi r = new Roi(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(r);
						
						
					}
					
						else  if ((  tmp.equals("BP")))
					{
						
						
						Pion p = new Pion(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Boolean.parseBoolean(st.nextToken()),Integer.parseInt(st.nextToken()));
						ec.setTab(p);
						
					}
		
						try{
							line=br.readLine();
						}
						catch (IOException |  NoSuchElementException e){
							e.printStackTrace();
						}	
						
					
			}
		
			
		
		return ec;
	}
	
	public void demarrerPartie ( FenetrePrincipale f1,Echiquier e) 
	{
		Echiquier ec = new Echiquier();
		ec.Echange(e); // Méthode permettant d'initialiser l'objet Echiquier créé précédement.
		f1.afficherEch(); // Méthode permettant d'afficher l'échiquier sur la fenêtre. 
		f1.positionnerCases(); // Méthode permettant de positonner les cases.
		f1.afficherPieces(ec); // Méthode permettant d'afficher les pièces..
		f1.revalidate();// Méthode permettant de mettre à jour la fenêtre.
	}
	
	
	public void partieCharger( FenetrePrincipale f1,Echiquier ec,String j1,String j2,String c1,int nbTour,boolean iswhite)
	{
		
		if ( iswhite)
		{
			this.setJ("blanc");
		}
		else
		{
			this.setJ("noir");
		}
		
		int t = 0;
		setTour(nbTour);
		int cpt = nbTour;
		boolean winner = false;	
		String s = c1;
		f1.getSauve().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				
					String mes = (String)JOptionPane.showInputDialog(null,"Quelle est le nom de votre fichier");
					JOptionPane.showMessageDialog(null, "La Partie vient d'être sauvegarder.");	
					sauvegarde(mes,ec,j1,j2,s,nbTour,getAublanc());
			}});
		do
		{
			
			
			System.out.println("Tour n° : "+getTour());
			f1.afficherEch(); // Méthode permettant d'afficher l'échiquier sur la fenêtre. 
			f1.positionnerCases(); // Méthode permettant de positonner les cases.
			f1.afficherPieces(ec); // Méthode permettant d'afficher les pièces.
			f1.revalidate();// Méthode permettant de mettre à jour la fenêtre.
			System.out.println(getJ());
			if(iswhite && t != 1) 
			{
					
				if ( c1.equals("blanc"))
				{
					this.jouerModeClavier(this,ec,j1);
					setJ("noir");
					iswhite = !(iswhite);
					c1 = "noir";
				}
				else if ( c1.equals("noir"))
				{
					this.jouerModeClavier(this,ec,j2);
					setJ("blanc");
					iswhite = !(iswhite);
					c1 = "blanc";
				}
			}
			
			else if (!(iswhite) && t != 1) 
			{
				   
				if ( c1.equals("noir"))
				{
					this.jouerModeClavier(this,ec,j1);
					setJ("blanc");
					iswhite = !(iswhite);
					c1 = "blanc";
				}
				else if ( c1.equals("blanc"))
				{
					this.jouerModeClavier(this,ec,j2);
					setJ("noir");
					iswhite = !(iswhite);
					c1 = "noir";
				}
			}
			
			setTour(cpt);
			cpt++;
			
			if (ec.getWinner().equals("noir") || (ec.getWinner().equals("blanc") || ec.getWinner().equals("null")) || ec.getWinner().equals("deuce")) 
			{
				winner = true;
				t ++;
			}
			
		}while((winner != true || t !=2));
		
		
		
		if ( ec.getWinner().equals("noir"))
			
			System.out.println("Le joueur noir remporte la partie.");
		
		else if (ec.getWinner().equals("blanc"))
			
			System.out.println("Le joueur blanc remporte la partie.");
		
		else if (ec.getWinner().equals("null"))
			
			System.out.println("Vous êtes pat.");
		else
			System.out.println("C'est une égualité");
	
	}
	
	
public String chargeJoueur(String nom) {
		
		FileReader fr = null;
		try {
			fr = new FileReader("Sauvegarde/"+nom);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		
		try{
			line = br.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		String j1 = null;
		Echiquier ec = new Echiquier();
		while(line!=null)
		{
			StringTokenizer st = new StringTokenizer(line,"\t");
			String tmp = line.substring(0, 2);
			if ((  tmp.equals("JO")))
			{
				String s = st.nextToken();
				 j1 = s.substring(2);								
			}
			
			try{
				line=br.readLine();
			}
			catch (IOException |  NoSuchElementException e){
				e.printStackTrace();
			}	
		}
		return j1;
	}

public String chargeJoueur2(String nom) {
	
	FileReader fr = null;
	try {
		fr = new FileReader("Sauvegarde/"+nom);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	BufferedReader br = new BufferedReader(fr);
	
	String line = null;
	
	try{
		line = br.readLine();
	}catch(IOException e){
		e.printStackTrace();
	}
	String j2 = null;
	Echiquier ec = new Echiquier();
	while(line!=null)
	{
		StringTokenizer st = new StringTokenizer(line,"\t");
		String tmp = line.substring(0, 2);
		if ((  tmp.equals("J2")))
		{
			String s = st.nextToken();
			j2 = s.substring(2);								
		}
		
		try{
			line=br.readLine();
		}
		catch (IOException |  NoSuchElementException e){
			e.printStackTrace();
		}	
	}
	return j2;
}


public String chargeCouleur(String nom) {
	
	FileReader fr = null;
	try {
		fr = new FileReader("Sauvegarde/"+nom);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	BufferedReader br = new BufferedReader(fr);
	
	String line = null;
	
	try{
		line = br.readLine();
	}catch(IOException e){
		e.printStackTrace();
	}
	String c = null;
	Echiquier ec = new Echiquier();
	while(line!=null)
	{
		StringTokenizer st = new StringTokenizer(line,"\t");
		String tmp = line.substring(0, 2);
		if ((  tmp.equals("CO")))
		{
			String s = st.nextToken();
			c = s.substring(2);								
		}
		
		try{
			line=br.readLine();
		}
		catch (IOException |  NoSuchElementException e){
			e.printStackTrace();
		}	
	}
	return c;
}


public int chargeTour(String nom) {
	
	FileReader fr = null;
	try {
		fr = new FileReader("Sauvegarde/"+nom);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	BufferedReader br = new BufferedReader(fr);
	
	String line = null;
	
	try{
		line = br.readLine();
	}catch(IOException e){
		e.printStackTrace();
	}
	int tour = 0;
	Echiquier ec = new Echiquier();
	while(line!=null)
	{
		StringTokenizer st = new StringTokenizer(line,"\t");
		String tmp = line.substring(0, 2);
		if ((  tmp.equals("TO")))
		{
			String s = st.nextToken();
			tour = Integer.parseInt(s.substring(2));						
		}
		
		try{
			line=br.readLine();
		}
		catch (IOException |  NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	return tour;
}
public boolean auBlanc(String nom) {
	
	FileReader fr = null;
	try {
		fr = new FileReader("Sauvegarde/"+nom);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	BufferedReader br = new BufferedReader(fr);
	
	String line = null;
	
	try{
		line = br.readLine();
	}catch(IOException e){
		e.printStackTrace();
	}
	boolean white= false;
	Echiquier ec = new Echiquier();
	while(line!=null)
	{
		StringTokenizer st = new StringTokenizer(line,"\t");
		String tmp = line.substring(0, 2);
		if ((  tmp.equals("MO")))
		{
			String s = st.nextToken();	
			white = Boolean.parseBoolean(s.substring(2))	;				
										
		}
		
		try{
			line=br.readLine();
		}
		catch (IOException |  NoSuchElementException e){
			e.printStackTrace();
		}	
	}
	return white;
}


public boolean getAublanc() {
	return aublanc;
}

public void setAublanc(boolean aublanc) {
	this.aublanc = aublanc;
}

	
}
