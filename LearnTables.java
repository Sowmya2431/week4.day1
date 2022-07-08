package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTables {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		driver.get("http://www.leafground.com/pages/table.html");
		
		//Get the count of number of rows
		WebElement rows = driver.findElement(By.tagName("table"));
		int noOfRows = rows.findElements(By.tagName("tr")).size();
		System.out.println("Number of Rows : " + noOfRows);
		
		//Get the count of number of columns
		WebElement columns = driver.findElement(By.tagName("table"));
		int noOfColumns = columns.findElements(By.tagName("td")).size();
		System.out.println("Number of Columns : " + noOfColumns);
		
		//Get the progress value of 'Learn to interact with Elements'
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='even']//font"));
		for (int i = 0; i < elements.size(); i++) {
			
			System.out.println(elements.get(i).getText());
		}
		
		//Check the vital task for the least completed progress.
		WebElement vitalTask = driver.findElement(By.xpath("(//input[@type='checkbox'])[5]"));
		vitalTask.click();
		
		driver.close();
		
		
			
	
		
		
}
}

