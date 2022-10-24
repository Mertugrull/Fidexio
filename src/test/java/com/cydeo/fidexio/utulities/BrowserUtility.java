package com.cydeo.fidexio.utulities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

    public class BrowserUtility {

        //this method will accept int seconds and execute Thread.sleep for given duration
        public static void sleep(int second){

            second*=1000;
            try {
                Thread.sleep(second);
            }catch (InterruptedException e){

            }
        }

        public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

            Set<String> allWindowsHandles=driver.getWindowHandles();

            for (String each : allWindowsHandles) {
                driver.switchTo().window(each);
                if(driver.getCurrentUrl().contains(expectedInUrl)){
                    break;
                }
            }

            Assert.assertTrue(driver.getTitle().contains(expectedTitle));

        }

        /**
         * this method will verify if the current url contains expected url order
         * @param driver
         * @param expectedTitle
         */

        public static void urlVerify(WebDriver driver,String expectedTitle){


            Assert.assertTrue(driver.getTitle().equals(expectedTitle));


        }


        public static void titleVerifyContains(String expectedTitle){
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedTitle));
        }

        /**
         * This method will accept a dropdown as a WebElement
         * @param dropdownElement
         * @return
         */

        public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
            Select select= new Select(dropdownElement);

            List<WebElement> actualOptionsWebElement=select.getOptions();

            List<String> actualOptionsString= new ArrayList<>();

            for (WebElement each : actualOptionsWebElement) {
                actualOptionsString.add(each.getText());
            }

            return actualOptionsString;

        }

        /**
         *
         * @param radioButton
         * @param attributeValue
         */

        public static void radioButtons(List<WebElement> radioButton, String attributeValue){

            for (WebElement each : radioButton) {
                if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                    each.click();
                }
            }

        }

        public static void waitForInvisibilityOf(WebElement webElement){
            //Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        }


    }
