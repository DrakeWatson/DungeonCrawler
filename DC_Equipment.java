
public class DC_Equipment
{
	public int weapon;
 public DC_Equipment(int weaponID){
	 weapon = weaponID;
 }
 public void change_Weapon(int weaponID){
	 weapon = weaponID;
 }
 
 public int weapon_Damage(){
	 if(weapon == 1) //Bronze Dagger
	 {
		 return 5;
	 }
	 else return 0;
 }
 public int weapon_Effects(){
	 if (weapon == 1)
	 {
		 return 0;
	 }
	 else
	 return 0;
 }
}
