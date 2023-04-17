package utils;

import java.io.*;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;

import constants.FindElement.ElementType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	// Create dynamic web driver method
	public static WebDriver driver() {
		WebDriver driver = null;

		try {
			String browser = configProperty("browser").toString();
			String url = configProperty("url").toString();

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				EdgeOptions options = new EdgeOptions();
				// options.addArguments("--disable-notifications");
				driver = new EdgeDriver(options);
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--disable-notifications");
				driver = new FirefoxDriver(options);
			}
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return driver;
	}

	// Get Configuration File Properties
	public static Object configProperty(String property) throws Exception {
		File f = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\environment\\config.properties");

		if (f.exists()) {
			FileInputStream fs = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fs);
			return prop.getProperty(property);
		}
		return "!!config file is missing!!";
	}

	// Get All Properties Files
	public static String props(String property) throws Exception {
		File f = new File(System.getProperty("user.dir") + "/src/main/resources/properties");
		File[] files = f.listFiles();

		Properties prop = new Properties();

		for (int i = 0; i < files.length; i++) {
			FileInputStream fs = new FileInputStream(files[i]);
			prop.load(fs);
		}

		return prop.getProperty(property);
	}

	// Get Properties Files
	private static Properties properties(String property) throws Exception {
		File f = new File(System.getProperty("user.dir") + "/src/main/resources/properties");
		File[] files = f.listFiles();

		Properties prop = new Properties();

		for (int i = 0; i < files.length; i++) {
			FileInputStream fs = new FileInputStream(files[i]);
			prop.load(fs);
		}

		return prop;
	}

	// Create dynamic web element method
	private static WebElement webElement(WebDriver driver, String findElement, ElementType elementType) {
		WebElement element = null;

		switch (elementType) {
		case Id:
			element = driver.findElement(By.id(findElement));
			break;

		case Name:
			element = driver.findElement(By.name(findElement));
			break;

		case Class:
			element = driver.findElement(By.className(findElement));
			break;

		case Tag:
			element = driver.findElement(By.tagName(findElement));
			break;

		case XPath:
			element = driver.findElement(By.xpath(findElement));
			break;
		}

		return element;
	}

	// Create WebElement
	public static WebElement elementManager(WebDriver driver, String property, ElementType elementType)
			throws Exception {
		Properties prop = null;
		WebElement element = null;

		try {
			prop = properties(property);
			for (int i = 0; i < prop.keySet().size(); i++) {
				String str = prop.keySet().toArray()[i].toString();
System.out.println(str);
				if (str.endsWith("id")) {
					element = webElement(driver, prop.getProperty(property), elementType);
				} else if (str.endsWith("name")) {
					element = webElement(driver, prop.getProperty(property), elementType);
				} else if (str.endsWith("class")) {
					element = webElement(driver, prop.getProperty(property), elementType);
				} else if (str.endsWith("tag")) {
					element = webElement(driver, prop.getProperty(property), elementType);
				}else if (str.endsWith("xpath")) {
					element = webElement(driver, prop.getProperty(property), elementType);
				}
				else {
					System.out.println("Locator extension is missing!");
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

		return element;
	}
}