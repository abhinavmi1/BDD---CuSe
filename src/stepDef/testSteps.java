package stepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class testSteps {


	//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver();
	WebDriver driver = new FirefoxDriver();
@Given("^Audio album web app is launched$")
public void Audio_album_web_app_is_launched() throws Throwable {
	System.out.println("Finally it works");
	//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	
	driver.get("https://cf-academy-demo-app-abhinav.cfapps.io/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@Given("^Add new album is clicked$")
public void Add_new_album_is_clicked() throws Throwable {
	driver.findElement(By.xpath("//*[@id='albums']/div[1]/div/a[8]")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@When("^Valid values are entered$")
public void Valid_values_are_entered() throws Throwable {
	WebElement title = driver.findElement(By.xpath("//*[@id='title']"));
	title.sendKeys("Abhinav");
	WebElement artist = driver.findElement(By.xpath("//*[@id='artist']"));
	artist.sendKeys("Abhinav");
	WebElement releaseYear = driver.findElement(By.xpath("//*[@id='releaseYear']"));
	releaseYear.sendKeys("1990");
	WebElement genre = driver.findElement(By.xpath("//*[@id='genre']"));
	genre.sendKeys("Abhinav");
}

@When("^Ok button is clicked$")
public void Ok_button_is_clicked() throws Throwable {
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[1]")).click();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
}

@Then("^Adlum added message is displayed$")
public void Adlum_added_message_is_displayed() throws Throwable {
	String text = driver.findElement(By.xpath("//*[@id='alert']/div/p")).getText();
	System.out.println(text);
	String expected = "Album saved";
	if(text != expected)
	{
		System.out.println("Test Case Passed");
	}
	else
	{
		System.out.println("Test Case Failed");
	}
}
}
