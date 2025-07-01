import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListApp
    {

        // Components
        private JFrame frame;
        private JTextField taskInput;
        private JButton addButton, deleteButton;
        private DefaultListModel<String> taskListModel;
        private JList<String> taskList;

        public TodoListApp()
        {
            // Frame
            frame = new JFrame("To-Do List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new BorderLayout());

            // Top Panel for input and add button
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new BorderLayout());

            taskInput = new JTextField();
            addButton = new JButton("Add");

            topPanel.add(taskInput, BorderLayout.CENTER);
            topPanel.add(addButton, BorderLayout.EAST);

            // Task list
            taskListModel = new DefaultListModel<>();
            taskList = new JList<>(taskListModel);
            JScrollPane scrollPane = new JScrollPane(taskList);

            // Delete button
            deleteButton = new JButton("Delete Selected");

            // Add components to frame
            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(deleteButton, BorderLayout.SOUTH);

            // Add Button Action
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String task = taskInput.getText().trim();
                    if (!task.isEmpty())
                    {
                        taskListModel.addElement(task);
                        taskInput.setText("");
                    }
                }
            });

            // Delete Button Action
            deleteButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    int selectedIndex = taskList.getSelectedIndex();
                    if (selectedIndex != -1)
                    {
                        taskListModel.remove(selectedIndex);
                    }
                }
            });

            // Show Frame
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            // Start app on Event Dispatch Thread
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new TodoListApp();
                }
            });
        }
    }



