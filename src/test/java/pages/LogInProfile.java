package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class LogInProfile extends Base {

    public LogInProfile(){
        super();
    }

    @FindBy(css = "[title=\"Log me out\"]")
    WebElement logOutButton;

    @Step
    public void successfullyRegistered(){
        String logOutButtonText = logOutButton.getText();

        Assert.assertThat(logOutButtonText, IsEqual.equalTo("Sign out"));
    }

}
