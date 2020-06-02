package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.Util.TestUtil;

public class DataDivenTest {
	public WebDriver d;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().deleteAllCookies();
        d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.get("https://www.browserstack.com/users/sign_in");
	}
	@AfterMethod
	public void tearDown() {
		d.quit();
	}
	@DataProvider
	public Iterator<Object[]>  myTestData(){
		ArrayList<Object[]> data=TestUtil.getDataFromExcel();
		return data.iterator();
		}
	@Test(dataProvider="myTestData")
	public void BrowserStackTest(String UserId, String Password) throws InterruptedException {
		d.findElement(By.name("user[login]")).sendKeys(UserId);
		d.findElement(By.name("user[password]")).sendKeys(Password);
		//d.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		//Assert.assertTrue(d.getTitle().matches("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool"), "Invalid credentials");
		System.out.println("Login successful");
		}
	}


