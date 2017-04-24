package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import business.DataManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class CheckOutCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldCPF;
	private JLabel lblCpf;


	/**
	 * Create the frame.
	 */
	public CheckOutCliente(DataManager data) {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("CheckOut de Cliente");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 393, 66);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtFieldCPF = new JTextField();
		txtFieldCPF.setColumns(10);

		JButton btnProcurar = new JButton("CheckOut");
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(data.clienteEstaNoBar(txtFieldCPF.getText())){
					data.removerCliente(txtFieldCPF.getText());
					JOptionPane.showMessageDialog(null, "Check Out Feito!");
				}
				else
					JOptionPane.showMessageDialog(null, "O cliente não estava no bar");
				txtFieldCPF.setText("");		

			}
		});

		lblCpf = new JLabel("CPF:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(lblCpf)
						.addGap(18)
						.addComponent(txtFieldCPF, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnProcurar)
						.addContainerGap(60, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(txtFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnProcurar))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}

}
