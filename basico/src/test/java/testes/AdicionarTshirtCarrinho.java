package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import suporte.Web;


public class AdicionarTshirtCarrinho {
    private WebDriver navegador;


    @Rule
    public TestName test = new TestName();// pega o nome da classe atual

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testeAdicionarTshirtAoCarrinho(){
        navegador.findElement(By.name("search_query")).click();
        navegador.findElement(By.name("search_query")).sendKeys("T-shirt");
        navegador.findElement(By.name("submit_search")).click();

        Actions action = new Actions(navegador);
        WebElement we = navegador.findElement(By.xpath("//*[@alt='Faded Short Sleeve T-shirts']"));
        System.out.println(we.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).getText());
        action.moveToElement(we).moveToElement(navegador.findElement(By.xpath("//span[contains(text(),'Add to cart')]"))).click().build().perform();

        WebElement checkButton =  navegador.findElement(By.xpath("//*[@id='layer_cart']//span[@class='cross']//following-sibling::h2//*[@class='icon-ok']"));
        checkButton.isDisplayed();

        Web.takeScreenShot(navegador, "C:\\Users\\l.jorente.CORP\\Desktop\\"+ Web.dataHoraParaArquivo()+test.getMethodName()+".png");
    }

    @After
    public void tearDown(){
        //navegador.quit();
    }
}
