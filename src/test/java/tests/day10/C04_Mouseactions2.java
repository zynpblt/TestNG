package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Mouseactions2 extends TestBase {
    //Yeni bir class olusturalim: D14_MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    @Test
    public  void  test(){
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        WebElement dragElementi= driver.findElement(By.id("draggable"));
        WebElement dropAlani= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElementi,dropAlani).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualDroppedYazsi=droppedYazisi.getText();
        String expectedDroppedYazisi="Dropped!";

        Assert.assertEquals(actualDroppedYazsi,expectedDroppedYazisi,"dropped yazisi beklenenden farkli");
    }
}
