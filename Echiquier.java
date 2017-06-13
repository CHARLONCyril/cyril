package Echec;


import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;



/**
 * 
 * Définit un échiquier
 *
 */

public class Echiquier 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Tableau de pièce.
	 */
	Piece [][] tab;
	
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
	
	public Echiquier ( Echiquier e )
	{
		this.tab = new Piece [8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				tab[i][j]=null;
			}
		}
		for ( int i = 0; i < 8 ; i ++)
		{
			for ( int j = 0; j < 8 ; j ++ )
			{
				if ( e.estOccupee(i, j))
				{
					
					if (( e.getTab(i, j).getNom().equals("NT")))
					{
						Tour t = new Tour((Tour)e.getTab(i, j));
						this.setTab(t);
						
					}
					
					else if (( e.getTab(i, j).getNom().equals("NF")))
					{
						Fou f = new Fou((Fou)e.getTab(i, j));
						this.setTab(f);
						
						
					}
				
					else if (( e.getTab(i, j).getNom().equals("NC")))
				{
					
					
						Cavalier c = new Cavalier((Cavalier)e.getTab(i, j));
						this.setTab(c);
					
				}
				
					else if (( e.getTab(i, j).getNom().equals("ND")))
				{
					
						Dame d  = new Dame ( ( Dame)e.getTab(i, j));
						this.setTab(d);
					
					
				}
					else if (( e.getTab(i, j).getNom().equals("NR")))
				{
					
						Roi r  = new Roi  ( ( Roi)e.getTab(i, j));
						this.setTab(r);
					
					
				}
				
					else if (( e.getTab(i, j).getNom().equals("NP")))
				{
						Pion p = new Pion ( ( Pion)e.getTab(i, j));
						this.setTab(p);
					
					
				}
				
					else if (( e.getTab(i, j).getNom().equals("BT")))
				{
					
						Tour t = new Tour ( (Tour)e.getTab(i, j));
						this.setTab(t);
					
					
				}
					else if (( e.getTab(i, j).getNom().equals("BF")))
				{
					
						Fou f  = new Fou ( ( Fou )e.getTab(i, j));
						this.setTab(f);
					
					
				}
				
					else if (( e.getTab(i, j).getNom().equals("BC")))
				{
					
						Cavalier c = new Cavalier(( Cavalier)e.getTab(i, j));
						this.setTab(c);
					
					
				}
				
					else if (( e.getTab(i, j).getNom().equals("BD")))
				{
					
						Dame d  = new Dame ( ( Dame)e.getTab(i, j));
						this.setTab(d);
					
					
				}
					else if (( e.getTab(i, j).getNom().equals("BR")))
				{
					
						Roi r = new Roi ( ( Roi)e.getTab(i, j));
						this.setTab(r);
					
					
				}
				
					else  if (( e.getTab(i, j).getNom().equals("BP")))
				{
					
					
						Pion p   = new Pion ( ( Pion )e.getTab(i, j));
						this.setTab(p);
					
				}
				}
			}
		}
		setRois();
		this.winner = new String(e.getWinner());
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
			 //Echecquier avec toutes les Pieces
			/*setTab((new Tour("NT","noir",0,0,true,0)));
			
			setTab((new Cavalier("NC","noir",0,1,false,0)));
			setTab((new Fou("NF","noir",0,2,false,0)));
		   setTab((new Dame("ND","noir",0,3,false,0)));
		   setTab((new Roi("NR","noir",0,4,true,0)));
		  setTab((new Fou("NF","noir",0,5,false,0)));
		    setTab((new Cavalier("NC","noir",0,6,false,0)));
		setTab((new Tour("NT","noir",0,7,true,0)));
		    for(int i = 0; i <= 7; i++)
		    {
				setTab( new Pion("NP","noir",1, i,true,0));
				setTab( new Pion("BP","blanc",6, i,true,0));
			}
				
		  setTab((new Tour("BT","blanc",7,0,true,0)));
		 setTab(( new Cavalier("BC","blanc",7,1,false,0)));
		   setTab(( new Fou("BF","blanc",7,2,false,0)));
		    setTab((new Dame("BD","blanc",7,3,false,0)));
	        setTab(( new Roi("BR","blanc",7,4,true,0)));
	        setTab(( new Fou("BF","blanc",7,5,false,0)));
			setTab(( new Cavalier("BC","blanc",7,6,false,0)));
			setTab(( new Tour("BT","blanc",7,7,true,0)));  
			
	        */
			// Test pour l'échec et mat Blanc//
			
			/*setTab((new Tour("NT","noir",6,7,true,0)));
	        setTab((new Tour("NT","noir",0,0,true,0)));
	        setTab((new Roi("NR","noir",0,4,true,0)));
	        setTab(( new Roi("BR","blanc",7,4,true,0)));*/
	      	
	     // Test pour l'échec et mat Noir//
			/*
	     		setTab((new Tour("BT","blanc",1,1,true,0)));
	     	    setTab((new Tour("BT","blanc",1,6,true,0)));
	     	    setTab((new Roi("NR","noir",0,4,true,0)));
	     	    setTab(( new Roi("BR","blanc",7,4,true,0)));
	     	 */     	
			// Test pour le pat roi noir
			
			/*setTab((new Tour("BT","blanc",6,5,true,0)));
	        setTab((new Tour("BT","blanc",1,0,true,0)));
	        setTab((new Roi("NR","noir",0,7,true,0)));
	        setTab(( new Roi("BR","blanc",7,4,true,0)));
	        setTab((new Dame("BD","blanc",2,5,false,0)));*/
	      	
			
			//Test pour le pat roi blanc
			/*setTab((new Tour("NT","noir",6,5,true,0)));
	        setTab((new Tour("NT","noir",1,3,true,0)));
	        setTab((new Roi("NR","noir",0,7,true,0)));
	        setTab(( new Roi("BR","blanc",7,0,true,0)));*/
	        
			// test égualité
			/*setTab( new Tour("NT","noir",1, 7,true,0));
			setTab((new Roi("BR","blanc",0,6,true,0)));
        	setTab(( new Roi("NR","noir",7,4,true,0)));*/
        	
			
			// Le roque Noir
			/*setTab( new Tour("NT","noir",0,0 ,true,0));
			setTab((new Roi("BR","blanc",7,4,true,0)));
        	setTab(( new Roi("NR","noir",0,4,true,0)));
        	setTab((new Tour("NT","noir",0,7,true,0)));*/
			
			// Le roque Blanc
			/*setTab( new Tour("BT","blanc",7,0 ,true,0));
			setTab((new Roi("BR","blanc",7,4,true,0)));
			setTab(( new Roi("NR","noir",0,4,true,0)));
			setTab((new Tour("BT","blanc",7,7,true,0)));*/
			
			// La Promotion
			/*setTab( new Pion("NP","noir",6,0 ,true,0));
			setTab((new Roi("BR","blanc",7,4,true,0)));
        	setTab(( new Roi("NR","noir",0,4,true,0)));
        	setTab((new Pion("BP","blanc",1,6,true,0)));*/
        	
        	// La prisse en passant
        	/*setTab( new Pion("NP","noir",4,5 ,true,0));
			setTab((new Roi("BR","blanc",7,4,true,0)));
        	setTab(( new Roi("NR","noir",0,4,true,0)));
        	setTab((new Pion("BP","blanc",6,6,true,0)));*/
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
			 if (this.tab[x][y] != null)
			 {
				 return true;
			 }
			return false;
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
									if ( !(estOccupee(x, y)))
				 					{
				 					
				 						
				 						int absP = p.getAbscisse();
				 						int ordP = p.getOrdonnee();
				 						enlevePiece(p);
				 						Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 						this.setTab(p2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 						{
				 							res = false;
				 						}
				 						enlevePiece(p2);
				 						Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
				 						setTab(p3);
				 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 					setTab(r);
					 					
				 					}
				 					
				 					else
				 					{
				 						if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 						{
				 										 					
				 							if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 							{
				 								Dame d = new Dame ( (Dame)getTab(x, y));
				 						
				 								int absP = p.getAbscisse();
				 								int ordP = p.getOrdonnee();
				 								int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
				 								int ordD = d.getOrdonnee();
				 								ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Dame)
				 									{
				 										Dame da = (Dame) pi;
				 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
				 								enlevePiece(p);
				 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 								this.setTab(p2);
				 								try
				 								{
				 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								enlevePiece(p2);
				 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
				 								setTab(p3);
				 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 								setTab(r);
				 								Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 								setTab(d1);
				 							}
				 						
				 							if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 							{
				 								Tour t = new Tour ( (Tour)getTab(x, y));
				 						
				 								int absP = p.getAbscisse();
				 								int ordP = p.getOrdonnee();
				 								int absT = t.getAbscisse();// On sauve les coordonnées de la dame.
				 								int ordT = t.getOrdonnee();
				 								ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Tour)
				 									{
				 										Tour to  = (Tour) pi;
				 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
				 								enlevePiece(p);
				 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 								this.setTab(p2);
				 								
				 								try
				 								{
				 									if ( listPiece.get(cpt).getAbscisse() != t.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								enlevePiece(p2);
				 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
				 								setTab(p3);
				 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 								setTab(r);
				 								Tour t1 = new Tour("BT","blanc",absT,ordT,t.getPremierMouvement(),t.getMvt());
				 								setTab(t1);
				 							}
				 						
				 							if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 							{
				 								Fou f = new Fou ( (Fou)getTab(x, y));
				 						
				 								int absP = p.getAbscisse();
				 								int ordP = p.getOrdonnee();
				 								int absF = f.getAbscisse();// On sauve les coordonnées de la dame.
				 								int ordF = f.getOrdonnee();
				 								ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Fou)
				 									{
				 										Fou fo = (Fou) pi;
				 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
				 								enlevePiece(p);
				 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 								this.setTab(p2);
					 				
				 								try
				 								{
				 									if ( listPiece.get(cpt).getAbscisse() != f.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								
				 								enlevePiece(p2);
				 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
				 								setTab(p3);
				 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 								setTab(r);
				 								Fou f1 = new Fou("BF","blanc",absF,ordF,f.getPremierMouvement(),f.getMvt());
				 								setTab(f1);
				 							}
				 						
				 							if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 							{
				 								Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 								int absP = p.getAbscisse();
				 								int ordP = p.getOrdonnee();
				 								int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 								int ordC = ca.getOrdonnee();
				 								ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Cavalier)
				 									{
				 										Cavalier cav = (Cavalier) pi;
				 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
				 								enlevePiece(p);
				 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 								this.setTab(p2);
				 							
				 								try
				 								{
				 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								
				 								enlevePiece(p2);
				 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
				 								setTab(p3);
				 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 								setTab(r);
				 								Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 								setTab(c1);
				 							}
				 						
				 							if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 							{
				 								Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 								int absP = p.getAbscisse();
				 								int ordP = p.getOrdonnee();
				 								int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 								int ordPi = p4.getOrdonnee();
				 								ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pio = (Piece) ite.next();
				 									if ( pio instanceof Pion)
				 									{
				 										Pion pi = (Pion) ite.next();
				 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
				 								enlevePiece(p);
				 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 								this.setTab(p2);
					 				
				 								try
				 								{
				 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){} 
				 								
				 								enlevePiece(p2);
				 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
				 								setTab(p3);
				 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 								setTab(r);
				 								Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 								setTab(p5);
				 								
				 							}	
				 						}
				 					}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
						int c = 0;			 	
					 	this.setRois();
					 	while( c < listPiece.size() && res != false)
					 	{
					 				
					 				
					 				if (!( echec(this,listPiece.get(c))))
						 			{
					 					if ( !(estOccupee(x, y)))
					 					{
					 					
					 						
					 						int absP = p.getAbscisse();
					 						int ordP = p.getOrdonnee();
					 						enlevePiece(p);
					 						Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 						this.setTab(p2);
						 				
					 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 						{
					 							res = false;
					 						}
					 						enlevePiece(p2);
					 						Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 						setTab(p3);
					 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 					setTab(r);
						 					
					 					}
					 					
					 					else
					 					{
					 						if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
					 						{
					 										 					
					 							if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
					 							{
					 								Dame d = new Dame ( (Dame)getTab(x, y));
					 						
					 								int absP = p.getAbscisse();
					 								int ordP = p.getOrdonnee();
					 								int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
					 								int ordD = d.getOrdonnee();
					 								ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(p);
					 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 								this.setTab(p2);
						 				
					 								try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d.getAbscisse() && listPiece.get(c).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
					 								
					 								enlevePiece(p2);
					 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 								setTab(p3);
					 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 								setTab(r);
					 								Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
					 								setTab(d1);
					 							}
					 						
					 							if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
					 							{
					 								Tour t = new Tour ( (Tour)getTab(x, y));
					 						
					 								int absP = p.getAbscisse();
					 								int ordP = p.getOrdonnee();
					 								int absT = t.getAbscisse();// On sauve les coordonnées de la dame.
					 								int ordT = t.getOrdonnee();
					 								ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(p);
					 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 								this.setTab(p2);
						 				
					 								try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != t.getAbscisse() && listPiece.get(c).getOrdonnee() != t.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
					 								
					 								enlevePiece(p2);
					 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 								setTab(p3);
					 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 								setTab(r);
					 								Tour t1 = new Tour("BT","blanc",absT,ordT,t.getPremierMouvement(),t.getMvt());
					 								setTab(t1);
					 							}
					 						
					 							if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
					 							{
					 								Fou f = new Fou ( (Fou)getTab(x, y));
					 						
					 								int absP = p.getAbscisse();
					 								int ordP = p.getOrdonnee();
					 								int absF = f.getAbscisse();// On sauve les coordonnées de la dame.
					 								int ordF = f.getOrdonnee();
					 								ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(p);
					 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 								this.setTab(p2);
						 				
					 								try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f.getAbscisse() && listPiece.get(c).getOrdonnee() != f.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
					 								
					 								enlevePiece(p2);
					 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 								setTab(p3);
					 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 								setTab(r);
					 								Fou f1 = new Fou("BF","blanc",absF,ordF,f.getPremierMouvement(),f.getMvt());
					 								setTab(f1);
					 							}
					 						
					 							if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
					 							{
					 								Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
					 						
					 								int absP = p.getAbscisse();
					 								int ordP = p.getOrdonnee();
					 								int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
					 								int ordC = ca.getOrdonnee();
					 								ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(p);
					 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 								this.setTab(p2);
					 							
					 								try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
					 								
					 								enlevePiece(p2);
					 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 								setTab(p3);
					 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 								setTab(r);
					 								Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
					 								setTab(c1);
					 							}
					 						
					 							if ( getTab(x, y) instanceof Pion) // Si c'est un pion.
					 							{
					 								Pion p4 = new Pion ( (Pion)getTab(x, y));
					 						
					 								int absP = p.getAbscisse();
					 								int ordP = p.getOrdonnee();
					 								int absPi = p4.getAbscisse();// On sauve les coordonnées du Pion.
					 								int ordPi = p4.getOrdonnee();
					 								ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(p);
					 								Pion p2 = new Pion ("NP", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 								this.setTab(p2);
						 				
					 								try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
					 								
					 								enlevePiece(p2);
					 								Pion p3 = new Pion ("NP", "noir", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 								setTab(p3);
					 								Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 								setTab(r);
					 								Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
					 								setTab(p5);
					 							}	
					 						}
					 					}
						 			}
					 				c ++;
					 	}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
							return res;
						}
						 
						 if ( (x == p.getAbscisse()+1 && y == p.getOrdonnee()-1 ))
						 {
							 if (!(estOccupee(x, y)))
							 {
								 if ( estOccupee(p.getAbscisse(), p.getOrdonnee()-1))
								{
									 if (getTab(p.getAbscisse(), p.getOrdonnee()-1).getMvt() == 1)
									 {
										 return true;
									 }
								}
							 }
						 }
						 
						 if ( (x == p.getAbscisse()+1 && y == p.getOrdonnee()+1 ))
						 {
							 if (!(estOccupee(x, y)))
							 {
								 if ( estOccupee(p.getAbscisse(), p.getOrdonnee()+1))
								{
									 if (getTab(p.getAbscisse(), p.getOrdonnee()+1).getMvt() == 1)
									 {
										 return true;
									 }
								}
							 }
						 }
						 
						 
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
								if(!(estOccupee(x,y))) // Je ne peut pas manger si il n'y a pas de pièce à ma gauche.
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
							  
								if(!(estOccupee(x,y))) // Je ne peut pas manger si il n'y a pas de pièce à ma droite.
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
						
						
						return true;// Le déplacement du pion est correcte.
					 }
					 else
						 return false; // Le déplacement n'est pas valide.
						 
				 }
				 else // C'est un pion blanc
				 {
					 
					 if ( p.DeplacerPionBlanc(x,y)) // Si les coordonnées saisie par le joueur sont valides.
					 {
						 

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
								if ( !(estOccupee(x, y)))
			 					{
			 					
			 						int absP = p.getAbscisse();
			 						int ordP = p.getOrdonnee();
			 						enlevePiece(p);
			 						Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
			 						this.setTab(p2);
				 				
			 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 						{
			 							res = false;
			 						}
			 						enlevePiece(p2);
			 						Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
			 						setTab(p3);
			 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 					setTab(r);
			 					}
			 					
			 					else
			 					{
			 										 					
			 						if ( (getTab(x, y).getC().equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
			 						{				 					
			 							if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
			 							{
			 								Dame d = new Dame ( (Dame)getTab(x, y));
			 						
			 								int absP = p.getAbscisse();
			 								int ordP = p.getOrdonnee();
			 								int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
			 								int ordD = d.getOrdonnee();
			 								ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
			 								enlevePiece(p);
			 								Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
			 								this.setTab(p2);
				 				
			 								try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
			 								
			 								enlevePiece(p2);
			 								Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
			 								setTab(p3);
			 								Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 								setTab(r);
			 								Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
			 								setTab(d1);
			 							}
			 						
			 					
			 						
			 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
			 						{
			 							Tour t = new Tour ( (Tour)getTab(x, y));
			 						
			 							int absP = p.getAbscisse();
			 							int ordP = p.getOrdonnee();
			 							int absT = t.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordT = t.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Tour)
		 									{
		 										Tour to = (Tour) pi;
		 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(p);
			 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
			 							this.setTab(p2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != t.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
		 								
			 							enlevePiece(p2);
			 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
			 							setTab(p3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Tour t1 = new Tour("NT","noir",absT,ordT,t.getPremierMouvement(),t.getMvt());
			 							setTab(t1);
			 						}
			 						
			 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
			 						{
			 							Fou f = new Fou ( (Fou)getTab(x, y));
			 						
			 							int absP = p.getAbscisse();
			 							int ordP = p.getOrdonnee();
			 							int absF = f.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordF = f.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Fou)
		 									{
		 										Fou fo = (Fou) pi;
		 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(p);
			 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
			 							this.setTab(p2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != f.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
		 								
			 							enlevePiece(p2);
			 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
			 							setTab(p3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Fou f1 = new Fou("NF","noir",absF,ordF,f.getPremierMouvement(),f.getMvt());
			 							setTab(f1);
			 						}
			 						
			 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
			 						{
			 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
			 						
			 							int absP = p.getAbscisse();
			 							int ordP = p.getOrdonnee();
			 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordC = ca.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Cavalier)
		 									{
		 										Cavalier cav = (Cavalier) pi;
		 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(p);
			 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
			 							this.setTab(p2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
		 								
			 							enlevePiece(p2);
			 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
			 							setTab(p3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
			 							setTab(c1);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Pion) // Si c'est un Pion
			 						{
			 							Pion p4 = new Pion ( (Pion)getTab(x, y));
			 						
			 							int absP = p.getAbscisse();
			 							int ordP = p.getOrdonnee();
			 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordPi = p4.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pio = (Piece) ite.next();
		 									if ( pio instanceof Pion)
		 									{
		 										Pion pi = (Pion) pio;
		 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(p);
			 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
			 							this.setTab(p2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
		 								
			 							enlevePiece(p2);
			 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
			 							setTab(p3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
			 							setTab(p5);
			 						}
			 					}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
						
						
						int c = 0;			 	
					 	this.setRois();
					 	while( c < listPiece.size() && res != false)
					 	{
					 				
					 				
					 				if (!( echec(this,listPiece.get(c))))
						 			{
					 					if ( !(estOccupee(x, y)))
					 					{
					 					
					 						int absP = p.getAbscisse();
					 						int ordP = p.getOrdonnee();
					 						enlevePiece(p);
					 						Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 						this.setTab(p2);
						 				
					 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 						{
					 							res = false;
					 						}
					 						enlevePiece(p2);
					 						Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 						setTab(p3);
					 						/*Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 					setTab(r);*/
					 					}
					 					
					 					else
					 					{
					 										 					
					 						if ( (getTab(x, y).getC().equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
					 						{				 					
					 							if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
					 							{
					 								Dame d = new Dame ( (Dame)getTab(x, y));
					 						
					 								int absP = p.getAbscisse();
					 								int ordP = p.getOrdonnee();
					 								int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
					 								int ordD = d.getOrdonnee();
					 								ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(p);
					 								Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 								this.setTab(p2);
						 				
					 								try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d.getAbscisse() && listPiece.get(c).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
					 								
					 								enlevePiece(p2);
					 								Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 								setTab(p3);
					 								Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 								setTab(r);
					 								Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
					 								setTab(d1);
					 							}
					 						
					 					
					 						
					 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
					 						{
					 							Tour t = new Tour ( (Tour)getTab(x, y));
					 						
					 							int absP = p.getAbscisse();
					 							int ordP = p.getOrdonnee();
					 							int absT = t.getAbscisse();// On sauve les coordonnées de la dame.
					 							int ordT = t.getOrdonnee();
					 							ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Tour)
				 									{
				 										Tour to = (Tour) pi;
				 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
					 							enlevePiece(p);
					 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 							this.setTab(p2);
						 				
					 							try
				 								{
				 									if ( listPiece.get(c).getAbscisse() != t.getAbscisse() && listPiece.get(c).getOrdonnee() != t.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								
					 							enlevePiece(p2);
					 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 							setTab(p3);
					 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 							setTab(r);
					 							Tour t1 = new Tour("NT","noir",absT,ordT,t.getPremierMouvement(),t.getMvt());
					 							setTab(t1);
					 						}
					 						
					 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
					 						{
					 							Fou f = new Fou ( (Fou)getTab(x, y));
					 						
					 							int absP = p.getAbscisse();
					 							int ordP = p.getOrdonnee();
					 							int absF = f.getAbscisse();// On sauve les coordonnées du fou.
					 							int ordF = f.getOrdonnee();
					 							ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Fou)
				 									{
				 										Fou fo = (Fou)pi;
				 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
					 							enlevePiece(p);
					 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 							this.setTab(p2);
						 				
					 							try
				 								{
				 									if ( listPiece.get(c).getAbscisse() != f.getAbscisse() && listPiece.get(c).getOrdonnee() != f.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								
					 							enlevePiece(p2);
					 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 							setTab(p3);
					 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 							setTab(r);
					 							Fou f1 = new Fou("NF","noir",absF,ordF,f.getPremierMouvement(),f.getMvt());
					 							setTab(f1);
					 						}
					 						
					 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
					 						{
					 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
					 						
					 							int absP = p.getAbscisse();
					 							int ordP = p.getOrdonnee();
					 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
					 							int ordC = ca.getOrdonnee();
					 							ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Cavalier)
				 									{
				 										Cavalier cav = (Cavalier) pi;
				 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
					 							enlevePiece(p);
					 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 							this.setTab(p2);
						 				
					 							try
				 								{
				 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								
					 							enlevePiece(p2);
					 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 							setTab(p3);
					 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 							setTab(r);
					 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
					 							setTab(c1);
					 						}
					 						
					 						if ( getTab(x, y) instanceof Pion) // Si c'est un Pion.
					 						{
					 							Pion p4 = new Pion ( (Pion)getTab(x, y));
					 						
					 							int absP = p.getAbscisse();
					 							int ordP = p.getOrdonnee();
					 							int absP4 = p4.getAbscisse();// On sauve les coordonnées du pion.
					 							int ordP4 = p4.getOrdonnee();
					 							ListIterator<Piece> ite = listPiece.listIterator();
				 								while( ite.hasNext())
				 								{
				 									Piece pi = (Piece) ite.next();
				 									if ( pi instanceof Pion)
				 									{
				 										Pion pio = (Pion)pi;
				 										if ( pio.getAbscisse() == absP4 && pio.getOrdonnee() == ordP4)
				 										{
				 											ite.remove();
				 										}
				 									}
				 								}
					 							enlevePiece(p);
					 							Pion p2 = new Pion ("BP", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
					 							this.setTab(p2);
					 							try
				 								{
				 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
				 									{
				 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
				 										{
				 											res = false;
				 										}
				 									}
					 							}catch ( IndexOutOfBoundsException e){}
				 								
					 							enlevePiece(p2);
					 							Pion p3 = new Pion ("BP", "blanc", absP, ordP, p1.getPremierMouvement(),((Pion) p1).getMvt() );
					 							setTab(p3);
					 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 							setTab(r);
					 							Pion p5 = new Pion("NP","noir",absP4,ordP4,p4.getPremierMouvement(),p4.getMvt());
					 							setTab(p5);	
					 						}
					 					}
					 					
						 			}
					 					
						 	  }
					 		  c ++;
					 	}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
							return res;
						}
							
					
					 if ( (x == p.getAbscisse()-1 && y == p.getOrdonnee()-1 ))
					 {
						 if (!(estOccupee(x, y)))
						 {
							 if ( estOccupee(p.getAbscisse(), p.getOrdonnee()-1))
							{
								 if (getTab(p.getAbscisse(), p.getOrdonnee()-1).getMvt() == 1)
								 {
									 return true;
								 }
							}
						 }
					 }
					 
					 if ( (x == p.getAbscisse()-1 && y == p.getOrdonnee()+1 ))
					 {
						 if (!(estOccupee(x, y)))
						 {
							 if ( estOccupee(p.getAbscisse(), p.getOrdonnee()+1))
							{
								 if (getTab(p.getAbscisse(), p.getOrdonnee()+1).getMvt() == 1)
								 {
									 return true;
								 }
							}
						 }
					 }
					
					 	
					
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
								if(!(estOccupee(x,y))) // Je ne peut pas manger si il n'y a pas de pièce à ma gauche.
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
							   
								if(!(estOccupee(x,y))) // Je ne peut pas manger si il n'y a pas de pièce à ma droite.
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
						
						
						
						
						return true;// Le déplacement du pion est correcte.
					 }
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
							if (t.getC().equals("noir"))
						 	{
								if ( echec(this,listPiece.get(cpt)))
								{
								
									if ( !(estOccupee(x, y)))
				 					{
				 					
				 						
				 						int absP = t.getAbscisse();
				 						int ordP = t.getOrdonnee();
				 						enlevePiece(t);
				 						Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 						this.setTab(t2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 						{
				 							res = false;
				 						}
				 						enlevePiece(t2);
				 						Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 						setTab(t3);
				 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 					setTab(r);
				 					}
				 					
				 					else
				 					{
				 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 					{
				 										
				 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 						{
				 							Dame d = new Dame ( (Dame)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordD = d.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
			 								
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 							setTab(d1);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 						{
				 							Tour t1 = new Tour ( (Tour)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordT = t1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Tour)
			 									{
			 											Tour to = new Tour((Tour)pi);
			 											if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
			 											{
			 												ite.remove();
			 											}
			 										}
			 									
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour)p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Tour t4 = new Tour("BT","blanc",absT,ordT,t.getPremierMouvement(),t.getMvt());
				 							setTab(t4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 						{
				 							Fou f1 = new Fou ( (Fou)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordF = f1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Fou)
			 									{
			 										Fou fo = (Fou) pi;
			 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Fou f2 = new Fou("BF","blanc",absF,ordF,t.getPremierMouvement(),t.getMvt());
				 							setTab(f2);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 						{
				 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordC = ca.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Cavalier)
			 									{
			 										Cavalier cav = (Cavalier) pi;
			 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 							setTab(c1);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 						{
				 									
				 							Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordPi = p4.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pio = (Piece) ite.next();
			 									if ( pio instanceof Pion)
			 									{
			 										Pion pi = (Pion) ite.next();
			 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour  ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 							setTab(p5);
				 							listPiece.add(p5);
				 						}
				 					}
								
								}
						 	}
							else
							{
								if ( echec(this,listPiece.get(cpt)))
								{
									if ( !(estOccupee(x, y)))
				 					{
				 					
				 						
				 						int absP = t.getAbscisse();
				 						int ordP = t.getOrdonnee();
				 						enlevePiece(t);
				 						Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 						this.setTab(t2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
				 						{
				 							res = false;
				 						}
				 						enlevePiece(t2);
				 						Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 						setTab(t3);
				 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 					setTab(r);
				 					}
				 					
				 				else
				 				{
				 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 					{
				 										 					
				 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 						{
				 							Dame d = new Dame ( (Dame)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordD = d.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 							setTab(d1);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 						{
				 							Tour t1 = new Tour ( (Tour)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordT = t1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Tour)
			 									{
			 											Tour to = new Tour((Tour)pi);
			 											if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
			 											{
			 												ite.remove();
			 											}
			 										}
			 									
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Tour t4 = new Tour("NT","noir",absT,ordT,t.getPremierMouvement(),t.getMvt());
				 							setTab(t4);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 						{
				 							Fou f1 = new Fou ( (Fou)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordF = f1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Fou)
			 									{
			 										Fou fo = (Fou) pi;
			 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Fou f2 = new Fou("NF","noir",absF,ordF,t.getPremierMouvement(),t.getMvt());
				 							setTab(f2);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 						{
				 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordC = ca.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Cavalier)
			 									{
			 										Cavalier cav = (Cavalier) pi;
			 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 							setTab(c1);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 						{
				 							Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 							int absP = t.getAbscisse();
				 							int ordP = t.getOrdonnee();
				 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordPi = p4.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pio = (Piece) ite.next();
			 									if ( pio instanceof Pion)
			 									{
			 										Pion pi = (Pion) pio;
			 										if ( pi.getAbscisse() == absPi  && pi.getOrdonnee() == ordPi)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(t);
				 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
				 							this.setTab(t2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							
				 							enlevePiece(t2);
				 							Tour t3 = new Tour  ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
				 							setTab(t3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 							setTab(p5);
				 						}
				 					}
				 				}
					 			}
				 				
								
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
						
						
						int c = 0;			 	
					 	this.setRois();
					 	if (t.getC().equals("noir"))
					 	{
					 		while( c < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(c))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = t.getAbscisse();
						 						int ordP = t.getOrdonnee();
						 						enlevePiece(t);
						 						Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 						this.setTab(t2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(t2);
						 						Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 						setTab(t3);
						 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
							 					setTab(r);
						 					}
						 					
						 					else
						 					{
						 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{
						 										
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame)pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d.getAbscisse() && listPiece.get(c).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d1);
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != t1.getAbscisse() && listPiece.get(c).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour)p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("BT","blanc",absT,ordT,t.getPremierMouvement(),t.getMvt());
						 							setTab(t4);
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f1.getAbscisse() && listPiece.get(c).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f2 = new Fou("BF","blanc",absF,ordF,t.getPremierMouvement(),t.getMvt());
						 							setTab(f2);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 									
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("NT", "noir", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour  ("NT", "noir", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 						}
						 					}
							 			}
						 	}
						 				
						 				
						 				c ++;
						 	}
					 		
				 		}
					 	else
					 	{
					 		while( c < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(c))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = t.getAbscisse();
						 						int ordP = t.getOrdonnee();
						 						enlevePiece(t);
						 						Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 						this.setTab(t2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(t2);
						 						Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 						setTab(t3);
						 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
							 					setTab(r);
						 					}
						 					
						 				else
						 				{
						 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{
						 										 					
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d.getAbscisse() && listPiece.get(c).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d1);
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != t1.getAbscisse() && listPiece.get(c).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("NT","noir",absT,ordT,t.getPremierMouvement(),t.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f1.getAbscisse() && listPiece.get(c).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f2 = new Fou("NF","noir",absF,ordF,t.getPremierMouvement(),t.getMvt());
						 							setTab(f2);
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav  = (Cavalier)pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = t.getAbscisse();
						 							int ordP = t.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(t);
						 							Tour t2 = new Tour ("BT", "blanc", x, y, p1.getPremierMouvement(),((Tour) p1).getMvt());
						 							this.setTab(t2);
						 							
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(t2);
						 							Tour t3 = new Tour  ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Tour) p1).getMvt() );
						 							setTab(t3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 						}
						 					}
						 				}
							 	}
						 		c ++;
						 	}
					 		
					 	}
					 		
					
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
							return res;
						}

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
							if ( f.getC().equals("noir"))
							{
								if ( echec(this,listPiece.get(cpt)))
								{
									if ( !(estOccupee(x, y)))
				 					{
				 					
				 						
				 						int absP = f.getAbscisse();
				 						int ordP = f.getOrdonnee();
				 						enlevePiece(f);
				 						Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 						this.setTab(f2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 						{
				 							res = false;
				 						}
				 						enlevePiece(f2);
				 						Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 						setTab(f3);
				 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 					setTab(r);
				 					}
				 					else
				 					{
				 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 					{ 					
				 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 						{
				 							Dame d = new Dame ( (Dame)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordD = d.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 							setTab(d1);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 						{
				 							Tour t1 = new Tour ( (Tour)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordT = t1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Tour)
			 									{
			 										Tour to = (Tour) pi;
			 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Tour t4 = new Tour("BT","blanc",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
				 							setTab(t4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 						{
				 							Fou f1 = new Fou ( (Fou)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordF = f1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Fou)
			 									{
			 										Fou fo = (Fou) pi;
			 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Fou f4 = new Fou("BF","blanc",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
				 							setTab(f4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 						{
				 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordC = ca.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Cavalier)
			 									{
			 										Cavalier cav = (Cavalier) pi;
			 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 							setTab(c1);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 						{
				 									
				 							Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordPi = p4.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pio = (Piece) ite.next();
			 									if ( pio instanceof Pion)
			 									{
			 										Pion pi = (Pion) pio;
			 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou  ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 							setTab(p5);
				 							
				 						}
				 					}
					 			}
								}
							}
							else
							{
								if (!( echec(this,listPiece.get(cpt))))
					 			{
				 					if ( !(estOccupee(x, y)))
				 					{
				 					
				 						
				 						int absP = f.getAbscisse();
				 						int ordP = f.getOrdonnee();
				 						enlevePiece(f);
				 						Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 						this.setTab(f2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
				 						{
				 							res = false;
				 						}
				 						enlevePiece(f2);
				 						Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 						setTab(f3);
				 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
					 					setTab(r);
				 					}
				 					else
				 					{
				 						if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 						{
				 										 					
				 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 						{
				 							Dame d = new Dame ( (Dame)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordD = d.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 							setTab(d1);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 						{
				 							Tour t1 = new Tour ( (Tour)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordT = t1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Tour)
			 									{
			 										Tour to = (Tour) pi;
			 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Tour t4 = new Tour("NT","noir",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
				 							setTab(t4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 						{
				 							Fou f1 = new Fou ( (Fou)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordF = f1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Fou)
			 									{
			 										Fou fo = (Fou) pi;
			 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Fou f4 = new Fou("NF","noir",absF,ordF,f.getPremierMouvement(),f.getMvt());
				 							setTab(f4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 						{
				 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordC = ca.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Cavalier)
			 									{
			 										Cavalier cav = (Cavalier) pi;
			 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 							setTab(c1);
				 							listPiece.add(c1);
				 						}
				 						
				 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 						{
				 							Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 							int absP = f.getAbscisse();
				 							int ordP = f.getOrdonnee();
				 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordPi = p4.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pio = (Piece) ite.next();
			 									if ( pio instanceof Pion)
			 									{
			 										Pion pi = (Pion) pio;
			 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(f);
				 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
				 							this.setTab(f2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(f2);
				 							Fou f3 = new Fou  ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
				 							setTab(f3);
				 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 							setTab(r);
				 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 							setTab(p5);
				 						}
				 					}
					 			}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							return res;
						}
					 
						
						int c = 0;			 	
					 	this.setRois();
					 	if (f.getC().equals("noir"))
					 	{
					 		while( c < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(c))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = f.getAbscisse();
						 						int ordP = f.getOrdonnee();
						 						enlevePiece(f);
						 						Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 						this.setTab(f2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(f2);
						 						Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 						setTab(f3);
						 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
							 					setTab(r);
						 					}
						 					else
						 					{
						 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{ 					
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d.getAbscisse() && listPiece.get(c).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != t1.getAbscisse() && listPiece.get(c).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("BT","blanc",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f1.getAbscisse() && listPiece.get(c).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f4 = new Fou("BF","blanc",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
						 							setTab(f4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 									
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("NF", "noir", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou  ("NF", "noir", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 							
						 						}
						 					}
							 			}
							 			}
						 				
						 				c ++;
						 	}
					 		
				 		}
					 	else
					 	{
					 		while( c < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(c))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = f.getAbscisse();
						 						int ordP = f.getOrdonnee();
						 						enlevePiece(f);
						 						Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 						this.setTab(f2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(f2);
						 						Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 						setTab(f3);
						 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
							 					setTab(r);
						 					}
						 					else
						 					{
						 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{
						 										 					
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d.getAbscisse() && listPiece.get(c).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
					 								enlevePiece(f);
						 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
						 							
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != t1.getAbscisse() && listPiece.get(c).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("NT","noir",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f1.getAbscisse() && listPiece.get(c).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f4 = new Fou("NF","noir",absF,ordF,f.getPremierMouvement(),f.getMvt());
						 							setTab(f4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( ca.getAbscisse() == absC && ca.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou ("BF", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = f.getAbscisse();
						 							int ordP = f.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(f);
						 							Fou f2 = new Fou ("BF", "blanc", x, y, p1.getPremierMouvement(),((Fou) p1).getMvt());
						 							this.setTab(f2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(f2);
						 							Fou f3 = new Fou  ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Fou) p1).getMvt() );
						 							setTab(f3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 						}
						 					}
							 			}
							 			}
						 				
						 				c ++;
						 	}
					 	}
					 	}
						
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
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
					    int c = 0;	
					    boolean res = true;
					 	this.setRois();
					 	
					 	if (d.getC().equals("noir"))
					 	{
					 		
					 		while( c < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(c))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 						
						 						
						 						int absP = d.getAbscisse();
						 						int ordP = d.getOrdonnee();
						 						enlevePiece(d);
						 						
						 						Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 						this.setTab(d2);
						 						
						 							if ( echec(this,listPiece.get(c)))
						 							{
						 								res = false;
						 							}
						 						
						 						enlevePiece(d2);
						 						Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 						this.setTab(d3);
						 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
							 					this.setTab(r);
							 					
						 					}
						 					else
						 					{
						 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{ 	
						 						
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d1 = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absD = d1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
						 							{
						 								if ( listPiece.get(c).getAbscisse() != d1.getAbscisse() && listPiece.get(c).getOrdonnee() != d1.getOrdonnee())
						 								{
						 									if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
						 									{
						 										res = false;
						 									}
						 								}
						 							}catch( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Dame d4 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
						 							try
						 							{
						 								if ( listPiece.get(c).getAbscisse() != t1.getAbscisse() && listPiece.get(c).getOrdonnee() != t1.getOrdonnee())
						 								{
						 									if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
						 									{
						 										res = false;
						 									}
						 								}
						 							}catch( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("BT","blanc",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f1.getAbscisse() && listPiece.get(c).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f2 = new Fou("BF","blanc",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
						 							setTab(f2);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
						 							
						 							try
						 							{
						 								if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
						 								{
						 									if ( DeplacementEstValide(listPiece.get(c), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
						 									{
						 										res = false;
						 									}
						 								}
						 							}catch( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame)p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 									
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame  ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 							
						 						}
						 					}
							 			}
							 		}
						 				
						 				c ++;
						 	}
				 		}
					 	else
					 	{
					 		while( c < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(c))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = d.getAbscisse();
						 						int ordP = d.getOrdonnee();
						 						enlevePiece(d);
						 						Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 						this.setTab(d2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(d2);
						 						Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 						setTab(d3);
						 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
							 					setTab(r);
						 					}
						 					else
						 					{
						 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{
						 										 					
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d1 = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absD = d1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != d1.getAbscisse() && listPiece.get(c).getOrdonnee() != d1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Dame d4 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != t1.getAbscisse() && listPiece.get(c).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("NT","noir",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != f1.getAbscisse() && listPiece.get(c).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f2 = new Fou("NF","noir",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
						 							setTab(f2);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier )
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != ca.getAbscisse() && listPiece.get(c).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = d.getAbscisse();
						 							int ordP = d.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(d);
						 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
						 							this.setTab(d2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(c).getAbscisse() != p4.getAbscisse() && listPiece.get(c).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(c), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(d2);
						 							Dame d3 = new Dame  ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
						 							setTab(d3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 							
						 						}
						 					}
							 			}
							 			}
						 				
						 				c ++;
						 	}
					 	}
					 	
						
						if ( res == false)
						{
							
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
							return res;
						}
					    
						int cpt = 0;
						while ( cpt < listPiece.size() && res != false)
						{
							if ( d.getC().equals("noir"))
							{
								
								if ( echec(this,listPiece.get(cpt)))
								{
									if ( !(estOccupee(x, y)))
				 					{
										
				 						
				 						int absP = d.getAbscisse();
				 						int ordP = d.getOrdonnee();
				 						enlevePiece(d);
				 						Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
				 						this.setTab(d2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 						{
				 							
				 							res = false;
				 						}
				 						enlevePiece(d2);
				 						Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
				 						setTab(d3);
				 						Roi r = new Roi ( "NR","noir",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 					setTab(r);
				 					}
				 					else
				 					{
				 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 					{ 					
				 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 						{
				 							Dame d1 = new Dame ( (Dame)getTab(x, y));
				 						
				 							int absP = d.getAbscisse();
				 							int ordP = d.getOrdonnee();
				 							int absD = d1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordD = d1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(d);
				 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Pion) p1).getMvt());
				 							this.setTab(d2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(d2);
				 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
				 							setTab(d3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Dame d4 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 							setTab(d4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 						{
				 							Tour t1 = new Tour ( (Tour)getTab(x, y));
				 						
				 							int absP = d.getAbscisse();
				 							int ordP = d.getOrdonnee();
				 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordT = t1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Tour)
			 									{
			 										Tour to = (Tour) pi;
			 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(d);
				 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
				 							this.setTab(d2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(d2);
				 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
				 							setTab(d3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Tour t4 = new Tour("BT","blanc",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
				 							setTab(t4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 						{
				 							Fou f1 = new Fou ( (Fou)getTab(x, y));
				 						
				 							int absP = d.getAbscisse();
				 							int ordP = d.getOrdonnee();
				 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordF = f1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Fou)
			 									{
			 										Fou fo = (Fou) pi;
			 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(d);
				 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
				 							this.setTab(d2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(d2);
				 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
				 							setTab(d3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Fou f2 = new Fou("BF","blanc",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
				 							setTab(f2);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 						{
				 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 							int absP = d.getAbscisse();
				 							int ordP = d.getOrdonnee();
				 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordC = ca.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Cavalier)
			 									{
			 										Cavalier cav = (Cavalier) pi;
			 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(d);
				 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
				 							this.setTab(d2);
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(d2);
				 							Dame d3 = new Dame ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame)p1).getMvt() );
				 							setTab(d3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 							setTab(c1);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 						{
				 									
				 							Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 							int absP = d.getAbscisse();
				 							int ordP = d.getOrdonnee();
				 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordPi = p4.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pio = (Piece) ite.next();
			 									if ( pio instanceof Pion)
			 									{
			 										Pion pi = ( Pion ) pio;
			 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(d);
				 							Dame d2 = new Dame ("ND", "noir", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
				 							this.setTab(d2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(d2);
				 							Dame d3 = new Dame  ("ND", "noir", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
				 							setTab(d3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 							setTab(p5);
				 							
				 						}
				 					}
					 			}
								}
								cpt++;
							}
							else
							{
								
								if ( !(estOccupee(x, y)))
			 					{
									
			 						
			 						int absP = d.getAbscisse();
			 						int ordP = d.getOrdonnee();
			 						enlevePiece(d);
			 						Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
			 						this.setTab(d2);
				 				
			 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 						{
			 							
			 							res = false;
			 						}
			 						enlevePiece(d2);
			 						Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
			 						setTab(d3);
			 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 					setTab(r);
			 					}
			 					else
			 					{
			 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
			 					{
			 										 					
			 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
			 						{
			 							Dame d1 = new Dame ( (Dame)getTab(x, y));
			 						
			 							int absP = d.getAbscisse();
			 							int ordP = d.getOrdonnee();
			 							int absD = d1.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordD = d1.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Dame)
		 									{
		 										Dame da = (Dame) pi;
		 										if ( da.getAbscisse() == absD && d.getOrdonnee() == ordD)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(d);
			 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
			 							this.setTab(d2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != d1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d1.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(d2);
			 							Dame d3 = new Dame ("BT", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
			 							setTab(d3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Dame d4 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
			 							setTab(d4);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
			 						{
			 							Tour t1 = new Tour ( (Tour)getTab(x, y));
			 						
			 							int absP = d.getAbscisse();
			 							int ordP = d.getOrdonnee();
			 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordT = t1.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Tour)
		 									{
		 										Tour to = (Tour) pi;
		 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(d);
			 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
			 							this.setTab(d2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(d2);
			 							Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
			 							setTab(d3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Tour t4 = new Tour("NT","noir",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
			 							setTab(t4);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
			 						{
			 							Fou f1 = new Fou ( (Fou)getTab(x, y));
			 						
			 							int absP = d.getAbscisse();
			 							int ordP = d.getOrdonnee();
			 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordF = f1.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Fou)
		 									{
		 										Fou fo  = (Fou) pi;
		 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(d);
			 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
			 							this.setTab(d2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(d2);
			 							Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
			 							setTab(d3);
			 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
			 							setTab(r);
			 							Fou f2 = new Fou("NF","noir",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
			 							setTab(f2);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
			 						{
			 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
			 						
			 							int absP = d.getAbscisse();
			 							int ordP = d.getOrdonnee();
			 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordC = ca.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Cavalier)
		 									{
		 										Cavalier cav = (Cavalier) pi;
		 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(d);
			 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
			 							this.setTab(d2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(d2);
			 							Dame d3 = new Dame ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
			 							setTab(d3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
			 							setTab(c1);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
			 						{
			 							Pion p4 = new Pion ( (Pion)getTab(x, y));
			 						
			 							int absP = d.getAbscisse();
			 							int ordP = d.getOrdonnee();
			 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordPi = p4.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pio = (Piece) ite.next();
		 									if ( pio instanceof Pion)
		 									{
		 										Pion pi = (Pion) pio;
		 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(d);
			 							Dame d2 = new Dame ("BD", "blanc", x, y, p1.getPremierMouvement(),((Dame) p1).getMvt());
			 							this.setTab(d2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(d2);
			 							Dame d3 = new Dame  ("BD", "blanc", absP, ordP, p1.getPremierMouvement(),((Dame) p1).getMvt() );
			 							setTab(d3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
			 							setTab(p5);
			 							
			 						}
			 					}
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
						 
						 boolean roque = true;
						 int c = 0;
						 while ( c < p.size() && roque != false)
						 {
							 if ( echec(this,p.get(c)))
							 {
								 roque = false;
							 }
							 c++;
						 }
						 if ( roque)
						 {
							 if ( estOccupee(x, y))
							 {
								 if ( getTab(x,y) instanceof Tour && getTab(x,y).getC().equals("noir") && r.getPremierMouvement() && getTab(x, y).getPremierMouvement())
								 {
									 
									 int abs = r.getAbscisse();
									 int ord = r.getOrdonnee();
									 boolean res = true;
									 int cpt = 0;
									 if(ord > y)// droite vers gauche
									 {
							    		while( ord != y+1 && res != false )
						    			{
						    				if( this.estOccupee(x, ord-1))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
						    				{
						    					res = false;
						    				}
						    				while ( cpt < p.size() && res != false ) 
						    				{
						    					if ( DeplacementEstValide(p.get(cpt), x, ord-1))
						    					{
						    						res = false;
						    					}
						    					cpt++;
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
						    				
						    				while ( cpt < p.size() && res != false ) 
						    				{
						    					if ( DeplacementEstValide(p.get(cpt), x, ord+1))
						    					{
						    						res = false;
						    					}
						    					cpt++;
						    				}
						    				
						    				ord ++;
						    			}
							    		
						    			return res;
							    	}
								 
								 }
							 }
						 }
						 
						 
						 if(estOccupee(x, y) && r.equalsCouleur(getTab(x,y).getC())) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
							 return false;
						 
						
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
						 
						 boolean roque = true;
						 int c = 0;
						 while ( c < p.size() && roque != false)
						 {
							 if ( echec(this,p.get(c)))
							 {
								 roque = false;
							 }
							 c++;
						 }
						 System.out.println(roque);
						 if ( roque)
						 {
						 
							 if ( estOccupee(x, y))
							 {
								 if ( getTab(x,y) instanceof Tour && getTab(x,y).getC().equals("blanc") && r.getPremierMouvement() && getTab(x, y).getPremierMouvement())
								 {
									
									 int abs = r.getAbscisse();
									 int ord = r.getOrdonnee();
									 boolean res = true;
									 int cpt = 0;
									 if(ord > y)// droite vers gauche
									 {
							    		while( ord != y+1 && res != false )
						    			{
						    				if( this.estOccupee(x, ord-1))// Si la case est occcupée, mon chemin n'est pas valide car la tour ne peut pas enjambée des pièces.
						    				{
						    					res = false;
						    				}
						    				while ( cpt < p.size() && res != false ) 
						    				{
						    					if ( DeplacementEstValide(p.get(cpt), x, ord-1))
						    					{
						    						res = false;
						    					}
						    					cpt++;
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
						    				
						    				while ( cpt < p.size() && res != false ) 
						    				{
						    					if ( DeplacementEstValide(p.get(cpt), x, ord+1))
						    					{
						    						res = false;
						    					}
						    					cpt++;
						    				}
						    				
						    				ord ++;
						    			}
						    			return res;
							    	}
								 
								 }
							 }
						 }
						 
						 
						 
						 
						 if(estOccupee(x, y) && r.equalsCouleur(getTab(x,y).getC())) // Si le joueur veut placer une pièce à l'endroit d'une autre de ces pièces
							 return false;
						 
						 
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
							if ( c.getC().equals("noir"))
							{
								if ( echec(this,listPiece.get(cpt)))
								{
									if ( !(estOccupee(x, y)))
				 					{
				 					
										
				 						int absP = c.getAbscisse();
				 						int ordP = c.getOrdonnee();
				 						enlevePiece(c);
				 						Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
				 						this.setTab(c2);
					 				
				 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
				 						{
				 							res = false;
				 						}
				 						enlevePiece(c2);
				 						Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
				 						setTab(c3);
				 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
					 					setTab(r);
				 					}
				 					else
				 					{
				 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
				 					{ 					
				 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
				 						{
				 							Dame d = new Dame ( (Dame)getTab(x, y));
				 						
				 							int absP = c.getAbscisse();
				 							int ordP = c.getOrdonnee();
				 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordD = d.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Dame)
			 									{
			 										Dame da = (Dame) pi;
			 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(c);
				 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
				 							this.setTab(c2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(c2);
				 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
				 							setTab(c3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
				 							setTab(d1);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
				 						{
				 							Tour t1 = new Tour ( (Tour)getTab(x, y));
				 						
				 							int absP = c.getAbscisse();
				 							int ordP = c.getOrdonnee();
				 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordT = t1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Tour)
			 									{
			 										Tour to = (Tour) pi;
			 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(c);
				 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
				 							this.setTab(c2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(c2);
				 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
				 							setTab(c3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Tour t4 = new Tour("BT","blanc",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
				 							setTab(t4);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
				 						{
				 							Fou f1 = new Fou ( (Fou)getTab(x, y));
				 						
				 							int absP = c.getAbscisse();
				 							int ordP = c.getOrdonnee();
				 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordF = f1.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Fou)
			 									{
			 										Fou fo = (Fou) pi;
			 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(c);
				 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
				 							this.setTab(c2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(c2);
				 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
				 							setTab(c3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Fou f2 = new Fou("BF","blanc",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
				 							setTab(f2);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
				 						{
				 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
				 						
				 							int absP = c.getAbscisse();
				 							int ordP = c.getOrdonnee();
				 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordC = ca.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pi = (Piece) ite.next();
			 									if ( pi instanceof Cavalier)
			 									{
			 										Cavalier cav = (Cavalier) pi;
			 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(c);
				 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
				 							this.setTab(c2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(c2);
				 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
				 							setTab(c3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
				 							setTab(c1);
				 							
				 						}
				 						
				 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
				 						{
				 									
				 							Pion p4 = new Pion ( (Pion)getTab(x, y));
				 						
				 							int absP = c.getAbscisse();
				 							int ordP = c.getOrdonnee();
				 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
				 							int ordPi = p4.getOrdonnee();
				 							ListIterator<Piece> ite = listPiece.listIterator();
			 								while( ite.hasNext())
			 								{
			 									Piece pio = (Piece) ite.next();
			 									if ( pio instanceof Pion)
			 									{
			 										Pion pi = (Pion) pio;
			 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
			 										{
			 											ite.remove();
			 										}
			 									}
			 								}
				 							enlevePiece(c);
				 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
				 							this.setTab(c2);
					 				
				 							try
			 								{
			 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
			 									{
			 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
			 										{
			 											res = false;
			 										}
			 									}
				 							}catch ( IndexOutOfBoundsException e){}
				 							
				 							enlevePiece(c2);
				 							Cavalier c3 = new Cavalier  ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
				 							setTab(c3);
				 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
				 							setTab(r);
				 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
				 							setTab(p5);
				 							
				 						}
				 					}
								}
							}
							}
							else
							{
								if ( !(estOccupee(x, y)))
			 					{
			 					
			 						
			 						int absP = c.getAbscisse();
			 						int ordP = c.getOrdonnee();
			 						enlevePiece(c);
			 						Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
			 						this.setTab(c2);
				 				
			 						if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
			 						{
			 							res = false;
			 						}
			 						enlevePiece(c2);
			 						Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
			 						setTab(c3);
			 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
				 					setTab(r);
			 					}
			 					else
			 					{
			 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
			 					{
			 										 					
			 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
			 						{
			 							Dame d = new Dame ( (Dame)getTab(x, y));
			 						
			 							int absP = c.getAbscisse();
			 							int ordP = c.getOrdonnee();
			 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordD = d.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Dame)
		 									{
		 										Dame da = (Dame) pi;
		 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(c);
			 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
			 							this.setTab(c2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != d.getAbscisse() && listPiece.get(cpt).getOrdonnee() != d.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(c2);
			 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
			 							setTab(c3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
			 							setTab(d1);
			 						
			 						}
			 						
			 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
			 						{
			 							Tour t1 = new Tour ( (Tour)getTab(x, y));
			 						
			 							int absP = c.getAbscisse();
			 							int ordP = c.getOrdonnee();
			 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordT = t1.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Tour)
		 									{
		 										Tour to = (Tour) pi;
		 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(c);
			 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
			 							this.setTab(c2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != t1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != t1.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(c2);
			 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
			 							setTab(c3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Tour t4 = new Tour("NT","noir",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
			 							setTab(t4);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
			 						{
			 							Fou f1 = new Fou ( (Fou)getTab(x, y));
			 						
			 							int absP = c.getAbscisse();
			 							int ordP = c.getOrdonnee();
			 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordF = f1.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Cavalier)
		 									{
		 										Fou fo = (Fou) pi;
		 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(c);
			 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
			 							this.setTab(c2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != f1.getAbscisse() && listPiece.get(cpt).getOrdonnee() != f1.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(c2);
			 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
			 							setTab(c3);
			 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
			 							setTab(r);
			 							Fou f2 = new Fou("NF","noir",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
			 							setTab(f2);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
			 						{
			 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
			 						
			 							int absP = c.getAbscisse();
			 							int ordP = c.getOrdonnee();
			 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordC = ca.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pi = (Piece) ite.next();
		 									if ( pi instanceof Cavalier)
		 									{
		 										Cavalier cav = (Cavalier) pi;
		 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(c);
			 							Cavalier c2 = new Cavalier  ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
			 							this.setTab(c2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != ca.getAbscisse() && listPiece.get(cpt).getOrdonnee() != ca.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(c2);
			 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
			 							setTab(c3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
			 							setTab(c1);
			 							
			 						}
			 						
			 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
			 						{
			 							Pion p4 = new Pion ( (Pion)getTab(x, y));
			 						
			 							int absP = c.getAbscisse();
			 							int ordP = c.getOrdonnee();
			 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
			 							int ordPi = p4.getOrdonnee();
			 							ListIterator<Piece> ite = listPiece.listIterator();
		 								while( ite.hasNext())
		 								{
		 									Piece pio = (Piece) ite.next();
		 									if ( pio instanceof Pion)
		 									{
		 										Pion pi = (Pion) pio;
		 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
		 										{
		 											ite.remove();
		 										}
		 									}
		 								}
			 							enlevePiece(c);
			 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
			 							this.setTab(c2);
				 				
			 							try
		 								{
		 									if ( listPiece.get(cpt).getAbscisse() != p4.getAbscisse() && listPiece.get(cpt).getOrdonnee() != p4.getOrdonnee())
		 									{
		 										if ( DeplacementEstValide(listPiece.get(cpt), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
		 										{
		 											res = false;
		 										}
		 									}
			 							}catch ( IndexOutOfBoundsException e){}
			 							
			 							enlevePiece(c2);
			 							Cavalier c3 = new Cavalier  ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
			 							setTab(c3);
			 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
			 							setTab(r);
			 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
			 							setTab(p5);
			 							
			 						}
			 					}
							}
							cpt ++;
										
						}
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car votre roi est echec et que ce mouvement n'enlève pas l'échec");
							
						}
						
						int cp = 0;			 	
					 	this.setRois();
					 	if (c.getC().equals("noir"))
					 	{
					 		while( cp < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(cp))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = c.getAbscisse();
						 						int ordP = c.getOrdonnee();
						 						enlevePiece(c);
						 						Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 						this.setTab(c2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(cp), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(c2);
						 						Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 						setTab(c3);
						 						Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
							 					setTab(r);
						 					}
						 					else
						 					{
						 					if ( (getTab(x, y).getC().equals("blanc")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{ 					
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != d.getAbscisse() && listPiece.get(cp).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Dame d1 = new Dame("BD","blanc",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != t1.getAbscisse() && listPiece.get(cp).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("BT","blanc",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != f1.getAbscisse() && listPiece.get(cp).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f2 = new Fou("BF","blanc",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
						 							setTab(f2);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != ca.getAbscisse() && listPiece.get(cp).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("BC","blanc",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 									
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = ( Pion)pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("NC", "noir", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != p4.getAbscisse() && listPiece.get(cp).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiN().getAbscisse(), this.getRoiN().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier  ("NC", "noir", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("BP","blanc",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 							
						 						}
						 					}
							 			}
							 		}
						 				
						 		cp ++;
						 	}
					 		
				 		}
					 	else
					 	{
					 		while( cp < listPiece.size() && res != false)
						 	{
						 				
						 				
						 				if (!( echec(this,listPiece.get(cp))))
							 			{
						 					if ( !(estOccupee(x, y)))
						 					{
						 					
						 						
						 						int absP = c.getAbscisse();
						 						int ordP = c.getOrdonnee();
						 						enlevePiece(c);
						 						Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 						this.setTab(c2);
							 				
						 						if ( DeplacementEstValide(listPiece.get(cp), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
						 						{
						 							res = false;
						 						}
						 						enlevePiece(c2);
						 						Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 						setTab(c3);
						 						Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
							 					setTab(r);
						 					}
						 					else
						 					{
						 					if ( (getTab(x, y).equals("noir")))// Si la pièce de ma case d'arrivée n'a pas la même couleur que moi.
						 					{
						 										 					
						 						if ( getTab(x, y) instanceof Dame) // Si c'est une dame.
						 						{
						 							Dame d = new Dame ( (Dame)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absD = d.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordD = d.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Dame)
					 									{
					 										Dame da = (Dame) pi;
					 										if ( da.getAbscisse() == absD && da.getOrdonnee() == ordD)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != d.getAbscisse() && listPiece.get(cp).getOrdonnee() != d.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Dame d1 = new Dame("ND","noir",absD,ordD,d.getPremierMouvement(),d.getMvt());
						 							setTab(d1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Tour) // Si c'est une dame.
						 						{
						 							Tour t1 = new Tour ( (Tour)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absT = t1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordT = t1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Tour)
					 									{
					 										Tour to = (Tour) pi;
					 										if ( to.getAbscisse() == absT && to.getOrdonnee() == ordT)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != t1.getAbscisse() && listPiece.get(cp).getOrdonnee() != t1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Tour t4 = new Tour("NT","noir",absT,ordT,t1.getPremierMouvement(),t1.getMvt());
						 							setTab(t4);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Fou) // Si c'est une dame.
						 						{
						 							Fou f1 = new Fou ( (Fou)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absF = f1.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordF = f1.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Fou)
					 									{
					 										Fou fo = (Fou) pi;
					 										if ( fo.getAbscisse() == absF && fo.getOrdonnee() == ordF)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != f1.getAbscisse() && listPiece.get(cp).getOrdonnee() != f1.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "BR","blanc",this.getRoiB().getAbscisse(),this.getRoiB().getOrdonnee(),this.getRoiB().getPremierMouvement(),this.getRoiB().getMvt());
						 							setTab(r);
						 							Fou f2 = new Fou("NF","noir",absF,ordF,f1.getPremierMouvement(),f1.getMvt());
						 							setTab(f2);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Cavalier) // Si c'est une dame.
						 						{
						 							Cavalier ca = new Cavalier ( (Cavalier)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absC = ca.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordC = ca.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pi = (Piece) ite.next();
					 									if ( pi instanceof Cavalier)
					 									{
					 										Cavalier cav = (Cavalier) pi;
					 										if ( cav.getAbscisse() == absC && cav.getOrdonnee() == ordC)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier  ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != ca.getAbscisse() && listPiece.get(cp).getOrdonnee() != ca.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Cavalier c1 = new Cavalier("NC","noir",absC,ordC,ca.getPremierMouvement(),ca.getMvt());
						 							setTab(c1);
						 							
						 						}
						 						
						 						if ( getTab(x, y) instanceof Pion) // Si c'est une dame.
						 						{
						 							Pion p4 = new Pion ( (Pion)getTab(x, y));
						 						
						 							int absP = c.getAbscisse();
						 							int ordP = c.getOrdonnee();
						 							int absPi = p4.getAbscisse();// On sauve les coordonnées de la dame.
						 							int ordPi = p4.getOrdonnee();
						 							ListIterator<Piece> ite = listPiece.listIterator();
					 								while( ite.hasNext())
					 								{
					 									Piece pio = (Piece) ite.next();
					 									if ( pio instanceof Pion)
					 									{
					 										Pion pi = (Pion) pio;
					 										if ( pi.getAbscisse() == absPi && pi.getOrdonnee() == ordPi)
					 										{
					 											ite.remove();
					 										}
					 									}
					 								}
						 							enlevePiece(c);
						 							Cavalier c2 = new Cavalier ("BC", "blanc", x, y, p1.getPremierMouvement(),((Cavalier) p1).getMvt());
						 							this.setTab(c2);
							 				
						 							try
					 								{
					 									if ( listPiece.get(cp).getAbscisse() != p4.getAbscisse() && listPiece.get(cp).getOrdonnee() != p4.getOrdonnee())
					 									{
					 										if ( DeplacementEstValide(listPiece.get(cp), this.getRoiB().getAbscisse(), this.getRoiB().getOrdonnee()))
					 										{
					 											res = false;
					 										}
					 									}
						 							}catch ( IndexOutOfBoundsException e){}
						 							
						 							enlevePiece(c2);
						 							Cavalier c3 = new Cavalier  ("BC", "blanc", absP, ordP, p1.getPremierMouvement(),((Cavalier) p1).getMvt() );
						 							setTab(c3);
						 							Roi r = new Roi ( "NR","noir",this.getRoiN().getAbscisse(),this.getRoiN().getOrdonnee(),this.getRoiN().getPremierMouvement(),this.getRoiN().getMvt());
						 							setTab(r);
						 							Pion p5 = new Pion("NP","noir",absPi,ordPi,p4.getPremierMouvement(),p4.getMvt());
						 							setTab(p5);
						 							
						 						}
						 					}
							 			}
						 				
							 			}
						 		cp ++;
						 	}
					 		
					 	}
								
						if ( res == false)
						{
							System.out.println("Vous ne pouvez pas bouger cette pièce car vous mettriez votre roi en échec");
							return res;
						}
						
						return true;
				 }
			 
				 }
				 else
				 {
					return false; 
				 }
			 }
				 return false; 
			 }	 
				
			 
			 
		 
		 
		 public void DeplacerPiece(Piece p, int x, int y)
		 {
				 if ( DeplacementEstValide(p,x,y))
				 {
					
					 
					 if ( p instanceof Roi)
					 {
						 Roi r1 = new Roi ( ( Roi) p);
						 if ( r1.getC().equals("noir"))
						 {
						 if ( this.getTab(x,y) instanceof Tour && r1.getC().equals("noir") && this.getTab(x,y).getC().equals("noir"))
						 {
						 
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
							
								 
								 if ( r1.getOrdonnee() > this.getTab(x, y).getOrdonnee())
								 {
									 
									 boolean roqueEstPossible = true;
										int cpt = 0;
										while (cpt < listPiece.size() && roqueEstPossible != false )
										{
											if ( DeplacementEstValide(listPiece.get(cpt), 0, 2))
											{
												roqueEstPossible = false;
											}
											cpt ++;
										}
									 
										if (roqueEstPossible)
										{
											int absP = r1.getAbscisse();
											int ordP = r1.getOrdonnee();
											enlevePiece(r1);
											Roi r = new Roi ("NR","noir",absP,ordP-2,p.getPremierMouvement(),p.getMvt() );
											this.setTab(r);
											Tour t = new Tour ("NT","noir",absP,ordP-1,getTab(x,y).getPremierMouvement(),getTab(x, y).getMvt());
											this.setTab(t);
											System.out.println("Vous venez d'effectuer un roque");
											 enlevePiece(this.getTab(x, y));
											if ( echec(this,t))
											 {
												 System.out.println("Vous étes en ECHEC !!!!");
								 		 
												 if ( echecEtMat(this,t))
												 {
													 System.out.println("Vous étes  ECHEC et MAT !!!!");
											
													 if ( t.getC().equals("noir"))
													 {
														 setWinner("noir");
													 }
													 else
													 {
														 setWinner("blanc");
													 }
												 }
											 }
											else
											{
											if ( t.getC().equals("noir"))
											 {
											     
												 Jouer j1 = new Jouer( "blanc");
												 if ( pat(j1))
												 {
													 	ArrayList<Piece >pi = new ArrayList<Piece>();
													    for(int i=0;i<8;i++)
														{
													    	for(int j=0;j<8;j++)
													    	{
													    		if ((estOccupee(i,j)))
																{
													    			if (getTab(i,j).getC().equals("blanc"))
																	{									
																		pi.add(getTab(i,j));
																	}
																}
															}
														}
													    if ( pi.size() == 1 )
														{
															ArrayList<Piece>p2 = new ArrayList<Piece>();
															for(int i=0;i<8;i++)
															{
																		for(int j=0;j<8;j++)
																		{
																			if ((estOccupee(i,j)))
																			{
																				if (getTab(i,j).getC().equals("noir"))
																				{									
																					p2.add(getTab(i,j));
																				}
																			}
																		}
															}
															if ( p2.size() == 1)
															{
																System.out.println("Il n'y a plus que les rois sur l'échiquier.");
																setWinner("deuce");
															}
															else
														    {
														    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
														    	setWinner("null");
														    	
														    }
														}
													    else
													    {
													    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
													    	setWinner("null");
													    }
												 }
												 
											 }
											else
											 {
												 Jouer j1 = new Jouer( "noir");
												if ( pat(j1))
												{
														 	ArrayList<Piece >pi = new ArrayList<Piece>();
														    for(int i=0;i<8;i++)
															{
														    	for(int j=0;j<8;j++)
														    	{
														    		if ((estOccupee(i,j)))
																	{
														    			if (getTab(i,j).getC().equals("noir"))
																		{									
																			pi.add(getTab(i,j));
																		}
																	}
																}
															}
														    if ( pi.size() == 1 )
															{
																ArrayList<Piece>p2 = new ArrayList<Piece>();
																for(int i=0;i<8;i++)
																{
																			for(int j=0;j<8;j++)
																			{
																				if ((estOccupee(i,j)))
																				{
																					if (getTab(i,j).getC().equals("blanc"))
																					{									
																						p2.add(getTab(i,j));
																					}
																				}
																			}
																}
																if ( p2.size() == 1)
																{
																	System.out.println("Il n'y a plus que les rois sur l'échiquier.");
																	setWinner("deuce");
																}
																else
															    {
															    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
															    	setWinner("null");
															    	
															    }
															}
														    else
														    {
														    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
														    	setWinner("null");
														    }
													 }
												
											 }
											 
										 }
											
										}
										
										else
										{
											System.out.println("Vous ne pouvez pas effectuer de roque car vous mettriez votre roi en échec");
										}
								 }
								 else if ( r1.getOrdonnee() < this.getTab(x, y).getOrdonnee())
								 {
									 
									 boolean roqueEstPossible = true;
										int cpt = 0;
										while (cpt < listPiece.size() && roqueEstPossible != false )
										{
											if ( DeplacementEstValide(listPiece.get(cpt), 0, 6))
											{
												roqueEstPossible = false;
											}
											cpt ++;
										}
										
									if (roqueEstPossible)
									{
										
										int absP = r1.getAbscisse();
										int ordP = r1.getOrdonnee();
										enlevePiece(r1);
										Roi r = new Roi ("NR","noir",absP,ordP+2,p.getPremierMouvement(),p.getMvt() );
										this.setTab(r);
										Tour t = new Tour ("NT","noir",absP,ordP+1,getTab(x,y).getPremierMouvement(),getTab(x, y).getMvt());
										this.setTab(t);
										 enlevePiece(this.getTab(x, y));
										System.out.println("Vous venez d'effectuer un roque");
										if ( echec(this,t))
										 {
											 System.out.println("Vous étes en ECHEC !!!!");
							 		 
											 if ( echecEtMat(this,t))
											 {
												 System.out.println("Vous étes  ECHEC et MAT !!!!");
										
												 if ( t.getC().equals("noir"))
												 {
													 setWinner("noir");
												 }
												 else
												 {
													 setWinner("blanc");
												 }
											 }
										 }
										else
										{
										if ( t.getC().equals("noir"))
										 {
										     
											 Jouer j1 = new Jouer( "blanc");
											 if ( pat(j1))
											 {
												 	ArrayList<Piece >pi = new ArrayList<Piece>();
												    for(int i=0;i<8;i++)
													{
												    	for(int j=0;j<8;j++)
												    	{
												    		if ((estOccupee(i,j)))
															{
												    			if (getTab(i,j).getC().equals("blanc"))
																{									
																	pi.add(getTab(i,j));
																}
															}
														}
													}
												    if ( pi.size() == 1 )
													{
														ArrayList<Piece>p2 = new ArrayList<Piece>();
														for(int i=0;i<8;i++)
														{
																	for(int j=0;j<8;j++)
																	{
																		if ((estOccupee(i,j)))
																		{
																			if (getTab(i,j).getC().equals("noir"))
																			{									
																				p2.add(getTab(i,j));
																			}
																		}
																	}
														}
														if ( p2.size() == 1)
														{
															System.out.println("Il n'y a plus que les rois sur l'échiquier.");
															setWinner("deuce");
														}
														else
													    {
													    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
													    	setWinner("null");
													    	
													    }
													}
												    else
												    {
												    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
												    	setWinner("null");
												    }
											 }
											 
										 }
										else
										 {
											 Jouer j1 = new Jouer( "noir");
											if ( pat(j1))
											{
													 	ArrayList<Piece >pi = new ArrayList<Piece>();
													    for(int i=0;i<8;i++)
														{
													    	for(int j=0;j<8;j++)
													    	{
													    		if ((estOccupee(i,j)))
																{
													    			if (getTab(i,j).getC().equals("noir"))
																	{									
																		pi.add(getTab(i,j));
																	}
																}
															}
														}
													    if ( pi.size() == 1 )
														{
															ArrayList<Piece>p2 = new ArrayList<Piece>();
															for(int i=0;i<8;i++)
															{
																		for(int j=0;j<8;j++)
																		{
																			if ((estOccupee(i,j)))
																			{
																				if (getTab(i,j).getC().equals("blanc"))
																				{									
																					p2.add(getTab(i,j));
																				}
																			}
																		}
															}
															if ( p2.size() == 1)
															{
																System.out.println("Il n'y a plus que les rois sur l'échiquier.");
																setWinner("deuce");
															}
															else
														    {
														    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
														    	setWinner("null");
														    	
														    }
														}
													    else
													    {
													    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
													    	setWinner("null");
													    }
												 }
											
										 }
										 
									 }
										
									}
									else
									{
										System.out.println("Vous ne pouvez pas effectuer de roque car vous mettriez votre roi en échec");
									}
								 }
							 
						 }
						 else
						 {
							 
							 this.enlevePiece(p);
							 this.tab[x][y]=p;
							 p.setAbscisse(x);
							 p.setOrdonnee(y);
							 enlevePiece(this.getTab(x, y));
						 }
					 }
						 if ( this.getTab(x,y) instanceof Tour && r1.getC().equals("blanc") && this.getTab(x,y).getC().equals("blanc"))
						 { 
							 if ( r1.getC().equals("blanc") && this.getTab(x,y).getC().equals("blanc"))
							 {
								 System.out.println(this.getTab(x,y).getNom()+"/////////");
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
								 
								 if ( r1.getOrdonnee() > this.getTab(x, y).getOrdonnee())
								 {
									 boolean roqueEstPossible = true;
										int cpt = 0;
										while (cpt < listPiece.size() && roqueEstPossible != false )
										{
											if ( DeplacementEstValide(listPiece.get(cpt), 7, 2))
											{
												roqueEstPossible = false;
											}
											cpt ++;
										}
									 
										if (roqueEstPossible)
										{
											int absP = r1.getAbscisse();
											int ordP = r1.getOrdonnee();
											enlevePiece(r1);
											Roi r = new Roi ("BR","blanc",absP,ordP-2,p.getPremierMouvement(),p.getMvt() );
											this.setTab(r);
											Tour t = new Tour ("BT","blanc",absP,ordP-1,getTab(x,y).getPremierMouvement(),getTab(x, y).getMvt());
											this.setTab(t);
											 enlevePiece(this.getTab(x, y));
											System.out.println("Vous venez d'effectuer un roque");
											if ( echec(this,t))
											 {
												 System.out.println("Vous étes en ECHEC !!!!");
								 		 
												 if ( echecEtMat(this,t))
												 {
													 System.out.println("Vous étes  ECHEC et MAT !!!!");
											
													 if ( t.getC().equals("noir"))
													 {
														 setWinner("noir");
													 }
													 else
													 {
														 setWinner("blanc");
													 }
												 }
											 }
											else
											{
											if ( t.getC().equals("noir"))
											 {
											     
												 Jouer j1 = new Jouer( "blanc");
												 if ( pat(j1))
												 {
													 	ArrayList<Piece >pi = new ArrayList<Piece>();
													    for(int i=0;i<8;i++)
														{
													    	for(int j=0;j<8;j++)
													    	{
													    		if ((estOccupee(i,j)))
																{
													    			if (getTab(i,j).getC().equals("blanc"))
																	{									
																		pi.add(getTab(i,j));
																	}
																}
															}
														}
													    if ( pi.size() == 1 )
														{
															ArrayList<Piece>p2 = new ArrayList<Piece>();
															for(int i=0;i<8;i++)
															{
																		for(int j=0;j<8;j++)
																		{
																			if ((estOccupee(i,j)))
																			{
																				if (getTab(i,j).getC().equals("noir"))
																				{									
																					p2.add(getTab(i,j));
																				}
																			}
																		}
															}
															if ( p2.size() == 1)
															{
																System.out.println("Il n'y a plus que les rois sur l'échiquier.");
																setWinner("deuce");
															}
															else
														    {
														    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
														    	setWinner("null");
														    	
														    }
														}
													    else
													    {
													    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
													    	setWinner("null");
													    }
												 }
												 
											 }
											else
											 {
												 Jouer j1 = new Jouer( "noir");
												if ( pat(j1))
												{
														 	ArrayList<Piece >pi = new ArrayList<Piece>();
														    for(int i=0;i<8;i++)
															{
														    	for(int j=0;j<8;j++)
														    	{
														    		if ((estOccupee(i,j)))
																	{
														    			if (getTab(i,j).getC().equals("noir"))
																		{									
																			pi.add(getTab(i,j));
																		}
																	}
																}
															}
														    if ( pi.size() == 1 )
															{
																ArrayList<Piece>p2 = new ArrayList<Piece>();
																for(int i=0;i<8;i++)
																{
																			for(int j=0;j<8;j++)
																			{
																				if ((estOccupee(i,j)))
																				{
																					if (getTab(i,j).getC().equals("blanc"))
																					{									
																						p2.add(getTab(i,j));
																					}
																				}
																			}
																}
																if ( p2.size() == 1)
																{
																	System.out.println("Il n'y a plus que les rois sur l'échiquier.");
																	setWinner("deuce");
																}
																else
															    {
															    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
															    	setWinner("null");
															    	
															    }
															}
														    else
														    {
														    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
														    	setWinner("null");
														    }
													 }
												
											 }
											 
										 }
											
										}
										else
										{
											System.out.println("Vous ne pouvez pas effectuer de roque car vous mettriez votre roi en échec");
										}
								 }
								 else
								 {
									 
									 boolean roqueEstPossible = true;
										int cpt = 0;
										while (cpt < listPiece.size() && roqueEstPossible != false )
										{
											if ( DeplacementEstValide(listPiece.get(cpt), 7, 6))
											{
												roqueEstPossible = false;
											}
											cpt ++;
										}
										
									if (roqueEstPossible)
									{
									 
										int absP = r1.getAbscisse();
										int ordP = r1.getOrdonnee();
										enlevePiece(r1);
										Roi r = new Roi ("BR","blanc",absP,ordP+2,p.getPremierMouvement(),p.getMvt() );
										this.setTab(r);
										Tour t = new Tour ("BT","blanc",absP,ordP+1,getTab(x,y).getPremierMouvement(),getTab(x, y).getMvt());
										this.setTab(t);
										 enlevePiece(this.getTab(x, y));
										System.out.println("Vous venez d'effectuer un roque");
										if ( echec(this,t))
										 {
											 System.out.println("Vous étes en ECHEC !!!!");
							 		 
											 if ( echecEtMat(this,t))
											 {
												 System.out.println("Vous étes  ECHEC et MAT !!!!");
										
												 if ( t.getC().equals("noir"))
												 {
													 setWinner("noir");
												 }
												 else
												 {
													 setWinner("blanc");
												 }
											 }
										 }
										
										else
										{
										if ( t.getC().equals("noir"))
										 {
										     
											 Jouer j1 = new Jouer( "blanc");
											 if ( pat(j1))
											 {
												 	ArrayList<Piece >pi = new ArrayList<Piece>();
												    for(int i=0;i<8;i++)
													{
												    	for(int j=0;j<8;j++)
												    	{
												    		if ((estOccupee(i,j)))
															{
												    			if (getTab(i,j).getC().equals("blanc"))
																{									
																	pi.add(getTab(i,j));
																}
															}
														}
													}
												    if ( pi.size() == 1 )
													{
														ArrayList<Piece>p2 = new ArrayList<Piece>();
														for(int i=0;i<8;i++)
														{
																	for(int j=0;j<8;j++)
																	{
																		if ((estOccupee(i,j)))
																		{
																			if (getTab(i,j).getC().equals("noir"))
																			{									
																				p2.add(getTab(i,j));
																			}
																		}
																	}
														}
														if ( p2.size() == 1)
														{
															System.out.println("Il n'y a plus que les rois sur l'échiquier.");
															setWinner("deuce");
														}
														else
													    {
													    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
													    	setWinner("null");
													    	
													    }
													}
												    else
												    {
												    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
												    	setWinner("null");
												    }
											 }
											 
										 }
										else
										 {
											 Jouer j1 = new Jouer( "noir");
											if ( pat(j1))
											{
													 	ArrayList<Piece >pi = new ArrayList<Piece>();
													    for(int i=0;i<8;i++)
														{
													    	for(int j=0;j<8;j++)
													    	{
													    		if ((estOccupee(i,j)))
																{
													    			if (getTab(i,j).getC().equals("noir"))
																	{									
																		pi.add(getTab(i,j));
																	}
																}
															}
														}
													    if ( pi.size() == 1 )
														{
															ArrayList<Piece>p2 = new ArrayList<Piece>();
															for(int i=0;i<8;i++)
															{
																		for(int j=0;j<8;j++)
																		{
																			if ((estOccupee(i,j)))
																			{
																				if (getTab(i,j).getC().equals("blanc"))
																				{									
																					p2.add(getTab(i,j));
																				}
																			}
																		}
															}
															if ( p2.size() == 1)
															{
																System.out.println("Il n'y a plus que les rois sur l'échiquier.");
																setWinner("deuce");
															}
															else
														    {
														    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
														    	setWinner("null");
														    	
														    }
														}
													    else
													    {
													    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
													    	setWinner("null");
													    }
												 }
											
										 }
										 
									 }
										
									}
									else
									{
										System.out.println("Vous ne pouvez pas effectuer de roque car vous mettriez votre roi en échec");
									}
								 }
							 }
							 
						 }
						 else
						 {
							 
							 this.enlevePiece(p);
							 this.tab[x][y]=p;
							 p.setAbscisse(x);
							 p.setOrdonnee(y);
						 }
						 
						 if ( p.getPremierMouvement())
						 {
							 p.setPremierMouvement(false);
						 }
					 }
					 
					 
					 	
						 if ( p instanceof Pion )
						 {
							 if (p.getPremierMouvement())
							 {
								 p.setPremierMouvement(false);
							 }
							 p.setMvt(p.getMvt()+1);
							
							 if ( p.getC().equals("noir"))
							 {
								 if ( (x == p.getAbscisse()+1 && y == p.getOrdonnee()-1  &&  (!(estOccupee(p.getAbscisse()+1,p.getOrdonnee()-1 )))))
								 {
									 Pion p1 = new Pion( "NP","noir",p.getAbscisse()+1,p.getOrdonnee()-1,p.getPremierMouvement(),p.getMvt());
									 setTab(p1);
									 enlevePiece(getTab(p1.getAbscisse()-1,p1.getOrdonnee()));
									 enlevePiece(p);
									 System.out.println("Vous venez de faire une prise en passant.");
									 
								 }
								 else if ( (x == p.getAbscisse()+1 && y == p.getOrdonnee()+1 &&   (!estOccupee(p.getAbscisse()+1,p.getOrdonnee()+1 ))))
								 {
									 Pion p1 = new Pion( "NP","noir",p.getAbscisse()+1,p.getOrdonnee()+1,p.getPremierMouvement(),p.getMvt());
									 setTab(p1);
									 enlevePiece(getTab(p1.getAbscisse()-1,p1.getOrdonnee()));
									 enlevePiece(p);
									 System.out.println("Vous venez de faire une prise en passant.");
									 
								 }
								 
								 else
								 {
									 this.tab[x][y]=p; 
									 this.enlevePiece(p);
									 p.setAbscisse(x);
									 p.setOrdonnee(y);
									 
									
								 }
								 
							 }
							 else
							 {
								 if ( (x == p.getAbscisse()-1 && y == p.getOrdonnee()-1 ) &&  (!(estOccupee(p.getAbscisse()-1,p.getOrdonnee()-1 ))))
								 {
									 
									 Pion p1 = new Pion( "BP","blanc",p.getAbscisse()-1,p.getOrdonnee()-1,p.getPremierMouvement(),p.getMvt());
									 setTab(p1);
									 enlevePiece(getTab(p1.getAbscisse()+1,p1.getOrdonnee()));
									 enlevePiece(p);
									 System.out.println("Vous venez de faire une prise en passant.");
								 }
								 else if ( (x == p.getAbscisse()-1 && y == p.getOrdonnee()+1 &&  (!(estOccupee(p.getAbscisse()-1,p.getOrdonnee()+1 ) ))))
								 {
									 
									 Pion p1 = new Pion( "BP","blanc",p.getAbscisse()-1,p.getOrdonnee()+1,p.getPremierMouvement(),p.getMvt());
									 setTab(p1);
									 enlevePiece(getTab(p1.getAbscisse()+1,p1.getOrdonnee()));
									 enlevePiece(p);
									 System.out.println("Vous venez de faire une prise en passant.");
								 }
								 
								 else
								 {
									 this.tab[x][y]=p;
									 this.enlevePiece(p);
									
									 p.setAbscisse(x);
									 p.setOrdonnee(y);
								 }
							 }
						 
							 
							 if ( Promotion(p) )
							 {
								 
								    Scanner sc = new Scanner (System.in);
									String rep = "";
									boolean res = false;
									do 
									{
										System.out.println("Veuillez choisir la pièce que vous voulez échanger contre votre pion");
										rep = sc.nextLine();
										rep = rep.toUpperCase();
										System.out.println(rep);
										switch(rep)
										{
											case "DAME":
												res = true;
												break;
											case "CAVALIER":
												res = true;
												break;
											case "TOUR":
												res = true;
												break;
											case "FOU":
												res = true;
												break;
										
										}
									}while(!(res));
									p = ChangerPiece(rep, p);
									setTab(p);
								}
						 }
						 
						 
						 
						 if ( p instanceof Tour && p.getPremierMouvement() )
						 {
							 p.setPremierMouvement(false);
						 }
						 
						 if (!( p instanceof Roi || p instanceof Pion))
						 {
							
							 this.enlevePiece(p);
							 this.tab[x][y]=p;
							 p.setAbscisse(x);
							 p.setOrdonnee(y);
						 }
						 
					}
				 	else
				 	{
				 		System.out.println( "Mouvement impossible");
				 	} 
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
				
				 else
				 {
					 
					if ( p.getC().equals("noir"))
					 {
					     System.out.println("7578");
						 Jouer j1 = new Jouer( "blanc");
						 if ( pat(j1))
						 {
							
							 	ArrayList<Piece >pi = new ArrayList<Piece>();
							    for(int i=0;i<8;i++)
								{
							    	for(int j=0;j<8;j++)
							    	{
							    		if ((estOccupee(i,j)))
										{
							    			if (getTab(i,j).getC().equals("blanc"))
											{									
												pi.add(getTab(i,j));
											}
										}
									}
								}
							    if ( pi.size() == 1 )
								{
									ArrayList<Piece>p2 = new ArrayList<Piece>();
									for(int i=0;i<8;i++)
									{
												for(int j=0;j<8;j++)
												{
													if ((estOccupee(i,j)))
													{
														if (getTab(i,j).getC().equals("noir"))
														{									
															p2.add(getTab(i,j));
														}
													}
												}
									}
									if ( p2.size() == 1)
									{
										System.out.println("Il n'y a plus que les rois sur l'échiquier.");
										setWinner("deuce");
									}
									else
								    {
								    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
								    	setWinner("null");
								    	
								    }
								}
							    else
							    {
							    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
							    	setWinner("null");
							    }
						 }
						 
					 }
					 else
					 {
						 
						 Jouer j1 = new Jouer( "noir");
						if ( pat(j1))
						{
							 
								 	ArrayList<Piece >pi = new ArrayList<Piece>();
								    for(int i=0;i<8;i++)
									{
								    	for(int j=0;j<8;j++)
								    	{
								    		if ((estOccupee(i,j)))
											{
								    			if (getTab(i,j).getC().equals("noir"))
												{									
													pi.add(getTab(i,j));
												}
											}
										}
									}
								   
								    if ( pi.size() == 1 )
									{
										ArrayList<Piece>p2 = new ArrayList<Piece>();
										for(int i=0;i<8;i++)
										{
													for(int j=0;j<8;j++)
													{
														if ((estOccupee(i,j)))
														{
															if (getTab(i,j).getC().equals("blanc"))
															{									
																p2.add(getTab(i,j));
															}
														}
													}
										}
										if ( p2.size() == 1)
										{
											System.out.println("Il n'y a plus que les rois sur l'échiquier.");
											setWinner("deuce");
										}
										else
									    {
									    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
									    	setWinner("null");
									    	
									    }
									}
								    else
								    {
								    	System.out.println("Il est impossible de continuer, le joueur "+ j1.getJ()+" ne peut avancer aucune pièce");
								    	setWinner("null");
								    	
								    }
							 }
						
					 }
					 
				 }
				
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
				 {
					 
					 	res = true;
				 }
				
			 }
			 else
			 {
				 this.getRoiB();
				 if(DeplacementEstValide(p1, ech.getRoiB().getAbscisse(),ech.getRoiB().getOrdonnee()))
				 {
					 	res = true;
				 }
			 }
			 return res;
		 }
		
		public boolean echecEtMat( Echiquier ech, Piece p1)
		 {
			
			 this.setRois();
			 boolean res = true;
			 
				 if ( p1.getC().equals("blanc"))
				 {
					 System.out.println("7682");
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()+1,ech.getRoiN().getOrdonnee()))// J avance de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException | NullPointerException e){};
					
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()+1,ech.getRoiN().getOrdonnee()+1))// J avance de une ligne et une colonne.
						{
						return false;
						}
					}catch(ArrayIndexOutOfBoundsException | NullPointerException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()+1,ech.getRoiN().getOrdonnee()-1))// J avance de une ligne et recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException | NullPointerException e){};
					 
					try
					{
					 	if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse(),ech.getRoiN().getOrdonnee()+1))// J avance de une colonne.
					 	{
					 		return false;
					 	}
					}
					catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
				 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse(),ech.getRoiN().getOrdonnee()-1))// Je recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					
					try
					{	
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()-1,ech.getRoiN().getOrdonnee()))// Je recule de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()-1,ech.getRoiN().getOrdonnee()-1))// Je recule de une ligne et une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiN(),ech.getRoiN().getAbscisse()-1,ech.getRoiN().getOrdonnee()+1))// Je recule de une ligne et avance de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					
					
					ArrayList<Piece> p = new ArrayList<Piece>();
					 for(int i=0;i<8;i++)
					{
							for(int j=0;j<8;j++)
							{
								if ((estOccupee(i,j)))
								{
									if (ech.getTab(i,j).getC().equals("noir"))
									{									
										p.add(getTab(i,j));
									}
								}
							}
					}	
					
					
					for ( int i = 0; i < p.size(); i++)
					{
						if ( !(p.get(i).getNom().equals("NR")))
						{
						if ( DeplacementEstValide(p.get(i),p1.getAbscisse(),p1.getOrdonnee()))// Si une pièce noire peut manger la pièce mettant le roi noir en echec
						{																	  // Il n'y a alors pas echec et mat.
							res = false;
						}
						}
					}
					if ( res == false)
					{
						return res;
					}
					System.out.println("7779");
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
						;
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
									if ( !(p.get(i).getNom().equals("NR")))
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{
											res = false;
										}
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
				System.out.println("8095");
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()+1,ech.getRoiB().getOrdonnee()))// J avance de une ligne.
						{
							
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()+1,ech.getRoiB().getOrdonnee()+1))// J avance de une ligne et une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()+1,ech.getRoiB().getOrdonnee()-1))// J avance de une ligne et recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					 
					try
					{
					 	if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse(),ech.getRoiB().getOrdonnee()+1))// J avance de une colonne.
					 	{
					 		return false;
					 	}
					}
					catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
				 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse(),ech.getRoiB().getOrdonnee()-1))// Je recule de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					
					try
					{	
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()-1,ech.getRoiB().getOrdonnee()))// Je recule de une ligne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()-1,ech.getRoiB().getOrdonnee()-1))// Je recule de une ligne et une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					 
					try
					{
						if ( DeplacementEstValide(ech.getRoiB(),ech.getRoiB().getAbscisse()-1,ech.getRoiB().getOrdonnee()+1))// Je recule de une ligne et avance de une colonne.
						{
							return false;
						}
					}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					
					
					
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
						try
						{
							if ( !(p.get(i).getNom().equals("BR")))
							{
							if ( DeplacementEstValide(p.get(i),p1.getAbscisse(),p1.getOrdonnee()))// Si une pièce noire peut manger la pièce mettant le roi noir en echec
							{																	  // Il n'y a alors pas echec et mat.
								res = false;
								System.out.println(p.get(i).getNom());
							}
							}
						}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
					}
					if ( res == false)
					{
						return res;
					}
					System.out.println("8194");
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
									try
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{
											res = false;
										}
									}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
									try
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{
											res = false;
										}
									}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
									try
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{										
											res = false;
										}
									}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
									try
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{
											res = false;
										}
									}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
									try
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{
											res = false;
										}
									}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
									try
									{
										if ( DeplacementEstValide(p.get(i),abs,ord))
										{
											res = false;
										}
										
									}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{										
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
								try
								{
									if ( DeplacementEstValide(p.get(i),abs,ord))
									{
										res = false;
									}
								}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
							try
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
							}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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
							try
							{
								if ( DeplacementEstValide(p.get(i),abs,ord))
								{
									res = false;
								}
							}catch(ArrayIndexOutOfBoundsException |NullPointerException e){};
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

		public Piece ChangerPiece ( String chaine, Piece p1)
		{
			
			if ( chaine.equals("DAME"))
			{
				if ( p1.getC().equals("noir") )
				{
					
					Dame d = new Dame("ND", "noir", p1.getAbscisse(), p1.getOrdonnee(), p1.getPremierMouvement(),p1.getMvt()  );
					this.setTab(d);
					return d;
				}
				else
				{
					
					Dame d = new Dame("BD", "blanc", p1.getAbscisse(), p1.getOrdonnee(), p1.getPremierMouvement(),p1.getMvt()  );
					this.setTab(d);
					return d;
				}
			}
					
			else if ( chaine.equals("CAVALIER") )
			{
				if ( p1.getC().equals("noir"))
				{
					Cavalier c = new Cavalier( "NC","noir",p1.getAbscisse(),p1.getOrdonnee(),p1.getPremierMouvement(),p1.getMvt() );
					this.setTab(c);
					return c;
				}
				else
				{
					Cavalier c = new Cavalier( "BC","blanc",p1.getAbscisse(),p1.getOrdonnee(),p1.getPremierMouvement() ,p1.getMvt());
					this.setTab(c);
					return c;
				}
			}
			
			else if ( chaine.equals("TOUR"))
			{
				if ( p1.getC().equals("noir"))
				{
					Tour t = new Tour( "NT","noir",p1.getAbscisse(),p1.getOrdonnee(),p1.getPremierMouvement(),p1.getMvt() );
					this.setTab(t);
					return t;
				}
				else
				{
					Tour t = new Tour( "BT","blanc",p1.getAbscisse(),p1.getOrdonnee(),p1.getPremierMouvement(),p1.getMvt() );
					this.setTab(t);
					return t;
				}
			}
								
			else
			{
				if ( p1.getC().equals("noir"))
				{
					Fou f = new Fou( "NF","noir",p1.getAbscisse(),p1.getOrdonnee(),p1.getPremierMouvement() ,p1.getMvt());
					this.setTab(f);
					return f;
				}
				else
				{
					Fou f = new Fou( "BF","blanc",p1.getAbscisse(),p1.getOrdonnee(),p1.getPremierMouvement(),p1.getMvt() );
					this.setTab(f);
					return f;
				}
			}
				
		}



		public boolean Promotion( Piece p)
		{
			boolean res = false;
			
			if ( p instanceof Pion )
			{
				Pion p1 = new Pion ( (Pion) p);
				
				if ( p1.getC().equals("noir"))
				{
					if (p1.getAbscisse() == 7)
					{
						res = true;
					}
					return res;
				}
				else
				{
					if (p1.getAbscisse() == 0)
					{
						res = true;
					}
					return res;
				}
			}
			else
				return res;
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
			    if ( p.size() == 1 )
				{
					ArrayList<Piece>p2 = new ArrayList<Piece>();
					for(int i=0;i<8;i++)
					{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("blanc"))
										{									
											p2.add(getTab(i,j));
										}
									}
								}
					}
					if ( p2.size() == 1)
					{
						return res;
					}
				}
					
				 	int i = 0;
				 	
					while ( i < p.size() && res != false)
					{
						int l = p.get(i).getAbscisse();
						
						int c = p.get(i).getOrdonnee();
						
						if ( c < 7 && res != false )
					    {
								    try
								    {
								    	if ( !(p.get(i).getNom().equals("NR")))
								    	{
								    	if ( DeplacementEstValide(p.get(i), l, c+1))// mvt gauche droite
								    	{
								    		System.out.println(p.get(i).getNom());
								    		res = false;
								    	}
								    	}
								    }catch(Exception e) {}
					    }
					    if ( res == false)
					    {
					    	return res;
					    }
					   
					     c = p.get(i).getOrdonnee();
					    	
					   if( c >=0 && res != false )
						{
					    	try
					    	{
					    		if ( DeplacementEstValide(p.get(i), l, c-1))// mvt droite gauche
					    		{
					    			res = false;
					    		}
					    	}catch( Exception e ) {}
					    	
						}
					    
					    if ( res == false)
					    {
					    	return res;
					    }
					     c = p.get(i).getOrdonnee();
				    	
					  if( l < 7 && res != false )
						{
					    	try
					    	{
					    		if ( DeplacementEstValide(p.get(i), l + 1, c))// mvt bas vers haut
					    		{
					    			
					    			res = false;
					    		}
					    	}catch( Exception e){}
					    	
			    			
						}
					    
					    if ( res == false)
					    {
					    	
					    	return res;
					    }
					    
					    
					    l = p.get(i).getAbscisse();
					    
					    if( l >=0 && res != false )
						{
					    	try 
					    	{
					    		if ( DeplacementEstValide(p.get(i), l - 1, c))// mvt haut vers bas
					    		{
					    			res = false;
					    		}
					    	}catch( Exception e ){}
					    	
			    			
						}
					    
					    if ( res == false)
					    {
					    	
					    	return res;
					    }
					    
					    l = p.get(i).getAbscisse();
					    c = p.get(i).getOrdonnee();
					    
					    if ( l < 7 && c < 7 && res != false )
						{
					    	try 
					    	{
					    		if ( DeplacementEstValide(p.get(i), l + 1, c + 1))// mvt bas vers haut à droite
					    		{
					    			res = false;
					    		}
					    	} catch ( Exception e) {}
						}
					    
					    if ( res == false)
					    {
					    	return res;
					    }
					    
					    l = p.get(i).getAbscisse();
					    c = p.get(i).getOrdonnee();
					    
					    if( l < 7 && c >=0 && res != false )
						{
					    	try
					    	{
					    		if ( DeplacementEstValide(p.get(i), l + 1, c - 1))// mvt bas vers haut à gauche
					    		{
					    			res = false;
					    		}
					    	}catch( Exception e) {}
					    	
						}
					    
					    if ( res == false)
					    {
					    	return res;
					    }
					  
						
					    l = p.get(i).getAbscisse();
					    c = p.get(i).getOrdonnee();
					    
					    if( l >=0 && c < 7 && res != false )
						{
					    	try
					    	{
					    		if ( DeplacementEstValide(p.get(i), l - 1, c + 1))// mvt haut vers bas à droite
					    		{
					    			res = false;
					    		}
					    	}catch (Exception e){}
					    	
			    			
						}
					    
					    if ( res == false)
					    {
					    	return res;
					    }
					    
					    
					    l = p.get(i).getAbscisse();
					    c = p.get(i).getOrdonnee();
					    
					   if( l >=0 && c >= 0 && res != false )
						{
					    	try
					    	{
					    		if ( DeplacementEstValide(p.get(i), l - 1, c - 1))// mvt haut vers bas à gauche
					    		{
					    			res = false;
					    		}
					    	}catch ( Exception e ) {}
					    	
			    			
						}
					    
					    if ( res == false)
					    {
					    	return res;
					    }
					    
					    i++;
						
					}
					
					return res; 	
				
			}
			else
			{
				
				p = new ArrayList<Piece>();
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
			    if ( p.size() == 1 )
				{
					ArrayList<Piece>p2 = new ArrayList<Piece>();
					for(int i=0;i<8;i++)
					{
								for(int j=0;j<8;j++)
								{
									if ((estOccupee(i,j)))
									{
										if (getTab(i,j).getC().equals("noir"))
										{									
											p2.add(getTab(i,j));
										}
									}
								}
					}
					if ( p2.size() == 1)
					{
						return res;
					}
				}
			    int i = 0;
				while ( i < p.size() && res != false)
				{
					int l = p.get(i).getAbscisse();
					int c = p.get(i).getOrdonnee();
					
					if( c < 7 && res != false )
				    {
							    try
							    {
							    	if ( DeplacementEstValide(p.get(i), l, c+1))// mvt gauche droite
							    	{
							    		res = false;
							    	}
							    	
							    }catch(Exception e) {}
				    }
				    if ( res == false)
				    {
				    	return res;
				    }
				    
				     c = p.get(i).getOrdonnee();
				    	
				    if( c >=0 && res != false )
					{
				    	try
				    	{
				    		if ( DeplacementEstValide(p.get(i), l, c-1))// mvt droite gauche
				    		{
				    			res = false;
				    		}
				    	}catch( Exception e ) {}
				    	
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				   
				    c = p.get(i).getOrdonnee();
			    	
				    if( l < 7 && res != false )
					{
				    	try
				    	{
				    		if ( DeplacementEstValide(p.get(i), l + 1, c))// mvt bas vers haut
				    		{
				    			res = false;
				    		}
				    	}catch( Exception e){}
				    	
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				    
				    
				    l = p.get(i).getAbscisse();
				    
				    if( l >=0 && res != false )
					{
				    	try 
				    	{
				    		if ( DeplacementEstValide(p.get(i), l - 1, c))// mvt haut vers bas
				    		{
				    			res = false;
				    		}
				    	}catch( Exception e ){}
				    	
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				    
				    l = p.get(i).getAbscisse();
				    c = p.get(i).getOrdonnee();
				    
				    if( l < 7 && c < 7 && res != false )
					{
				    	try 
				    	{
				    		if ( DeplacementEstValide(p.get(i), l + 1, c + 1))// mvt bas vers haut à droite
				    		{
				    			res = false;
				    		}
				    	} catch ( Exception e) {}
				    	
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				    
				    l = p.get(i).getAbscisse();
				    c = p.get(i).getOrdonnee();
				    
				    if( l < 7 && c >=0 && res != false )
					{
				    	try
				    	{
				    		if ( DeplacementEstValide(p.get(i), l + 1, c - 1))// mvt bas vers haut à gauche
				    		{
				    			res = false;
				    		}
				    	}catch( Exception e) {}
				    	
		    			
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				  
					
				    l = p.get(i).getAbscisse();
				    c = p.get(i).getOrdonnee();
				    
				    if( l >=0 && c < 7 && res != false )
					{
				    	try
				    	{
				    		if ( DeplacementEstValide(p.get(i), l - 1, c + 1))// mvt haut vers bas à droite
				    		{
				    			res = false;
				    		}
				    	}catch (Exception e){}
				    	
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				    
				    
				    l = p.get(i).getAbscisse();
				    c = p.get(i).getOrdonnee();
				    
				    if( l >=0 && c >= 0 && res != false )
					{
				    	try
				    	{
				    		if ( DeplacementEstValide(p.get(i), l - 1, c - 1))// mvt haut vers bas à gauche
				    		{
				    			res = false;
				    		}
				    	}catch ( Exception e ) {}
				    	
		    			
					}
				    
				    if ( res == false)
				    {
				    	return res;
				    }
				    
				    i++;
					
				}
				
			}
			return res;
			
		}	
		
		public void Echange ( Echiquier ech )
		{
			
			for ( int i = 0; i < 8; i ++)
			{
				for ( int j  = 0 ; j < 8 ; j ++ )
				{
					if ( ech.estOccupee(i, j))
					{
						this.setTab(ech.getTab(i, j));
					}
					
				}
			}
			
		
		}
		
	
}
