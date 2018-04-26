// Nome: Roberto Guimarães Junior
// Nome: Tiago Pereira


package br.edu.utfpr.classesPO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage{
    
    
    // elementos da pagina
     private WebElement login_link_top;
     private WebElement Bugzilla_login_top;
     private WebElement Bugzilla_password_top;
     private WebElement log_in_top;
     private WebElement error_msg;
     
    // botão de login 
    public LoginPage(WebDriver driver) {
        super(driver);
        login_link_top.click();
    }
     
     // campo de login
     public LoginPage InserirLogin(String login) {
         Bugzilla_login_top.sendKeys(login);
         return this;
     }
     
     // campo de senha
     public LoginPage inserirSenha(String senha) {
         Bugzilla_password_top.sendKeys(senha);
         return this;
     }
     
     public MainPage adicionarValido () {
         log_in_top.click();
         return new MainPage(driver);
     }
     
     // metodo que insere o usuario
     public LoginPage adicionarInvalido() {
         return this;
     }
     
     // metodo que retorna erro de cadastro
     public String getErrorText() {
         return error_msg.getText();
     }
     
}
    
