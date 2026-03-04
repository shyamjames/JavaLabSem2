/* Demo of menus using AWT
@Shyam James
Roll no: 54
Date: 16-02-2026
*/

import java.awt.*;
import java.awt.event.*;

class Program61 extends Frame implements ActionListener {
	MenuBar mb;
	Menu m1, m2;
	MenuItem mi1, mi2, mi3, mi4;
	Label result;

	Program61() {
		setLayout(new FlowLayout());

		mb = new MenuBar();
		m1 = new Menu("File");
		m2 = new Menu("Edit");

		mi1 = new MenuItem("New");
		mi2 = new MenuItem("Open");
		mi3 = new MenuItem("Cut");
		mi4 = new MenuItem("Copy");

		m1.add(mi1);
		m1.add(mi2);
		m2.add(mi3);
		m2.add(mi4);

		mb.add(m1);
		mb.add(m2);

		setMenuBar(mb);

		result = new Label("");
		add(result);

		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setSize(300, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch (command) {
			case "New":
				result.setText("You selected: New");
				break;
			case "Open":
				result.setText("You selected: Open");
				break;
			case "Cut":
				result.setText("You selected: Cut");
				break;
			case "Copy":
				result.setText("You selected: Copy");
				break;
			default:
				result.setText("");
				break;
		}
	}

	public static void main(String[] args) {
		new Program61();
	}
}