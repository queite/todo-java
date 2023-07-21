package view;

import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.TaskController;
import model.Project;
import model.Task;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class TaskDialogScreen extends JDialog {
	
	TaskController controller;
	Project project;
	
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TaskDialogScreen dialog = new TaskDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TaskDialogScreen() {
		setResizable(false);
		setBounds(100, 100, 462, 484);
		JPanel panelTaskHeader = new JPanel();
		panelTaskHeader.setBackground(new Color(128, 0, 128));
		JPanel panelTask = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(panelTaskHeader, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelTask, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panelTaskHeader, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTask, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		JLabel labelName = new JLabel("Nome");
		labelName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		JLabel labelDescription = new JLabel("Descrição");
		labelDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		final JTextArea textAreaDescription = new JTextArea();
		JLabel labelDeadline = new JLabel("Prazo");
		labelDeadline.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JLabel labelNotes = new JLabel("Notas");
		labelNotes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		final JTextArea textAreaNotes = new JTextArea();
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		final JFormattedTextField formattedTextFieldDeadline = new JFormattedTextField(dateFormat);
		GroupLayout gl_panelTask = new GroupLayout(panelTask);
		gl_panelTask.setHorizontalGroup(
			gl_panelTask.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTask.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTask.createParallelGroup(Alignment.LEADING)
						.addComponent(textAreaNotes, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
						.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
						.addComponent(labelName)
						.addComponent(labelDescription)
						.addComponent(textAreaDescription, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
						.addComponent(labelDeadline)
						.addComponent(labelNotes)
						.addComponent(formattedTextFieldDeadline, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelTask.setVerticalGroup(
			gl_panelTask.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTask.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaDescription, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelDeadline)
					.addGap(1)
					.addComponent(formattedTextFieldDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelNotes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaNotes, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelTask.setLayout(gl_panelTask);
		JLabel labelTaskTitle = new JLabel("Tarefa");
		labelTaskTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		labelTaskTitle.setForeground(new Color(255, 255, 255));
		final JLabel labelTaskSave = new JLabel("");
		labelTaskSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Task task = new Task();
					task.setIdProject( project.getId());
					task.setName(textFieldName.getText());
					task.setDescription(textAreaDescription.getText());
					String deadlineText = formattedTextFieldDeadline.getText();
					task.setDeadline(dateFormat.parse(deadlineText));
					task.setNotes(textAreaNotes.getText());
					controller.save(task);
					JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso.");
				} catch(Exception er) {
					JOptionPane.showMessageDialog(rootPane, er);
				}
				
			Window window = SwingUtilities.getWindowAncestor(labelTaskSave);
			window.dispose();
		}
		});
		labelTaskSave.setIcon(new ImageIcon("C:\\Users\\Queite\\eclipse-workspace\\todo\\src\\main\\resources\\check-mark-3-32.png"));
		GroupLayout gl_panelTaskHeader = new GroupLayout(panelTaskHeader);
		gl_panelTaskHeader.setHorizontalGroup(
			gl_panelTaskHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTaskHeader.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTaskTitle)
					.addPreferredGap(ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
					.addComponent(labelTaskSave)
					.addContainerGap())
		);
		gl_panelTaskHeader.setVerticalGroup(
			gl_panelTaskHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTaskHeader.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTaskHeader.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTaskTitle)
						.addComponent(labelTaskSave))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panelTaskHeader.setLayout(gl_panelTaskHeader);
		getContentPane().setLayout(groupLayout);
		
		controller = new TaskController();
	}
	
	public void setProject(Project project) {
		this.project = project; 
	}
}
