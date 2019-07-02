package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.Web;

import static org.junit.Assert.assertEquals;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesPageObjectsCSV.csv")

public class InformacoesPageObjectsCSV {
    private WebDriver navegador;

    @Before
    public void setUp() {
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(
            @Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagemEsperada){//feito para passar os valores do arquivo csv da pasta resources


        String textoToast = new LoginPage(navegador)
                .clickSignIn()// quando uso esse comando ele já retorna o objeto da pagina LoginFormPage, então já sabe que estou lá
                .typeLogin(login) //login não passei hardcoded, passei um parametro do arquivo csv
                .typePassword(senha) //senha não passei hardcoded, passei um parametro do arquivo csv
                .clickSignIn()
                //.fazerLogin("julio0001", "123456") // opção de método funcional
                .clickMe()
                .clickTabMoreDataAboutYou()
                .clickButtomMoreDataAboutYou()
                //.AddContact("Phone", "+5519993444")
                .selectTypeOfContact(tipo)
                .typeContact(contato)
                .clickSave()
                .capturarTestoToast();

        assertEquals(mensagemEsperada, textoToast);

    }

    @After
    public void tearDown(){
        //navegador.quit();
    }
}
