import java.io.*;
public class Create3DPointFiles
{
    private final String folder;
    
    public Create3DPointFiles(String folder) throws IOException
    {
        this.folder = folder;
        new Tree(newFile("tree.txt"));
        new Zombie(newFile("zombie.txt"));
    }

    private PrintWriter newFile(String file) throws IOException
    {
        return new PrintWriter(folder + "/" + file);
    }

    public static void main(String[] args) throws IOException {
        new Create3DPointFiles("resources");
    }
}