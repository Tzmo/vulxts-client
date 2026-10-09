package dev.vulxts.render;

record ClusterEspRenderer$Bucket(int x, int y, int z) {
   ClusterEspRenderer$Bucket(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   static ClusterEspRenderer$Bucket of(BlockEspRenderer.Hit var0, int var1) {
      return new ClusterEspRenderer$Bucket(Math.floorDiv(var0.x(), var1), Math.floorDiv(var0.y(), var1), Math.floorDiv(var0.z(), var1));
   }

   public int x() {
      return this.x;
   }

   public int y() {
      return this.y;
   }

   public int z() {
      return this.z;
   }
}
