package com.ultreon.masterweapons.datafixer;

import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.templates.TypeTemplate;
import net.minecraft.util.datafix.schemas.NamespacedSchema;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MWeaponsV2 extends NamespacedSchema {
    public MWeaponsV2(int versionKey, Schema parent) {
        super(versionKey, parent);
    }

    @Override
    public void registerTypes(Schema schema, Map<String, Supplier<TypeTemplate>> entityTypes, Map<String, Supplier<TypeTemplate>> blockEntityTypes) {
//        registerType(false, References.BLOCK_NAME, () -> DSL.constType(namespacedString()));
//        registerType(false, References.ITEM_NAME, () -> DSL.constType(namespacedString()));
    }

    @Override
    protected Map<String, Type<?>> buildTypes() {
        return new HashMap<>();
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerEntities(Schema schema) {
        return new HashMap<>();
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema schema) {
        return new HashMap<>();
    }
}
