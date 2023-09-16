package org.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String a) {
		if(a.equalsIgnoreCase("Chrome")) {
			 driver= new ChromeDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		return driver;
	}
	public static void urlLaunch(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	public static String currenturl() {
		String crl = driver.getCurrentUrl();
		return crl;
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void waitTime(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	public static void sendkeys(WebElement e,String value) {
		e.sendKeys(value);
		
}
	public static void click(WebElement e) {
		e.click();
	}
	public static String getText(WebElement e) {
		String a=e.getText();
		return a;
		
	}
	public static String getAttribute (WebElement e) {
		String s=e.getAttribute("value");
		return s;
		
		}
	//actions
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
			}
	public static void dragAndDrop(WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
			}
	public static void contextClick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();
			}
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
		}
	
	//alert
	public static void alertAccept(WebElement e) {
		Alert a=driver.switchTo().alert();
		a.accept();
		}
	public static void dismissAccept(WebElement e) {
		Alert a=driver.switchTo().alert();
		a.dismiss();
		}
	//Screenshot
	public static void screenShot(String path) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
	}
	//Windows Handling
	public static void windowsHandling(int a) {

		Set<String> windows = driver.getWindowHandles();
		
		List<String> li= new ArrayList<>();
		li.addAll(windows);
		
		driver.switchTo().window(li.get(a));
	}
	
	//javaScript
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",e);
	}
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",e);
	}
	public static String getAttributejs(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String s=(String) js.executeScript("return arguments[0].getAttribute('value')",e);
		return s;
	}	
	//DropDown
	
	public static void selectIndex(WebElement e,int a) {
	Select s=new Select(e);
	s.selectByIndex(a);
	}
	public static void selectValue(WebElement e,String a) {
	Select s=new Select(e);
	s.selectByValue(a);
	}
	public static void selectVisibleText(WebElement e,String b) {
	Select s=new Select(e);
	s.selectByVisibleText(b);
		}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



