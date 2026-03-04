/* Implement Check box and radio button in AWT
@Shyam James
Roll no: 54
Date: 16-02-2026
*/

import java.awt.*;
import java.awt.event.*;

class Program60 extends Frame implements ItemListener {
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Label result;

	Program60() {
		setLayout(new FlowLayout());

		cb1 = new Checkbox("Option 1");
		cb2 = new Checkbox("Option 2");
		cb3 = new Checkbox("Option 3");

		cbg = new CheckboxGroup();
		cb1.setCheckboxGroup(cbg);
		cb2.setCheckboxGroup(cbg);
		cb3.setCheckboxGroup(cbg);

		result = new Label("");

		add(cb1);
		add(cb2);
		add(cb3);
		add(result);

		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);

		setSize(300, 200);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		if (cb1.getState()) {
			result.setText("Selected: Option 1");
		} else if (cb2.getState()) {
			result.setText("Selected: Option 2");
		} else if (cb3.getState()) {
			result.setText("Selected: Option 3");
		}
	}

	public static void main(String[] args) {
		new Program60();
	}
}