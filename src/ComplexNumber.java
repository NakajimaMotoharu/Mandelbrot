public class ComplexNumber {
	private double re = 0, im = 0, abs = 0.0;

	public ComplexNumber(double re, double im){
		this.re = re;
		this.im = im;
		abs = Math.sqrt(re * re + im * im);
	}

	public double getRe(){
		return re;
	}

	public double getIm() {
		return im;
	}

	public double getAbs() {
		return abs;
	}
}
