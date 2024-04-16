package handlingPagesJavaFiles;

import com.google.gson.Gson;
import getDirectories.GetDirectories;
import org.apache.commons.io.FileUtils;
import utils.Element;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class GetContentsFromPagesJsonFiles {
    public static Collection<File> getJsonFilesFromElementsJsonFilesDirectory() {
        return FileUtils.listFiles(new File(GetDirectories.getElementsJsonFilesDirectory()), new String[]{"json"}, true);
    }

    public static String getContentsOfJsonFile(File jsonFile) throws IOException {
        return FileUtils.readFileToString(jsonFile, "UTF-8");
    }

    public static Element[] getElementsArrayFromJsonContents(String jsonContent) {
        Gson gson = new Gson();
        return gson.fromJson(jsonContent, Element[].class);
    }
}
