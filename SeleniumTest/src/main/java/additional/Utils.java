package additional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    public static Boolean elementIsNotDisplayed(By by, WebDriver driver){
        return driver.findElements(by).isEmpty();
    }

    public static Boolean elementIsVisible(WebElement element){
        return element.getCssValue("visibility").equals("visible");
    }
}
