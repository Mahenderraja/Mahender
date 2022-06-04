package sp_1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import net.jodah.failsafe.internal.util.Assert;

public class Spring {
public static void main(String args[])throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Chorme.driver\\chromedriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	
	driver.navigate().to("https://codeshare.io/");
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Share Code Now")).click();
	
	Thread.sleep(3000);

	
    Assert.state(true, "expected_line_1", "#include <stdio.h>");
	driver.findElement(By.tagName("textarea")).sendKeys("#include <stdio.h>");
	driver.findElement(By.tagName("textarea")).sendKeys(Keys.ENTER);
	System.out.println("entered into 1tab");
    System.out.println("entered #include <stdio.h>");
    String currenturl=driver.getCurrentUrl();
	driver.switchTo().newWindow(WindowType.WINDOW);
	
	ArrayList<String> windsinfo = new ArrayList<String>(driver.getWindowHandles());
	for (String h:windsinfo)System.out.println("the handle is" + h);
	driver.navigate().to(currenturl);
    driver.switchTo().window(windsinfo.get(0));
    
    Thread.sleep(3000);
	
    Assert.state(true, "expected_line_1", "#include <conio.h>");
	driver.findElement(By.tagName("textarea")).sendKeys("#include <conio.h>");
	driver.findElement(By.tagName("textarea")).sendKeys(Keys.ENTER);
	System.out.println("entered into 2tab");
	System.out.println("entered #include <conio.h> ");
	driver.switchTo().window(windsinfo.get(0));
	System.out.println("driver entered into 1 st window");
	driver.quit();
	
		}

	}
