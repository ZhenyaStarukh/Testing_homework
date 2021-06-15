package enums;

import additional.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public enum Services {
    CONSULT("CONSULT", new PropertiesUtils().getProperty("service.consult&design"),
            new By.ByXPath("//strong[text()='Consult']")),
    DESIGN("DESIGN", new PropertiesUtils().getProperty("service.consult&design"),
            new By.ByXPath("//strong[text()='Design']")),
    ENGINEER("ENGINEER", new PropertiesUtils().getProperty("service.engineer"),
            new By.ByXPath("//strong[text()='Engineer']")),
    OPERATE("OPERATE", new PropertiesUtils().getProperty("service.operate"),
            new By.ByXPath("//strong[text()='Operate']")),
    OPTIMIZE("OPTIMIZE", new PropertiesUtils().getProperty("service.optimize"),
            new By.ByXPath("//strong[text()='Optimize']"));

    private final String serviceName;
    private final String servicePageURL;
    private final By serviceButton;

    Services (String serviceName, String servicePageURL, By serviceButton) {
        this.serviceName = serviceName;
        this.servicePageURL = servicePageURL;
        this.serviceButton = serviceButton;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServicePageURL() {
        return servicePageURL;
    }

    public WebElement getServiceButton(WebDriver driver) {
        return driver.findElement(serviceButton);
    }
}
