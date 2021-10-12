package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {
    //amazon sayfasina gidin
    //url in amazon icerdigini test edin
    //title in amazon icerdigini test edin
    //java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");
        // url'in amazon icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        // title'in amazon icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        System.out.println("Assertion failed oldugunda bu satir calismaz");
        // java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(ilkUrun.getText().contains("Java"));
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
