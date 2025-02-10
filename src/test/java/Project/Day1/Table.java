package Project.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Table {
    WebDriver driver;

    @Test
    public void getDataColumnUsingFirstName() {
        driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> columnData = driver.findElements((By.xpath
                ("//td[@scope='row' and contains(text(),'Cierra')]/../td[not(a)]")));
        List<String> testDataTable = new ArrayList<>();

        for (int i = 0; i < columnData.size(); i++) {
            testDataTable.add(columnData.get(i).getText().trim());
        }
        System.out.println(testDataTable);
    }

     @Test
     public void sortingColumnUsingFirstName() {
         driver = new ChromeDriver();
         driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    List<WebElement> firstNameHeader = driver.findElements(By.xpath("//th[text()='First Name']/../../..//tbody/tr/td[1]"));
    List<String> firstNameData = new ArrayList<>();
        for(
    int i = 0;i<firstNameHeader.size();i++)

    {
        firstNameData.add(firstNameHeader.get(i).getText().trim());
    }
    // firstNameData.sort(null);
        Collections.sort(firstNameData);
        System.out.println(firstNameData);
    //remove duplicate names from list of first name
    Set<String> removeDuplicateNames = new HashSet<>(firstNameData);
        System.out.println(removeDuplicateNames);
}

}
