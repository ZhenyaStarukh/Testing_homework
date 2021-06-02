package enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public enum FormField {
    FIRST_NAME("FirstName", new By.ById("_content_epam_en_about_who-we-are_contact_jcr_content" +
            "_content-container_section_section-par_form_constructor_user_first_name")),
    LAST_NAME("LastName", new By.ById("_content_epam_en_about_who-we-are_contact_jcr_content" +
            "_content-container_section_section-par_form_constructor_user_last_name")),
    EMAIL("Email@email.com", new By.ById("_content_epam_en_about_who-we-are_contact_jcr_content" +
            "_content-container_section_section-par_form_constructor_user_email")),
    PHONE("+123456789012", new By.ById("_content_epam_en_about_who-we-are_contact_jcr_content" +
            "_content-container_section_section-par_form_constructor_user_phone"));

    private final String value;
    private final By inputBox;

    FormField(String value, By inputBox){
        this.value = value;
        this.inputBox = inputBox;
    }

    public String getValue(){
        return value;
    }

    public WebElement getInputBox(WebDriver driver) {
        return driver.findElement(inputBox);
    }

}
