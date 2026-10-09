package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.render.StorageEspRenderer;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.IconListSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_310;

public class StorageEspModule extends Module {
   public final ModeSetting mode = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt(";\u00056@"), Deobf.decrypt("4\u0005*\u0005{\u009c\u009cÖñŞⅇěŨƣƭǉǭȑɠɅɆʔʣ˙˙̷̔ͣ͜ϏήχϲώЎнрѽґңӳҤԄԮՑձ"), Deobf.decrypt("9\u001f&Ia\u0086\u0080"), new String[]{Deobf.decrypt("9\u001f&Ia\u0086\u0080"), Deobf.decrypt("0\u001f>I")}));
   public final SliderSetting range = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("$\u000b<Bm"), Deobf.decrypt(";\u000b*\u0005l\u0081\u0096ÎõĐİŞĠƭǡǆǭȈȴɋɚʎʪ˂ʗ̘ͤ̓\u0379ΆνϝϿωКйсѻҐ"), 256.0, 16.0, 512.0, 8.0));
   public final SliderSetting highlightAlpha = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt(">\u00035Md\u0081\u0082ÒàŞĒŗŰƤƠ"), Deobf.decrypt("4\u0005*\u0005g\u0098\u0084ÙýĊĪěĨǼǬƗƷɓɩ"), 200.0, 0.0, 255.0, 1.0));
   public final BooleanSetting tracers = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Fm\u009a\u0096"), Deobf.decrypt("2\u00183R(\u0084\u008cÔñčųŝŲƣƬƅǶȎȥȊɐʒʠ˃˄̙Ͷ͚ͣϏήϚγυМвѝоҗҢөӰԃԮՓոև"), false));
   public final IconListSetting containers = (IconListSetting)this.addSetting(new IconListSetting(Deobf.decrypt("5\u0005<Qi\u0081\u008bßæč"), Deobf.decrypt("!\u0002;F`È\u0086ÕúĊĲŒŮƩƳƅǶȟȰɏɀˀʻ˟ʗ̙;͔\u0379\u0383γϒϻϔ")));
   public final BooleanSetting hideOpened;
   private final Set interactedBlocks = new HashSet();

   public StorageEspModule() {
      super(Deobf.decrypt("%\u001e=Wi\u008f\u0080ÿÇĮ"), Deobf.decrypt(">\u00035Md\u0081\u0082ÒàčųŘŨƩƲǑǱɊɠɈɒʒʽ˕˛̻̂̓͢·ίϙϸυЏТ"), Category.RENDER);
      StorageType[] var1 = StorageEspModule.StorageType.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         StorageType var4 = var1[var3];
         this.containers.add(var4.key, var4.label, var4.icon, var4.defaultEnabled, var4.defaultColor);
      }

      this.hideOpened = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt(">\u00036@(§\u0095ßúěķ"), Deobf.decrypt("2\u0005<\u0002|È\u008dÓóĖĿŒŧƤƵƅǡȉȮɞɒʉʡ˕˅̷̂͊;ΚϽσ϶\u0380МнчѻҕҩӾҤԍԷ\u0558ճ\u0590֊"), false));
   }

   public boolean isTypeEnabled(StorageType var1) {
      return this.containers.isEnabled(var1.key);
   }

   public int colorFor(StorageType var1) {
      return this.containers.color(var1.key);
   }

   public boolean hideOpened() {
      return (Boolean)this.hideOpened.get();
   }

   public boolean isInteracted(int var1, int var2, int var3) {
      return !this.interactedBlocks.isEmpty() && this.interactedBlocks.contains(new class_2338(var1, var2, var3));
   }

   public void clearInteractions() {
      this.interactedBlocks.clear();
   }

   public void trackInteraction(class_2338 var1) {
      if (var1 != null) {
         class_310 var4 = class_310.method_1551();
         if (var4.field_1687 != null) {
            this.interactedBlocks.add(var1.method_10062());
            class_2586 var5 = var4.field_1687.method_8321(var1);
            class_2745 var2;
            class_2680 var3;
            if (var5 instanceof class_2595 && (var3 = var4.field_1687.method_8320(var1)).method_26204() instanceof class_2281 && (var2 = (class_2745)var3.method_11654(class_2281.field_10770)) != class_2745.field_12569) {
               class_2350 var6 = (class_2350)var3.method_11654(class_2281.field_10768);
               class_2338 var7 = var1.method_10093(var2 == class_2745.field_12574 ? var6.method_10170() : var6.method_10160());
               this.interactedBlocks.add(var7);
            }
         }
      }

   }

   protected void onEnable() {
      this.interactedBlocks.clear();
   }

   public void onTick() {
      StorageEspRenderer.scan(this);
   }

   protected void onDisable() {
      StorageEspRenderer.clear();
   }

   public static enum StorageType {
      CHEST(Deobf.decrypt("\u0015\u00027V|"), Deobf.decrypt("5\u00027V|"), class_1802.field_8106, -22016, true),
      TRAPPED(Deobf.decrypt("\u0002\u00183Ux\u008d\u0081"), Deobf.decrypt("\"\u00183Ux\u008d\u0081\u009a×ĖĶňŴ"), class_1802.field_8247, -65536, true),
      ENDER(Deobf.decrypt("\u0013\u00046@z"), Deobf.decrypt("3\u00046@zÈ¦Òñčħ"), class_1802.field_8466, -8912641, true),
      SHULKER(Deobf.decrypt("\u0005\u0002'Ic\u008d\u0097"), Deobf.decrypt("%\u0002'Ic\u008d\u0097\u009aÖđī"), class_1802.field_8545, -47873, true),
      BARREL(Deobf.decrypt("\u0014\u000b Wm\u0084"), Deobf.decrypt("4\u000b Wm\u0084"), class_1802.field_16307, -7842560, true),
      SPAWNER(Deobf.decrypt("\u0005\u001a3Rf\u008d\u0097"), Deobf.decrypt("%\u001a3Rf\u008d\u0097"), class_1802.field_8849, -16711936, true),
      HOPPER(Deobf.decrypt("\u001e\u0005\"Um\u009a"), Deobf.decrypt(">\u0005\"Um\u009a"), class_1802.field_8239, -7829368, false),
      FURNACE(Deobf.decrypt("\u0010\u001f Ki\u008b\u0080"), Deobf.decrypt("0\u001f Ki\u008b\u0080"), class_1802.field_8732, -7566196, false);

      final String key;
      final String label;
      final class_1792 icon;
      final int defaultColor;
      final boolean defaultEnabled;

      private StorageType(String nullxx, String nullxxx, class_1792 nullxxxx, int nullxxxxx, boolean nullxxxxxx) {
         this.key = nullxx;
         this.label = nullxxx;
         this.icon = nullxxxx;
         this.defaultColor = nullxxxxx;
         this.defaultEnabled = nullxxxxxx;
      }

      // $FF: synthetic method
      private static StorageType[] $values() {
         return new StorageType[]{CHEST, TRAPPED, ENDER, SHULKER, BARREL, SPAWNER, HOPPER, FURNACE};
      }
   }
}
