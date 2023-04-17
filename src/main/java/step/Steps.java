package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import page_objects.FacebookSignInPage;
import utils.Base;
//import org.openqa.selenium.JavascriptExecutor;

public class Steps {

	WebDriver driver;
	WebElement element;
	FacebookSignInPage fbPage;
	
	public Steps() {
		driver = Base.driver();
		fbPage = new FacebookSignInPage(driver);
	}
	
	@Given("Amazon Click Account List")
	public void amazon_click_account_list() throws Exception {
	    fbPage.accountAndList();
	}

	@Given("Amazon Get UserName")
	public void amazon_get_user_name() throws Exception {
		fbPage.userName();
	}

	@Given("Amazon Click Continue Btn")
	public void amazon_click_continue_btn() throws Exception {
	   fbPage.continueButton();
	}

	@When("Amazon Get Password")
	public void amazon_get_password() throws Exception {
	    fbPage.password();
	}
	
	@When("Amazon Remember Me")
	public void amazon_remember_me() throws Exception {
		fbPage.rememberMe();
	}

	@When("Amazon Login Btn Click")
	public void amazon_login_btn_click() throws Exception {
	    fbPage.submitButton();
	}
	
	@When("Amazon Otp Verification")
	public void amazon_otp_verification() throws Exception {
		fbPage.otpVerification();
	}
	
	@Then("Amazon Logout")
	public void amazon_logout() throws Exception {
		fbPage.logout();
	}

	@Then("Close Browser")
	public void close_browser() {
	    driver.close();
	    driver.quit();
	}
}
