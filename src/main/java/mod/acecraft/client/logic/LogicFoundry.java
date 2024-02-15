package mod.acecraft.client.logic;

import mod.acecraft.Register;
import mod.acecraft.util.FoundryContent;
import mod.lucky77.util.content.Dummy;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class LogicFoundry extends Dummy {
	
	public List<FoundryContent> content = new ArrayList<>();
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public LogicFoundry(){
		createMaterialMap();
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SAVE / LOAD  ---------- ---------- ---------- ---------- //
	
	public void load(String s){
		String[] split = s.split(",");
		for(int i = 0; i < split.length; i+=2){
			for(FoundryContent fc : content){
				if(fc.id.matches(split[i])){
					fc.amount = Integer.parseInt(split[i+1]);
				}
			}
		}
	}
	
	public String save(){
		String s = "other,0";
		for(FoundryContent fc : content){
			if(fc.amount > 0){
				s = s + "," + fc.id + "," + fc.amount;
			}
		}
		return s;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public void increase(String name){
		for(FoundryContent fc : content) {
			if(fc.id.matches(name)){
				fc.amount++;
			}
		}
	}
	
	public void increase(String name, int amount){
		for(FoundryContent fc : content) {
			if(fc.id.matches(name)){
				fc.amount += amount;
			}
		}
	}
	
	public int count(String value){
		for(FoundryContent fc : content){
			if(fc.id.matches(value)){
				return fc.amount;
			}
		}
		return 0;
	}
	
	public int count(){
		int count = 0;
		for(FoundryContent fc : content){
			count += fc.amount;
		}
		return count;
	}
	
	public int countDiff(){
		int count = 0;
		for(FoundryContent fc : content){
			if(fc.amount > 0){
				count++;
			}
		}
		return count;
	}
	
	public void findBestMix(){
		int slag = countDiff() + count("slag");
		String result = findFirstBestMix();
		int count = count() - slag;
		for(FoundryContent fc : content){
			if(fc.id.matches("slag")){
				fc.amount = slag;
			} else if(fc.id.matches(result)){
				fc.amount = count;
			} else {
				fc.clear();
			}
		}
	}
	
	private String findFirstBestMix(){
		String lastID = "";
		int lastAmount = 0;
		for(FoundryContent fc : content){
			if(fc.amount > lastAmount){
				lastAmount = fc.amount;
				lastID = fc.id;
			}
			if(fc.isAlloy()){
				int found = 0;
				for(FoundryContent f : content){
					if(fc.alloy.part1.matches(f.id)){
						float count = (float) count();
						float p = ((float) f.amount / count) * 100.0f;
						if(fc.alloy.percent1 - fc.alloy.margin <= p && p <= fc.alloy.percent1 + fc.alloy.margin){
							found++;
						}
					} else if(fc.alloy.part2.matches(f.id)){
						float count = (float) count();
						float p = ((float) f.amount / count) * 100.0f;
						if(fc.alloy.percent2 - fc.alloy.margin <= p && p <= fc.alloy.percent2 + fc.alloy.margin){
							found++;
						}
					}
				}
				if(found == 2){
					return fc.id;
				}
			}
		}
		
		return lastID;
	}
	
	private void createMaterialMap(){
		content.add(new FoundryContent("slag",       Register.STUFF_SLAG.get(),    null));
		content.add(new FoundryContent("tin",        Register.INGOT_TIN.get(),     null));
		content.add(new FoundryContent("mythril",    Register.INGOT_MYTHRIL.get(), null));
		content.add(new FoundryContent("gilium",     Register.INGOT_GILIUM.get(),  null));
		content.add(new FoundryContent("iron",       Items.IRON_INGOT,   null));
		content.add(new FoundryContent("gold",       Items.GOLD_INGOT,   null));
		content.add(new FoundryContent("copper",     Items.COPPER_INGOT, null));
		content.add(new FoundryContent("bronze",     Register.INGOT_BRONZE.get(),     new FoundryContent.Alloy(90, 10, "copper",  "tin", 5)));
		content.add(new FoundryContent("orichalcum", Register.INGOT_ORICHALCUM.get(), new FoundryContent.Alloy(80, 20, "mythril", "tin", 5)));
		content.add(new FoundryContent("adamantium", Register.INGOT_ADAMANTIUM.get(), new FoundryContent.Alloy(80, 20, "gilium",  "tin", 5)));
	}
	
	
	
}
