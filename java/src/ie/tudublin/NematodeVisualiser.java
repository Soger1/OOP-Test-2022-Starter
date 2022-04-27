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


	public void draw()
	{
		
	}
}
