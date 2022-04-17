package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class firefoxStandAloneTest {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capab = DesiredCapabilities.firefox();
//		capab.setBrowserName("firefox");
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,capab);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle()); 
	}
}
