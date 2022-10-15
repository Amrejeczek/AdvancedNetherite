package com.autovw.advancednetherite.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author Autovw
 */
public class Config {
    public static final ForgeConfigSpec clientConfig;
    public static final Config.Client CLIENT;

    public static final ForgeConfigSpec commonConfig;
    public static final Config.Common COMMON;

    public static final ForgeConfigSpec serverConfig;
    public static final Config.Server SERVER;

    static {
        final Pair<Client, ForgeConfigSpec> clientConfigPair = new ForgeConfigSpec.Builder().configure(Client::new);
        clientConfig = clientConfigPair.getRight();
        CLIENT = clientConfigPair.getLeft();

        final Pair<Common, ForgeConfigSpec> commonConfigPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonConfig = commonConfigPair.getRight();
        COMMON = commonConfigPair.getLeft();

        final Pair<Server, ForgeConfigSpec> serverConfigPair = new ForgeConfigSpec.Builder().configure(Server::new);
        serverConfig = serverConfigPair.getRight();
        SERVER = serverConfigPair.getLeft();
    }

    public static void saveClientConfig() {
        clientConfig.save();
    }

    // CLIENT config
    public static class Client {
        public static ForgeConfigSpec.BooleanValue showTooltips;
        public static ForgeConfigSpec.BooleanValue matchingDurabilityBars;
        public static ForgeConfigSpec.BooleanValue enableSearchBarInCreativeTab;
        public static ForgeConfigSpec.BooleanValue forceDisableDetailArmorBarSupport;

        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("client");
            {
                showTooltips = builder
                        .comment("If true, displays tooltips, added by Advanced Netherite, with perks client-side. True by default.")
                        .translation("config.advancednetherite.client.show_tooltips")
                        .define("showTooltips", true);
                matchingDurabilityBars = builder
                        .comment("If true, displays a (color) matching durability bar underneath the item when damaged. False by default.")
                        .translation("config.advancednetherite.client.matching_durability_bars")
                        .define("matchingDurabilityBars", false);
                enableSearchBarInCreativeTab = builder
                        .comment("If true, enables a search bar in the Advanced Netherite creative tab. False by default.")
                        .translation("config.advancednetherite.client.enable_search_bar")
                        .define("enableSearchBarInCreativeTab", false);
                forceDisableDetailArmorBarSupport = builder
                        .comment("If true, forcefully disables support for Detail Armor Bar mod. Requires the game to be restarted. False by default.")
                        .translation("config.advancednetherite.client.force_disable_dab_support")
                        .define("forceDisableDetailArmorBarSupport", false);
            }
            builder.pop();
        }
    }

    // COMMON config
    public static class Common {
        public final ArmorConfig armorConfig;
        public final AdditionalDropsConfig additionalDropsConfig;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("common");
            {
                this.armorConfig = new ArmorConfig(builder);
                this.additionalDropsConfig = new AdditionalDropsConfig(builder);
            }
            builder.pop();
        }
    }

    public static class ArmorConfig {
        public static ForgeConfigSpec.BooleanValue ironPhantomPassiveArmor;
        public static ForgeConfigSpec.BooleanValue ironPiglinPassiveArmor;
        public static ForgeConfigSpec.BooleanValue ironEndermanPassiveArmor;

        public static ForgeConfigSpec.BooleanValue goldPhantomPassiveArmor;
        public static ForgeConfigSpec.BooleanValue goldPiglinPassiveArmor;
        public static ForgeConfigSpec.BooleanValue goldEndermanPassiveArmor;

        public static ForgeConfigSpec.BooleanValue emeraldPhantomPassiveArmor;
        public static ForgeConfigSpec.BooleanValue emeraldPiglinPassiveArmor;
        public static ForgeConfigSpec.BooleanValue emeraldEndermanPassiveArmor;

        public static ForgeConfigSpec.BooleanValue diamondPhantomPassiveArmor;
        public static ForgeConfigSpec.BooleanValue diamondPiglinPassiveArmor;
        public static ForgeConfigSpec.BooleanValue diamondEndermanPassiveArmor;

        public ArmorConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Configure properties related to armor perks here").push("armor_perks");
            {
                // Netherite-Iron Armor
                builder.comment("Configure properties related to Netherite-Iron armor here").push("netherite_iron_armor");
                {
                    ironPhantomPassiveArmor = builder.comment("If true, Phantoms behave neutral towards players wearing Netherite-Iron armor. True by default.").define("ironPhantomPassiveArmor", true);
                    ironPiglinPassiveArmor = builder.comment("If true, Piglins behave neutral towards players wearing Netherite-Iron armor. False by default.").define("ironPiglinPassiveArmor", false);
                    ironEndermanPassiveArmor = builder.comment("If true, Endermen behave neutral towards players wearing Netherite-Iron armor. False by default.").define("ironEndermanPassiveArmor", false);
                }
                builder.pop();

                // Netherite-Gold Armor
                builder.comment("Configure properties related to Netherite-Gold armor here").push("netherite_gold_armor");
                {
                    goldPhantomPassiveArmor = builder.comment("If true, Phantoms behave neutral towards players wearing Netherite-Gold armor. False by default.").define("goldPhantomPassiveArmor", false);
                    goldPiglinPassiveArmor = builder.comment("If true, Piglins behave neutral towards players wearing Netherite-Gold armor. True by default.").define("goldPiglinPassiveArmor", true);
                    goldEndermanPassiveArmor = builder.comment("If true, Endermen behave neutral towards players wearing Netherite-Gold armor. False by default.").define("goldEndermanPassiveArmor", false);
                }
                builder.pop();

                // Netherite-Emerald Armor
                builder.comment("Configure properties related to Netherite-Emerald armor here").push("netherite_emerald_armor");
                {
                    emeraldPhantomPassiveArmor = builder.comment("If true, Phantoms behave neutral towards players wearing Netherite-Emerald armor. False by default.").define("emeraldPhantomPassiveArmor", false);
                    emeraldPiglinPassiveArmor = builder.comment("If true, Piglins behave neutral towards players wearing Netherite-Emerald armor. False by default.").define("emeraldPiglinPassiveArmor", false);
                    emeraldEndermanPassiveArmor = builder.comment("If true, Endermen behave neutral towards players wearing Netherite-Emerald armor. True by default.").define("emeraldEndermanPassiveArmor", true);
                }
                builder.pop();

                // Netherite-Diamond Armor
                builder.comment("Configure properties related to Netherite-Diamond armor here").push("netherite_diamond_armor");
                {
                    diamondPhantomPassiveArmor = builder.comment("If true, Phantoms behave neutral towards players wearing Netherite-Diamond armor. False by default.").define("diamondPhantomPassiveArmor", false);
                    diamondPiglinPassiveArmor = builder.comment("If true, Piglins behave neutral towards players wearing Netherite-Diamond armor. True by default.").define("diamondPiglinPassiveArmor", true);
                    diamondEndermanPassiveArmor = builder.comment("If true, Endermen behave neutral towards players wearing Netherite-Diamond armor. True by default.").define("diamondEndermanPassiveArmor", true);
                }
                builder.pop();
            }
            builder.pop();
        }
    }

    public static class AdditionalDropsConfig {
        public static ForgeConfigSpec.BooleanValue enableAdditionalCropDrops;
        public static ForgeConfigSpec.BooleanValue enableAdditionalOreDrops;
        public static ForgeConfigSpec.BooleanValue enableAdditionalMobDrops;

        public AdditionalDropsConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Configure properties related to additional drop perks here. Drop chances can be modified using a datapack.").push("additional_drops");
            {
                enableAdditionalCropDrops = builder.comment("If true, enables additional crop drops for hoes. True by default.").define("enableAdditionalCropDrops", true);
                enableAdditionalOreDrops = builder.comment("If true, enables additional ore drops for pickaxes. Pickaxes with Silk Touch remain unaffected. True by default.").define("enableAdditionalOreDrops", true);
                enableAdditionalMobDrops = builder.comment("If true, enables additional ore drops for swords. True by default.").define("enableAdditionalMobDrops", true);
            }
            builder.pop();
        }
    }

    // SERVER config
    public static class Server {
        public final ToolConfig toolConfig;

        public Server(ForgeConfigSpec.Builder builder) {
            builder.push("server");
            {
                this.toolConfig = new ToolConfig(builder);
            }
            builder.pop();
        }
    }

    public static class ToolConfig {
        public static ForgeConfigSpec.IntValue ironBreakingSpeedMultiplier;
        public static ForgeConfigSpec.IntValue goldBreakingSpeedMultiplier;
        public static ForgeConfigSpec.IntValue emeraldBreakingSpeedMultiplier;
        public static ForgeConfigSpec.IntValue diamondBreakingSpeedMultiplier;

        public ToolConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Configure properties related to tools here.").push("tool_properties");
            {
                builder.comment("Configure tool properties related to block breaking speed here.").push("breaking_speed_multipliers");
                {
                    ironBreakingSpeedMultiplier = builder.comment("Block breaking speed multiplier for Netherite-Iron tools").defineInRange("ironBreakingSpeedMultiplier", 11, 1, 64);
                    goldBreakingSpeedMultiplier = builder.comment("Block breaking speed multiplier for Netherite-Gold tools").defineInRange("goldBreakingSpeedMultiplier", 13, 1, 64);
                    emeraldBreakingSpeedMultiplier = builder.comment("Block breaking speed multiplier for Netherite-Emerald tools").defineInRange("emeraldBreakingSpeedMultiplier", 15, 1, 64);
                    diamondBreakingSpeedMultiplier = builder.comment("Block breaking speed multiplier for Netherite-Diamond tools").defineInRange("diamondBreakingSpeedMultiplier", 17, 1, 64);
                }
                builder.pop();
            }
            builder.pop();
        }
    }
}
