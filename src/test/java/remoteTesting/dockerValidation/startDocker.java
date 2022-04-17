package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class startDocker {
	
	public void startFile() throws IOException, InterruptedException {

		// runing file dockerUp.bat
		Runtime runTime = Runtime.getRuntime();
		runTime.exec("cmd /c start dockerUp.bat");

		// flagging for information that the node already registered to the hub
		boolean flag = false;
		String f = "outputLog.txt";

		// geting current timestamp
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 30);// tambah timestamp skrg dgn 30 dtk
		long stopnow = cal.getTimeInMillis(); // get time stelah ditambah

		while (System.currentTimeMillis() < stopnow) {
			//cek jika string yang dicari sudah ditemukan, maka perulangan distop
			if (flag) {
				break;
			}
			// membaca file outputLog untuk di cek apakah terdapat string yang diinginkan
			// ketika sukses
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String currentLine = reader.readLine();
			while (currentLine != null && !flag) {
				if (currentLine.contains("Node has been added")) {
					System.out.println("Found my expect text");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();
		}
		Assert.assertTrue(flag);
		runTime.exec("cmd /c start scale.bat");
		Thread.sleep(15000);
	}
}
