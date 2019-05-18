package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebScrap
{
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().version("74.0.3729.6").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.espncricinfo.com/series/8048/scorecard/1178427/kings-xi-punjab-vs-kolkata-knight-riders-52nd-match-indian-premier-league-2019");
		
		List<WebElement> playerNames = driver.findElements(By.cssSelector(".scorecard-section >div [name='&lpos=cricket:game:scorecard:player']"));
		List<WebElement> headers = driver.findElements(By.cssSelector(".wrap.header >div"));
		
		for(WebElement el : headers)
		{
			if(el.isDisplayed())
			{
				System.out.print(el.getText()+"\t");
				getPlaydetails(driver, el.getText());
				System.out.println();
			}
		}
		
		
		
		for(WebElement el : playerNames)
		{
			if(el.isDisplayed())
			{
				System.out.print(el.getText()+"\t");
				getPlaydetails(driver, el.getText());
				System.out.println();
			}
		}
		
	}
	
	public static void getPlaydetails(WebDriver driver, String playerName)
	{
		List<WebElement> playerNames = driver.findElements(By.xpath("//a[text()='"+playerName+"']/../following-sibling::*"));
		for(WebElement el : playerNames)
		{
			System.out.print(el.getText()+"\t");
		}
		
	}
}
