package stepdefination;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {
	WebDriver driver;
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}

	@When("the user logs in with valid credentials")
	public void the_user_logs_in_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Convert the DataTable into a Map
	    Map<String, String> credentials = dataTable.asMaps(String.class, String.class).get(0);
	   Thread.sleep(3000);
	    WebElement usernameField = driver.findElement(By.xpath("//input[@type='text']"));
	    usernameField.sendKeys(credentials.get("username"));
	    // Enter password
	    WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
	    passwordField.sendKeys(credentials.get("password"));
	    // Click the submit button
	    WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
	    submitButton.click();
	}

	@When("the user adds the following items to the cart:")
	public void the_user_adds_the_following_items_to_the_cart(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    // Convert the data table into a map
	    Map<String, String> credentials = dataTable.asMaps(String.class, String.class).get(0);
	    // Pause to allow page load (avoid long sleeps; use WebDriverWait for better practices)
	    Thread.sleep(3000);
	    // Click on the link for the first item
	    driver.findElement(By.partialLinkText(credentials.get("Item Name"))).click();
	    Thread.sleep(3000);
	    // Add the first item to the cart
	    WebElement item1 = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
	    String name1 = item1.getText();
	    item1.click();
	    Thread.sleep(3000);
	    // Go back to the item list
	    WebElement backButton1 = driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_large inventory_details_back_button']"));
	    backButton1.click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']")).click();
	    Thread.sleep(3000);
	}

	@When("the user proceeds to checkout with the following details:")
	public void the_user_proceeds_to_checkout_with_the_following_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    Map<String, String> credentials = dataTable.asMaps(String.class, String.class).get(0);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(credentials.get("First Name"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(credentials.get("Last Name"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(credentials.get("Zip Code"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='continue']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@id='finish']")).click();
	    Thread.sleep(3000);
	}

	@Then("the order confirmation message should be {string}")
	public void the_order_confirmation_message_should_be(String string) throws InterruptedException {
	Thread.sleep(3000);
	WebElement massage = driver.findElement(By.xpath("//h2[@class='complete-header']"));
	String massage1 = massage.getText();
	if(massage1.equals(string) ) {
		System.out.println(massage1);
	}
	driver.close();
	}	
}
