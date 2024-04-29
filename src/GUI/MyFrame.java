package GUI;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("Set Bounds Example");

        // Tạo một JButton
        JButton button = new JButton("Click Me");

        // Đặt vị trí và kích thước cho JButton
        button.setBounds(50, 50, 100, 30);

        // Thêm JButton vào JFrame
        add(button);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
