
package BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.MemberSubstitution.TypePoolResolver.OfImplicitPool;

public class BaseClass2 {
	private static final String STRING = null;
	public static WebDriver driver;

	public static void browserLaunch(String Url) {
		driver.get(Url);
		driver.manage().window().maximize();
	}

	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
	}

	public String getProjecpath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public String getpropertyfileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjecpath() + "\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}

	public byte[] screenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	// **********************************************************************************
	// 1
	public static void browserlaunch(String Url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get(Url);
		driver.manage().window().maximize();
	}

	// 2
	public WebElement findelementId(String Id) {
		WebElement elementId = driver.findElement(By.id(Id));
		return elementId;
	}

	// 3
	public WebElement findelementName(String Name) {
		WebElement elementName = driver.findElement(By.name(Name));
		return elementName;

	}

	// 4
	public static void sendValues(WebElement element, String data) {
		element.sendKeys(data);
	}
	public void sendkeysViaActiveElement(String data) {
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys(data);
	}

	// 5
	public void elementClick(WebElement element) {
		element.click();
	}

	// 6
	public void elementclear(WebElement element) {
		element.clear();
	}

	// 7
	public String getTitle() {
		return driver.getTitle();
	}

	// 8
	public void closeWindow() {
		driver.close();
	}

	// 9
	public void quitMethod() {
		driver.quit();
	}

	// 10
	public void getCurrentUrl() {
		driver.getCurrentUrl();
	}

	// 11
	public WebElement findElementClassName(String ClassName) {
		WebElement elementClassname = driver.findElement(By.className(ClassName));
		return elementClassname;
	}

	// 12
	public WebElement findElementXpath(String Xpath) {
		WebElement ElementXpath = driver.findElement(By.xpath(Xpath));
		return ElementXpath;
	}

	// 13
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 14
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 15
	public void alertEnterText(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}

	// 16
	public void selectByOption(WebElement element, String text) {
		// obj creation for select
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 17
	public void selectByValue(WebElement element, String attributeValue) {
		Select select = new Select(element);
		select.selectByVisibleText(attributeValue);
	}
	// 18

	public void selectByIndex(WebElement element, int numb) {
		Select select = new Select(element);
		select.selectByIndex(numb);
	}

	// 19
	public void switchToChildWindow(String data) {
		driver.switchTo().window(data);
	}

	// 20
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	// 21
	public String getText(WebElement element) {
		String text = element.getText();
		return text;

	}

	// 22
	public void sendkeysJs(WebElement element, String text) {
		JavascriptExecutor a = (JavascriptExecutor) driver;
		a.executeAsyncScript("arguments[0].setAttribute('value','text')", element);
	}

	public void frames(WebElement string2) {
		driver.switchTo().frame(string2);
	}

	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	// 23
	public String readCellData(String pathname, String sheetName, int rowNum, int cellNum) throws IOException {
		String celldata = null;
		File file = new File(pathname);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType Type = cell.getCellType();
		switch (Type) {
		case STRING:
			celldata = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
				celldata = dateformate.format(date);
			} else {
				double numeric = cell.getNumericCellValue();
				long check = Math.round(numeric);
				if (numeric == check) {
					celldata = String.valueOf(check);
				} else {
					celldata = String.valueOf(numeric);

				}
			}
			break;
		default:
			break;

		}
		return celldata;

	}

	// 24
	public void clickByJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// 25
	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(True)", element);
	}

	// 26
	public void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoview(False)", element);
	}

	// 27
	public void robotClass(int key) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(key);
		robot.keyRelease(key);
	}

	// 28
	public WebElement dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target);
		return target;
	}

	// 29
	public WebElement rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick();
		return element;
	}

	// 30
	public Alert promptAlert(String prompt) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(prompt);
		alert.accept();
		return alert;
	}

	// 31
	public String elementGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public void findElements(String WebElement) {
		List<WebElement> findElement = driver.findElements(By.xpath(""));
	}

	public void implicitlyWait(long time) {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

		// driver.manage().timeouts().implicitlyWait(Duration, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 32
	// public void writeCellData(String pathname,String sheetName, int rowNum, int
	// cellNum,data)
	// throws IOException {
	// File file = new File(pathname);
	// FileInputStream stream = new FileInputStream(file);
	// Workbook book = new XSSFWorkbook(stream);
	// Sheet sheet = book.getSheet(sheetName);
	// Row row = sheet.getRow(rowNum);
	// Cell cell = row.getCell(cellNum);
	// String value = cell.getStringCellValue();
	// if (value.equals(olddata)) {
	// cell.setCellValue(olddata);
	// }
	// FileOutputStream out = new FileOutputStream(file);
	// book.write(out);

	// }

}
