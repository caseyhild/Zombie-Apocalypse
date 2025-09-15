public class Vector3D
{
    private double x;
    private double y;
    private final double z;

    public Vector3D(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
    
    public double getZ()
    {
        return z;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }
    public double dist(Vector3D v)
    {
        return Math.sqrt(Math.pow(x - v.x, 2) + Math.pow(y - v.y, 2) + Math.pow(y - v.y, 2));
    }

    public String toString()
    {
        return x + " " + y;
    }
}