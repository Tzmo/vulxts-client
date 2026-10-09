package dev.vulxts.module.impl;

import dev.vulxts.module.Category;
import dev.vulxts.module.Module;
import dev.vulxts.rt.Deobf;
import dev.vulxts.settings.BooleanSetting;
import dev.vulxts.settings.ColorSetting;
import dev.vulxts.settings.ModeSetting;
import dev.vulxts.settings.SliderSetting;
import dev.vulxts.util.Colors;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import net.minecraft.class_310;
import net.minecraft.class_746;

public class CustomAccessoriesModule extends Module {
   public final ColorSetting color = (ColorSetting)this.addSetting(new ColorSetting(Deobf.decrypt("5\u0005>Jz"), Deobf.decrypt("4\u000b!@(\u009c\u008cÔàŞĵŔŲǬƤǓǧȔȹȊɒʃʬ˕˄̂\u0378́ͨ"), -49508));
   public final BooleanSetting rainbow = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("$\u000b;Kj\u0087\u0092"), Deobf.decrypt("5\u00131ImÈ\u0080ÌñČĪěšƯƢǀǱȕȯɘɊˀʻ˘˅̞͔͢\u0379Ϗήϝ϶\u0380ЏаќѰҖҢӰ"), false));
   public final SliderSetting glow = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("1\u0006=R"), Deobf.decrypt("%\u00054Q(\u0087\u0090ÎñČžœšƠƮƅǫȈȴɏɝʓʦ˄ˎ"), 70.0, 0.0, 100.0, 5.0, Deobf.decrypt("S")));
   public final BooleanSetting firstPerson = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("0\u0003 V|Èµßæčļŕ"), Deobf.decrypt("7\u0006!J(\u009b\u008dÕãŞĪŔŵƾǡǄǡȅȥəɀʏʽ˙˒̷͚̂ͿϏμϜϡϓЉѼхѻ҆ҾӨӪՂԱՔու"), false));
   public final BooleanSetting cape = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u000b\"@"), Deobf.decrypt("7J4Ig\u009f\u008cÔóŞİŗůƸƩƅǡȇȰɏȓʄʠˇ˙͑ͮͤ͜ΝϺϗϲσЖ"), true));
   public final ModeSetting capeStyle = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("5\u000b\"@(»\u0091Ãøě"), Deobf.decrypt("5\u000b\"@(\u0084\u008aÕÿ"), Deobf.decrypt(" \u001f>]|\u009b"), new String[]{Deobf.decrypt(" \u001f>]|\u009b"), Deobf.decrypt("!\u000b$@"), Deobf.decrypt("1\u0018;A"), Deobf.decrypt("%\u0005>Ll")}));
   public final BooleanSetting capePhysics = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u000b\"@(¸\u008dÃçėİň"), Deobf.decrypt("%\u001d3\\(ÎÅØýĒĿŔŷǬƶǌǶȎɠɓɜʕʽʐ˚̞͖͡ͼΊδρ"), true));
   public final BooleanSetting trail = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("\"\u00183Ld"), Deobf.decrypt("7J5Ig\u009f\u008cÔóŞħŉšƥƭƅǮȃȦɞȓʂʪ˘˞̟ͳ̓ͰΜϺόϼϕѝмњѨґ"), true));
   public final ModeSetting trailStyle = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("\"\u00183LdÈ¶ÎíĒĶ"), Deobf.decrypt("\"\u00183LdÈ\u0089Õûĕ"), Deobf.decrypt("$\u00030Gg\u0086"), new String[]{Deobf.decrypt("$\u00030Gg\u0086"), Deobf.decrypt("%\u001a3Wc\u0084\u0080"), Deobf.decrypt("3\t:J")}));
   public final SliderSetting trailLength = (SliderSetting)this.addSetting(new SliderSetting(Deobf.decrypt("\"\u00183LdÈ©ßúęħœ"), Deobf.decrypt(">\u0005%\u0005d\u0087\u008bÝ´ĊĻŞĠƸƳǄǫȊɠɆɚʎʨ˕˅̂"), 1.2, 0.2, 4.0, 0.1, Deobf.decrypt("\u0005")));
   public final BooleanSetting aura = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("7\u001f D"), Deobf.decrypt("7\u0004rJz\u008a\u008cÎýĐĴěšƹƳǄƢȇȲɅɆʎʫʐˎ̞̱́͢Ήοϐϧ"), false));
   public final ModeSetting auraStyle = (ModeSetting)this.addSetting(new ModeSetting(Deobf.decrypt("7\u001f D(»\u0091Ãøě"), Deobf.decrypt("7\u001f D(\u0084\u008aÕÿ"), Deobf.decrypt("9\u00180L|"), new String[]{Deobf.decrypt("9\u00180L|"), Deobf.decrypt("$\u0003<B")}));
   public final BooleanSetting crown = (BooleanSetting)this.addSetting(new BooleanSetting(Deobf.decrypt("5\u0018=Rf"), Deobf.decrypt("7J4Ig\u0089\u0091ÓúęſěųƼƨǋǬȏȮɍȓʶʺ˜ˏ̅ͤ̓Ͱ\u038dεσ϶\u0380ЄорѬӔҥӢӥԆ"), false));
   private final Deque trailNodes = new ArrayDeque();
   private static final int MAX_TRAIL = 256;

   public CustomAccessoriesModule() {
      super(Deobf.decrypt("5\u001f!Qg\u0085¤Ù÷ěĠňůƾƨǀǱ"), Deobf.decrypt("5\u0006;@f\u009cÈÉýĚĶěţƣƲǈǧȒȩɉɀˀ⋛ʐ˔͖̐ͧ̽ϏήχϲωБѽЕѿҁҿӦҤՄէ՞կ֚֙ו"), Category.VISUALS);
      ModeSetting var10000 = this.capeStyle;
      BooleanSetting var10001 = this.cape;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
      BooleanSetting var1 = this.capePhysics;
      var10001 = this.cape;
      Objects.requireNonNull(var10001);
      var1.visibleWhen(var10001::get);
      var10000 = this.trailStyle;
      var10001 = this.trail;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
      SliderSetting var2 = this.trailLength;
      var10001 = this.trail;
      Objects.requireNonNull(var10001);
      var2.visibleWhen(var10001::get);
      var10000 = this.auraStyle;
      var10001 = this.aura;
      Objects.requireNonNull(var10001);
      var10000.visibleWhen(var10001::get);
   }

   public Deque trailNodes() {
      return this.trailNodes;
   }

   public void onTick() {
      if (!(Boolean)this.trail.get()) {
         if (!this.trailNodes.isEmpty()) {
            this.trailNodes.clear();
         }
      } else {
         class_746 player = class_310.method_1551().field_1724;
         if (player != null) {
            double x = player.method_23317();
            double y = player.method_23318() + (double)player.method_17682() * 0.5;
            double z = player.method_23321();
            this.trailNodes.addLast(new TrailNode(x, y, z, System.nanoTime()));
            long cutoff = System.nanoTime() - (long)((double)Math.max(0.2F, this.trailLength.getFloat()) * 1.4E9);

            while(!this.trailNodes.isEmpty() && ((TrailNode)this.trailNodes.peekFirst()).nanos < cutoff) {
               this.trailNodes.removeFirst();
            }

            while(this.trailNodes.size() > 256) {
               this.trailNodes.removeFirst();
            }
         }
      }

   }

   protected void onDisable() {
      this.clear();
   }

   public void clear() {
      this.trailNodes.clear();
   }

   public int currentRgb() {
      if ((Boolean)this.rainbow.get()) {
         float hue = (float)(System.currentTimeMillis() % 4000L) / 4000.0F * 360.0F;
         return Colors.hsvToRgb(hue, 0.8F, 1.0F) & 16777215;
      } else {
         return (Integer)this.color.get() & 16777215;
      }
   }

   public float glowStrength() {
      return this.glow.getFloat() / 100.0F;
   }

   public static final class TrailNode {
      public final double x;
      public final double y;
      public final double z;
      public final long nanos;

      TrailNode(double x, double y, double z, long nanos) {
         this.x = x;
         this.y = y;
         this.z = z;
         this.nanos = nanos;
      }

      public float ageSeconds(long now) {
         return (float)(now - this.nanos) / 1.0E9F;
      }
   }
}
