package tests;

import config.BrowserConfig;
import org.junit.Test;
import pages.Home;

public class RegistrationTest extends BrowserConfig {

    @Test
    public void successfullyRegistration(){
        new Home()
                .openSignIn()
                .createAccount()
                .submitValidDataRegistration()
                .successfullyRegisteredLogIn();
    }

    @Test
    public void invalidEmailRegistration(){
        new Home()
                .openSignIn()
                .createAccountInvalidEmail()
                .invalidEmailRegistration();
    }

    @Test
    public void failedRegistration(){
        new Home()
                .openSignIn()
                .createAccount()
                .submitInvalidDataRegistration()
                .showAlertMessagesRegistration();
    }
}
