
import javax.swing.JButton;
import javax.swing.JTextArea;


public class EventManager {
	public VisualManager vm;
	boolean isChecking = false;
	int[] playerStats;
	JTextArea textareaVar;
	InventoryManager inventMang;
	public EventManager(VisualManager vm, InventoryManager inventMang) {
		this.vm = vm;
		this.inventMang = inventMang;
	}
	public void runEvent(int levelOfMonster) {
	
		if (levelOfMonster > 0) {
		System.out.println(levelOfMonster);
		clearScreen();
		battleSequence(levelOfMonster);
		
		}
		if (levelOfMonster == -1) {
			
		}
	}
	public void returnToNormalFrame() {
		vm.button1.setText("Left");
		vm.button2.setText("Right");
		vm.button3.setText("Up");
		vm.button4.setText("Down");
		vm.button1.setVisible(true);
		vm.button2.setVisible(true);
		vm.button3.setVisible(true);
		vm.button4.setVisible(true);
		vm.label1.setVisible(true);
		vm.label2.setVisible(true);
		vm.mapArea.setVisible(true);
		vm.textarea1.setVisible(true);
		vm.button5.setVisible(false);
		vm.displayMap();
		setIsCheckingToFalse();
	}
	public void clearScreen() {
		isChecking = true;
	//	vm.button5.setVisible(true);
	//	vm.button5.setText("Press To Return");

		vm.button1.setVisible(false);
		vm.button2.setVisible(false);
		vm.button3.setVisible(false);
		vm.button4.setVisible(false);
		vm.label1.setVisible(false);
		vm.label2.setVisible(false);
		vm.mapArea.setVisible(false);
		vm.textarea1.setVisible(false);
		System.out.println(""+playerStats[0] + playerStats[1] + playerStats[2] + playerStats[3] );
	}
	public boolean isChecking() {
		return isChecking;
	}
	public void setIsCheckingToFalse() {
		isChecking = false;
	}
	public void battleSequence(int monsterLevel) {
		char[][] battleMap = new char[20][40];
		vm.label1.setVisible(true);
		vm.label1.setText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|Monster Level " + monsterLevel + "|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		vm.battleArea.setVisible(true);
		vm.inventory.setVisible(true);
		vm.inventory.setText("           »»»Stats««« \n" + "Health: \n       " + healthAmount() + "\n" + attackAmount() + "\n" + defenseAmount() + "\n" + magicAmount() + 
				"\n          »»»Inventory««« \n" + Inventory());
	}													 
	public void setStats(int stats[]) {
		playerStats = stats;
	}
	public void printStatsAndInventory(JTextArea textarea1) {
		textareaVar = textarea1;
		textareaVar.setText("           »»»Stats««« \n" + "Health: \n       " + healthAmount() + "\n" + attackAmount() + "\n" + defenseAmount() + "\n" + magicAmount() + 
				"\n          »»»Inventory««« \n" + Inventory());
	}
	public String healthAmount() {
		int playerHealth = playerStats[0] / 2;
		String hearts = "";
		int x = 0;
		for (int i = 0; i < playerHealth; i++) {
			if(x == 9) {
				x = 0;
				hearts = hearts + "\n       ";
			}
			 hearts = hearts + "♥";
			 x++;
		}
		return hearts;
		
	}
	public String attackAmount() {
		String attack = "";
		int playerAttack = playerStats[1];
		attack = "Attack:    " + playerAttack;
		return attack;
	}
	public String defenseAmount() {
		String defense = "";
		int playerDefense = playerStats[2];
		defense = "Defense:    " + playerDefense;
		return defense;
	}
	public String magicAmount() {
		String magic = "";
		int playerMagic = playerStats[3];
		magic = "Magic:    " + playerMagic;
		return magic;
	}
	public String Inventory() {

		return "Weapon: " + inventMang.getWeaponName() + "\n" +
			   "Spell: " + inventMang.getSpellName() + "\n" +
			   "HealthPotions: " + inventMang.getHealthPotionAmount() + "\n"
			  +"ManaPotions: " + inventMang.getManaPotionAmount() + "\n" +
			   "Misc: " + inventMang.itemList();
	}
	
}
