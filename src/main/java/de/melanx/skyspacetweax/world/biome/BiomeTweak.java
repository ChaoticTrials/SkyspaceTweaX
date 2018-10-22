package de.melanx.skyspacetweax.world.biome;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import javax.annotation.Nullable;
import java.util.Random;

public class BiomeTweak implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        final int x = chunkX * 16 + 8;
        final int z = chunkZ * 16 + 8;

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));

        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) {
            generateFlower(BlockFlower.EnumFlowerType.OXEYE_DAISY, world, random, x, z);
        }

    }

    private void generateFlower(BlockFlower.EnumFlowerType flowerType, World world, Random random, int x, int z) {
        if (random.nextFloat() < 8) {
            final int posX = x + world.rand.nextInt(32);
            final int posZ = z + world.rand.nextInt(32);
            final BlockPos newPos = getGroundPos(world, posX, posZ);

            world.setBlockState(newPos, Blocks.RED_FLOWER.getStateFromMeta(8));
        }
    }

    @Nullable
    public static BlockPos getGroundPos(World world, int x, int z) {
        final BlockPos topPos = world.getHeight(new BlockPos(x, 0, z));
        if (topPos.getY() == 0) {
            return null;
        }

        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(topPos);

        IBlockState blockState = world.getBlockState(pos);
        while (isUnvalidBlock(blockState, world, pos) || canReplace(blockState, world, pos)) {
            pos.move(EnumFacing.DOWN);
            if (pos.getY() <= 0) {
                return null;
            }
            blockState = world.getBlockState(pos);

        }

        return pos.up();
    }

    public static boolean canReplace(IBlockState blockState, World world, BlockPos pos) {
        Block block = blockState.getBlock();
        return block.isReplaceable(world, pos) && !blockState.getMaterial().isLiquid();
    }

    public static boolean isUnvalidBlock(IBlockState blockState, World world, BlockPos pos) {
        Block block = blockState.getBlock();
        return block.isLeaves(blockState, world, pos) || block.isWood(world, pos);
    }

}
