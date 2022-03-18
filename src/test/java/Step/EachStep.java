package Step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EachStep {
    String Id="id";
    String Xpath ="xpath";

    MySteps step = new MySteps();
    public void login(WebDriver driver,String username, String password) throws InterruptedException {
        locator(Id, driver, step.userName);
        sendKey(Id,driver,step.userName,username);
        step.waitElememt(driver);

        sendKey(Id,driver,step.passWord,password);
       step.waitElememt(driver);

        clickCall(Id,driver,step.login);

        step.waitElememt(driver);
    }

    public void addCart(WebDriver driver) throws InterruptedException {
       // locator("xpath", driver, step.producet1);
        step.waitElememt(driver);
        clickCall(Xpath,driver,step.producet1);

        step.waitElememt(driver);

        clickCall(Xpath,driver,step.producet2);
       step.waitElememt(driver);
        clickCall(Xpath,driver,step.producet3);

        step.waitElememt(driver);

        clickCall(Xpath,driver,step.producet4);

        step.waitElememt(driver);

        clickCall(Xpath,driver,step.cart);

        step.waitElememt(driver);

        clickCall(Id,driver,step.chekout);

    }

    public void addressValidation(WebDriver driver, String Fname,String Lname, String Zcode) throws InterruptedException {
      //  locator("id", driver, step.fName);
        sendKey(Id,driver,step.fName,Fname);

        step.waitElememt(driver);
        //locator("id", driver, step.lName);
        sendKey(Id,driver,step.lName,Lname);

        step.waitElememt(driver);

        sendKey(Id,driver,step.zcode,Zcode);

        step.waitElememt(driver);
       // locator("id", driver, step.next);
        clickCall(Id,driver,step.next);

        //locator("id", driver, step.done);
        step.waitElememt(driver);;
        clickCall(Id, driver,step.done);
       // driver.findElement(By.id(step.done)).click();
    }

    public void assertification(WebDriver driver) throws InterruptedException {
        String exp ="THANK YOU FOR YOUR ORDER" ;
        String actula = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(exp, actula);
        step.waitElememt(driver);
    }


    public void logout(WebDriver driver) throws InterruptedException {
        step.waitElememt(driver);
        driver.quit();
    }

    public void locator(String type, WebDriver driver, String path){
        if(type.equalsIgnoreCase("id")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
        }if(type.equalsIgnoreCase("xpath")){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));

        }
    }

    public void sendKey( String ID,WebDriver driver, String path, String data){
        if(ID.equalsIgnoreCase(Id)){
            driver.findElement(By.id(path)).sendKeys(data);
        }
        if(ID.equalsIgnoreCase(Xpath)){
            driver.findElement(By.xpath(path)).sendKeys(data);
        }

    }
    public void clickCall( String ID, WebDriver driver, String path){
        if(ID.equalsIgnoreCase(Id)){
            driver.findElement(By.id(path)).click();
        }
        if(ID.equalsIgnoreCase(Xpath)){
            driver.findElement(By.xpath(path)).click();
        }

    }
}
