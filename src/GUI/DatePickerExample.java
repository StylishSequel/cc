package GUI;
import javax.swing.*;
import org.jdatepicker.impl.*;
import java.util.Properties;

public class DatePickerExample {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Date Picker Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        // Cài đặt thuộc tính cho JDatePicker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Đặt vị trí và kích thước cho JDatePicker
        datePicker.setBounds(50, 50, 200, 30);

        // Thêm JDatePicker vào JFrame
        frame.add(datePicker);

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    // Tạo class DateLabelFormatter để định dạng ngày tháng
    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws java.text.ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws java.text.ParseException {
            if (value != null) {
                java.util.Calendar cal = (java.util.Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }
    }
}