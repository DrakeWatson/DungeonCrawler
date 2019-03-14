
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class VisualManager extends JFrame {
	
	JLabel label1,label2;
	JPanel panel1; 
	JTextArea textarea1, mapArea, battleArea, inventory;
	JButton button1, button2, button3, button4, button5;
	boolean goOn = false, vis = false, firstPhase = false, secondPhase = true;
	int x = 1;
	Movement_Checker player;
	World_Generation worldGen;
	char playerSymbol;
	char[][] map;
	int[][] intMap;
	int[] statArray;
	EventManager event;
	InventoryManager inventMang;
	public VisualManager(String VERSION, Movement_Checker player,World_Generation worldGen, InventoryManager inventMang) {
		this.inventMang = inventMang;
		event = new EventManager(this, inventMang);
		this.player = player;
		map = worldGen.printWorld();
		intMap = worldGen.returnWorld();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		this.setSize(700,600);
		
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(xPos,yPos);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Dungeon Crawler - " + VERSION);
		panel1 = new JPanel();
		label1 = new JLabel("Enter The Dungeon?");
		label2 = new JLabel("|DUNGEON CRAWLER|");
		panel1.add(label2);
		panel1.add(label1);
		this.add(panel1);

		
		button1 = new JButton("Yes");
		button2 = new JButton("No");
		button3 = new JButton("");
		button4 = new JButton("");
		button5 = new JButton("");
		button3.setVisible(true);
		button4.setVisible(true);
		button5.setVisible(false);
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.add(button5);
	
		ListenForButton lForButton = new ListenForButton();
		button1.addActionListener(lForButton);
		button2.addActionListener(lForButton);
		button3.addActionListener(lForButton);
		button4.addActionListener(lForButton);
		button5.addActionListener(lForButton);
		
		textarea1 = new JTextArea(20,30);
		panel1.add(textarea1);
		textarea1.setEditable(false);
		mapArea = new JTextArea(5,5);
		panel1.add(mapArea);
		mapArea.setEditable(false);
		battleArea = new JTextArea(20,40);
		panel1.add(battleArea);
		battleArea.setVisible(false);
		battleArea.setEditable(false);
		inventory = new JTextArea(15,20);
		panel1.add(inventory);
		inventory.setVisible(false);
		inventory.setEditable(false);
		
	}
	
	public int classSelection() {
		
		if (goOn != true) {
			displayMap();
		label1.setText("Welcome To The Dungeon! Would you like to begin? \n");
		}
		label1.setText("Please choose a class.");
		return 1;
		
		
	}
	public void runEvent(int spaceValue) {
		if(spaceValue > 0) {
			event.runEvent(spaceValue);
		}
		
	}
	public void displayMap() {
		
		mapArea.setText("" +    map[player.getX()-2][player.getY()-2] + map[player.getX()-1][player.getY()-2] + map[player.getX()][player.getY()-2]+ map[player.getX()+1][player.getY()-2] + map[player.getX()+2][player.getY()-2] +
						"\n"+	map[player.getX()-2][player.getY()-1] + map[player.getX()-1][player.getY()-1] + map[player.getX()][player.getY()-1]+ map[player.getX()+1][player.getY()-1] + map[player.getX()+2][player.getY()-1]+
						"\n"+	map[player.getX()-2][player.getY()] +   map[player.getX()-1][player.getY()] +   map[player.getX()][player.getY()]  + map[player.getX()+1][player.getY()]   + map[player.getX()+2][player.getY()  ] +
						"\n"+	map[player.getX()-2][player.getY()+1] + map[player.getX()-1][player.getY()+1] + map[player.getX()][player.getY()+1]+ map[player.getX()+1][player.getY()+1] + map[player.getX()+2][player.getY()+1] +
						"\n"+	map[player.getX()-2][player.getY()+2] + map[player.getX()-1][player.getY()+2] + map[player.getX()][player.getY()+2]+ map[player.getX()+1][player.getY()+2] + map[player.getX()+2][player.getY()+2]);
	
	}
	public void monsterGame() {
		
	}

			
	private class ListenForButton implements ActionListener {
		int eventNum;
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button1 && x == 1) {
				label2.setText("|DUNGEON CRAWLER|");
				label1.setText("Please choose a class!\n");
				button1.setText("Warrior");
				button2.setText("Rogue");
				button3.setText("Mage");
				firstPhase = true;
				
			}
			if (e.getSource() == button1 && x == 2 && event.isChecking() == false) { // Warrior
				playerSymbol = '♦';
				warriorClass();
				direction();
				secondPhase = true;
				
			}	
			if (e.getSource() == button2 && x == 2) { // Rogue
				playerSymbol = '♠';
				rogueClass();
				direction();
				secondPhase = true;
			}		
			if (e.getSource() == button3 && x == 2) { // Mage
				playerSymbol = '♣';
				mageClass();
				direction();
				secondPhase = true;
			}		
			if (e.getSource() == button5 && event.isChecking() == true) {
				event.returnToNormalFrame();
				
			}
			
			if(e.getSource() == button1 && x >= 3 && event.isChecking() == false) {//left
				if(player.direction(1) == true) {
					map[player.getX()][player.getY()] = playerSymbol;
					map[player.getX()+1][player.getY()] = '☐';
					intMap[player.getX()+1][player.getY()] = 0;
					displayMap();
					eventNum = intMap[player.getX()][player.getY()];
					runEvent(eventNum);
					
				}
			}
			if(e.getSource() == button2 && x >= 3) {//Right
				if(player.direction(3) == true) {
					map[player.getX()][player.getY()] = playerSymbol;
					map[player.getX()-1][player.getY()] = '☐';
					intMap[player.getX()-1][player.getY()] = 0;
					displayMap();
					eventNum = intMap[player.getX()][player.getY()];
					runEvent(eventNum);
					
				}
			}
			if(e.getSource() == button3 && x >= 3) {//up
				if(player.direction(4) == true) {
					map[player.getX()][player.getY()] = playerSymbol;
					map[player.getX()][player.getY()+1] = '☐';
					intMap[player.getX()][player.getY()+1] = 0;
					displayMap();
					eventNum = intMap[player.getX()][player.getY()];
					runEvent(eventNum);
					
				}
			}
			if(e.getSource() == button4 && x >= 3) {//down
				if(player.direction(2) == true) {
					map[player.getX()][player.getY()] = playerSymbol;
					map[player.getX()][player.getY()-1] = '☐';
					intMap[player.getX()][player.getY()-1] = 0;
					displayMap();
					eventNum = intMap[player.getX()][player.getY()];
					runEvent(eventNum);
					
				}
			}
			else if (e.getSource() == button2 && x == 1) {
				JOptionPane.showMessageDialog(null, "Coward!");
				System.out.println("First Phase:" + firstPhase + " Second Phase:" + secondPhase + " X:" + x);
				System.exit(0);
			}
		if (x == 1 && firstPhase == true) {
			firstPhase = false;
			x = 2;
			secondPhase = false;
			System.out.println("First Phase:" + firstPhase + " Second Phase:" + secondPhase + " X:" + x);
		}
		if (x == 2 && secondPhase == true) {
			x = 3;
			secondPhase = false;
			System.out.println("First Phase:" + firstPhase + " Second Phase:" + secondPhase + " X:" + x);
		}
	
		}

		public void direction() {
			label1.setText("Which way do you want to go?\n");
			displayMap();
			button4.setVisible(true);
			button1.setText("Left");
			button2.setText("Right");
			button3.setText("Up");
			button4.setText("Down");
		}
		public void warriorClass() {
			textarea1.append("You are a Warrior!\n");
			Dungeon_Crawler_Choose_Class Player_One = new Dungeon_Crawler_Choose_Class(1);	
			statArray = Player_One.getStats();
			event.setStats(statArray);
			label2.setText("|WARRIOR|");
			event.printStatsAndInventory(textarea1);
		}
		public void rogueClass() {
			textarea1.append("You are a Rogue!\n");
			Dungeon_Crawler_Choose_Class Player_One = new Dungeon_Crawler_Choose_Class(2);	
			statArray = Player_One.getStats();
			event.setStats(statArray);
			label2.setText("|ROGUE|");
			event.printStatsAndInventory(textarea1);
			
		}
		public void mageClass() {
			textarea1.append("You are a Mage!\n");
			Dungeon_Crawler_Choose_Class Player_One = new Dungeon_Crawler_Choose_Class(3);
			statArray = Player_One.getStats();
			event.setStats(statArray);
			label2.setText("|MAGE|");
			event.printStatsAndInventory(textarea1);
	}		
		
		}

		
}
	