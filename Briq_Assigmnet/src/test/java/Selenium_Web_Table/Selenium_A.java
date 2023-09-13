package Selenium_Web_Table;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_A {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();

	        
	        driver.get("http://the-internet.herokuapp.com/challenging_dom");
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        WebElement table = driver.findElement(By.xpath("//div[@class='row']//div[2]"));
	        
	     
	        List<List<String>> tableData = new ArrayList<List<String>>();
	        


	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        for (WebElement row : rows) {
	            List<String> rowData = new ArrayList<String>();
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            for (WebElement cell : cells) {
	                rowData.add(cell.getText());
	            }
	            tableData.add(rowData);
	        }

	        
	        for (List<String> rowData : tableData) {
	            for (String cellData : rowData) {
	                System.out.print(cellData + "\t");
	            }
	            System.out.println();
	        }

	    

	}

}
