package net.Wilckens.Pong;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

abstract class GameBase extends JComponent {
    // technical details:
    private JFrame window;
    protected KeyTracker keys;
    private Thread sleepyThread;
    private boolean running;
    GameBase(JFrame window) {
        this.window = window;
        // Using a Thread.sleep makes smoother animation than using either java.util.Timer
        // or javax.swing.Timer.
        // Yes, for this obscure reason (seems to be Windows-only?):
        // 'Having a sleeping thread forces the VM to use the high-precision timer.' 
        // --http://www.java-gaming.org/index.php/topic,24112.
        // without this, the animation is choppy.  Ugh.
        final Runnable doUpdate = new Runnable() {
            @Override
            public void run() {
                update();
            }
        };
        running = true;
        sleepyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int counter = 0;
                    long lastFrame = System.currentTimeMillis();
                    while (running) {
                        // we want 60 FPS...
                        // ensure 3 frames = 50 ms: (alternatively, just do Thread.sleep(16)...)
                        // still gives some jitter, but seems to be the best of the alternatives I am aware of...
                        int delay_ms = 16;
                        counter++;
                        if (counter > 2) {
                             counter = 0;
                             delay_ms = 16;
                        }
                        // this compensates for some inaccuracies of the sleep method
                        while (System.currentTimeMillis() - lastFrame < delay_ms)
                            Thread.sleep(1);
                        
                        // we want to invoke update() on the swing EDT...
                        // 'cause that's what you're supposed to do ('Don't update
                        // GUI except on EDT' they always say...)
                        // but seems to be work the same if we just say update() here...
                        SwingUtilities.invokeLater(doUpdate);                        
                        repaint();
                        lastFrame = System.currentTimeMillis();
                    }
                } catch (Exception e) {
                }
            }
        });        
        keys = new KeyTracker(this);        
    }
    public void start() {
        sleepyThread.start();
    }
    // this is only needed because we can't 'X' out
    public void quit() {
        window.dispose();
        running = false;
    }
    
    // YOU need to write this method:
    public abstract void update();
}