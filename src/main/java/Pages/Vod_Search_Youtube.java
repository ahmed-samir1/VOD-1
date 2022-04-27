package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vod_Search_Youtube extends Page_base {

    public WebDriver driver;
    @FindBy(xpath = "//input[@id='search']")
    WebElement searchField;
    @FindBy(xpath = "//button[@id='search-icon-legacy']/yt-icon")
    WebElement searchButton;
    @FindBy(xpath = "//yt-formatted-string[text()='Filters']")
    WebElement filter;
    @FindBy(xpath = "//yt-formatted-string[normalize-space()='Video']")
    WebElement videotype;
    @FindBy(css = "h1.title.style-scope.ytd-video-primary-info-renderer > yt-formatted-string.style-scope.ytd-video-primary-info-renderer")
    WebElement title_under_video;
    //*[@id="title"]/h1/yt-formatted-string
    //"//*[@id=\"container\"]/h1/yt-formatted-string"
    //div[@id='container']/h1/yt-formatted-string
    //yt-formatted-string[@class='style-scope ytd-video-primary-info-renderer'])[1]
    int indexSearch = 0;
    //String searchindex = "(//*[@id=\"video-title\"]/yt-formatted-string)["+indexSearch+"]";

    public Vod_Search_Youtube(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 50);

        this.driver=driver;
    }

    public void searchUsingSearchButton(String searchItem) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        EnterText(searchField, searchItem);
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        clickButton(searchButton);
        //Thread.sleep(3000);

    }

    public void filter() throws InterruptedException {

        //wait.until(ExpectedConditions.visibilityOf(filter));
        clickButton(filter);

        //Thread.sleep(10000);

    }

    public void selectvideotype() {

        wait.until(ExpectedConditions.visibilityOf(videotype));
        clickButton(videotype);
        //Thread.sleep(3000);

    }

    public String getTitleFromSearchPage( int indexSearch) {
        String searchindex = driver.findElement(By.xpath("(//*[@id=\"video-title\"]/yt-formatted-string)[" + indexSearch + "]")).getText();

        return searchindex;
    }

    public void click_on_vedio( int indexSearch) {
        driver.findElement(By.xpath("(//*[@id=\"video-title\"]/yt-formatted-string)[" + indexSearch + "]")).click();


    }

    public String get_title_under_video() {
        wait.until(ExpectedConditions.visibilityOf(title_under_video));
        String title_video= title_under_video.getText();
        return title_video;

    }

}


