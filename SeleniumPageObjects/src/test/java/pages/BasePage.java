package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {//coisas associadas a todas as paginas, como um toast, que pode aparecer em qualquer uma
    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador = navegador;
    }
    public String capturarTestoToast(){// é acessavel por todas as outras, apenas utilizando o this
        WebElement toastMessage =  navegador.findElement(By.id("toast-container"));
        String MensagemToast = toastMessage.getText();

        return MensagemToast;
    }

}
