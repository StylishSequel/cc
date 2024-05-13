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

        
    }

    public static void main(String[] args) {
        new BookingPage();
    }
}

