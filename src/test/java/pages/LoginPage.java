package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id = "user-name")
    WebElement usernameField;

    @FindBy (id= "password")
    WebElement passwordField;

    @FindBy (id = "login-button")
    WebElement loginButton;

    @FindBy (xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
    WebElement errorMessage;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }

    public void assertingErrorMessage(){
        Assert.assertTrue(errorMessage.getText().contains("Username and password do not match any user in this service"));
    }
}
