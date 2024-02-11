import javax.swing.JFrame;

public class MyFrame extends JFrame{

	DragPanel dragPanel = new DragPanel();
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setTitle("Drag and Drop");
		
		this.add(dragPanel);
		this.setVisible(true);
	}
}
