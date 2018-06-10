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
		String packagename = "de.underflow.calc"; //Paquete principal de la aplicacion a automatizar
		String URL = "http://127.0.0.1:4723/wd/hub"; //IP y puerto de Appium
		String activityname = "de.underflow.calc.CalculatorMainActivity"; //Nombre de la actividad (o vista) en donde empezara la automatizacion
		capabilities.setCapability("deviceName", "Moto G (5) Plus"); //No es obligatorio que este nombre coincida
		capabilities.setCapability("udid", "ZY224CTP8L"); //Serial del dispositivo, se obtiene activando la depuración USB y con el comando adb devices
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
			// hacer click boton2
			MobileElement num2 = driver.findElement(By.id("de.underflow.calc:id/Two"));
			num2.click();

			// hacer click boton mas( +)
			MobileElement mas = driver.findElement(By.id("de.underflow.calc:id/Plus"));
			mas.click();

			// hacer click boton9
			MobileElement num9 = driver.findElement(By.id("de.underflow.calc:id/Nine"));
			num9.click();

			// hacer click boton mas( +)
			MobileElement mas1 = driver.findElement(By.id("de.underflow.calc:id/Plus"));
			mas1.click();

			// hacer click boton8
			MobileElement num8 = driver.findElement(By.id("de.underflow.calc:id/Eight"));
			num8.click();

			// hacer click botonigual
			MobileElement igual = driver.findElement(By.id("de.underflow.calc:id/Equals"));
			igual.click();

			// hacer click botonigual
			MobileElement dividido = driver.findElement(By.id("de.underflow.calc:id/Divide"));
			dividido.click();

			// hacer click boton 2
			MobileElement numdos = driver.findElement(By.id("de.underflow.calc:id/Two"));
			numdos.click();

			// hacer click boton =
			MobileElement igual2 = driver.findElement(By.id("de.underflow.calc:id/Equals"));
			igual2.click();

			MobileElement result = driver.findElementById("de.underflow.calc:id/Result");
			String textResult = result.getText();
			System.out.print(textResult);
		} catch (Exception e) {
			System.out.print("Se presento Excepción " + e);
		}
	}
}
