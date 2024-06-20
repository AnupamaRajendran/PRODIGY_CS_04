import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;

public class KeyLogger extends JFrame implements KeyListener {

    private static final String LOG_FILE = "key_log.txt";

    public KeyLogger() {
        this.setTitle("Key Logger");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        logKey(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        logKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        logKey(e);
    }

    private void logKey(KeyEvent e) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(e.getKeyChar());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        KeyLogger keyLogger = new KeyLogger();
        keyLogger.setVisible(true);
    }
}
