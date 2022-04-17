package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class stopDocker {
	
	public void stopFile() throws IOException, InterruptedException {

		// runing file dockerUp.bat
		Runtime runTime = Runtime.getRuntime();
		runTime.exec("cmd /c start dockerDown.bat");

		// flagging for information that the node already registered to the hub
		boolean flag = false;
		String file = "outputLog.txt";

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
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			while (currentLine != null && !flag) {
				if (currentLine.contains("selenium-hub exited")) {
					System.out.println("Found my expect text");
					flag = true;
					break;
				}
				currentLine = reader.readLine();
			}
			reader.close();
		}
		Assert.assertTrue(flag);
		File fileDelete = new File("C:\\Users\\lawencon\\eclipse-workspace1\\dockerValidation\\outputLog.txt");
		if (fileDelete.delete()) {
			System.out.println("File deleted successfully");
		}
	}
}
