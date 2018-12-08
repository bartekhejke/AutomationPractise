package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import tools.DataFaker;
import static config.WebDriverBrowserSetup.getInstance;

import static tools.ScreenShot.captureScreenShot;

public class SignIn extends Base {

    private DataFaker datafaker = new DataFaker();

    private static final String LOGIN = "prawidloweBH@wp.pl";
    private static final String PASSWORD = "prawidloweBH";
    private static final String LOGIN_ALERT="An email address required.";
    private static final String PASSWORD_ALERT="Password is required.";

    public SignIn(){
        super();
    }

    @FindBy(id ="email_create")
    private WebElement emailSpace;

    @FindBy(id ="SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id ="email")
    private WebElement emailLoginSpace;

    @FindBy(id = "passwd")
    private WebElement passwordLoginSpace;

    @FindBy(id = "SubmitLogin")
    private WebElement loginAccountButton;

    @FindBy(css = "#center_column > .alert li")
    private WebElement loginAlert;


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
        captureScreenShot();
        Assert.assertTrue(getInstance().getPageSource().contains("Please enter your email address to create an account."));
    }

    private void fillingLoginSpace(String emai, String password){
        emailLoginSpace.sendKeys(emai);
        passwordLoginSpace.sendKeys(password);
    }

    @Step
    public void emptyLoginPasswordSpace(){

        loginAccountButton.click();
        captureScreenShot();
        Assert.assertThat(loginAlert.getText(), IsEqual.equalTo(LOGIN_ALERT));
    }

    @Step
    public LogInProfile validLoginPassword(){



        fillingLoginSpace(LOGIN,PASSWORD);
        captureScreenShot();
        loginAccountButton.click();
        return new LogInProfile();
    }

    @Step
    public void emptyPasswordSpace(){

        fillingLoginSpace(LOGIN,"");
        loginAccountButton.click();
        captureScreenShot();
        Assert.assertThat(loginAlert.getText(), IsEqual.equalTo(PASSWORD_ALERT));

    }




}
