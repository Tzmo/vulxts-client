package dev.vulxts.module;

import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.KeybindSetting;
import dev.vulxts.settings.Setting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class Module {
   private final String name;
   private final String description;
   private final Category category;
   private final KeybindSetting keybind;
   private final List settings = new ArrayList();
   private boolean enabled;
   private BiConsumer toggleCallback;

   protected Module(String name, String description, Category category) {
      this.name = name;
      this.description = description;
      this.category = category;
      this.keybind = new KeybindSetting(Deobf.decrypt("=\u000f+Ga\u0086\u0081"), "Toggles " + name, -1);
   }

   protected Setting addSetting(Setting setting) {
      this.settings.add(setting);
      return setting;
   }

   public String getName() {
      return this.name;
   }

   public String getDescription() {
      return this.description;
   }

   public Category getCategory() {
      return this.category;
   }

   public KeybindSetting getKeybind() {
      return this.keybind;
   }

   public List getSettings() {
      return Collections.unmodifiableList(this.settings);
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   public void setEnabled(boolean enabled) {
      if (this.enabled != enabled) {
         this.enabled = enabled;
         if (enabled) {
            this.onEnable();
         } else {
            this.onDisable();
         }

         if (this.toggleCallback != null) {
            this.toggleCallback.accept(this, enabled);
         }
      }

   }

   void setToggleCallback(BiConsumer callback) {
      this.toggleCallback = callback;
   }

   public void toggle() {
      this.setEnabled(!this.enabled);
   }

   protected void onEnable() {
   }

   protected void onDisable() {
   }

   public void onTick() {
   }

   public boolean onKeyPress(int keyCode) {
      return false;
   }
}
