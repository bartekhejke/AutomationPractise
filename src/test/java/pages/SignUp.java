package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import tools.DataFaker;

import java.util.ArrayList;
import java.util.List;

import static tools.ScreenShot.captureScreenShot;

public class SignUp extends Base {

    DataFaker datafaker = new DataFaker();

    public SignUp(){
        super();
    }

    @FindBy (id ="uniform-id_gender1")
    WebElement maleTitleRadio;

    @FindBy (id ="customer_firstname")
    WebElement firstNameSpace;

    @FindBy (id ="customer_lastname")
    WebElement lastNameSpace;

    @FindBy (id ="passwd")
    WebElement passwordSpace;

    @FindBy (id ="days")
    WebElement daysSelector;

    @FindBy (id ="months")
    WebElement monthsSelector;

    @FindBy (id ="years")
    WebElement yearsSelector;

    @FindBy (id ="address1")
    WebElement addressSpace;

    @FindBy (id ="city")
    WebElement citySpace;

    @FindBy (id="id_state")
    WebElement stateSelector;

    @FindBy (id ="postcode")
    WebElement zipCodeSpace;

    @FindBy (id="id_country")
    WebElement countrySelector;

    @FindBy (id ="phone_mobile")
    WebElement phoneNumberSpace;

    @FindBy (id ="submitAccount")
    WebElement submitRegistrationButton;

    @FindBy(css = "#center_column > .alert li")
    private List<WebElement> alertMessagesRegistrationElement;

    private void fillingRegistrationSpace(){
        maleTitleRadio.click();
        firstNameSpace.sendKeys(datafaker.getFakeFirstName());
        lastNameSpace.sendKeys(datafaker.getFakeLastName());
        passwordSpace.sendKeys(datafaker.getFakePassword());
        new Select(daysSelector).selectByValue("1");
        new Select(monthsSelector).selectByValue("1");
        new Select(yearsSelector).selectByValue("2000");
        addressSpace.sendKeys(datafaker.getFakeStreet());
        citySpace.sendKeys(datafaker.getFakeCity());
        new Select(stateSelector).selectByValue("1");
        zipCodeSpace.sendKeys("00000");
        new Select(countrySelector).selectByValue("21");
        phoneNumberSpace.sendKeys(datafaker.getFakeMobilePhone());
    }

    @Step
    public LogInProfile submitValidDataRegistration(){
        fillingRegistrationSpace();
        captureScreenShot();
        submitRegistrationButton.click();
        return new LogInProfile();
    }

    @Step
    public SignUp submitInvalidDataRegistration(){
        submitRegistrationButton.click();
        captureScreenShot();
        return this;
    }

    public void showAlertMessagesRegistration(){
        Assert.assertThat(getAlertMessagesRegistration(), IsEqual.equalTo(getAlertMessagesRegistration()));
    }

    private List<String> getAlertMessagesRegistration(){
        List<String> alertMessagesRegistration = new ArrayList<String>();

        for(WebElement messages : alertMessagesRegistrationElement){
            alertMessagesRegistration.add(messages.getText());
        }
        return alertMessagesRegistration;
    }




}
