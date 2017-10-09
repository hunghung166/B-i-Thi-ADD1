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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author nguyenhung
 */
public class CaculatorClient extends JFrame {

    public static void main(String[] args) {
        new CaculatorClient();
    }
    private final JLabel lblKilo;
    private final JLabel lblMiles;
    private final JTextField txtKilo;
    private final JTextField txtMiles;
    private final JButton btnExit;
    private final JButton btnCal;

    public CaculatorClient() {
        this.lblKilo = new JLabel("Kilometers");
        this.lblMiles = new JLabel("Miles");

        this.txtKilo = new JTextField();
        this.txtMiles = new JTextField();

        this.btnCal = new JButton("Calculating");
        this.btnExit = new JButton("Exit");

        this.lblKilo.setBounds(50, 50, 80, 40);
        this.lblMiles.setBounds(50, 150, 80, 40);

        this.txtKilo.setBounds(160, 50, 300, 40);
        this.txtMiles.setBounds(160, 150, 300, 40);

        this.btnCal.setBounds(160, 250, 120, 40);
        this.btnExit.setBounds(300, 250, 120, 40);
        
        this.btnCal.addActionListener(new Calculating());
        this.btnExit.addActionListener(new Exit());

        this.add(lblKilo);
        this.add(lblMiles);
        this.add(txtKilo);
        this.add(txtMiles);
        this.add(btnCal);
        this.add(btnExit);

        this.setTitle("Caculator client");
        this.setSize(600, 400);
        this.setLayout(null);
        this.setVisible(true);

    }

    class Calculating implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                KhuonMauTuXa khuon = (KhuonMauTuXa) Naming.lookup("rmi://localhost:9000/chuyendoi");
                float b = khuon.ChuyenDoi(Float.parseFloat(txtKilo.getText()));
                txtMiles.setText(b + "");

            } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    class Exit implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }

}
