import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CapitalsAppTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://qacapitalsapp.ccbp.tech/");

            // Find all the options of the dropdown Element
            List<WebElement> optionsLIST = driver.findElements(By.xpath("//select[@class='capital-select']/child::option"));
            ArrayList<String> optionTextList = new ArrayList<String>();

            // Get the text for each option of the dropdown Element
            for (WebElement i : optionsLIST){
                String text = i.getText();
                optionTextList.add(text);
            }
            String[] expectedARRAY = {"New Delhi","London","Paris","Kathmandu","Helsinki"};
            int i;
            for (i=0; i<5; i++){
                if (!expectedARRAY[i].equals(optionTextList.get(i))){
                    System.out.println("Mismatch Found");
                    break;
                }
            }
            if (i == 5){
                System.out.println("All options are as expected");
            }

            Thread.sleep(4000);
            driver.quit();
        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
