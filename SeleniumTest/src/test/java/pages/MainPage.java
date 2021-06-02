package pages;

import additional.ElementDisplayed;
import enums.Language;
import enums.UkraineLocations;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage {

    private final By servicesButton = new By.ByXPath("//a[contains(text(),'Services')]");

    private final By cookieWindow = new By.ByXPath("//div[@class = 'cookie-disclaimer__column']");

    private final By languageButton = new
            By.ByXPath("//button[contains(@class,'location-selector__button')]" +
            "[ contains(text(),'Global (EN)')]");

    private final By contactUsButton = new By.ByXPath("//span[contains(text(),'CONTACT US')]");

    private final By europeButton = new
            By.ByXPath("//*[contains(@class,'tabs__link js-tabs-link')][contains(text(),'Europe')]");

    private final By arrowLeft = new By.ByXPath("//div[@data-item-count=\"18\"]/div[@class=\"locations-viewer__carousel " +
            "owl-loaded owl-drag\"]/div[@class=\"owl-nav\"]/button[@class=\"owl-prev\"]");

    private final By countryButtons = new By.ByXPath("//button[@class=\"locations-viewer__country-btn\"]");

    private final By childCountryButton = new By.ByXPath(".//div[@class=\"locations-viewer__country-title\"]");


    private final By by = new By.ByXPath("//div[@class=\"owl-item active\"]/div[@data-country=\"ukraine\"]/button");

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void goTo(){
        driver.get(SITE_URL);
    }

    public void clickAcceptCookies(){
        driver.findElement(disclaimerButton).click();
    }

    public void clickServicesButton(){
        driver.findElement(servicesButton).click();
    }

    public void checkVanishedCookieWindow(){
        isElementNotDisplayed(cookieWindow);
    }

    public void clickLanguageButton(){
        driver.findElement(languageButton).click();
    }

    public void clickContactUsButton(){
        driver.findElement(contactUsButton).click();
    }

    public void chooseLanguage(Language language) {
        WebElement languageLink = driver.findElement(By.xpath("//a[contains(@href,'"+language.getSiteURL()+"')]"));
        languageLink.click();
    }

    public void seeOtherMainPage(Language language) {
        isPageRedirected(language.getSiteURL()+"/");
    }

    public void isOnMainPage() {
        isPageRedirected(SITE_URL);
    }

    public void clickEurope() {
        clickAcceptCookies();
        driver.findElement(europeButton).click();
    }


    //toDo check why the text is not shown -> probably this is why the function above won't work
    public void chooseUkraine() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(arrowLeft).click();
        driver.findElement(arrowLeft).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(by));

        wait.until(new ElementDisplayed(driver.findElement(by)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        new Actions(driver).moveToElement(driver.findElement(by)).perform();

        driver.findElement(by).click();
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

    private void redirectToMap(String url) {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        isPageRedirected(url);
    }

    public void checkMapRedirect(UkraineLocations location) throws InterruptedException {
        redirectToMap(location.getLocationURL());
    }

}
