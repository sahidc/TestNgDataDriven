package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasic {
	public WebDriver d;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
         d=new ChromeDriver();
       
	}
	@BeforeMethod
	public void enter_url() {
		d.get("https://ui.cogmento.com/");
	}
	
	@Test
	public void Login() throws IOException, InterruptedException
	{
		 FileInputStream fis=new FileInputStream("C:\\Users\\Mashuda\\Desktop\\Book1.xlsx");
	        XSSFWorkbook wb=new XSSFWorkbook(fis);
	        XSSFSheet s=wb.getSheet("Sheet1");
	        System.out.println("Sheet Name::"+s.getSheetName());
	        XSSFCell cell1=s.getRow(1).getCell(0);
	        String username=cell1.getStringCellValue();
	        XSSFCell cell2=s.getRow(1).getCell(1);
	        String password=cell2.getStringCellValue();
	        d.findElement(By.name("email")).sendKeys(username);
	        d.findElement(By.name("password")).sendKeys(password);
	        Thread.sleep(3000);
	        d.findElement(By.xpath("//div[@class=\"ui fluid large blue submit button\"]")).click();
	        System.out.println("Login Completed");
	       
	        
	}
	@AfterMethod
	public void Logout() throws InterruptedException {
		
		d.findElement(By.xpath("//*[@id=\"main-nav\"]/a[3]/span")).click();;
		Thread.sleep(3000);
       /* Actions a=new Actions(d);
		a.moveToElement(e).build().perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[@class='text']")).click();*/
	}

}
