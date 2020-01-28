package mod.acecraft.tileentities;

public class TileEntityWaterwheel {

}

//public class TileEntityWaterwheel extends ITileEntityEnergy {
//
//    public void update(){
//        if(facing == null){
//            facing = world.getBlockState(pos).getValue(IMachinaEnergy.FACING);
//        } else {
//            int e = searchWater();
//            if(e != energy){
//                energy = e;
//                this.markDirty();
//            }
//        }
//        rotation = rotation + energy;
//        if(rotation >= 360) rotation -= 360;
//    }
//
//    private int searchWater(){
//        int e = 0;
//        if(facing == EnumFacing.NORTH){
//            //if(world.getBlockState(pos.add(-2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
//            if(world.getBlockState(pos.add(-1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
//
//            if(world.getBlockState(pos.add( 2, -1,  0)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 2,  0,  0)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 2,  1,  0)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 2,  2,  0)).getBlock() == Blocks.WATER) e += 0;
//        }
//        if(facing == EnumFacing.SOUTH){
//            //if(world.getBlockState(pos.add(-2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
//            if(world.getBlockState(pos.add(-1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
//
//            if(world.getBlockState(pos.add(-2, -1,  0)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add(-2,  0,  0)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add(-2,  1,  0)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add(-2,  2,  0)).getBlock() == Blocks.WATER) e += 0;
//        }
//        if(facing == EnumFacing.EAST){
//            //if(world.getBlockState(pos.add( 0, -2, -2)).getBlock() == Blocks.WATER) e += 0;
//            if(world.getBlockState(pos.add( 0, -2, -1)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 0, -2,  1)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 0, -2,  2)).getBlock() == Blocks.WATER) e += 0;
//
//            if(world.getBlockState(pos.add( 0, -1,  2)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 0,  0,  2)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 0,  1,  2)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 0,  2,  2)).getBlock() == Blocks.WATER) e += 0;
//        }
//        if(facing == EnumFacing.WEST){
//            //if(world.getBlockState(pos.add( 0, -2, -2)).getBlock() == Blocks.WATER) e += 0;
//            if(world.getBlockState(pos.add( 0, -2, -1)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 0, -2,  1)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 0, -2,  2)).getBlock() == Blocks.WATER) e += 0;
//
//            if(world.getBlockState(pos.add( 0, -1, -2)).getBlock() == Blocks.WATER) e += 15;
//            if(world.getBlockState(pos.add( 0,  0, -2)).getBlock() == Blocks.WATER) e += 35;
//            if(world.getBlockState(pos.add( 0,  1, -2)).getBlock() == Blocks.WATER) e += 15;
//            //if(world.getBlockState(pos.add( 0,  2, -2)).getBlock() == Blocks.WATER) e += 0;
//        }
//        return e;
//    }
//
//}
