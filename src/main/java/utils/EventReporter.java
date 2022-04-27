package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventReporter implements WebDriverEventListener {


    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Try to Accepting Alert  " );

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("Accepted Alert  " );

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("canceled Alert  " );

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("Try to cancel Alert  " );

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        System.out.println("Before navigating to: '" + url + "'");

    }

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        System.out.println("Navigated to:'" + url + "'");

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating back to previous page");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page");

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

            System.out.println("Navigating forward to next page");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Try Refresh");

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println(" Refresh done");

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Found Element By : " + by.toString());

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver webDriver) {
        System.out.println("Trying to click on: " + element.toString());

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver webDriver) {
        System.out.println("Clicked on: " + element.toString());

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the:" + element.toString() + " before any changes made");

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value changed to: " + element.toString());

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("Switching to window : " );

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("Switched to window : " );

    }

    @Override
    public void onException(Throwable error, WebDriver webDriver) {
        System.out.println("Exception occured: " + error);

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {


    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        System.out.println("got a text : "+webElement.toString() );
    }
}
