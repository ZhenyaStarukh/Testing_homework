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

    @FindBy(xpath = "//strong[text()='Consult']")
    private WebElement consultButton;

    @FindBy(xpath = "//strong[text()='Design']")
    private WebElement designButton;

    @FindBy(xpath = "//strong[text()='Engineer']")
    private WebElement engineerButton;

    @FindBy(xpath = "//strong[text()='Operate']")
    private WebElement operateButton;

    @FindBy(xpath = "//strong[text()='Optimize']")
    private WebElement optimizeButton;

    private final Map<Services, WebElement> serviceMap = new HashMap<>(5);

    public ServicesPage(WebDriver driver) {
        super(driver);
        SITE_URL+="services";
    }

    public void mapServices() {
        serviceMap.put(Services.CONSULT, consultButton);
        serviceMap.put(Services.DESIGN, designButton);
        serviceMap.put(Services.ENGINEER, engineerButton);
        serviceMap.put(Services.OPERATE, operateButton);
        serviceMap.put(Services.OPTIMIZE, optimizeButton);
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void clickLogo(){
        logo.click();
    }

    private WebElement findServiceElement(Services service) {
        return serviceMap.get(service);
    }

    public void clickServiceName(Services service) {
        disclaimerButton.click();
        findServiceElement(service).click();
    }

    public void checkRedirection(Services service) throws InterruptedException {
        isPageRedirected(service.getServicePageURL());
    }


}
