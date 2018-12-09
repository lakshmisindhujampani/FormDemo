package FormReg;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefFormReg {
		WebDriver webDriver=null;
		RegPageFactory regPageFactory=null; 
		
	@Given("^User is on RegistrationPage$")
	public void user_is_on_RegistrationPage() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    webDriver = new ChromeDriver();
	    webDriver.get("file:///C:/Users/lenovo8/Desktop/RegForm.html");
	    regPageFactory = new RegPageFactory(webDriver);
	}

	@Then("^Check the title of the page$")
	public void check_the_title_of_the_page() throws Throwable {
	    String title = webDriver.getTitle();
	    String title1= "Registration Form";
	    assertEquals(title1, title);
	    
	}

	@When("^User enters all valid details$")
	public void user_enters_all_valid_details() throws Throwable {
		regPageFactory.setName("bharath");
		Thread.sleep(500);
		regPageFactory.setMobile("9491125082");
		Thread.sleep(500);
		regPageFactory.setEmail("bharath@gmail.com");
		Thread.sleep(500);
		regPageFactory.getMgender();
		Thread.sleep(500);
		regPageFactory.setAddress("hyderabad");
		Thread.sleep(500);
		regPageFactory.setButton();
	}

	@Then("^navigate to next page$")
	public void navigate_to_next_page() throws Throwable {
	    System.out.println("Registered Successfully");
	}

	@When("^User enters Invalid FirstName$")
	public void user_enters_Invalid_FirstName() throws Throwable {
	    regPageFactory.setName("#123");
	    Thread.sleep(500);
	    regPageFactory.setButton();
	}

	@Then("^generate  error message$")
	public void generate_error_message() throws Throwable {
		String alertMessage = webDriver.switchTo().alert().getText();
		Thread.sleep(500);
		webDriver.switchTo().alert().accept();
		System.err.println("not matched" + alertMessage);
	}

	@When("^User enters Invalid MobileNumber$")
	public void user_enters_Invalid_MobileNumber(DataTable arg1) throws Throwable {
	   regPageFactory.setName("sindhu");
	   Thread.sleep(500);
	   List<String> mobileList=arg1.asList(String.class);
	   String data=null;
	   for (String mobile : mobileList) {
		data=mobile;
		regPageFactory.getMobile().clear();
		Thread.sleep(500);
		regPageFactory.setMobile(mobile);
		Thread.sleep(500);
		regPageFactory.setButton();

			if (Pattern.matches("[7-9]{1}[0-9]{9}", data)) {
				System.out.println("matching");
			} else {
				System.err.println("not matched");
				String alertMessage = webDriver.switchTo().alert().getText();
				Thread.sleep(1000);
				webDriver.switchTo().alert().accept();
				System.err.println("not matched" + alertMessage);
			}
	}
	   regPageFactory.setButton();
}

	@When("^User enters Invalid MailId$")
	public void user_enters_Invalid_MailId(DataTable arg1) throws Throwable {
		regPageFactory.setName("tejitha");
		Thread.sleep(500);
		regPageFactory.setMobile("6303631547");
		Thread.sleep(500);
		List<String> mailList=arg1.asList(String.class);
		String data=null;
		   for (String mail : mailList) {
			data=mail;
			regPageFactory.getEmail().clear();
			Thread.sleep(500);
			regPageFactory.setEmail(mail);;
			Thread.sleep(500);
			regPageFactory.setButton();

				if (Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}$", data)) {
					System.out.println("matching");
				} else {
					System.err.println("not matched");
					String alertMessage = webDriver.switchTo().alert().getText();
					Thread.sleep(1000);
					webDriver.switchTo().alert().accept();
					System.err.println("not matched" + alertMessage);
				}
		}
		   regPageFactory.setButton();
	}

	@When("^User enters Invalid adresss$")
	public void user_enters_Invalid_adresss(DataTable arg1) throws Throwable {
		regPageFactory.setName("siva");
		Thread.sleep(500);
		regPageFactory.setMobile("9491125082");
		Thread.sleep(500);
		regPageFactory.setEmail("sindhu@gmail.com");
		Thread.sleep(500);
		regPageFactory.getMgender();
		Thread.sleep(500);
		regPageFactory.setAddress(" ");
		Thread.sleep(500);
		regPageFactory.setButton();
	}

	@When("^User doesnot enters any details$")
	public void user_doesnot_enters_any_details() throws Throwable {
		regPageFactory.setName(" ");
		Thread.sleep(500);
		regPageFactory.setMobile(" ");
		Thread.sleep(500);
		regPageFactory.setEmail(" ");
		Thread.sleep(500);
		regPageFactory.getMgender();
		Thread.sleep(500);
		regPageFactory.setAddress(" ");
		Thread.sleep(500);
	}

	@When("^Clicks submit button$")
	public void clicks_submit_button() throws Throwable {
	    regPageFactory.setButton();
	}
	
	@After
	public void destroy() {
		webDriver.close();
	}

}
