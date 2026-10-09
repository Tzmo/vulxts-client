package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ModeSetting;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_5455;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_8053;
import org.jetbrains.annotations.Nullable;

public class ArmorTrimHiderModule extends Module {
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt(">\u00036@(\u009f\u008cÊñčųŌůƾƯƅǶȔȩɇɀ˛˯ˢ˖̟ͳ͜ͼϏνϜϥυЎѱѐѨґҿӾҤԒԮ\u0558վ\u0590\u05ceך֪\u0605ؓٔؾړڱڄ۰ܜܳ"), Deobf.decrypt(">\u00036@"), new String[]{Deobf.decrypt(">\u00036@"), Deobf.decrypt("$\u000b<Ag\u0085")}));
   public final BooleanSetting ownArmor = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("9\u001d<\u0005I\u009a\u0088Õæ"), Deobf.decrypt("7\u0006!J(\u0089\u0083ÜñĝħěŹƣƴǗƢȉȷɄȓʗʠ˂˙͑Ͷ́ͼ\u0380ΨΕλϦшѱКоҝңӱӡԌԳՒկ\u058cׇ"), true));
   private class_5455 cachedAccess;
   private final List materials = new ArrayList();
   private final List patterns = new ArrayList();

   public ArmorTrimHiderModule() {
      super(Deobf.decrypt("7\u0018?Jz¼\u0097ÓùĶĺşťƾ"), Deobf.decrypt(">\u00036@{È\u008aÈ´ČĲŕŤƣƬǌǸȃȳȊɄʏʽ˞ʗ̐ͥ͞;ΝϺρϡωАТ"), Category.MISC);
   }

   public boolean affectsOwn() {
      return (Boolean)this.ownArmor.get();
   }

   public @Nullable class_8053 mapTrim(class_1799 stack, @Nullable class_8053 original) {
      if (this.mode.is(Deobf.decrypt("$\u000b<Ag\u0085"))) {
         class_8053 random = this.randomTrim(stack);
         return random != null ? random : original;
      } else {
         return null;
      }
   }

   private @Nullable class_8053 randomTrim(class_1799 stack) {
      class_310 mc = class_310.method_1551();
      if (mc.field_1687 == null) {
         return null;
      } else {
         class_5455 access = mc.field_1687.method_30349();
         if (access != this.cachedAccess) {
            this.rebuildCache(access);
         }

         if (!this.materials.isEmpty() && !this.patterns.isEmpty()) {
            Random rng = new Random((long)stack.method_7909().method_7876().hashCode());
            class_6880 material = (class_6880)this.materials.get(rng.nextInt(this.materials.size()));
            class_6880 pattern = (class_6880)this.patterns.get(rng.nextInt(this.patterns.size()));
            return new class_8053(material, pattern);
         } else {
            return null;
         }
      }
   }

   private void rebuildCache(class_5455 access) {
      this.cachedAccess = access;
      this.materials.clear();
      this.patterns.clear();

      try {
         Stream var10000 = access.method_30530(class_7924.field_42083).method_42017();
         List var10001 = this.materials;
         Objects.requireNonNull(var10001);
         var10000.forEach(var10001::add);
         var10000 = access.method_30530(class_7924.field_42082).method_42017();
         var10001 = this.patterns;
         Objects.requireNonNull(var10001);
         var10000.forEach(var10001::add);
      } catch (Exception var3) {
         this.materials.clear();
         this.patterns.clear();
      }

   }

   protected void onDisable() {
      this.cachedAccess = null;
      this.materials.clear();
      this.patterns.clear();
   }
}
