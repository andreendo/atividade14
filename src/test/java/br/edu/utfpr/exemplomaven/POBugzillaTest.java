/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exemplomaven;
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
import pageObjects.LoginPage;
import pageObjects.MainPage;
/**
 *
 * @author kbig
 */
public class POBugzillaTest {
    
    private static String CHROMEDRIVER_LOCATION = "/home/kbig/Downloads/chromedriver_236_linux64/chromedriver";

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //Opcao headless para MacOS e Linux
//        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/");
    }

    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void testPOLoginValid() {
        LoginPage lp = new LoginPage(driver);
        MainPage mp = lp.setLogin("rafaelnsantos1@gmail.com")
                .setPassword("abcd1234")
                .addValid();
        assertEquals("| Log out rafaelnsantos1@gmail.com", mp.getEmailLogged());
    }
    
    @Test
    public void testPOLoginInvalid() {
        LoginPage lp = new LoginPage(driver);
        lp.setLogin("asdfarafaelnasantos1@gmail.com")
                .setPassword("abcd1234")
                .addValid();
        assertEquals("The login or password you entered is not valid.", lp.getErrorText());
    }
    
}
