package week4.day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		//Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		
		//Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		
		//Click on NSE bulk Deals
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
		
		//Get all the Security names
		List<WebElement> names = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[3]"));
		Thread.sleep(2000);
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < names.size(); i++) {
			//System.out.println(names.get(i).getText());
			String dup = names.get(i).getText();
			System.out.println(dup);
			list.add(dup);
			
		}
		//Print security names without dupliactes
		Set<String> set=new HashSet<String>(list);
		System.out.println("Security names without duplicates :" + set);
		driver.close();
	
}
		


}



