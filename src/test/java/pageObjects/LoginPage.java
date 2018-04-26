/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageObjects;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author kbig
 */
public class LoginPage extends BasePage{
     private WebElement login_link_top;
     private WebElement Bugzilla_login_top;
     private WebElement Bugzilla_password_top;
     private WebElement log_in_top;
     private WebElement error_msg;
     
    public LoginPage(WebDriver driver) {
        super(driver);
        login_link_top.click();
    }
     
     
     public LoginPage setLogin(String login) {
         Bugzilla_login_top.sendKeys(login);
         return this;
     }
     
     public LoginPage setPassword(String password) {
         Bugzilla_password_top.sendKeys(password);
         return this;
     }
     
     public MainPage addValid () {
         log_in_top.click();
         return new MainPage(driver);
     }
     
     public LoginPage addInvalid() {
         return this;
     }
     
     public String getErrorText() {
         return error_msg.getText().trim();
     }
     
}
