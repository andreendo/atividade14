package br.edu.utfpr.bugzilla.po;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author fabriciojso
 */
public class MainPage extends BasePage{
    
    @FindBy(css = "form[name='userprefsform']")
    private WebElement formUserPreferences;
    
    @FindBy(css = "form[name='login']")
    private WebElement formUserLogin;
    
    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/userprefs.cgi?tab=email");
    }

    public WebElement getFormUserPreferences() {
        return formUserPreferences;
    }

    private WebElement getFormUserLogin() {
        return formUserLogin;
    }
    
    public boolean isCorrectPage(){
       try{
           this.getFormUserPreferences().getText();
           return true;
       }catch(Throwable eThrowable){
           return false;
       }
    }
   
}
