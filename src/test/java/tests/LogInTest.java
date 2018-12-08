package tests;

import config.BrowserConfig;
import org.junit.Test;
import pages.Home;

public class LogInTest extends BrowserConfig {

    @Test
    public void emptyLogInSpaceFailed(){
        new Home()
                .openSignIn()
                .emptyLoginPasswordSpace();
    }

    @Test
    public void successfullyLogin(){
        new Home()
                .openSignIn()
                .validLoginPassword()
                .successfullyRegisteredLogIn();
    }

    @Test
    public void emptyPasswordSpaceFailed(){
        new Home()
                .openSignIn()
                .emptyPasswordSpace();
    }
}
