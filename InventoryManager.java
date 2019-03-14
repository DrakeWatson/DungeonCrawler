
public class InventoryManager {

	String weaponName = "", spellName = "", itemName = "";
	int weaponID,spellID,itemID,itemNum,itemType, hPotionAmount = 0,mPotionAmount = 0,x=0;
	String items = "";
	String itemIntegersString;
	public InventoryManager() {
		
	}
	public void addItem(int ID, int itemType) {
		this.itemNum = ID;
		this.itemType = itemType;
		if (itemType == 0) { //Weapon
			weaponID = ID;
		}
		if (itemType == 1) { //Spell
			spellID = ID;
		}
		if (itemType == 2) { //Health Potion
			hPotionAmount++;
		}
		if (itemType == 3) { //Mana Potion
			mPotionAmount++;
		}
		if (itemType == 4) { //Misc Item
			
			
			itemID = ID;
			if( x == 2) {
				x= 0;
				items = items + ",\n "  +getItemName();
			}
			else {
			items = items + ", "  +getItemName();
			itemIntegersString = "" + itemIntegersString + itemID;
			System.out.println(items);
			x++;
			}
		}
		 
	}
	public String getWeaponName() {
		char x;
		ItemIDReferance weaponRef = new ItemIDReferance();
		weaponName = weaponRef.returnWeapon(weaponID);
		String weaponString = "";
		for(int i = 0; i < weaponName.length(); i++){
			if (weaponName.charAt(i) == '|') {
				i = weaponName.length() + 1;
			}
			else {
				weaponString = weaponString + weaponName.charAt(i);
			}
			
		}
		return weaponString;
		}
	public int getWeaponAttack() {
		char x;
		boolean start = false;
		ItemIDReferance weaponRef = new ItemIDReferance();
		weaponName = weaponRef.returnWeapon(weaponID);
		String weaponAttack = "";
		int weaponAttackReturn;
		for(int i = 0; i < weaponName.length()-1; i++){
			if (weaponName.charAt(i) == '|' && start == false) {
				start = true;
			}
			else if (start == true) {
				if (weaponName.charAt(i) == '|') {
					i = weaponName.length() + 1;
				}
				else {
				weaponAttack = weaponAttack + weaponName.charAt(i);
				}
			}
			
		}
		weaponAttackReturn = Integer.parseInt(weaponAttack);
		return weaponAttackReturn;
		}
	public String getWeaponEffect() {
		char x;
		boolean start1 = false, start2 = false;
		ItemIDReferance weaponRef = new ItemIDReferance();
		weaponName = weaponRef.returnWeapon(weaponID);
		String weaponEffect = "";
		for(int i = 0; i < weaponName.length()-1; i++){
			if (weaponName.charAt(i) == '|' && start1 == false) {
				start1 = true;
			}
			else if (start1 == true) {
				if (weaponName.charAt(i) == '|' && start2 == false) {
					start2 = true;
				}
				else if (start2 == true){
					if (weaponName.charAt(i) == '|') {
						i = weaponName.length() + 1;
					}
					else
				weaponEffect = weaponEffect + weaponName.charAt(i);
				}
			}
			
		}
		
		return weaponEffect;
		}
	
	public String getSpellName() {
		char x;
		ItemIDReferance spellRef = new ItemIDReferance();
		spellName = spellRef.returnSpell(spellID);
		String spellString = "";
		for(int i = 0; i < spellName.length(); i++){
			if (spellName.charAt(i) == '|') {
				i = spellName.length() + 1;
			}
			else {
				spellString = spellString + spellName.charAt(i);
			}
			
		}
		return spellString;
		}
	public int getSpellAttack() {
		char x;
		boolean start = false;
		ItemIDReferance spellRef = new ItemIDReferance();
		spellName = spellRef.returnSpell(spellID);
		String spellAttack = "";
		int spellAttackReturn;
		for(int i = 0; i < spellName.length()-1; i++){
			if (spellName.charAt(i) == '|' && start == false) {
				start = true;
			}
			else if (start == true) {
				if (spellName.charAt(i) == '|') {
					i = spellName.length() + 1;
				}
				else {
					spellAttack = spellAttack + spellName.charAt(i);
				}
			}
			
		}
		spellAttackReturn = Integer.parseInt(spellAttack);
		return spellAttackReturn;
		}
	public String getSpellEffect() {
		char x;
		boolean start1 = false, start2 = false;
		ItemIDReferance spellRef = new ItemIDReferance();
		spellName = spellRef.returnSpell(weaponID);
		String spellEffect = "";
		for(int i = 0; i < spellName.length()-1; i++){
			if (spellName.charAt(i) == '|' && start1 == false) {
				start1 = true;
			}
			else if (start1 == true) {
				if (spellName.charAt(i) == '|' && start2 == false) {
					start2 = true;
				}
				else if (start2 == true){
					if (spellName.charAt(i) == '|') {
						i = spellName.length() + 1;
					}
					else
				spellEffect = spellEffect + spellName.charAt(i);
				}
			}
			
		}
		
		return spellEffect;
		}
	public String getItemName() {
		char x;
		ItemIDReferance itemRef = new ItemIDReferance();
		itemName = itemRef.returnItem(itemID);
		String itemString = "";
		for(int i = 0; i < itemName.length(); i++){
			if (itemName.charAt(i) == '|') {
				i = itemName.length() + 1;
			}
			else {
				itemString = itemString + itemName.charAt(i);
				
			}
			
		}
		return itemString;
		}
	public String itemList() {
	
		System.out.println(items);
		return items;
	}
	public int getHealthPotionAmount() {
		return hPotionAmount;
	}
	public int getManaPotionAmount() {
		return mPotionAmount;
	}
	public void useHealthPotion() {
		hPotionAmount--;
	}
	public void useManaPotion() {
		mPotionAmount--;
	}
}
