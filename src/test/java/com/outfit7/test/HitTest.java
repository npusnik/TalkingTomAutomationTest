package com.outfit7.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

class HitTest extends BaseTest{

    @Test
    void hitTheCat(){

        MobileElement cat = driver.findElement(By.id("com.outfit7.talkingtom:id/foodButtonNumber"));

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(700, 1400)).perform();

    }
}
