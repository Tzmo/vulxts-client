package dev.vulxts.staff;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

public final class StaffRankMatcher {
   private StaffRankMatcher() {
   }

   public static String normalize(String var0) {
      if (var0 == null) {
         return "";
      } else {
         var0 = var0.replaceAll("(?i)[§&][0-9a-fk-orx]", "");
         var0 = Normalizer.normalize(var0, Form.NFKD).toLowerCase(Locale.ROOT);
         String var1 = "ᴀʙᴄᴅᴇꜰɢʜɪᴊᴋʟᴍɴᴏᴘ\ua7afʀꜱᴛᴜᴠᴡʏᴢ";
         String var2 = "abcdefghijklmnopqrstuvwyz";
         StringBuilder var3 = new StringBuilder();
         int[] var4 = var0.codePoints().toArray();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            int var7 = var4[var6];
            if (Character.getType(var7) != 6 && Character.getType(var7) != 16) {
               int var8 = var1.indexOf(var7);
               if (var8 >= 0) {
                  var7 = var2.charAt(var8);
               }

               var3.append(var7 >= 97 && var7 <= 122 ? (char)var7 : ' ');
            }
         }

         return var3.toString().trim().replaceAll(" +", " ");
      }
   }

   public static String canonical(String var0) {
      String var10000;
      switch (normalize(var0).replace(" ", "")) {
         case "srmod":
         case "seniormod":
         case "srmoderator":
         case "seniormoderator":
            var10000 = "srmod";
            break;
         case "moderator":
            var10000 = "mod";
            break;
         case "srhelper":
         case "seniorhelper":
            var10000 = "srhelper";
            break;
         case "administrator":
            var10000 = "admin";
            break;
         default:
            var10000 = var1;
      }

      return var10000;
   }

   public static String match(String var0, List var1) {
      HashSet var2 = new HashSet();
      Iterator var3 = var1.iterator();

      String var11;
      while(var3.hasNext()) {
         var11 = (String)var3.next();
         String var5 = canonical(var11);
         if (!var5.isEmpty()) {
            var2.add(var5);
         }
      }

      if (var2.contains("mod")) {
         var2.add("srmod");
      }

      String[] var10 = normalize(var0).split(" ");
      var11 = null;
      int var12 = 0;

      for(int var6 = 0; var6 < var10.length; ++var6) {
         StringBuilder var7 = new StringBuilder();

         for(int var8 = var6; var8 < Math.min(var10.length, var6 + 4); ++var8) {
            var7.append(var10[var8]);
            String var9 = canonical(var7.toString());
            if (var2.contains(var9) && var7.length() > var12) {
               var11 = var9;
               var12 = var7.length();
            }
         }
      }

      return var11;
   }

   public static List parseKeywords(String var0) {
      if (var0 != null && !var0.isBlank()) {
         ArrayList var1 = new ArrayList();
         Set var2 = Set.of("owner", "coowner", "admin", "manager", "mod", "helper", "dev", "developer", "builder", "support", "staff", "trial", "trialmod", "srmod", "srhelper");
         String[] var3 = var0.split("[,;/|\\r\\n]+");
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var3[var5];
            var6 = var6.trim();
            if (!var6.isEmpty()) {
               String[] var7 = var6.split("\\s+");
               if (!var2.contains(canonical(var6)) && var7.length > 1 && Arrays.stream(var7).allMatch((var1x) -> {
                  return var2.contains(canonical(var1x));
               })) {
                  var1.addAll(Arrays.asList(var7));
               } else {
                  var1.add(var6);
               }
            }
         }

         return List.copyOf(var1);
      } else {
         return List.of();
      }
   }

   public static String removePlayerName(String var0, String var1) {
      if (var0 != null && var1 != null && !var1.isBlank()) {
         String var2 = var0.trim();
         if (var2.equalsIgnoreCase(var1)) {
            return "";
         } else if (var2.length() > var1.length() && var2.regionMatches(true, var2.length() - var1.length(), var1, 0, var1.length())) {
            return var2.substring(0, var2.length() - var1.length());
         } else {
            return var2.length() > var1.length() && var2.regionMatches(true, 0, var1, 0, var1.length()) ? var2.substring(var1.length()) : var0.replaceAll("(?i)(?<![a-z0-9_])" + Pattern.quote(var1) + "(?![a-z0-9_])", " ");
         }
      } else {
         return var0 == null ? "" : var0;
      }
   }
}
