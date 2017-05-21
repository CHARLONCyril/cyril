package Echec;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Définit un échiquier
 *
 */

public class Echiquier
{
	/**
	 * Tableau de pièce.
	 */
	private Piece [][] tab;
	
	private Roi roiB;
	private Roi roiN;
	
	private String winner;
	
	/**
	 * Constructeur par défaut.
	 */
	
	public  Echiquier ()
	{
		this.tab = new Piece [8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				tab[i][j]=null;
			}
		}
		setRois();
		this.setWinner("");
	
	}
		

		
		public void setRois(){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
	    			if(this.tab[i][j] != null && this.tab[i][j] instanceof Roi ){
	    				if(this.tab[i][j].getC().equals("noir")){
	    					this.roiN = (Roi)this.tab[i][j];
	    				}else if(this.tab[i][j].getC().equals("blanc")){
	    					this.roiB = (Roi)this.tab[i][j];
	    				}
	    			}
	    		}
	    	}
	    }
		
		
		public Piece getRoiN()
		{
			return this.roiN;
			
		}
		
		public Piece getRoiB()
		{
			return this.roiB;
		}
		
		public void initEchiquier()
		{
			
			//setTab((new Tour("NT","noir",0,0,true)));
			//setTab((new Cavalier("NC","noir",0,1,false)));
			//setTab((new Fou("NF","noir",0,2,false)));
		    //setTab((new Dame("ND","noir",0,3,false)));
		    setTab((new Roi("NR","noir",0,4,true)));
		    //setTab((new Fou("NF","noir",0,5,false)));
		    //setTab((new Cavalier("NC","noir",0,6,false)));
			//setTab((new Tour("NT","noir",0,7,true)));
		    for(int i = 0; i <= 7; i++)
		    {
				setTab( new Pion("NP","noir",1, i,true));
				//setTab( new Pion("BP","blanc",6, i,true));
			}
				
		    //setTab((new Tour("BT","blanc",7,0,true)));
			//setTab(( new Cavalier("BC","blanc",7,1,false)));
		   //setTab(( new Fou("BF","blanc",7,2,false)));
		    setTab((new Dame("BD","blanc",7,3,false)));
	        setTab(( new Roi("BR","blanc",7,4,true)));
	        //setTab(( new Fou("BF","blanc",7,5,false)));
			//setTab(( new Cavalier("BC","blanc",7,6,false)));
			setTab(( new Tour("BT","blanc",7,7,true)));
		}
		
	

	/**
	  * Cette méthode retourne si elle existe la piece d'une des Tab du tableau.
	  * @param x L'abscisse de la Tab
	  * @param y L'ordonnée de la Tab
	  * @return soit la pièce contenue dans cette Tab soit null car il y a eut une erreur dans les coordonnées. 
	  */
	 
		public Piece getTab(int x, int y) {
			return this.tab[x][y];
		}
	 
	 /**
	  * Méthode insérant une pièce dans une case de  Tab.
	  * @param x L'abscisse de la Tab
	  * @param y L'ordonnée de la Tab
	  * @param a La pièce à insérer dans Tab.
	  */
				public void setTab(Piece p) {
					this.tab[p.getAbscisse()][p.getOrdonnee()]=p;
				}
	 /**
		 *Si une case du tableau est occupée.
		 *@param x Abscisse de la case
		 *@param y Ordonnee de la case
		 *@return true si elle est occupée sinon return false.
		 */
		 
		 public boolean estOccupee ( int x, int y)
		 {
			 if (this.tab[x][y]==null) 
				 return false;
			 
			return true;
		 }
		 
		 
		 
		 public boolean DeplacementEstValide(Piece p1, int x, int y)
		 {
			
			 if( p1 instanceof Pion ) // Si ma pièce est un pion.
			 {
				 Pion p = new Pion ((Pion)p1);// On caste la Pièce en Pion
				 if( p.getC().equals("noir")) // Si c'est un Pion Noir
				 {
					 if ( p.DeplacerPionNoir(x,y)) // Si les coordonnées saisie par le joueur sont valides.
					 {
						 if(estOccupee(x, y) && p.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces.
						 {
							 return false;
						 }
						 
						 if(y == p.getOrdonnee() && x == p.getAbscisse()+1 && estOccupee(x,y)) // On ne peut pas se deplacer sur case qui contient deja une pièce
						 {																	   // Le pion peut manger uniquement en diagonale.
							 return false;
						 }
		
						if(x == p.getAbscisse()+1 && y == p.getOrdonnee()-1) // Si je veut manger vers la gauche
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma gauche.
								{
									return false;
								}
								 if ( estOccupee(x,y) && p.equalsCouleur(getTab(x,y) )) // On ne peut pas se manger soit même.
								 {
										 return false;
								 }
								 
								return true; // Je peut manger.
						}
						
						if( x == p.getAbscisse()+1 && y == p.getOrdonnee()+1) // Si je veut manger vers la droite
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma droite.
								{
									return false;
								}
								
							    if ( estOccupee(x,y) && p.equalsCouleur(getTab(x,y) )) // On ne peut pas se manger soit même.
								{
									 return false;
								}
								 
								return true; // Je peut manger.
								
						}
						
						if( x == p.getAbscisse()+2 && y == p.getOrdonnee() && !(p.getPremierMouvement()) ) // Je peut uniquement avancer de 2 lignes
						{																					// lors de mon premier Déplacement.
							return false;
						}
						
						if( x == p.getAbscisse()+2 && y == p.getOrdonnee() && estOccupee(x,y))  // Je ne peut pas avancer de 2 lignes si cette dernière 
						{																		// est déja occupée par une autre pièce.
							return false;
						}
						
						
						if( x == p.getAbscisse()+2 && y == p.getOrdonnee() && estOccupee(x-1,y)) // Mon pion ne peut pas enjamber d'autre pièce.
						{
							return false;
						}
						
						ArrayList<Piece> listPiece = new ArrayList<Piece>();
						 for(int i=0;i<8;i++)
						{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("blanc"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
						}
						boolean res = true;
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( echec(this,listPiece.get(cpt)))
							{
								if ( p.getAbscisse() + x != listPiece.get(cpt).getAbscisse() &&  p.getOrdonnee() + y != listPiece.get(cpt).getOrdonnee())
								{
									res = false;
								}
							}
							cpt ++;
										
						}
						if ( res == false)
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
						
						
						int c = 0;
					 	res = true;				 	
					 	this.setRois();
					 	while( c < listPiece.size() && res != false)
					 	{
					 			if (!( echec(this,listPiece.get(c))))
					 			{
					 				Roi r2 = new Roi( (Roi) this.getRoiN());
					 				Pion p2 = new Pion ( (Pion) p);
					 				p2.setAbscisse(x);
					 				p2.setOrdonnee(y);
					 				Echiquier e = new Echiquier();
					 				e.setTab(r2);
					 				e.setTab(listPiece.get(c));
					 				e.setTab(p2);
					 				e.setRois();
					 				if ( e.DeplacementEstValide(e.getTab(listPiece.get(c).abscisse, listPiece.get(c).ordonnee), e.getRoiN().getAbscisse(), e.getRoiN().getOrdonnee()))
					 				{
					 					System.out.println("yoyo");
					 				}
					 			}
					 			
					 		c ++;
					 	}
						
						if ( res == false)
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
						
						return res;// Le déplacement du pion est correcte.
					 }
					 else
						 return false; // Le déplacement n'est pas valide.
				 }
				 else // C'est un pion blanc
				 {
					 if ( p.DeplacerPionBlanc(x,y)) // Si les coordonnées saisie par le joueur sont valides.
					 {
						 if(estOccupee(x, y) && p.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces.
						 {
							 return false;
						 }
						 
						 if(y == p.getOrdonnee() && x == p.getAbscisse()- 1 && estOccupee(x,y)) // On ne peut pas se deplacer sur case qui contient deja une pièce 
						 {																		// Le pion peut manger uniquement en diagonale.
							 return false;
						 }
		
						if(x == p.getAbscisse()-1 && y == p.getOrdonnee()-1) // Si je veut manger vers la gauche
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma gauche.
								{
									return false;
								}
								
							    if ( estOccupee(x,y) && p.equalsCouleur(getTab(x,y) )) // On ne peut pas se manger soit même.
								{
									return false;
								}
								 
								return true; // Je peut manger.
								
						}
						
						if( x == p.getAbscisse()-1 && y == p.getOrdonnee()+1) // Si je veut manger vers la droite
						{
								if(!estOccupee(x,y)) // Je ne peut pas manger si il n'y a pas de pièce à ma droite.
								{
									return false;
								}
								
								 if ( estOccupee(x,y) && p.equalsCouleur(getTab(x,y) )) // On ne peut pas se manger soit même.
								 {
										 return false;
								 }
								 
								return true; // Je peut manger.
								
						}
						
						if( x == p.getAbscisse()-2 && y == p.getOrdonnee() && !(p.getPremierMouvement()) ) // Je peut uniquement avancer de 2 lignes 
						{																				// lors de mon premier Déplacement.
							return false;																
						}
						
						if( x == p.getAbscisse()-2 && y == p.getOrdonnee() && estOccupee(x,y))  // Je ne peut pas avancer de 2 lignes si cette dernière 
						{																		// est déja occupée par une autre pièce.
							return false;
						}
						
						if( x == p.getAbscisse()-2 && y == p.getOrdonnee() && estOccupee(x+1,y)) // Mon pion ne peut pas enjamber d'autre pièce.
						{
							return false;
						}
						
						ArrayList<Piece> listPiece = new ArrayList<Piece>();
						 for(int i=0;i<8;i++)
						{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
						}
						boolean res = true;
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( echec(this,listPiece.get(cpt)))
							{
								if ( p.getAbscisse() + x != listPiece.get(cpt).getAbscisse() &&  p.getOrdonnee() + y != listPiece.get(cpt).getOrdonnee())
								{
									res = false;
								}
							}
							cpt ++;
										
						}
						if ( res == false)
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
						
						return res;// Le déplacement du pion est correcte.
					 }
					 else
						return false; // Le déplacement n'est pas valide.
				 }
			 }
			 
			 if( p1 instanceof Tour) // Si ma pièce est une tour.
			 {
				 Tour t = new Tour( (Tour) p1 ); // On caste la Pièce en Tour.
				 if ( t.DeplacerTour(x,y)) // Si les coordonnées saisie par le joueur sont valides.
				 {
					 if(estOccupee(x, y) && t.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
					 {
						 return false;
					 }
					 
					 
					 ArrayList<Piece> listPiece = new ArrayList<Piece>();
					    if ( t.getC().equals("noir"))
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("blanc"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    else
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    boolean res = true;
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( echec(this,listPiece.get(cpt)))
							{
								if ( t.getAbscisse() + x != listPiece.get(cpt).getAbscisse() &&  t.getOrdonnee() + y != listPiece.get(cpt).getOrdonnee())
								{
									res = false;
								}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
					    
				    res = true;
					int abs = t.getAbscisse();
					int ord = t.getOrdonnee();
				    if(abs != x && ord ==y) // Mouvement Verticale
					 {
				    	
				    	if(abs > x) // haut vers bas
				    	{  
				    		while( abs != x+1 && res != false )
				    		{
				    			if( this.estOccupee(abs-1, y))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
				    			{
				    				res = false;
				    			}
				    			abs --;
				    		}
				    		return res;
				    	}
				    	
					   if(abs < x) // bas vers haut
					    { 
						   while( abs != x-1 && res != false )
					    	{
					    	    if( this.estOccupee(abs+1, y)) // Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
					    		{
					    			res = false;
					    		}
					    		abs ++;
					    	}
			    			return res;
				    	}
				    }
				    if(ord != y && abs == x) // Mouvement horizontale
				    { 
				    	if(ord > y)// droite vers gauche
				    	{
				    		while( ord != y+1 && res != false )
			    			{
			    				if( this.estOccupee(x, ord-1))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
			    				{
			    					res = false;
			    				}
			    				ord --;
			    			}
			    			return res;
				    	}
				    	if(ord < y)// gauche vers droite
				    	{ 
				    		while( ord != y-1 && res != false )
			    			{
			    				if( this.estOccupee(x, ord+1))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
			    				{
			    					res = false;
			    				}
			    				ord ++;
			    			}
			    			return res;
				    	}
				    }
				    
				 }
				 else
					 return false; // Le déplacement n'est pas valide.
			 }			
			 
			 if( p1 instanceof Fou) // Si ma pièce est un fou.
			 {
				 Fou f = new Fou( (Fou) p1 ); // On caste la Pièce en Fou.
				 if ( f.DeplacerFou(x,y)) // Si les coordonnées saisie par le joueur sont valides.
				 {
					 if(estOccupee(x, y) && f.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
					 {
						 return false;
					 }
					 
					 ArrayList<Piece> listPiece = new ArrayList<Piece>();
					    if ( f.getC().equals("noir"))
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("blanc"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    else
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    boolean res = true;
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( echec(this,listPiece.get(cpt)))
							{
								if ( f.getAbscisse() + x != listPiece.get(cpt).getAbscisse() &&  f.getOrdonnee() + y != listPiece.get(cpt).getOrdonnee())
								{
									res = false;
								}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
					 
					 
					 res = true;
					int abs = f.getAbscisse();
					int ord = f.getOrdonnee();
						
					if(x > abs && y > ord)// Mouvement du bas vers le haut à droite
					{
							while(abs != x-1 && ord != y-1 && res != false)
							{
								if(this.estOccupee(abs+1, ord+1))// Si la case est occcupée, mon chemin n'est pas valide car le fou ne peut pas enjambée des pièces.
								{
									res = false;
								}
								abs ++ ;
								ord ++;
							}
							return res ;
						}
						
						if(x < abs && y > ord) // Mouvement du haut vers le bas à droite
						{ 
							while(abs != x+1 && ord != y-1 && res != false)
							{
								if(this.estOccupee(abs-1, ord+1))// Si la case est occcupée, mon chemin n'est pas valide car le fou ne peut pas enjambée des pièces.
								{
									res =  false;
								}
								abs --;
								ord ++;
							}
							return res;
						}
						
					
					 	if(x>abs && y <ord)// Mouvement du bas vers le haut à gauche.
					 	{ 
					 		while(abs != x-1 && ord != y+1 && res != false)
					 		{
								if(this.estOccupee(abs+1, ord-1))
								{
									res =  false;
								}
								abs ++;
								ord --;
							}
							return res;
						}
						
						if(x<abs && y<ord) // Mouvement du haut vers le bas à gauche
						{
							while(abs != x+1 && ord != y+1 && res != false)
							{
								
								if(this.estOccupee(abs-1, ord-1))//Si la case est occcupée, mon chemin n'est pas valide car le fou ne peut pas enjambée des pièces.
								{
									res = false;
								}
					 			abs --;
								ord --;
							}
							return res;
						}
				}
				 else
					 return false; // Le déplacement n'est pas valide.
			 }
			 
			 if ( p1 instanceof Dame) // Si ma pièce est une dame.
			 {
				 Dame  d = new Dame ( (Dame) p1 ); // On caste la Pièce en Dame.
				 if ( d.DeplacerDame(x,y)) // Si les coordonnées saisie par le joueur sont valides.
				 {
					 if(estOccupee(x, y) && d.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
					 {
						 
						 return false;
					 }
						
					 ArrayList<Piece> listPiece = new ArrayList<Piece>();
					    if ( d.getC().equals("noir"))
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("blanc"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    else
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    boolean res = true;
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( echec(this,listPiece.get(cpt)))
							{
								if ( d.getAbscisse() + x != listPiece.get(cpt).getAbscisse() &&  d.getOrdonnee() + y != listPiece.get(cpt).getOrdonnee())
								{
									res = false;
								}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
					 
					 
					 	res = true;
						int abs = d.getAbscisse();
						int ord = d.getOrdonnee();
					    if(abs != x && ord ==y) // Mouvement Verticale
						 {
					    	
					    	if(abs > x) // haut vers bas
					    	{  
					    		while( abs != x+1 && res != false )
					    		{
					    			if( this.estOccupee(abs-1, y))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
					    			{
					    				res = false;
					    			}
					    			abs --;
					    		}
					    		return res;
					    	}
					    	
						   if(abs < x) // bas vers haut
						    { 
							   while( abs != x-1 && res != false )
						    	{
						    	    if( this.estOccupee(abs+1, y)) // Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
						    		{
						    			res = false;
						    		}
						    		abs ++;
						    	}
				    			return res;
					    	}
					    }
					    if(ord != y && abs == x) // Mouvement horizontale
					    { 
					    	if(ord > y)// droite vers gauche
					    	{
					    		while( ord != y+1 && res != false )
				    			{
				    				if( this.estOccupee(x, ord-1))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
				    				{
				    					res = false;
				    				}
				    				ord --;
				    			}
				    			return res;
					    	}
					    	if(ord < y)// gauche vers droite
					    	{ 
					    		while( ord != y-1 && res != false )
				    			{
				    				if( this.estOccupee(x, ord+1))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
				    				{
				    					res = false;
				    				}
				    				ord ++;
				    			}
				    			return res;
					    	}
					    	
					    }
						if(x > abs && y > ord)// Mouvement du bas vers le haut à droite
						{
								while(abs != x-1 && ord != y-1 && res != false)
								{
									if(this.estOccupee(abs+1, ord+1))// Si la case est occcupée, mon chemin n'est pas valide car le fou ne peut pas enjambée des pièces.
									{
										res = false;
									}
									abs ++ ;
									ord ++;
								}
								return res ;
							}
							
							if(x < abs && y > ord) // Mouvement du haut vers le bas à droite
							{ 
								while(abs != x+1 && ord != y-1 && res != false)
								{
									if(this.estOccupee(abs-1, ord+1))// Si la case est occcupée, mon chemin n'est pas valide car le fou ne peut pas enjambée des pièces.
									{
										res =  false;
									}
									abs --;
									ord ++;
								}
								return res;
							}
							
						
						 	if(x>abs && y <ord)// Mouvement du bas vers le haut à gauche.
						 	{ 
						 		while(abs != x-1 && ord != y+1 && res != false)
						 		{
									if(this.estOccupee(abs+1, ord-1))
									{
										
										res =  false;
									}
									abs ++;
									ord --;
								}
								return res;
							}
							
							if(x<abs && y<ord) // Mouvement du haut vers le bas à gauche
							{
								while(abs != x+1 && ord != y+1 && res != false)
								{
									
									if(this.estOccupee(abs-1, ord-1))//Si la case est occcupée, mon chemin n'est pas valide car le fou ne peut pas enjambée des pièces.
									{
										
										res = false;
									}
						 			abs --;
									ord --;
								}
								return res;
							}
				 }
				 else 
					 return false; // Le déplacement n'est pas valide.
			 }
			 
			 if ( p1 instanceof Roi )
			 {
				 Roi r = new Roi ( (Roi) p1); // On caste la Pièce en roi.
				 if ( r.DeplacerRoi(x, y, this)) // Si les coordonnées saisie par le joueur sont valides.
				 {
					 if(estOccupee(x, y) && r.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
						 return false;
					 if ( r.getC().equals("noir"))
					 {
						 ArrayList<Piece> p = new ArrayList<Piece>();
						 for(int i=0;i<8;i++)
							{
									for(int j=0;j<8;j++)
									{
										if ((estOccupee(i,j)))
										{
											if (getTab(i,j).getC().equals("blanc"))
											{									
												p.add(getTab(i,j));
											}
										}
									}
							}
						 	int cpt = 0;
						 	boolean res = true;				 	
						 	this.setRois();
						 	while( cpt < p.size() && res != false)
						 	{
						 			if (DeplacementEstValide(p.get(cpt), x, y))
						 			{
						 				res = false;
						 			}
						 			if ( echec(this,p.get(cpt)))
						 			{
						 				Roi r2 = new Roi(r);
						 				r2.setAbscisse(x);
						 				r2.setOrdonnee(y);
						 				Echiquier e = new Echiquier();
						 				e.setTab(r2);
						 				e.setTab(p.get(cpt));
						 				if (e.DeplacementEstValide(p.get(cpt), x, y))
							 			{
							 				res = false;
							 			}
						 			}
						 			
						 		cpt ++;
						 	}
						 	return res;
						 	
					 }
					 else
					 {
						 ArrayList<Piece> p = new ArrayList<Piece>();
						 for(int i=0;i<8;i++)
						 {
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											p.add(getTab(i,j));
										}
									}
								}
						 }
						 int cpt = 0;
						 	boolean res = true;				 	
						 	this.setRois();
						 	while( cpt < p.size() && res != false)
						 	{
						 			if (DeplacementEstValide(p.get(cpt), x, y))
						 			{
						 				res = false;
						 			}
						 			if ( echec(this,p.get(cpt)))
						 			{
						 				Roi r2 = new Roi(r);
						 				r2.setAbscisse(x);
						 				r2.setOrdonnee(y);
						 				Echiquier e = new Echiquier();
						 				e.setTab(r2);
						 				e.setTab(p.get(cpt));
						 				if (e.DeplacementEstValide(p.get(cpt), x, y))
							 			{
							 				res = false;
							 			}
						 			}
						 			
						 		cpt ++;
						 	}
						 	return res;
						 	
					 }
				 }
				 else
					 return false; // Le déplacement n'est pas valide.
			 }
			 if ( p1 instanceof Cavalier )
			 {
				 Cavalier c = new Cavalier ( (Cavalier) p1); // On caste la Pièce
				 if ( c.DeplacerCavalier(x, y)) // Si les coordonnées saisie par le joueur sont valides.
				 {
					 if(estOccupee(x, y) && c.equalsCouleur(getTab(x,y))) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
						 return false;
					 
					 ArrayList<Piece> listPiece = new ArrayList<Piece>();
					    if ( c.getC().equals("noir"))
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("blanc"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    else
					    {
					    	for(int i=0;i<8;i++)
					    	{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											listPiece.add(getTab(i,j));
										}
									}
								}
					    	}
					    }
					    boolean res = true;
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( echec(this,listPiece.get(cpt)))
							{
								if ( c.getAbscisse() + x != listPiece.get(cpt).getAbscisse() &&  c.getOrdonnee() + y != listPiece.get(cpt).getOrdonnee())
								{
									res = false;
								}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							
						}
						return res;
				 }
				 else
					 return false; // Le déplacement n'est pas valide.
			 }
			 return false;
		 }
		 
		 public void DeplacerPiece(Piece p, int x, int y)
		 {
			
				 if ( DeplacementEstValide(p,x,y))
				 {
					 this.enlevePiece(p);
			 		 this.tab[x][y]=p;
			 		 p.setAbscisse(x);
			 		 p.setOrdonnee(y);
			 		 if ( p instanceof Pion && p.getPremierMouvement())
			 		 {
			 			 p.setPremierMouvement(false);
			 		 }
			 		 Piece d = this.Promotion(p);
			 		 if ( echec(this,p))
			 		 {
			 			 System.out.println("Vous étes en ECHEC !!!!");
			 		 
			 		 	if ( echecEtMat(this,p))
			 		 	{
			 		 		 System.out.println("Vous étes  ECHEC et MAT !!!!");
			 		 		 if ( p.getC().equals("noir"))
			 		 		 {
			 		 			 setWinner("noir");
			 		 		 }
			 		 		 else
			 		 		 {
			 		 			setWinner("blanc");
			 		 		 }
			 		 	}
			 		 }
				 }
			 	else
			 		System.out.println( "Mouvement impossible");
			 
		 }
		 
		 
		 /**
		  * méthode mettant a null la case d'origine d'une piece qui s'est déplacée.
		  */
		 
		 public	void enlevePiece(Piece p) 
		 {
			if (this.tab[p.getAbscisse()][p.getOrdonnee()]!=null)
			{
				this.tab[p.getAbscisse()][p.getOrdonnee()]= null;
			}
		 }
		 
		 
		 
		public boolean echec(Echiquier ech, Piece p1)
		 {
			 this.setRois();
			 boolean res = false;
			 if ( p1.getC().equals("blanc"))
			 {
				 this.getRoiN();
				 if(DeplacementEstValide(p1, ech.getRoiN().getAbscisse(),ech.getRoiN().getOrdonnee()))
					 	res = true;
			 }
			 else
				 this.getRoiB();
				 if(DeplacementEstValide(p1, ech.getRoiB().getAbscisse(),ech.getRoiB().getOrdonnee()))
					 	res = true;
			 return res;
		 }
		
		public boolean echecEtMat( Echiquier ech, Piece p1)
		 {
			 this.setRois();
			 boolean res = true;
			 
				 if ( p1.getC().equals("blanc"))
				 {
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()+1,ech.getRoiN().getOrdonnee()))// J avance de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()+1,ech.getRoiN().getOrdonnee()+1))// J avance de une ligne et une colonne.
						{
						return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()+1,ech.getRoiN().getOrdonnee()-1))// J avance de une ligne et recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
					 	if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse(),ech.getRoiN().getOrdonnee()+1))// J avance de une colonne.
					 	{
					 		return false;
					 	}
					}
					catch(ArrayIndexOutOfBoundsException e){};
				 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse(),ech.getRoiN().getOrdonnee()-1))// Je recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					
					try
					{	
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()-1,ech.getRoiN().getOrdonnee()))// Je recule de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()-1,ech.getRoiN().getOrdonnee()-1))// Je recule de une ligne et une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()-1,ech.getRoiN().getOrdonnee()+1))// Je recule de une ligne et avance de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					
					ArrayList<Piece> p = new ArrayList<Piece>();
					 for(int i=0;i<8;i++)
					{
							for(int j=0;j<8;j++)
							{
								if ((estOccupee(i,j)))
								{
									if (getTab(i,j).getC().equals("noir"))
									{									
										p.add(getTab(i,j));
									}
								}
							}
					}	
					
					
					for ( int i = 0; i < p.size(); i++)
					{
						if ( DeplacementEstValide(p.get(i),p1.getAbscisse(),p1.getOrdonnee()))// Si une pièce noire peut manger la pièce mettant le roi noir en echec
						{																	  // Il n'y a alors pas echec et mat.
							res = false;
						}
					}
					if ( res == false)
					{
						return res;
					}
					if ( p1 instanceof Fou)
					{
						if  ( p1.getAbscisse() > ech.getRoiN().getAbscisse() && p1.getOrdonnee() < ech.getRoiN().getOrdonnee()) // Mouvement du haut vers le bas à droite
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() -1;
								int ord = p1.getOrdonnee()+1;
								while ( abs >= ech.getRoiN().getAbscisse()+1 && ord <= ech.getRoiN().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									abs --;
									ord ++;
								}
								
							}
							return res;
						}
						
						if  ( p1.getAbscisse() > ech.getRoiN().getAbscisse() && p1.getOrdonnee() > ech.getRoiN().getOrdonnee()) // Mouvement du haut vers le bas à gauche
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() -1;
								int ord = p1.getOrdonnee()-1;
								while ( abs >= ech.getRoiN().getAbscisse()+1 && ord >= ech.getRoiN().getOrdonnee()+1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									abs --;
									ord --;
								}	
							}
							return res;
						}
						
						if  ( p1.getAbscisse() < ech.getRoiN().getAbscisse() && p1.getOrdonnee() < ech.getRoiN().getOrdonnee()) // Mouvement du bas vers le haut à droite
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() +1;
								int ord = p1.getOrdonnee()+1;
								while ( abs <= ech.getRoiN().getAbscisse()-1 && ord <= ech.getRoiN().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{										
										res = false;
									}
									abs ++;
									ord ++;
								}	
							}
							return res;
						}
						

						if  ( p1.getAbscisse() < ech.getRoiN().getAbscisse() && p1.getOrdonnee() > ech.getRoiN().getOrdonnee()) // Mouvement du bas vers le haut à gauche
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() +1;
								int ord = p1.getOrdonnee()-1;
								while ( abs <= ech.getRoiN().getAbscisse()-1 && ord >= ech.getRoiN().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									abs ++;
									ord --;
								}	
							}
							return res;
						}
					
					}
					
					if ( p1 instanceof Tour )
					{
						if ( p1.getAbscisse() == ech.getRoiN().getAbscisse() && p1.getOrdonnee() < ech.getRoiN().getOrdonnee())// gauche vers droite
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse();
								int ord = p1.getOrdonnee()+1;
								while ( ord <= ech.getRoiN().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									ord ++;
								}	
							}
							return res;
						}
						
						if ( p1.getAbscisse() == ech.getRoiN().getAbscisse() && p1.getOrdonnee() > ech.getRoiN().getOrdonnee())// droite vers gauche
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse();
								int ord = p1.getOrdonnee()-1;
								while ( ord >= ech.getRoiN().getOrdonnee()+1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									ord --;
								}	
							}
							return res;
						}
					
					if ( p1.getAbscisse() > ech.getRoiN().getAbscisse() && p1.getOrdonnee() == ech.getRoiN().getOrdonnee()) // haut vers bas
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse()-1;
							int ord = p1.getOrdonnee();
							while ( abs >= ech.getRoiN().getAbscisse()+1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs --;
							}	
						}
						return res;
					}
					
					if ( p1.getAbscisse() < ech.getRoiN().getAbscisse() && p1.getOrdonnee() == ech.getRoiN().getOrdonnee())// bas vers haut
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse()+1;
							int ord = p1.getOrdonnee();
							while (abs <= ech.getRoiN().getAbscisse()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs ++;
							}	
						}
						return res;
					}
				}
			   if ( p1 instanceof Dame )
			   {
				   if  ( p1.getAbscisse() > ech.getRoiN().getAbscisse() && p1.getOrdonnee() < ech.getRoiN().getOrdonnee()) // Mouvement du haut vers le bas à droite
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() -1;
							int ord = p1.getOrdonnee()+1;
							while ( abs >= ech.getRoiN().getAbscisse()+1 && ord <= ech.getRoiN().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs --;
								ord ++;
							}
							
						}
						return res;
					}
					
					if  ( p1.getAbscisse() > ech.getRoiN().getAbscisse() && p1.getOrdonnee() > ech.getRoiN().getOrdonnee()) // Mouvement du haut vers le bas à gauche
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() -1;
							int ord = p1.getOrdonnee()-1;
							while ( abs >= ech.getRoiN().getAbscisse()+1 && ord >= ech.getRoiN().getOrdonnee()+1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs --;
								ord --;
							}	
						}
						return res;
					}
					
					if  ( p1.getAbscisse() < ech.getRoiN().getAbscisse() && p1.getOrdonnee() < ech.getRoiN().getOrdonnee()) // Mouvement du bas vers le haut à droite
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() +1;
							int ord = p1.getOrdonnee()+1;
							while ( abs <= ech.getRoiN().getAbscisse()-1 && ord <= ech.getRoiN().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{										
									res = false;
								}
								abs ++;
								ord ++;
							}	
						}
						return res;
					}
					

					if  ( p1.getAbscisse() < ech.getRoiN().getAbscisse() && p1.getOrdonnee() > ech.getRoiN().getOrdonnee()) // Mouvement du bas vers le haut à gauche
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() +1;
							int ord = p1.getOrdonnee()-1;
							while ( abs <= ech.getRoiN().getAbscisse()-1 && ord >= ech.getRoiN().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs ++;
								ord --;
							}	
						}
						return res;
					}
					
					if ( p1.getAbscisse() == ech.getRoiN().getAbscisse() && p1.getOrdonnee() < ech.getRoiN().getOrdonnee())// gauche vers droite
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse();
							int ord = p1.getOrdonnee()+1;
							while ( ord <= ech.getRoiN().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								ord ++;
							}	
						}
						return res;
					}
					
					if ( p1.getAbscisse() == ech.getRoiN().getAbscisse() && p1.getOrdonnee() > ech.getRoiN().getOrdonnee())// droite vers gauche
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse();
							int ord = p1.getOrdonnee()-1;
							while ( ord >= ech.getRoiN().getOrdonnee()+1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								ord --;
							}	
						}
						return res;
					}
				
				if ( p1.getAbscisse() > ech.getRoiN().getAbscisse() && p1.getOrdonnee() == ech.getRoiN().getOrdonnee()) // haut vers bas
				{
					for ( int i = 0; i < p.size(); i++ )
					{
				
						int abs = p1.getAbscisse()-1;
						int ord = p1.getOrdonnee();
						while ( abs >= ech.getRoiN().getAbscisse()+1 && res != false)
						{
							if ( DeplacementEstValide(p.get(i),abs,ord))
							{
								res = false;
							}
							abs --;
						}	
					}
					return res;
				}
				
				if ( p1.getAbscisse() < ech.getRoiN().getAbscisse() && p1.getOrdonnee() == ech.getRoiN().getOrdonnee())// bas vers haut
				{
					for ( int i = 0; i < p.size(); i++ )
					{
				
						int abs = p1.getAbscisse()+1;
						int ord = p1.getOrdonnee();
						while (abs <= ech.getRoiN().getAbscisse()-1 && res != false)
						{
							if ( DeplacementEstValide(p.get(i),abs,ord))
							{
								res = false;
							}
							abs ++;
						}	
					}
					return res;
				 }
			  }
			   return res;
		    }
			else
			{
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()+1,ech.getRoiB().getOrdonnee()))// J avance de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()+1,ech.getRoiB().getOrdonnee()+1))// J avance de une ligne et une colonne.
						{
						return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()+1,ech.getRoiB().getOrdonnee()-1))// J avance de une ligne et recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
					 	if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse(),ech.getRoiB().getOrdonnee()+1))// J avance de une colonne.
					 	{
					 		return false;
					 	}
					}
					catch(ArrayIndexOutOfBoundsException e){};
				 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse(),ech.getRoiB().getOrdonnee()-1))// Je recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					
					try
					{	
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()-1,ech.getRoiB().getOrdonnee()))// Je recule de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()-1,ech.getRoiB().getOrdonnee()-1))// Je recule de une ligne et une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()-1,ech.getRoiB().getOrdonnee()+1))// Je recule de une ligne et avance de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException e){};
					
					ArrayList<Piece> p = new ArrayList<Piece>();
					 for(int i=0;i<8;i++)
					{
							for(int j=0;j<8;j++)
							{
								if ((estOccupee(i,j)))
								{
									if (getTab(i,j).getC().equals("blanc"))
									{									
										p.add(getTab(i,j));
									}
								}
							}
					}	
					
					
					for ( int i = 0; i < p.size(); i++)
					{
						if ( DeplacementEstValide(p.get(i),p1.getAbscisse(),p1.getOrdonnee()))// Si une pièce noire peut manger la pièce mettant le roi noir en echec
						{																	  // Il n'y a alors pas echec et mat.
							res = false;
						}
					}
					if ( res == false)
					{
						return res;
					}
					if ( p1 instanceof Fou)
					{
						if  ( p1.getAbscisse() > ech.getRoiB().getAbscisse() && p1.getOrdonnee() < ech.getRoiB().getOrdonnee()) // Mouvement du haut vers le bas à droite
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() -1;
								int ord = p1.getOrdonnee()+1;
								while ( abs >= ech.getRoiB().getAbscisse()+1 && ord <= ech.getRoiB().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									abs --;
									ord ++;
								}
								
							}
							return res;
						}
						
						if  ( p1.getAbscisse() > ech.getRoiB().getAbscisse() && p1.getOrdonnee() > ech.getRoiB().getOrdonnee()) // Mouvement du haut vers le bas à gauche
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() -1;
								int ord = p1.getOrdonnee()-1;
								while ( abs >= ech.getRoiB().getAbscisse()+1 && ord >= ech.getRoiB().getOrdonnee()+1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									abs --;
									ord --;
								}	
							}
							return res;
						}
						
						if  ( p1.getAbscisse() < ech.getRoiB().getAbscisse() && p1.getOrdonnee() < ech.getRoiB().getOrdonnee()) // Mouvement du bas vers le haut à droite
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() +1;
								int ord = p1.getOrdonnee()+1;
								while ( abs <= ech.getRoiB().getAbscisse()-1 && ord <= ech.getRoiB().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{										
										res = false;
									}
									abs ++;
									ord ++;
								}	
							}
							return res;
						}
						

						if  ( p1.getAbscisse() < ech.getRoiB().getAbscisse() && p1.getOrdonnee() > ech.getRoiB().getOrdonnee()) // Mouvement du bas vers le haut à gauche
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse() +1;
								int ord = p1.getOrdonnee()-1;
								while ( abs <= ech.getRoiB().getAbscisse()-1 && ord >= ech.getRoiB().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									abs ++;
									ord --;
								}	
							}
							return res;
						}
					
					}
					
					if ( p1 instanceof Tour )
					{
						if ( p1.getAbscisse() == ech.getRoiB().getAbscisse() && p1.getOrdonnee() < ech.getRoiB().getOrdonnee())// gauche vers droite
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse();
								int ord = p1.getOrdonnee()+1;
								while ( ord <= ech.getRoiB().getOrdonnee()-1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									ord ++;
								}	
							}
							return res;
						}
						
						if ( p1.getAbscisse() == ech.getRoiB().getAbscisse() && p1.getOrdonnee() > ech.getRoiB().getOrdonnee())// droite vers gauche
						{
							for ( int i = 0; i < p.size(); i++ )
							{
						
								int abs = p1.getAbscisse();
								int ord = p1.getOrdonnee()-1;
								while ( ord >= ech.getRoiB().getOrdonnee()+1 && res != false)
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
									ord --;
								}	
							}
							return res;
						}
					
					if ( p1.getAbscisse() > ech.getRoiB().getAbscisse() && p1.getOrdonnee() == ech.getRoiB().getOrdonnee()) // haut vers bas
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse()-1;
							int ord = p1.getOrdonnee();
							while ( abs >= ech.getRoiB().getAbscisse()+1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs --;
							}	
						}
						return res;
					}
					
					if ( p1.getAbscisse() < ech.getRoiB().getAbscisse() && p1.getOrdonnee() == ech.getRoiB().getOrdonnee())// bas vers haut
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse()+1;
							int ord = p1.getOrdonnee();
							while (abs <= ech.getRoiB().getAbscisse()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs ++;
							}	
						}
						return res;
					}
				}
			   if ( p1 instanceof Dame )
			   {
				   if  ( p1.getAbscisse() > ech.getRoiB().getAbscisse() && p1.getOrdonnee() < ech.getRoiB().getOrdonnee()) // Mouvement du haut vers le bas à droite
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() -1;
							int ord = p1.getOrdonnee()+1;
							while ( abs >= ech.getRoiB().getAbscisse()+1 && ord <= ech.getRoiB().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs --;
								ord ++;
							}
							
						}
						return res;
					}
					
					if  ( p1.getAbscisse() > ech.getRoiB().getAbscisse() && p1.getOrdonnee() > ech.getRoiB().getOrdonnee()) // Mouvement du haut vers le bas à gauche
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() -1;
							int ord = p1.getOrdonnee()-1;
							while ( abs >= ech.getRoiB().getAbscisse()+1 && ord >= ech.getRoiB().getOrdonnee()+1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs --;
								ord --;
							}	
						}
						return res;
					}
					
					if  ( p1.getAbscisse() < ech.getRoiB().getAbscisse() && p1.getOrdonnee() < ech.getRoiB().getOrdonnee()) // Mouvement du bas vers le haut à droite
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() +1;
							int ord = p1.getOrdonnee()+1;
							while ( abs <= ech.getRoiB().getAbscisse()-1 && ord <= ech.getRoiB().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{										
									res = false;
								}
								abs ++;
								ord ++;
							}	
						}
						return res;
					}
					

					if  ( p1.getAbscisse() < ech.getRoiB().getAbscisse() && p1.getOrdonnee() > ech.getRoiB().getOrdonnee()) // Mouvement du bas vers le haut à gauche
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse() +1;
							int ord = p1.getOrdonnee()-1;
							while ( abs <= ech.getRoiB().getAbscisse()-1 && ord >= ech.getRoiB().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								abs ++;
								ord --;
							}	
						}
						return res;
					}
					if ( p1.getAbscisse() == ech.getRoiB().getAbscisse() && p1.getOrdonnee() < ech.getRoiB().getOrdonnee())// gauche vers droite
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse();
							int ord = p1.getOrdonnee()+1;
							while ( ord <= ech.getRoiB().getOrdonnee()-1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								ord ++;
							}	
						}
						return res;
					}
					
					if ( p1.getAbscisse() == ech.getRoiB().getAbscisse() && p1.getOrdonnee() > ech.getRoiB().getOrdonnee())// droite vers gauche
					{
						for ( int i = 0; i < p.size(); i++ )
						{
					
							int abs = p1.getAbscisse();
							int ord = p1.getOrdonnee()-1;
							while ( ord >= ech.getRoiB().getOrdonnee()+1 && res != false)
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
								ord --;
							}	
						}
						return res;
					}
				
				if ( p1.getAbscisse() > ech.getRoiB().getAbscisse() && p1.getOrdonnee() == ech.getRoiB().getOrdonnee()) // haut vers bas
				{
					for ( int i = 0; i < p.size(); i++ )
					{
				
						int abs = p1.getAbscisse()-1;
						int ord = p1.getOrdonnee();
						while ( abs >= ech.getRoiB().getAbscisse()+1 && res != false)
						{
							if ( DeplacementEstValide(p.get(i),abs,ord))
							{
								res = false;
							}
							abs --;
						}	
					}
					return res;
				}
				
				if ( p1.getAbscisse() < ech.getRoiB().getAbscisse() && p1.getOrdonnee() == ech.getRoiB().getOrdonnee())// bas vers haut
				{
					for ( int i = 0; i < p.size(); i++ )
					{
				
						int abs = p1.getAbscisse()+1;
						int ord = p1.getOrdonnee();
						while (abs <= ech.getRoiB().getAbscisse()-1 && res != false)
						{
							if ( DeplacementEstValide(p.get(i),abs,ord))
							{
								res = false;
							}
							abs ++;
						}	
					}
					return res;
				 }
			 }
			return res;
		 }
	 }



		public String getWinner() {
			return winner;
		}



		public void setWinner(String winner) {
			this.winner = winner;
		}

		public Piece Promotion ( Piece p)
		{
			if ( p instanceof Pion )
			{
				Scanner sc = new Scanner (System.in);
				String rep = "";
				boolean res = false;
				Dame d = null;
				if ( p.getC().equals("noir"))
				{
					if ( p.getAbscisse() == 7)
					{
						do 
						{
							System.out.println("Veuillez choisir la pièce que vous voulez échanger contre votre pion");
							rep = sc.nextLine();
							rep.toUpperCase();
							switch(rep)
							{
								case "DAME":
									 d = new Dame("ND", "noir", p.getAbscisse(), p.getOrdonnee(), true  );
									this.setTab(d);
									res = true;
									break;
								case "CAVALIER":
									Cavalier c = new Cavalier( (Cavalier) (p) );
									res = true;
									break;
								case "TOUR":
									Tour t = new Tour( (Tour) (p) );
									res = true;
									break;
								case "FOU":
									Fou f = new Fou( (Fou) (p) );
									res = true;
									break;
							
							}
						}while(!(res));
					}
				}
				return d;
			}
			return null;
		}
		
		public boolean pat(Jouer j1)
		{
			boolean res = true;
			ArrayList<Piece>p;
			if ( j1.getJ().equals("noir"))
			{
				p = new ArrayList<Piece>();
				 for(int i=0;i<8;i++)
					{
							for(int j=0;j<8;j++)
							{
								if ((estOccupee(i,j)))
								{
									if (getTab(i,j).getC().equals("noir"))
									{									
										p.add(getTab(i,j));
									}
								}
							}
					}	
					
				 	//int i = 0;
					//while ( i < 8 && res != false)
					   
					
				 
				 	
				
			}
			
			return false;
		}
		 
}
