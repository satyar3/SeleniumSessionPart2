package Tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageDisabledOption
{
	@Test
	public void main()
	{
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		//ChromeOptions options = new ChromeOptions();
		FirefoxOptions options = new FirefoxOptions();
		
		//disableImgChrome(options);
		disableImgFirefox(options);
		
		//WebDriver driver = new ChromeDriver(options);
		//driver.get("https://www.amazon.com");
		
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.amazon.com");
		
	}
	
	public static void disableImgChrome(ChromeOptions options)
	{
		HashMap<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2);
		
		HashMap<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("profile.default_content_setting_values", images);
		
		options.setExperimentalOption("prefs", preferences);
	}
	
	public static void disableImgFirefox(FirefoxOptions options)
	{
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		
	}
}


