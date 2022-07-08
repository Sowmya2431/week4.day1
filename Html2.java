package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Html2 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		
		
		// 2. You have to print the respective values based on given Library
		//List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody[1]/tr"));
		//for (WebElement row : rows) {
			//System.out.println(row.getText());
			
		//}
		List<WebElement> marketShare = driver.findElements(By.xpath("(//table//tbody/tr)[1]"));
		for (WebElement row1 : marketShare) {
			System.out.println(row1.getText());
		}
		
		List<WebElement> absoluteUsage = driver.findElements(By.xpath("(//table//tbody/tr)[2]"));
		for (WebElement row2 : absoluteUsage) {
			System.out.println(row2.getText());
		}
		
	}
}

