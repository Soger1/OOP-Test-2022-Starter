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
			if (sel - 1 < 0)
			{
				sel = nemlist.size() - 1;
			}
			else
			{
				sel--;
			}
			fill(0);
			noStroke();
			square(0, 0, width + 40);

		}	
		if (keyCode == RIGHT)
		{
			if (sel + 1 >= nemlist.size())
			{
				sel = 0;
			}
			else
			{
				sel++;
			}
			fill(0);
			noStroke();
			square(0, 0, width + 40);	
		}	


	}

	class Nematode
	{
		int length, limbs, eyes;
		String name, gender;
		Nematode (TableRow row) {
			length = row.getInt("length");
			limbs = row.getInt("limbs");
			eyes = row.getInt("eyes");
			name = row.getString("name");
			gender = row.getString("gender");
		}

		public String toString(){
			return this.name + "is aNematode of length" + this.length + "eye status:" + this.eyes + "gender:" + this.gender + "limb status:" + this.eyes;
		}
	}


	public void settings()
	{
		size(800, 800, P3D);
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
			nemlist.add(new Nematode(row));
		}

	}


	int sel = 0; // selection var



	public void draw()
	{
		Nematode nematode = nemlist.get(sel);
		int lmod = (nematode.length * 30 / 2);

		/// MIDDLE NEMOTODE

		fill(0);
		noStroke();
		rect(width/2 -100 , 0,200 , height);
		stroke(255, 255, 255);

		pushMatrix();
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
		popMatrix();

		/// left NEMOTODE
		int lsel = sel;
		if (lsel - 1 <= 0)
			{
				lsel = nemlist.size()-1;
			}
			else
			{
				lsel--;
			}
		

		nematode = nemlist.get(lsel);

		pushMatrix();
		translate(width/3 * -1, 0, -600);
		// text display
		textSize(32);
		fill(255, 255, 255);
		text("LEFT", width/2  - (4 * 32 / 4), height/2 -lmod - 60 );
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
		popMatrix();

		/// right NEMOTODe

		int rsel = sel;
		if (rsel + 1 >= nemlist.size())
			{
				rsel = 0;
			}
			else
			{
				rsel++;
			}

		nematode = nemlist.get(rsel);
		pushMatrix();
		translate(width/3, 0, -600);
		// text display
		textSize(32);
		fill(255, 255, 255);
		text("RIGHT", width/2 - (4 * 32 / 4), height/2 -lmod - 60 );
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
		popMatrix();

		
		
	}
}
