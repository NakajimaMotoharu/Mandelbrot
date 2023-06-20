import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Draw extends JPanel implements MouseMotionListener {
	@Override
	public void paintComponent(Graphics g){
		for (int x = 0; x <= Data.W; x = x + 1){
			for (int y = 0; y <= Data.H; y = y + 1){
				if (Mandelbrot.getMap(x, y)){
					g.fillRect(x, y, 1, 1);
				}
			}
		}

		addMouseMotionListener(this);

		g.setColor(Color.red);
		ComplexNumber cnZ = new ComplexNumber(CoordinateTransformation.ctX(Data.oriX), CoordinateTransformation.ctY(Data.oriY));
		ComplexNumber cnO;
		ComplexNumber cnC = new ComplexNumber(CoordinateTransformation.ctX(Data.nowX), CoordinateTransformation.ctY(Data.nowY));
		for (int i = 0; i < Data.count; i = i + 1){
			cnO = cnZ;
			cnZ = Mandelbrot.func(cnO, cnC);
			g.drawLine(CoordinateTransformation.diX(cnO.getRe()), CoordinateTransformation.diY(cnO.getIm()), CoordinateTransformation.diX(cnZ.getRe()), CoordinateTransformation.diY(cnZ.getIm()));
		}

		g.setColor(Color.green);
		g.drawLine(0, Data.H / 2, Data.W, Data.H / 2);
		g.drawLine(Data.W / 2, 0, Data.W / 2, Data.H);
		g.setColor(Color.red);
		g.fillOval(CoordinateTransformation.diX(1.0) - 3, CoordinateTransformation.diY(0.0) - 3, 6, 6);
		g.fillOval(CoordinateTransformation.diX(-1.0) - 3, CoordinateTransformation.diY(0.0) - 3, 6, 6);
		g.fillOval(CoordinateTransformation.diX(0.0) - 3, CoordinateTransformation.diY(1.0) - 3, 6, 6);
		g.fillOval(CoordinateTransformation.diX(0.0) - 3, CoordinateTransformation.diY(-1.0) - 3, 6, 6);

		g.setColor(Color.BLACK);
		g.drawString(String.format("Count = %d", Data.count), 10, 10);
		g.drawString(String.format("Coordinate(mouse) = (%d, %d)", Data.nowX, Data.nowY), 10, 20);
		g.drawString(String.format("Coordinate(complex) = (%f, %f)", CoordinateTransformation.ctX(Data.nowX), CoordinateTransformation.ctY(Data.nowY)), 10, 30);
		g.drawString(String.format("Convergence = %s", Mandelbrot.getMap(Data.nowX, Data.nowY)), 10, 40);
	}

	@Override
	public void mouseDragged(MouseEvent e){
	}

	@Override
	public void mouseMoved(MouseEvent e){
		Data.nowX = e.getX();
		Data.nowY = e.getY();
	}
}
