package uinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import business.*;
import persistence.FileProcess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StartMainClass extends JFrame {

	private JPanel contentPane;
	private JTable tableClientesNoBar;
	private ArrayList<Cliente> clientesPresentes;
	private DataManager data;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMainClass frame = new StartMainClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public StartMainClass() throws FileNotFoundException {
		setTitle("Silva Bar");
		data = new DataManager();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblClientesNoBar = new JLabel("Clientes no Bar");

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {		

				DefaultTableModel model = (DefaultTableModel) tableClientesNoBar.getModel();
				model.setRowCount(0);

				addRowToTable();
			}
		});

		JButton btnCheckInCliente = new JButton("Check In de Cliente");
		btnCheckInCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CheckInCliente checkin = new CheckInCliente(data);
				checkin.setVisible(true);

			}
		});


		JButton btnDistribuioPorGnero = new JButton("Distribui\u00E7\u00E3o por g\u00EAnero");
		btnDistribuioPorGnero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{


					double percentHomens = data.getPorcentagemDeHomens();
					double percentMulheres = data.getPorcentagemDeMulheres();
					JOptionPane.showMessageDialog(null, (int)percentHomens+"% dos clientes são homens e "
							+ (int)(100-percentHomens)+ "% são mulheres");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Não há clientes no bar");
				}
			}

		});

		JButton btnQuantidadeDeScios = new JButton("Quantidade de s\u00F3cios");
		btnQuantidadeDeScios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					JOptionPane.showMessageDialog(null, data.qtdSocios()+" clientes são sócios");
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Não há clientes no bar");
				}
			}
		});

		JButton btnCheckoutDeCliente = new JButton("Check Out de Cliente");
		btnCheckoutDeCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckOutCliente checkout = new CheckOutCliente(data);
				checkout.setVisible(true);
			}
		});

		JButton btnProcurarPorCliente = new JButton("Procurar por Cliente");
		btnProcurarPorCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProcurarCliente search = new ProcurarCliente(data);
				search.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnCheckInCliente)
												.addComponent(btnQuantidadeDeScios)
												.addComponent(btnDistribuioPorGnero)
												.addComponent(btnCheckoutDeCliente)
												.addComponent(btnProcurarPorCliente))
										.addGap(36)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblClientesNoBar)
										.addGap(39)
										.addComponent(btnAtualizar)
										.addGap(212))))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAtualizar)
								.addComponent(lblClientesNoBar))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnCheckInCliente)
										.addGap(22)
										.addComponent(btnDistribuioPorGnero)
										.addGap(24)
										.addComponent(btnQuantidadeDeScios)
										.addGap(15)
										.addComponent(btnProcurarPorCliente)
										.addGap(21)
										.addComponent(btnCheckoutDeCliente)))
						.addGap(52))
				);

		tableClientesNoBar = new JTable();
		tableClientesNoBar.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Idade", "Genero","Socio","Numero de Socio"
				}
				));
		tableClientesNoBar.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableClientesNoBar.getColumnModel().getColumn(1).setPreferredWidth(40);
		tableClientesNoBar.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableClientesNoBar.getColumnModel().getColumn(3).setPreferredWidth(80);
		tableClientesNoBar.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(tableClientesNoBar);
		contentPane.setLayout(gl_contentPane);


	}


	public void addRowToTable(){
		clientesPresentes = data.getClientes(); 
		DefaultTableModel model = (DefaultTableModel) tableClientesNoBar.getModel();
		Object rowData[] = new Object[5];
		for(Cliente cli : clientesPresentes){
			rowData[0] = cli.getNome();
			rowData[1]=cli.getIdade();
			rowData[2]=cli.getGenero();
			if(cli instanceof ClienteSocio){
				ClienteSocio cliSocio = (ClienteSocio) cli;
				rowData[3]="Sim";
				rowData[4]=cliSocio.getNumSocio();
			}
			else{
				rowData[3]="Nao";
				rowData[4]="N/A";
			}

			model.addRow(rowData);

		}

	}

}
