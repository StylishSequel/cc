package GUI;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Main Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        // Khởi tạo cửa sổ với trang HomePage
        getContentPane().add(new HomePage());
       
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}