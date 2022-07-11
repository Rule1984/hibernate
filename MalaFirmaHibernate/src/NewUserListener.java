import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserListener implements ActionListener {
    JFrame parentFrame;
    NewUserListener(JFrame parentFrame){
        this.parentFrame = parentFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new NewUserWindow(parentFrame);
    }
}