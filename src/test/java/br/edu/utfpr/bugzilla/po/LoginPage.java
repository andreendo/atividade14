package br.edu.utfpr.bugzilla.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

/**
 *
 * @author fabriciojso
 */
public class LoginPage extends BasePage{
    
    @FindBy(id = "login_link_top")
    private WebElement buttonLogin;
    
    @FindBy(id = "Bugzilla_login_top")
    private WebElement login;
    
    @FindBy(id = "Bugzilla_password_top")
    private WebElement password;  
    
    @FindBy(id = "log_in_top")
    private WebElement buttonSubmit;
    
    @FindBy(id = "error_msg")
    private WebElement errorMensage;

    
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/index.cgi");
    }

    public LoginPage clickButtonLogin() {
        this.buttonLogin.click();
        return this;
    }

    public WebElement getLogin() {
        return login;
    }

    public LoginPage setLogin(String login) {
        this.login.sendKeys(login);
        return this;
    }

    public WebElement getPassword() {
        return password;
    }

    public LoginPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public WebElement getButtonSubmit() {
        return buttonSubmit;
    }

   
    public MainPage addValid(){
        this.getButtonSubmit().click();
        
        return new MainPage(driver);
    }

    public LoginPage addInvalid() {
        this.getButtonSubmit().click();
        return this;
    }

    public WebElement getErrorMensage() {
        return errorMensage;
    }
    
    
    
    
}
