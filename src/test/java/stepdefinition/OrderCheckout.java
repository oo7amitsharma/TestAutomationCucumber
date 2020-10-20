package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;

public class OrderCheckout extends CucumberRunner{
	
	@When("^I navigate to \"(.*?)\" page")
	public void clickOnDeleteLaptop(String text) throws Throwable {
		
		WebElement placeorderpage = driver.findElement(By.xpath("//h5[@id='orderModalLabel']"));
		explicitWait(placeorderpage);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		String placeorderpagetext = placeorderpage.getText();
		if(placeorderpagetext.equals(text)) {
			System.out.println("User is at place order page");
		}
		else {
			System.out.println("User is not at place order page");
		}
	}
	
	@And("^I enter name \"(.*?)\"$")
	public void enterName(String name) throws Throwable {
		WebElement enterName = driver.findElement(By.xpath("//input[@id='name']"));
		explicitWait(enterName);
		enterName.sendKeys(name);		
	}
	
	@And("^I enter city \"(.*?)\"$")
	public void enterCity(String city) throws Throwable {
		WebElement cityDeatils = driver.findElement(By.xpath("//input[@id='city']"));
		explicitWait(cityDeatils);
		cityDeatils.sendKeys(city);
		
	}
	
	@And("^I enter country \"(.*?)\"$")
	public void enterCountry(String country) throws Throwable {
		WebElement countryDeatils = driver.findElement(By.xpath("//input[@id='country']"));
		explicitWait(countryDeatils);
		countryDeatils.sendKeys(country);
		
	}
	
	@And("^I enter credit card \"(.*?)\"$")
	public void enterCardNumber(String cardnumber) throws Throwable {
		WebElement credetCardDetails = driver.findElement(By.xpath("//input[@id='card']"));
		explicitWait(credetCardDetails);
		credetCardDetails.sendKeys(cardnumber);
		
	}
	
	@And("^I enter month \"(.*?)\"$")
	public void enterMonth(String month) throws Throwable {
		WebElement monthDetails = driver.findElement(By.xpath("//input[@id='month']"));
		explicitWait(monthDetails);
		monthDetails.sendKeys(month);
		
	}
	
	@And("^I enter year \"(.*?)\"$")
	public void enterYear(String year) throws Throwable {
		WebElement yearDetails = driver.findElement(By.xpath("//input[@id='year']"));
		explicitWait(yearDetails);
		yearDetails.sendKeys(year);
		
	}
	
	@Then("^I click on purchase$")
	public void clickOnPurchase() throws Throwable {
		WebElement purchaseButton = driver.findElement(By.xpath("//button[contains(text(),'Purchase')]"));
		explicitWait(purchaseButton);
		purchaseButton.click();
		
	}
	
	@And("^I save the purchase amount and id$")
	public void getPurchanseAmountandID() throws Throwable {

		WebElement orderDetails = driver.findElement(By.xpath("//body/div[10]/p"));
		explicitWait(orderDetails);
		
		String orderdetails = orderDetails.getText();
		String[] splitString = orderdetails.split(":");
		String[] pid = splitString[1].split("\\r?\\n");
		String[] pamount = splitString[2].split("\\r?\\n");	
		purchaseID = pid[0].trim();
		purchaseAmount = pamount[0].trim();	
		System.out.println("purchaseID :"+purchaseID);
		System.out.println("purchaseAmount :"+purchaseAmount);
		
	}
	
	@And("^I validate purchase amount with expected amount \"(.*?)\"$")
	public void validatePurchaseAmount(String expectedAmount) throws Throwable {
		Assert.assertEquals(purchaseAmount, expectedAmount);
		//purchaseButton.click();
		
	}
	
	@Then("^I click on OK$")
	public void clickOnOkButton() throws Throwable {
		WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		explicitWait(okButton);
		okButton.click();
		
	}
	
	


}
