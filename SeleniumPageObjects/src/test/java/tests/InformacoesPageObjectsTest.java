package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Generator;
import support.Screenshot;
import support.Web;
import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)

public class InformacoesPageObjectsTest {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();//serve para pegar o nome da classe atual

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
            String textoToast = new LoginPage(navegador)
                .clickSignIn()// quando uso esse comando ele já retorna o objeto da pagina LoginFormPage, então já sabe que estou lá
                .typeLogin("julio0001") //login não passei hardcoded, passei um parametro do arquivo csv
                .typePassword("123456") //senha não passei hardcoded, passei um parametro do arquivo csv
                .clickSignIn()
    //.fazerLogin("julio0001", "123456") // opção de método funcional
                .clickMe()
                .clickTabMoreDataAboutYou()
                .clickButtomMoreDataAboutYou()
    //.AddContact("Phone", "+5519993444")
                .selectTypeOfContact("E-mail")
                .typeContact("email@001@julio.com")
                .clickSave()
                .capturarTestoToast();

    assertEquals("Your contact has been added!", textoToast);
    Screenshot.take(navegador, "C:\\Users\\leona\\test-reports\\"+ Generator.dataHoraParaArquivo()+test.getMethodName()+".png");
    }

    @After
    public void tearDown(){
        //navegador.quit();
    }

}
