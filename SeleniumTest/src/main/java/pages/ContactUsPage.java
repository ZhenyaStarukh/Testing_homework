package pages;

import enums.FormField;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;


public class ContactUsPage extends BasePage {

    @FindBy(className = "checkbox__holder")
    private WebElement checkbox;

    @FindBy(xpath = "//button[contains(text(),'Submit')][contains(@class,'button-ui')]")
    private WebElement submitButton;

    @FindBy(xpath = "//span[@class='validation-text' and text()='Incorrect email format']")
    private WebElement incorrectEmailMessageBox;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        SITE_URL+="about/who-we-are/contact";
    }

    public boolean seeContactUsPage() {
        return isPageRedirected(SITE_URL);
    }

    public void goTo() {
        driver.get(SITE_URL);
    }

    public void fillEmail(String email) {
        driver.findElement(disclaimerButton).click();
        FormField.EMAIL.getInputBox(driver).sendKeys(email);
        FormField.EMAIL.getInputBox(driver).sendKeys(Keys.ENTER);
    }


    public void fillEverythingExcept(FormField field) {
        for (FormField formField : FormField.values()) {
            if(!formField.equals(field)) {
                formField.getInputBox(driver).sendKeys(formField.getValue());
            }
        }
    }

    public void clickSubmit() {
        driver.findElement(disclaimerButton).click();
        checkbox.click();
        submitButton.click();
    }

    public Boolean highlightBox(FormField field) {
        return hasColor(field.getInputBox(driver), "rgb(241, 92, 67)");
    }

    public Boolean highlightWrongEmail() {
        return isElementVisible(incorrectEmailMessageBox);
    }


}
