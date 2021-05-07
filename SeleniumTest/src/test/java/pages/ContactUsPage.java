package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ContactUsPage extends BasePage {

   @FindBy(id = "_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email")
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


    public ContactUsPage(WebDriver driver){
        super(driver);
        SITE_URL+="about/who-we-are/contact";
    }

    public void seeContactUsPage() throws InterruptedException {
        redirectedPage(SITE_URL);
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void fillWrongEmail(){
        disclaimerButton.click();
        emailInput.sendKeys("wrongEmail");
        emailInput.sendKeys(Keys.ENTER);
    }

    public void fillEverythingExcept(String str){
        WebElement element;

        if (!str.equals("First Name")){
           firstNameInput.sendKeys("FirstName");
        }
        if (!str.equals("Last Name")){
            lastNameInput.sendKeys("LastName");
        }
        if (!str.equals("Email")){
            emailInput.sendKeys("Email@email.com");
        }
        if (!str.equals("Phone")){
            phoneInput.sendKeys("+123456789012");
        }
    }



    public void clickSubmit(){
        disclaimerButton.click();
        checkbox.click();
        submitButton.click();
    }

    private WebElement messageBox(String str){
        switch (str){
            case "First Name":
                return emptyFirstNameMessageBox;
            case "Last Name":
                return emptyLastNameMessageBox;
            case "Email":
                return emptyEmailMessageBox;
            case "Phone":
                return emptyPhoneMessageBox;
            default:
                return null;
        }
    }

    public void highlightBox(String str){

        List<WebElement> elements = new ArrayList<>();
        elements.add(messageBox(str));
        isElementVisible(elements);

    }

    public void highlightWrongEmail(){
        List<WebElement> elements = new ArrayList<>();
        elements.add(incorrectEmailMessageBox);
        isElementVisible(elements);
    }


}
