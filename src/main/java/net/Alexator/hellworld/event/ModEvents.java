package net.Alexator.hellworld.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.ModEntityTypes;
import net.Alexator.hellworld.entity.custom.DummyEntity;
import net.Alexator.hellworld.entity.robots.LilyEntity;
import net.Alexator.hellworld.entity.robots.NanaEntity;
import net.Alexator.hellworld.item.ModItems;
import net.Alexator.hellworld.villager.ModVillager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.List;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = Hellworld.MOD_ID)
    public static class forgeEvents{

        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.SAKUCOIN.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKURITA.get(),2),
                        stack,30,8,0.02F));
            }


            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.COPPER_INGOT, 12);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),1),
                        stack,20,8,0.02F));
            }

            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.COAL, 12);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),1),
                        stack,20,8,0.02F));
            }

            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.IRON_INGOT, 8);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),1),
                        stack,15,8,0.02F));
            }


            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.GOLD_INGOT, 12);
                int villagerLevel = 3;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),1),
                        stack,20,8,0.02F));
            }

            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.REDSTONE, 12);
                int villagerLevel = 3;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),1),
                        stack,20,8,0.02F));
            }
            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.DIAMOND, 4);
                int villagerLevel = 4;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),4),
                        stack,5,8,0.02F));
            }
            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.EMERALD ,6);
                int villagerLevel = 4;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),1),
                        stack,10,8,0.02F));
            }

            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.ANCIENT_DEBRIS ,2);
                int villagerLevel = 5;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),12),
                        stack,4,8,0));
            }

            if(event.getType() == ModVillager.BLACKMARKET_CULTIST.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(Items.SHULKER_SHELL ,1);
                int villagerLevel = 5;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(ModItems.SAKUCOIN.get(),10),
                        stack,4,8,0));
            }



        }
    }


    @Mod.EventBusSubscriber(modid = Hellworld.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvent{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.DUMMY.get(), DummyEntity.setAttributes());
            event.put(ModEntityTypes.SERVANT_LILY.get(), LilyEntity.setAttributes());
            event.put(ModEntityTypes.SERVANT_NANA.get(), NanaEntity.setAttributes());
    }

}}
