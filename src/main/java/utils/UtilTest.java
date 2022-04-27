package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class UtilTest {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static Logs logs;
	public static LogEntries logEntries;
	public static PrintWriter writer;
	public static WebDriver driver;
	public static String getNewDownloadFilePath;


	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("AutoReport\\" + System.currentTimeMillis() + ".png"));
	}

	public static void clickByJS(WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static String TakeSnapshot(WebDriver driver, String pictureName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String Destination = pictureName + ".png";
		File FinalDestination = new File("AutoReport\\" + Destination);
		FileUtils.copyFile(src, FinalDestination);
		return Destination;

	}

	public static void getConsoleLogs(WebDriver driver1, ITestResult result) throws Throwable, Throwable {

		logs = driver1.manage().logs();
		logEntries = logs.get(LogType.BROWSER);
		writer = new PrintWriter("AutoReport" + result.getName() + ".txt", "UTF-8");

		for (LogEntry logEntry : logEntries) {
			writer.println("Console log found in Test- " + result.getName());

			writer.println("__________________________________________________________");

			if (logEntry.getMessage().toLowerCase().contains("error")) {
				writer.println("Error Message in Console:" + logEntry.getMessage());

			} else if (logEntry.getMessage().toLowerCase().contains("warning")) {
				writer.println("Warning Message in Console:" + logEntry.getMessage());

			} else {
				writer.println("Information Message in Console:" + logEntry.getMessage());

			}
		}
		writer.close();
	}
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	public static void presenceOfElement(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.ignoring(NoSuchElementException.class).
				ignoring(StaleElementReferenceException.class).
				until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public static void sleepDynamic(WebDriver driver,int timeout){
		 new WebDriverWait(driver, timeout);

	}

	public static void waitElement(WebDriver driver, WebElement locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.ignoring(NoSuchElementException.class).
				ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(locator));

	}

	public static void robotSendKeys(String path) throws AWTException {
		Robot rb = new Robot();

		StringSelection str = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void getFileNameFromDownloadFolder() {
		String DownloadFolderPath=System.getProperty("user.dir")+"\\Downloads";
		File folder = new File(DownloadFolderPath);
		File[] listOfFiles = folder.listFiles();
		File f = null;
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				getNewDownloadFilePath = "" + DownloadFolderPath + "\\" + fileName + "";
				System.out.println("new export file path  = "+getNewDownloadFilePath);
			}
		}
	}

	public static void DeleteAllFilesFromDownloadFolder() {

		File folder = new File(System.getProperty("user.dir")+"\\Downloads");
		File[] listOfFiles = folder.listFiles();
		File f = null;
		assert listOfFiles != null;
		for (File listOfFile : listOfFiles) {
			if (listOfFile.exists()&& listOfFile.isFile()) {
				listOfFile.deleteOnExit();
				System.out.println("Delete All Files From Download Folder");
			}
			System.out.println("files are deleted ?"+listOfFile.delete());
		}
	}
	public static void ScrollDown2Lines(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,50)");
	}


}