package daily.business.util.rrd.util.captcha;

import com.github.cage.Cage;
import com.github.cage.ObjectRoulette;
import com.github.cage.image.EffectConfig;
import com.github.cage.image.Painter;
import com.github.cage.image.Painter.Quality;
import com.github.cage.image.ScaleConfig;

import java.awt.*;
import java.util.Random;

public class RRDGCage extends Cage{

	public RRDGCage(){
		this(genPainter());
	}
	
	public RRDGCage(Painter painter){
		super(painter, new ObjectRoulette<Font>(new Random(),new Font("Consolas", Font.PLAIN, painter.getHeight()/2)), new RRDColorGenerator(), null, DEFAULT_COMPRESS_RATIO, null, null);
	}
	
	private static Painter genPainter(){
		Color bGround = Color.WHITE;
		Quality quality = Quality.MAX;
		ScaleConfig scaleConfig = new ScaleConfig(1.0f, 1.0f);
		EffectConfig effectConfig = new EffectConfig(true,false,false,true,scaleConfig);
		Painter painter = new Painter(70, 30, bGround, quality, effectConfig, null);
		return painter;
	}
}
