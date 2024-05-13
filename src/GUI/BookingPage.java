package GUI;
import javax.swing.*;
// import javax.swing.border.EmptyBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;

import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Map;
import java.awt.font.TextAttribute;

//ConnectDatabase libary 
import ConnectDatabase.*;
import Room.*;
public class BookingPage extends BaseForm {
    public BookingPage() {
        super();
           
    }
    
    @Override
    public void setMenuPanel(){
        super.setMenuPanel(); // Gọi phương thức của lớp cha để thực hiện các thao tác trong đó

        // Thêm nút mới vào MenuPanel
        JButton bookRoomButton = new JButton("Book Room");
        bookRoomButton.setFont(new Font("Arial", Font.PLAIN, 20));
        bookRoomButton.setBounds(0, 350, 200, 50); // Đặt vị trí và kích thước cho nút mới
        MenuPanel.add(bookRoomButton); // Thêm nút vào MenuPanel của lớp cha
    }

    public static void main(String[] args) {
        new BookingPage();
    }
}

