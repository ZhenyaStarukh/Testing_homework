package pages;

import enums.FormField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactUsPage extends BasePage {

   @FindBy(id = "_content_epam_en_about_who-we-are_contact_jcr_content" +
           "_content-container_section_section-par_form_constructor_user_email")
   private WebElement emailInput;

   @FindBy(id = "_content_epam_en_about_who-we-are_contact_jcr_" +
           "content_content-container_section_section-par_form_constructor_user_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "_content_epam_en_about_who-we-are_contact_jcr_" +
            "content_content-container_section_section-par_form_constructor_user_last_name")
    private WebElement lastNameInput;

    @FindBy(id="_content_epam_en_about_who-we-are_contact_jcr" +
            "_content_content-container_section_section-par_form_constructor_user_phone")
    private WebElement phoneInput;

    @FindBy(className = "checkbox__holder")
    private WebElement checkbox;

    @FindBy(xpath = "//button[contains(text(),'Submit')][contains(@class,'button-ui')]")
    private WebElement submitButton;

    @FindBy(xpath = "//em[@class='is-a11y-only'][text()='First Name']")
    private WebElement emptyFirstNameMessageBox;

    @FindBy(xpath = "//em[@class='is-a11y-only'][text()='Last Name']")
    private WebElement emptyLastNameMessageBox;

    @FindBy(xpath = "//em[@class='is-a11y-only'][text()='Email]")
    private WebElement emptyEmailMessageBox;

    @FindBy(xpath = "//em[@class='is-a11y-only'][text()='Phone']")
    private WebElement emptyPhoneMessageBox;

    @FindBy(xpath = "//span[@class='validation-text' and text()='Incorrect email format']")
    private WebElement incorrectEmailMessageBox;


    private final Map<FormField, WebElement> fieldMap = new HashMap<>(4);
    private final Map<FormField, WebElement> emptyBoxMap = new HashMap<>(4);


    public ContactUsPage(WebDriver driver){
        super(driver);
        SITE_URL+="about/who-we-are/contact";
    }

    public void mapFields(){
        fieldMap.put(FormField.FIRST_NAME,firstNameInput);
        fieldMap.put(FormField.LAST_NAME, lastNameInput);
        fieldMap.put(FormField.EMAIL,emailInput);
        fieldMap.put(FormField.PHONE,phoneInput);

        emptyBoxMap.put(FormField.FIRST_NAME, emptyFirstNameMessageBox);
        emptyBoxMap.put(FormField.LAST_NAME, emptyLastNameMessageBox);
        emptyBoxMap.put(FormField.EMAIL, emptyEmailMessageBox);
        emptyBoxMap.put(FormField.PHONE, emptyPhoneMessageBox);
    }

    public void seeContactUsPage() {
        redirectedPage(SITE_URL);
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void fillEmail(String email) {
        disclaimerButton.click();
        emailInput.sendKeys(email);
        emailInput.sendKeys(Keys.ENTER);
    }


    public void fillEverythingExcept(FormField field) {
        for (FormField formField : FormField.values()){
            if(!formField.equals(field)){
                System.out.println(fieldMap.get(formField));
                fieldMap.get(formField).sendKeys(formField.getValue());
            }
        }
    }

    public void clickSubmit() {
        disclaimerButton.click();
        checkbox.click();
        submitButton.click();
    }

    private WebElement messageBox(FormField field) {

        return emptyBoxMap.get(field);

    }

    public void highlightBox(FormField field) {
        isElementVisible(messageBox(field));
    }

    public void highlightWrongEmail() {
        isElementVisible(incorrectEmailMessageBox);
    }


}
