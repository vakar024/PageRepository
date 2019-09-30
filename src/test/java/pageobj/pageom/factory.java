package pageobj.pageom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class factory {
	WebDriver driver;
	//PageFactory.init elements(driver,age.class)
		@FindBy(how=How.ID,using="userName")
		static public WebElement username;
		@FindBy(how=How.ID,using="password")
		static public WebElement pwd;
		
}
