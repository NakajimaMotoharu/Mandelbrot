import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main(String[] args) {
		Data.count = 256;
		Mandelbrot.init(Data.count);
		Mandelbrot.calcMap(4);

		Window window = new Window();

		Timer timer = new Timer(false);
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				window.repaint();
			}
		};
		timer.schedule(timerTask, 0, 1000 / 60);
	}
}