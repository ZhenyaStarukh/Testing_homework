package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;


public class MainPage extends BasePage {

    final String EPAM_RU = "https://www.epam-group.ru";


    @FindBy(xpath = "//a[contains(text(),'Services')]")
    private WebElement servicesButton;

    @FindBy(xpath = "//div[contains(@class,'cookie-disclaimer__column')]")
    private List<WebElement> cookieWindow;

    @FindBy(xpath = "//button[contains(@class,'location-selector__button')][ contains(text(),'Global (EN)')]")
    private WebElement languageButton;

    @FindBy(xpath = "//span[contains(text(),'CONTACT US')]")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[contains(@href,'"+EPAM_RU+"')]")
    private WebElement toRussianPageLink;

    @FindBy(xpath = "//*[contains(@class,'tabs__link js-tabs-link')][contains(text(),'Europe')]")
    private WebElement europeButton;


    @FindBy(xpath = "//div[@data-item-count=\"18\"]/div[@class=\"locations-viewer__carousel " +
            "owl-loaded owl-drag\"]/div[@class=\"owl-nav\"]/button[@class=\"owl-prev\"]")
    private WebElement arrowLeft;




    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[10]/section/div/div[2]/div/div[3]/div/div/div[1]/div[1]/div/div[26]/div/button")
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

    public void chooseRussian(){
        toRussianPageLink.click();
    }

    public void seeRussianMainPage() throws InterruptedException {
        redirectedPage(EPAM_RU+"/");
    }

    public void onMainPage() throws InterruptedException {
        redirectedPage(SITE_URL);
    }

    public void clickEurope(){
        clickAcceptCookies();
        europeButton.click();
    }


    public void chooseUkraine() throws InterruptedException {
        arrowLeft.click();
        sleep(500);
        arrowLeft.click();
        sleep(2000);

        ukraineButton.click();
    }

    @FindBy(xpath = "//h5[text()='Lviv']/parent::*/a[@class='locations-viewer__office-map']")
    private WebElement lvivMapButton;

    @FindBy(xpath = "//h5[text()='Dnipro']/parent::*/a[@class='locations-viewer__office-map']")
    private WebElement dniproMapButton;

    @FindBy(xpath = "//h5[text()='Kharkiv']/parent::*/a[@class='locations-viewer__office-map']")
    private WebElement kharkivMapButton;

    @FindBy(xpath = "//h5[text()='Vinnytsia']/parent::*/a[@class='locations-viewer__office-map']")
    private WebElement vinnytsiaMapButton;

    @FindBy(xpath = "//h5[text()='Kyiv: Registered office']/parent::*/a[@class='locations-viewer__office-map']")
    private WebElement kyivRoMapButton;

    @FindBy(xpath = "//h5[text()='Kyiv: Visitors office']/parent::*/a[@class='locations-viewer__office-map']")
    private WebElement kyivVoMapButton;

    private WebElement getMapButton(String str){
        switch (str){
            case "Lviv":
                return lvivMapButton;
            case "Dnipro":
                return dniproMapButton;
            case "Kharkiv":
                return kharkivMapButton;
            case "Vinnytsia":
                return vinnytsiaMapButton;
            case "Kyiv: Registered office":
                return kyivRoMapButton;
            default:
                return kyivVoMapButton;
        }
    }

    public void clickOnMapButton(String str){
        getMapButton(str).click();
    }

    private void forMapsRedirect(String url) throws InterruptedException {
        sleep(3000);
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        redirectedPage(url);
    }

    public void mapRedirect(String str) throws InterruptedException {
        switch (str){
            case "Lviv":
                forMapsRedirect("https://www.google.com/maps/place/EPAM+Systems/@49.8095285," +
                        "24.0436381,17z/data=!3m1!4b1!4m5!3m4!1s0x473ae7c0f43f1bdf:0xe269177e40b0f387!8m2!" +
                        "3d49.8095251!4d24.0458268?shorturl=1");
                break;
            case "Kharkiv":
                forMapsRedirect("https://www.google.com/maps/place/Epam%20Systems/" +
                        "@50.0354614,36.2178303,17z/_data=!4m12!1m6!3m5!1s0x4127a6b4ec8de933_" +
                        "0xf8300dc54356b778!2s23%20Serpnia!8m2!3d50.035458!4d36.220019!3m4!1s0x41" +
                        "27a131b25962f9:0x51992032d0c2e7be!8m2!3d50.0371529!4d36.2180655");
                break;
            case "Vinnytsia":
                forMapsRedirect("https://www.google.com/maps/search/51+Kozitskogo+S" +
                        "treet+Vinnytsia,+Ukraine/@49.2334869,28.4707423,17z/data=!3m1!4b1");
                break;
            case "Kyiv: visitors office":
                forMapsRedirect("https://www.google.com/maps/place/Kudryashova" +
                        "%20St,%2014b,%20Kyiv,%20Ukraine,%2003035/@50.4314743,30.4852715,17z" +
                        "/_data=!3m1!4b1!4m5!3m4!1s0x40d4cee98e046ebd_0xf37a6e0bf8259abe!8m2!" +
                        "3d50.4314709!4d30.4874602");
                break;
            default:
                onMainPage();
                break;
        }
    }

}
