package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

import static config.WebDriverBrowserSetup.getInstance;

public class ScreenShot {

    @Attachment(value="Screenshot", type="image/png")
    public static byte[] captureScreenShot(){
        return ((TakesScreenshot) getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
