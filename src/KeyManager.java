import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[] keys;
    public boolean len, xuong, trai, phai;
    public KeyManager(){
        keys = new boolean[100];
    }
    public void update(){
        len = keys[KeyEvent.VK_UP];
        xuong = keys[KeyEvent.VK_DOWN];
        trai = keys[KeyEvent.VK_LEFT];
        phai = keys[KeyEvent.VK_RIGHT];
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
