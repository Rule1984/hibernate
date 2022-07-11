import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserWindow extends JFrame {
    JPanel userPanel;
    private JLabel jl_name, jl_surname, jl_age, jl_adress, jl_income;
    private TextField tf_name, tf_surname, tf_age, tf_adress, tf_income;
    public JButton jb_cancel, jb_ok;

    public TextField getTf_name() {
        return tf_name;
    }

    public TextField getTf_surname() {
        return tf_surname;
    }

    public TextField getTf_age() {
        return tf_age;
    }

    public TextField getTf_adress() {
        return tf_adress;
    }

    public TextField getTf_income() {
        return tf_income;
    }

    public NewUserWindow(JFrame parentFrame) {
        setSize(420,350);
        setTitle("New User");
        setLocationRelativeTo(parentFrame);
        parentFrame.dispose();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponent();
        postaviSlusaoce(parentFrame);
        setVisible(true);
    }

    private void postaviSlusaoce(JFrame parentFrame) {
        jb_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.setVisible(true);
                dispose();
            }
        });
        jb_ok.addActionListener(new ProcessingNewUser(this));
    }

    private void addComponent() {
        userPanel = new JPanel();
        SpringLayout sp = new SpringLayout();
        userPanel.setLayout(sp);
        jl_name = new JLabel("Name");
        jl_name.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_name, 50,SpringLayout.NORTH, userPanel);
        sp.putConstraint(SpringLayout.WEST, jl_name,25, SpringLayout.WEST, userPanel);
        tf_name = new TextField();
        tf_name.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_name, 0,SpringLayout.NORTH, jl_name);
        sp.putConstraint(SpringLayout.WEST, tf_name,20, SpringLayout.EAST, jl_name);
        jl_surname = new JLabel("Surname");
        jl_surname.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_surname, 20,SpringLayout.SOUTH, jl_name);
        sp.putConstraint(SpringLayout.WEST, jl_surname,0, SpringLayout.WEST, jl_name);
        tf_surname = new TextField();
        tf_surname.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_surname, 20,SpringLayout.SOUTH, tf_name);
        sp.putConstraint(SpringLayout.WEST, tf_surname,0, SpringLayout.WEST, tf_name);
        jl_age = new JLabel("Age");
        jl_age.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_age, 20,SpringLayout.SOUTH, jl_surname);
        sp.putConstraint(SpringLayout.WEST, jl_age,0, SpringLayout.WEST, jl_surname);
        tf_age = new TextField();
        tf_age.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_age, 20,SpringLayout.SOUTH, tf_surname);
        sp.putConstraint(SpringLayout.WEST, tf_age,0, SpringLayout.WEST, tf_surname);
        jl_adress = new JLabel("Adress");
        jl_adress.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_adress, 20,SpringLayout.SOUTH, jl_age);
        sp.putConstraint(SpringLayout.WEST, jl_adress,0, SpringLayout.WEST, jl_age);
        tf_adress = new TextField();
        tf_adress.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_adress, 20,SpringLayout.SOUTH, tf_age);
        sp.putConstraint(SpringLayout.WEST, tf_adress,0, SpringLayout.WEST, tf_age);
        jl_income = new JLabel("Income");
        jl_income.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_income, 20,SpringLayout.SOUTH, jl_adress);
        sp.putConstraint(SpringLayout.WEST, jl_income,0, SpringLayout.WEST, jl_adress);
        tf_income = new TextField();
        tf_income.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_income, 20,SpringLayout.SOUTH, tf_adress);
        sp.putConstraint(SpringLayout.WEST, tf_income,0, SpringLayout.WEST, tf_adress);
        jb_cancel = new JButton("cancel");
        jb_cancel.setPreferredSize(new Dimension(80,20));
        jb_ok = new JButton("ok");
        jb_ok.setPreferredSize(new Dimension(80,20));
        sp.putConstraint(SpringLayout.NORTH, jb_cancel,250, SpringLayout.NORTH, userPanel);
        sp.putConstraint(SpringLayout.WEST, jb_cancel,100,SpringLayout.WEST, userPanel);
        sp.putConstraint(SpringLayout.NORTH, jb_ok,0, SpringLayout.NORTH, jb_cancel);
        sp.putConstraint(SpringLayout.WEST, jb_ok,60,SpringLayout.EAST, jb_cancel);

        userPanel.add(jl_name);
        userPanel.add(tf_name);
        userPanel.add(jl_surname);
        userPanel.add(tf_surname);
        userPanel.add(jl_age);
        userPanel.add(tf_age);
        userPanel.add(jl_adress);
        userPanel.add(tf_adress);
        userPanel.add(jl_income);
        userPanel.add(tf_income);
        userPanel.add(jb_cancel);
        userPanel.add(jb_ok);

        setContentPane(userPanel);

    }
}
