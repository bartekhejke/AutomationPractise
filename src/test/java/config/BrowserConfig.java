package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static config.WebDriverBrowserSetup.quit;
import static tools.ScreenShot.captureScreenShot;
import static config.WebDriverBrowserSetup.getInstance;

public class BrowserConfig {
    private WebDriver driver;

    @Before
    public void SetupBrowser(){

        String Url = "http://automationpractice.com/index.php";

        driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url);
    }

    @After
    public void Shutdown(){
        captureScreenShot();
        quit();
    }

}
