package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;
import pages.addtocard;

public class AddToCart extends CucumberRunner {
	
	@Then("^I navigate back to homepage of store")
	public void clickOnHomePage() throws Throwable {
		
		WebElement homepage = driver.findElement(By.partialLinkText("Home"));
		explicitWait(homepage);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		homepage.click();
	}
	
	@Then("^I click on Add Dell i7 eight gb laptop from the list")
	public void clickOnDellLaptop() throws Throwable {
		
		WebElement dellLaptop = driver.findElement(By.xpath("//a[contains(text(),'Dell i7 8gb')]"));
		explicitWait(dellLaptop);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		dellLaptop.click();
	}
	
	
	@When("^I navigate to cart")
	public void clickOnCart() throws Throwable {
		
		WebElement cart = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
		explicitWait(cart);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		cart.click();
	}
	
	@When("^I click on delete button to delete \"(.*?)\" laptops")
	public void clickOnDeleteLaptop(String deviceName) throws Throwable {
		
		WebElement deleteButton = driver.findElement(By.xpath("//td[contains(text(),'"+deviceName+"')]/following-sibling::td[2]/a"));
		explicitWait(deleteButton);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		deleteButton.click();
		
	}
	
	
	@Then("^I validate \"(.*?)\" laptop deleted from cart")
	public void verifyDeletedItem(String deviceName) throws Throwable {
		
		WebElement device = driver.findElement(By.xpath("//td[contains(text(),'"+deviceName+"')]"));
		explicitWait(device);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		//WebElement device = driver.findElement(By.xpath("//td[contains(text(),'"+deviceName+"')]"));
	//	List<WebElement> deviceCount = driver.findElements(By.xpath("//tbody/tr"));
        int flag = 0;
        while(flag==0) {
 
		if(device.getText().equals(deviceName)){
			System.out.println("Device not deleted successfully");
			Thread.sleep(5000);
			break;
		}
		else {
			
			System.out.println("Device deleted successfully");
			flag = 1;
			
		}
        }
	}
	
	
	
	@Then("^I click on place order")
	public void clickOnPlaceOrder() throws Throwable {
		
		WebElement placeOrder = driver.findElement(By.xpath("//button[contains(text(),'Place Order')]"));
		explicitWait(placeOrder);
		//driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		placeOrder.click();
	}
	
//	addtocard addToCartPage = new addtocard();
//	
//	@Then("^I click on Add to cart$")
//	public void clickOnAddToCart() throws Throwable {
//		
//		explicitWait(addToCartPage.addToCart);
//		addToCartPage.addToCart.click();
//		
//	}

}
