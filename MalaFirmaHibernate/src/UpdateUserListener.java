import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserListener implements ActionListener {
    UpdateUserByIDWindow uuw;

    public UpdateUserListener(UpdateUserByIDWindow uuw) {
        this.uuw = uuw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Session sesija = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesija.beginTransaction();
            uuw.p = sesija.get(Person.class, Integer.parseInt(uuw.getJtf_userID().getText()));
            tx.commit();
            if (uuw.p!=null)
                new UpdateUserWindow(uuw);
            else
                JOptionPane.showMessageDialog(uuw, "Niste uneli ispravan ID kosrinika, korisnik sa unetim ID-jem ne postoji u bazi!");

        } catch (NumberFormatException throwables) {
            JOptionPane.showMessageDialog(uuw, "Niste uneli ispravan ID kosrinika");
        }
    }
}