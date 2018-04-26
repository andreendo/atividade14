package br.edu.utfpr.bugzilla;

import br.edu.utfpr.bugzilla.po.LoginPage;
import br.edu.utfpr.bugzilla.po.MainPage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author renil
 */
public class Bugzila {

    private static String CHROMEDRIVER_LOCATION = "/Users/fabriciojso/utfpr/topicos-avancados-em-teste/jars/chromedriver";

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void loginValido() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.clickButtonLogin()
                 .setLogin("fabricio.jhonata@gmail.com")
                 .setPassword("123senhaab")
                 .addValid();
        
        assertTrue(mainPage.getFormUserPreferences().getText().contains("fabricio.jhonata@gmail.com"));
        
    }
    
    @Test
    public void loginInvalido() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage = loginPage.clickButtonLogin()
                 .setLogin("fabricio.jhonata@gmail.com")
                 .setPassword("123senhaab2")
                 .addInvalid();
        assertEquals("The login or password you entered is not valid.", loginPage.getErrorMensage().getText().trim());
    }
    
}
