package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;
import java.util.logging.Level;

// page_url = https://www.jetbrains.com/
public class MainPage {

    @FindBy(xpath = "//*[@data-test-marker='Products']") //'Developer Tools']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='suggestion-link']") //suggestion-action']")
    public WebElement findYourToolsButton;

    @FindBy(xpath = "//div[@data-test='main-menu-item'and @data-test-marker = 'Products']") // and @data-test-marker = 'Developer Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    @FindBy(css = "button[class='ch2-btn ch2-allow-all-btn ch2-btn-primary']")
    public WebElement cookieAllowButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Closes the cookie consent popup by clicking the "Allow All" button.
     * This method encapsulates the interaction with the popup element.
     */
    public void closePopUp() {
        cookieAllowButton.click();
    }
}
