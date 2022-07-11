import javax.swing.*;
import java.awt.*;

public class HomeWindow extends JFrame {
    JPanel panel;
    JButton jb_newEmployee, jb_updateEmployee, jb_eraseEmployee;
    JButton jb_showAllEmployee, jb_searchEmployee;

    public HomeWindow() {
        setSize(400,570);
        setTitle("Home Window");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponent();
        postaviSlusaoce();
        setVisible(true);
    }

    public void addComponent() {
        panel = new JPanel();
        SpringLayout sp = new SpringLayout();
        panel.setLayout(sp);
        jb_newEmployee = new JButton("new user");
        jb_newEmployee.setPreferredSize(new Dimension(200,50));
        sp.putConstraint(SpringLayout.NORTH, jb_newEmployee, 50, SpringLayout.NORTH, panel);
        sp.putConstraint(SpringLayout.WEST, jb_newEmployee, 100, SpringLayout.WEST, panel);
        jb_updateEmployee = new JButton("update user");
        jb_updateEmployee.setPreferredSize(new Dimension(200,50));
        sp.putConstraint(SpringLayout.NORTH, jb_updateEmployee, 50, SpringLayout.SOUTH, jb_newEmployee);
        sp.putConstraint(SpringLayout.WEST, jb_updateEmployee, 0, SpringLayout.WEST, jb_newEmployee);
        jb_eraseEmployee = new JButton("erase user");
        jb_eraseEmployee.setPreferredSize(new Dimension(200,50));
        sp.putConstraint(SpringLayout.NORTH, jb_eraseEmployee, 50, SpringLayout.SOUTH, jb_updateEmployee);
        sp.putConstraint(SpringLayout.WEST, jb_eraseEmployee, 0, SpringLayout.WEST, jb_updateEmployee);
        jb_showAllEmployee = new JButton("show all users");
        jb_showAllEmployee.setPreferredSize(new Dimension(200,50));
        sp.putConstraint(SpringLayout.NORTH, jb_showAllEmployee, 50, SpringLayout.SOUTH, jb_eraseEmployee);
        sp.putConstraint(SpringLayout.WEST, jb_showAllEmployee, 0, SpringLayout.WEST, jb_eraseEmployee);
        jb_searchEmployee = new JButton("search");
        jb_searchEmployee.setPreferredSize(new Dimension(200,50));
        sp.putConstraint(SpringLayout.NORTH, jb_searchEmployee, 50, SpringLayout.SOUTH, jb_showAllEmployee);
        sp.putConstraint(SpringLayout.WEST, jb_searchEmployee, 0, SpringLayout.WEST, jb_showAllEmployee);
        panel.add(jb_newEmployee);
        panel.add(jb_updateEmployee);
        panel.add(jb_eraseEmployee);
        panel.add(jb_showAllEmployee);
        panel.add(jb_searchEmployee);
        setContentPane(panel);
    }
    private void postaviSlusaoce(){

        jb_newEmployee.addActionListener(new NewUserListener(this));
        jb_updateEmployee.addActionListener(new UpdateListener(this));
        jb_eraseEmployee.addActionListener(new DeleteListener(this));
        jb_showAllEmployee.addActionListener(new AllEmployersListener(this));
        jb_searchEmployee.addActionListener(new SearchListener(this));
    }

}