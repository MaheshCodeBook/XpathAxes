import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FeaturesPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://qafeaturesect.ccbp.tech/");

            WebElement spanEle =  driver.findElement(By.xpath("//span[@class='interaction']"));
            System.out.println(spanEle.getText());

            WebElement pEle =  driver.findElement(By.xpath("//span[@class='interaction']/parent::p"));
            System.out.println(pEle.getText());

            List<WebElement> followingDescription = driver.findElements(By.xpath("//h1[text() = 'Interaction']/ancestor::div[2]/following-sibling::div//p"));
            for(WebElement i : followingDescription){
                System.out.println(i.getText());
            }

            List<WebElement> precedingDescription = driver.findElements(By.xpath("//h1[text() = 'Interaction']/ancestor::div[2]/preceding-sibling::div//p"));
            for(WebElement i : precedingDescription){
                System.out.println(i.getText());
            }





            Thread.sleep(4000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
