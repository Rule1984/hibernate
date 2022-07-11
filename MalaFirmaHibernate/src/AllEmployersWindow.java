import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AllEmployersWindow extends JFrame {
    JPanel allEmpPanel;
    JTextArea jte_allE;
    JButton jb_back;
    JScrollPane jsp;
    StringBuilder sb;
    List<Person> sviZaposleni;

    public AllEmployersWindow(HomeWindow parentFrame) {
        setSize(new Dimension(500, 300));
        setTitle("All Employers from DataBase");
        setLocationRelativeTo(parentFrame);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        parentFrame.dispose();
        addComponents();
        jb_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeWindow();
            }
        });
        setResizable(false);
        setVisible(true);
    }

    private void addComponents() {
        allEmpPanel = new JPanel();
        allEmpPanel.setLayout(new FlowLayout());
        jte_allE = new JTextArea(10, 35);
        jte_allE.setPreferredSize(new Dimension(400, 400));
        jsp = new JScrollPane(jte_allE);
        jte_allE.setWrapStyleWord(false);
        jte_allE.setLineWrap(true);
        jte_allE.setBackground(Color.gray);
        jte_allE.setEditable(false);
        allEmpPanel.add(jsp);
        jb_back = new JButton("back");
        jb_back.setPreferredSize(new Dimension(80, 30));
        allEmpPanel.add(jb_back);
        Session sesija = HibernateUtil.createSessionFactory().openSession();
        Transaction tx = null;
        String hql = "from Person";
        try {
            tx = sesija.beginTransaction();
            Query query = sesija.createQuery(hql);
            sviZaposleni = query.list();
            tx.commit();
            sb = new StringBuilder();
            for (Person p : sviZaposleni) {
                sb.append(p + "\n");
            }
            jte_allE.setText(String.valueOf(sb));
        } catch (NumberFormatException throwables) {
            throwables.printStackTrace();
        }
        setContentPane(allEmpPanel);
    }
}
