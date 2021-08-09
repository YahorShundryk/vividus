package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class Task4 {
    private WebElement webElement;
    private WebDriver driver;
    private String locatorEmailEstimate = "//*[@id=\"email_quote\"]";
    private String locatorSendEmail = "/html/body/div[9]/md-dialog/form/md-dialog-actions/button[2]";
    private String locatorEmail = "//*[@id='input_418']";
    private String pageURL = "https://10minutemail.com/";
    private String locatorCoppyEmail = "//*[@id=\"mail_address\"]";
    private String locatorOpenEmail =  "//*[@id='mail_messages_content']/div/div[1]/div[3]/span";

    public Task4(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Task4 sendEmail() {
        (new Task3(driver)).getFrame(driver, webElement);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(locatorEmailEstimate)));
        webElement = driver.findElement(By.xpath(locatorEmailEstimate));
        webElement.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(locatorSendEmail)));
        webElement = driver.findElement(By.xpath(locatorEmail));
        webElement.sendKeys(Keys.LEFT_CONTROL,"v");
        webElement = driver.findElement(By.xpath(locatorSendEmail));
        webElement.click();
        return this;
    }

    public Task4 getEmailAdress() throws InterruptedException {
        driver.get(pageURL);
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"page-footer\"]/div/div[7]/p[2]/a")));
        Thread.sleep(1000);
        webElement = driver.findElement(By.xpath(locatorCoppyEmail));
        new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.sendKeys(Keys.LEFT_CONTROL,"x");
        return this;
    }

    public Task4 checkEmail() {
        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(locatorOpenEmail)));
        webElement = driver.findElement(By.xpath(locatorOpenEmail));
        webElement.click();

        return this;
    }
}
