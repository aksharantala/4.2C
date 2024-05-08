package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    WebDriver driver;

    @Before
    public void setUp() {
        // Set up the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Akshar Antala\\Desktop\\Jar\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    private void performLogin(String username, String password) {
        // Navigate to the login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter username and password
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Wait for the error message to appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Sign in']")));
    }

    @Test
    public void testValidLogin() {
        // Navigate to the login page
        driver.get("https://www.bunnings.com.au/login");

        // Enter valid username and password
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("antalaakshar@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("@kshar123BW");

        // Click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the user to be logged in successfully
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.bunnings.com.au/my-account"));

        // Assert that the user is logged in successfully
        Assert.assertEquals("https://www.bunnings.com.au/my-account", driver.getCurrentUrl());

        System.out.println("Test valid login: " + (driver.getCurrentUrl().equals("https://www.bunnings.com.au/my-account") ? "Passed" : "Failed"));
    }

    @Test
    public void testInvalidUsername() {
        performLogin("akshar", "@kshar123BW");

        // Assert that the login failed
        Assert.assertEquals("https://www.bunnings.com.au/my-account", driver.getCurrentUrl());

        System.out.println("Test invalid username: " + (driver.getCurrentUrl().equals("https://www.bunnings.com.au/login") ? "Passed" : "Failed"));
    }

    @Test
    public void testInvalidPassword() {
        performLogin("antalaakshar@gmail.com", "1234");

        // Assert that the login failed
        Assert.assertEquals("https://www.bunnings.com.au/my-account", driver.getCurrentUrl());

        System.out.println("Test invalid password: " + (driver.getCurrentUrl().equals("https://www.bunnings.com.au/login") ? "Passed" : "Failed"));
    }

    @Test
    public void testBlankCredentials() {
        performLogin("", "");

        // Assert that the login failed
        Assert.assertEquals("https://www.bunnings.com.au/my-account", driver.getCurrentUrl());

        System.out.println("Test blank credentials: " + (driver.getCurrentUrl().equals("https://www.bunnings.com.au/login") ? "Passed" : "Failed"));
    }

    @After
    public void tearDown() {
        // Quit the WebDriver
        driver.quit();
    }
}
