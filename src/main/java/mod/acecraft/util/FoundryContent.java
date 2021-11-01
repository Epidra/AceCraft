package mod.acecraft.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FoundryContent {

    public final String id;
    public final Item result;
    public final List<Item> substitutes;

    public final Alloy alloy;

    public int amount;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public FoundryContent(String id, Item item, Alloy alloy){
        this(id, item, new ArrayList<Item>(), alloy);
    }

    public FoundryContent(String id, Item result, List<Item> substitutes, Alloy alloy){
        this.id = id;
        this.result = result;
        this.substitutes = substitutes;
        this.alloy = alloy;
    }





    //----------------------------------------SUPPORT----------------------------------------//

    public boolean isAlloy(){
        return alloy != null;
    }

    public boolean tryToAddItem(Item item){
        for(Item i : substitutes){
            if(i == item){
                amount++;
                return true;
            }
        }
        return false;
    }

    public ItemStack generateStack(){
        return new ItemStack(result, amount);
    }

    public void clear(){
        amount = 0;
    }





    //----------------------------------------ALLOY----------------------------------------//

    public static class Alloy {

        public final int percent1;
        public final int percent2;
        public final String part1;
        public final String part2;
        public final int margin;

        public Alloy(int percent1, int percent2, String part1, String part2, int margin){
            this.percent1 = percent1;
            this.percent2 = percent2;
            this.part1 = part1;
            this.part2 = part2;
            this.margin = margin;
        }

    }



}
