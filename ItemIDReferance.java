
public class ItemIDReferance {
	String[] weaponID,spellID,itemID;
	public ItemIDReferance() {
		
	}
	public String returnWeapon(int weapon) {			//Name-Damage-Effect-Rarity
		weaponID = new String[10];
		weaponID[0] = "Dagger|7|Sharp|1" ;
		weaponID[1] = "Broadsword|10|Heavy|1" ;
		weaponID[2] = "Staff|5|Sticky|1" ;
		return weaponID[weapon];
	}
	public String returnSpell(int spell) {			//Name-Damage-Effect-Cost-Rarity
		spellID = new String[10];
		spellID[0] = "Fireball|10|Burning|5|1" ;
		spellID[1] = "Frostblast|5|Freezing|3|1" ;
		spellID[2] = "Cleave|15|null|5|1" ;
		return spellID[spell];
	}
	public String returnItem(int item) {			//Name-effect-Rarity
		itemID = new String[10];
		itemID[0] = "Health Potion|Healing|1" ;
		itemID[1] = "Coin|Null|1" ;
		itemID[2] = "Null|Null|1" ;
		return itemID[item];
	}
}
