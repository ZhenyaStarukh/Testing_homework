package pages;

import additional.ElementDisplayed;
import additional.Utils;
import enums.Language;
import enums.UkraineLocations;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;


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

    private final By ukraineButton = new By.ByXPath("//div[@class=\"owl-item active\"]/div[@data-country=\"ukraine\"]/button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get(SITE_URL);
    }

    public void clickAcceptCookies() {
        driver.findElement(disclaimerButton).click();
    }

    public void clickServicesButton() {
        driver.findElement(servicesButton).click();
    }

    public Boolean checkVanishedCookieWindow() {
        return Utils.elementIsNotDisplayed(cookieWindow, driver);
    }

    public void clickLanguageButton() {
        driver.findElement(languageButton).click();
    }

    public void clickContactUsButton() {
        driver.findElement(contactUsButton).click();
    }

    public void chooseLanguage(Language language) {
        WebElement languageLink = driver.findElement(By.xpath("//a[contains(@href,'"+language.getSiteURL()+"')]"));
        languageLink.click();
    }

    public Boolean seeOtherMainPage(Language language) {
        return isPageRedirected(language.getSiteURL()+"/");
    }

    public Boolean isOnMainPage() {
        return isPageRedirected(SITE_URL);
    }

    public void clickRegion(By byRegion) {
        clickAcceptCookies();
        driver.findElement(byRegion).click();
    }

    public void chooseCountry(By byCountry) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(arrowLeft));

        do{
            driver.findElement(arrowLeft).click();
            sleep(300);
        }while(!Utils.elementIsVisible(driver.findElement(byCountry)));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(byCountry)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(byCountry));

        wait.until(new ElementDisplayed(driver.findElement(byCountry)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byCountry)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byCountry));

        new Actions(driver).moveToElement(driver.findElement(byCountry)).perform();

        driver.findElement(byCountry).click();
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

    private Boolean redirectToMap(String url) {
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        return isPageRedirected(url);
    }

    public Boolean checkMapRedirect(UkraineLocations location) throws InterruptedException {
        return redirectToMap(location.getLocationURL());
    }

}
