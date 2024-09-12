package ITI_selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenBrowser {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        // Set the path to the chromedriver executable
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        // Initialize the WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the login page
        driver.get("https://the-internet.herokuapp.com/login");
        // Wait for the page to load
        Thread.sleep(3000);
    }

    @Test
    public void validLogin() {
        // Enter username and password
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        // Click the login button
        driver.findElement(By.className("radius")).click();

    }

}