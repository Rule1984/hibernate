import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateListener implements ActionListener {
    JFrame parentFrame;
    UpdateListener(JFrame parentFrame){
        this.parentFrame = parentFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new UpdateUserByIDWindow(parentFrame);
    }
}
