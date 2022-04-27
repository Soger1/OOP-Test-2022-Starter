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
			eyes = eye;
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

	int sel = 7;
	public void draw()
	{
		Nematode nematode = nemlist.get(sel);
		int lmod = (nematode.length * 30 / 2);
		// text display
		textSize(32);
		fill(255, 255, 255);
		text(nematode.name, width/2 - (nematode.name.length() * 32 / 4), height/2 -lmod - 60 );

		for(int i =0; i < nematode.length; i++ ) // drawing body/limbs
		{
			noFill();
			stroke(255, 255, 255);
			circle(width/2, height/2 + 30 * i - lmod, 30);
			if (nematode.limbs == 1)
			{
				line(width/2 + 15, height/2 + 30 * i - lmod, width/2 + 30 , height/2 + 30 * i - lmod);
				line(width/2 - 15, height/2 + 30 * i - lmod, width/2 - 30, height/2 + 30 * i - lmod);
			}
		}

		// drawing gender
		stroke(255, 255, 255);
		if (nematode.gender.equals("m") || nematode.gender.equals("h"))
		{
			line(width/2, height / 2 + 30 * nematode.length - lmod - 15, width/2 , height / 2 + 30 * nematode.length + 5 - lmod);
			circle(width/2, height / 2 + 30 * nematode.length + 5 - lmod +5 , 10);
		}
		
		if (nematode.gender.equals("f") || nematode.gender.equals("h"))
		{
			circle(width /2 , height /2 + 30 * nematode.length - lmod - 30, 10);
		}

		// drawing eyes

		if (nematode.eyes == 1)
		{
			line(width / 2 - 10, height/2 - lmod - 10, width / 2 - 25, height/2 - lmod - 25 );
			line(width / 2 + 10, height/2 - lmod - 10, width / 2 + 25, height/2 - lmod - 25 );
			fill(0);
			circle(width / 2 + 25, height/2 - lmod - 25, 10);
			circle(width / 2 - 25, height/2 - lmod - 25, 10);
		}
		
	}
}
