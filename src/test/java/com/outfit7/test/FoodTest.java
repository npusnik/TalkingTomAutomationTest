package com.outfit7.test;

import io.appium.java_client.MobileElement;
import org.aspectj.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FoodTest extends BaseTest {

    @Test
    void feedTheCat() throws IOException, InterruptedException {

        // Click Food Button to open food menu
        driver.findElement(By.id("com.outfit7.talkingtom:id/foodButton")).click();

        // Wait for menu animation to finish
        Thread.sleep(1000);

        // Store the value of food items left
        MobileElement foodNumberBefore = driver.findElement(By.id("com.outfit7.talkingtom:id/foodButtonNumber"));

        // Click on Cake to feed Tom
        driver.findElement(By.id("com.outfit7.talkingtom:id/foodItemCake")).click();

        // Wait for animation to begin and take a screenshot
        Thread.sleep(1000);
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(file, new File("C:/Users/Nejc3D/Desktop/Outfit7 test/sampleTest/target/Screenshots/TomEatingACake.jpg"));

        // Wait for animation to end
        Thread.sleep(5000);

        // Check if the value of food items left is different from the beginning of the test
        MobileElement foodNumberAfter = driver.findElement(By.id("com.outfit7.talkingtom:id/foodButtonNumber"));
        assertNotEquals(foodNumberBefore.getText(), foodNumberAfter.getText(), "Expected "+foodNumberBefore+" to decrease by 1");

        System.out.println("###Tom was indeed fed!###");
    }

}
