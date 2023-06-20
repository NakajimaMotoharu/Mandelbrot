public class ComplexCalc {
	public static ComplexNumber add(ComplexNumber a, ComplexNumber b){
		return new ComplexNumber(a.getRe() + b.getRe(), a.getIm() + b.getIm());
	}

	public static ComplexNumber mul(ComplexNumber a, ComplexNumber b){
		double re = a.getRe() * b.getRe() - a.getIm() * b.getIm();
		double im = a.getRe() * b.getIm() + a.getIm() * b.getRe();

		return new ComplexNumber(re, im);
	}
}
