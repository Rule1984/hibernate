import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllEmployersListener implements ActionListener {
    HomeWindow parentFrame;
    public AllEmployersListener(HomeWindow parentFrame) {
        this.parentFrame=parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AllEmployersWindow(parentFrame);
    }
}
