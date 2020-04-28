package webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TableDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/WebTable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Double click edit button
		WebElement button=driver.findElementByXPath("(//i[@class=\"fa fa-pencil\"])[1]");
	        Actions action=new Actions(driver);
	    	action.moveToElement(button).doubleClick().build().perform(); 
	    
	   	//Get the data
	    	List<WebElement> input=driver.findElementsByTagName("input");
	    	System.out.println("Number Of Elements:"+input.size());
	    
	    	//Edit the data
	    	for(WebElement value:input) {
	    	String data=value.getAttribute("value");
	    	Thread.sleep(5000);
	    	System.out.println(data);
	    	if(data.equalsIgnoreCase("anilkumar@gmail.com"))
	    	{
	    		value.clear();
	    		value.sendKeys("abc@gmail.com");
	    		continue;
	    	}
	    	if(data.equalsIgnoreCase("bbb"))
	    	{
	    		value.clear();
	    		value.sendKeys("smith");
	    		continue;
	    	}
	    	if(data.equalsIgnoreCase("aaa"))
	    	{
	    		value.clear();
	    		value.sendKeys("john");
	    		continue;
	    	}
	    	if(data.equalsIgnoreCase("male"))
	    	{
	    		value.clear();
	    		value.sendKeys("female");
	    		continue;
	    	} 
	    	if(data.equalsIgnoreCase("9708485431"))
	    	{
	    		value.clear();
	    		value.sendKeys("1234567890");
	    		continue;
	    	} 
	    	System.out.println("Editted");
	    }
	    
	    //click cancel button
	    driver.findElementByXPath("(//button[@class=\"btn btn-danger\"])[1]").click();
	    
	    //Right click the delete button
	    WebElement button1=driver.findElementByXPath("(//i[@class=\"fa fa-trash-o \"])[4]");
	    Actions action1=new Actions(driver);
	    action1.moveToElement(button1).contextClick().build().perform(); 
	    Thread.sleep(1000);
	    
	    //click the delete button
	    driver.findElementByXPath("(//button[text()=\"Delete\"])[4]").click();
	    
	    //alert message
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    System.out.println("Deleted");
	    
	    //close
	    driver.close();
	    
	}
	
		
	

}
