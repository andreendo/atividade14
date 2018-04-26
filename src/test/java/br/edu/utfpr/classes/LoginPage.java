/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andre
 */
public class LoginPage extends BasePage{

    WebElement Bugzilla_login;
    WebElement Bugzilla_password;
    WebElement login_link_top;

    @FindBy(id = "log_in_top")
    WebElement loginButton;

    public LoginPage(WebDriver drive) {
        super(drive);
        login_link_top.click();
    }
    
    public LoginPage setLogin(String login) {
        Bugzilla_login.clear();
        Bugzilla_login.sendKeys(login);
        return this;
    }
    
    public LoginPage setPassword(String senha) {
        Bugzilla_password.clear();
        Bugzilla_password.sendKeys(senha);
        return this;
    }
    public MainPage addValid() {
        loginButton.click();
        return new MainPage(driver);
    }
    public LoginPage addInvalid() {
         return this;
    }
    
}
