package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver navegador){ //construtor da classe
        super(navegador);
    }

    public LoginFormPage typeLogin(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this; //Esse retorno é porque ele continua na mesma página
    }

    public LoginFormPage typePassword(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this; //Esse retorno é porque ele continua na mesma página
    }

    public SecretPage clickSignIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();

        return new SecretPage(navegador);
    }

    public SecretPage fazerLogin(String login, String senha){
        typeLogin(login);
        typePassword(senha);
        clickSignIn();

        return new SecretPage(navegador);
    }
}
