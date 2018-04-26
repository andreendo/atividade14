package br.edu.utfpr.exemplomaven;

import br.edu.utfpr.classes.LoginPage;
import br.edu.utfpr.classes.MainPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author renil
 */
public class Bugzila {

    private static String CHROMEDRIVER_LOCATION = "driver/chromedriver.exe";

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
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/");
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void loginValido() {
        LoginPage loginP = new LoginPage(driver);
        MainPage mainP = loginP.setLogin("papu_nilo@hotmail.com")
                .setPassword("123asd")
                .addValid();
        assertEquals("| Log out papu_nilo@hotmail.com", mainP.getEmail());
    }

    @Test
    public void loginInvalido() {
        LoginPage loginP = new LoginPage(driver);
        MainPage mainP = loginP.setLogin("testeinvalido@hotmail.com")
                .setPassword("123asd12314")
                .addValid();
        assertEquals("The login or password you entered is not valid.", mainP.getErro());
    }
}
