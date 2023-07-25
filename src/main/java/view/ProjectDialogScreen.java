package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProjectController;
import model.Project;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProjectDialogScreen extends JDialog {
	
	ProjectController controller;

	private final JPanel contentPanel = new JPanel();
	private JLabel lableTitle;
	private JLabel lableName;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProjectDialogScreen dialog = new ProjectDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectDialogScreen() {
		setBounds(100, 100, 450, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(128, 0, 128));
		panelHeader.setForeground(new Color(151, 0, 151));
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE))
		);
		{
			lableName = new JLabel("Nome");
			lableName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		}
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldName.setColumns(10);
		
		JLabel labledescription = new JLabel("Descrição");
		labledescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		final JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(textAreaDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addComponent(textFieldName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addComponent(lableName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addComponent(labledescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lableName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labledescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaDescription, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		{
			lableTitle = new JLabel("Projeto");
			lableTitle.setForeground(new Color(244, 244, 244));
			lableTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		}
		final JLabel lableSave = new JLabel("");
		lableSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(!textFieldName.getText().isEmpty()) {
						Project project = new Project();
						project.setName(textFieldName.getText());
						project.setDescription(textAreaDescription.getText());
						controller.save(project);						
						JOptionPane.showMessageDialog(rootPane, "Projeto Salvo com sucesso");
						
						Window window = SwingUtilities.getWindowAncestor(lableSave);
						window.dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "Campo nome obrigatório");
					}									
				}catch(Exception er){
					JOptionPane.showMessageDialog(rootPane, er);
				}
			}
		});
		lableSave.setIcon(new ImageIcon("C:\\Users\\Queite\\eclipse-workspace\\todo\\src\\main\\resources\\check-mark-3-32.png"));
		GroupLayout gl_panelHeader = new GroupLayout(panelHeader);
		gl_panelHeader.setHorizontalGroup(
			gl_panelHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelHeader.createSequentialGroup()
					.addContainerGap()
					.addComponent(lableTitle)
					.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
					.addComponent(lableSave)
					.addContainerGap())
		);
		gl_panelHeader.setVerticalGroup(
			gl_panelHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelHeader.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelHeader.createParallelGroup(Alignment.LEADING)
						.addComponent(lableTitle)
						.addComponent(lableSave))
					.addGap(13))
		);
		panelHeader.setLayout(gl_panelHeader);
		contentPanel.setLayout(gl_contentPanel);
		
		controller = new ProjectController();
	}
}
