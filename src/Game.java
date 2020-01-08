import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {
    private Display display;
    private Thread thread;
    private int width, height;
    public String title;
    public boolean running=false;
    private KeyManager keyManager;
    private GameCamera gameCamera;
    private Handler handler;
    public State gameState, gameOverState;
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        }
    private  void init(){
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);

        Asset.init();
        gameCamera = new GameCamera(this,0, 0);
        handler = new Handler(this);
        State gameState = new GameState(handler);
        State gameOverState = new GameOverState(handler);
        State.setState(gameState);
    }
    private void update(){
        keyManager.update();
        if(State.getState() != null)
            State.getState().update();

    }

    private void render(){
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //clear scr
        g.clearRect(0,0,width,height);
        //Draw
        if(State.getState() != null)
            State.getState().render(g);


        //End Draw
        bs.show();
        g.dispose();
    }
    public void run(){
        init();

        while(running){
            update();
            render();
        }

        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public int getWidth(){
        return  width;
    }

    public int getHeight(){
        return height;
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
           return;
        running = false;
        try {
            thread.join();
        }
        catch ( InterruptedException e ){
            e.printStackTrace();
        }
    }



}
