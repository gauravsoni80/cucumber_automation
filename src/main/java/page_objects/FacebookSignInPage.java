package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constant_page.AmazonLogin;
import constants.FindElement.ElementType;
import utils.Base;
import java.util.*;

public class FacebookSignInPage {
	private WebDriver driver;
	private WebElement element;
	
	public FacebookSignInPage(WebDriver rDriver) {
		this.driver = rDriver;
	}
	
	public void accountAndList() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.ACCOUNT_LIST, ElementType.XPath);
		element.click();
	}

	
	public void userName() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.AMAZON_USER_CLASS, ElementType.Class);
		element.sendKeys(AmazonLogin.AmazonString.USER);
	}
	
	public void continueButton() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.CONTINUE_BUTTON, ElementType.Class);
		element.click();
	}
	
	public void password() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.AMAZON_PWD_ID, ElementType.Id);
		element.sendKeys(AmazonLogin.AmazonString.PASS);
	}
	
	public void rememberMe() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.AMAZON_REMEMBER_NAME, ElementType.Name);
		element.click();
	}
	
	public void submitButton() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.AMAZON_LOGIN_BUTTON, ElementType.Id);
		element.click();
	}
	
//	public void otpVerification() throws Exception {
//		element = Base.elementManager(driver, AmazonLogin.AMAZON_OTP_VERIFY_ID, ElementType.Id);
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//		element.sendKeys(sc.next());
//	}
	
	public void logout() throws Exception {
		element = Base.elementManager(driver, AmazonLogin.ACCOUNT_LIST, ElementType.XPath);
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click().build();
		element = Base.elementManager(driver, AmazonLogin.AMAZON_LOGOUT_BUTTON, ElementType.XPath);
		element.click();
	}
}
