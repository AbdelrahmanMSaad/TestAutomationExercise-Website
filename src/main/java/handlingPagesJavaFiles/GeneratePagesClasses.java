package handlingPagesJavaFiles;

import getDirectories.GetDirectories;
import utils.Element;

import java.io.File;
import java.io.IOException;

public class GeneratePagesClasses {
    public static void generateJavaFiles() {
        for (File jsonFile : GetContentsFromPagesJsonFiles.getJsonFilesFromElementsJsonFilesDirectory()) {
            try {
                String jsonContent = GetContentsFromPagesJsonFiles.getContentsOfJsonFile(jsonFile);
                String javaFileName = jsonFile.getName().replace(".json", ".java");
                String className = javaFileName.replace(".java", "");
                File javaFilesDirectory = new File(GetDirectories.getElementsJavaFilesDirectory());
                if (!javaFilesDirectory.exists()) {
                    javaFilesDirectory.mkdirs();
                }
                Element[] webElements = GetContentsFromPagesJsonFiles.getElementsArrayFromJsonContents(jsonContent);
                String contents = BuildPageJavaClassContents.generatePageJavaClassContent(className, webElements);
                CreatePageJavaClass.createJavaFileWithContent(javaFilesDirectory, javaFileName, contents);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GeneratePagesClasses.generateJavaFiles();

    }
}
