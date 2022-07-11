import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEmloyerWindow extends JFrame {
    JPanel searchPanel;
    private JLabel jl_name, jl_surname, jl_income;
    private JTextField tf_name, tf_surname;
    public  JTextField tf_income;
    public JTextArea jta;
    public Choice ch;


    public JTextField getTf_name() {
        return tf_name;
    }

    public JTextField getTf_surname() {
        return tf_surname;
    }

    public JTextField getTf_income() {
        return tf_income;
    }

    public JScrollPane jscp;
    public JButton jb_cancel, jb_ok;
    SearchEmloyerWindow (JFrame parentFrame){
        setTitle("Search");
        setSize(new Dimension(500,480));
        setLocationRelativeTo(parentFrame);
        parentFrame.dispose();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponent();
        addListeners();
        setVisible(true);

    }

    private void addListeners() {

        jb_ok.addActionListener(new SearchEmployersListener(this));
        jb_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeWindow();
            }
        });
    }

    private void addComponent() {
        searchPanel = new JPanel();
        searchPanel = new JPanel();
        SpringLayout sp = new SpringLayout();
        searchPanel.setLayout(sp);
        jl_name = new JLabel("Name");
        jl_name.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_name, 40,SpringLayout.NORTH, searchPanel);
        sp.putConstraint(SpringLayout.WEST, jl_name,25, SpringLayout.WEST, searchPanel);
        tf_name = new JTextField();
        tf_name.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_name, 0,SpringLayout.NORTH, jl_name);
        sp.putConstraint(SpringLayout.WEST, tf_name,20, SpringLayout.EAST, jl_name);
        jl_surname = new JLabel("Surname");
        jl_surname.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_surname, 20,SpringLayout.SOUTH, jl_name);
        sp.putConstraint(SpringLayout.WEST, jl_surname,0, SpringLayout.WEST, jl_name);
        tf_surname = new JTextField();
        tf_surname.setPreferredSize(new Dimension(200,20));
        sp.putConstraint(SpringLayout.NORTH, tf_surname, 20,SpringLayout.SOUTH, tf_name);
        sp.putConstraint(SpringLayout.WEST, tf_surname,0, SpringLayout.WEST, tf_name);
        jl_income = new JLabel("Income");
        jl_income.setPreferredSize(new Dimension(150,20));
        sp.putConstraint(SpringLayout.NORTH, jl_income, 20,SpringLayout.SOUTH, jl_surname);
        sp.putConstraint(SpringLayout.WEST, jl_income,0, SpringLayout.WEST, jl_surname);
        ch = new Choice();
        ch.add("=");
        ch.add("<");
        ch.add(">");
        sp.putConstraint(SpringLayout.NORTH, ch, 0,SpringLayout.NORTH, jl_income);
        sp.putConstraint(SpringLayout.WEST, ch,20, SpringLayout.EAST, jl_income);
        tf_income = new JTextField();
        tf_income.setPreferredSize(new Dimension(140,22));
        sp.putConstraint(SpringLayout.NORTH, tf_income, 20,SpringLayout.SOUTH, tf_surname);
        sp.putConstraint(SpringLayout.WEST, tf_income,60, SpringLayout.WEST, tf_surname);
        tf_income.setToolTipText("unesite prvo operaciju po kojoj zelite da se vrsi pretraga (<,>,=), potom iznos");
        jb_cancel = new JButton("cancel");
        jb_cancel.setPreferredSize(new Dimension(80,20));
        jb_ok = new JButton("ok");
        jb_ok.setPreferredSize(new Dimension(80,20));
        sp.putConstraint(SpringLayout.NORTH, jb_cancel,180, SpringLayout.NORTH, searchPanel);
        sp.putConstraint(SpringLayout.WEST, jb_cancel,130,SpringLayout.WEST, searchPanel);
        sp.putConstraint(SpringLayout.NORTH, jb_ok,0, SpringLayout.NORTH, jb_cancel);
        sp.putConstraint(SpringLayout.WEST, jb_ok,60,SpringLayout.EAST, jb_cancel);

        jta = new JTextArea(10,35);
        jta.setPreferredSize(new Dimension(400,400));
        jscp = new JScrollPane(jta);
        jta.setWrapStyleWord(false);
        jta.setLineWrap(true);
        sp.putConstraint(SpringLayout.NORTH, jscp,230,SpringLayout.NORTH,searchPanel);
        sp.putConstraint(SpringLayout.WEST, jscp, 40, SpringLayout.WEST,searchPanel);
        jta.setBackground(Color.gray);
        jta.setEditable(false);




        searchPanel.add(jl_name);
        searchPanel.add(tf_name);
        searchPanel.add(jl_surname);
        searchPanel.add(tf_surname);
        searchPanel.add(jl_income);
        searchPanel.add(ch);
        searchPanel.add(tf_income);
        searchPanel.add(jb_cancel);
        searchPanel.add(jb_ok);
        searchPanel.add(jscp);

        setContentPane(searchPanel);
    }
}
