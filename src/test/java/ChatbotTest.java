
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChatbotTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.get("https://qachatbot.ccbp.tech/");

            //finding inputFiled element
            WebElement inputFiled = driver.findElement(By.xpath("//input[@class=\"user-input\"]"));
            inputFiled.sendKeys("Hi");
            //findig sendButton Element
            WebElement sendButton = driver.findElement(By.xpath("//button[@class='send-msg-btn']"));
            sendButton.click();

            inputFiled.sendKeys("Good Morning");
            sendButton.click();

            inputFiled.sendKeys("Help!!!");
            sendButton.click();

            // Find all the message Elements
            List<WebElement> messages = driver.findElements(By.xpath("//div[@id='chatContainer']//descendant::span"));

            // print all the messages
            for (WebElement i : messages){
                System.out.println(i.getText());
            }

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
