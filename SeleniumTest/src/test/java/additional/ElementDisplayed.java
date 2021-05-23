package additional;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ElementDisplayed implements ExpectedCondition<Boolean> {

    private final WebElement element;

    @Override
    public Boolean apply(WebDriver driver) {
        return element.isDisplayed();
    }

    public ElementDisplayed(WebElement element) {
        this.element = element;
    }
}
