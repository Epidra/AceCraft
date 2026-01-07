package mod.acecraft.custom.logic;

import mod.acecraft.Register;
import mod.acecraft.custom.content.ContentFoundry;
import mod.lucky77.custom.logic.LogicBase;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class LogicFoundry extends LogicBase {
	
	public List<ContentFoundry> content = new ArrayList<>();
	
	public LogicFoundry(){
		createMaterialMap();
	}
	
	// Override from base
	public void load(String data){
		String[] split = data.split(",");
		for(int i = 0; i < split.length; i+=2){
			for(ContentFoundry cf : content){
				if(cf.id.matches(split[i])){
					cf.amount = Integer.parseInt(split[i+1]);
				}
			}
		}
	}
	
	public String save(){
		String data = "other,0";
		for(ContentFoundry cf : content){
			if(cf.amount > 0){
				data = data + "," + cf.id + "," + cf.amount;
			}
		}
		return data;
	}
	
	public void increase(String name){
		increase(name, 1);
	}
	
	public void increase(String name, int amount){
		for(ContentFoundry CF : content){
			if(CF.id.matches(name)){
				CF.amount += amount;
			}
		}
	}
	
	public int countONE(String value){
		for(ContentFoundry CF : content){
			if(CF.id.matches(value)){
				return CF.amount;
			}
		}
		return 0;
	}
	
	public int countALL(){
		int count = 0;
		for(ContentFoundry CF : content){
			count += CF.amount;
		}
		return count;
	}
	
	// needs better name
	public int countDIFF(){
		int count = 0;
		for(ContentFoundry CF : content){
			if(CF.amount > 0){
				count++;
			}
		}
		return count;
	}
	
	public void findBestMix(){
		int slag = countDIFF() + countONE("slag");
		String result = findFirstMix();
		int count = countALL() - slag;
		for(ContentFoundry CF : content){
			if(CF.id.matches("slag")){
				CF.amount = slag;
			} else if(CF.id.matches(result)){
				CF.amount = count;
			} else {
				CF.clear();
			}
		}
	}
	
	private String findFirstMix(){
		String lastID = "";
		int lastAmount = 0;
		for(ContentFoundry CF : content){
			if(CF.amount > lastAmount){
				lastAmount = CF.amount;
				lastID = CF.id;
			}
			if(CF.isAlloy()){
				int found = 0;
				for(ContentFoundry CF2 : content){
					for(int i = 0; i < 2; i++){
						if(CF.alloy.part(i).matches(CF2.id)){
							float count = (float) countALL();
							float p = ((float) CF2.amount / count) * 100.f;
							if(CF.alloy.percent(i) - CF.alloy.margin() <= p && p <= CF.alloy.percent(i) + CF.alloy.margin()){
								found++;
							}
						}
					}
				}
				if(found == 2){
					return CF.id;
				}
			}
		}
		return lastID;
	}
	
	private void createMaterialMap(){
		content.add(new ContentFoundry("slag", Register.STUFF_SLAG.get(), null));
		content.add(new ContentFoundry("tin", Register.STUFF_TIN_INGOT.get(), null));
		content.add(new ContentFoundry("mythril", Register.STUFF_MYTHRIL_INGOT.get(), null));
		content.add(new ContentFoundry("gilium", Register.STUFF_GILIUM_INGOT.get(), null));
		content.add(new ContentFoundry("iron", Items.IRON_INGOT, null));
		content.add(new ContentFoundry("gold", Items.GOLD_INGOT, null));
		content.add(new ContentFoundry("copper", Items.COPPER_INGOT, null));
		content.add(new ContentFoundry("bronze", Register.STUFF_BRONZE_INGOT.get(), null));
		content.add(new ContentFoundry("orichalcum", Register.STUFF_ORICHALCUM_INGOT.get(), null));
		content.add(new ContentFoundry("adamantium", Register.STUFF_ADAMANTIUM_INGOT.get(), null));
	}
	
}
