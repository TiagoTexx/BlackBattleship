package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.jetbrains.com/");
        
        mainPage = new MainPage(driver);
        mainPage.closePopUp();
    }

    @AfterEach
    public void tearDown() {
      driver.quit();
    }


    @Test
    public void search() throws InterruptedException {
        Thread.sleep(3000);
        mainPage.searchButton.click();
        //Thread.sleep(1000);
        WebElement searchField = driver.findElement(By.cssSelector("[data-test-id='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();
        //Thread.sleep(1000);
        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test-id='search-input']"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        assertTrue(driver.getCurrentUrl().contains("/products/"));
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
