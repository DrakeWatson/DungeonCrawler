import java.util.Scanner;
import javax.swing.JOptionPane;

public class Dungeon_Crawler_Main
{
	Scanner scan = new Scanner(System.in);
	static int choice, length, width;
	static String Version = "Release 1.0";
	public static void main(String[] args)
	{
		
		World_Generation worldGen = new World_Generation(findDif(),findLength(),findWidth());
		worldGen.generateWorld();
		Movement_Checker movement = new Movement_Checker(worldGen.returnWorld(),worldGen.getLength(),worldGen.getWidth());
		InventoryManager inventMang = new InventoryManager();
		LootManager lootMang = new LootManager(inventMang);
		VisualManager window = new VisualManager(Version,movement,worldGen, inventMang);
		System.out.println(inventMang.getWeaponEffect());
		
	}


	static public int findLength() {
		int x = 0, y = 0;
		while (y != 1) {
		String anws = JOptionPane.showInputDialog("Select Length. (Short/Medium/Long)");
		if (anws.equals("Short")) {
			x = 10;
			y = 1;
		}
		else if (anws.equals("Medium")) {
			x = 20;
			y = 1;
		}
		else if (anws.equals("Long")) {
			x = 30;
			y = 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "Anwser not applicable.");
		}
		}
		return x;
	}
	static public int findWidth() {
		int x = 0, y = 0;
		while (y != 1) {
		String anws = JOptionPane.showInputDialog("Select Width. (Small/Medium/Wide)");
		if (anws.equals("Small")) {
			x = 15;
			y = 1;
		}
		else if (anws.equals("Medium")) {
			x = 30;
			y = 1;
		}
		else if (anws.equals("Wide")) {
			x = 50;
			y = 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "Anwser not applicable.");
		}
		}
		return x;
	}
	static public int findDif() {
		int x = 0, y = 0;
		while (y != 1) {
		
		String dif = JOptionPane.showInputDialog("Select Difficulty. (Easy/Medium/Hard/GodLike)");
		if (dif.equals("Easy")){
			x= 20;
			y = 1;
		}
		else if (dif.equals("Medium")) {
			x = 30;
			y = 1;
		}
		else if (dif.equals("Hard")) {
			x = 60;
			y = 1;
		}
		else if (dif.equals("GodLike")) {
			x = 100;
			y = 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "Anwser not applicable.");
		}
		}
		return x;
	}
}
