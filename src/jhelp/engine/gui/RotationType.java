package jhelp.engine.gui;

public enum RotationType
{
   XY(RotationAxe.X, RotationAxe.Y), XZ(RotationAxe.X, RotationAxe.Z), YX(RotationAxe.Y, RotationAxe.X), YZ(RotationAxe.Y, RotationAxe.Z),
   ZX(RotationAxe.Z, RotationAxe.X), ZY(RotationAxe.Z, RotationAxe.Y);
   private final RotationAxe first;
   private final RotationAxe second;

   RotationType(final RotationAxe first, final RotationAxe second)
   {
      this.first = first;
      this.second = second;
   }

   public RotationAxe getFirst()
   {
      return this.first;
   }

   public RotationAxe getSecond()
   {
      return this.second;
   }
}