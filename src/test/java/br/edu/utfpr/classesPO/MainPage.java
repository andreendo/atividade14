// Nome: Roberto Guimarães Junior
// Nome: Tiago Pereira

package br.edu.utfpr.classesPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String emailLogado() {

        if (!emailLogado().isEmpty()) {
            return driver.findElement(By.xpath("/html/body/div[1]/div[3]/ul/li[9]")).getText();
        } else if (emailLogado().length() < 1) {
            return "Pagina errada!!!";
        }
        return "Pagina errada!!!";
    }

}
