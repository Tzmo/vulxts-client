package dev.vulxts.theme;

import dev.vulxts.util.Colors;

public class Theme {
   private final String name;
   private int accent;
   private final boolean custom;

   public Theme(String var1, int var2, boolean var3) {
      this.name = var1;
      this.accent = var2;
      this.custom = var3;
   }

   public String getName() {
      return this.name;
   }

   public int accent() {
      return this.accent;
   }

   public void setAccent(int var1) {
      this.accent = var1;
   }

   public boolean isCustom() {
      return this.custom;
   }

   public int accentBright() {
      return Colors.lighten(this.accent(), 0.24F);
   }

   public int accentHover() {
      return Colors.withAlpha(this.accent(), 0.35F);
   }

   public int background() {
      return -182772192;
   }

   public int backgroundTo() {
      return -182772192;
   }

   public int headerTop() {
      return -14276051;
   }

   public int headerBottom() {
      return -14276051;
   }

   public int moduleActiveFill() {
      return Colors.lerp(-14407381, this.accent(), 0.12F);
   }

   public int textPrimary() {
      return -1578004;
   }

   public int textMuted() {
      return -6050384;
   }

   public int textDisabled() {
      return -9668998;
   }

   public int statusEnabled() {
      return this.accentBright();
   }

   public int statusDisabled() {
      return -13286824;
   }
}
