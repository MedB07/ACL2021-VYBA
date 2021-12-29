import java.util.ArrayList;

public class labyrinthe 
{
	int nbr_mur;
	public labyrinthe(int niveau, Plateau plateau)
	{
		plateau.liste_fantome= new ArrayList<Fantome>();
		plateau.liste_monstre= new ArrayList<Monster>();
		mur1 m1 = new mur1();
		mur1_2 m2 = new mur1_2();
		if (niveau==1)
		{
			
			for (int k=0;k<51;k++)
			{
				int i=Integer.parseInt(m1.mur11().get(k));
				int j=Integer.parseInt(m2.mur12().get(k));  
				plateau.matrice_plateau[i][j]=2;
			}
			int [] arrivee= {0,19};
			plateau.matrice_plateau[arrivee[0]][arrivee[1]]=5;
			plateau.position_arrivee=arrivee;
			
			int a=(int)(Math.random()*20);
			int b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (1,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (2,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (1,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (2,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			
		}
		if (niveau==2)
		{
			int [][] mur= {{6,0},{7,0},{8,0},{9,0},{10,0},{11,0},{1,1},{13,1},{14,1},{15,1},{1,2},{11,2},{15,2},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{11,3},{16,3},{17,3},{18,3},{19,3},{0,4},{8,4},{1,5},{2,5},{3,5},{4,5},{5,5},{6,5},{7,5},{8,5},{9,5},{10,5},{11,5},{12,5},{5,6},{6,6},{14,6},{16,6},{17,6},{18,6},{19,6},{13,7},{14,7},{10,8},{11,8},{14,8},{14,9},{0,10},{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10},{11,10},{12,10},{13,10},{14,10},{16,10},{17,10},{18,10},{19,10},{8,10},{14,10},{8,11},{14,11},{8,12},{9,12},{14,12},{16,12},{11,13},{16,13},{17,13},{18,13},{11,14},{16,14},{5,15},{6,15},{7,15},{8,15},{9,15},{16,15},{5,16},{18,16},{5,17},{10,17},{11,17},{12,17},{13,17},{14,17},{15,17},{16,17},{18,17},{5,18},{5,19},{6,19},{7,19}};
			for (int k=0;k<mur.length;k++)
			{
				plateau.matrice_plateau[mur[k][0]][mur[k][1]]=2;
			}
			int [] arrivee= {0,19};
			plateau.matrice_plateau[arrivee[0]][arrivee[1]]=5;
			plateau.position_arrivee=arrivee;
			int a=(int)(Math.random()*20);
			int b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add (new Monster (1,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (2,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (1,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (2,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (3,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (3,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
		}
		if (niveau==3)
		{
			int [][] mur= {{15,0},{16,0},{17,0},{18,0},{19,0},{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1},{8,1},{9,1},{18,1},{19,1},{0,2},{1,2},{2,2},{5,2},{6,2},{9,2},{12,2},{13,2},{14,2},{15,2},{16,2},{17,2},{18,2},{19,2},{9,3},{19,3},{1,4},{2,4},{3,4},{4,4},{5,4},{7,4},{9,4},{14,4},{19,4},{1,5},{2,5},{3,5},{5,5},{7,5},{12,5},{14,5},{3,6},{9,6},{10,6},{12,6},{14,6},{15,6},{16,6},{17,6},{18,6},{19,6},{0,7},{1,7},{2,7},{3,7},{4,7},{5,7},{6,7},{12,7},{0,8},{8,8},{9,8},{11,8},{12,8},{16,8},{17,8},{18,8},{19,8},{0,9},{2,9},{3,9},{4,9},{5,9},{6,9},{8,9},{10,9},{11,9},{12,9},{13,9},{14,9},{16,9},{17,9},{18,9},{19,9},{0,10},{2,10},{3,10},{0,11},{1,11},{2,11},{3,11},{4,11},{5,11},{7,11},{8,11},{9,11},{10,11},{12,11},{13,11},{15,11},{16,11},{17,11},{18,11},{19,11},{0,12},{12,12},{3,13},{6,13},{7,13},{8,13},{9,13},{11,13},{12,13},{13,13},{14,13},{15,13},{16,13},{18,13},{19,13},{2,14},{3,14},{6,14},{7,14},{8,14},{9,14},{12,14},{6,15},{7,15},{8,15},{9,15},{12,15},{16,15},{17,15},{18,15},{19,15},{0,16},{1,16},{4,16},{7,16},{8,16},{12,16},{14,16},{0,17},{1,17},{2,17},{4,17},{5,17},{6,17},{10,17},{12,17},{14,17},{15,17},{16,17},{17,17},{18,17},{9,18},{10,18},{15,18},{16,18},{2,19},{6,19},{7,19},{8,19},{9,19},{10,19},{11,19},{13,19}};
			for (int k=0;k<mur.length;k++)
			{
				plateau.matrice_plateau[mur[k][0]][mur[k][1]]=2;
			}
			int [] arrivee= {12,19};
			plateau.matrice_plateau[arrivee[0]][arrivee[1]]=5;
			plateau.position_arrivee= arrivee;
			int a=(int)(Math.random()*20);
			int b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (1,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (2,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (1,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (2,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add(new Monster (3,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_monstre.add( new Monster (4,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=3;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (3,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
			a=(int)(Math.random()*20);
			b=(int)(Math.random()*20);
			while (plateau.matrice_plateau[a][b]!=0)
			{
				a=(int)(Math.random()*20);
				b=(int)(Math.random()*20);
			}
			plateau.liste_fantome.add(new Fantome (4,100,a,b,plateau));
			plateau.matrice_plateau[a][b]=4;
		}
	}

}
