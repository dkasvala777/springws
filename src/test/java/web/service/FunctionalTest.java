package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class FunctionalTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dhruv\\OneDrive\\Desktop\\Assignment\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginAndMathQuestionsCorrectFlow() {
        driver.get("http://localhost:8080/login");

        // Perform login
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");
        passwordField.submit();

        // Answer Q1 correctly
        WebElement answerField = driver.findElement(By.name("result"));
        answerField.sendKeys("8");
        answerField.submit();

        // Answer Q2 correctly
        answerField = driver.findElement(By.name("result"));
        answerField.sendKeys("5");
        answerField.submit();

        // Answer Q3 correctly
        answerField = driver.findElement(By.name("result"));
        answerField.sendKeys("3");
        answerField.submit();

        // Verify final success URL
        assertEquals("http://localhost:8080/success", driver.getCurrentUrl());
    }

    @Test
    public void testLoginAndMathQuestionsIncorrectFlow() {
        driver.get("http://localhost:8080/login");

        // Perform login
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");
        passwordField.submit();

        // Answer Q1 incorrectly
        WebElement answerField = driver.findElement(By.name("result"));
        answerField.sendKeys("7");
        answerField.submit();

        // Verify error message on Q1 page
        WebElement errorMsg = driver.findElement(By.id("error"));
        assertEquals("Incorrect, try again.", errorMsg.getText());

        // Answer Q1 correctly
        answerField = driver.findElement(By.name("result"));
        answerField.clear();
        answerField.sendKeys("8");
        answerField.submit();

        // Answer Q2 incorrectly
        answerField = driver.findElement(By.name("result"));
        answerField.sendKeys("6");
        answerField.submit();

        // Verify error message on Q2 page
        errorMsg = driver.findElement(By.id("error"));
        assertEquals("Incorrect, try again.", errorMsg.getText());

        // Answer Q2 correctly
        answerField = driver.findElement(By.name("result"));
        answerField.clear();
        answerField.sendKeys("5");
        answerField.submit();

        // Answer Q3 incorrectly
        answerField = driver.findElement(By.name("result"));
        answerField.sendKeys("4");
        answerField.submit();

        // Verify error message on Q3 page
        errorMsg = driver.findElement(By.id("error"));
        assertEquals("Incorrect, try again.", errorMsg.getText());
    }
}
