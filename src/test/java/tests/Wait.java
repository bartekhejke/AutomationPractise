package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static config.WebDriverBrowserSetup.getInstance;

public class Wait {
    static final int WAIT_TIMEOUT=10;
    private static WebDriverWait wait = new WebDriverWait(getInstance(), WAIT_TIMEOUT);

    public static void waitForVisibilityElements(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
