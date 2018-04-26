/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageObjects;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author kbig
 */
public class MainPage extends BasePage{
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public String getEmailLogged() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/ul/li[9]")).getText();
    }
    
}
