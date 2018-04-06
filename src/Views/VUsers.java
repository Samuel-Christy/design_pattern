package Views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VUsers {

	public void write(String txt) {
		System.out.println(txt);
	}

	public String read() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			String s = br.readLine();
			if ("exit".equalsIgnoreCase(s)) {
				System.exit(0);
			}

			return s;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
