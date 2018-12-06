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
                .submitDataRegistration()
                .successfullyRegistered();
    }

    @Test
    public void invalidEmailRegistration(){
        new Home()
                .openSignIn()
                .createAccountInvalidEmail()
                .emailRegistrationAlert();
    }
}
