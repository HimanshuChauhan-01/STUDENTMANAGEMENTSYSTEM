package ui;

import database.StudentDatabase;
import model.Student;
import table.StudentTableModel;

import javax.swing.*;
import java.awt.*;

public class StudentManagementSystem extends JFrame {
    private JTextField nameField, rollField, courseField, searchField;
    private JButton addButton, deleteButton, searchButton, resetButton;
    private JTable studentTable;
    private StudentTableModel tableModel;
    private StudentDatabase db;

    public StudentManagementSystem() {
        db = new StudentDatabase();

        setTitle("Student Management System");
        setSize(700, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add Student"));

        nameField = new JTextField();
        rollField = new JTextField();
        courseField = new JTextField();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete Selected");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Roll No:"));
        formPanel.add(rollField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(addButton);
        formPanel.add(deleteButton);

        // ===== Search Panel =====
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));

        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        resetButton = new JButton("Reset");

        searchPanel.add(new JLabel("Keyword:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(resetButton);

        // ===== Logo Panel =====
        ImageIcon logoIcon = new ImageIcon("resources/galgotias-university-logo.png");
        Image scaledImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        JPanel logoPanel = new JPanel();
        logoPanel.add(logoLabel);

        // ===== Table =====
        tableModel = new StudentTableModel();
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(formPanel);
        topPanel.add(searchPanel);
        topPanel.add(logoPanel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Events =====
        addButton.addActionListener(e -> addStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        searchButton.addActionListener(e -> searchStudent());
        resetButton.addActionListener(e -> loadAllStudents());

        loadAllStudents();

        setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();
        String course = courseField.getText().trim();

        if (name.isEmpty() || roll.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        db.addStudent(new Student(name, roll, course));
        loadAllStudents();

        nameField.setText("");
        rollField.setText("");
        courseField.setText("");
    }

    private void deleteStudent() {
        int selected = studentTable.getSelectedRow();
        if (selected != -1) {
            String rollNo = (String) studentTable.getValueAt(selected, 1);
            db.deleteStudent(rollNo);
            loadAllStudents();
        }
    }

    private void searchStudent() {
        String keyword = searchField.getText().trim().toLowerCase();
        tableModel.loadData(db.searchStudents(keyword));
    }

    private void loadAllStudents() {
        tableModel.loadData(db.getAllStudents());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ui.StudentManagementSystem::new);
    }
}