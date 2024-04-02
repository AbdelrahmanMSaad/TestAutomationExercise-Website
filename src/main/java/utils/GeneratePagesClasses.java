package utils;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class GeneratePagesClasses {
//    private static String elementsJsonFilesDirectory;
//    private static String elementsJavaFilesDirectory;

    public GeneratePagesClasses() {
//        elementsJsonFilesDirectory = Utilities.getElementsJsonFilesDirectory();
//        elementsJavaFilesDirectory = Utilities.getElementsJavaFilesDirectory();
    }

    /**
     * This method is to get the json files from the elments json files directory
     *
     * @return jsonFiles as a collection of Files
     */
    private static Collection<File> getJsonFilesFromElementsJsonFilesDirectory() {
        return FileUtils.listFiles(new File(Utilities.getElementsJsonFilesDirectory()), new String[]{"json"}, true);
    }

    /**
     * This method is to extract the content out of a json file
     *
     * @param jsonFile contains data to be extracted
     * @return extracted data
     */
    private static String getContentsOfJsonFile(File jsonFile) throws IOException {
        return FileUtils.readFileToString(jsonFile, "UTF-8");
    }

    /**
     * This method is to get an array of elements from the json content provided
     *
     * @param jsonContent contains elements to be extracted
     * @return array of elements
     */
    private static Element[] getElementsArrayFromJsonContents(String jsonContent) {
        Gson gson = new Gson();
        return gson.fromJson(jsonContent, Element[].class);
    }

    /**
     * This method takes an array of elements and convert them into java string
     *
     * @param elements web elements to be converted
     * @return java string
     */
    private static StringBuilder convertElementsIntoJavaText(Element[] elements) {
        StringBuilder elementsContents = new StringBuilder(),
                defineElements = new StringBuilder();
        defineElements.append("""
                \tpublic WebElement getElement(String webElement){
                \t\tif (webElement.toLowerCase().contains("btn")){
                \t\t\treturn AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeClickable(elementsMap.get(webElement));
                \t\t}else{
                \t\t\treturn AutomatedActions.WaitAndVisibilityActions.waitForAnElementToBeVisible(elementsMap.get(webElement));
                \t\t}
                \t}
                \s
                \tprivate void defineAllElements() {
                """);
        for (Element element : elements) {
            elementsContents.append(String.format("""
                            \tprivate final By %s_%s = By.%s("%s");
                            \tpublic String %s = "%s";
                             \s
                            """, element.elementName, element.locatorMethod, element.locatorMethod, element.locatorValue,
                    element.elementName,element.elementName));
            defineElements.append(String.format("""
                    \t\tthis.elementsMap.put(%s, %s_%s);
                    """, element.elementName,element.elementName, element.locatorMethod));
        }
        defineElements.append("""
                \t}
                \s
                """);
        elementsContents.append(defineElements);
        return elementsContents;
    }

    /**
     * This method is to generate the java class text for that page
     *
     * @param javaClassName java class name
     * @param elements      array of the page's elements
     * @return java class content as string
     */
    private static String generateJavaClassContent(String javaClassName, Element[] elements) {
        StringBuilder elementsContents = convertElementsIntoJavaText(elements);
        return String.format("""
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
                                            
                }""", javaClassName, javaClassName, elementsContents);
    }

    /**
     * This method is to generate the java classes
     *
     * @param javaFilesDirectory java files directory
     * @param javaFileName       java file name
     * @param contents           to be written in the class
     */
    private static void createJavaFileWithContent(File javaFilesDirectory, String javaFileName, String contents) throws IOException {
        FileWriter fileWriter = new FileWriter(javaFilesDirectory + File.separator + javaFileName);
        fileWriter.write(contents);
        fileWriter.flush();
    }

    /**
     * This method is to generate the java files from the json files
     */
    public static void generateJavaFiles() {
        //loop over the json files file by file
        for (File jsonFile : getJsonFilesFromElementsJsonFilesDirectory()) {
            try {
                // 1. get json content of the file
                String jsonContent = getContentsOfJsonFile(jsonFile);
                // 2. define java file name and java class name
                String javaFileName = jsonFile.getName().replace(".json", "") + ".java",
                        className = javaFileName.replace(".java", "");
                // 3. define java files directory
                File javaFilesDirectory = new File(Utilities.getElementsJavaFilesDirectory());
                // Note: if the java files directory doesn't exists, make it
                if (!javaFilesDirectory.exists()) {
                    //noinspection ResultOfMethodCallIgnored
                    javaFilesDirectory.mkdir();
                }
                // 4. read the web elements from the json file and store them into an array of elements
                Element[] webElements = getElementsArrayFromJsonContents(jsonContent);

                // 5. get the java class content
                String contents = generateJavaClassContent(className, webElements);

                // 6. create the java file and the file writer and fill the
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
