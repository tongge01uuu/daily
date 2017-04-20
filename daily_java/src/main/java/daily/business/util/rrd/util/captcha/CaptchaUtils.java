package daily.business.util.rrd.util.captcha;

import com.github.cage.Cage;
import com.github.cage.IGeneratorFactory;
import com.github.cage.token.RandomCharacterGeneratorFactory;
import com.github.cage.token.RandomTokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 验证码工具类
 * 
 * @author Johnny
 *
 */
public class CaptchaUtils {
	private static Logger log = LoggerFactory.getLogger(CaptchaUtils.class);
	
	private static RandomTokenGenerator generator;

	public static CaptchaImage createGImage() {
		Cage cage = new RRDGCage();
		
		String randomCode = genCaptchaCode();
		
		log.info("生成的验证码为 ："+randomCode);
		//System.out.println("生成的验证码为 ："+randomCode);
		
		CaptchaImage captcha = new CaptchaImage();
		byte bytes[] = cage.draw(randomCode);
		captcha.setCode(randomCode);
		captcha.setImage(bytes);
		
		return captcha;
	}
	
	public static CaptchaImage createYImage() {
		Cage cage = new RRDYCage();
		
		String randomCode = genCaptchaCode();
		
		log.info("生成的验证码为 ："+randomCode);
		System.out.println("生成的验证码为 ："+randomCode);
		
		CaptchaImage captcha = new CaptchaImage();
		byte bytes[] = cage.draw(randomCode);
		captcha.setCode(randomCode);
		captcha.setImage(bytes);
		
		return captcha;
	}
	
	/**
	 * 生成四位随机验证码
	 * @return
	 */
	public static String genCaptchaCode() {
		if (generator == null) {
			String codeStr = "23456789abcdefghjkmnprstuvwxyz23456789ABCDEFGHJKMNPRSTUVWXYZ23456789";
			IGeneratorFactory<Character> characterFactory = new RandomCharacterGeneratorFactory(codeStr.toCharArray(), RandomCharacterGeneratorFactory.DEFAULT_SPECIAL_CHARACTER_SETS, new Random());
			generator = new RandomTokenGenerator(new Random(), characterFactory, 4, 0);
		}

		String randomCode = generator.next();
		return randomCode;
	}
}
