import java.io.*;

public class FileReadWrite {

    public static void writeFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("some test text");
            writer.write("\nNext line text");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileReadWrite.writeFile("output.txt");
        FileReadWrite.readFile("output.txt");
    }
}
