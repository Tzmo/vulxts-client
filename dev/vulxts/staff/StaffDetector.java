package dev.vulxts.staff;

import dev.vulxts.rt.Deobf;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.class_11719;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5251;

public final class StaffDetector {
   public static final int CONFIRMED_STAR = 9733;
   public static final int CONFIRMED_COLOR = 64648;
   public static final String MODE_STAR_RANK = "Star + Rank";
   public static final String MODE_STAR = "Star Only";
   public static final String MODE_RANK = "Rank Only";
   public static final String MODE_NAMES = "Names Only";
   public static final String DEFAULT_SYMBOLS = "★☆✦✧✪✩✫✬✭✮✯⭐✰❂⚝✴✵✶✷✸✹⍟";
   public static final List DEFAULT_RANK_KEYWORDS = List.of(Deobf.decrypt("\u0015\u0005=Rf\u008d\u0097"), Deobf.decrypt("\u0019\u001d<@z"), Deobf.decrypt("\u001b\u000b<Do\u008d\u0097"), Deobf.decrypt("\u0017\u000e?Lf\u0081\u0096ÎæğħŔŲ"), Deobf.decrypt("\u0017\u000e?Lf"), Deobf.decrypt("\u0012\u000f$@d\u0087\u0095ßæ"), Deobf.decrypt("\u0012\u000f$"), Deobf.decrypt("\u0005\u0018?Jl"), Deobf.decrypt("\u0005\u000f<Lg\u009a\u0088Õð"), Deobf.decrypt("\u001b\u00056@z\u0089\u0091Õæ"), Deobf.decrypt("\u001b\u00056"), Deobf.decrypt("\u0005\u0018:@d\u0098\u0080È"), Deobf.decrypt("\u0005\u000f<Lg\u009a\u008dßøĎĶŉ"), Deobf.decrypt("\u001e\u000f>Um\u009a"), Deobf.decrypt("\u0002\u0018;Dd\u0085\u008aÞ"), Deobf.decrypt("\u0002\u0018;Dd"), Deobf.decrypt("\u0014\u001f;Il\u008d\u0097"), Deobf.decrypt("\u0005\u001f\"Ug\u009a\u0091"), Deobf.decrypt("\u0005\u001e3Cn"));
   public static final String DEFAULT_RANK_KEYWORDS_STRING;
   private static final Map RANK_LABELS;

   public static boolean matchesConfirmedBadge(int var0, Integer var1, String var2) {
      return var0 == 9733 && var1 != null && (var1 & 16777215) == 64648 && "minecraft:default".equals(var2);
   }

   public static StaffEntry classifyConfirmedBadge(String var0, class_2561 var1, class_2561 var2, class_2561 var3, int var4) {
      if (var0 != null && !var0.isEmpty()) {
         boolean var5 = var1 != null ? hasConfirmedBadge(var1) : hasConfirmedBadge(var2) || hasConfirmedBadge(var3);
         return var5 ? new StaffEntry(var0, "", -16712568, false, var4, 1) : null;
      } else {
         return null;
      }
   }

   private static boolean hasConfirmedBadge(class_2561 var0) {
      return var0 == null ? false : (Boolean)var0.method_27658((var0x, var1) -> {
         class_11719 patt0$temp = var0x.method_27708();
         if (patt0$temp instanceof class_11719.class_11721 var2) {
            Integer var4 = var0x.method_10973() == null ? null : var0x.method_10973().method_27716();
            return var1.codePoints().anyMatch((var2x) -> {
               return matchesConfirmedBadge(var2x, var4, var2.comp_4590().toString());
            }) ? Optional.of(true) : Optional.empty();
         } else {
            return Optional.empty();
         }
      }, class_2583.field_24360).orElse(false);
   }

   private StaffDetector() {
   }

   public static StaffEntry classify(String var0, class_2561 var1, class_2561 var2, class_2561 var3, String var4, boolean var5, int var6, DetectConfig var7) {
      if (var0 != null && !var0.isEmpty() && (!var5 || var7.showVanished())) {
         boolean var8 = var7.names().contains(var0.toLowerCase(Locale.ROOT));
         Marker var9 = scanStaffMarker(var1, var7);
         if (var9 == null) {
            var9 = scanStaffMarker(var2, var7);
         }

         if (var9 == null) {
            var9 = scanStaffMarker(var3, var7);
         }

         String var10000 = rankText(var2, var0);
         String var10 = var10000 + " " + rankText(var3, var0) + " " + rankText(var1, var0) + " " + stripName(var4 == null ? "" : var4, var0);
         Rank var11 = deriveRank(var10, var7.rankKeywords());
         String var12 = var9 == null ? "" : var9.label();
         boolean var16;
         switch (var7.mode()) {
            case "Star Only":
               var16 = var9 != null;
               break;
            case "Rank Only":
               var16 = var11 != null;
               break;
            case "Names Only":
               var16 = false;
               break;
            default:
               var16 = var9 != null || var11 != null;
         }

         boolean var13 = var16;
         return !var8 && !var13 ? null : new StaffEntry(var0, var11 == null ? var12 : var11.label(), var9 == null ? 0 : var9.color(), var5, var6, var11 == null ? (var9 == null ? 0 : 1) : var11.priority());
      } else {
         return null;
      }
   }

   static Integer scanMarker(class_2561 var0, DetectConfig var1) {
      Marker var2 = scanStaffMarker(var0, var1);
      return var2 == null ? null : var2.color();
   }

   private static Marker scanStaffMarker(class_2561 var0, DetectConfig var1) {
      return var0 == null ? null : (Marker)var0.method_27658((var1x, var2) -> {
         int var3;
         for(int var4 = 0; var4 < var2.length(); var4 += Character.charCount(var3)) {
            var3 = var2.codePointAt(var4);
            class_5251 var5 = var1x.method_10973();
            Integer var6 = var5 == null ? null : var5.method_27716();
            String var7 = markerLabel(var3, var6, var1);
            if (var7 == null && var1.fontIcons() && isPrivateUse(var3)) {
               Rank var8 = deriveRank(StaffFontRanks.describe(var1x, new String(Character.toChars(var3))), var1.rankKeywords());
               if (var8 != null) {
                  var7 = var8.label();
               }
            }

            if (var7 != null) {
               return Optional.of(new Marker(var6 == null ? 0 : -16777216 | var6, var7));
            }
         }

         return Optional.empty();
      }, class_2583.field_24360).orElse((Object)null);
   }

   private static String rankText(class_2561 var0, String var1) {
      if (var0 == null) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(stripName(var0.getString(), var1));
         var0.method_27658((var2x, var3) -> {
            var2.append(' ').append(stripName(var3, var1));
            var2.append(StaffFontRanks.describe(var2x, var3));
            return Optional.empty();
         }, class_2583.field_24360);
         return var2.toString();
      }
   }

   private static boolean isPrivateUse(int var0) {
      return Character.getType(var0) == 18;
   }

   public static String markerLabel(int var0, Integer var1, DetectConfig var2) {
      if (!isGreenStaffColor(var1)) {
         return null;
      } else {
         String var3 = mappedRank(var0, var2);
         if (var2.symbols().indexOf(var0) < 0 && (!var2.fontIcons() || !isPrivateUse(var0) || var3 == null)) {
            return null;
         } else {
            return var3 == null ? var2.markerRank() : var3;
         }
      }
   }

   public static boolean isGreenStaffColor(Integer var0) {
      if (var0 == null) {
         return false;
      } else {
         int var1 = var0 >> 16 & 255;
         int var2 = var0 >> 8 & 255;
         int var3 = var0 & 255;
         return var2 >= 60 && var2 - var1 >= 35 && var2 - var3 >= 35;
      }
   }

   private static Rank deriveRank(String var0, List var1) {
      String var2 = StaffRankMatcher.match(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         int var3 = -1;

         for(int var4 = 0; var4 < DEFAULT_RANK_KEYWORDS.size(); ++var4) {
            if (StaffRankMatcher.canonical((String)DEFAULT_RANK_KEYWORDS.get(var4)).equals(var2)) {
               var3 = var4;
               break;
            }
         }

         return new Rank(labelFor(var2), var3 < 0 ? 2 : DEFAULT_RANK_KEYWORDS.size() - var3 + 2);
      }
   }

   private static String labelFor(String var0) {
      String var1 = (String)RANK_LABELS.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         return var0.isEmpty() ? Deobf.decrypt("%\u001e3Cn") : Character.toUpperCase(var0.charAt(0)) + var0.substring(1);
      }
   }

   private static String plain(class_2561 var0) {
      return var0 == null ? Deobf.decrypt("") : var0.getString();
   }

   private static String stripName(String var0, String var1) {
      return var1 != null && !var1.isEmpty() ? StaffRankMatcher.removePlayerName(var0, var1) : var0;
   }

   public static String assignedRank(String var0, DetectConfig var1) {
      int[] var2 = var0.codePoints().toArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var2[var4];
         String var6 = mappedRank(var5, var1);
         if (var6 != null) {
            return var6;
         }
      }

      return var1.markerRank();
   }

   private static String mappedRank(int var0, DetectConfig var1) {
      String[] var2 = var1.mappings().split("[,;\\r\\n]+");
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         String[] var6 = var5.trim().split("=", 2);
         if (var6.length == 2) {
            String var7 = var6[0].trim();

            int var8;
            try {
               var8 = var7.toUpperCase(Locale.ROOT).startsWith("U+") ? Integer.parseInt(var7.substring(2), 16) : (var7.codePointCount(0, var7.length()) == 1 ? var7.codePointAt(0) : -1);
            } catch (RuntimeException var10) {
               continue;
            }

            if (var8 == var0) {
               String var9 = StaffRankMatcher.canonical(var6[1]);
               if (RANK_LABELS.containsKey(var9)) {
                  return labelFor(var9);
               }
            }
         }
      }

      return null;
   }

   static {
      DEFAULT_RANK_KEYWORDS_STRING = String.join(Deobf.decrypt("ZJ"), DEFAULT_RANK_KEYWORDS);
      RANK_LABELS = Map.ofEntries(Map.entry(Deobf.decrypt("\u0015\u0005=Rf\u008d\u0097"), Deobf.decrypt("5\u0005\u007fj\u007f\u0086\u0080È")), Map.entry(Deobf.decrypt("\u0019\u001d<@z"), Deobf.decrypt("9\u001d<@z")), Map.entry(Deobf.decrypt("\u001b\u000b<Do\u008d\u0097"), Deobf.decrypt(";\u000b<Do\u008d\u0097")), Map.entry(Deobf.decrypt("\u0017\u000e?Lf\u0081\u0096ÎæğħŔŲ"), Deobf.decrypt("7\u000e?Lf")), Map.entry(Deobf.decrypt("\u0017\u000e?Lf"), Deobf.decrypt("7\u000e?Lf")), Map.entry(Deobf.decrypt("\u0012\u000f$@d\u0087\u0095ßæ"), Deobf.decrypt("2\u000f$")), Map.entry(Deobf.decrypt("\u0012\u000f$"), Deobf.decrypt("2\u000f$")), Map.entry(Deobf.decrypt("\u0005\u0018?Jl"), Deobf.decrypt("%\u0018|hg\u008c")), Map.entry(Deobf.decrypt("\u0005\u000f<Lg\u009a\u0088Õð"), Deobf.decrypt("%\u0018|hg\u008c")), Map.entry(Deobf.decrypt("\u001b\u00056@z\u0089\u0091Õæ"), Deobf.decrypt(";\u00056")), Map.entry(Deobf.decrypt("\u001b\u00056"), Deobf.decrypt(";\u00056")), Map.entry(Deobf.decrypt("\u0005\u0018:@d\u0098\u0080È"), Deobf.decrypt("%\u0018|mm\u0084\u0095ßæ")), Map.entry(Deobf.decrypt("\u0005\u000f<Lg\u009a\u008dßøĎĶŉ"), Deobf.decrypt("%\u0018|mm\u0084\u0095ßæ")), Map.entry(Deobf.decrypt("\u001e\u000f>Um\u009a"), Deobf.decrypt(">\u000f>Um\u009a")), Map.entry(Deobf.decrypt("\u0002\u0018;Dd\u0085\u008aÞ"), Deobf.decrypt("\"\u0018;Dd")), Map.entry(Deobf.decrypt("\u0002\u0018;Dd"), Deobf.decrypt("\"\u0018;Dd")), Map.entry(Deobf.decrypt("\u0014\u001f;Il\u008d\u0097"), Deobf.decrypt("4\u001f;Il\u008d\u0097")), Map.entry(Deobf.decrypt("\u0005\u001f\"Ug\u009a\u0091"), Deobf.decrypt("%\u001f\"Ug\u009a\u0091")), Map.entry(Deobf.decrypt("\u0005\u001e3Cn"), Deobf.decrypt("%\u001e3Cn")));
   }

   public static record DetectConfig(String mode, Set names, List rankKeywords, String symbols, boolean fontIcons, boolean showVanished, String markerRank, String mappings) {
      public DetectConfig(String var1, Set var2, List var3, String var4, boolean var5, boolean var6) {
         this(var1, var2, var3, var4, var5, var6, "Staff", "");
      }

      public DetectConfig(String mode, Set names, List rankKeywords, String symbols, boolean fontIcons, boolean showVanished, String markerRank, String mappings) {
         this.mode = mode;
         this.names = names;
         this.rankKeywords = rankKeywords;
         this.symbols = symbols;
         this.fontIcons = fontIcons;
         this.showVanished = showVanished;
         this.markerRank = markerRank;
         this.mappings = mappings;
      }

      public String mode() {
         return this.mode;
      }

      public Set names() {
         return this.names;
      }

      public List rankKeywords() {
         return this.rankKeywords;
      }

      public String symbols() {
         return this.symbols;
      }

      public boolean fontIcons() {
         return this.fontIcons;
      }

      public boolean showVanished() {
         return this.showVanished;
      }

      public String markerRank() {
         return this.markerRank;
      }

      public String mappings() {
         return this.mappings;
      }
   }

   private static record Marker(int color, String label) {
      private Marker(int color, String label) {
         this.color = color;
         this.label = label;
      }

      public int color() {
         return this.color;
      }

      public String label() {
         return this.label;
      }
   }

   private static record Rank(String label, int priority) {
      private Rank(String label, int priority) {
         this.label = label;
         this.priority = priority;
      }

      public String label() {
         return this.label;
      }

      public int priority() {
         return this.priority;
      }
   }
}
