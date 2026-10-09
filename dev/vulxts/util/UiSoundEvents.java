package dev.vulxts.util;

import dev.vulxts.rt.Deobf;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;

public final class UiSoundEvents {
   public static final class_3414 GUI_OPEN = register(Deobf.decrypt("\u0003\u0003|B}\u0081ºÕäěĽ"));
   public static final class_3414 GUI_CLOSE = register(Deobf.decrypt("\u0003\u0003|B}\u0081ºÙøđĠŞ"));
   public static final class_3414 HOVER = register(Deobf.decrypt("\u0003\u0003|Mg\u009e\u0080È"));
   public static final class_3414 TOGGLE_ON = register(Deobf.decrypt("\u0003\u0003|Qg\u008f\u0082Öñġļŕ"));
   public static final class_3414 TOGGLE_OFF = register(Deobf.decrypt("\u0003\u0003|Qg\u008f\u0082ÖñġļŝŦ"));
   public static final class_3414 SLIDER = register(Deobf.decrypt("\u0003\u0003|Vd\u0081\u0081ßæ"));
   public static final class_3414 SELECT = register(Deobf.decrypt("\u0003\u0003|Vm\u0084\u0080Ùà"));
   public static final class_3414 KEYBIND = register(Deobf.decrypt("\u0003\u0003|Nm\u0091\u0087ÓúĚ"));
   public static final class_3414 NOTIFY_ON = register(Deobf.decrypt("\u0003\u0003|Kg\u009c\u008cÜíġļŕ"));
   public static final class_3414 NOTIFY_OFF = register(Deobf.decrypt("\u0003\u0003|Kg\u009c\u008cÜíġļŝŦ"));
   public static final class_3414 STARTUP_SAD = register(Deobf.decrypt("\u0005\u001e3W|\u009d\u0095\u0094çğķ"));
   public static final class_3414 STARTUP_SONG = register(Deobf.decrypt("\u0005\u001e3W|\u009d\u0095\u0094çđĽŜ"));
   public static final class_3414 STARTUP_TIKI = register(Deobf.decrypt("\u0005\u001e3W|\u009d\u0095\u0094àėĸŒ"));
   public static final class_3414 STARTUP_VULXTS = register(Deobf.decrypt("\u0005\u001e3W|\u009d\u0095\u0094âċĿŃŴƿ"));

   private UiSoundEvents() {
   }

   private static class_3414 register(String name) {
      class_2960 id = class_2960.method_60655(Deobf.decrypt("\u0000\u001f>]|\u009b\u0086ÖýěĽŏ"), name);
      return (class_3414)class_2378.method_10230(class_7923.field_41172, id, class_3414.method_47908(id));
   }

   public static void bootstrap() {
   }
}
