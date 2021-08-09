package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {
    private WebDriver driver;
    private static final String PageURL = "https://pastebin.com/";

    public Task1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Task1 openPage() {
        driver.get(PageURL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public Task1 Note(String code, String textLocator, String postformLocator, String title, String submitLocator) {

        WebElement pasteField = driver.findElement(By.id(textLocator));
        pasteField.sendKeys(code);
        WebElement pasteName = driver.findElement(By.id(postformLocator));
        pasteName.sendKeys(title);
        WebElement submit = driver.findElement(By.xpath(submitLocator));
        submit.click();
        return this;
    }
}
