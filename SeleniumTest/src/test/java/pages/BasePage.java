package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

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

    public void isElementNotDisplayed(By by) {
        try{
            assertFalse(driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException exception) {
            assert true;
        }

    }

    public void isElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getCssValue("visibility"), "visible");
    }

    public void hasColor(WebElement element, String color) {
        assertEquals(element.getCssValue("color"), color);
    }

    public void isPageRedirected(String url) {
        new WebDriverWait(driver,20).until(ExpectedConditions.urlToBe(url));
        assertEquals(url, driver.getCurrentUrl());
    }

}
