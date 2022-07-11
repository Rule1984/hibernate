import javax.swing.*;
import java.awt.*;

public class UpdateUserByIDWindow extends JFrame {
    JPanel updateUserID;
    private JLabel jl_textID;
    public static JTextField jtf_userID;
    private JButton jb_ok;
    public Person p = null;

    public UpdateUserByIDWindow(JFrame parentFrame){
        setSize(200,150);
        setLocationRelativeTo(parentFrame);
        setTitle("Update user");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addComponent();
        setVisible(true);
        jb_ok.addActionListener(new UpdateUserListener(this));

    }

    private void addComponent() {
        updateUserID = new JPanel();
        SpringLayout sp = new SpringLayout();
        updateUserID.setLayout(sp);
        jl_textID = new JLabel("insert ID");
        jl_textID.setPreferredSize(new Dimension(60,20));
        sp.putConstraint(SpringLayout.NORTH, jl_textID, 20, SpringLayout.NORTH,updateUserID);
        sp.putConstraint(SpringLayout.WEST, jl_textID, 70, SpringLayout.WEST,updateUserID);
        jtf_userID = new JTextField();
        jtf_userID.setPreferredSize(new Dimension(60,20));
        jtf_userID.setToolTipText("Unesite ID korinika kojem zelite da promenite podatke");
        sp.putConstraint(SpringLayout.NORTH, jtf_userID, 10, SpringLayout.SOUTH,jl_textID);
        sp.putConstraint(SpringLayout.WEST, jtf_userID, 0, SpringLayout.WEST,jl_textID);
        jb_ok = new JButton("OK");
        jb_ok.setPreferredSize(new Dimension(60,20));
        sp.putConstraint(SpringLayout.NORTH, jb_ok, 10, SpringLayout.SOUTH,jtf_userID);
        sp.putConstraint(SpringLayout.WEST, jb_ok, 0, SpringLayout.WEST,jtf_userID);
        updateUserID.add(jl_textID);
        updateUserID.add(jtf_userID);
        updateUserID.add(jb_ok);
        setContentPane(updateUserID);

    }

    public JTextField getJtf_userID() {
        return jtf_userID;
    }
}