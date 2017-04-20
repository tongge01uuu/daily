package daily.business.util.rrd.util.captcha;

/**
 * 图片验证码
 * @author Johnny
 *
 */
public class CaptchaImage {

	/**
	 * 验证码
	 */
	private String code;
	/**
	 * 验证码图片
	 */
	private byte[] image;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
