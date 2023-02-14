import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToApp extends BaseTest {

    // Positive testing
    @Test
    public void loginTest_loginWithCorrectCredentials_mainPageOpened(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApp(username, password);
        Assert.assertTrue(mainPage.isMainPage());
    }

    // Negative testing
    @Test
    public void loginTest_loginWithIncorrectCredentials_errorFrame(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginToApp(username,"wrongPassword");
        Assert.assertTrue(loginPage.isErrorFrame());
    }
}