package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{

		}		
	}

	class Nematode
	{
		int length, limbs, eyes;
		String name, gender;
		Nematode (int len, int limb, int eye, String names, String gen) {
			length = len;
			limbs = limb;
			eye = eyes;
			name = names;
			gender = gen;
		}
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();	
	}
	Table Nemtable;
	ArrayList<Nematode> nemlist = new ArrayList<Nematode>();
	public void loadNematodes()
	{
		Nemtable = loadTable("nematodes.csv", "header");
		for (TableRow row : Nemtable.rows()) {
			String name = row.getString("name");
			int length = row.getInt("length");
			int limbs = row.getInt("limbs");
			String gender = row.getString("gender");
			int eyes = row.getInt("eyes");
			nemlist.add(new Nematode(length, limbs, eyes, name, gender));
		}

	}

	int sel = 1;
	public void draw()
	{
		Nematode nematode = nemlist.get(sel);
		for(int i =0; i < nematode.length; i++ )
		{
			noFill();
			stroke(255, 255, 255);
			circle(width/2, height/2 + 30 * i, 30);

			if (nematode.limbs == 1){
				line(width/2 + 15, height/2 + 30 * i, width/2 + 30, height/2 + 30 * i);
				line(width/2 - 15, height/2 + 30 * i, width/2 - 30, height/2 + 30 * i);
			}
		}


		
	}
}
