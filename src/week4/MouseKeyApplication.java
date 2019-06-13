package week4;

public class MouseKeyApplication extends NiceFrame {
	private MouseKeyPanel mouseKeyPanel = new MouseKeyPanel();
	public MouseKeyApplication() {
		super("Mouse and Key Events");
		add (mouseKeyPanel);
		mouseKeyPanel.setFocusable(true);
	}
	
	public static void main(String[] args) {
		MouseKeyApplication mkApp = new MouseKeyApplication();
		mkApp.display();
	}

}
