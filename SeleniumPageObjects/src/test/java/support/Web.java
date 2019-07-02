package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME ="juliocesardelima1";// valor para rodar os testes na nuvem --site browserStack
    public static final String AUTOMATED_KEY ="kakfu343"; // esses valores são gerados pelo próprio site stackbrowser quando cadastra
    public static final String URL ="https://"+ USERNAME+":" + AUTOMATED_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DriversSelenium\\chromedriver.exe");

        //Abrindo o navegador
        WebDriver navegador = new ChromeDriver(); //Cria uma instância/objeto do tipo webdriver
        navegador.manage().window().maximize(); //maximiza a janela do navegador
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// Na validação final é necessário um wait, este implicity wait resolveu, note que ele fica no começo do codigo e funciona como wait para todos os elementos
        //Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    public static WebDriver createBrowserStack(){// conexao pelo site browserstack-nuvem e nao pelo navegador local
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser","IL");
        caps.setCapability("browser_version","7.0");
        caps.setCapability("os","Windows");
        caps.setCapability("os_version","XP");
        caps.setCapability("browserstack.degub","true");

        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // navegando para a página taskit!
            navegador.get("http://www.juliodelima.com.br/taskit");
        }catch(MalformedURLException e){
            System.out.println("Houveram problemas com a URL:"+e.getMessage());
        }

        return navegador;
    }
}