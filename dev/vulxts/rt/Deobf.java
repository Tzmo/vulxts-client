package dev.vulxts.rt;

public final class Deobf {
   private static final String KEY = "vulxts_client_string_key_v1";

   private Deobf() {
   }

   public static String decrypt(String var0) {
      char[] var1 = var0.toCharArray();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = (char)(var1[var2] ^ "vulxts_client_string_key_v1".charAt(var2 % "vulxts_client_string_key_v1".length()) ^ var2 * 31);
      }

      return new String(var1);
   }
}
