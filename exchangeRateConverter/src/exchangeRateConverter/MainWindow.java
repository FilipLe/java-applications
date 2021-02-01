package exchangeRateConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainWindow {

	private JFrame frmCurrencyConverter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmCurrencyConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurrencyConverter = new JFrame();
		frmCurrencyConverter.setTitle("Currency Converter");
		frmCurrencyConverter.setBounds(100, 100, 203, 161);
		frmCurrencyConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrencyConverter.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("US Dollar");
		lblNewLabel.setBounds(17, 16, 61, 16);
		frmCurrencyConverter.getContentPane().add(lblNewLabel);
		
		JLabel lblBitcoin = new JLabel("Bitcoin");
		lblBitcoin.setBounds(17, 50, 61, 16);
		frmCurrencyConverter.getContentPane().add(lblBitcoin);
		
		JLabel usdLabel = new JLabel("USD amount");
		usdLabel.setBounds(105, 16, 106, 16);
		frmCurrencyConverter.getContentPane().add(usdLabel);
		
		JButton updateButton = new JButton("UPDATE");
		updateButton.setBounds(6, 90, 179, 37);
		frmCurrencyConverter.getContentPane().add(updateButton);
		
		JSpinner btcSpinner = new JSpinner();
		//Default starting BTC value in placeholder = 50
		//Min value = 0
		//Max value = 100
		//Every arrow increment by 1.0
		btcSpinner.setModel(new SpinnerNumberModel(50.0, 0.0, 100.0, 1.0));
		btcSpinner.setBounds(99, 45, 86, 26);
		frmCurrencyConverter.getContentPane().add(btcSpinner);
		
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Converter converter = new Converter();
				double btc= (Double)btcSpinner.getValue();
				double usd = converter.btcToUsd(btc);
				usdLabel.setText(Double.toString(usd));
			}
		});
		
		
	}
}
