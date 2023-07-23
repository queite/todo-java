package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;
import util.TaskTableModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JList<Project> list;

	ProjectController projectController;
	TaskController taskController;
	
	DefaultListModel<Project> projectModel;
	TaskTableModel taskModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setMinimumSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(94, 0, 94));
		panelHeader.setLayout(null);
		
		JLabel lableHeaderTitle = new JLabel("ToDo App");
		lableHeaderTitle.setIcon(new ImageIcon("C:\\Users\\Queite\\eclipse-workspace\\todo\\src\\main\\resources\\check-mark-3-32.png"));
		lableHeaderTitle.setForeground(new Color(244, 244, 244));
		lableHeaderTitle.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lableHeaderTitle.setBounds(10, 11, 394, 36);
		lableHeaderTitle.setBackground(new Color(255, 255, 255));
		panelHeader.add(lableHeaderTitle);
		
		JPanel panelProjects = new JPanel();
		panelProjects.setBackground(new Color(255, 255, 255));
		panelProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelTasks = new JPanel();
		panelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelTasks.setBackground(new Color(255, 255, 255));
		
		JPanel panelListProjects = new JPanel();
		panelListProjects.setBackground(new Color(255, 255, 255));
		panelListProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelListTasks = new JPanel();
		panelListTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelListTasks.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelHeader, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelListProjects, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panelProjects, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelTasks, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panelListTasks, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(3))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panelHeader, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTasks, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelProjects, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelListTasks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(panelListProjects, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
		);
		panelListTasks.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = table.rowAtPoint(e.getPoint());
				int columnIndex = table.columnAtPoint(e.getPoint());
				
				switch(columnIndex) {
				case 3:
					Task task = taskModel.getTasks().get(rowIndex);
					taskController.update(task);
				}
					
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setRowHeight(40);
//		System.out.println(table.getTableHeader().getBackground());
//		table.getTableHeader().setBackground(Color.black);
//		System.out.println(table.getTableHeader().getBackground());
		decorateTableTasks();

//		table.setBounds(10, 11, 306, 413);	
		JScrollPane scrollPanelTasks = new JScrollPane(table);
		panelListTasks.add(scrollPanelTasks);
		panelListProjects.setLayout(new BorderLayout(0, 0));
        
		list = new JList<Project>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int projectIndex = list.getSelectedIndex();
				Project project = (Project) projectModel.get(projectIndex);
				loadTasks(project.getId());
				taskModel.fireTableDataChanged();
			}
		});
		list.setFixedCellHeight(40);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectionBackground(new Color(151, 0, 151));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Segoe UI", Font.BOLD, 13));
		panelListProjects.add(list);
		
		JLabel labelTasks = new JLabel("Tarefas");
		labelTasks.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelTasks.setForeground(new Color(64, 0, 64));
		
		JLabel labelTasksAdd = new JLabel("");
		labelTasksAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TaskDialogScreen taskDialogScreen = new TaskDialogScreen();
				int projectIndex = list.getSelectedIndex();
				Project project = (Project) projectModel.get(projectIndex);
				taskDialogScreen.setProject(project);
				taskDialogScreen.setVisible(true);
				
				taskDialogScreen.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						int projectIndex = list.getSelectedIndex();
						Project project = (Project) projectModel.get(projectIndex);
						loadTasks(project.getId());
					}
				});			
			}
		});
		labelTasksAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		labelTasksAdd.setAlignmentX(Component.RIGHT_ALIGNMENT);
		labelTasksAdd.setIcon(new ImageIcon("C:\\Users\\Queite\\eclipse-workspace\\todo\\src\\main\\resources\\plus-16.png"));
		GroupLayout gl_panelTasks = new GroupLayout(panelTasks);
		gl_panelTasks.setHorizontalGroup(
			gl_panelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTasks.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelTasks, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
					.addComponent(labelTasksAdd)
					.addContainerGap())
		);
		gl_panelTasks.setVerticalGroup(
			gl_panelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTasks.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelTasks.createParallelGroup(Alignment.LEADING)
						.addComponent(labelTasks)
						.addComponent(labelTasksAdd))
					.addContainerGap())
		);
		panelTasks.setLayout(gl_panelTasks);
		
		JLabel labelProjects = new JLabel("Projetos");
		labelProjects.setFont(new Font("Segoe UI", Font.BOLD, 14));
		labelProjects.setForeground(new Color(64, 0, 64));
		
		JLabel labelProjectsAdd = new JLabel("");
		labelProjectsAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen();
				projectDialogScreen.setVisible(true);
				projectDialogScreen.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						loadProjects();
					}
				});
			}
		});
		labelProjectsAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		labelProjectsAdd.setIcon(new ImageIcon("C:\\Users\\Queite\\eclipse-workspace\\todo\\src\\main\\resources\\plus-16.png"));
		GroupLayout gl_panelProjects = new GroupLayout(panelProjects);
		gl_panelProjects.setHorizontalGroup(
			gl_panelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProjects.createSequentialGroup()
					.addGap(10)
					.addComponent(labelProjects, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(labelProjectsAdd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelProjects.setVerticalGroup(
			gl_panelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProjects.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelProjects.createParallelGroup(Alignment.LEADING)
						.addComponent(labelProjectsAdd, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelProjects))
					.addContainerGap())
		);
		panelProjects.setLayout(gl_panelProjects);
		contentPane.setLayout(gl_contentPane);
		initDataControler();
		initComponentsModel();
	}
	public void decorateTableTasks() {
		table.getTableHeader().setFont(new Font("Segoi UI", Font.BOLD, 14));
		table.getTableHeader().setBackground(new Color(94,0,94));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setAutoCreateRowSorter(true);
	}
	
	public void initDataControler() {
		projectController = new ProjectController();
		taskController = new TaskController();
	}
	
	public void loadTasks(int projectId) {
		List<Task> tasks = taskController.getAll(projectId);
		if(!tasks.isEmpty()) {
			table.setVisible(true);
			taskModel.setTasks(tasks);
		} else {
			table.setVisible(false);
			JOptionPane.showMessageDialog(null, "Projeto sem tarefas");
		}
	}
	
	public void initComponentsModel() {
		projectModel = new DefaultListModel<Project>();
		loadProjects();
		taskModel = new TaskTableModel();
		table.setModel(taskModel);
		
		if(!projectModel.isEmpty()) {
			list.setSelectedIndex(0);
			Project project = (Project) projectModel.get(0);
			loadTasks(project.getId());
		}
	}
	
	public void loadProjects() {
		List<Project> projects = projectController.getAll();
		projectModel.clear();
		
		for (int i = 0; i < projects.size(); i += 1) {
			projectModel.addElement(projects.get(i));
		}
		
		list.setModel(projectModel);
	}
}
