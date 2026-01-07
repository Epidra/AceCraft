package mod.acecraft.common.item;

import mod.lucky77.common.item.ItemBook;

public class ItemBookPlant extends ItemBook {
	
	public ItemBookPlant(int colorID, int bookID){
		super(colorID);
		createPages(bookID);
	}
	
	private void createPages(int id){
		this.addPage("Plants", "lorem ipsum");
	}
	
}
