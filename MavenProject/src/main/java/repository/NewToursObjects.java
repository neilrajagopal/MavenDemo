package repository;

import org.openqa.selenium.By;

public class NewToursObjects {
	//Login page
	public static By txtUserName = By.name("userName");
	public static By txtPassword = By.name("password");
	public static By btnLogin = By.name("login");
	
	//Travel Booking page
	public static By radTripType=By.name("tripType");
	public static By selFromPort=By.name("fromPort");
	public static By lnkSignOff=By.linkText("SIGN-OFF");
	
	
}
