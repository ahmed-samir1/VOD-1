package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    public WebDriver driver;
    static WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){

        this.driver = driver;
        navigate = driver.navigate();
    }

    public static void goBack(){
        navigate.back();
    }

    public static void goForward(){
        navigate.forward();
    }

    public static void refreshPage(){
        navigate.refresh();
    }

    public static void goTo(String url){
        navigate.to(url);
    }
}
