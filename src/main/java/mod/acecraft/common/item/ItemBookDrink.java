package mod.acecraft.common.item;

import mod.lucky77.common.item.ItemBook;

public class ItemBookDrink extends ItemBook {
	
	public ItemBookDrink(int colorID, int bookID){
		super(colorID);
		createPages(bookID);
	}
	
	private void createPages(int id){
		this.addPage("Drinks", "lorem ipsum");
	}
	
}
