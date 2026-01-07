package mod.acecraft.common.item;

import mod.lucky77.common.item.ItemBook;

public class ItemBookAlloy extends ItemBook {
	
	public ItemBookAlloy(int colorID, int bookID){
		super(colorID);
		createPages(bookID);
	}
	
	private void createPages(int id){
		this.addPage("Minerals", "lorem ipsum");
	}
	
}
