package framework.appium;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

	public class Demo extends Capability 
	{
		
		AndroidDriver<AndroidElement> driver;
		
		@BeforeTest
		public void bt() throws IOException, InterruptedException
		{
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(5000);
			//driver = capabilities(appPackage, appActivity, deviceName, platformName, chromeExecutable);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	}
	
		
		@Test(enabled=false)
		public void testcase1() 
		{
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//hide the keyboard
			driver.hideKeyboard();
			//i want to enter the name
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kansas");
			//i want to fetch the name and store in variable
			String Name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
			//click on lets shop
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			//asserting the name
			String expected = "kansas";
			Assert.assertEquals(Name, expected);
		}

		//error handling test case to fetch the error msg
		@Test(enabled=false)
		public void testcase2() 
		{
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//hide the keyboard
			driver.hideKeyboard();
			//i want to enter the name
			//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kansas");
			//i want to fetch the name and store in variable
			//String Name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
			//click on lets shop
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			//here i want to capture the error message which is always dissapearing.[1] is first error message
			String errormsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		    System.out.println(errormsg);
		    String expected ="Please enter your name";
		    Assert.assertEquals(errormsg, expected);
			
		}
	   
		@Test(enabled=false) 
		void testcase3() 
		{
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//hide the keyboard
			driver.hideKeyboard();
			//i want to enter the name
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kansas");
			//i want to fetch the name and store in variable
			String Name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
			//click on lets shop
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			//asserting the name
			String expected = "kansas";
			Assert.assertEquals(Name, expected);
			//i want to scroll till a element and click on the add to cart button ;finding the total number of items on page
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
			int links  = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
			for(int i=0;i<links;i++)
			{
				String name =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
				if(name.equalsIgnoreCase("Air Jordan 9 Retro"))
						{
					         driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
					         break;
						}
			}
			//click on add to cart button
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			String Actual = driver.findElement(By.xpath("//*[@text='Air Jordan 9 Retro']")).getText();
			String Expected = "Air Jordan 9 Retro";
			Assert.assertEquals(Expected, Actual);
			
	}
		@Test
		public void testcase4() throws InterruptedException, IOException 
		{
			service = startServer();
			driver = capabilities(appPackage, appActivity, deviceName, platformName, chromeExecutable);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//i want to select the radio button which is female
			driver.findElement(By.xpath("//*[@text='Female']")).click();
			//hide the keyboard
			driver.hideKeyboard();
			//i want to enter the name
			driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kansas");
			//i want to fetch the name and store in variable
			String Name = driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).getAttribute("text");
			//i want to select the dropdown
			driver.findElement(By.id("android:id/text1")).click();
			//now i want to scroll
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
			//click on lets shop
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			// i want to click on add to cart of first two elements without scroll; below line wil click on first add to cart
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			//i want to click on second add to cart button; here we gave get(0) since after first add to cart is selcted it becomes added to cart hence the index of second becomes 0 only
			driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
			//click on add to cart button
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			Thread.sleep(3000);
			//add to product amnt and  compare against the final amount
			//first product amnt
			String first = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
			//elimate the first character
			first = first.substring(1);
			System.out.println(first);
			//parsing the value form double to int
			Double amnt = Double.parseDouble(first);
			//second product amnt
			String second = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
			System.out.println(second);
			//elimate the first character
			second = second.substring(1);
			System.out.println(second);
			//parsing the value form double to int
			Double amnt2 = Double.parseDouble(second);
			//parsing the total cart value fromm double to int
			Double total = amnt + amnt2 ;
			System.out.println(total);
			//total product amnt
			String totalamnt = driver.findElements(By.id("com.androidsample.generalstore:id/totalAmountLbl")).get(0).getText();
			System.out.println(totalamnt);
			totalamnt = totalamnt.substring(1);
			Double finalamnt = Double.parseDouble(totalamnt);
			Assert.assertEquals(finalamnt, total);
			//tap on the checkbox content
			WebElement tap = driver.findElementByClassName("android.widget.CheckBox");
			TouchAction T = new TouchAction(driver);
			T.tap(tapOptions().withElement(element(tap))).perform();
	       //longpress on the terms and conditions
			WebElement LP = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			T.longPress(longPressOptions().withElement(element(LP)).withDuration(ofSeconds(3))).release().perform();
			//close button
			driver.findElement(By.id("android:id/button1")).click();
			//click on visit website button
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			Thread.sleep(3000);
			//context//web//hydbrid//native
			//contex is to understand or to know which context i am in at present
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames)
			{
			    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_
		    }	
			//this is used to switch between native app and web app in hybrid app
		    driver.context("WEBVIEW_com.androidsample.generalstore");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		    driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    driver.context("NATIVE_APP");
		    
		    service.stop();
	  } 
	}
	
