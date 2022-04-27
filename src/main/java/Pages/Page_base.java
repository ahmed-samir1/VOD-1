package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_base {



    public static WebDriverWait wait;
    public JavascriptExecutor jse;


    //CONSTRUCTOR
    public Page_base (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Main Functions used in all page objects
    public static void clickButton(WebElement Button) {
        wait.until(ExpectedConditions.visibilityOf(Button));
        Button.click();
    }

    public static void EnterText(WebElement textField, String text) {
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.sendKeys(text);
    }

    public void scrollToBottom() {
        jse.executeScript("scrollBy(0,250)");
    }
}
