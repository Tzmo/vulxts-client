package dev.vulxts.util;

import java.util.ArrayDeque;
import java.util.Deque;

public final class CpsTracker {
   private static final Deque LEFT = new ArrayDeque();
   private static final Deque RIGHT = new ArrayDeque();

   private CpsTracker() {
   }

   public static void onClick(int button) {
      Deque deque = button == 0 ? LEFT : (button == 1 ? RIGHT : null);
      if (deque != null) {
         synchronized(deque) {
            deque.addLast(System.nanoTime());
         }
      }

   }

   public static int get(int button) {
      Deque deque = button == 0 ? LEFT : RIGHT;
      long cutoff = System.nanoTime() - 1000000000L;
      synchronized(deque) {
         while(!deque.isEmpty() && (Long)deque.peekFirst() < cutoff) {
            deque.pollFirst();
         }

         return deque.size();
      }
   }
}
