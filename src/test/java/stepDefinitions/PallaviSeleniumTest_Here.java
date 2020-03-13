package stepDefinitions;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class PallaviSeleniumTest_Here 
{
	public static WebDriver driver;
	@Given("^the valid credentials for developer portal$")
	public void the_valid_credentials_for_developer_portal() throws Throwable {
		
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://developer.here.com/documentation"); 
	
	}
	@Then("^verify that main page is loaded correctly$")
	public void verify_that_main_page_is_loaded_correctly() throws Throwable {
		Assert.assertEquals("Documentation, Code Examples and API References - HERE Developer", driver.getTitle());
		System.out.println("Documentation page title is  : "+driver.getTitle()+"Documentation page is loaded");
	}

	@Then("^verify that angular is initialised for main page$")
	public void verify_that_angular_is_initialised_for_main_page() throws Throwable {
	   WebElement htmlEl = driver.findElement(By.tagName("html"));
	   // Verify that HTML element is present
	   Assert.assertNotNull(htmlEl);
	   // Check that the AngularJS application attribute is defined on the element
	   String ngAppAttrVal = htmlEl.getAttribute("data-ng-app");
	   // Verify that the angular app is initialized to "devportal"
	   Assert.assertEquals("devportal", ngAppAttrVal);
	   System.out.println("Angular app initialized on the page");
	}

	@Then("^Validate all internal dcumentation links on that page are loading and they are angular initialized or not$")
	public void validate_all_internal_dcumentation_links_on_that_page_are_loading_and_they_are_angular_initialized_or_not() throws Throwable {
		// Count all links in a page
				List<WebElement> alllinks = driver.findElements(By.tagName("a"));

				for (int i = 0; i < alllinks.size(); i++) {
					WebElement ele = alllinks.get(i);
					// System.out.println(ele);
					// By using "href" attribute, we could get the url of the requried link
					String url = ele.getAttribute("href");
					if (url.contains("developer.here.com/documentation")) {
						System.out.print("this is internal link::");
						verifyURL(url);
					} else if (!url.contains("javascript:void(0)")) {
						System.out.println("this is external link::" + url);
					}
					String ngAttribute = ele.getAttribute("data-ng-click");
					if (ngAttribute != null) {
						System.out.println("Angular initialized link::" + ele.getText());
					}
				}
				driver.quit();
			}

			public static void verifyURL(String url) {
				// Sometimes we may face exception "java.net.MalformedURLException". Keep the
				// code in try catch block to continue the broken link analysis
				try {
					// Use URL Class - Create object of the URL Class and pass the urlLink as
					// parameter
					URL link = new URL(url);
					// Create a connection using URL object (i.e., link)
					HttpURLConnection httpconn = (HttpURLConnection) link.openConnection();
					// Set the timeout for 2 seconds
					httpconn.setConnectTimeout(3000);
					// connect using connect method
					httpconn.connect();
					// use getResponseCode() to get the response code.
					// getResponseCode method returns = IOException - if an error occurred
					// connecting to the server.
					if (httpconn.getResponseCode() == 200) {
						System.out.println(url + "=" + httpconn.getResponseMessage());
					} else if (httpconn.getResponseCode() == 400) {
						System.out.println(url + "=" + httpconn.getResponseMessage());
					} else if (httpconn.getResponseCode() == 401) {
						System.out.println(url + "=" + httpconn.getResponseMessage());
					} else if (httpconn.getResponseCode() == 404) {
						System.out.println(url + "=" + httpconn.getResponseMessage());
					} else if (httpconn.getResponseCode() == 500) {
						System.out.println(url + "=" + httpconn.getResponseMessage());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}




