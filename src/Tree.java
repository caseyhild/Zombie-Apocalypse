import java.io.*;
public class Tree
{
    public Tree(PrintWriter outFile)
    {
        this(outFile, 0, 0, 0);
    }

    public Tree(PrintWriter outFile, double xCenter, double yCenter, double zCenter)
    {
        // tree
        int num = 10;
        double x = xCenter;
        double y = yCenter;
        double z  = zCenter + 1 - 0.75/num;
        double dx;
        double dy;
        for(int i = 0; i < 2 * num; i++)
        {
            z -= 0.75/num;
            outFile.printf("%.4f", x);
            outFile.print("  ");
            outFile.printf("%.4f", y);
            outFile.print("  ");
            outFile.printf("%.4f", z);
            outFile.print("  ");
            outFile.println(rgbNum(64, 32, 0));
        }
        for(int deg = 0; deg < 360; deg += 10)
        {
            x = xCenter;
            y = yCenter;
            z = zCenter + 1;
            dx = 0.5 * Math.cos(Math.toRadians(deg));
            dy = 0.5 * Math.sin(Math.toRadians(deg));
            for(int i = 0; i < num; i++)
            {
                x += dx/num;
                y += dy/num;
                z -= 1.2/num;
                outFile.printf("%.4f", x);
                outFile.print("  ");
                outFile.printf("%.4f", y);
                outFile.print("  ");
                outFile.printf("%.4f", z);
                outFile.print("  ");
                outFile.println(rgbNum(0, 64 + (int) (Math.random() * 64), 0));
            }
        }
        outFile.close();
    }

    private int rgbNum(int r, int g, int b)
    {
        //gets rgb decimal value from rgb input
        return r * 65536 + g * 256 + b;
    }
}