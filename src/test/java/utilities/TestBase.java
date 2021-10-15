package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //abstract yaparak bu classtan obje olusturulmasinin onune geceriz
   protected   WebDriver driver;
   //biz test base class'i sadece extends ile inherit ederek kullanacagiz
    //dolayisiyla olusturdugumuz driver variabla'i icin protected acsess modifier;i seciyoruz
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }




    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
