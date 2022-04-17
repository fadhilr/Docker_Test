package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromeTest3 {

	@Test
	public void test3() throws MalformedURLException {
		DesiredCapabilities capab = DesiredCapabilities.chrome();

		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, capab);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}
}
