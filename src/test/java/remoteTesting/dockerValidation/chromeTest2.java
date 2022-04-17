package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromeTest2 {

	@Test
	public void test2() throws MalformedURLException {
		DesiredCapabilities capab = DesiredCapabilities.chrome();
//		capab.setBrowserName("firefox");
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,capab);
		driver.get("http://www.gmail.com");
		System.out.println(driver.getTitle()); 
	}
}
