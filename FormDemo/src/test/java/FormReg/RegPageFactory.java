package FormReg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegPageFactory {
	WebDriver webDriver;
	
	public RegPageFactory() {
	
	}

	public RegPageFactory(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}

	@FindBy(name="name")
	@CacheLookup
	WebElement name;
	
	@FindBy(id="txnPh")
	@CacheLookup
	WebElement mobile;
	
	@FindBy(id="txnEmail")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="mG")
	@CacheLookup
	WebElement mgender;
	
	@FindBy(id="fG")
	@CacheLookup
	WebElement fgender;
	
	@FindBy(name="address")
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[6]/td/input")
	@CacheLookup
	WebElement button;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMgender() {
		return mgender;
	}

	public WebElement getFgender() {
		return fgender;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getButton() {
		return button;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void setName(String nameTemp) {
		name.sendKeys(nameTemp);
	}

	public void setMobile(String mobileTemp) {
		mobile.sendKeys(mobileTemp);
	}

	public void setEmail(String emailTemp) {
		email.sendKeys(emailTemp);
	}

	public void setMgender() {
		mgender.click();
	}

	public void setFgender() {
		fgender.click();
	}

	public void setAddress(String addressTemp) {
		address.sendKeys(addressTemp);
	}

	public void setButton() {
		button.click();
	}
	
	
}
