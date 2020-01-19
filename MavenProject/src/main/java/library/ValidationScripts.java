package library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ValidationScripts {
	WebDriver driver;
	
	public ValidationScripts(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/*
	 * Function: To handle text boxes
	 * Date : 11/03
	 * Created By : 
	 */
	public void typeText(By objName, String testData, String desc)
	{
		if (driver.findElements(objName).size() == 1)
		{
			driver.findElement(objName).sendKeys(testData);
		}else
		{
			// fail the test case
			Assert.fail(desc +"- Object is not found");
		}
	}

	/*
	 * Function: To handle click objects
	 * Date : 11/03
	 * Created By : 
	 */
	public void clickObject(By objName,String desc)
	{
		if (driver.findElements(objName).size() == 1)
		{
			driver.findElement(objName).click();
		}else
		{
			// fail the test case
			Assert.fail(desc +"- Object is not found");
		}
	}

	/*
	 * Function: To handle radio option box
	 * Date : 11/03
	 * Created By : 
	 */
	public void radSelection(By objName, String testData, String desc)
	{

		if (driver.findElements(objName).size() > 0)
		{
			List<WebElement> Types= driver.findElements(objName);
			for(WebElement Type: Types)
			{
				if(Type.getAttribute("value").equals(testData))
				{
					Type.click();
				}
			}

		}else
		{
			// fail the test case
			Assert.fail(desc +"- Object is not found");
		}

	}
	/*
	 * Function: To handle select drop down box
	 * Date : 11/03
	 * Created By : 
	 */
	public void selectDropDown(By objName, String testData, String desc)
	{
		if (driver.findElements(objName).size() == 1)
		{
			Select dep = new Select(driver.findElement(objName));
			dep.selectByVisibleText(testData);

		}else
		{
			// fail the test case
			Assert.fail(desc +"- Object is not found");
		}
	}

}
