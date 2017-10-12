package linkdb;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Window.Type;

public class linkdb {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					linkdb window = new linkdb();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public linkdb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setResizable(false);
		frame.setTitle("\u7528\u6237\u4FE1\u606F");
		frame.setBounds(100, 100, 443, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font(Font.DIALOG,Font.PLAIN,32);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		JLabel lblNewLabel2 = new JLabel("");
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel name = new JLabel("");
		name.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(name);
		name.setFont(font );
		name.setText("用户");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel address = new JLabel("");
		address.setText("用户");
		address.setVerticalAlignment(SwingConstants.TOP);
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setFont(new Font("Dialog", Font.PLAIN, 32));
		panel.add(address);
	}

}
