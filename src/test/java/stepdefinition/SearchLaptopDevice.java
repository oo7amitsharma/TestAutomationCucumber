package stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;
import pages.SearchPage;
import pages.addtocard;

public class SearchLaptopDevice extends CucumberRunner {

	//SearchPage homePage;
	//;
	
	@Given("^I navigate to \"(.*?)\" site")
	public void verifyPageTitle(String text) throws Throwable {

		String title = driver.getTitle();
			if(text == "STORE") {
				Assert.assertEquals(title, "STORE");
			}
	}
	
	@When("^I click on Laptops under category$")
	public void clickOnLaptops() throws Throwable {
		WebElement laptops = driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"));
		explicitWait(laptops);
		laptops.click();
		
		
	}
	
	@Then("^I click on Sony vaio i5 laptop from the list$")
	public void clickOnSonyLaptop() throws Throwable {
		WebElement sonylaptop = driver.findElement(By.linkText("Sony vaio i5"));
		explicitWait(sonylaptop);
		sonylaptop.click();
	}
	

	@And("^I click on Add to cart$")
	public void clickOnAddToCart() throws Throwable {
		WebElement addtocart = driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]"));
		explicitWait(addtocart);
		addtocart.click();
		
	}
	
	
	@And("^I click on ok button to accept the alert$")
	public void acceptAlert() throws Throwable {
		
		try
        {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            
        }
        catch(NoAlertPresentException e)
        {
          Thread.sleep(5000);
          driver.switchTo().alert().accept();
          
        }

	}

}
