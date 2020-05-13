import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter {
    private JPanel pnlMain;
    private JComboBox cmbCurrencies;
    private JButton btnConvert;
    private JButton btnClear;
    private JButton btnExit;
    private JLabel lblConverted;
    private JTextField txtOriginal;


    public Converter() {

        Model model = new Model();


        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtOriginal.setText("");
                lblConverted.setText("");
                cmbCurrencies.setSelectedIndex(0);
            }
        });

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double usDollar = Double.parseDouble(txtOriginal.getText());
                if (cmbCurrencies.getSelectedItem().equals("Philippine Peso")) {
                    String convert = String.format("PHP %.2f", usDollar * model.philippinePeso);
                    lblConverted.setText(convert);
                }
                if (cmbCurrencies.getSelectedItem().equals("British pound sterling")) {
                    String convert = String.format("GBP %.2f", usDollar * model.poundSterling);
                    lblConverted.setText(convert);
                }
                if (cmbCurrencies.getSelectedItem().equals("Pakistani Rupee")) {
                    String convert = String.format("PKR %.2f", usDollar * model.pakistaniRupee);
                    lblConverted.setText(convert);
                }
                if (cmbCurrencies.getSelectedItem().equals("United Arab Emirates Dirham")) {
                    String convert = String.format("AED %.2f", usDollar * model.uaeDirham);
                    lblConverted.setText(convert);
                }
                if (cmbCurrencies.getSelectedItem().equals("Euro")) {
                    String convert = String.format("EUR %.2f", usDollar * model.euro);
                    lblConverted.setText(convert);
                }
                if (cmbCurrencies.getSelectedItem().equals("Singapore Dollar")) {
                    String convert = String.format("SGD %.2f", usDollar * model.singaporeDollar);
                    lblConverted.setText(convert);
                }
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Currency Converter");
                frame.setSize(new Dimension(500,300));
                frame.setContentPane(new Converter().pnlMain);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // frame.pack();
                frame.setVisible(true);
            }
        });

    }

}
