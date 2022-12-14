package VYBA;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*; 
import java.awt.*;
public class principal extends JFrame implements KeyListener,ActionListener
{
	public Hero notre_heros;
	public int niveau=99;
	public JFrame f;
	public JFrame selection_niveau;
	public JFrame fin;
	public JFrame donnee_joueur;
	public JTextArea nom;
	public JComboBox genre;
	public char genre_heros;
	public static void main(String[] args) 

	{
		new principal();
	}

	principal()
	{
		//Ecran permettant d'entrer les donn?es du joueur
		donnee_joueur= new JFrame("Donn?es du joueur");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3,1));
		JButton validation = new JButton("Valider");
		validation.addActionListener(this);
		JLabel label1 = new JLabel("Nom du joueur : ");
		nom = new JTextArea();
		nom.setPreferredSize(new Dimension (125,20));
		JLabel label3 = new JLabel("Genre du joueur");
		genre = new JComboBox();
		genre.addItem('M');
		genre.addItem('F');		
		panel1.add(label1);
		panel1.add(nom);
		panel2.add(label3);
		panel2.add(genre);
		panel3.add(validation);
		panel4.add(panel1);
		panel4.add(panel2);
		panel4.add(panel3);
		donnee_joueur.add(panel4);
		donnee_joueur.setSize(300,300);
		donnee_joueur.show();
	}

	void niveau()
	{
		//Ecran de s?l?ction du niveau
		selection_niveau = new JFrame("Selection du niveau");
		JPanel panel=new JPanel();
		JLabel label1 = new JLabel("Appuyez sur 1 pour le niveau 1");
		JLabel label2= new JLabel ("Appuyez sur 2 pour le niveau 2");
		JLabel label3= new JLabel ("Appuyez sur 3 pour le niveau 3");
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		selection_niveau.add(panel);
		selection_niveau.addKeyListener(this);
		selection_niveau.setSize(300, 300); 
		selection_niveau.show();
	}

	void deplacement_heros()
	{
		//Fenetre qui affiche le labyrinthe, avec les infos pr?c?dentes
		selection_niveau.dispose();
		this.notre_heros = new Hero(nom.getText(),genre_heros,20,20,0,0);
		new labyrinthe(this.niveau,this.notre_heros);
		notre_heros.Affichage(notre_heros.matrice_plateau);
		f = new JFrame("Labyrinthe");
		f.getContentPane().setBackground(Color.GREEN);
		f.getContentPane().add(new Draw(notre_heros));
		f.addKeyListener(this);
		f.setSize(1300, 700);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();	

	}
	void fin_partie()
	{
		//Ecran de fin de partie lorsque le h?ros atteint l'arriv?e
		f.dispose();
		fin = new JFrame();
		JLabel message_fin= new JLabel("Bravo, vous avez gagn?");
		JPanel panel_fin = new JPanel();
		panel_fin.add(message_fin);
		JButton bouton_rejouer = new JButton("Rejouer avec le m?me joueur");
		bouton_rejouer.addActionListener(this);
		JButton bouton_changer = new JButton("Changer de joueur");
		bouton_changer.addActionListener(this);
		panel_fin.add(bouton_rejouer);
		panel_fin.add(bouton_changer);
		fin.add(panel_fin);
		fin.setSize(300,300);
		fin.setVisible(true);
		fin.show();
	}
	void perdue_partie()
	{
		//Ecran de fin de partie lorsque le h?ros n'a plus de points de vie
		f.dispose();
		fin = new JFrame();
		JLabel message_fin= new JLabel("Game Over ! :(");
		JPanel panel_fin = new JPanel();
		panel_fin.add(message_fin);
		JButton bouton_rejouer = new JButton("Rejouer avec le m?me joueur");
		bouton_rejouer.addActionListener(this);
		JButton bouton_changer = new JButton("Changer de joueur");
		bouton_changer.addActionListener(this);
		panel_fin.add(bouton_rejouer);
		panel_fin.add(bouton_changer);
		fin.add(panel_fin);
		fin.setSize(300,300);
		fin.setVisible(true);
		fin.show();			

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		//Fonction qui se d?clenche d?s qu'un bouton est press?, qui r?cup?re le code du bouton pour ensuite savoir quoi faire
		if (e.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			//D?placement al?atoire des monstres et fantomes
			double depMon;
			double depFan;
			for (int k=0;k<notre_heros.liste_fantome.size();k++)
			{
				depFan = Math.random();
				if (depFan<0.25)
				{
					notre_heros.liste_fantome.get(k).MoveDownFan();
				}
				if (depFan<0.50 && depFan>=0.25)
				{
					notre_heros.liste_fantome.get(k).MoveLeftFan();
				}
				if (depFan<0.75 && depFan>=0.5)
				{
					notre_heros.liste_fantome.get(k).MoveRightFan();
				}
				if (depFan>=0.75)
				{
					notre_heros.liste_fantome.get(k).MoveUpFan();
				}
			}
			for(int k=0;k<notre_heros.liste_monstre.size();k++)
			{
				depMon = Math.random();
				if (depMon<0.25)
				{
					notre_heros.liste_monstre.get(k).MoveDownMon();
				}
				if (depMon<0.50 && depMon>=0.25)
				{
					notre_heros.liste_monstre.get(k).MoveLeftMon();
				}
				if (depMon<0.75 && depMon>=0.5)
				{
					notre_heros.liste_monstre.get(k).MoveRightMon();
				}
				if (depMon>=0.75)
				{
					notre_heros.liste_monstre.get(k).MoveUpMon();
				}
			}
			notre_heros.MoveDown();
			//Actualisation de l'affichage :
			f.getContentPane().add(new Draw(notre_heros));
			f.show();
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) { 
			//D?placement al?atoire des monstres et fantomes
			double depMon;
			double depFan;
			for (int k=0;k<notre_heros.liste_fantome.size();k++)
			{
				depFan = Math.random();
				if (depFan<0.25)
				{
					notre_heros.liste_fantome.get(k).MoveDownFan();
				}
				if (depFan<0.50 && depFan>=0.25)
				{
					notre_heros.liste_fantome.get(k).MoveLeftFan();
				}
				if (depFan<0.75 && depFan>=0.5)
				{
					notre_heros.liste_fantome.get(k).MoveRightFan();
				}
				if (depFan>=0.75)
				{
					notre_heros.liste_fantome.get(k).MoveUpFan();
				}
			}
			for(int k=0;k<notre_heros.liste_monstre.size();k++)
			{
				depMon = Math.random();
				if (depMon<0.25)
				{
					notre_heros.liste_monstre.get(k).MoveDownMon();
				}
				if (depMon<0.50 && depMon>=0.25)
				{
					notre_heros.liste_monstre.get(k).MoveLeftMon();
				}
				if (depMon<0.75 && depMon>=0.5)
				{
					notre_heros.liste_monstre.get(k).MoveRightMon();
				}
				if (depMon>=0.75)
				{
					notre_heros.liste_monstre.get(k).MoveUpMon();
				}
			}
			notre_heros.MoveUp();
			//Actualisation de l'affichage :
			f.getContentPane().add(new Draw(notre_heros));
			f.show();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{ 
			//D?placement al?atoire des monstres et fantomes
			double depMon;
			double depFan;
			for (int k=0;k<notre_heros.liste_fantome.size();k++)
			{
				depFan = Math.random();
				if (depFan<0.25)
				{
					notre_heros.liste_fantome.get(k).MoveDownFan();
				}
				if (depFan<0.50 && depFan>=0.25)
				{
					notre_heros.liste_fantome.get(k).MoveLeftFan();
				}
				if (depFan<0.75 && depFan>=0.5)
				{
					notre_heros.liste_fantome.get(k).MoveRightFan();
				}
				if (depFan>=0.75)
				{
					notre_heros.liste_fantome.get(k).MoveUpFan();
				}
			}
			for(int k=0;k<notre_heros.liste_monstre.size();k++)
			{
				depMon = Math.random();
				if (depMon<0.25)
				{
					notre_heros.liste_monstre.get(k).MoveDownMon();
				}
				if (depMon<0.50 && depMon>=0.25)
				{
					notre_heros.liste_monstre.get(k).MoveLeftMon();
				}
				if (depMon<0.75 && depMon>=0.5)
				{
					notre_heros.liste_monstre.get(k).MoveRightMon();
				}
				if (depMon>=0.75)
				{
					notre_heros.liste_monstre.get(k).MoveUpMon();
				}
			}
			notre_heros.MoveLeft();
			//Actualisation de l'affichage :
			f.getContentPane().add(new Draw(notre_heros));
			f.show();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			//D?placement al?atoire des monstres et fantomes
			double depMon;
			double depFan;
			for (int k=0;k<notre_heros.liste_fantome.size();k++)
			{
				depFan = Math.random();
				if (depFan<0.25)
				{
					notre_heros.liste_fantome.get(k).MoveDownFan();
				}
				if (depFan<0.50 && depFan>=0.25)
				{
					notre_heros.liste_fantome.get(k).MoveLeftFan();
				}
				if (depFan<0.75 && depFan>=0.5)
				{
					notre_heros.liste_fantome.get(k).MoveRightFan();
				}
				if (depFan>=0.75)
				{
					notre_heros.liste_fantome.get(k).MoveUpFan();
				}
			}
			for(int k=0;k<notre_heros.liste_monstre.size();k++)
			{
				depMon = Math.random();
				if (depMon<0.25)
				{
					notre_heros.liste_monstre.get(k).MoveDownMon();
				}
				if (depMon<0.50 && depMon>=0.25)
				{
					notre_heros.liste_monstre.get(k).MoveLeftMon();
				}
				if (depMon<0.75 && depMon>=0.5)
				{
					notre_heros.liste_monstre.get(k).MoveRightMon();
				}
				if (depMon>=0.75)
				{
					notre_heros.liste_monstre.get(k).MoveUpMon();
				}
			}
			notre_heros.MoveRight();
			//Actualisation de l'affichage :
			f.getContentPane().add(new Draw(notre_heros));
			f.show();
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{ 
			notre_heros.attaque_hero();
			f.getContentPane().add(new Draw(notre_heros));
			f.show();
		}
		//Test si le h?ros est arriv?e :
		if (notre_heros.getPosition()[0]==notre_heros.position_arrivee[0] && notre_heros.getPosition()[1]==notre_heros.position_arrivee[1])
		{
			fin_partie();
		}
		//Test si le h?ros a encore des points de vie
		if (notre_heros.getPointVie()<=0)
		{
			perdue_partie();
		}
	}



	@Override
	public void keyTyped(KeyEvent e) 
	{
		if (e.getKeyChar()=='1')
		{
			this.niveau=1;
			deplacement_heros();
		}
		if (e.getKeyChar()=='2')
		{
			this.niveau=2;
			deplacement_heros();
		}
		if (e.getKeyChar()=='3')
		{
			this.niveau=3;
			deplacement_heros();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// pas d'action quand on relache la touche

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Action a effectuer en fonction des boutons sur lesquels on appuie
		if (e.getActionCommand() == "Valider")
		{
			donnee_joueur.dispose();
			System.out.println(genre.getSelectedIndex());
			if (genre.getSelectedIndex()== 0)
			{
				genre_heros='M';
			}
			if (genre.getSelectedIndex() == 1)
			{
				genre_heros='F';
			}
			niveau();
		}
		if (e.getActionCommand()=="Rejouer avec le m?me joueur")
		{
			fin.dispose();
			niveau();
		}
		if (e.getActionCommand()=="Changer de joueur")
		{
			fin.dispose();
			new principal();
		}
	}
}


