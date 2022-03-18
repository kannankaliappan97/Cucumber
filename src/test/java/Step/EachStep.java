package Step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EachStep {
    MySteps step = new MySteps();
    public void login(WebDriver driver,String username, String password) throws InterruptedException {
        locator("id", driver, step.userName);
        driver.findElement(By.id(step.userName)).sendKeys(username);
        step.waitElememt(driver);
        //locator("id", driver, step.passWord);
        driver.findElement(By.id(step.passWord)).sendKeys(password);
       step.waitElememt(driver);
       // locator("id", driver, step.login);
        driver.findElement(By.id(step.login)).click();
        step.waitElememt(driver);
    }

    public void addCart(WebDriver driver) throws InterruptedException {
       // locator("xpath", driver, step.producet1);
        driver.findElement(By.xpath(step.producet1)).click();
        step.waitElememt(driver);
       // locator("xpath", driver, step.producet2);
        driver.findElement(By.xpath(step.producet2)).click();
       step.waitElememt(driver);
       // locator("xpath", driver, step.producet3);
        driver.findElement(By.xpath(step.producet3)).click();
        step.waitElememt(driver);
       // locator("xpath", driver, step.producet4);
        driver.findElement(By.xpath(step.producet4)).click();
        step.waitElememt(driver);
        //locator("xpath", driver, step.cart);
        driver.findElement(By.xpath(step.cart)).click();
        step.waitElememt(driver);
        //locator("id", driver, step.chekout);
        driver.findElement(By.id(step.chekout)).click();
    }

    public void addressValidation(WebDriver driver, String Fname,String Lname, String Zcode) throws InterruptedException {
      //  locator("id", driver, step.fName);
        driver.findElement(By.id(step.fName)).sendKeys(Fname);
        step.waitElememt(driver);
        //locator("id", driver, step.lName);
        driver.findElement(By.id(step.lName)).sendKeys(Lname);
        step.waitElememt(driver);
       // locator("id", driver, step.zcode);
        driver.findElement(By.id(step.zcode)).sendKeys(Zcode);
        step.waitElememt(driver);
       // locator("id", driver, step.next);
        driver.findElement(By.id(step.next)).click();
        //locator("id", driver, step.done);
        step.waitElememt(driver);;
        driver.findElement(By.id(step.done)).click();
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
}
