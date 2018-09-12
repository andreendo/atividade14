package br.edu.utfpr.exemplomaven;

import io.github.bonigarcia.wdm.WebDriverManager;
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

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        
        chromeOptions.addArguments("headless");
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
    public void loginInvalido() {
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/");

        WebElement linkLogin = driver.findElement(By.id("login_link_top"));

        linkLogin.click();

        WebElement email = driver.findElement(By.id("Bugzilla_login_top"));

        email.sendKeys("asdsad@asdas.com");

        WebElement senha = driver.findElement(By.id("Bugzilla_password_top"));

        senha.sendKeys("asdsad");

        WebElement login = driver.findElement(By.id("log_in_top"));

        login.click();

        WebElement errorMsg = driver.findElement(By.id("error_msg"));
        assertEquals("The login or password you entered is not valid.", errorMsg.getText().trim());
    }

    @Test
    public void loginValido() {
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/");

        WebElement linkLogin = driver.findElement(By.id("login_link_top"));

        linkLogin.click();

        WebElement email = driver.findElement(By.id("Bugzilla_login_top"));

        email.sendKeys("rafaelnsantos1@gmail.com");

        WebElement senha = driver.findElement(By.id("Bugzilla_password_top"));

        senha.sendKeys("abcd1234");

        WebElement login = driver.findElement(By.id("log_in_top"));

        login.click();

        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/userprefs.cgi");

        WebElement user = driver.findElement(By.xpath("//*[@id=\"subtitle\"]"));
        assertEquals("rafaelnsantos1@gmail.com", user.getText().trim());
    }
    
    @Test
    public void newBug(){
        loginValido();
        
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/token.cgi");
        
        WebElement newBug = driver.findElement(By.xpath("//*[@id=\"common_links\"]/ul/li[2]/a"));
        newBug.click();
        
        WebElement definicao = driver.findElement(By.xpath("//*[@id=\"choose_classification\"]/tbody/tr[3]/th/a"));
        definicao.click();
        
        WebElement food = driver.findElement(By.xpath("//*[@id=\"choose_product\"]/tbody/tr[2]/th/a"));
        food.click();
        
        WebElement component = driver.findElement(By.xpath("//*[@id=\"v10_component\"]"));
        component.click();
        
        WebElement severitySel = driver.findElement(By.xpath("//*[@id=\"bug_severity\"]"));
        Select severity = new Select(severitySel);
        severity.selectByVisibleText("critical");
        
        
        WebElement hardwareSel = driver.findElement(By.xpath("//*[@id=\"rep_platform\"]"));
        Select hardware = new Select(hardwareSel);
        hardware.selectByVisibleText("HP");
        
        WebElement osSel = driver.findElement(By.xpath("//*[@id=\"op_sys\"]"));
        Select os = new Select(osSel);
        os.selectByVisibleText("Windows 95");
        
        WebElement sumary = driver.findElement(By.xpath("//*[@id=\"short_desc\"]"));
        sumary.sendKeys("Teste");
        
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"commit\"]"));
        submit.click();
        
        try{
            WebElement numBug = driver.findElement(By.xpath("//*[@id=\"changeform\"]/div[1]/a/b"));
            assertTrue(numBug.isDisplayed());
        } catch (Exception e){
            fail();
        }
        
    }
    
    
    @Test
    public void usuarioJaRegistrado() {
        driver.get("https://landfill.bugzilla.org/bugzilla-5.0-branch/createaccount.cgi");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"login\"]"));

        email.sendKeys("rafaelnsantos1@gmail.com");

        WebElement login = driver.findElement(By.id("send"));

        login.click();

        WebElement errorMsg = driver.findElement(By.id("error_msg"));

        assertEquals("There is already an account with the login name rafaelnsantos1@gmail.com.", errorMsg.getText().trim());

    }

    @Test
    public void newBugInvalido() {
        
        loginValido();

        WebElement newBug = driver.findElement(By.xpath("//*[@id=\"common_links\"]/ul/li[2]/a"));
        newBug.click();

        WebElement definicao = driver.findElement(By.xpath("//*[@id=\"choose_classification\"]/tbody/tr[3]/th/a"));
        definicao.click();

        WebElement food = driver.findElement(By.xpath("//*[@id=\"choose_product\"]/tbody/tr[2]/th/a"));
        food.click();

        WebElement component = driver.findElement(By.xpath("//*[@id=\"v10_component\"]"));
        component.click();

        WebElement severitySel = driver.findElement(By.xpath("//*[@id=\"bug_severity\"]"));
        Select severity = new Select(severitySel);
        severity.selectByVisibleText("critical");

        WebElement hardwareSel = driver.findElement(By.xpath("//*[@id=\"rep_platform\"]"));
        Select hardware = new Select(hardwareSel);
        hardware.selectByVisibleText("HP");

        WebElement osSel = driver.findElement(By.xpath("//*[@id=\"op_sys\"]"));
        Select os = new Select(osSel);
        os.selectByVisibleText("Windows 95");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"commit\"]"));
        submit.click();

        WebElement erroMsg = driver.findElement(By.xpath("//*[@id=\"Create\"]/table/tbody[5]/tr[1]/td/div"));
        assertEquals("You must enter a Summary for this bug.", erroMsg.getText());
    }
}
