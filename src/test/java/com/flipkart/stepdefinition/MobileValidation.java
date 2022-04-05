package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileValidation {
	static WebDriver driver ;
	static String name ;
	static String mobilename ;
	@Given("user launches flipkart app")
	public void user_launches_flipkart_app() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	   
	}

	@Given("user login by entering valid credentials")
	public void user_login_by_entering_valid_credentials() {
		driver.findElement(By.xpath("//button[contains(@class,'2doB4z')]")).click();
		    
	}

	@When("user search mobile")
	public void user_search_mobile() {
		mobilename = "SAMSUNG";
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(mobilename,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
		
		WebElement e1 = driver.findElement(By.xpath("(//div[contains(text(),'"+mobilename+"')])[6]"));
	    name = e1.getText();
	    System.out.println(name);
	    e1.click();
	}


	@Then("user validate the mobile names")
	public void user_validate_the_mobile_names() {
		String p = driver.getWindowHandle();
		Set<String> c = driver.getWindowHandles();
		for(String x: c) {
			if(!p.equals(x)) {
				driver.switchTo().window(x);   
	}
    }
		WebElement e2 = driver.findElement(By.xpath("//span[contains(text(),'"+mobilename+"')]"));
		String name2 = e2.getText();
		System.out.println(name2);
		
		Assert.assertEquals(name , name2);
	}
	
	@When("user search mobile by One Dim List")
	public void user_search_mobile_by_One_Dim_List(DataTable dataTable) {
		List<String> datas = dataTable.asList();
		mobilename = datas.get(1);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(mobilename,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@When("user search mobile by One Dim Map")
	public void user_search_mobile_by_One_Dim_Map(DataTable dataTable) {
		Map<String, String> datas = dataTable.asMap(String.class, String.class);
		mobilename = datas.get("1");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(mobilename,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	
	@When("user search mobile by One Dim List {string}")
	public void user_search_mobile_by_One_Dim_List(String mobile) {
		mobilename = mobile ;
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(mobilename,Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    
	}
	
}
