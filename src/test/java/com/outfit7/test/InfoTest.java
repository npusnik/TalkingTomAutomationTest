package com.outfit7.test;

import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InfoTest extends BaseTest {

    @Test
    void checkHowToPlayLabel() {
        // Click info button to open info panel
        driver.findElement(By.id("com.outfit7.talkingtom:id/buttonInfo")).click();

        // Click How To Play button to open instructions
        driver.findElement(By.id("com.outfit7.talkingtom:id/infoWebButtonHowToPlay")).click();

        // Set the expected string
        String expectedText = "Talk to Tom and he repeats with a funny voice";

        // Find the first label
        List<MobileElement> childElements = driver.findElements(By.className("android.view.View"));
        MobileElement resultText = childElements.get(0);

        // Check if string of the first element equals expected text string
        assertEquals(expectedText, resultText.getText(), "Expected the string to equal: "+expectedText);

        System.out.println("###Label text is correct!###");

    }
}
