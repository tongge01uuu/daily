package daily.business.util.rrd.util.captcha;

import com.github.cage.IGenerator;

import java.awt.*;

public class RRDColorGenerator implements IGenerator<Color> {

	private Color colors[] = { Color.BLACK };

	@Override
	public Color next() {
		int index = ((int) (Math.random() * 10000)) & (colors.length-1);
		return colors[index];
	}
}
