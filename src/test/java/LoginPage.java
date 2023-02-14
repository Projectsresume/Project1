import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private WebElement getEmailField(){
        By emailBy = By.xpath("//input[@class='form-input__area form-input__area--with-valid-icon phone-email-field-input--single phone-email-field-input']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailBy));
        return driver.findElement(emailBy);
    }
    private WebElement getPasswordField(){
        return driver.findElement(By.xpath("//*[@type='password']"));
    }
    private WebElement getLoginButton(){
        return driver.findElement(By.xpath("//button[@class='btn btn--size-medium btn--default login-form__submit']"));
    }
    private WebElement getErrorFrame(){
        By errorBy = By.xpath("//div[@class='input-error form-input__error-hint']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorBy));
        return driver.findElement(errorBy);
    }
    public MainPage loginToApp(String username, String password){
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);
    }
    public void open() {
        driver.get("https://humans.net/login");
    }
    public boolean isErrorFrame() {
        try {
            return getErrorFrame().isDisplayed();
        } catch (TimeoutException err){
            return false;
        }
    }
}