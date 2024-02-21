import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BlogPageTest2 {
    public static void main(String[]args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://qabloglist.ccbp.tech/");

            List<WebElement> blogTitle = driver.findElements(By.xpath("//h1[text()='My fifth post']/preceding::h1[@class='blog-title']"));

            for (WebElement i : blogTitle){
                System.out.println(i.getText());
            }
            List<WebElement> linksLIST = driver.findElements(By.xpath("//a[text()='Home']/following::a"));
            WebElement firstLink = linksLIST.get(0);
            firstLink.click();

            String expectedURL = "https://qabloglist.ccbp.tech/about";
            String currentURL = driver.getCurrentUrl();
            if(expectedURL.equals(currentURL)){
                System.out.println("Navigation to About Page Successful");
            }

            WebElement secondLINK = linksLIST.get(1);
            secondLINK.click();
            expectedURL = "https://qabloglist.ccbp.tech/contact";
            currentURL = driver.getCurrentUrl();
            if (expectedURL.equals(currentURL)){
                System.out.println("Navigation to Contact Page Successful");
            }

            Thread.sleep(4000);
            driver.quit();
        }catch (Exception e ){
            System.out.println("The Exception isz: "+e);
        }
    }
}
