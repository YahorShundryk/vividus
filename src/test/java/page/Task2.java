package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
    private WebDriver driver;
    private static final String PageURL = "https://pastebin.com/";

    public Task2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Task2 openPage() {
        driver.get(PageURL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public Task2 Note(String textLocator, String code1, String code2, String code3, String pasteHighlightingLocator,
                      String searchFieldLocator, String key, String postformLocator, String title, String submitLocator) {
        driver.manage().window().maximize();
        WebElement pasteField = driver.findElement(By.id(textLocator));
        pasteField.sendKeys(code1);
        pasteField.sendKeys(code2);
        pasteField.sendKeys(code3);
        WebElement pasteHighlighting = driver.findElement(By.xpath(pasteHighlightingLocator));
        pasteHighlighting.click();
        WebElement searchField = driver.findElement(By.className(searchFieldLocator));
        searchField.sendKeys(key);
        searchField.sendKeys(Keys.ENTER);
        WebElement pasteName = driver.findElement(By.id(postformLocator));
        pasteName.sendKeys(title);
        WebElement submit = driver.findElement(By.xpath(submitLocator));
        submit.click();
        return this;
    }
}
