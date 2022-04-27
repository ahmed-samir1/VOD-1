package Pages;

import Base.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class configTest extends BaseTest {


	@BeforeSuite()
	public void setExtent() {

		extent = new ExtentReports(System.getProperty("user.dir")+"\\AutoReport\\index.html", true);
		extent.addSystemInfo("Framework", "Page Object Model");
		extent.addSystemInfo("Author", "Ahmed Samir");
		extent.addSystemInfo("OS", "window");
		extent.addSystemInfo("Test Type", "E2E");
		extent.addSystemInfo("project Name", "General QC Report");
		extent.addSystemInfo("Cross Platform", "Chrome & Firefox & Edge");

	}

	@AfterSuite()
	public void endReport() {

		extent.flush();

	}

	
	

}
