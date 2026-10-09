package dev.vulxts.settings;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.vulxts.rt.Deobf;
import org.lwjgl.glfw.GLFW;

public class KeybindSetting extends Setting {
   public static final int NONE = -1;

   public KeybindSetting(String name, String description, int defaultKey) {
      super(name, description, defaultKey);
   }

   public boolean isBound() {
      return (Integer)this.get() != -1;
   }

   public boolean matches(int keyCode) {
      return this.isBound() && (Integer)this.get() == keyCode;
   }

   public String keyName() {
      int key = (Integer)this.get();
      if (key == -1) {
         return Deobf.decrypt("8\u0005<@");
      } else {
         String var10000;
         if (key >= 0 && key <= 7) {
            switch (key) {
               case 0:
                  var10000 = Deobf.decrypt(":'\u0010");
                  break;
               case 1:
                  var10000 = Deobf.decrypt("$'\u0010");
                  break;
               case 2:
                  var10000 = Deobf.decrypt(";'\u0010");
                  break;
               default:
                  var10000 = "MB" + (key + 1);
            }

            return var10000;
         } else {
            String name = GLFW.glfwGetKeyName(key, 0);
            if (name != null) {
               return name.toUpperCase();
            } else {
               switch (key) {
                  case 32:
                     var10000 = Deobf.decrypt("%:\u0013fM");
                     break;
                  case 257:
                     var10000 = Deobf.decrypt("3$\u0006`Z");
                     break;
                  case 258:
                     var10000 = Deobf.decrypt("\"+\u0010");
                     break;
                  case 259:
                     var10000 = Deobf.decrypt("4+\u0011n");
                     break;
                  case 260:
                     var10000 = Deobf.decrypt("?$\u0001`Z¼");
                     break;
                  case 261:
                     var10000 = Deobf.decrypt("2/\u001e`\\\u00ad");
                     break;
                  case 262:
                     var10000 = Deobf.decrypt("$#\u0015m\\");
                     break;
                  case 263:
                     var10000 = Deobf.decrypt(":/\u0014q");
                     break;
                  case 264:
                     var10000 = Deobf.decrypt("2%\u0005k");
                     break;
                  case 265:
                     var10000 = Deobf.decrypt("#:");
                     break;
                  case 266:
                     var10000 = Deobf.decrypt("&-\u0007u");
                     break;
                  case 267:
                     var10000 = Deobf.decrypt("&-\u0016k");
                     break;
                  case 268:
                     var10000 = Deobf.decrypt(">%\u001f`");
                     break;
                  case 269:
                     var10000 = Deobf.decrypt("3$\u0016");
                     break;
                  case 280:
                     var10000 = Deobf.decrypt("5+\u0002v");
                     break;
                  case 340:
                     var10000 = Deobf.decrypt(":9\u001alN¼");
                     break;
                  case 341:
                     var10000 = Deobf.decrypt(":)\u0006wD");
                     break;
                  case 342:
                     var10000 = Deobf.decrypt(":+\u001eq");
                     break;
                  case 344:
                     var10000 = Deobf.decrypt("$9\u001alN¼");
                     break;
                  case 345:
                     var10000 = Deobf.decrypt("$)\u0006wD");
                     break;
                  case 346:
                     var10000 = Deobf.decrypt("$+\u001eq");
                     break;
                  default:
                     var10000 = key >= 290 && key <= 314 ? "F" + (key - 290 + 1) : "KEY" + key;
               }

               return var10000;
            }
         }
      }
   }

   public JsonElement toJson() {
      return new JsonPrimitive((Number)this.value);
   }

   public void fromJson(JsonElement element) {
      if (element != null && element.isJsonPrimitive() && element.getAsJsonPrimitive().isNumber()) {
         this.value = element.getAsInt();
      }

   }
}
