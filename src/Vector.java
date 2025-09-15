public class Vector
{
    private double x;
    private double y;

    public Vector()
    {
        x = 0; 
        y = 0;
    }

    public Vector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void add(Vector v)
    {
        x += v.x;
        y += v.y;
    }

    public static Vector sub(Vector v1, Vector v2)
    {
        Vector v = new Vector();
        v.setX(v1.x - v2.x);
        v.setY(v1.y - v2.y);
        return v;
    }

    public static Vector mult(Vector v1, double n)
    {
        Vector v = new Vector();
        v.setX(v1.x * n);
        v.setY(v1.y * n);
        return v;
    }

    public double mag()
    {
        return Math.sqrt(x * x + y * y);
    }

    public static Vector normalize(Vector v1)
    {
        Vector v = new Vector();
        if(v1.mag() > 0)
        {
            v.setX(v1.x/v1.mag());
            v.setY(v1.y/v1.mag());
        }
        return v;
    }

    public boolean equals(Vector v)
    {
        return x == v.x && y == v.y;
    }

    public String toString()
    {
        return x + " " + y;
    }
}