import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {
    JFrame parentFrame;
    DeleteListener(JFrame parentFrame){
        this.parentFrame = parentFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new DeleteWindow(parentFrame);
    }
}