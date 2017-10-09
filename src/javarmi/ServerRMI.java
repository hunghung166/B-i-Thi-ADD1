/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author nguyenhung
 */
public class ServerRMI extends JFrame {

    public static void main(String[] args) {
        new ServerRMI();
    }

    JTextArea textArea = new JTextArea();
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JButton btnExit = new JButton("Exit");

    public ServerRMI() {
        this.setLayout(null);
        this.setTitle("Server RMI");
        this.setSize(600, 400);

        this.textArea.setBounds(0, 0, 600, 200);
        this.btnStart.setBounds(40, 250, 150, 50);
        this.btnStop.setBounds(220, 250, 150, 50);
        this.btnExit.setBounds(400, 250, 150, 50);

        this.add(textArea);
        this.add(btnStart);
        this.add(btnStop);
        this.add(btnExit);

        this.btnStart.addActionListener(new Start());
        this.btnExit.addActionListener(new Cancel());
        this.btnExit.addActionListener(new Stop());

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    class Start implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                LocateRegistry.createRegistry(9000);
                PhuongThucTuXa tuxa = new PhuongThucTuXa();
                Naming.rebind("rmi://localhost:9000/chuyendoi", tuxa);
                textArea.setText("Sever is running...");
            } catch (RemoteException | MalformedURLException ex) {
                Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class Cancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    class Stop implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    }

}
