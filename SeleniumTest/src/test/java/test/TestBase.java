package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.MainPage;
import pages.ServicesPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

//ToDo polish the code for it to look more readable
    protected WebDriver driver;
    protected MainPage mainPage;
    protected ServicesPage servicesPage;
    protected ContactUsPage contactUsPage;

    @BeforeEach
    public void start(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        servicesPage = PageFactory.initElements(driver, ServicesPage.class);
        servicesPage.mapServices();
        contactUsPage = PageFactory.initElements(driver,ContactUsPage.class);
        contactUsPage.mapFields();
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }

}
