package Backend.SingleTone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    // Single instance
    private static FileManager _instance = null;
    private final File file;

    // class constructor
    private FileManager() {
        this.file = new File("FormInput.txt");
        System.out.println("FileManager constructor was called");
    }

    // return _instance. Singleton instance is created when method is called for the first time
    public static synchronized FileManager getInstance() {
        if (_instance == null) {
            System.out.println("creating new FileManager instance");
            _instance = new FileManager();
        }
        return _instance;
    }

    // add a text to the file
    public void AddToFile(String str) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(str + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + file.getName(), e);
        }
    }

    // read all text from the file
    public List<String> readFile() {
        if (!file.exists()) {
            return Collections.emptyList();
        }

        try (Scanner scanner = new Scanner(file)) {
            List<String> lines = new java.util.ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + file.getName(), e);
        }
    }
}
