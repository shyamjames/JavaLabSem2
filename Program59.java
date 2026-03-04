/* Implement all the functionality of LIST control.
@Shyam James
Roll no: 54
Date: 09-02-2026
*/

import java.awt.*;
import java.awt.event.*;

class Program59 extends Frame implements ActionListener {
	List list;
	TextField input;
	Button bAdd, bRemove, bSelect, bDeselect, bShow, bCount, bClear;
	Label result;

	Program59() {
		setLayout(new FlowLayout());

		list = new List(6, true);
		list.add("Red");
		list.add("Green");
		list.add("Blue");
		list.add("Yellow");
		list.add("Orange");

		input = new TextField(12);
		bAdd = new Button("Add");
		bRemove = new Button("Remove Sel");
		bSelect = new Button("Select 1st");
		bDeselect = new Button("Deselect All");
		bShow = new Button("Show Sel");
		bCount = new Button("Count");
		bClear = new Button("Clear");

		result = new Label("");

		add(new Label("Item:"));
		add(input);
		add(bAdd);
		add(bRemove);
		add(bSelect);
		add(bDeselect);
		add(bShow);
		add(bCount);
		add(bClear);
		add(list);
		add(result);

		bAdd.addActionListener(this);
		bRemove.addActionListener(this);
		bSelect.addActionListener(this);
		bDeselect.addActionListener(this);
		bShow.addActionListener(this);
		bCount.addActionListener(this);
		bClear.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setSize(420, 260);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAdd) {
			String item = input.getText().trim();
			if (!item.equals("")) {
				list.add(item);
				result.setText("Added: " + item);
				input.setText("");
			} else {
				result.setText("Enter item to add");
			}
		} else if (e.getSource() == bRemove) {
			int[] idx = list.getSelectedIndexes();
			if (idx.length == 0) {
				result.setText("No item selected");
			} else {
				for (int i = idx.length - 1; i >= 0; i--) {
					list.remove(idx[i]);
				}
				result.setText("Selected item(s) removed");
			}
		} else if (e.getSource() == bSelect) {
			if (list.getItemCount() > 0) {
				list.select(0);
				result.setText("First item selected");
			} else {
				result.setText("List is empty");
			}
		} else if (e.getSource() == bDeselect) {
			for (int i = 0; i < list.getItemCount(); i++) {
				list.deselect(i);
			}
			result.setText("All items deselected");
		} else if (e.getSource() == bShow) {
			String[] items = list.getSelectedItems();
			if (items.length == 0) {
				result.setText("No item selected");
			} else {
				String selected = "";
				for (int i = 0; i < items.length; i++) {
					if (i > 0) selected += ", ";
					selected += items[i];
				}
				result.setText("Selected: " + selected);
			}
		} else if (e.getSource() == bCount) {
			result.setText("Total items: " + list.getItemCount());
		} else if (e.getSource() == bClear) {
			list.removeAll();
			result.setText("All items removed");
		}
	}

	public static void main(String[] args) {
		new Program59();
	}
}