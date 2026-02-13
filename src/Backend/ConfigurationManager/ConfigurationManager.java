package Backend.ConfigurationManager;

import Backend.SingleTone.FileManager;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String configText;
    //intiliaize config text from file
    private ConfigurationManager(){
        configText = readConfigFile();
    }
    //read string from config file and return it
    private String readConfigFile()
    {
        String config = "No Config File";
        try {
            config = FileManager.getInstance().readConfigFile();
            System.out.println("Config loaded successfully: " + config);

        } catch (Exception e) {
            System.err.println("Failed to load config: " + e.getMessage());
        }
        return config;
    }
    //Get config manager instance
    public static ConfigurationManager getInstance() {
        if(instance==null)
        {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    //get configuration text from manager
    public String GetConfigurationText(){
        return configText;
    }
}
