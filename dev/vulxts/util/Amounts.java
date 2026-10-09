package dev.vulxts.util;

import dev.vulxts.rt.Deobf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5250;

public final class Amounts {
   private static final String[] SUFFIX = new String[]{Deobf.decrypt("\u0007\u001e"), Deobf.decrypt("\u0007"), Deobf.decrypt("\u0002"), Deobf.decrypt("\u0014"), Deobf.decrypt("\u001b"), Deobf.decrypt("\u001d")};
   private static final String[] DISPLAY = new String[]{Deobf.decrypt("'>"), Deobf.decrypt("'"), Deobf.decrypt("\""), Deobf.decrypt("4"), Deobf.decrypt(";"), Deobf.decrypt("\u001d")};
   private static final int[] POWER = new int[]{18, 15, 12, 9, 6, 3};
   private static final Pattern NUMBER = Pattern.compile(Deobf.decrypt("*\u000e\tylÆÉç¾ŖŬāŜƿǾƍƽɜțɛɢʽʔ˄ˣ̬ͫͨͺΤηϸϱϢЉЅфяҩӤҮһ"));

   private Amounts() {
   }

   public static double parse(String raw) {
      if (raw == null) {
         return Double.NaN;
      } else {
         String s;
         for(s = raw.trim().toLowerCase(Locale.ROOT).replaceAll(Deobf.decrypt("-F\u000eVWµ"), Deobf.decrypt("")); !s.isEmpty() && (s.charAt(0) == '$' || s.charAt(0) == 8364 || s.charAt(0) == 163); s = s.substring(1)) {
         }

         if (s.isEmpty()) {
            return Double.NaN;
         } else {
            for(int i = 0; i < SUFFIX.length; ++i) {
               if (s.endsWith(SUFFIX[i]) && s.length() > SUFFIX[i].length()) {
                  String num = s.substring(0, s.length() - SUFFIX[i].length());

                  try {
                     return Double.parseDouble(num) * Math.pow(10.0, (double)POWER[i]);
                  } catch (NumberFormatException var5) {
                     return Double.NaN;
                  }
               }
            }

            try {
               return Double.parseDouble(s);
            } catch (NumberFormatException var6) {
               return Double.NaN;
            }
         }
      }
   }

   public static String shortForm(double n) {
      double abs = Math.abs(n);

      for(int i = 0; i < POWER.length; ++i) {
         double pow = Math.pow(10.0, (double)POWER[i]);
         if (abs >= pow) {
            double v = (double)Math.round(n / pow * 10.0) / 10.0;
            String var10000 = trimZero(v);
            return var10000 + DISPLAY[i];
         }
      }

      return Long.toString(Math.round(n));
   }

   public static String comma(double n) {
      return String.format(Locale.US, Deobf.decrypt("SF6"), (long)Math.floor(n));
   }

   public static String plain(double n) {
      return Long.toString((long)Math.floor(n));
   }

   public static String format(double n, String mode) {
      String var10000;
      switch (mode) {
         case "Short":
            var10000 = shortForm(n);
            break;
         case "Plain":
            var10000 = plain(n);
            break;
         default:
            var10000 = comma(n);
      }

      return var10000;
   }

   private static String trimZero(double v) {
      return v == Math.floor(v) && !Double.isInfinite(v) ? Long.toString((long)v) : String.valueOf(v);
   }

   public static int[] lastNumberSpan(String text) {
      Matcher m = NUMBER.matcher(text);
      int start = -1;

      int end;
      for(end = -1; m.find(); end = m.end()) {
         start = m.start();
      }

      return start < 0 ? null : new int[]{start, end};
   }

   public static int[] valueSpan(String text) {
      for(int i = 0; i < text.length(); ++i) {
         if (Character.isDigit(text.charAt(i))) {
            return new int[]{i, text.length()};
         }
      }

      return null;
   }

   public static class_2561 replaceNumberStyled(class_2561 original, String replacement) {
      return spliceStyled(original, replacement, false);
   }

   public static class_2561 replaceValueStyled(class_2561 original, String replacement) {
      return spliceStyled(original, replacement, true);
   }

   private static class_2561 spliceStyled(class_2561 original, String replacement, boolean toEnd) {
      List styles = new ArrayList();
      List parts = new ArrayList();
      original.method_27658((style, str) -> {
         styles.add(style);
         parts.add(str);
         return Optional.empty();
      }, class_2583.field_24360);
      StringBuilder sb = new StringBuilder();
      Iterator var6 = parts.iterator();

      while(var6.hasNext()) {
         String p = (String)var6.next();
         sb.append(p);
      }

      int[] span = toEnd ? valueSpan(sb.toString()) : lastNumberSpan(sb.toString());
      if (span == null) {
         return original;
      } else {
         int start = span[0];
         int end = span[1];
         class_5250 out = class_2561.method_43473();
         int pos = 0;
         boolean inserted = false;

         for(int i = 0; i < parts.size(); ++i) {
            String s = (String)parts.get(i);
            class_2583 st = (class_2583)styles.get(i);
            int re = pos + s.length();
            int beforeEnd = Math.min(re, start);
            if (beforeEnd > pos) {
               out.method_10852(class_2561.method_43470(s.substring(0, beforeEnd - pos)).method_10862(st));
            }

            if (!inserted && start >= pos && start < re) {
               out.method_10852(class_2561.method_43470(replacement).method_10862(st));
               inserted = true;
            }

            int afterStart = Math.max(pos, end);
            if (re > afterStart) {
               out.method_10852(class_2561.method_43470(s.substring(afterStart - pos)).method_10862(st));
            }

            pos = re;
         }

         if (!inserted) {
            out.method_10852(class_2561.method_43470(replacement));
         }

         return out;
      }
   }
}
