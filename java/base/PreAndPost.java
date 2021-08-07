package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import lib.util.ReadExcel;

public class PreAndPost {
	
	private static final ThreadLocal<RemoteWebDriver> localdriver = new ThreadLocal<RemoteWebDriver>();

	public void setDriver(RemoteWebDriver driver) {
		localdriver.set(driver);
	}

	public static RemoteWebDriver getDriver() {
		return localdriver.get();
	}
	public String excelFileName, sheetName;
	public RemoteWebDriver driver;
	public Properties prop;
	public Random rand = new Random();
	public int rand_int1 = rand.nextInt(1000);
	public WebDriverWait wait;
	public static JavascriptExecutor js;
	public FileInputStream fis;
	public ExtentTest node;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public ExtentTest test;
	public String testName, testDesc, testAuthor, testCategory;
	
	@BeforeSuite
		public void startReport() {
			reporter = new ExtentHtmlReporter("./reports/result.html");
			reporter.setAppendExisting(true);
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}


	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDesc);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	
	}
	
	@Parameters({ "browser" })
	@BeforeMethod
		public void Launchapp(String browser,Method name) throws InterruptedException {
		String Methodname=name.getName();
			node = test.createNode(testName);
			//saucelabcomment
			MutableCapabilities sauceOpts=new MutableCapabilities();
			sauceOpts.setCapability("name", Methodname);
			sauceOpts.setCapability("SeleniumVersion", "3.141.59");
			sauceOpts.setCapability("username", "oauth-munnirunnisab-a9e41");
			sauceOpts.setCapability("accesskey", "08688a42-111d-42d4-91aa-897ded00b0f2");
			sauceOpts.setCapability("tags", "w3c-chrome-tests");
			
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability("sauce:options", sauceOpts);
			cap.setCapability("browserVersion", "latest");
			cap.setCapability("platformName", "windows 10");
			//saucelabcomment
			
			try {
				fis = new FileInputStream("./src/main/resources/config.properties");
				prop = new Properties();
				prop.load(fis);
				//String browser="Chrome";
			if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				//saucelabcomment
				cap.setCapability("browserName", browser);
				//saucelabcomment
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");/* ,"headless"); */ // options.addArguments("window-size=1366,768");
			//	https://oauth-munnirunnisab-a9e41:08688a42-111d-42d4-91aa-897ded00b0f2@ondemand.eu-central-1.saucelabs.com:443/wd/hub
				driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"),cap);
				setDriver(driver);
				getDriver().get(prop.getProperty("url"));
				getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(10000);
				getDriver().manage().window().maximize();

			}

			else if (browser.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}

			else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			}

			else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
		
	
	
	public long takeSnap() throws IOException {
		long ranNum = (long) (Math.random() * 99999999L);
		File Source = getDriver().getScreenshotAs(OutputType.FILE);
		File Target = new File("./snaps/img" + ranNum + ".png");
		FileUtils.copyFile(Source, Target);
		return ranNum;
	}
	public void reportStep(String msg, String status) throws IOException {

		if (status.equalsIgnoreCase("pass")) {
			node.pass(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());

		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());

		}
	}
	@AfterMethod
	public void close() {
		getDriver().quit();
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();

	}	
	
	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException { //
		//ReadExcel re = new ReadExcel();
		String[][] readData = ReadExcel.readExcelSData(excelFileName, sheetName);
		return readData;
	}

}
