public class MandelbrotThread extends Thread{
	public int st, en;

	public MandelbrotThread(int st, int en){
		this.st = st;
		this.en = en;
	}

	@Override
	public void run(){
		for (int i = st; i < en; i = i + 1){
			int x = i % Data.W;
			int y = i / Data.W;
			Mandelbrot.setMap(x, y, Mandelbrot.pointAbs(new ComplexNumber(CoordinateTransformation.ctX(x), CoordinateTransformation.ctY(y))));
		}
	}
}
