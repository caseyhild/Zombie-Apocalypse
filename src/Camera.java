import java.awt.event.*;
public class Camera implements KeyListener
{
    public double xPos, yPos, xDir, yDir, xPlane, yPlane;
    private boolean left;
    private boolean right;
    private boolean forward;
    private boolean back;
    public boolean shoot;

    public Camera(double x, double y, double xd, double yd, double xp, double yp) 
    {   
        //gets starting location and direction
        xPos = x;
        yPos = y;
        xDir = xd;
        yDir = yd;
        xPlane = xp;
        yPlane = yp;
        left = false;
        right = false;
        forward = false;
        back = false;
        shoot = false;
    }
    //checks if key is pressed
    public void keyPressed(KeyEvent key)
    {
        if((key.getKeyCode() == KeyEvent.VK_LEFT))
            left = true;
        if((key.getKeyCode() == KeyEvent.VK_RIGHT))
            right = true;
        if((key.getKeyCode() == KeyEvent.VK_UP))
            forward = true;
        if((key.getKeyCode() == KeyEvent.VK_DOWN))
            back = true;
        if((key.getKeyCode() == KeyEvent.VK_SPACE))
            shoot = true;
    }
    //checks if key is released
    public void keyReleased(KeyEvent key)
    {
        if((key.getKeyCode() == KeyEvent.VK_LEFT))
            left = false;
        if((key.getKeyCode() == KeyEvent.VK_RIGHT))
            right = false;
        if((key.getKeyCode() == KeyEvent.VK_UP))
            forward = false;
        if((key.getKeyCode() == KeyEvent.VK_DOWN))
            back = false;
    }
    //checks if key is typed
    public void keyTyped(KeyEvent key)
    {

    }

    public void update(int[][] map)
    {
        //moves and turns player based on key input
        double MOVE_SPEED = .08;
        if(forward)
        {
            if(!((int) (xPos + xDir * MOVE_SPEED) < 0 || (int) (xPos + xDir * MOVE_SPEED) > map.length - 1 || (int) (yPos + yDir * MOVE_SPEED) < 0 || (int) (yPos + yDir * MOVE_SPEED) > map[0].length - 1))
            {
                if(map[(int) (xPos + xDir * MOVE_SPEED)][(int) yPos] == 0)
                    xPos += xDir * MOVE_SPEED;
                if(map[(int) xPos][(int) (yPos + yDir * MOVE_SPEED)] == 0)
                    yPos += yDir * MOVE_SPEED;
            }
        }
        if(back)
        {
            if(!((int) (xPos - xDir * MOVE_SPEED) < 0 || (int) (xPos - xDir * MOVE_SPEED) > map.length - 1 || (int) (yPos - yDir * MOVE_SPEED) < 0 || (int) (yPos - yDir * MOVE_SPEED) > map[0].length - 1))
            {
                if(map[(int) (xPos - xDir * MOVE_SPEED)][(int) yPos] == 0)
                    xPos -= xDir * MOVE_SPEED;
                if(map[(int) xPos][(int) (yPos - yDir * MOVE_SPEED)] == 0)
                    yPos -= yDir * MOVE_SPEED;
            }
        }
        double ROTATION_SPEED = .045;
        if(right)
        {
            double oldxDir = xDir;
            xDir = xDir * Math.cos(-ROTATION_SPEED) - yDir * Math.sin(-ROTATION_SPEED);
            yDir = oldxDir * Math.sin(-ROTATION_SPEED) + yDir * Math.cos(-ROTATION_SPEED);
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(-ROTATION_SPEED) - yPlane * Math.sin(-ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(-ROTATION_SPEED) + yPlane * Math.cos(-ROTATION_SPEED);
        }
        if(left)
        {
            double oldxDir = xDir;
            xDir = xDir * Math.cos(ROTATION_SPEED) - yDir * Math.sin(ROTATION_SPEED);
            yDir = oldxDir * Math.sin(ROTATION_SPEED) + yDir * Math.cos(ROTATION_SPEED);
            double oldxPlane = xPlane;
            xPlane = xPlane * Math.cos(ROTATION_SPEED) - yPlane * Math.sin(ROTATION_SPEED);
            yPlane = oldxPlane * Math.sin(ROTATION_SPEED) + yPlane * Math.cos(ROTATION_SPEED);
        }
    }
}