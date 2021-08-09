package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Task1;
import page.Task2;
import page.Task3;
import page.Task4;

import java.util.ArrayList;

public class Tests {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new FirefoxDriver();
    }

    @Test(enabled=true, description = "Task 1 'I Can Win'")
    public void Task1() {
        String textLocator= "postform-text";
        String code ="Hello from WebDriver";
        String postformLocator ="postform-name";
        String title ="helloweb";
        String submitLocator="//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button";

        Task1 task= new Task1(driver);
        task.openPage();
        task.Note(code,textLocator,postformLocator,title,submitLocator);
    }

    @Test(enabled=true, description = "Task 2 'Bring It On'")
    public void Task2() {
        String textLocator= "postform-text";
        String code1="git config --global user.name  \"New Sheriff in Town\"\n";
        String code2="git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n";
        String code3 ="git push origin master --force";
        String pasteHighlightingLocator ="//*[@id=\"select2-postform-format-container\"]";
        String searchFieldLocator = "select2-search__field";
        String key = "Bash";
        String postformLocator ="postform-name";
        String title ="how to gain dominance among developers";
        String submitLocator="//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button";

        Task2 task= new Task2(driver);
        task.openPage();
        task.Note(textLocator,code1,code2,code3,pasteHighlightingLocator,searchFieldLocator,key,postformLocator,title,submitLocator);

        boolean text = driver.getPageSource().contains("how to gain dominance among developers");
        System.out.println(text);
        String colorText = driver.findElement(By.className("kw2")).getCssValue("color");
        System.out.println("Text color:"+colorText);
        boolean text1 = driver.getPageSource().contains("git config --global user.name  \"New Sheriff in Town\"\n");
        System.out.println(text1);
        boolean text2 = driver.getPageSource().contains("git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n");
        System.out.println(text2);
        boolean text3 = driver.getPageSource().contains("git push origin master --force");
        System.out.println(text3);
    }

    @Test(enabled=true, description = "Task 3 'Hurt Me Plenty'")
    public void Task3() {
        Task3 task = new Task3(driver);
        task.openPage();
        task.search();
        task.form();
        boolean instanceType = driver.getPageSource().contains("n1-node-96-624");
        System.out.println(instanceType);
        boolean region = driver.getPageSource().contains("Iowa");
        System.out.println(region);
        boolean localSSD = driver.getPageSource().contains("24x375");
        System.out.println(localSSD);
        boolean price = driver.getPageSource().contains("8,182.65");
        System.out.println(price);
    }

    @Test(enabled=true, description = "Task 4 'Hardcore'")
    public void Task4() throws InterruptedException {
        Task3 task = new Task3(driver);
        task.openPage();
        task.search();
        task.form();
        Task4 task4=new Task4(driver);

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        task4.getEmailAdress();
        driver.switchTo().window(tabs.get(0));
        task4.sendEmail();
        driver.switchTo().window(tabs.get(1));
        task4.checkEmail();
        boolean price = driver.getPageSource().contains("8,182.65");
        System.out.println(price);
    }

    @AfterMethod(enabled=true,alwaysRun = true)
    public void browseTearnDownr(){
        driver.quit();
        driver=null;
    }
}

