/* Find the maximum of three numbers using AWT.
@Shyam James
Roll no: 54
Date: 09-02-2026
*/

import java.awt.*;
import java.awt.event.*;

class Program58 extends Frame implements ActionListener {
	TextField t1, t2, t3;
	Button b;
	Label result;

	Program58() {
		setLayout(new FlowLayout());

		t1 = new TextField(10);
		t2 = new TextField(10);
		t3 = new TextField(10);
		b = new Button("Find Max");
		result = new Label("");

		add(new Label("Enter first number:"));
		add(t1);
		add(new Label("Enter second number:"));
		add(t2);
		add(new Label("Enter third number:"));
		add(t3);
		add(b);
		add(result);

		b.addActionListener(this);

		setSize(300, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			int num1 = Integer.parseInt(t1.getText());
			int num2 = Integer.parseInt(t2.getText());
			int num3 = Integer.parseInt(t3.getText());

			int max = Math.max(num1, Math.max(num2, num3));
			result.setText("Maximum: " + max);
		} catch (NumberFormatException ex) {
			result.setText("Please enter valid integers.");
		}
	}

	public static void main(String[] args) {
		new Program58();
	}
}