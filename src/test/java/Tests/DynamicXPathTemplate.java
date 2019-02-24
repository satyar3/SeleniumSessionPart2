package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DynamicXPathTemplate
{
	@Test
	public void testDynamicXpath()
	{
		String xpath = createDynamicXpath("//input[@id='{0}' and @name = '{1}' and @class = '{2}']", "Satya","ranjan","muduli");
		System.out.println("Xpath is : "+ xpath);
		
		By xpath2 = By.xpath(createDynamicXpath("//input[@id='{0}' and @name = '{1}' and @class = '{2}']", "Satya","ranjan","muduli"));
		System.out.println(xpath2);
	}
	
	
	//input[@id='{0}']
	public static String createDynamicXpath(String xpathExpression, Object...args)
	{
		for(int i = 0; i<args.length; i++)
		{
			xpathExpression = xpathExpression.replace("{"+i+"}", (CharSequence) args[i]);
		}
		
		return xpathExpression;
	}
}
