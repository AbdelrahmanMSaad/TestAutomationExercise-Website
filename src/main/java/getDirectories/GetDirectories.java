package getDirectories;

import java.nio.file.Paths;

public class GetDirectories {
    private static final String USER_DIR = System.getProperty("user.dir");

    public static String getConfigFilePath() {
        return Paths.get(USER_DIR, "src", "main", "resources", "config.properties").toString();
    }

    public static String getTestDataFilePath() {
        return Paths.get(USER_DIR, "src", "test", "resources", "testdata.json").toString();
    }

    public static String getScreenshotsDirectory() {
        return Paths.get(USER_DIR, "src", "test", "screenshots").toString();
    }

    public static String getElementsJsonFilesDirectory() {
        return Paths.get(USER_DIR, "src", "main", "java", "pages", "pagesElements").toString();
    }

    public static String getElementsJavaFilesDirectory() {
        return Paths.get(USER_DIR, "src", "main", "java", "pages", "pages").toString();
    }
}
