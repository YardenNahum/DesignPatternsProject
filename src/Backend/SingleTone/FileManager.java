package Backend.SingleTone;

import Backend.Builder.InsuranceDetails;
import Backend.Purchases.PurchasesTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    // Single instance
    private static FileManager _instance = null;
    private final File logFile;
    private final File configFile;


    // class constructor
    private FileManager() {
        this.logFile = new File("../InputFiles/Logger.txt");
        configFile = new File("src/InputFiles/ConfigFile.json");
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

    // add log message to file
    public void writeToLogger(String insuranceRecord)
    {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(insuranceRecord + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write to file: " + logFile.getName(), e);
        }
    }
    // read config file
    public String readConfigFile() {
        List<String> lines = readFile(configFile);
        if (lines.isEmpty() && !configFile.exists()) {
            return "Config file not found.";
        }
        //building a single string
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.equals("{") || trimmed.equals("}")) {
                continue;
            }
            String cleanLine = trimmed
                    .replace("\"", "")
                    .replace(",", "")
                    .replace(":", ": ");

            if (!cleanLine.isEmpty()) {
                sb.append(cleanLine).append("\n");
            }
        }
        return sb.toString();
    }



    // read all text from the file
    public List<String> readFile(File file)
    {
        if (!file.exists()) {
            return Collections.emptyList();
        }

        try (Scanner scanner = new Scanner(file))
        {
            List<String> lines = new java.util.ArrayList<>();
            while (scanner.hasNextLine())
            {
                lines.add(scanner.nextLine());
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + file.getName(), e);
        }
    }

    // View All Purchases in the PurchasesTable
    /*public List<InsuranceDetails> addToPurchasesTable() {

        List<String> lines = readFile();  // read all text from the file
        List<PurchasesTable> tableRows = new ArrayList<>();

        for (String line : lines) {

            //split the table details: name,familyName,date,remarks,insuranceType
            String[] tableColumns = line.split(",", -1);

            String name = tableColumns[0].trim();
            String familyName = tableColumns[1].trim();
            String date = tableColumns[2].trim();
            String remarks = tableColumns[3].trim();

            tableRows.add(new PurchasesTable(name, familyName, date, remarks));
        }

        return tableRows;
    }*/

}
