/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemplomaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Aluno
 */
public class LoginPage extends BasePage{
    
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/");
    }
    
    WebElement Bugzilla_login_top; //Email
    WebElement Bugzilla_password_top; //Senha
    WebElement log_in_top; //Botao LogIn
    
    //Botao Login
    public void clicarLogin(){
        log_in_top.click();  
    }
    
    
}
