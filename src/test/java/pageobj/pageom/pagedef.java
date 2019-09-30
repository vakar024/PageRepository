package pageobj.pageom;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pagedef {
	 WebDriver driver; 
	 Actions act;
	 WebDriverWait wait;
	 @Given("User is on home page")
	 public void a()
	 {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.04.30\\Desktop\\Drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		PageFactory.initElements(driver, factory.class);
	 }
	 @When("User enters username and password and clicks on the login button")
	 public void b()
	 {	
		 factory.username.sendKeys("lalitha");
		 factory.pwd.sendKeys("password123");
		 driver.findElement(By.name("Login")).click(); 
	 }
	 @Then("Navigate to all categories -electronics and headphone")
	 public void c()
	 {
		 act= new Actions(driver);
		 act.moveToElement(driver.findElement(By.linkText("All Categories"))).build().perform();
		 act.moveToElement(driver.findElement(By.linkText("Electronics"))).click().build().perform();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 act.moveToElement(driver.findElement(By.linkText("Head Phone"))).click().build().perform();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	 }
	 @And("Add product into shopping cart and checkout")
	 public void d()
	 { 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  act.moveToElement(driver.findElement(By.linkText("Add to cart"))).click().build().perform();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  act.moveToElement(driver.findElement(By.partialLinkText("Cart"))).click().build().perform();
	  act.moveToElement(driver.findElement(By.linkText("Checkout"))).click().build().perform();
	  act.moveToElement(driver.findElement(By.xpath("//input[@type='submit'and @value='Proceed to Pay']"))).click().build().perform();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 }
	 @And("Select bank and add credentials")
	 public void e()
	 {
	  driver.findElement(By.xpath("//label[contains(text(),'Andhra Bank')]")).click();
	  driver.findElement(By.id("btn")).click();
	  driver.findElement(By.name("username")).sendKeys("123456");
	  driver.findElement(By.name("password")).sendKeys("Pass@456");
	  act.moveToElement(driver.findElement(By.xpath("//input[@type='submit' and @value='LOGIN']"))).click().build().perform();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@type='submit' and @value='PayNow']")).click();
	  Assert.assertEquals(driver.getTitle(),"Order Details");
	  //wait= new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.titleContains("Order Details"));
	  
	 }
	 @Then("Redirected to thank you page")
	 public void f()
	 {
	  driver.findElement(By.linkText("SignOut")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  Assert.assertEquals(driver.getTitle(),"Home"); 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
}
