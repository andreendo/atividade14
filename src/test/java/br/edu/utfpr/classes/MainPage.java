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
public class MainPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[3]/ul/li[9]")
    WebElement email;
    WebElement error_msg;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public String getEmail() {
        return email.getText();
    }
    public String getErro(){
        return error_msg.getText();
    }


}
