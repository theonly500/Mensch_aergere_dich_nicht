import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameStartUp {

    public GameStartUp(){
        JFrame startUpFrame=new JFrame("Player Selection");
        startUpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel basePanel=new JPanel();
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        JPanel nameSelectionPanel=new JPanel();
        nameSelectionPanel.setLayout(new BoxLayout(nameSelectionPanel, BoxLayout.X_AXIS));
        basePanel.add(nameSelectionPanel);
        JPanel[] nameColorConection=new JPanel[4];
        JLabel[] colorToName=new JLabel[4];
        colorToName[0]=new JLabel("Blue");
        colorToName[1]=new JLabel("Green");
        colorToName[2]=new JLabel("Yellow");
        colorToName[3]=new JLabel("Red");
        JFormattedTextField[] nameToColor=new JFormattedTextField[4];
        for(int i=0;i<4;i++){
            final int tempInt = i;
            nameToColor[i]=new JFormattedTextField();
            nameToColor[i].setText("Playername");
            nameToColor[i].setForeground(new Color(155, 155, 155));
            nameToColor[i].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (nameToColor[tempInt].getText().contentEquals("Playername")) {
                        nameToColor[tempInt].setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (nameToColor[tempInt].getText().contentEquals("")) {
                        nameToColor[tempInt].setText("Playername");
                        nameToColor[tempInt].setForeground(new Color(155, 155, 155));
                    }
                    else{
                        nameToColor[tempInt].setForeground(new Color(0,0,0));
                    }
                }
            });
            nameToColor[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    nameToColor[tempInt].setForeground(new Color(0, 0, 0));
                }
            });

                    nameColorConection[i] = new JPanel();
            nameColorConection[i].setLayout(new BoxLayout(nameColorConection[i], BoxLayout.Y_AXIS));
            nameColorConection[i].add(colorToName[i]);
            nameColorConection[i].add(nameToColor[i]);
            nameSelectionPanel.add(nameColorConection[i]);
        }
        startUpFrame.setContentPane(basePanel);
        startUpFrame.pack();
        startUpFrame.setLocationRelativeTo(null);
        startUpFrame.setVisible(true);
    }
}
