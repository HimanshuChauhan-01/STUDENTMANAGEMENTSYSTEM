package table;

import model.Student;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentTableModel extends DefaultTableModel {
    public StudentTableModel() {
        super(new String[]{"Name", "Roll No", "Course"}, 0);
    }

    public void loadData(ArrayList<Student> students) {
        setRowCount(0); // Clear
        for (Student s : students) {
            addRow(new Object[]{s.getName(), s.getRollNo(), s.getCourse()});
        }
    }
}