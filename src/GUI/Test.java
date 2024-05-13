package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Test extends JFrame {
    private JPanel cards; // Panel to contain the menu and content panels
    private JPanel menuPanel; // The menu panel
    private JPanel contentPanel; // The content panel

    public Test() {
        // Initialize the panels
        menuPanel = new JPanel();
        contentPanel = new JPanel();
        cards = new JPanel(new CardLayout());

        // Add the panels to the cards panel
        cards.add(menuPanel, "Menu Panel");
        cards.add(contentPanel, "Content Panel");

        // Add a button to the menu panel to switch to the content panel
        JButton hideMenuButton = new JButton("Hide Menu");
        hideMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "Content Panel");
            }
        });
        menuPanel.add(hideMenuButton);

        // Add a button to the content panel to switch back to the menu panel
        JButton showMenuButton = new JButton("Show Menu");
        showMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "Menu Panel");
            }
        });
        contentPanel.add(showMenuButton);

        // Add the cards panel to the frame
        this.add(cards);
    }

    public static void main(String[] args) {
        Test Test = new Test();
        Test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Test.setSize(400, 400);
        Test.setVisible(true);
    }
}