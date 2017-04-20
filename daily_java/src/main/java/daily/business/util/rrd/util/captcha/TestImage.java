package daily.business.util.rrd.util.captcha;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestImage {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("d:/captcha.jpg", false);
		CaptchaImage image = CaptchaUtils.createGImage();
		os.write(image.getImage());
	}
}
