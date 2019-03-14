import javax.swing.JOptionPane;


public class Movement_Checker
{
	int[][] map;
	int positionX, positionY, length, width;
	public Movement_Checker(int[][] map, int length, int width) {
		this.map = map;
		this.length = length;
		this.width = width;
		positionX = 3; 
		positionY = 3;
	}
	

	
	public boolean direction(int direction) {
		int x[] = new int[4];
		int y = 0;
		x = checkSides(positionX, positionY);
		if (direction == 1) {
			if (x[0] == 0) {
				positionX -= 1;
				System.out.println("X:" + positionX + " Y:" + positionY);
				return true;
			}
			else if (x[0] == 1) {
				return false;
			}
		}
		else if (direction == 3) {
			if (x[2] == 0) {
				positionX += 1;
				System.out.println("X:" + positionX + " Y:" + positionY);
				return true;
			}
			else if (x[2] == 1) {
				return false;
			}
		}
		else if (direction == 4) {
			if (x[3] == 0) {
				positionY -= 1;
				System.out.println("X:" + positionX + " Y:" + positionY);
				return true;
			}
			else if (x[3] == 1) {
				return false;
			}
		}
		else if (direction == 2) {
			if (x[1] == 0) {
				positionY += 1;
				System.out.println("X:" + positionX + " Y:" + positionY);
				return true;
			}
			else if (x[1] == 1) {
				return false;
				}
		}
		else {
			return false;
		}
		return false;
	}
	
	private int[] checkSides(int positionX, int positionY) {			//Left = x[0]
		int x[] = new int[4];											//Down = x[1]				0 = Able to move
		if (positionX <= 2) {											//Right = x[2]				1 = Unable to Move
			x[0] = 1;													//Up = x[3]		
			System.out.println("left");
		}
		if (positionX >= length - 3) {
			x[2] = 1;	
			System.out.println("Right: " + positionX + ">=" + (length - 2));
		}
		if (positionY <= 2) {
			System.out.println("up");
			x[3] = 1;																
		}
		if (positionY >= width - 3) {
			x[1] = 1; 
			System.out.println("Down: " + positionY + ">=" + (length - 2));
		}
		return x;
	}
	public void checkMap() {
		System.out.print(map[0][0]);
	}
	public int getX() {
		return positionX;
	}
	public int getY() {
		return positionY;
	}

	
}
