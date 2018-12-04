package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static config.WebDriverBrowserSetup.getInstance;
import static tests.Wait.waitForVisibilityElements;

public class Base {

    public Base(){
        PageFactory.initElements(getInstance(), this);
        waitForVisibilityElements(elements);
    }

    @FindBy(id = "page")
    private WebElement elements;
}
