package StepDefs;

import Step.EachStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class MyStepdefs {
    public WebDriver driver=null;
    EachStep each = new EachStep();
    @Given("^I launch \"([^\"]*)\" Browser$")
    public void iLaunchBrowser(String browser) {
        // Write code here that turns the phrase above into concrete actions
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }else  if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }


    }

    @Given("^url link \"([^\"]*)\" in \"([^\"]*)\"$")
    public void urlLinkIn(String url, String browser) {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("opening " +url+" in "+browser);

    }



    @When("^I enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void siEnterUsernameAsAndPasswordAs(String username, String password) throws InterruptedException {
        each.login(driver,username,password);
    }

    @And("I log out")
    public void iLogOut() throws InterruptedException {
    each.logout(driver);
    }

    @And("goto cart for checkout")
    public void gotoCartForCheckout() throws InterruptedException {
        each.addCart(driver);
    }

    @And("I fill the {string} and {string} and {string}")
    public void iFillTheAndAnd(String Fname, String Lanme, String Zcode) throws InterruptedException {
        each.addressValidation(driver,Fname,Lanme,Zcode);
    }

    @Then("I validate Checkout")
    public void iValidateCheckout() throws InterruptedException {
        each.assertification(driver);

    }


}
