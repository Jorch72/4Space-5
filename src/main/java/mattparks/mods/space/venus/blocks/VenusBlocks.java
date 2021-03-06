package mattparks.mods.space.venus.blocks;

import mattparks.mods.space.core.blocks.BlockBasics;
import mattparks.mods.space.core.blocks.BlockBuilder;
import mattparks.mods.space.core.builder.ICoreBlocks;
import mattparks.mods.space.venus.VenusCore;
import mattparks.mods.space.venus.items.VenusItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class VenusBlocks implements ICoreBlocks {
	public static BlockBasics venusBlock;
	public static BlockBasics decorBlock;
	public static BlockSulfurTorch sulfurTorch;
	public static BlockVenusianTNT venusianTNT;
	public static BlockEvolvedBlazeEgg evolvedBlazeEgg;
	
	@Override
	public void initBlocks() {
		venusBlock = new BlockBasics("venusBlock", VenusCore.instance.prefixTexture, new BlockBuilder[] {
			new BlockBuilder("venusSurfaceRock").setHardness(1.25f).setPlantable(true).setTerraformable(true),
			new BlockBuilder("venusSubRock").setHardness(1.0f),
			new BlockBuilder("venusRock").setHardness(1.5f),
			new BlockBuilder("venusCobblestone").setHardness(2.5f).setSealable(true),
			new BlockBuilder("venusVent").setHardness(22.0f).setResistance(30.0f).setSmokes(2.0f).setDropItem(VenusItems.venusItem), // TODO: DROP
			new BlockBuilder("venusBrickDungeon").setHardness(25.0f).setResistance(40.0f).setSealable(true),
			new BlockBuilder("venusOreSulfur").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOreUranium").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOreRuby").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOrePellucidum").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOreTin").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOreCopper").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOreIron").setHardness(2.5f).setValueable(true),
			new BlockBuilder("venusOreCoal").setHardness(2.5f).setValueable(true).setDropItem(Items.coal),
		});
		decorBlock = new BlockBasics("venusDecorBlock", VenusCore.instance.prefixTexture, new BlockBuilder[] {
			new BlockBuilder("venusBlockSulfur").setHardness(4.0f),
			new BlockBuilder("venusBlockUranium").setHardness(4.0f),
			new BlockBuilder("venusBlockRuby").setHardness(4.0f),
			new BlockBuilder("venusBlockPellucidum").setHardness(4.0f),
		});
		sulfurTorch = new BlockSulfurTorch("sulfurTorch");
		venusianTNT = new BlockVenusianTNT("venusianTNT");
		evolvedBlazeEgg = new BlockEvolvedBlazeEgg("evolvedBlazeEgg");
	}
	
	@Override
	public void setHarvestLevels() {
	}

	@Override
	public void registerBlocks() {
		venusBlock.registerBlock();
		decorBlock.registerBlock();
		sulfurTorch.registerBlock();
		venusianTNT.registerBlock();
		evolvedBlazeEgg.registerBlock();
	}

	@Override
	public void oreDictRegistration() {
		OreDictionary.registerOre("oreSulfur", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreSulfur")));
		OreDictionary.registerOre("oreUranium", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreUranium")));
		OreDictionary.registerOre("oreRuby", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreRuby")));
		OreDictionary.registerOre("orePellucidum", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOrePellucidum")));
		OreDictionary.registerOre("oreTin", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreTin")));
		OreDictionary.registerOre("oreCopper", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreCopper")));
		OreDictionary.registerOre("oreIron", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreIron")));
		OreDictionary.registerOre("oreCoal", new ItemStack(VenusBlocks.venusBlock, 1, venusBlock.getIndex("venusOreCoal")));
	}
}
