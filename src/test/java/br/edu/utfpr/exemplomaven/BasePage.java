package br.edu.utfpr.exemplomaven;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class BasePage {
    protected WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
