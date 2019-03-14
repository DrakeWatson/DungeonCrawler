import java.util.Random;

import javax.swing.JOptionPane;


public class World_Generation
{
	
	static int length,width,numDif,dif,lootNum;
	static int[][] map;
	static char[][] visualMap;
	
 public World_Generation(int dif,int length, int width) {
	 this.dif = dif;
	 this.length = length;
	 this.width = width;
	
 }
 public void generateWorld(){
	
	 Random random = new Random();
	 dif += random.nextInt(120);
	 length += random.nextInt(40);
	 width += random.nextInt(40);
	 System.out.println("L" + length);
	 System.out.println("W" + width);
		map = new int[length][width];
		visualMap = new char[length][width];
		for (int i = 0; i < length; i++) {
			//System.out.println("");
			for (int j = 0; j < width; j++) {
				 lootNum = random.nextInt(15);
				if (i <= 5) {
					map[i][j] = random.nextInt(dif / 10);
				}
				if (j <= 5) {
					map[i][j] = random.nextInt(dif / 10);
				}
				if (i <= 15 && i > 5) {
					map[i][j] = random.nextInt(dif / 8);
				}
				if (j <= 15 && j > 5) {
					map[i][j] = random.nextInt(dif / 8);
				}
				if (i <= 30 && i > 15) {
					map[i][j] = random.nextInt(dif / 2);
				}
				if (j <= 30 && j > 15) {
					map[i][j] = random.nextInt(dif / 2);
				}
				if (i > 30) {
					map[i][j] = random.nextInt(dif);
				}
				if (j > 30) {
					map[i][j] = random.nextInt(dif);
				}
				if (lootNum == 0) {
					map[i][j] = -2;
				}
				map[3][3] = -1;
			}
		}
		
 }
 public char[][] printWorld() {
//	 System.out.println(length);
//	 System.out.println(width);
	 for (int i = 0; i < length; i++) {
			//System.out.println("");
			for (int j = 0; j < width; j++) {
				if (map[i][j] == -2) {
					visualMap[i][j] = '©';
				}
				if (map[i][j] == -1) {
					visualMap[i][j] = '#';
				}
				if (map[i][j] >= 0 && map[i][j] < 4) {
					visualMap[i][j] = 'O';
				}
				if (map[i][j] >= 4 && map[i][j] < 8) {
					visualMap[i][j] = '♟';
				}
				if (map[i][j] >= 8 && map[i][j] < 13) {
					visualMap[i][j] = '♞';
				}
				if (map[i][j] >= 13 && map[i][j] < 20) {
					visualMap[i][j] = '♝';
				}
				if (map[i][j] >= 20 && map[i][j] < 30) {
					visualMap[i][j] = '♜';
				}
				if (map[i][j] >= 30 && map[i][j] < 50) {
					visualMap[i][j] = '♛';
				}
				if (map[i][j] >= 50 && map[i][j] < 100) {
					visualMap[i][j] = '♚';
				}
				if (map[i][j] >= 100 && map[i][j] < 200) {
					visualMap[i][j] = '❄';
				}
				if (map[i][j] >= 200) {
					visualMap[i][j] = '✡';
				}
				visualMap[i][0] = '▐'; 
				visualMap[i][1] = '▐'; 
				visualMap[0][j] = '▐'; 
				visualMap[1][j] = '▐'; 
				visualMap[i][width-1] = '▐'; 
				visualMap[i][width-2] = '▐'; 
				visualMap[length-1][j] = '▐'; 
				visualMap[length-2][j] = '▐'; 
			//	System.out.print("|I" + i + "I|");
			//	System.out.print("|J" + j + "J|");
				
			//	System.out.print(visualMap[i][j]);
			
											}
	 								}
	return visualMap;

 						}
 public void defeatTile(int arrayX, int arrayY) {
	 map[arrayX][arrayY] = -1;
 }
 public int[][] returnWorld() {
	 return map;
 }
 public int getLength() {
	return length;
 }
 public int getWidth() {
	 return width;
 }

}
 
 
