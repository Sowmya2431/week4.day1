package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SnapDeal {
	
	public static <allWindows> void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver=new FirefoxDriver();  
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		//Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
		//Search for Training Shoes
		WebElement findElement = driver.findElement(By.id("inputValEnter"));
		findElement.sendKeys("Training Shoes" ,Keys.ENTER);
		Thread.sleep(10000);
		
		//Get the count of training shoes
		int size = driver.findElements(By.xpath("//picture[@class='picture-elem']//img")).size();
		System.out.println("No of Training shoes :" + size);
		Thread.sleep(10000);
		
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		WebElement sort = driver.findElement(By.xpath("//ul[@class='sort-value']//li[3]"));
		sort.click();
		Thread.sleep(10000);
		
		
		//Check if the items displayed are sorted correctly
		List<WebElement> sortedPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		//List <Integer> list = new ArrayList<Integer>();
		
		//iterate the list and add the values 
		//for (WebElement each_shoe : sortedPrice) {
		//String price = each_shoe.getAttribute("data-price");
		//int i = Integer.parseInt(price);
		//list.add(i);
		for (int i = 0; i < sortedPrice.size(); i++) {
			System.out.println(sortedPrice.get(i).getText());
			
		}
		
	
		
		// Verify list is sorted or not
		//boolean listSorted = isListSorted(true, list);
		//System.out.println("isListsorted = " + listSorted);
				
		//Select the price range (900-1200)
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("900");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
		Thread.sleep(2000);
		
		//Filter with color Navy 
		driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).click();
		Thread.sleep(2000);
		
		//verify the filter option is selected
		boolean selected = driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).isSelected();
		System.out.println("Blue colour is selected :" + selected);
		Thread.sleep(2000);
		
		//Mouse Hover on first resulting Training shoes and click on Quick view button
		driver.findElement(By.xpath("//div[@pogid ='640015266547']")).click();
		Thread.sleep(2000);
			
		//Handle the new window
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<allWindows> list1=new ArrayList<allWindows>();
		driver.switchTo().window((String) list1.get(1));
		
		//Print the cost and the discount percentage
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price :" +price);
		String discount = driver.findElement(By.xpath("percent-desc ")).getText();		
	    System.out.println("Discount :" + discount);
	    Thread.sleep(2000);
	    
	    //Come back to base window
	    driver.switchTo().window((String) list1.get(0));
		
		//Take the snapshot of the shoes.
	    File source = driver.getScreenshotAs(OutputType.FILE);
	    File dest = new File ("./snapshots/IMG001.png");
	    FileUtils.copyFile(source, dest);
	    
		//Close the window
		driver.close();
			}

	//private static boolean isListSorted(boolean b, List<Integer> list) {
		// TODO Auto-generated method stub
		//return false;
	//}
	
	
}
		 	 
				
			
			


