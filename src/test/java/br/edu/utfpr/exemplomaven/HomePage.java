/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemplomaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Aluno
 */
public class HomePage extends BasePage{
    
    public HomePage(WebDriver driver){
        super(driver);
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/");
    }
}
