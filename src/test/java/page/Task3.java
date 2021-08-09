package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task3 {
    private WebElement webElement;
    private String pageURL="https://cloud.google.com/";
    private WebDriver driver;
    private String locatorSearchField="//devsite-search/form/div[1]/div/input";
    private String textSearch="Google Cloud Platform Pricing Calculator";
    private String locatorSearchResult="//b[text()='Google Cloud Platform Pricing Calculator']";
    private String locatorComputerEngine="*//md-tab-item[1]/div[1]/div/div[1]/div/div";
    private String locatorNumberOfInstance="//*[@id=\"input_63\"]";
    private String locatorOS="//*[@id='select_value_label_56']";
    private String locatorDebianOS="//*[@id='select_option_65']/div[1]";
    private String locatorVMClass="//*[@id=\"select_value_label_57\"]/span[1]/div";
    private String locatorClassRegular="//*[@id=\"select_option_78\"]/div[1]";
    private String locatorIntanceType="//*[@id=\"select_114\"]";
    private String locatorChosenType="//*[@id=\"select_option_107\"]/div[1]";
    private String locatorGPUsCheckbox="//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[2]/form/div[4]/div[1]/md-input-container/md-checkbox";
    private String locatorNumberOfGPU ="//*[@id=\"select_value_label_352\"]/span[1]";
    private String locatorNumberOfGPUChosen ="//*[@id=\"select_option_361\"]";
    private String locatorGPUType ="//*[@id=\"select_value_label_353\"]/span[1]/div";
    private String locatorGPUTypeChosen ="//*[@id=\"select_option_364\"]/div[1]";
    private String locatorLocalSSD ="//*[@id=\"select_value_label_102\"]/span[2]";
    private String locatorLocalSSDChosen ="//*[@id=\"select_option_117\"]/div[1]";
    private String locatorDatacenterLocation ="//*[@id=\"select_value_label_103\"]/span[1]/div";
    private String locatorDatacenterLocationChosen ="//*[@id=\"select_option_248\"]/div[1]";
    private String locatorCommitedUsage ="//*[@id=\"select_value_label_104\"]/span[1]";
    private String locatorCommitedUsageChosen ="//*[@id=\"select_option_123\"]/div[1]";
    private String locatorNumberOfNodes  ="//*[@id=\"input_105\"]";
    private String locatorBTN ="//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[2]/form/div[11]/button";

    public Task3 (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Task3 openPage() {
        driver.get(pageURL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.id("accelerate-your-transformation-with-google-cloud")));
        driver.manage().window().maximize();
        return this;
    }
    public Task3 search() {
       webElement = driver.findElement(By.xpath(locatorSearchField));
       webElement.sendKeys(textSearch);
       webElement.sendKeys(Keys.ENTER);
       new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorSearchResult)));
       webElement = driver.findElement(By.xpath(locatorSearchResult));
       webElement.click();
       return this;
    }

    public Task3 form () {
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        getFrame(driver,webElement);

        new WebDriverWait(driver, 1000).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(locatorIntanceType)));

        webElement = driver.findElement(By.xpath(locatorComputerEngine));
        webElement.click();
        webElement = driver.findElement(By.xpath(locatorNumberOfInstance));
        webElement.click();
        webElement.sendKeys("4");
        webElement = driver.findElement(By.xpath(locatorOS));
        webElement.click();
        webElement = driver.findElement(By.xpath(locatorDebianOS));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorVMClass));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorClassRegular));
        webElement.click();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(locatorGPUsCheckbox)));
        webElement=driver.findElement(By.xpath(locatorNumberOfNodes));
        webElement.sendKeys("1");
        webElement=driver.findElement(By.xpath(locatorIntanceType));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorChosenType));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorGPUsCheckbox));
        webElement.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[14]")));
        webElement=driver.findElement(By.xpath(locatorNumberOfGPU));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorNumberOfGPUChosen));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorGPUType));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorGPUTypeChosen));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorLocalSSD));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorLocalSSDChosen));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorDatacenterLocation));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorDatacenterLocationChosen));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorCommitedUsage));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorCommitedUsageChosen));
        webElement.click();
        webElement=driver.findElement(By.xpath(locatorBTN));
        webElement.click();
        return this;
    }

    public void getFrame(WebDriver driver1, WebElement webElement1){
        webElement1 = driver1.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver1.switchTo().frame(webElement1);
        webElement1 = driver1.findElement(By.xpath("//*[@id=\"myFrame\"]"));
        driver1.switchTo().frame(webElement1);
    }
}
