package sample;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        //create the components
        canvas = new DrawingPanel(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        this.getContentPane().add(label);

        //Display the window.
        this.add(canvas, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
    public ConfigPanel getConfigPanel(){
        return configPanel;
    }
}