package net.Alexator.hellworld.item.armor.material;

import net.Alexator.hellworld.Hellworld;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;


public record HellwordArmorMaterial(String name, int durability, int[] protection, int echanteability, SoundEvent equipsounds, float toughness, float knockbackResist, Supplier<Ingredient> RepairMaterial) implements ArmorMaterial {
//durabilidad base de la armorque se multiplica por el parametro que se pasa de durabilidad
private static  int[] DURABILITY_SLOT = new int[]{20,30,35,18};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABILITY_SLOT[slot.getIndex()]*durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.echanteability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipsounds;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.RepairMaterial.get();
    }

    @Override
    public String getName() {
        return Hellworld.MOD_ID +":"+ this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResist;
    }
}
