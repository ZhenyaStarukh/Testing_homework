package pages;

import additional.ElementDisplayed;
import enums.Language;
import enums.UkraineLocations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Services')]")
    private WebElement servicesButton;

    @FindBy(xpath = "//div[contains(@class,'cookie-disclaimer__column')]")
    private List<WebElement> cookieWindow;

    @FindBy(xpath = "//button[contains(@class,'location-selector__button')][ contains(text(),'Global (EN)')]")
    private WebElement languageButton;

    @FindBy(xpath = "//span[contains(text(),'CONTACT US')]")
    private WebElement contactUsButton;

    @FindBy(xpath = "//*[contains(@class,'tabs__link js-tabs-link')][contains(text(),'Europe')]")
    private WebElement europeButton;

    @FindBy(xpath = "//div[@data-item-count=\"18\"]/div[@class=\"locations-viewer__carousel " +
            "owl-loaded owl-drag\"]/div[@class=\"owl-nav\"]/button[@class=\"owl-prev\"]")
    private WebElement arrowLeft;

// cannot see this element for some reason
//    @FindBy(xpath = "//div[@class=\"locations-viewer__country-title\"][text()=\"Ukraine\"]/parent::*")
//    private WebElement ukraineButton;

    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[10]/" +
            "section/div/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[26]/div/button")
    private WebElement ukraineButton;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void clickAcceptCookies(){
        disclaimerButton.click();
    }

    public void clickServicesButton(){
        servicesButton.click();
    }

    public void checkVanishedCookieWindow(){
        isElementNotDisplayed(cookieWindow);
    }

    public void clickLanguageButton(){
        languageButton.click();
    }

    public void clickContactUsButton(){
        contactUsButton.click();
    }

    public void chooseLanguage(Language language) {
        WebElement languageLink = driver.findElement(By.xpath("//a[contains(@href,'"+language.getSiteURL()+"')]"));
        languageLink.click();
    }

    public void seeOtherMainPage(Language language) {
        redirectedPage(language.getSiteURL()+"/");
    }

    public void onMainPage() {
        redirectedPage(SITE_URL);
    }

    public void clickEurope() {
        clickAcceptCookies();
        europeButton.click();
    }


    //toDo ukraineButton cannot be scrolled into view if found by another xpath -> solve this
    public void chooseUkraine() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        arrowLeft.click();
        arrowLeft.click();
        wait.until(ExpectedConditions.elementToBeClickable(ukraineButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ukraineButton);

        wait.until(new ElementDisplayed(ukraineButton));
        wait.until(ExpectedConditions.visibilityOf(ukraineButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/main/div[1]/div[10]/sect" +
                        "ion/div/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[26]/div/button")));

        new Actions(driver).moveToElement(ukraineButton).perform();

        ukraineButton.click();
    }


    private WebElement getMapButton(UkraineLocations location) {
        return driver.findElement(By.xpath("//h5[text()='" +
                location.getLocationName() +
                "']/parent::*/a[@class='locations-viewer__office-map']"));
    }

    public void clickOnMapButton(UkraineLocations location) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(getMapButton(location)));
        getMapButton(location).click();
    }

    private void forMapsRedirect(String url) {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        redirectedPage(url);
    }

    public void mapRedirect(UkraineLocations location) throws InterruptedException {
        forMapsRedirect(location.getLocationURL());
    }

}
