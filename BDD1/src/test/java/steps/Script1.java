package steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Script1 {
	WebDriver d2;
	@Given(":Open chrome browser and url of application")
	public void open_chrome_browser_and_url_of_application() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\B S BHASKAR\\Downloads\\chromedriver_win32\\chromedriver.exe");
		d2=new ChromeDriver();
		d2.get("https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_AccountFlyout_signout%26signIn%3D1%26useRedirectOnSuccess%3D1");
		
	}

	@When("Enter ap_mail,continue,ap_password and click on signin button")
	public void enter_ap_mail_continue_ap_password_and_click_on_signin_button() {
	    // Write code here that turns the phrase above into concrete actions
		d2.findElement(By.id("ap_email")).sendKeys("9632719969");
		d2.findElement(By.id("continue")).click();
		d2.findElement(By.id("ap_password")).sendKeys("Bharath@4");
		d2.findElement(By.id("signInSubmit")).click();
		
	}

	@Then("Success in Signin")
	public void success_in_Signin() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement searchBox = d2.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("xbox");
		d2.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		d2.findElement(By.linkText("Xbox One Series S")).click();
		Set<String> ids = d2.getWindowHandles();
	    Iterator<String> it = ids.iterator();
	    String parentId = it.next();
	    String childId = it.next();
	    d2.switchTo().window(childId);
	    d2.findElement(By.id("add-to-cart-button")).click();
		
	}

}
