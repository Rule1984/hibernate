import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteWindow extends JFrame {
    JPanel erasePanel;
    private JLabel jl_eraseID;
    public static JTextField jtf_eraseID;
    private JButton jb_ok;
    private String name, surname;
    Person osobaZaBrisanje=null;

    public DeleteWindow(JFrame parentFrame){
        setSize(200,150);
        setLocationRelativeTo(parentFrame);
        setTitle("Erase user");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addComponent();
        setVisible(true);
        jb_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Session sesija = HibernateUtil.createSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = sesija.beginTransaction();
                    osobaZaBrisanje = sesija.get(Person.class, Integer.parseInt(jtf_eraseID.getText()));

                    if (osobaZaBrisanje!=null){
                        name = osobaZaBrisanje.getName();
                        surname = osobaZaBrisanje.getSurname();
                        sesija.delete(osobaZaBrisanje);
                        tx.commit();
                        JOptionPane.showMessageDialog(parentFrame,"Uspesno ste obrisali korisnika sa ID-jem = "+Integer.parseInt(jtf_eraseID.getText())+"("+name+" "+surname+")");
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(parentFrame,"Ne postoji korisnik sa trazenim ID-jem");
                }
                catch (NumberFormatException throwables){
                    JOptionPane.showMessageDialog(parentFrame,"Ne postoji korisnik sa trazenim ID-jem");
                }
                sesija.close();
            }
        });
    }

    private void addComponent() {
        erasePanel = new JPanel();
        SpringLayout sp = new SpringLayout();
        erasePanel.setLayout(sp);
        jl_eraseID = new JLabel("insert ID");
        jl_eraseID.setPreferredSize(new Dimension(60,20));
        sp.putConstraint(SpringLayout.NORTH, jl_eraseID, 20, SpringLayout.NORTH, erasePanel);
        sp.putConstraint(SpringLayout.WEST, jl_eraseID, 70, SpringLayout.WEST, erasePanel);
        jtf_eraseID = new JTextField();
        jtf_eraseID.setPreferredSize(new Dimension(60,20));
        jtf_eraseID.setToolTipText("Unesite ID korinika kojeg zelite da izbrisete");
        sp.putConstraint(SpringLayout.NORTH, jtf_eraseID, 10, SpringLayout.SOUTH, jl_eraseID);
        sp.putConstraint(SpringLayout.WEST, jtf_eraseID, 0, SpringLayout.WEST, jl_eraseID);
        jb_ok = new JButton("OK");
        jb_ok.setPreferredSize(new Dimension(60,20));
        sp.putConstraint(SpringLayout.NORTH, jb_ok, 10, SpringLayout.SOUTH,jtf_eraseID);
        sp.putConstraint(SpringLayout.WEST, jb_ok, 0, SpringLayout.WEST,jtf_eraseID);
        erasePanel.add(jl_eraseID);
        erasePanel.add(jtf_eraseID);
        erasePanel.add(jb_ok);
        setContentPane(erasePanel);

    }
}
