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
			this.addPage("Minerals", "This book will be filled with valuable information in the future.", "", -1, MODID);
		}
		if(id == 2){ // Crops
			this.addPage("Crops", "This book will be filled with valuable information in the future.", "", -1, MODID);
		}
		if(id == 3){ // Drink
			this.addPage("Drinks", "This book will be filled with valuable information in the future.", "", -1, MODID);
		}
		this.addPage("", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.", "", -1, MODID);
	}
	
	
	
}
