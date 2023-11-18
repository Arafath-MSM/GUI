import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegistration extends JDialog 
{
    private JTextField tfName;
    private JTextField tfRegistrationNumber;
    private JTextField tfEmail;
    private JTextField tfDepartmentName;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JPanel StudentRegisterPanel;
    private JCheckBox cterm;
    private JLabel res;
    private JTextArea tout;

    public StudentRegistration(JFrame parent) {
        super(parent);
        setTitle("Create a new Student Registration  ");
        setContentPane(StudentRegisterPanel);
        setMinimumSize(new Dimension(700, 475));
        setModal(true);
        setLocationRelativeTo(parent);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cterm.isSelected() && areAllFieldsFilled()) {
                    String data = "Name : " + tfName.getText() + "\n"
                            + "Registration Number : " + tfRegistrationNumber.getText() + "\n"
                            + "Email ID : " + tfEmail.getText() + "\n"
                            + "Department Name: " + tfDepartmentName.getText();

                    tout.setText(data);
                    tout.setEditable(false);
                    res.setText("Registration Successfully..");
                } else {
                    tout.setText("");
                    res.setText("Please fill in all fields and accept terms.");
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cterm.isSelected() && areAllFieldsFilled()) {
                    String updatedData = "Updated Information:\n"
                            + "Name : " + tfName.getText() + "\n"
                            + "Registration Number : " + tfRegistrationNumber.getText() + "\n"
                            + "Email ID : " + tfEmail.getText() + "\n"
                            + "Department Name: " + tfDepartmentName.getText();

                    tout.setText(updatedData);
                    tout.setEditable(false);
                    res.setText("Information Updated Successfully..");
                } else {
                    tout.setText("");
                    res.setText("Please fill in all fields and accept terms.");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfRegistrationNumber.setText("");
                tfEmail.setText("");
                tfDepartmentName.setText("");
                tout.setText("");
                cterm.setSelected(false);
                res.setText("");
            }
        });

        setVisible(true);
    }

    private boolean areAllFieldsFilled() {
        return !tfName.getText().isEmpty()
                && !tfRegistrationNumber.getText().isEmpty()
                && !tfEmail.getText().isEmpty()
                && !tfDepartmentName.getText().isEmpty();
    }

    public static void main(String[] args) {
        StudentRegistration myForm = new StudentRegistration(null);
    }
}
