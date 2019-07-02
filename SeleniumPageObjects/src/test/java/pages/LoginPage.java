package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver navegador){ //construtor da classe
        super(navegador);
    }

    public LoginFormPage clickSignIn(){// O retorno é a página resultante do click feito, ou seja, o formulario de login
        navegador.findElement(By.linkText("Sign in")).click();

        return new LoginFormPage(navegador);
    }
}
