package handlingConfigFile;

import getDirectories.GetDirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetPropertiesFromConfigFile {
    public static String getPropertyFromConfigFile(String property) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(GetDirectories.getConfigFilePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property.toLowerCase());
    }
}
