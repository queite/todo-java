package util;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {
	private String buttonType;
	
	public ButtonColumnCellRenderer(String buttonType) {
		this.buttonType = buttonType;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
		// Cells are by default rendered as JLabel.
		JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		label.setHorizontalAlignment(CENTER);
		label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));
		
		return label;
	}

}
