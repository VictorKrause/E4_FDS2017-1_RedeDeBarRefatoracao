package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.*;
import persistence.FileProcess;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckInCliente extends JFrame {

	private ArrayList<Cliente> clientesAntigos;
	private JPanel contentPane;
	private JTextField txtFieldNome;
	private JTextField txtFieldIdade;
	private JTextField txtFieldCPF;
	private JTextField txtFieldMatricula;
	private FileProcess processador;

	/**
	 * Create the frame.
	 */
	public CheckInCliente(DataManager data) {
		processador = new FileProcess();
		setResizable(false);
		setTitle("Check In de Cliente");
		setBounds(100, 100, 514, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnCheckIn = new JButton("Check In");


		JLabel lblNome = new JLabel("Nome:");

		txtFieldNome = new JTextField();
		txtFieldNome.setColumns(10);

		JLabel lblIdade = new JLabel("Idade:");

		txtFieldIdade = new JTextField();
		txtFieldIdade.setColumns(10);

		JLabel lblGnero = new JLabel("G\u00EAnero:");

		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));

		txtFieldCPF = new JTextField();
		txtFieldCPF.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");

		JLabel lblNewLabel = new JLabel("Tipo de Cliente");
		JLabel MatriculaSocio = new JLabel("Matricula: ");
		txtFieldMatricula = new JTextField();
		txtFieldMatricula.setVisible(false);
		MatriculaSocio.setVisible(false);

		JComboBox comboBoxSocio = new JComboBox();
		comboBoxSocio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				if(comboBoxSocio.getSelectedItem().equals("Cliente Normal")){
					txtFieldMatricula.setVisible(false);
					MatriculaSocio.setVisible(false);
				}
				else{
					txtFieldMatricula.setVisible(true);
					MatriculaSocio.setVisible(true);

				}
			}
		});
		comboBoxSocio.setModel(new DefaultComboBoxModel(new String[] {"Cliente Normal", "Cliente S\u00F3cio"}));

		txtFieldMatricula.setForeground(Color.BLACK);
		txtFieldMatricula.setBackground(Color.WHITE);
		txtFieldMatricula.setEditable(true);
		txtFieldMatricula.setColumns(10);

		btnCheckIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{

					if(comboBoxSocio.getSelectedItem().equals("Cliente Normal")){
						Cliente cli = new Cliente(txtFieldNome.getText(), txtFieldCPF.getText(), Integer.parseInt(txtFieldIdade.getText()), 
								(String)comboBoxGenero.getSelectedItem());
						if(data.clienteEstaNoBar(txtFieldCPF.getText()))
							JOptionPane.showMessageDialog(null, "Cliente Já Está no Bar");					
						else{
							data.adicionarCliente(cli);
							processador.write(cli);
							JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
						}
					}
					else{
						ClienteSocio cli = new ClienteSocio(txtFieldNome.getText(), txtFieldCPF.getText(), Integer.parseInt(txtFieldIdade.getText()), 
								(String)comboBoxGenero.getSelectedItem(), txtFieldMatricula.getText());
						if(data.clienteEstaNoBar(txtFieldCPF.getText()))
							JOptionPane.showMessageDialog(null, "Cliente Já Está no Bar");
						else	{			
							data.adicionarCliente(cli);
							processador.write(cli);
							JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
						}
					}
					txtFieldNome.setText("");
					txtFieldCPF.setText("");
					txtFieldMatricula.setText("");
					txtFieldIdade.setText("");

				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Verifique os dados informados");
					txtFieldNome.setText("");
					txtFieldCPF.setText("");
					txtFieldMatricula.setText("");
					txtFieldIdade.setText("");
				}

			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNome)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(txtFieldNome, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblIdade)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(txtFieldIdade, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblGnero)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(comboBoxGenero, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblCpf)
														.addGap(18)
														.addComponent(txtFieldCPF, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(204, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnCheckIn)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblNewLabel)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(comboBoxSocio, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(MatriculaSocio)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(txtFieldMatricula, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
										.addContainerGap())))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(comboBoxSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(MatriculaSocio)
								.addComponent(txtFieldMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(txtFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIdade)
								.addComponent(txtFieldIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGnero)
								.addComponent(comboBoxGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(txtFieldCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCheckIn)
						.addGap(241))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
