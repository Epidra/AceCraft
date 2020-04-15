package mod.acecraft.util;

import mod.acecraft.ShopKeeper;
import mod.shared.util.ContainerContent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;

import java.util.List;

public class FoundryContent extends ContainerContent {

    private List<Integer> amount;
    private List<String> type;

    private int size;
    private String result;

    public FoundryContent(){

    }

    public int getSize(){
        return size;
    }

    private void findSize(){
        size = 0;
        for(int i : amount){
            size += i;
        }
    }

    private void findResult(){
               if(findResult2("iron", 0.7f, "coal", 0.3f)){ result = "steel";
        } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "bronze";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "brass";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "questorium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "adamantium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "viridium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "kobalium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "denarium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "clavium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "aurelium";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "orichalcum";
       } else if(findResult2("copper", 0.7f, "tin", 0.3f)){ result = "darksteel";
        }
        result = "VOID";
    }

    private boolean findResult2(String item1, float scale1, String item2, float scale2){
        int i = 0;
        float amount1 = -1;
        float amount2 = -1;
        for(String s : type){
            if(s.contains(item1)){
                amount1 = amount.get(i);
            }
            if(s.contains(item2)){
                amount2 = amount.get(i);
            }
            i++;
        }
        if(amount1 == -1 || amount2 == -1) return false;
        float value1 = amount1/size;
        float value2 = amount2/size;
        if(value1 > scale1 -0.05f && value1 < scale1 + 0.05f){
            return value2 > scale2 - 0.05f && value2 < scale2 + 0.05f;
        }
        return false;
    }

    public String getResult(){
        return result;
    }

    public Item getResultItem(){
        if(result.matches("brass")) return ShopKeeper.INGOT_BRASS;
        if(result.matches("adamantium")) return ShopKeeper.INGOT_ADAMANTIUM;
        if(result.matches("orichalcum")) return ShopKeeper.INGOT_ORICHALCUM;
        if(result.matches("bronze")) return ShopKeeper.INGOT_BRONZE;
        if(result.matches("steel")) return ShopKeeper.INGOT_STEEL;

        return Items.STICK;
    }

    public boolean add(Item item){
        return add(item.getName().getString());
    }

    public boolean add(String string) {
        String refined = refineString(string);
        if(refined.matches("void")) return false;
        if(size == 64) return false;
        Boolean found = false;
        int i = 0;
        for(String s : type){
            if(s.matches(refined)){
                found = true;
                amount.set(i, amount.get(i) + 1);
            }
            i++;
        }
        if(!found){
            type.add(refined);
            amount.add(1);
        }
        findSize();
        findResult();
        return true;
    }

    private String refineString(String s){
        if(s.contains("iron")) return "iron";
        if(s.contains("gold")) return "gold";
        if(s.contains("coal")) return "coal";

        if(s.contains("brass")) return "brass";
        if(s.contains("questorium")) return "questorium";
        if(s.contains("gilium")) return "gilium";
        if(s.contains("adamantium")) return "adamantium";
        if(s.contains("viridium")) return "viridium";
        if(s.contains("zinc")) return "zinc";
        if(s.contains("kobalium")) return "kobalium";
        if(s.contains("denarium")) return "denarium";
        if(s.contains("mythril")) return "mythril";
        if(s.contains("clavium")) return "clavium";
        if(s.contains("aurelium")) return "aurelium";
        if(s.contains("nividium")) return "nividium";
        if(s.contains("tin")) return "tin";
        if(s.contains("orichalcum")) return "orichalcum";
        if(s.contains("scarletite")) return "scarletite";
        if(s.contains("copper")) return "copper";
        if(s.contains("bronze")) return "bronze";
        if(s.contains("steel")) return "steel";
        if(s.contains("darksteel")) return "darksteel";
        if(s.contains("unobtanium")) return "unobtanium";
        return "void";
    }

    public void read(CompoundNBT compound){
        int count = compound.getInt("ContentCount");
        type.clear();
        amount.clear();
        for(int i = 0; i < count; i++){
            type.add(compound.getString("ContentType" + i));
            amount.add(compound.getInt("ContentAmount" + i));
        }
    }

    public void write(CompoundNBT compound){
        compound.putInt("ContentCount", type.size());
        for (int i = 0; i < type.size(); i++){
            compound.putString("ContentType" + i, type.get(i));
            compound.putInt("ContentAmount" + i, amount.get(i));
        }
    }

}
