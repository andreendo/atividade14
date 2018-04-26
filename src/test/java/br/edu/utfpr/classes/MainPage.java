// Nome: Roberto Guimarães Junior
// Nome: Tiago Pereira

package br.edu.utfpr.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    
    public MainPage(WebDriver driver){
        super(driver);
    }
    
    public String emailLogado() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/ul/li[9]")).getText();
    }
    
    
    
    
    

    

 
}
