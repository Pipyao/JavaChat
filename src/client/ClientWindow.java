package client;

import javax.swing.*;
import java.awt.*;

public class ClientWindow {

        private JFrame frame;
        private JTextField messageField;
        private static JTextArea textArea = new JTextArea();

        private Client client;

    public static void main(String[] args){
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try{
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        ClientWindow window = new ClientWindow();
                        window.frame.setVisible(true);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

        public ClientWindow(){
            initialize();

            String name = JOptionPane.showInputDialog("Enter name");
            client = new Client(name, "localhost", 52864);
        }
        private void initialize(){
            frame = new JFrame();
            frame.setResizable(false);
            frame.setTitle("Chat Program\r\n");
            frame.setBounds(100,100,638,472);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(new BorderLayout(0, 0));


            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.getContentPane().add(scrollPane);

            JPanel panel = new JPanel();
            frame.getContentPane().add(panel, BorderLayout.SOUTH);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

            messageField = new JTextField();
            panel.add(messageField);
            messageField.setColumns(50);

            JButton btnSend = new JButton("Send");
            btnSend.addActionListener(e -> {

            });
            panel.add(btnSend);

            frame.setLocationRelativeTo(null);

        }


        public static void printToConsole (String message){
            textArea.setText(textArea.getText()+message+"\n");
        }
}
