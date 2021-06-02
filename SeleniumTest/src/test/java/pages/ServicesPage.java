package pages;

import enums.Services;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;


public class ServicesPage extends BasePage {

    @FindBy(xpath = "//img[@class=\"header__logo\"]")
    private WebElement logo;

    public ServicesPage(WebDriver driver) {
        super(driver);
        SITE_URL+="services";
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void clickLogo(){
        logo.click();
    }

    private WebElement findServiceElement(Services service) {
        return service.getServiceButton(driver);
    }

    public void clickServiceName(Services service) {
        driver.findElement(disclaimerButton).click();
        findServiceElement(service).click();
    }

    public void checkRedirection(Services service) throws InterruptedException {
        isPageRedirected(service.getServicePageURL());
    }

}
