package driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ValidationScripts;
import repository.NewToursObjects;
import testdata.NewToursData;

public class DriverDemo {
	WebDriver driver;
	NewToursObjects or;
	ValidationScripts vs;

	@Test(dataProvider="dpLogin", dataProviderClass=NewToursData.class)
	public void demoTest(String un, String pwd, String expTitle, String trip, String dFrom)
	{
		String actTitle=driver.getTitle().trim();
		Assert.assertEquals(actTitle, expTitle);
		vs.typeText(or.txtUserName, un, "UserName");
		vs.typeText(or.txtPassword, pwd, "Password");
		//driver.findElement(or.txtUserName).sendKeys(un);
		//driver.findElement(or.txtPassword).sendKeys(pwd);
		vs.clickObject(or.btnLogin, "Login Button");
		//driver.findElement(or.btnLogin).click();
	/*	List<WebElement> Types= driver.findElements(or.radTripType);
		for(WebElement Type: Types)
		{
			if(Type.getAttribute("value").equals(trip))
			{
				Type.click();
			}
		}
		Select dep = new Select(driver.findElement(or.selFromPort));
		dep.selectByVisibleText(dFrom);*/
		vs.radSelection(or.radTripType, trip, "Trip Type radio option");
		vs.selectDropDown(or.selFromPort, dFrom, "From Port Select Drop down");
		vs.clickObject(or.lnkSignOff, "Log-off link");
		//driver.findElement(or.lnkSignOff).click();	
		}

	@BeforeMethod
	public void demoBfr()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neel\\Desktop\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		vs = new ValidationScripts(driver);
		
		driver.get("http://newtours.demoaut.com/");
	}

	@AfterMethod
	public void demoAft()
	{
		driver.close();
	}

}
