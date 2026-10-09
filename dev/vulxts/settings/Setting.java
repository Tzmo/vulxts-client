package dev.vulxts.settings;

import com.google.gson.JsonElement;
import java.util.function.BooleanSupplier;

public abstract class Setting {
   private final String name;
   private final String description;
   protected Object value;
   protected final Object defaultValue;
   private BooleanSupplier visibility = () -> {
      return true;
   };

   protected Setting(String var1, String var2, Object var3) {
      this.name = var1;
      this.description = var2.replace("The Vulxts badge", "Vulxts Client watermark");
      this.value = var3;
      this.defaultValue = var3;
   }

   public String getName() {
      return this.name;
   }

   public String getDescription() {
      return this.description;
   }

   public Object get() {
      return this.value;
   }

   public void set(Object var1) {
      this.value = var1;
   }

   public void reset() {
      this.value = this.defaultValue;
   }

   public void visibleWhen(BooleanSupplier var1) {
      this.visibility = var1;
   }

   public boolean isVisible() {
      return this.visibility.getAsBoolean();
   }

   public abstract JsonElement toJson();

   public abstract void fromJson(JsonElement var1);
}
