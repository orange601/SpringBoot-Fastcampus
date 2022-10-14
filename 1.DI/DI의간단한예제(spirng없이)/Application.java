package svg;

public class Application {
	public static void main(String[] args) {
		String url = "www.naver.com";
		
		Encoder encoder = new Encoder(new Base64Encoder());
		//Encoder encoder = new Encoder(new UrlEncoder());
		String result1 = encoder.encode(url);
		
		System.out.println(result1);
	}

}
