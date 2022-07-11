import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserWindow extends JFrame {

    public JButton jb_cancel, jb_ok;
    UpdateUserByIDWindow prozor;
    JPanel updateUserPanel;
    Person izmenjenKorisnik;
    private JLabel jl_name, jl_surname, jl_age, jl_adress, jl_income;
    private TextField tf_name, tf_surname, tf_age, tf_adress, tf_income;


    public UpdateUserWindow(UpdateUserByIDWindow prozor) {
        izmenjenKorisnik = prozor.p;
        setSize(420, 350);
        setTitle("User to update");
        setLocationRelativeTo(prozor);
        prozor.dispose();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponent();
        postaviSlusaoce();
        tf_name.setText(izmenjenKorisnik.getName());
        tf_surname.setText(izmenjenKorisnik.getSurname());
        tf_age.setText(String.valueOf(izmenjenKorisnik.getAge()));
        tf_adress.setText(izmenjenKorisnik.getAdress());
        tf_income.setText(String.valueOf(izmenjenKorisnik.getIncome()));

        setVisible(true);
    }

    private void postaviSlusaoce() {

        jb_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Session sesija = HibernateUtil.createSessionFactory().openSession();
                Transaction tx = null;
                try {
                    izmenjenKorisnik.setName(tf_name.getText());
                    izmenjenKorisnik.setSurname(tf_surname.getText());
                    izmenjenKorisnik.setAdress(tf_adress.getText());
                    izmenjenKorisnik.setAge(Integer.parseInt(tf_age.getText()));
                    izmenjenKorisnik.setIncome(Integer.parseInt(tf_income.getText()));
                    tx = sesija.beginTransaction();
                    sesija.update(izmenjenKorisnik);
                    tx.commit();
                    JOptionPane.showMessageDialog(prozor, "Uspesna ste izmenili korisnika!");
                    dispose();
                } catch (NumberFormatException numEx) {

                    JOptionPane.showMessageDialog(prozor,
                            "Niste pravilno popunili trazena polja \n" +
                                    numEx.getMessage(),
                            "greska",
                            JOptionPane.ERROR_MESSAGE);
                } finally {
                    sesija.close();
                }
            }
        });
        jb_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void addComponent() {
        updateUserPanel = new JPanel();
        SpringLayout sp = new SpringLayout();
        updateUserPanel.setLayout(sp);
        jl_name = new JLabel("Name");
        jl_name.setPreferredSize(new Dimension(150, 20));
        sp.putConstraint(SpringLayout.NORTH, jl_name, 50, SpringLayout.NORTH, updateUserPanel);
        sp.putConstraint(SpringLayout.WEST, jl_name, 25, SpringLayout.WEST, updateUserPanel);
        tf_name = new TextField();
        tf_name.setPreferredSize(new Dimension(200, 20));
        sp.putConstraint(SpringLayout.NORTH, tf_name, 0, SpringLayout.NORTH, jl_name);
        sp.putConstraint(SpringLayout.WEST, tf_name, 20, SpringLayout.EAST, jl_name);
        jl_surname = new JLabel("Surname");
        jl_surname.setPreferredSize(new Dimension(150, 20));
        sp.putConstraint(SpringLayout.NORTH, jl_surname, 20, SpringLayout.SOUTH, jl_name);
        sp.putConstraint(SpringLayout.WEST, jl_surname, 0, SpringLayout.WEST, jl_name);
        tf_surname = new TextField();
        tf_surname.setPreferredSize(new Dimension(200, 20));
        sp.putConstraint(SpringLayout.NORTH, tf_surname, 20, SpringLayout.SOUTH, tf_name);
        sp.putConstraint(SpringLayout.WEST, tf_surname, 0, SpringLayout.WEST, tf_name);
        jl_age = new JLabel("Age");
        jl_age.setPreferredSize(new Dimension(150, 20));
        sp.putConstraint(SpringLayout.NORTH, jl_age, 20, SpringLayout.SOUTH, jl_surname);
        sp.putConstraint(SpringLayout.WEST, jl_age, 0, SpringLayout.WEST, jl_surname);
        tf_age = new TextField();
        tf_age.setPreferredSize(new Dimension(200, 20));
        sp.putConstraint(SpringLayout.NORTH, tf_age, 20, SpringLayout.SOUTH, tf_surname);
        sp.putConstraint(SpringLayout.WEST, tf_age, 0, SpringLayout.WEST, tf_surname);
        jl_adress = new JLabel("Adress");
        jl_adress.setPreferredSize(new Dimension(150, 20));
        sp.putConstraint(SpringLayout.NORTH, jl_adress, 20, SpringLayout.SOUTH, jl_age);
        sp.putConstraint(SpringLayout.WEST, jl_adress, 0, SpringLayout.WEST, jl_age);
        tf_adress = new TextField();
        tf_adress.setPreferredSize(new Dimension(200, 20));
        sp.putConstraint(SpringLayout.NORTH, tf_adress, 20, SpringLayout.SOUTH, tf_age);
        sp.putConstraint(SpringLayout.WEST, tf_adress, 0, SpringLayout.WEST, tf_age);
        jl_income = new JLabel("Income");
        jl_income.setPreferredSize(new Dimension(150, 20));
        sp.putConstraint(SpringLayout.NORTH, jl_income, 20, SpringLayout.SOUTH, jl_adress);
        sp.putConstraint(SpringLayout.WEST, jl_income, 0, SpringLayout.WEST, jl_adress);
        tf_income = new TextField();
        tf_income.setPreferredSize(new Dimension(200, 20));
        sp.putConstraint(SpringLayout.NORTH, tf_income, 20, SpringLayout.SOUTH, tf_adress);
        sp.putConstraint(SpringLayout.WEST, tf_income, 0, SpringLayout.WEST, tf_adress);
        jb_cancel = new JButton("cancel");
        jb_cancel.setPreferredSize(new Dimension(80, 20));
        jb_ok = new JButton("ok");
        jb_ok.setPreferredSize(new Dimension(80, 20));
        sp.putConstraint(SpringLayout.NORTH, jb_cancel, 250, SpringLayout.NORTH, updateUserPanel);
        sp.putConstraint(SpringLayout.WEST, jb_cancel, 100, SpringLayout.WEST, updateUserPanel);
        sp.putConstraint(SpringLayout.NORTH, jb_ok, 0, SpringLayout.NORTH, jb_cancel);
        sp.putConstraint(SpringLayout.WEST, jb_ok, 60, SpringLayout.EAST, jb_cancel);

        updateUserPanel.add(jl_name);
        updateUserPanel.add(tf_name);
        updateUserPanel.add(jl_surname);
        updateUserPanel.add(tf_surname);
        updateUserPanel.add(jl_age);
        updateUserPanel.add(tf_age);
        updateUserPanel.add(jl_adress);
        updateUserPanel.add(tf_adress);
        updateUserPanel.add(jl_income);
        updateUserPanel.add(tf_income);
        updateUserPanel.add(jb_cancel);
        updateUserPanel.add(jb_ok);

        setContentPane(updateUserPanel);

    }

    public TextField getTf_name() {
        return tf_name;
    }

    public void setTf_name(TextField tf_name) {
        this.tf_name = tf_name;
    }

    public TextField getTf_surname() {
        return tf_surname;
    }

    public void setTf_surname(TextField tf_surname) {
        this.tf_surname = tf_surname;
    }

    public TextField getTf_age() {
        return tf_age;
    }

    public void setTf_age(TextField tf_age) {
        this.tf_age = tf_age;
    }

    public TextField getTf_adress() {
        return tf_adress;
    }

    public void setTf_adress(TextField tf_adress) {
        this.tf_adress = tf_adress;
    }

    public TextField getTf_income() {
        return tf_income;
    }

    public void setTf_income(TextField tf_income) {
        this.tf_income = tf_income;
    }
}