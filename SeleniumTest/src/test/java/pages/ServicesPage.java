package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ServicesPage extends BasePage {

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/div/header/div/a/img")
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



    public ServicesPage(WebDriver driver){
        super(driver);
        SITE_URL+="services";
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void clickLogo(){
        logo.click();
    }

    private WebElement findServiceElement(String name){
        switch (name){
            case "Consult":
                return consultButton;
            case "Design":
                return designButton;
            case "Engineer":
                return engineerButton;
            case "Operate":
                return operateButton;
            default:
                return optimizeButton;
        }
    }

    public void clickServiceName(String name){
        disclaimerButton.click();
        name = capitalize(name);
        findServiceElement(name).click();
    }

    public void checkRedirection(String page) throws InterruptedException {
        redirectedPage(SITE_URL+"/"+page);
    }


}
