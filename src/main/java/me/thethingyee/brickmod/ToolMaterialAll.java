package me.thethingyee.brickmod;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialAll implements ToolMaterial {

    @Override
    public int getDurability() {
        return 7000;
    }

    @Override
    public float getMiningSpeedMultiplier() { return 20f; }

    @Override
    public float getAttackDamage() {
        return 11f;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 40;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(brickmod.BRICK_INGOT);
    }
}
