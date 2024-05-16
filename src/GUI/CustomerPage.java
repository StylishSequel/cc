package GUI;

import javax.swing.*;

public class CustomerPage extends BaseForm{
    public CustomerPage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setBackground(){
        super.setBackground();
    }



    public static void main(String[] args) {
        new CustomerPage();
    }
}
