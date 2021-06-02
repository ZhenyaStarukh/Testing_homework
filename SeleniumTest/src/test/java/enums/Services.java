package enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public enum Services {
    CONSULT("CONSULT", "https://www.epam.com/services/consult-and-design",
            new By.ByXPath("//strong[text()='Consult']")),
    DESIGN("DESIGN", "https://www.epam.com/services/consult-and-design",
            new By.ByXPath("//strong[text()='Design']")),
    ENGINEER("ENGINEER", "https://www.epam.com/services/engineer",
            new By.ByXPath("//strong[text()='Engineer']")),
    OPERATE("OPERATE", "https://www.epam.com/services/operate",
            new By.ByXPath("//strong[text()='Operate']")),
    OPTIMIZE("OPTIMIZE", "https://www.epam.com/services/optimize",
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
