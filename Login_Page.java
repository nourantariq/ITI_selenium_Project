package ITI_selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Page {

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
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.name("username")).sendKeys("tomsmith");
            driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

            // Click the login button
            driver.findElement(By.className("radius")).click();

            // Actual result VS Excepted result
            String ExceptedResult="You logged into a secure area!";
            String ActualResult=driver.findElement(By.id("flash")).getText();
            //Assert.assertEquals(ActualResult.contains(ExceptedResult),true);
            Assert.assertTrue(ActualResult.contains(ExceptedResult));
        }
        @Test
        public void InvalidLogin() {
            // Enter username and password
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.name("username")).sendKeys("tomth");
            driver.findElement(By.name("password")).sendKeys("SuperSecrerd!");


            // Click the login button
            driver.findElement(By.className("radius")).click();
            String ActualResult = driver.findElement(By.id("flash")).getText();
            String ExpectedResult = "Your username is invalid!";
            Assert.assertTrue(ActualResult.contains(ExpectedResult));
        }

    }


