package remoteTesting.dockerValidation;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chromeTest1 {

	@BeforeTest
	public void startDocker() throws IOException, InterruptedException {
		
		startDocker s = new startDocker();
		s.startFile();
	}

	@AfterTest
	public void stoptDocker() throws IOException, InterruptedException {
		stopDocker d = new stopDocker();
		d.stopFile();
	}

	@Test
	public void test1() throws MalformedURLException {
		DesiredCapabilities capab = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, capab);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}
}
