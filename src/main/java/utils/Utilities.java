package utils;

import base.Base;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utilities extends Base {

    public static ChromeDriver openChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static FirefoxDriver openFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static String getConfigFilePath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
    }

    private static String getTestDataFilePath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testdata.json";
    }

    private static String getScreenshotsDirectory() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "screenshots";
    }

    public static String getPropertyFromConfigFile(String property) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(getConfigFilePath()));
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(property.toLowerCase());
    }

    public static String getElementsJsonFilesDirectory() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "pages" + File.separator + "pagesElements";
    }

    public static String getElementsJavaFilesDirectory() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "pages" + File.separator + "pages";
    }

    public static void maximizePage(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    private static TestCaseData[] retrieveAllTestCases() {
        try {
            InputStream inputStream = new FileInputStream(getTestDataFilePath());
            String testDataJson = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(testDataJson);
            ObjectMapper objectMapper = new ObjectMapper();
            TestCaseData[] testCases = new TestCaseData[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                testCases[i] = objectMapper.readValue(jsonArray.getJSONObject(i).getJSONObject("testCase").toString(), TestCaseData.class);
            }
            return testCases;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TestCaseData getTestCase(String testCaseName) {
        TestCaseData[] testCaseList = Utilities.retrieveAllTestCases();
        assert testCaseList != null;
        for (TestCaseData testCase : testCaseList) {
            if (testCase.getTestCaseName().equals(testCaseName)) {
                return testCase;
            }
        }
        return null;
    }

    public static void takeScreenShot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String screenshotDestPath = getScreenshotsDirectory() + File.separator + screenshotName;
        File screenshotFile = ((TakesScreenshot) Base.webDriver).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenshotFile.toPath(), Paths.get(screenshotDestPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }

    public static void captureAndAttachScreenshot() {
        byte[] screenshot = ((TakesScreenshot) Base.webDriver).getScreenshotAs(OutputType.BYTES);
        attachScreenshot(screenshot);
    }

    public static void main(String[] args) {
        retrieveAllTestCases();
    }
}
