package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class BasePage {

    protected String SITE_URL="https://www.epam.com/";
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class,'button-ui bg-color-light-blue cookie-disclaimer__button')]")
    protected WebElement disclaimerButton;

    protected String capitalize(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    protected boolean isClickable(WebElement el){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void isElementNotDisplayed(List<WebElement> elements){
        assertFalse(elements.size()>0);
    }

    public void isElementVisible(List<WebElement> elements){
        assertTrue(elements.size()>0);
    }

    public void redirectedPage(String url) throws InterruptedException {
        sleep(500);
        assertEquals(url, driver.getCurrentUrl());
    }




}
