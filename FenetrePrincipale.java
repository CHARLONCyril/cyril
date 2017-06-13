package Echec;

import javax.swing.*;



import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class FenetrePrincipale extends JFrame 
	{
		private JFrame fenetre;
		private	JPanel ech[][];
		private JPanel posech;
		private JLabel lettre[];
		private JLabel chiffre[];
		private JMenuBar menu;
		private JButton sauve;
		private JComboBox<Button> rules;
		public JButton getCharge() {
			return charge;
		}
		public void setCharge(JButton charge) {
			this.charge = charge;
		}
		public JButton getSauve() {
			return sauve;
		}
		public void setSauve(JButton sauve) {
			this.sauve = sauve;
		}
		private JButton charge;
		private JButton abandonner;
		private JButton nouvellePartie;
		public FenetrePrincipale ()
		{
			fenetre = new JFrame();  // On creer une nouvelle Fenêtre.
			ech = new JPanel[9][9];  // On creer un tableau Jpanel a 2 dimensions.
			lettre = new JLabel [8]; // Creation d'un tableau Jlabel.
			chiffre = new JLabel [8]; // Creation d'un tableau Jlabel.
			menu = new JMenuBar();
			Box b1 = Box.createHorizontalBox();
			
			sauve = new JButton("Sauvegarder La Partie");
			b1.add(sauve);
			sauve.addMouseListener(new MouseAdapter(){
			
				public void mouseEntered(MouseEvent e) {
					sauve.setBackground(Color.CYAN);
				}
				
				public void mouseExited(MouseEvent e) {
					sauve.setBackground(Color.WHITE);
				}
			});
			
			Box b2 = Box.createHorizontalBox();
			charge = new JButton("Charger La Partie");
			b2.add(charge);
			
			charge.addMouseListener(new MouseAdapter(){
			
				public void mouseEntered(MouseEvent e) {
					charge.setBackground(Color.CYAN);
				}
				
				public void mouseExited(MouseEvent e) {
					charge.setBackground(Color.WHITE);
				}

			});
			
			Box b3 = Box.createHorizontalBox();
			abandonner = new JButton("Abandonner La Partie");
			b3.add(abandonner);
			
			abandonner.addMouseListener(new MouseAdapter(){
			
				public void mouseEntered(MouseEvent e) {
					abandonner.setBackground(Color.CYAN);
				}
				
				public void mouseExited(MouseEvent e) {
					abandonner.setBackground(Color.WHITE);
				}


			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Le joueur a abandonnée la partie");
				System.exit(0);	
					
				
			}
			});
			
			Box b4 = Box.createHorizontalBox();
			
			nouvellePartie = new JButton("nouvelle Partie");
			b4.add(nouvellePartie);
			nouvellePartie.addMouseListener(new MouseAdapter(){
			
				public void mouseEntered(MouseEvent e) {
					nouvellePartie.setBackground(Color.CYAN);
				}
				
				public void mouseExited(MouseEvent e) {
					nouvellePartie.setBackground(Color.WHITE);
				}
			});
			
			
			
			String[] r = {"Déroulement du jeu","La promotion du pion","Le roque","La prise en passant","Echec","Echec et Mat","Pat","Match Nul","Déplacement de la Tour","Déplacement du Cavalier","Déplacement du Fou","Déplacement de la Dame","Déplacement du Roi","Déplacement du Pion"};
			rules = new JComboBox(r);
			rules.addMouseListener(new MouseAdapter() {
				public void mouseClicked( MouseEvent e)
				{
					if ( e.getSource() == rules)
					{
						if( rules.getSelectedIndex() == 0)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/chessGame.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Jouer un coup consiste à effectuer un déplacement de l'une de ses pièces, accompagné éventuellement de la capture d'une pièce adverse se trouvant sur la case d'arrivée de la pièce jouée.\n A l'exception du roque (voir ci-dessous), un coup ne peut pas être constitué du mouvement de deux pièces du même camp à la fois.\n Si l'on décide de déplacer sa pièce sur la case occupée par une pièce adverse, on retire cette pièce adverse de l'échiquier : elle a été prise ; contrairement au jeu de dames, aucune prise n'est obligatoire aux échecs. \nBlancs et Noirs jouent à tour de rôle, par convention les Blancs jouent le premier coup de la partie.On dit de celui qui doit jouer qu il a le trait, et jouer est une obligation (on ne peut pas passer  son tour). \n Être obligé de jouer est parfois un handicap lorsque tous les coups à disposition se révèlent mauvais, on parle alors de situation de zugzwang. Si le joueur qui a le trait est dans l'impossibilité d'exécuter un coup légal, la partie se termine (c'est un pat ou un échec et mat, voir plus loin).\n Le temps de réflexion alloué à chaque joueur, le mode d'attribution des Blancs, le nombre de rondes dans un tournoi, etc., ne font pas partie des règles du jeu lui-même, ce sont des règles d organisation des rencontres (partie amicale, par correspondance, tournoi, etc.).");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"Le Dérouement",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						
						if ( rules.getSelectedIndex() == 1 )
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/pion_b.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Quand le pion arrive sur la dernière rangée, il doit se transformer en une pièce de même couleur au choix du joueur parmi dame, tour, fou ou cavalier.\n Le plus souvent, la dame est choisie permettant ainsi d'avoir jusqu'à neuf dames, mais un autre choix peut parfois se révéler plus judicieux.");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"La Promotion du Pion",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						if( rules.getSelectedIndex() == 2)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/roque.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Le roque est le seul cas où, en un seul coup, on peut déplacer deux de ses propres pièces à la fois (le roi et une tour), et avec un mode de déplacement inhabituel :\n le roi se déplace sur sa rangée de deux cases vers sa tour, et la tour saute par-dessus son roi pour venir se placer à côté de lui, sur le flanc opposé.\n Il est nécessaire de veiller à respecter l'ordre de ces deux déplacements :\n le roi se déplace en premier, puis la tour opère son mouvement en second.\n Ce double déplacement est soumis aux conditions suivantes :\nle roi et la tour concernés n'ont jamais été déplacés,\nil n'y a aucune pièce entre le roi et la tour concernés\n,le roi n'est pas en échec au moment du roque\n,aucune des cases traversées par le roi n'est sous la menace d'une pièce adverse,\n le roi ne doit pas se mettre en échec lors de son déplacement.");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"Le Roque",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						if ( rules.getSelectedIndex() == 3)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/prise_en_passant.gif"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("La possibilité donnée au pion d'avancer de deux cases lors de son premier déplacement lui permet d'éviter l'affrontement qui aurait eu lieu s'il n'avait avancé que d'une case.\n Pour limiter ce désavantage qui pénalise l'audace du pion avancé adverse, ce dernier a la possibilité de prendre comme si le coup de début n'avait été que d'une case.\n Cette prise en passant ne peut se faire qu'en réponse immédiate à l'avance double.\n C'est le seul cas où une pièce n'est pas capturée sur la case d'arrivée de la pièce qui capture.");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"La Prise en Passant",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						if ( rules.getSelectedIndex() == 4 )
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/chessGame.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Lorsque le roi est en prise, il est en échec.\n Le joueur devra obligatoirement parer cet échec.\n S'il n'existe aucun coup pour soustraire le roi à l'échec.\nRemarque : l'annonce de l'échec est facultative. Il existe trois façons de parer un échec:\n Déplacer le roi.\nPrendre la pièce qui met le roi en échec.\nCouvrir l'échec en intercalant une autre pièce.\nIl est interdit de mettre son roi dans une position d'échec. ");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"Echec",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						if ( rules.getSelectedIndex() == 5)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/chessGame.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Si le Roi ne peut parer l’échec, il perd la partie, puisqu’il est échec et mat.\n—> Caractéristiques de l’échec et mat :\n– Le Roi ne peut plus se déplacer\n– Aucune pièce alliée ne peut s’interposer pour parer l’échec\n– La pièce qui fait l’échec ne peut être éliminée");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"Echec et Mat",JOptionPane.INFORMATION_MESSAGE,icon);
							
						}
						
						if ( rules.getSelectedIndex() == 6)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/chessGame.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Un joueur se retrouve en situation de Pat, lorsque :\n– Son Roi n’a aucun coup légal (c’est à dire, que le Roi n’est pas en échecs, mais qu’il ne peut aller nulle part sans se mettre en échec).\n– Aucune autre pièce ne peut être déplacée–>\n Le joueur ne peut donc effectuer aucun coup, il y a Pat et la partie est déclarée NULLE");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"Pat",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						if ( rules.getSelectedIndex() == 7 )
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/chessGame.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(1500,420));
							mes.setText("Voici la liste des cas qui déterminent le match nul :\n– Il y a Pat.\n– Il n’y a pas assez de matériel pour mater les Rois.\n– Un joueur fait des échecs perpétuels (échec à l’infini).\n– La même position est répétée trois fois.\n– 50 coups sont joués sans aucune prise, ni aucun déplacement de pion.");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"Match Nul",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						if ( rules.getSelectedIndex() == 8)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/tour_b.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(800,320));
							mes.setText("Déplacement horizontal ou vertical\n– d’autant de cases qu’elle veut\n– Peut avancer ou reculer");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);
							JOptionPane.showMessageDialog(null,mes,"La Tour",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						if ( rules.getSelectedIndex() == 9)
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/cavalier_b.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(800,320));
							mes.setText("– Déplacement en « L »–\n Change de couleur de case à chaque déplacement– \nSaute par dessus les autres");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);

							JOptionPane.showMessageDialog(null,mes,"Le Cavalier",JOptionPane.INFORMATION_MESSAGE,icon);
							
						}
						if ( rules.getSelectedIndex() == 10)
						{
							
								ImageIcon icon = new ImageIcon(getClass().getResource("/img/fou_b.png"));
								JTextArea mes = new JTextArea();
								mes.setLineWrap(true);
								mes.setPreferredSize(new Dimension(800,320));
								mes.setText("– Déplacement en diagonale\n– d’autant de cases qu’il veut");
								mes.setBackground(Color.BLACK);
								mes.setEnabled(false);

								JOptionPane.showMessageDialog(null,mes,"Le Fou",JOptionPane.INFORMATION_MESSAGE,icon);
								
							
						}
						
						if ( rules.getSelectedIndex() == 11 )
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/reine_b.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(800,320));
							mes.setText("– Pièce la plus puissante\n– Cumule déplacement de la Tour (horizontal/vertical) et du Fou (diagonal)\n– Peut contrôler 27 cases !");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);

							JOptionPane.showMessageDialog(null,mes,"La Dame",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						
						if ( rules.getSelectedIndex() == 12 )
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/roi_b.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(800,320));
							mes.setText("– Déplacement dans  toutes les directions\n– d’1 seule case à la fois\n– Il doit y avoir au moins une case entre 2 Rois adverses");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);

							JOptionPane.showMessageDialog(null,mes,"Le Roi",JOptionPane.INFORMATION_MESSAGE,icon);
						}
						if ( rules.getSelectedIndex() == 13 )
						{
							ImageIcon icon = new ImageIcon(getClass().getResource("/img/pion_b.png"));
							JTextArea mes = new JTextArea();
							mes.setLineWrap(true);
							mes.setPreferredSize(new Dimension(800,320));
							mes.setText("– Avance droit devant lui\n– Ne recule jamais\n– Avance d’1 case à la fois SAUF lors de son 1er coup où il peut avancer de 2 cases\n– Capture en diagonale");
							mes.setBackground(Color.BLACK);
							mes.setEnabled(false);

							JOptionPane.showMessageDialog(null,mes,"Le Pion",JOptionPane.INFORMATION_MESSAGE,icon);
						}
					}
				}
			});
			Box b5 = Box.createHorizontalBox();
			b5.add(rules);
			Box b6 = Box.createHorizontalBox();
			b6.add(b1);
			b6.add(b2);
			b6.add(b3);
			b6.add(b4);
			b6.add(b5);
			menu.add(b6);
			
			// Initialisation des différenentes parties de ma fenête.
			
			fenetre.setTitle("ChessGame"); // Permet de donner un titre à la fenêter.
			fenetre.setSize(800,620); // taille en pixel de la largeur et hauteur de la fenetre
			fenetre.setLayout(new BorderLayout()); // permet de les répartir selon 5 emplacements les différents éléments. 
			fenetre.setLocationRelativeTo(null); //  Permet à l'objet de se positionner au centre
			fenetre.setResizable(false); // empeche le redimenssionnement de la fenetre  
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Termine le processus lorsqu'on clique sur la croix rouge
			fenetre.setJMenuBar(menu);
			fenetre.setVisible(true); // Rend la fenêtre visible.
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
				chiffre[0]=new JLabel("  0");
				chiffre[1]=new JLabel("  1");
				chiffre[2]=new JLabel("  2");
				chiffre[3]=new JLabel("  3");
				chiffre[4]=new JLabel("  4");
				chiffre[5]=new JLabel("  5");
				chiffre[6]=new JLabel("  6");
				chiffre[7]=new JLabel("  7");
				for(int i=0;i<8;i++) chiffre[i].setForeground(Color.BLACK); // Ecrit les chiffres en noirs.
			}
			
			public void afficherEch(){
				boolean estGris = true;
				 for(int i=0;i<8;i++){

					for(int j=0;j<8;j++){
						if( estGris == true )// Ce test permet d'alterner la couleur de la case.
						{
							ech[i][j] = new JPanel();				 
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
			
			public void positionnerCases()
			{
				posech = new JPanel();
				posech.setLayout(new GridBagLayout());// permet d'agencer des composants sur une grille virtuelle. SetLayout permet de placer les composants insérés.
				
				/* Le principe est d'utiliser une grille virtuelle et de définir pour chaque sous-composant graphique 
				un ensemble de paramètres qui permet de le positionner et de le dimensionner par rapport à la grille virtuelle
				et par rapport aussi aux autres sous-composants.*/
				
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = 0;  // case de depart. Ils donnent l'abscisse et l'ordonnée du sous-composant dant la grille.
				gbc.gridy = 0;  // case de depart
				gbc.gridheight = 1;  // taille hauteur du sous-composant dans la grille.
		        gbc.gridwidth = 1;  // taille largeur du sous-composant dans la grille.
		        
		        for(int i=0;i<9;i++){
					for(int j=0;j<9;j++){
						gbc.gridx = i; // permet de positionner notre sous-composants
						gbc.gridy = j;// permet de positionner notre sosu-composants
						
						
						posech.add(ech[i][j], gbc);
					}
				}
		        posech.setBackground(new Color(117,231,238)); // si on veut mettre un fond de couleur
				fenetre.add(posech,BorderLayout.CENTER);
		    }
			
			public void afficherPieces(Echiquier e)
			{
		        for(int i=0;i<8;i++) {
					for(int j=0; j<8;j++){
						if(e.estOccupee(i,j)){
							if(e.getTab(i,j).getC().equals("blanc")){
								if(e.getTab(i,j).getNom().equals("BT")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/tour_b.png"));
									JLabel img = new JLabel(icon);
									
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("BC")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/cavalier_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("BF")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/fou_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("BP")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/pion_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("BD")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/reine_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("BR")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/roi_b.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
							}
							if(e.getTab(i,j).getC().equals("noir")){
								if(e.getTab(i,j).getNom().equals("NT")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/tour_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("NC")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/cavalier_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("NF")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/fou_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("NP")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/pion_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("ND")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/reine_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
								}
								if(e.getTab(i,j).getNom().equals("NR")){
									ImageIcon icon = new ImageIcon(getClass().getResource("/img/roi_n.png"));
									JLabel img = new JLabel(icon);
									ech[j][i].add(img,BorderLayout.CENTER);
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
			public JMenuBar getMenu() {
				return menu;
			}
			public void setMenu(JMenuBar menu) {
				this.menu = menu;
			}
			public JButton getNouvellePartie() {
				return nouvellePartie;
			}
			public void setNouvellePartie(JButton nouvellePartie) {
				this.nouvellePartie = nouvellePartie;
			}
			
			
	}





