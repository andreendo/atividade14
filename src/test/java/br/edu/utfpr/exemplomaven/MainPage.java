/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemplomaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Aluno
 */
public class MainPage extends BasePage{
    
    //User Valido
    @FindBy(xpath = "//*[@id=\"common_links\"]/ul/li[9]/a")
    WebElement logout;
    
    //User Invalido
    WebElement error_msg;
    
    public boolean isCorrectPage(){
        if (error_msg.isDisplayed())
                return false;
        
        return true;
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    
}
