package com.autovw.advancednetherite.common.item;

import com.autovw.advancednetherite.api.annotation.Internal;
import com.autovw.advancednetherite.common.AdvancedUtil;
import com.autovw.advancednetherite.config.Config;
import com.autovw.advancednetherite.core.util.ModArmorTiers;
import com.autovw.advancednetherite.core.util.ModTooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

/**
 * Author: Autovw
 */
public class AdvancedArmorItem extends ArmorItem {
    private final ArmorMaterial material;

    public AdvancedArmorItem(ArmorMaterial material, EquipmentSlot equipmentSlot, Properties properties) {
        super(material, equipmentSlot, properties);
        this.material = material;
    }

    /**
     * {@link Override} this method if you want endermen to behave neutral towards the player when wearing the armor.
     *
     * @return If true, pacifies endermen. Also applies the tooltip.
     */
    public boolean pacifiesEndermen() {
        if (this.material == ModArmorTiers.NETHERITE_IRON)
            return Config.ArmorConfig.ironEndermanPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_GOLD)
            return Config.ArmorConfig.goldEndermanPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_EMERALD)
            return Config.ArmorConfig.emeraldEndermanPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_DIAMOND)
            return Config.ArmorConfig.diamondEndermanPassiveArmor.get();

        return false;
    }

    /**
     * {@link Override} this method if you want piglins to behave neutral towards the player when wearing the armor.
     *
     * @return If true, pacifies piglins. Also applies the tooltip.
     */
    public boolean pacifiesPiglins() {
        if (this.material == ModArmorTiers.NETHERITE_IRON)
            return Config.ArmorConfig.ironPiglinPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_GOLD)
            return Config.ArmorConfig.goldPiglinPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_EMERALD)
            return Config.ArmorConfig.emeraldPiglinPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_DIAMOND)
            return Config.ArmorConfig.diamondPiglinPassiveArmor.get();

        return false;
    }

    /**
     * {@link Override} this method if you want phantoms to behave neutral towards te player when the armor.
     *
     * @return If true, pacifies phantoms. Alo applies the tooltip.
     */
    public boolean pacifiesPhantoms() {
        if (this.material == ModArmorTiers.NETHERITE_IRON)
            return Config.ArmorConfig.ironPhantomPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_GOLD)
            return Config.ArmorConfig.goldPhantomPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_EMERALD)
            return Config.ArmorConfig.emeraldPhantomPassiveArmor.get();
        if (this.material == ModArmorTiers.NETHERITE_DIAMOND)
            return Config.ArmorConfig.diamondPhantomPassiveArmor.get();

        return false;
    }

    /**
     * Netherite items do not burn by default.
     * {@link Override} if you want to disable this feature.
     *
     * @return If true, item does not burn when on fire
     */
    @Override
    public boolean isFireResistant() {
        return true;
    }

    /**
     * {@link Override} this method if you want to add your own custom tooltips.
     *
     * @param stack     The item stack
     * @param level     The world/level
     * @param tooltips  List of tooltips
     * @param flag      Used to determine if a tooltip is only visible when debug mode (F3 + H) is enabled
     */
    public void addTooltips(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag flag) {
    }

    /**
     * {@link Override} this method if you want to give your item a custom durability bar color.
     * Feature is disabled by default, can be enabled in Advanced Netherite's Client config.
     *
     * @param stack The item stack
     * @return The custom durability bar color
     */
    @Nullable
    public ChatFormatting customDurabilityBarColor(ItemStack stack) {
        return null;
    }

    /* ================ INTERNAL, use alternatives linked in javadoc ================ */

    /**
     * Don't override this method, use: {@link AdvancedArmorItem#pacifiesPiglins()}
     */
    @Internal
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return pacifiesPiglins();
    }

    /**
     * Don't override this method, use: {@link AdvancedArmorItem#addTooltips(ItemStack, Level, List, TooltipFlag)} if you want to add your own custom tooltips.
     */
    @Internal
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (Config.Client.showTooltips.get()) {
            if (pacifiesEndermen()) tooltip.add(ModTooltips.ENDERMAN_PASSIVE_TOOLTIP);
            if (pacifiesPiglins()) tooltip.add(ModTooltips.PIGLIN_PASSIVE_TOOLTIP);
            if (pacifiesPhantoms()) tooltip.add(ModTooltips.PHANTOM_PASSIVE_TOOLTIP);

            // Adds all the tooltips from add-ons
            addTooltips(stack, world, tooltip, flag); // Add tooltips from add-ons
        }
    }

    /**
     * Don't override this method, use {@link AdvancedArmorItem#customDurabilityBarColor(ItemStack)} to change the custom durability bar color.
     */
    @Internal
    @Override
    public int getBarColor(ItemStack stack) {
        int originalColor = super.getBarColor(stack);

        if (customDurabilityBarColor(stack) != null && Config.Client.matchingDurabilityBars.get()) {
            return Objects.requireNonNull(customDurabilityBarColor(stack).getColor());
        }

        return AdvancedUtil.getDurabilityBarColor(originalColor, stack);
    }
}
