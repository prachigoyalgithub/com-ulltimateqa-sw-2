package testsuite;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Navigate to the base URL
        driver.get("https://courses.ultimateqa.com/");

        // Click on the 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Verify the text 'Welcome Back!'
        WebElement welcomeText = driver.findElement(By.xpath("//div[contains(text(), 'Welcome Back!')]"));
        assertTrue("Welcome Back! text is not displayed", welcomeText.isDisplayed());
    }


    @Test
    public void verifyTheErrorMessage() {
        // Navigate to the base URL
        driver.get("https://courses.ultimateqa.com/");

        // Click on the 'Sign In' link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Enter invalid username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("invalidUsername");

        // Enter invalid password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("invalidPassword");

        // Click on the Login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify the error message 'Invalid email or password.'
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Invalid email or password.')]"));
        assertTrue("Error message is not displayed", errorMessage.isDisplayed());
    }


}