// Nome: Roberto Guimarães Junior
// Nome: Tiago Pereira

package br.edu.utfpr.classes;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
