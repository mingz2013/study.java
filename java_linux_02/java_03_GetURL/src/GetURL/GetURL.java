package GetURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GetURL {
	static protected void getURL(String u){
		URL url;
		InputStream is;
		InputStreamReader isr;
		BufferedReader   r;
		String str;
		try {
			System.out.println("reading url :" + u);
			url = new URL(u);
			is = url.openStream();
			isr = new InputStreamReader(is);
			r = new BufferedReader(isr);
			
			do {
				str = r.readLine();
				if(str != null)
					System.out.println(str);
			} while (str != null);
			
			
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println("Must enter a valid URL");
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Can't connect");
			
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length < 1){
			System.out.println("Usage: GetURL");
		}else{
			getURL(args[0]);
		}

	}

}
