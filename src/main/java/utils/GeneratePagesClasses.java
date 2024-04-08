package utils;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class GeneratePagesClasses {

    private static Collection<File> getJsonFilesFromElementsJsonFilesDirectory() {
        return FileUtils.listFiles(new File(Utilities.getElementsJsonFilesDirectory()), new String[]{"json"}, true);
    }

    private static String getContentsOfJsonFile(File jsonFile) throws IOException {
        return FileUtils.readFileToString(jsonFile, "UTF-8");
    }

    private static Element[] getElementsArrayFromJsonContents(String jsonContent) {
        Gson gson = new Gson();
        return gson.fromJson(jsonContent, Element[].class);
    }

    private static StringBuilder convertElementsIntoJavaText(Element[] elements) {
        StringBuilder elementsContents = new StringBuilder();
        StringBuilder defineElements = new StringBuilder("""
                \tpublic WebElement getElement(String elementKey) {
                \t\tBy elementLocator = elementsMap.get(elementKey);
                \t\tif (elementLocator != null) {
                \t\t\treturn elementKey.toLowerCase().contains("btn") ?
                \t\t\t\tAutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeClickable(elementLocator) :
                \t\t\t\tAutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeVisible(elementLocator);
                \t\t\t}
                \t\treturn null;
                \t}
                \s
                \tprivate void defineAllElements() {
                """);
        for (Element element : elements) {
            String elementName = element.elementName;
            String locatorMethod = element.locatorMethod;
            String locatorValue = element.locatorValue;
            elementsContents.append("""
                            \tprivate final By %s_%s = By.%s("%s");
                            \tpublic String %s = "%s";
                             \s
                            """.formatted(elementName, locatorMethod, locatorMethod, locatorValue, elementName, elementName));
            defineElements.append("""
                    \t\tthis.elementsMap.put(%s, %s_%s);
                    """.formatted(elementName, elementName, locatorMethod));
        }
        defineElements.append("""
                \t}
                \s
                """);
        elementsContents.append(defineElements);
        return elementsContents;
    }

    private static String generateJavaClassContent(String javaClassName, Element[] elements) {
        StringBuilder elementsContents = convertElementsIntoJavaText(elements);
        return """
                package pages.pages;
                \s
                import base.Base;
                import org.openqa.selenium.By;
                import org.openqa.selenium.WebDriver;
                import org.openqa.selenium.WebElement;
                import utils.AutomatedActions;
                                
                import java.time.Duration;
                import java.util.HashMap;
                import java.util.Map;
                                    
                public class %s extends Base {
                    protected WebDriver webDriver;
                    private final Map<String,By> elementsMap = new HashMap<>();
                            
                                    
                    public %s(WebDriver webDriver) {
                        this.webDriver = webDriver;
                        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Base.pageLoadTimeoutDuration));
                        this.defineAllElements();
                    }
                   \s
                %s
                \t//Add Other Needed Methods Here
                                            
                """.formatted(javaClassName, javaClassName, elementsContents);
    }

    private static void createJavaFileWithContent(File javaFilesDirectory, String javaFileName, String contents) throws IOException {
        try (FileWriter fileWriter = new FileWriter(javaFilesDirectory + File.separator + javaFileName)) {
            fileWriter.write(contents);
        }
    }

    public static void generateJavaFiles() {
        for (File jsonFile : getJsonFilesFromElementsJsonFilesDirectory()) {
            try {
                String jsonContent = getContentsOfJsonFile(jsonFile);
                String javaFileName = jsonFile.getName().replace(".json", "") + ".java";
                String className = javaFileName.replace(".java", "");
                File javaFilesDirectory = new File(Utilities.getElementsJavaFilesDirectory());
                if (!javaFilesDirectory.exists()) {
                    javaFilesDirectory.mkdirs();
                }
                Element[] webElements = getElementsArrayFromJsonContents(jsonContent);
                String contents = generateJavaClassContent(className, webElements);
                createJavaFileWithContent(javaFilesDirectory, javaFileName, contents);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GeneratePagesClasses.generateJavaFiles();
    }
}
