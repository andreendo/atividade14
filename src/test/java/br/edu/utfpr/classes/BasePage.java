
package br.edu.utfpr.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author andre
 */
public class BasePage {
    
    protected WebDriver driver;
    
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
