package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suporte.Web;

import static org.junit.Assert.assertEquals;

public class RegistrarUsuario {
    private WebDriver navegador;


    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testeAdicionarTshirtAoCarrinho() {
        navegador.findElement(By.xpath("//*[@id='header']//a[contains(text(),'Sign in')]")).click();
        navegador.findElement(By.id("email_create")).sendKeys("teste@ghi5.com");
        navegador.findElement(By.id("SubmitCreate")).click();
        navegador.findElement(By.xpath("//input[@type='radio' and @name='id_gender' and @value='1']")).click();
        navegador.findElement(By.id("customer_firstname")).sendKeys("Joao");
        navegador.findElement(By.id("customer_lastname")).sendKeys("da Silva");
        navegador.findElement(By.name("passwd")).sendKeys("teste123");
        navegador.findElement(By.id("firstname")).sendKeys("teste nome");
        navegador.findElement(By.id("lastname")).sendKeys("teste sobrenome");
        navegador.findElement(By.id("address1")).sendKeys("rua aguacu, 171");
        navegador.findElement(By.name("city")).sendKeys("Campinas");
        navegador.findElement(By.id("uniform-id_state")).click();
        navegador.findElement(By.id("id_state")).findElement(By.xpath("//option[contains(text(),'Alaska')]")).click();
        navegador.findElement(By.id("postcode")).sendKeys("11111");
        navegador.findElement(By.id("id_country")).click();
        navegador.findElement(By.xpath("//*[@id='id_country']//option[contains(text(),'United States')]")).click();
        navegador.findElement(By.name("phone_mobile")).sendKeys("19812333418");
        navegador.findElement(By.id("submitAccount")).click();

        WebElement Message = navegador.findElement(By.xpath("//*[@id='header']//a[@class='account']"));
        String usuarioLogado = Message.getText();
        System.out.println("Printing " + usuarioLogado);
        assertEquals("Joao da Silva", usuarioLogado);

        navegador.findElement(By.xpath("//*[@id='header']//span[contains(text(),'" + usuarioLogado + "')]")).isDisplayed();
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
