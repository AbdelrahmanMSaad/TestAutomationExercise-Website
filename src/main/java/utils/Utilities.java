package utils;

import base.Navigation;
import base.WebDriverHelper;
import getDirectories.GetDirectories;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utilities extends Navigation {

    public static String generateRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void takeScreenShot(String testName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String screenshotName = testName + "_" + timestamp + ".png";
        String screenshotDestPath = GetDirectories.getScreenshotsDirectory() + File.separator + screenshotName;
        File screenshotFile = ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.FILE);

        try {
            Files.copy(screenshotFile.toPath(), Paths.get(screenshotDestPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
