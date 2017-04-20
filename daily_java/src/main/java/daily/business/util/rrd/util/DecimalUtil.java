package daily.business.util.rrd.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 浮点数的精度问题
 * 用于替换BigDecimal类来计算
 * 默认精度为: 3
 * 默认ROUNDINGMODE为ROUND_HALF_EVEN( 0-4舍, 5不变, 6-9入)
 * 加减乘法结果的精度: 取因子里精度最大值
 * 除法结果的精度:
 * 能整除: 	直接整除
 * 除不尽: 	四舍五入的结果为0时, 继续提高精度计算到一个不为零的结果, 例如0.000001/3
 * 			Max(结果, 因子里精度最大值), 例如1/3
 * 			当取了精度后还除不尽或出现算术异常时, 尝试逐步减少精度直到不出现算术异常
 * 当出现除数为零或是除数被除数都为零的情况时, 返回defaultValue(0)
 * @author luzongwei
 *
 */
public final class DecimalUtil {

	/**
	 * 默认数字精度
	 */
	public static int DEFAULT_DIGITS = 3;

	public static final int DEFAULT_ROUNDINGMODE = BigDecimal.ROUND_HALF_EVEN;

	public final String DEFAULT_VALUE = "0";

	private BigDecimal number = null;

	private int scale = DEFAULT_DIGITS;

	private int roundingMode = DEFAULT_ROUNDINGMODE;

//	public DecimalUtil(Integer num) {
//		if (num == null) {
//			num = 0;
//		}
//		setScale(0);
//		number = new BigDecimal(Integer.toString(num));
//	}
//
//	public DecimalUtil(Long num) {
//		if (num == null) {
//			num = 0L;
//		}
//		setScale(0);
//		number = new BigDecimal(Long.toString(num));
//	}

//	public DecimalUtil(Float num) {
//		if (num == null) {
//			num = 0F;
//		}
//		setScale(getMaxScale(num));
//		number = new BigDecimal(Float.toString(num));
//	}

//	public DecimalUtil(Double num) {
//		if (num == null) {
//			num = 0D;
//		}
//		setScale(getMaxScale(num));
//		number = new BigDecimal(Double.toString(num));
//	}

	/**
	 * 参数为null或无法转换为数字时, 默认赋值0
	 * 默认数字精度为3
	 * 默认ROUNDINGMODE为ROUND_HALF_EVEN
	 * @param num
	 */
	public DecimalUtil(Object num) {
		if (num == null) {
			num = "0";
		}
		String num_str = num.toString();

		try {
			num_str = DecimalUtil.toStringNoScientificNotation(num);
			Double.parseDouble(num_str);
			number = new BigDecimal(num_str);
			setRoundingMode(DEFAULT_ROUNDINGMODE);
			if (num instanceof DecimalUtil) {
				setScale(Math.max(getMaxScale(num_str), ((DecimalUtil) num).getScale()));
				setRoundingMode(((DecimalUtil) num).getRoundingMode());
			} else if (num instanceof BigDecimal) {
				setScale(Math.max(getMaxScale(num_str), ((BigDecimal) num).scale()));
			} else {
				setScale(getMaxScale(num_str));
			}
		} catch (Throwable t) {
			number = new BigDecimal(String.valueOf(0D));
			setScale(getMaxScale(num_str));
		}
		number = number.setScale(scale, roundingMode);
	}

//	public DecimalUtil(String num) {
//		try {
//			Double.parseDouble(num);
//			number = new BigDecimal(num);
//		} catch (Throwable t) {
//			number = new BigDecimal(String.valueOf(0D));
//		}
//		setScale(getMaxScale(num));
//	}

//	public DecimalUtil(BigDecimal num) {
//		if (num == null) {
//			num = new BigDecimal(String.valueOf(0D));
//		} else {
//			number = num;
//			this.scale = num.scale();
//		}
//	}

	public DecimalUtil add(DecimalUtil num) {
		return new DecimalUtil(number.add(new BigDecimal(num.toString())));
	}

	public DecimalUtil add(Object num) {
		return add(new DecimalUtil(num));
	}

	public DecimalUtil subtract(DecimalUtil num) {
		return new DecimalUtil(number.subtract(new BigDecimal(num.toString())));
	}

	public DecimalUtil subtract(Object num) {
		return subtract(new DecimalUtil(num));
	}

	public DecimalUtil multiply(DecimalUtil num) {
		return new DecimalUtil(number.multiply(new BigDecimal(num.toString())));
	}

	public DecimalUtil multiply(Object num) {
		return multiply(new DecimalUtil(num));
	}

	public DecimalUtil divide(DecimalUtil num, int scale) {
		return divide(num, scale, DecimalUtil.DEFAULT_ROUNDINGMODE, "0");
	}

	/**
	 * @param num
	 * @param scale
	 * @param roundingMode
	 * @param defaultValue
	 * @return
	 */
	public DecimalUtil divide(DecimalUtil num, int scale, int roundingMode, String defaultValue) {
		BigDecimal db = null;
		try {
			db = number.divide(new BigDecimal(num.toString())); // , Math.max(getScale(), num.getScale())
		} catch (ArithmeticException e) {
			if (e.getMessage().indexOf("zero") >= 0 // Division by zero
					|| e.getMessage().indexOf("Division undefined") >= 0) { // NaN 0/0 Division undefined
				return new DecimalUtil(defaultValue);
			} else if (e.getMessage().indexOf("Rounding necessary") >= 0 // Rounding necessary
					|| e.getMessage().indexOf("Non-terminating") >= 0) { // Non-terminating decimal expansion; no exact representable decimal result.
				int minscale = scale;
				boolean notFinishYet = true;
				do {
					try {
						db = number.divide(new BigDecimal(num.toString()), minscale, getRoundingMode());
						if (db.doubleValue() == 0D) { // 四舍五入的结果为0时, 继续提高精度计算到一个不为零的结果, 例如0.000001/3
							++minscale;
							continue;
						}
						notFinishYet = false;
					} catch (ArithmeticException e2) { // 当取了精度后还除不尽或出现算术异常时, 尝试逐步减少精度直到不出现算术异常
						notFinishYet = true;
						--minscale;
						if (scale < 0) {
							return new DecimalUtil(defaultValue).setScale(minscale);
						}
					}
				} while (notFinishYet);
				return new DecimalUtil(db).setScale(minscale);
			}
		}
		return new DecimalUtil(db).setScale(Math.max(getScale(), db.scale()));
	}

	public DecimalUtil divide(Object num, int scale, int roundingMode, Object defaultValue) {
		return divide(new DecimalUtil(num), scale, roundingMode, defaultValue);
	}

	public DecimalUtil divide(DecimalUtil num) {
		return divide(num, Math.max(getScale(), num.getScale()), getRoundingMode(), DEFAULT_VALUE);
	}

	public DecimalUtil divide(Object num) {
		return divide(new DecimalUtil(num), Math.max(getScale(), new DecimalUtil(num).getScale()), getRoundingMode(), DEFAULT_VALUE);
	}

	/**
	 * 取得数字的最大精度, 既小数点后的位数
	 * @param number
	 * @return
	 */
	public static int getMaxScale(Object number) {
		return getMaxScale(String.valueOf(number));
	}

	/**
	 * 取得数字的最大精度, 既小数点后的位数
	 * @param number
	 * @return
	 */
	public static int getMaxScale(String number) {
		if (!StringUtils.isBlank(number)) {
			try {
				number = number.trim();
				Double.parseDouble(number);
				if (number.indexOf(".") < 0) {
					return 0;
				}
				return number.length() - number.indexOf(".") - 1;
			} catch (Throwable t) {
				// do nothing
			}
		}
		return 0;
	}

	/**
	 * 不使用科学计数法的toString
	 * @param num
	 */
	public String toString() {
		return DecimalUtil.toStringNoScientificNotation(this.number.toString());
	}

	/**
	 * 不使用科学计数法的toString BigDecimal
	 * @param num
	 */
	public static String toStringNoScientificNotationBigDecimal(Object num) {
		if(num==null)return null;

		if (num instanceof String) {
			try {
				if(num!=null && !"".equals(num)){

				}else{
					return "";
				}

			} catch (Exception e) {
				return "";
			}
		}
//		if (num instanceof DecimalUtil) {
//			num = ((DecimalUtil) num).doubleValue();
//		}
		String num_str = num.toString();
//		System.out.println("num.toString=" + num_str);
		if (num_str.indexOf("E") >= 0) {
			//Double scientific_base = Double.parseDouble(num_str.split("E")[0]);
			BigDecimal scientific_base = new BigDecimal(num_str.split("E")[0]);
			Integer scientific_digit = Math.abs(Integer.parseInt(num_str.split("E")[1].replaceAll("\\+", "")));
//			System.out.println("scientific_base=" + scientific_base);
//			System.out.println("scientific_digit=" + scientific_digit);
			StringBuffer format = new StringBuffer();
			for (int i = 0; i < scientific_base.toString().length()- 1 + scientific_digit; i++) {
				format.append("#");
			}
			format.append(".");
			for (int i = 0; i < scientific_base.toString().length()- 1 + scientific_digit; i++) {
				format.append("#");
			}
//			System.out.println("format=" + format);
			//DecimalFormat df = new DecimalFormat(format.toString());
//			try {
//				num_str = df.format(num);
//			} catch (Exception e) {
//				return num.toString();
//			}
			BigDecimal bg = new BigDecimal(format.toString());
			num_str = bg.toString();
		}
//		System.out.println(num_str);
		return num_str;
	}
	/**
	 * 不使用科学计数法的toString
	 * @param num
	 */
	public static String toStringNoScientificNotation(Object num) {
		String num_str = num.toString();
		if (num instanceof String) {
			try {
				num = Double.parseDouble((String) num);
				num_str = String.valueOf(num);
			} catch (Exception e) {
				return (String) num;
			}
		}
		if (num instanceof DecimalUtil) {
			num = ((DecimalUtil) num).doubleValue();
		}

//		System.out.println("num.toString=" + num_str);
		if (num_str.indexOf("E") >= 0) {
			Double scientific_base = Double.parseDouble(num_str.split("E")[0]);
			Integer scientific_digit = Math.abs(Integer.parseInt(num_str.split("E")[1].replaceAll("\\+", "")));
//			System.out.println("scientific_base=" + scientific_base);
//			System.out.println("scientific_digit=" + scientific_digit);
			StringBuffer format = new StringBuffer();
			for (int i = 0; i < scientific_base.toString().length()- 1 + scientific_digit; i++) {
				format.append("#");
			}
			format.append(".");
			for (int i = 0; i < scientific_base.toString().length()- 1 + scientific_digit; i++) {
				format.append("#");
			}
//			System.out.println("format=" + format);
			DecimalFormat df = new DecimalFormat(format.toString());
			try {
				num_str = df.format(num);
			} catch (Exception e) {
				return num.toString();
			}
		}
//		System.out.println(num_str);
		return num_str;
	}

	public BigDecimal decimalValue(){
		return number;
	}

	public double doubleValue() {
		return number.doubleValue();
	}

	public double floatValue() {
		return number.floatValue();
	}

	public double intValue() {
		return number.intValue();
	}

	public double longValue() {
		return number.longValue();
	}

	public int getScale() {
		return scale;
	}

	public DecimalUtil setScale(int scale) {
		this.scale = scale;
		number = number.setScale(scale, roundingMode);
		return this;
	}

	public int getRoundingMode() {
		return roundingMode;
	}

	public DecimalUtil setRoundingMode(int roundingMode) {
		this.roundingMode = roundingMode;
		return this;
	}

	public boolean equals(Object x) {
		return number.equals(x);
	}

	public boolean isZero() {
		return doubleValue() == 0;
	}

	public int compareTo(Object obj) {
		return this.number.compareTo(new DecimalUtil(obj).number);
	}

	public static String formatBigDecimal(BigDecimal bd, String defaultValue) {
		if (bd == null) {
			return defaultValue;
		}
		try {
			String s = bd.toString();
			if ("0E-16".equals(s)) {
				return "0";
			} else {
				if (s.indexOf(".") > 0) {
					if (s.split("\\.")[1].lastIndexOf("0") == s.split("\\.")[1].length() - 1) {
						String d = new StringBuffer(new StringBuffer(s.split("\\.")[1]).reverse().toString().replaceAll("^[1-9]*[0]+", "")).reverse().toString();
						return s.split("\\.")[0] + ("".equals(d) ? "" : ".") + d;
//						return s + "!bingo{" + s.split("\\.")[0] + ("".equals(d) ? "" : ".") + d + "}";
					}
				}
			}
		} catch (Exception e) {
			return bd.toString();
		}
		return bd.toString();
	}

	public static String formatBigDecimal(BigDecimal bd) {
		return DecimalUtil.formatBigDecimal(bd, "");
	}
	//to show fund style '.00'
	public static String formatNumber(Object obj) {
		String str = obj.toString();
		if ("0E-16".equals(str)) {
			return "0.00";
		} else {
			if(obj instanceof String){
				//页面保留两位小数
				obj = new BigDecimal((String)obj).setScale(2, BigDecimal.ROUND_HALF_DOWN);//wonderhang modify code用于小数点后两位，四舍五入
			}
			NumberFormat nf = NumberFormat.getInstance();

			nf.setMaximumFractionDigits(320);
			nf.setMinimumFractionDigits(2); // 最小小数位
			return replaceComma(nf.format(obj));
		}
	}

	public static String replaceComma(String str) {
		String result="";
		if (str != null) {
			result = str.replaceAll(",", "");
			return result;
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(formatBigDecimal(new BigDecimal("1000.00"),""));
	}
}