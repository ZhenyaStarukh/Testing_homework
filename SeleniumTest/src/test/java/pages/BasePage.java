package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BasePage {

    protected String SITE_URL="https://www.epam.com/";
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//*[contains(@class,'button-ui bg-color-light-blue cookie-disclaimer__button')]")
    protected WebElement disclaimerButton;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,1);
    }

    public void isElementNotDisplayed(List<WebElement> elements){
        assertFalse(elements.size()>0);
    }

    public void isElementVisible(WebElement element){
        assertEquals(element.getAttribute("visibility"), "visible");
    }

    public void redirectedPage(String url) {
        new WebDriverWait(driver,20).until(ExpectedConditions.urlToBe(url));
        assertEquals(url, driver.getCurrentUrl());
    }

}
