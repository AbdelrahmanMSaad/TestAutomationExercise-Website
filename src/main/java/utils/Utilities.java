package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Utilities {
    /**
     * This method is to setup google chrome driver
     *
     * @return ChromeDriver Object
     */
    public static ChromeDriver openChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * This method is to setup google chrome driver
     *
     * @return FirefoxDriver Object
     */
    public static FirefoxDriver openFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /**
     * This method is to get the get the config file path
     */
    private static String getConfigFilePath() {
        return System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
    }

    /**
     * This method is to get the get the test cases file path
     */
    private static String getTestDataFilePath() {
        return System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.json";
    }

    /**
     * This method is to get property from config file path
     * @return the property value as as string
     */
    public static String getPropertyFromConfigFile(String property) throws IOException {
        FileInputStream fileInputStream;
        File file = new File(Utilities.getConfigFilePath());
            fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(property.toLowerCase());
    }

    /**
     * This method is to get the json files directory containing the elements of the pages
     */
    public static String getElementsJsonFilesDirectory() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "pages" + File.separator + "pagesElements";
    }

    /**
     * This method is to get the java files directory, these java files will define the pages web elements and their methods
     */
    public static String getElementsJavaFilesDirectory() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                + "java" + File.separator + "pages" + File.separator + "pages";
    }

    public static void maximizePage(WebDriver webDriver){
        webDriver.manage().window().maximize();
    }

    /**
     * This method is to get all test data from the test data json file and parse it into test case data objects
     * @return an array of Test cases data
     */
    private static TestCaseData[] retrieveAllTestCases(){
        try {
            InputStream inputStream = new FileInputStream(Utilities.getTestDataFilePath());
            String testDataJson = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(testDataJson);
            ObjectMapper objectMapper = new ObjectMapper();
            TestCaseData[] testCases = new TestCaseData[jsonArray.length()];
            for (int i = 0 ; i < jsonArray.length() ; i++){
                testCases[i] = objectMapper.readValue(jsonArray.getJSONObject(i).getJSONObject("testCase").toString(), TestCaseData.class);
            }
            return testCases;
            } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is for getting a test case object and use its data as test data for a test
     * @param testCaseName the test case name that requires the test data
     * @return test case object with the data
     */
    public static TestCaseData getTestCase(String testCaseName){
        TestCaseData[] testCaseList = Utilities.retrieveAllTestCases();
        assert testCaseList != null;
        for(TestCaseData testCase:testCaseList){
            if(testCase.getTestCaseName().equals(testCaseName)){
                return testCase;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Utilities.retrieveAllTestCases();
    }


}
