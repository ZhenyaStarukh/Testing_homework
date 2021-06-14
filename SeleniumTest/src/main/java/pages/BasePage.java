package pages;

import additional.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    protected String SITE_URL="https://www.epam.com/";
    public WebDriver driver;
    public WebDriverWait wait;

    protected final By disclaimerButton =
            new By.ByXPath("//*[contains(@class,'button-ui bg-color-light-blue cookie-disclaimer__button')]");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,1);
    }

    public Boolean isElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return Utils.elementIsVisible(element);
    }

    public Boolean hasColor(WebElement element, String color) {
        return element.getCssValue("color").equals(color);
    }

    public Boolean isPageRedirected(String url) {
        new WebDriverWait(driver,20).until(ExpectedConditions.urlToBe(url));
        return url.equals(driver.getCurrentUrl());
    }

}
