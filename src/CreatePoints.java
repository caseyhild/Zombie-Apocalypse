import java.io.*;
public class CreatePoints
{
    private final String folder;
    
    public CreatePoints(String folder) throws IOException
    {
        this.folder = folder;
        new Tree(newFile("tree.txt"));
        new Zombie(newFile("zombie.txt"));
    }

    private PrintWriter newFile(String file) throws IOException
    {
        return new PrintWriter(folder + "/" + file);
    }
}