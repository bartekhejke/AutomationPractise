package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverBrowserSetup {

    private static WebDriver driver;

    private WebDriverBrowserSetup(){}

    public static WebDriver getInstance(){
        if( driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quit(){
        if(driver != null) {
            driver.quit();
        }
        driver = null;
    }


}