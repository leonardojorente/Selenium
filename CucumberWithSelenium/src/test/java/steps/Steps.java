package steps;

import Base.BaseUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Steps extends BaseUtils {
    private BaseUtils baseUtil;

    public Steps(BaseUtils util){
    this.baseUtil = util;
    }

    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("a user is in the main page")
    public void a_user_is_in_the_main_page() {


        driver.get("https://www.americanas.com.br/");
        baseUtil.productName = "Luva";
    }

    @When("he search for a product {string}")
    public void he_search_for_product(String product) {

        baseUtil.productName = product;
        driver.findElement(By.id("h_search-input")).sendKeys(product);
        driver.findElement(By.id("h_search-btn")).click();
    }

    @When("he search for a product data table")
    public void he_search_for_product(DataTable table) {

        List<String> product = table.asList();

        driver.findElement(By.id("h_search-input")).sendKeys(product.get(0));
        driver.findElement(By.id("h_search-btn")).click();
    }

    @And("add the product to the cart")
    public void add_the_product_to_the_cart() {
        driver.findElement(By.xpath("//div[@data-tracker='searchquery-main']//h1[contains(text(),"+baseUtil.productName+")]")).isDisplayed();
        int rowCount = driver.findElements(By.xpath("//div[@class='row product-grid no-gutters main-grid']//h2[contains(text(),"+baseUtil.productName+")]")).size();
        System.out.println(rowCount);
        driver.findElement(By.xpath("//div[@class='row product-grid no-gutters main-grid']//h2[contains(text(),'Luva De Látex Para Procedimento Supermax Com 100')]")).click();
        driver.findElement(By.id("btn-buy")).click();

    }

    @Then("the product appears correctly in the cart")
    public void the_product_appears_correctly_in_the_cart() {
        driver.findElement(By.xpath("//div[@class='basket-productInfo__wrapper']//a[contains(text(),'Luva De Látex Para Procedimento Supermax Com 100')]")).isDisplayed();

    }

    @After
    public void quitBrowser(){
        driver.quit();
    }
}
