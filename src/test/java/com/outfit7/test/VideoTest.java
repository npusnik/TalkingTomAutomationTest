package com.outfit7.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoTest extends BaseTest{

    @Test
    void recordTheVideo() throws InterruptedException, IOException {

        // Start recording actions
        driver.findElement(By.id("com.outfit7.talkingtom:id/recorderButton")).click();

        // Tap on the screen to hit Tom
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(700, 2890)).perform();
        Thread.sleep(500);
        touchAction.tap(PointOption.point(700, 2300)).perform();
        Thread.sleep(500);
        touchAction.tap(PointOption.point(700, 1400)).perform();

        // Wait to make the video longer
        Thread.sleep(3000);

        // Stop recording
        driver.findElement(By.id("com.outfit7.talkingtom:id/recorderButton")).click();

        // Check if Play button has appeared on the screen
        MobileElement playButton = driver.findElement(By.id("com.outfit7.talkingtom:id/recorderMenuButtonPlay"));
        playButton.isEnabled();

        // Play the recording back
        playButton.click();

        // Check if Stop playing button has appeared
        MobileElement stopButton = driver.findElement(By.id("com.outfit7.talkingtom:id/stopbtn"));
        stopButton.isEnabled();

        // Click Stop button to stop playing recording
        stopButton.click();

        // Find gallery option and click it
        MobileElement shareOptions = driver.findElementById("com.outfit7.talkingtom:id/recorderMenuButtonsLinearLayout");
        List<MobileElement> childElements = shareOptions.findElementsByClassName("android.widget.TextView");
        MobileElement galleryButton = childElements.get(0);
        galleryButton.click();

        // Allow access to storage in order to save the clip
        MobileElement allowPermissionButton = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));

        if (allowPermissionButton != null) {
            allowPermissionButton.click();
        }

        // Take screenshot of video converting
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(file, new File("C:/Users/Nejc3D/Desktop/Outfit7 test/sampleTest/target/Screenshots/ConvertingVideo.jpg"));

        // Check if video was actually saved
        MobileElement VideoSavedText = driver.findElement(By.id("com.outfit7.talkingtom:id/recorderSDCardConvertingTextView"));
        VideoSavedText.isDisplayed();

        // Check if the text says the right thing
        String expectedText = "Video successfully saved to Gallery.";
        assertEquals(expectedText, VideoSavedText.getText());

        System.out.println("###Recorded video was saved to the gallery!###");
    }
}
