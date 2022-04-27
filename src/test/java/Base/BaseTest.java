package Base;

import Config.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.EventReporter;
import utils.UtilTest;
import utils.WindowManager;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
    private EventFiringWebDriver e_driver;
    public static UtilTest utilTest;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static String downloadFilepath;
    public static ExcelEngine excelEngine;
    public static SoftAssert softAssert;
    public static Vod_Search_Youtube searchpage;





    @BeforeClass
    @Parameters({"browser","url"} )
    public void setUp(String browser , String url, Method method ) {
        if (browser.equalsIgnoreCase("chrome")) {
            downloadFilepath = System.getProperty("user.dir") + "\\Downloads";
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(cap);
            System.out.println("chrome is selected to run");

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("FireFox is selected to run");
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("edge is selected to run");
        }
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        excelEngine = new ExcelEngine ();

        softAssert=new SoftAssert();
        //webApplication size
        //Dimension setSize = new Dimension(375, 812);
        e_driver =new EventFiringWebDriver(driver);
        e_driver.register(new EventReporter());
        driver=e_driver;
        searchpage = new Vod_Search_Youtube(driver);

    }






    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterClass
    public void tearDown()   {
        driver.manage().deleteAllCookies();
        driver.quit();
    }





    @BeforeMethod
    public void start(Method method) throws InterruptedException, Throwable {

        logger = extent.startTest(method.getName());
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws Throwable {

        if (result.getStatus() == ITestResult.FAILURE) {

            logger.log(LogStatus.FAIL, "Test Failed " + result.getThrowable());
            String picturePath = utilTest.TakeSnapshot(driver, result.getName());
            logger.log(LogStatus.FAIL, logger.addScreenCapture(picturePath));


        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());

        } else {
            logger.log(LogStatus.PASS, "Test passed");
            String picturePath = utilTest.TakeSnapshot(driver, result.getName());
            logger.log(LogStatus.PASS, logger.addScreenCapture(picturePath));

        }

        extent.endTest(logger);


    }
}
