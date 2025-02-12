package Project.Day2.Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    @BeforeSuite
    public void initializeDrivers(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeTest
    public void launchApplication(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

}
