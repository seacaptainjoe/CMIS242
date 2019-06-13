package week4;

public class SketchApplication extends NiceFrame {
	private SketchPanel sketchPanel = new SketchPanel();
	public SketchApplication () {
		super("Sketcher");
		add(sketchPanel);
	}
	
	public static void main(String[] args) {
		SketchApplication skApp = new SketchApplication();
		skApp.display();
	}
}
