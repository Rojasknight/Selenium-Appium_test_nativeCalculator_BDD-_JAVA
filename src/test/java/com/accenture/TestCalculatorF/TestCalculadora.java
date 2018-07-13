package com.accenture.TestCalculatorF;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculadora {

	public static AppiumDriver<MobileElement> driver; //Este driver es el que contralara los eventos de la automatizacion
	DesiredCapabilities capabilities = new DesiredCapabilities(); //caracteristicas de la automatizacion

	@BeforeMethod
	public void setUpAppium() throws MalformedURLException, InterruptedException {
		String packagename = "com.google.android.calculator"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "com.android.calculator2.CalculatorGoogle"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		capabilities.setCapability("deviceName", "Moto G (5) Plus"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "ZY322P649N"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
		capabilities.setCapability("platformVersion", "7.0"); //No es obligatorio que la version coincida
		capabilities.setCapability("platformName", "Android"); //Nombre del sistema operativo
		capabilities.setCapability("appPackage", packagename);
		capabilities.setCapability("appActivity", activityname);
		driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@AfterTest
	public void CleanUpAppium() {
		driver.quit();
	}

	@Test
	public void mytest() throws InterruptedException {
		try {
			Thread.sleep(2000);
			
			
			for(Dato informacion: Excel.lectura()) {
				
				MobileElement number1 = null;
				MobileElement operator = null;
				MobileElement number2 = null;
				
				String cadena1 = Integer.toString(informacion.getNumber1());
				char[] numeros1 = cadena1.toCharArray();
				
				String cadena2 = Integer.toString(informacion.getNumber2());
				char[] numeros2 = cadena2.toCharArray();
				
				//
				
				//numero1
				for (int x=0;x<numeros1.length;x++) {
					number1 = driver.findElement(By.id("com.google.android.calculator:id/digit_" + numeros1[x]));
					number1.click();
				}
					  
				
				
				
				
				System.out.println(informacion.getNumber1());
				
				System.out.println(informacion.getOperator());
				
				System.out.println(informacion.getNumber2());
				//Operator
				switch(informacion.getOperator()) {
				
				
				case "*":
					operator = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
					operator.click();
			        break;
			        
			        
				case "/":
					operator = driver.findElement(By.id("com.google.android.calculator:id/op_div"));
					operator.click();
			        break;
			        
				case "-":
					operator = driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
					operator.click();
			        break;
				}
				
				
				
				
			//numero 2
			for (int x=0;x<numeros2.length;x++) {
				number2 = driver.findElement(By.id("com.google.android.calculator:id/digit_" + numeros2[x]));
				number2.click();
			}
				
			//Operator eq
		    MobileElement eq = driver.findElement(By.id("com.google.android.calculator:id/eq"));
			eq.click();
				
			Thread.sleep(2000);
		
			}
			
			
			
			MobileElement result = driver.findElementById("de.underflow.calc:id/Result");
			String textResult = result.getText();
			System.out.print(textResult);
		} catch (Exception e) {
			System.out.print("Se presento Excepción " + e);
		}
	}
}
