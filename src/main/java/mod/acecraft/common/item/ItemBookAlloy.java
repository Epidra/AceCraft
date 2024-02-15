package mod.acecraft.common.item;

import mod.lucky77.item.ItemBook;

import static mod.acecraft.AceCraft.MODID;

public class ItemBookAlloy extends ItemBook {
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	/** Default Constructor */
	public ItemBookAlloy(int _colorID, int _bookID){
		super(_colorID);
		createPages(_bookID);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	private void createPages(int id){
		if(id == 1){ // Alloys
			this.addPage("Minerals", "", "", -1, MODID);
		}
		if(id == 2){ // Crops
			this.addPage("Crops", "", "", -1, MODID);
		}
		if(id == 3){ // Drink
			this.addPage("Drinks", "", "", -1, MODID);
		}
	}
	
	
	
}
