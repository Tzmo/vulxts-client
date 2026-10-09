package dev.vulxts.staff;

import dev.vulxts.module.impl.StaffListModule;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_268;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_640;

public final class StaffTracker {
   private final StaffListModule module;
   private volatile List current = List.of();
   private int ticks;
   private static volatile List debugInject;
   private static final Set CONFIRMED_STAFF_NAMES = Set.of("archivepedro");

   public StaffTracker(StaffListModule var1) {
      this.module = var1;
   }

   public List current() {
      return debugInject == null ? this.current : debugInject;
   }

   public void reset() {
      this.current = List.of();
      this.ticks = 0;
   }

   public void clear() {
      this.reset();
   }

   public void tick() {
      if (debugInject == null && this.module.isEnabled() && ++this.ticks % 10 == 0) {
         class_310 var1 = class_310.method_1551();
         class_634 var2 = var1.method_1562();
         if (var2 != null && var1.field_1724 != null) {
            ArrayList var3 = new ArrayList();
            Iterator var4 = var2.method_45732().iterator();

            while(var4.hasNext()) {
               class_640 var5 = (class_640)var4.next();
               class_268 var6 = var5.method_2955();
               String var7 = var5.method_2966().name();
               StaffEntry var8 = StaffDetector.classifyConfirmedBadge(var7, var5.method_2971(), var6 == null ? null : var6.method_1144(), var6 == null ? null : var6.method_1136(), var5.method_2959());
               if (var8 == null && CONFIRMED_STAFF_NAMES.contains(var7.toLowerCase(Locale.ROOT))) {
                  var8 = new StaffEntry(var7, "Staff", -16712568, false, var5.method_2959(), 2);
               }

               if (var8 != null) {
                  var3.add(var8);
               }
            }

            var3.sort(Comparator.comparing((var0) -> {
               return var0.name().toLowerCase(Locale.ROOT);
            }));
            this.current = List.copyOf(var3);
         } else {
            this.current = List.of();
         }
      }

   }

   public static void injectForTest(List var0) {
      debugInject = var0 == null ? null : List.copyOf(var0);
   }

   public static void clearInject() {
      debugInject = null;
   }
}
