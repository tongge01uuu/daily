package daily.business.util.rrd.util.captcha;

import com.github.cage.Cage;
import com.github.cage.ObjectRoulette;
import com.github.cage.image.ConstantColorGenerator;
import com.github.cage.image.EffectConfig;
import com.github.cage.image.Painter;
import com.github.cage.image.ScaleConfig;
import com.github.cage.token.RandomCharacterGeneratorFactory;
import com.github.cage.token.RandomTokenGenerator;

import java.awt.*;
import java.util.Locale;
import java.util.Random;

public class RRDYCage extends Cage {
	/**
	 * Height of CAPTCHA image.
	 */
	protected static final int HEIGHT = 30;

	/**
	 * Width of CAPTCHA image.
	 */
	protected static final int WIDTH = 70;

	/**
	 * Character set supplied to the {@link RandomTokenGenerator} used by this
	 * template.
	 */
	protected static final char[] TOKEN_DEFAULT_CHARACTER_SET = (new String(RandomCharacterGeneratorFactory.DEFAULT_DEFAULT_CHARACTER_SET).replaceAll(
			"b|f|i|j|l|m|o|t", "")
			+ new String(RandomCharacterGeneratorFactory.DEFAULT_DEFAULT_CHARACTER_SET).replaceAll("c|i|o", "").toUpperCase(Locale.ENGLISH) + new String(
			RandomCharacterGeneratorFactory.ARABIC_NUMERALS).replaceAll("0|1|9", "")).toCharArray();

	/**
	 * Minimum length of token.
	 */
	protected static final int TOKEN_LEN_MIN = 6;

	/**
	 * Maximum length of token is {@value #TOKEN_LEN_MIN} +
	 * {@value #TOKEN_LEN_DELTA}.
	 */
	protected static final int TOKEN_LEN_DELTA = 2;

	/**
	 * Constructor.
	 */
	public RRDYCage() {
		this(new Random());
	}

	/**
	 * Constructor.
	 * 
	 * @param rnd
	 *            object used for random value generation. Not null.
	 */
	protected RRDYCage(Random rnd) {
		/*int defFontHeight = 22;
		
		IGenerator<Font> fonts = new ObjectRoulette<Font>(rnd, //
				new Font(Font.SANS_SERIF, Font.PLAIN, defFontHeight), //
				// new Font(Font.SANS_SERIF, Font.ITALIC, defFontHeight),//
				new Font(Font.SERIF, Font.PLAIN, defFontHeight), //
				// new Font(Font.SERIF, Font.ITALIC, defFontHeight), //
				new Font(Font.MONOSPACED, Font.BOLD, defFontHeight));*/
		super(new Painter(WIDTH, HEIGHT, Color.white, null, new EffectConfig(true, true, true, false, new ScaleConfig(1.0f, 1.0f)), rnd), new ObjectRoulette<Font>(rnd, //
				new Font(Font.MONOSPACED, 5, 100)),
				new ConstantColorGenerator(Color.BLACK), null, Cage.DEFAULT_COMPRESS_RATIO, new RandomTokenGenerator(rnd, new RandomCharacterGeneratorFactory(
						TOKEN_DEFAULT_CHARACTER_SET, null, rnd), TOKEN_LEN_MIN, TOKEN_LEN_DELTA), rnd);
	}
}
