package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import tools.DataFaker;
import static config.WebDriverBrowserSetup.getInstance;

import static tools.ScreenShot.captureScreenShot;

public class SignIn extends Base {

    private DataFaker datafaker = new DataFaker();

    public SignIn(){
        super();
    }

    @FindBy(id ="email_create")
    private WebElement emailSpace;

    @FindBy(id ="SubmitCreate")
    private WebElement createAccountButton;


    @Step
    public SignUp createAccount(){
        emailSpace.sendKeys(datafaker.getFakeEmail());
        captureScreenShot();
        createAccountButton.click();
        return new SignUp();
    }
    @Step
    public  SignIn createAccountInvalidEmail(){
        emailSpace.sendKeys(datafaker.getFakeFirstName());
        captureScreenShot();
        createAccountButton.click();
        return this;
    }

    @Step
    public void invalidEmailRegistration() {
        Assert.assertTrue(getInstance().getPageSource().contains("Please enter your email address to create an account."));
    }





}
