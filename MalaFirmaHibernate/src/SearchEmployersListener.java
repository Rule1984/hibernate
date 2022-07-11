import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchEmployersListener implements ActionListener {
    SearchEmloyerWindow parentWindow;
    List<Person> trazeniZaposleni;
    StringBuilder sb;

    public SearchEmployersListener(SearchEmloyerWindow parentWindow) {
        this.parentWindow = parentWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Session sesija = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        String hql = null;
        try {
            if (parentWindow.getTf_name().getText() != null && parentWindow.getTf_surname().getText().isEmpty()
                    && parentWindow.getTf_income().getText().isEmpty()) {
                hql = "from Person as p where p.name = '" + parentWindow.getTf_name().getText() + "'";
            } else if (parentWindow.getTf_name().getText().isEmpty() && parentWindow.getTf_surname().getText() != null
                    && parentWindow.getTf_income().getText().isEmpty()) {
                hql = "from Person as p where p.surname = '" + parentWindow.getTf_surname().getText() + "'";
            } else if (parentWindow.getTf_name().getText() != null && parentWindow.getTf_surname().getText() != null
                    && parentWindow.getTf_income().getText().isEmpty()) {
                hql = "from Person as p where p.surname = '" + parentWindow.getTf_surname().getText() + "' and p.name = '" + parentWindow.getTf_name().getText() + "'";
            } else if (parentWindow.getTf_name().getText().isEmpty() && parentWindow.getTf_surname().getText().isEmpty()
                    && parentWindow.getTf_income().getText() != null) {
                if (parentWindow.ch.getSelectedItem().equals("=")) {
                    hql = "from Person as p where p.income = '" + parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals(">")) {
                    hql = "from Person as p where p.income > '" + parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals("<")) {
                    hql = "from Person as p where p.income < '" + parentWindow.getTf_income().getText() + "'";
                }
            } else if (parentWindow.getTf_name().getText() != null && parentWindow.getTf_surname().getText().isEmpty()
                    && parentWindow.getTf_income().getText() != null) {
                if (parentWindow.ch.getSelectedItem().equals("=")) {
                    hql = "from Person as p where p.name = '" + parentWindow.getTf_name().getText() + "' and p.income = '" +
                            parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals(">")) {
                    hql = "from Person as p where p.name = '" + parentWindow.getTf_name().getText() + "' and p.income > '" +
                            parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals("<")) {
                    hql = "from Person as p where p.name = '" + parentWindow.getTf_name().getText() + "' and p.income < '" +
                            parentWindow.getTf_income().getText() + "'";
                }
            } else if (parentWindow.getTf_name().getText().isEmpty() && parentWindow.getTf_surname().getText() != null
                    && parentWindow.getTf_income().getText() != null) {
                if (parentWindow.ch.getSelectedItem().equals("=")) {
                    hql = "from Person as p where p.surname = '" + parentWindow.getTf_surname().getText() + "' and p.income = '" +
                            parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals(">")) {
                    hql = "from Person as p where p.surname = '" + parentWindow.getTf_surname().getText() + "' and p.income > '" +
                            parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals("<")) {
                    hql = "from Person as p where p.surname = '" + parentWindow.getTf_surname().getText() + "' and p.income < '" +
                            parentWindow.getTf_income().getText() + "'";
                }
            } else if (parentWindow.getTf_name().getText() != null && parentWindow.getTf_surname().getText() != null
                    && parentWindow.getTf_income().getText() != null) {
                if (parentWindow.ch.getSelectedItem().equals("=")) {
                    hql = "from Person as p where p.surname = '"
                            + parentWindow.getTf_surname().getText() + "' and p.name = '"
                            + parentWindow.getTf_name().getText() + "' and p.income = '"
                            + parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals(">")) {
                    hql = "from Person as p where p.surname = '"
                            + parentWindow.getTf_surname().getText() + "' and p.name = '"
                            + parentWindow.getTf_name().getText() + "' and p.income > '"
                            + parentWindow.getTf_income().getText() + "'";
                } else if (parentWindow.ch.getSelectedItem().equals("<")) {
                    hql = "from Person as p where p.surname = '"
                            + parentWindow.getTf_surname().getText() + "' and p.name = '"
                            + parentWindow.getTf_name().getText() + "' and p.income < '"
                            + parentWindow.getTf_income().getText() + "'";
                }
            }
            tx = sesija.beginTransaction();
            Query query = sesija.createQuery(hql);
            trazeniZaposleni = query.list();
            tx.commit();
            sb = new StringBuilder();
            for (Person p : trazeniZaposleni) {
                sb.append(p + "\n");
            }
            parentWindow.jta.setText(String.valueOf(sb));
        } catch (NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        if (sb.isEmpty()) {
            JOptionPane.showMessageDialog(parentWindow, "Nema korisnika sa trazenim podacima");
        }
        parentWindow.jta.setText(String.valueOf(sb));
    }
}

