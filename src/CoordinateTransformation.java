public class CoordinateTransformation {
	public static double ctX(int x){
		return ((double) (x - Data.oriX) / Data.POW);
	}

	public static double ctY(int y){
		return (double) (Data.oriY - y) / Data.POW;
	}

	public static int diX(double x){
		return (int)(x * Data.POW) + Data.oriX;
	}

	public static int diY(double y){
		return Data.oriY - (int)(y * Data.POW);
	}

	public static boolean test(double x, double y){
		return (((x <= 1) && (x >= -1)) && (y >= -1) && (y <= 1));
	}
}
