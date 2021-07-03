package eu.midnightdust.nauticality;

import eu.midnightdust.nauticality.block.Algae;
import eu.midnightdust.nauticality.block.Cattail;
import eu.midnightdust.nauticality.config.NauticalityConfig;
import eu.midnightdust.nauticality.entity.GlowFishEntity;
import eu.midnightdust.nauticality.entity.PirateEntity;
import eu.midnightdust.nauticality.entity.SubmarineEntity;
import eu.midnightdust.nauticality.item.SubmarineItem;
import eu.midnightdust.nauticality.world.NauticalityConfiguredFeatures;
import eu.midnightdust.nauticality.world.feature.FeatureInjector;
import eu.midnightdust.nauticality.world.NauticalityStructures;
import eu.midnightdust.nauticality.world.structure.PirateShipStructure;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class NauticalityMain implements ModInitializer {
    public static final String MOD_ID = "nauticality";
    public static final ItemGroup NauticalityGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main"), () -> new ItemStack(NauticalityMain.SubmarineItem));
    public static final EntityType<GlowFishEntity> GLOW_FISH = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(MOD_ID,"glow_fish"), FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, GlowFishEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.3F)).trackRangeBlocks(4).build());
    public static final EntityType<PirateEntity> PIRATE = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(MOD_ID,"pirate"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PirateEntity::new).spawnableFarFromPlayer()
                    .dimensions(EntityDimensions.fixed(0.6F, 1.95F)).trackRangeBlocks(8).build());
    public static final EntityType<SubmarineEntity> SUBMARINE = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(MOD_ID,"submarine"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, SubmarineEntity::new)//(a,b) -> new SubmarineEntity(a,b))
                    .dimensions(EntityDimensions.fixed(1.6F, 1.6F)).trackRangeBlocks(1).build());
    public static Item GLOW_FISH_BUCKET;
    public static Item Eyepatch;
    public static Item SubmarineItem;
    public static Block Algae = new Algae(FabricBlockSettings.of(Material.ORGANIC_PRODUCT, MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.AZALEA_LEAVES));
    public static Block Cattail = new Cattail(FabricBlockSettings.of(Material.ORGANIC_PRODUCT, MapColor.BROWN).sounds(BlockSoundGroup.WET_GRASS).noCollision());


    @Override
    public void onInitialize() {
        NauticalityConfig.init("nauticality", NauticalityConfig.class);
        // Items
        Eyepatch = Registry.register(Registry.ITEM, new Identifier(MOD_ID,"eyepatch"), new Item(new FabricItemSettings().group(NauticalityGroup)));
        // Entities
        GLOW_FISH_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID,"glow_fish_bucket"), new EntityBucketItem(GLOW_FISH, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, (new Item.Settings()).maxCount(1).group(NauticalityGroup)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"glow_fish_spawn_egg"), new SpawnEggItem(GLOW_FISH,63246,63425, new FabricItemSettings().group(NauticalityGroup)));
        FabricDefaultAttributeRegistry.register(GLOW_FISH, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"pirate_spawn_egg"), new SpawnEggItem(PIRATE,78657,24561, new FabricItemSettings().group(NauticalityGroup)));
        FabricDefaultAttributeRegistry.register(PIRATE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_ATTACK_DAMAGE,4).add(EntityAttributes.GENERIC_ATTACK_SPEED,1.5).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,2));
        SubmarineItem = Registry.register(Registry.ITEM, new Identifier(MOD_ID,"submarine"), new SubmarineItem(new FabricItemSettings().group(NauticalityGroup)));
        // Blocks
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "algae"), Algae);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"algae"), new BlockItem(Algae, new FabricItemSettings().group(NauticalityGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cattail"), Cattail);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"cattail"), new BlockItem(Cattail, new FabricItemSettings().group(NauticalityGroup)));

        PirateShipStructure.init();
        NauticalityStructures.init();
        NauticalityConfiguredFeatures.init();
        FeatureInjector.init();
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.OCEAN).and(BiomeSelectors.spawnsOneOf(EntityType.TROPICAL_FISH)),SpawnGroup.WATER_AMBIENT, GLOW_FISH, 6, 3, 10);
    }
}
