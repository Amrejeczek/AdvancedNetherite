package com.autovw.advancednetherite.datagen.providers;

import com.autovw.advancednetherite.AdvancedNetherite;
import com.autovw.advancednetherite.core.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author Autovw
 */
public class ModAdvancementProvider extends ForgeAdvancementProvider
{
    public ModAdvancementProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper)
    {
        super(packOutput, registries, existingFileHelper, List.of(new ModNetherAdvancements()));
    }

    public static class ModNetherAdvancements implements AdvancementGenerator
    {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper fileHelper)
        {
            Advancement.Builder.advancement()
                    .parent(new ResourceLocation("minecraft", "husbandry/obtain_netherite_hoe"))
                    .display(ModItems.NETHERITE_DIAMOND_HOE, Component.translatable("advancements.advancednetherite.husbandry.netherite_diamond_hoe.title"), Component.translatable("advancements.advancednetherite.husbandry.netherite_diamond_hoe.description"), null, FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(200))
                    .addCriterion("netherite_diamond_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DIAMOND_HOE))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "husbandry/obtain_netherite_diamond_hoe"));

            AdvancementHolder netheriteIronArmor = Advancement.Builder.advancement()
                    .parent(new ResourceLocation("minecraft", "nether/netherite_armor"))
                    .display(ModItems.NETHERITE_IRON_CHESTPLATE, Component.translatable("advancements.advancednetherite.nether.netherite_iron_armor.title"), Component.translatable("advancements.advancednetherite.nether.netherite_iron_armor.description"), null, FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(100))
                    .addCriterion("netherite_iron_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_IRON_HELMET, ModItems.NETHERITE_IRON_CHESTPLATE, ModItems.NETHERITE_IRON_LEGGINGS, ModItems.NETHERITE_IRON_BOOTS))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "nether/netherite_iron_armor"));

            AdvancementHolder netheriteGoldArmor = Advancement.Builder.advancement()
                    .parent(netheriteIronArmor)
                    .display(ModItems.NETHERITE_GOLD_CHESTPLATE, Component.translatable("advancements.advancednetherite.nether.netherite_gold_armor.title"), Component.translatable("advancements.advancednetherite.nether.netherite_gold_armor.description"), null, FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(100))
                    .addCriterion("netherite_gold_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_GOLD_HELMET, ModItems.NETHERITE_GOLD_CHESTPLATE, ModItems.NETHERITE_GOLD_LEGGINGS, ModItems.NETHERITE_GOLD_BOOTS))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "nether/netherite_gold_armor"));

            AdvancementHolder netheriteEmeraldArmor = Advancement.Builder.advancement()
                    .parent(netheriteGoldArmor)
                    .display(ModItems.NETHERITE_EMERALD_CHESTPLATE, Component.translatable("advancements.advancednetherite.nether.netherite_emerald_armor.title"), Component.translatable("advancements.advancednetherite.nether.netherite_emerald_armor.description"), null, FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(100))
                    .addCriterion("netherite_emerald_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_EMERALD_HELMET, ModItems.NETHERITE_EMERALD_CHESTPLATE, ModItems.NETHERITE_EMERALD_LEGGINGS, ModItems.NETHERITE_EMERALD_BOOTS))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "nether/netherite_emerald_armor"));

            Advancement.Builder.advancement()
                    .parent(netheriteEmeraldArmor)
                    .display(ModItems.NETHERITE_DIAMOND_CHESTPLATE, Component.translatable("advancements.advancednetherite.nether.netherite_diamond_armor.title"), Component.translatable("advancements.advancednetherite.nether.netherite_diamond_armor.description"), null, FrameType.CHALLENGE, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(200))
                    .addCriterion("netherite_diamond_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DIAMOND_HELMET, ModItems.NETHERITE_DIAMOND_CHESTPLATE, ModItems.NETHERITE_DIAMOND_LEGGINGS, ModItems.NETHERITE_DIAMOND_BOOTS))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "nether/netherite_diamond_armor"));

            AdvancementHolder netheriteIronIngot = Advancement.Builder.advancement()
                    .parent(new ResourceLocation("nether/obtain_ancient_debris"))
                    .display(ModItems.NETHERITE_IRON_INGOT, Component.translatable("advancements.advancednetherite.nether.obtain_netherite_iron_ingot.title"), Component.translatable("advancements.advancednetherite.nether.obtain_netherite_iron_ingot.description"), null, FrameType.TASK, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(20))
                    .addCriterion("netherite_iron_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_IRON_INGOT))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "nether/obtain_netherite_iron_ingot"));

            Advancement.Builder.advancement()
                    .parent(netheriteIronIngot)
                    .display(ModItems.NETHERITE_DIAMOND_BLOCK, Component.translatable("advancements.advancednetherite.nether.obtain_netherite_diamond_block.title"), Component.translatable("advancements.advancednetherite.nether.obtain_netherite_diamond_block.description"), null, FrameType.TASK, true, true, false)
                    .rewards(AdvancementRewards.Builder.experience(20))
                    .addCriterion("netherite_diamond_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_DIAMOND_BLOCK))
                    .save(consumer, new ResourceLocation(AdvancedNetherite.MOD_ID, "nether/obtain_netherite_diamond_block"));
        }
    }
}
