
public class Dungeon_Crawler_Choose_Class
{
	public int choices;
	public Dungeon_Crawler_Choose_Class(int choice){

		this.choices = choice;
	}	
	
	public int[] getStats() {
		int[] x;
		
		x = new int[4];
		//Health
		if(choices == 1) //Warrior
		{
			x[0] = 50;
		}
		else if(choices == 2) //Rogue
		{
			x[0] = 40;
		}
		else if(choices == 3) //Mage
		{
			x[0] = 30;
		}
		//Attack
		if(choices == 1) //Warrior
		{
			x[1] = 10;
		}
		else if(choices == 2) //Rogue
		{
			x[1] = 6;
		}
		else if(choices == 3) //Mage
		{
			x[1] = 2;
		}
		// Defense
		if(choices == 1) //Warrior
		{
			x[2] = 6;
		}
		else if(choices == 2) //Rogue
		{
			x[2] = 4;
		}
		else if(choices == 3) //Mage
		{
			x[2] = 0;
		}
		 // Magic
		if(choices == 1) //Warrior 
		{
			x[3] = 6;
		}
		else if(choices == 2) //Rogue
		{
			x[3] = 10;
		}
		else if(choices == 3) //Mage
		{
			x[3] = 30;
		}
		return x;
	}
}
