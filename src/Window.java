import javax.swing.*;

public class Window extends JFrame {
	public Window(){
		setTitle("Mandelbrot");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Data.W, Data.H);

		add(new Draw());

		setVisible(true);
	}
}
