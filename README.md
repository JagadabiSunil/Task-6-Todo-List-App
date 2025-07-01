To-Do List Application using Java Swing
This is a simple To-Do List desktop application built using Java Swing. The application allows users to manage their daily tasks efficiently. You can add new tasks using a text input field and delete selected tasks from the list. The user interface is designed with core Swing components like JFrame, JTextField, JButton, and JList.

*** Technologies Used ***
Technology	Purpose
Java	Programming language
Java Swing	GUI library for building interfaces
JDK	Java Development Kit

*** Components Overview ***
Component	Description
JFrame	The main application window.
JTextField	Used to type the task name.
JButton (Add)	Adds the task to the list.
JButton (Delete)	Deletes the selected task.
JList	Displays the list of tasks.
DefaultListModel	Used to manage the list data dynamically.

*** Features ***
Add a task by entering text and clicking "Add"
View all added tasks in a list
Select and delete tasks using "Delete Selected" button
Clean and user-friendly layout

*** How the App Works ***

The app launches a window (JFrame) titled "To-Do List".
You can type a task in the input field (JTextField) at the top.
Click the "Add" button to add the task to the list.
Tasks are displayed in a scrollable list view (JList).
Select a task and click the "Delete Selected" button to remove it.


*** How Code Works *** (Step By Step)
 (Step-by-Step):
 
**Imports:**
import javax.swing.*;       // For GUI components like JFrame, JButton, etc.
import java.awt.*;          // For layouts like BorderLayout
import java.awt.event.*;    // For handling button clicks (event listeners)

** Class Declaration:**
public class TodoListApp {
This is the main class where the app is built.

**** GUI Components:
private JFrame frame;
private JTextField taskInput;
private JButton addButton, deleteButton;
private DefaultListModel<String> taskListModel;
private JList<String> taskList;

These are Swing components used in the app:
JFrame: the main window.
JTextField: for entering new tasks.
JButton: for adding and deleting tasks.
DefaultListModel: stores the tasks dynamically.
JList: displays the list of tasks.

** Constructor – public TodoListApp() **
This builds and displays the GUI.
frame = new JFrame("To-Do List");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 400);
frame.setLayout(new BorderLayout());
A new window is created and configured with size and layout.
BorderLayout allows you to organize items in NORTH, CENTER, SOUTH, etc.

** Top Panel (Input field + Add button): **
JPanel topPanel = new JPanel();
topPanel.setLayout(new BorderLayout());

taskInput = new JTextField();            // For user to type task
addButton = new JButton("Add");          // "Add" button

topPanel.add(taskInput, BorderLayout.CENTER);
topPanel.add(addButton, BorderLayout.EAST);
This panel holds the input field and Add button.

It is placed at the top (NORTH of the frame).

** Task List: **
taskListModel = new DefaultListModel<>();
taskList = new JList<>(taskListModel);
JScrollPane scrollPane = new JScrollPane(taskList);
taskListModel holds the data (tasks).

JList shows the data in UI.

JScrollPane adds scrolling when tasks exceed the visible space.

** Delete Button: **
deleteButton = new JButton("Delete Selected");
Used to delete the currently selected task.

** Add Components to Frame: **
frame.add(topPanel, BorderLayout.NORTH);   // Input & Add button
frame.add(scrollPane, BorderLayout.CENTER); // Task list
frame.add(deleteButton, BorderLayout.SOUTH); // Delete button
This assembles all the parts into the window.

** Add Button Action: **
addButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);     // Add to the list
            taskInput.setText("");              // Clear the input field
        }
    }
});
When the "Add" button is clicked:

It gets the text from the input field.

Adds it to the list model (displayed in the list).

Clears the input field.

** Delete Button Action:**
deleteButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        }
    }
});
When the "Delete" button is clicked:

It checks if a task is selected.

If yes, it removes that task from the list.

**Main Method:**
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new TodoListApp();  // Create and show the app
        }
    });
}
This starts the GUI safely on the Event Dispatch Thread.
