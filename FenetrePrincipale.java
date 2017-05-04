package Echec;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.lang.Object;

public class FenetrePrincipale extends JFrame
	{
		private JFrame fenetre;
		private	JPanel ech[][];
		private JPanel posech;
		private JLabel lettre[];
		private JLabel chiffre[];
		
		public FenetrePrincipale ()
		{
			fenetre = new JFrame();
			ech = new JPanel[9][9];
			lettre = new JLabel [8];
			chiffre = new JLabel [8];
	

			// CONFIG DE LA FENETRE //
			fenetre.setTitle("ChessGame");
			fenetre.setSize(800,620); // taille en pixel de la largeur et hauteur de la fenetre
			fenetre.setLayout(new BorderLayout());
			fenetre.setLocationRelativeTo(null);
			fenetre.setResizable(false); // empeche le redimenssionnement de la fenetre  
			fenetre.setVisible(true);
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
			public void remplirLettre()
			{
				lettre[0]=new JLabel("A");
				lettre[1]=new JLabel("B");
				lettre[2]=new JLabel("C");
				lettre[3]=new JLabel("D");
				lettre[4]=new JLabel("E");
				lettre[5]=new JLabel("F");
				lettre[6]=new JLabel("G");
				lettre[7]=new JLabel("H");	
				for(int i=0;i<8;i++) lettre[i].setForeground(Color.BLACK); // Ecrit les lettres en noirs.
			}
			
			public void remplirChiffre()
			{
				chiffre[0]=new JLabel("  8");
				chiffre[1]=new JLabel("  7");
				chiffre[2]=new JLabel("  6");
				chiffre[3]=new JLabel("  5");
				chiffre[4]=new JLabel("  4");
				chiffre[5]=new JLabel("  3");
				chiffre[6]=new JLabel("  2");
				chiffre[7]=new JLabel("  1");
				for(int i=0;i<8;i++) chiffre[i].setForeground(Color.BLACK); // Ecrit les chiffres en noirs.
			}
			
			public void afficherEch(){
				boolean estGris = true;
				 for(int i=0;i<8;i++){

					for(int j=0;j<8;j++){
						if( estGris == true )
						{
							ech[i][j] = new JPanel(new BorderLayout());				 
							ech[i][j].setBackground(new Color(163,172,158));
							ech[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));//Le contour de la case est en blanc
							ech[i][j].setPreferredSize(new Dimension(60,60));
						}
						else 
						{
							ech[i][j] = new JPanel();				
							ech[i][j].setBackground(new Color(226,232,223));
							ech[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));//Le contour de la case est en blanc
							ech[i][j].setPreferredSize(new Dimension(60, 60));
						}
						estGris = !estGris;
					}
					estGris = !estGris;
					
				}
				for (int j=0;j<8;j++)
				{	
					ech[8][j]=new JPanel(new BorderLayout());
					ech[8][j].setPreferredSize(new Dimension(30,60));
					ech[8][j].setBorder(BorderFactory.createLineBorder(Color.WHITE)); //Le contour de la case est en blanc
					ech[8][j].add(chiffre[j],BorderLayout.CENTER);
				}	
				for (int i=0;i<8;i++)
				{	
					ech[i][8]=new JPanel();
					ech[i][8].setPreferredSize(new Dimension(60,30));
					ech[i][8].setBorder(BorderFactory.createLineBorder(Color.WHITE)); //Le contour de la case est en blanc
					ech[i][8].add(lettre[i]);
				}
				ech[8][8]=new JPanel();
				ech[8][8].setPreferredSize(new Dimension(30,30));
				ech[8][8].setBorder(BorderFactory.createLineBorder(Color.WHITE)); 
			}
			
			public void positionnerCases(){
				posech = new JPanel();
				posech.setLayout(new GridBagLayout());
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = 0;  // case de depart
				gbc.gridy = 0;  // case de depart
				gbc.gridheight = 1;  // taille hauteur
		        gbc.gridwidth = 1;  // taille largeur
		        
		        for(int i=0;i<9;i++){
					for(int j=0;j<9;j++){
						gbc.gridx = i;
						gbc.gridy = j;
						
						posech.add(ech[i][j], gbc);
					}
				}
		        posech.setBackground(new Color(117,231,238)); // si on veut mettre un fond de couleur
				fenetre.add(posech,BorderLayout.CENTER);
		    }
			
			public void afficherPieces(Echiquier e){
		        for(int i=0;i<8;i++) {
					for(int j=0; j<8;j++){
						if(e.estOccupee(i,j)){
							if(e.getTab(i,j).getC()=="blanc"){
								if(e.getTab(i,j).getNom()=="BT"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/tour_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="BC"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/cavalier_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="BF"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/fou_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="BP"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/pion_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="BD"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/reine_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="BR"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/roi_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
							}
							if(e.getTab(i,j).getC()=="noir"){
								if(e.getTab(i,j).getNom()=="NT"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/tour_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="NC"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/cavalier_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="NF"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/fou_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="NP"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/pion_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="ND"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/reine_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
								if(e.getTab(i,j).getNom()=="NR"){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/roi_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img);
								}
							}
						}
					}
				}
			}
			
			public void revalidate(){
				for(int i=0;i<8;i++) {
					for(int j=0; j<8;j++){
						ech[i][j].revalidate();
					}
				}
			}
			

	}





