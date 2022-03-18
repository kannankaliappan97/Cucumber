package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MySteps {
    String userName="user-name";
    String passWord="password";
    String login="login-button";
    String producet1 ="//button[@id='add-to-cart-sauce-labs-backpack']";
    String producet2 ="//button[@id='add-to-cart-sauce-labs-bike-light']";
    String producet3 ="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
    String producet4 ="//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
    String cart ="//a[@class='shopping_cart_link']";
    String chekout="checkout";
    String fName="first-name";
    String next ="continue";
    String lName="last-name";
    String zcode="postal-code";
    String done="finish";
    private Object WebDriver;

    public void waitElememt(WebDriver driver) throws InterruptedException {

       Thread.sleep(3000);
    }


}
