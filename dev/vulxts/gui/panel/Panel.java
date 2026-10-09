package dev.vulxts.gui.panel;

import dev.vulxts.gui.ClickGuiState;
import dev.vulxts.render.anim.Animation;
import dev.vulxts.render.nanovg.NVGRenderer;
import dev.vulxts.theme.Theme;
import dev.vulxts.theme.ThemeManager;
import dev.vulxts.util.Colors;
import dev.vulxts.util.UiSounds;

public abstract class Panel {
   public static final float WIDTH = 210.0F;
   public static final float HEADER_H = 38.0F;
   public static final float RADIUS = 6.0F;
   protected static final float CONTENT_PAD = 6.0F;
   private static final float FADE_ZONE = 16.0F;
   protected final ThemeManager themes;
   protected final ClickGuiState.PanelState ps;
   private final Animation open;
   private final Animation scroll = new Animation(200.0F, 0.0F);
   private float maxScroll;
   private boolean headerHovered;

   protected Panel(ThemeManager var1, ClickGuiState.PanelState var2) {
      this.themes = var1;
      this.ps = var2;
      this.open = new Animation(200.0F, var2.collapsed ? 0.0F : 1.0F);
   }

   protected Theme theme() {
      return this.themes.current();
   }

   public float x() {
      return this.ps.x;
   }

   public float y() {
      return this.ps.y;
   }

   public void moveTo(float var1, float var2) {
      this.ps.x = var1;
      this.ps.y = var2;
   }

   public void toggleCollapsed() {
      this.ps.collapsed = !this.ps.collapsed;
      this.open.setTarget(this.ps.collapsed ? 0.0F : 1.0F);
   }

   protected abstract String title();

   protected int icon() {
      return -1;
   }

   protected abstract float contentHeight(NVGRenderer var1);

   protected abstract void renderContent(NVGRenderer var1, float var2, float var3, float var4, float var5, float var6);

   protected float maxViewHeight(float var1) {
      return Math.max(60.0F, var1 - this.ps.y - 38.0F - 24.0F);
   }

   protected float viewHeight(NVGRenderer var1, float var2) {
      return Math.min(this.contentHeight(var1), this.maxViewHeight(var2)) * this.open.value();
   }

   public float totalHeight(NVGRenderer var1, float var2) {
      return 38.0F + this.viewHeight(var1, var2);
   }

   protected float edgeFade(float var1, float var2, float var3, float var4) {
      float var5 = Math.clamp((var2 - var3) / 16.0F, 0.0F, 1.0F);
      float var6 = Math.clamp((var4 - var1) / 16.0F, 0.0F, 1.0F);
      return Math.min(var5, var6);
   }

   public void render(NVGRenderer var1, float var2, float var3, float var4, float var5) {
      this.ps.x = Math.clamp(this.ps.x, -170.0F, var4 - 40.0F);
      this.ps.y = Math.clamp(this.ps.y, Math.min(70.0F, var5 - 38.0F), var5 - 38.0F);
      Theme var6 = this.theme();
      float var7 = this.viewHeight(var1, var5);
      boolean var8 = var7 > 0.5F;
      boolean var9 = this.headerHit(var2, var3);
      if (var9 && !this.headerHovered) {
         UiSounds.hover();
      }

      this.headerHovered = var9;
      var1.rect(this.ps.x + 2.0F, this.ps.y + 3.0F, 210.0F, 38.0F + var7, 2.0F, 1342177280);
      if (var8) {
         var1.rectVaryingGradient(this.ps.x, this.ps.y + 38.0F, 210.0F, var7, 0.0F, 0.0F, 2.0F, 2.0F, var6.background(), var6.backgroundTo());
      }

      float var10 = var8 ? 0.0F : 2.0F;
      var1.rectVaryingGradient(this.ps.x, this.ps.y, 210.0F, 38.0F, 2.0F, 2.0F, var10, var10, var6.headerTop(), var6.headerBottom());
      var1.rectOutline(this.ps.x, this.ps.y, 210.0F, 38.0F + var7, 2.0F, 1.0F, var9 ? -10458515 : -12959420);
      var1.rect(this.ps.x + 10.0F, this.ps.y, 34.0F, 2.0F, 1.0F, var9 ? var6.accentBright() : var6.accent());
      if (var8) {
         var1.line(this.ps.x + 1.0F, this.ps.y + 37.0F, this.ps.x + 209.0F, this.ps.y + 37.0F, 1.0F, -12959420);
      }

      float var11 = this.ps.x + 12.0F;
      int var12 = this.icon();
      if (var12 > 0) {
         var1.image(var12, this.ps.x + 12.0F, this.ps.y + 11.0F, 16.0F, 16.0F, var6.accentBright());
         var11 = this.ps.x + 38.0F;
      }

      var1.text(this.title(), var11, this.ps.y + 19.0F, 13.0F, var6.textPrimary());
      float var13 = this.ps.x + 210.0F - 16.0F;
      float var14 = this.ps.y + 19.0F;
      var1.save();
      var1.rect(var13 - 9.0F, var14 - 9.0F, 18.0F, 18.0F, 4.0F, Colors.withAlpha(var6.accent(), var9 ? 0.16F : 0.07F));
      var1.translate(var13, var14);
      var1.rotate((float)((double)this.open.value() * Math.PI / 2.0));
      var1.chevron(0.0F, 0.0F, 4.5F, 1.8F, var6.textMuted(), false);
      var1.restore();
      if (var8) {
         float var15 = this.ps.y + 38.0F;
         float var16 = var15 + var7;
         this.maxScroll = Math.max(0.0F, this.contentHeight(var1) - this.maxViewHeight(var5));
         this.scroll.setTarget(Math.clamp(this.scroll.getTarget(), 0.0F, this.maxScroll));
         var1.save();
         var1.scissor(this.ps.x, var15, 210.0F, var7);
         this.renderContent(var1, var15 + 6.0F - this.scroll.value(), var2, var3, var15, var16);
         var1.restore();
      }

   }

   public boolean headerHit(float var1, float var2) {
      return var1 >= this.ps.x && var1 <= this.ps.x + 210.0F && var2 >= this.ps.y && var2 <= this.ps.y + 38.0F;
   }

   public boolean bodyHit(NVGRenderer var1, float var2, float var3, float var4) {
      float var5 = this.viewHeight(var1, var4);
      return var2 >= this.ps.x && var2 <= this.ps.x + 210.0F && var3 >= this.ps.y + 38.0F && var3 <= this.ps.y + 38.0F + var5;
   }

   public void onScroll(double var1) {
      if (!(this.maxScroll <= 0.0F)) {
         this.scroll.setTarget(Math.clamp(this.scroll.getTarget() - (float)var1 * 38.0F, 0.0F, this.maxScroll));
      }

   }

   public boolean mouseClicked(float var1, float var2, int var3) {
      return false;
   }

   public void mouseDragged(float var1, float var2) {
   }

   public void mouseReleased() {
   }

   public boolean keyPressed(int var1) {
      return false;
   }

   public boolean charTyped(int var1) {
      return false;
   }

   public boolean isListening() {
      return false;
   }
}
