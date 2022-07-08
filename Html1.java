package week4.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Html1 {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();  
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	
	driver.get("https://html.com/tags/table/");
	
	//Get the count of number of rows
			WebElement rows = driver.findElement(By.tagName("table"));
			int noOfRows = rows.findElements(By.tagName("tr")).size();
			System.out.println("Number of Rows : " + noOfRows);
			
			//Get the count of number of columns
			WebElement columns = driver.findElement(By.tagName("table"));
			int noOfColumns = columns.findElements(By.tagName("td")).size();
			System.out.println("Number of Columns : " + noOfColumns);
			
}
	
}
