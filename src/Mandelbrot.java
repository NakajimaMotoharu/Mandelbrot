public class Mandelbrot {
	public static int loop;
	public static boolean[][] map = new boolean[Data.H][Data.W];

	public static void init(int n){
		loop = n;
	}

	public static ComplexNumber func(ComplexNumber z, ComplexNumber c){
		return ComplexCalc.add(ComplexCalc.mul(z, z), c);
	}

	public static ComplexNumber coreLoop(ComplexNumber a){
		ComplexNumber z = new ComplexNumber(0, 0);

		for (int i = 0; i < loop; i = i + 1){
			z = func(z, a);
		}

		return z;
	}

	public static void calcMap(){
		for (int x = 0; x < Data.W; x = x + 1){
			for (int y = 0; y < Data.H; y = y + 1){
				setMap(x, y, pointAbs(new ComplexNumber(CoordinateTransformation.ctX(x), CoordinateTransformation.ctY(y))));
			}
		}
	}

	public static void calcMap(int th){
		int s = Data.H * Data.W;
		int val = s / th;
		if (s % th != 0){
			val = val + 1;
		}

		MandelbrotThread[] mandelbrotThreads = new MandelbrotThread[th];
		for (int i = 0, j = 0; i < s; i = i + val, j = j + 1){
			if (i + val >= s){
				mandelbrotThreads[j] = new MandelbrotThread(i, s);
			} else {
				mandelbrotThreads[j] = new MandelbrotThread(i, i + val);
			}
			mandelbrotThreads[j].start();
		}
		for (int i = 0; i < th; i = i + 1){
			try {
				mandelbrotThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean inMap(int x, int y){
		return (((x >= 0) && (x < Data.W)) && ((y >= 0) && (y < Data.H)));
	}

	public static boolean getMap(int x, int y){
		if (inMap(x, y)){
			return map[y][x];
		}
		return false;
	}

	public static void setMap(int x, int y, boolean n){
		if (inMap(x, y)){
			map[y][x] = n;
		}
	}

	public static boolean pointAbs(ComplexNumber a){
		return (coreLoop(a).getAbs() < 1);
	}
}
