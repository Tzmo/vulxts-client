package dev.vulxts.module.impl;

record SpawnerNametagsModule$ChunkPos(int x, int z) {
   private SpawnerNametagsModule$ChunkPos(int x, int z) {
      this.x = x;
      this.z = z;
   }

   public int x() {
      return this.x;
   }

   public int z() {
      return this.z;
   }
}
