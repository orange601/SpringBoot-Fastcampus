package svg;

import java.util.Base64;

public class Base64Encoder implements IEncoder {

	@Override
	public String encode(String msg) {
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}

}
