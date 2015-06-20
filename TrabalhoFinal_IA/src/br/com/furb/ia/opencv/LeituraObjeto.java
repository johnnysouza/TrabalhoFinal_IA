package br.com.furb.ia.opencv;

import java.awt.Rectangle;
import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class LeituraObjeto {

	private Mat imagem;

	public void lerImagem(String path) {
		File file = new File(path);
		if (file.exists()) {
			imagem = Imgcodecs.imread(file.getAbsolutePath());
		} else {
			System.err.println("Arquivo não existe");
		}
	}

	public Mat getImagem() {
		return imagem;
	}

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		LeituraObjeto teste = new LeituraObjeto();
		teste.lerImagem("images/quadrado2.jpg");

		// MatOfPoint mat =
		// MatOfPoint.fromNativeAddr(teste.getImagem().getNativeObjAddr());
		// MatOfPoint matOfPoint = new MatOfPoint(teste.getImagem());
		MatOfPoint matOfPoint = new MatOfPoint();
		teste.getImagem().assignTo(matOfPoint);
		Rect r = Imgproc.boundingRect(matOfPoint);
		Rectangle boundingBox = new Rectangle(r.x, r.y, r.width, r.height);
		System.out.println(boundingBox);
	}

}
