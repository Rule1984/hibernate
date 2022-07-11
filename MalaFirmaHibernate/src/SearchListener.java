import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener {
    JFrame home;
    public SearchListener(JFrame home) {
        this.home= home;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SearchEmloyerWindow(home);
    }
}
