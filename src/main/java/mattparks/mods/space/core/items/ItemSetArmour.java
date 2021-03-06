package mattparks.mods.space.core.items;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

/**
 * A class for creating a basic set of armour.
 */
public class ItemSetArmour {
	private String texturePrefix;
	private ArmorMaterial material;
	private int renderIndex;
	
	public ItemArmour helmet;
	public ItemArmour chestplate;
	public ItemArmour leggings;
	public ItemArmour boots;

	public ItemSetArmour(String texturePrefix, ArmorMaterial material) {
		this.texturePrefix = texturePrefix;
		this.material = material;
		
		this.helmet = new ItemArmour(material.name() + "Helmet", 7, 0);
		this.chestplate = new ItemArmour(material.name()  + "Chestplate", 7, 1);
		this.leggings = new ItemArmour(material.name()  + "Leggings", 7, 2);
		this.boots = new ItemArmour(material.name()  + "Boots", 7, 3);
		
		try {
			registerRenderer();
		} catch(NoSuchMethodError e) {
		//	e.printStackTrace();
		}
	}

	@SideOnly(Side.CLIENT)
	private void registerRenderer() {
		this.renderIndex = RenderingRegistry.addNewArmourRendererPrefix(material.name());
	}

	public void registerItem() {
		SpaceCore.registerItem(helmet, true);
		SpaceCore.registerItem(chestplate, true);
		SpaceCore.registerItem(leggings, true);
		SpaceCore.registerItem(boots, true);
	}

	/**
	 * The object for each armour component.
	 */
	public class ItemArmour extends ItemArmor {
		public ItemArmour(String name, int par3, int par4) {
			super(material, par3, par4);
			this.setUnlocalizedName(name);
		}
	
		@Override
		public EnumRarity getRarity(ItemStack par1ItemStack) {
			return ClientProxy.RARITY_SPACE_ITEM;
		}
	
		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
			if (stack.getItem() == helmet) {
				return texturePrefix + "textures/model/armor/" + material.name() + "_1.png";
			} else if (stack.getItem() == chestplate || stack.getItem() == boots) {
				return texturePrefix + "textures/model/armor/" + material.name() + "_2.png";
			} else if (stack.getItem() == leggings) {
				return texturePrefix + "textures/model/armor/" + material.name() + "_3.png";
			}
	
			return null;
		}
	
		@Override
		public CreativeTabs getCreativeTab() {
			return SpaceCore.spaceItemsTab;
		}
	
		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister par1IconRegister) {
			this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName().replace("item.", texturePrefix));
		}
	
		@Override
		public Item setUnlocalizedName(String par1Str) {
			super.setTextureName(par1Str);
			super.setUnlocalizedName(par1Str);
			return this;
		}
	}
}
