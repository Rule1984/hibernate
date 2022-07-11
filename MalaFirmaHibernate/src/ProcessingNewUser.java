import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProcessingNewUser implements ActionListener {
    private String ime,prezime, adresa;
    private int godine, primanja;
    public NewUserWindow n;
    public Person p;
    ProcessingNewUser(NewUserWindow n){

        this.n = n;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            ime = n.getTf_name().getText();
            prezime = n.getTf_surname().getText();
            adresa = n.getTf_adress().getText();
            godine = Integer.parseInt(n.getTf_age().getText());
            primanja = Integer.parseInt(n.getTf_income().getText());
            p = new Person(ime,prezime,godine,adresa,primanja);

        }
        catch (NumberFormatException numEx){
            JOptionPane.showMessageDialog(n,
                    "Niste pravilno popunili trazena polja \n"+
                            numEx.getMessage(),
                    "greska",
                    JOptionPane.ERROR_MESSAGE);
            n.getTf_name().setText("");
            n.getTf_surname().setText("");
            n.getTf_adress().setText("");
            n.getTf_age().setText("");
            n.getTf_income().setText("");
            return;
        }
        Session sesija = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sesija.beginTransaction();
            sesija.save(p);
            tx.commit();
            JOptionPane.showMessageDialog(n, "Uspesna ste uneli korisnika!");
            n.getTf_name().setText("");
            n.getTf_surname().setText("");
            n.getTf_adress().setText("");
            n.getTf_age().setText("");
            n.getTf_income().setText("");
            //new HomeWindow();
            //n.dispose();
        }
        catch(HibernateException ex) {
            if(tx != null) {
                tx.rollback();
            }
            JOptionPane.showMessageDialog(n,
                    "Nije uspeo unos korisnika \n"+
                            ex.getMessage(),
                    "greska",
                    JOptionPane.ERROR_MESSAGE);
        }
        finally {
            sesija.close();
        }
    }
}