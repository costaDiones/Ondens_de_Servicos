package Trabalho.desktop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Trabalho.model.Cliente;
import Trabalho.model.OrdemInterna;
import Trabalho.model.Status;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class CadastraOrdenInt extends JFrame {

	private JLabel jlbDescricao, jlbNomeCliente, jlbData, jlbProblema,
			jlbModelo, jlbPrazoEntrega, jlbCodOrdInt, jlbValor;
	private JTextField jtfDescricao, jtfData, jtfProblema, jtfModelo,
			jtfPrazoEntrega, jtfCodOrdInt, jtfValor;
	private JComboBox jcbNomeCliente;
	private JButton jbtSalvar, jbtListar;

	private JButton jbtSair;

	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");

	public CadastraOrdenInt() {
		setTitle("Cadastra Ordem Interna");
		setLayout(null);

		jlbDescricao = new JLabel("Descriçao Ordem: ");
		jlbDescricao.setBounds(5, 5, 120, 25);
		getContentPane().add(jlbDescricao);

		jtfDescricao = new JTextField();
		jtfDescricao.setBounds(130, 5, 580, 25);
		getContentPane().add(jtfDescricao);

		jlbNomeCliente = new JLabel("Nome do Cliente: ");
		jlbNomeCliente.setBounds(5, 40, 130, 25);
		getContentPane().add(jlbNomeCliente);

		jcbNomeCliente = new JComboBox<>();
		jcbNomeCliente.setBounds(130, 40, 280, 25);
		getContentPane().add(jcbNomeCliente);

		jlbData = new JLabel("Data Ordem: ");
		jlbData.setBounds(5, 80, 80, 25);
		getContentPane().add(jlbData);

		jtfData = new JTextField(" / /");
		jtfData.setBounds(130, 80, 280, 25);
		getContentPane().add(jtfData);

		jlbProblema = new JLabel("Problema: ");
		jlbProblema.setBounds(5, 115, 80, 25);
		getContentPane().add(jlbProblema);

		jtfProblema = new JTextField();
		jtfProblema.setBounds(130, 115, 580, 25);
		getContentPane().add(jtfProblema);

		jlbModelo = new JLabel("Modelo: ");
		jlbModelo.setBounds(5, 150, 80, 25);
		getContentPane().add(jlbModelo);

		jtfModelo = new JTextField();
		jtfModelo.setBounds(130, 150, 180, 25);
		getContentPane().add(jtfModelo);

		jlbPrazoEntrega = new JLabel("Prazo Entrega : ");
		jlbPrazoEntrega.setBounds(5, 185, 180, 25);
		getContentPane().add(jlbPrazoEntrega);

		jtfPrazoEntrega = new JTextField(" / /");
		jtfPrazoEntrega.setBounds(130, 185, 180, 25);
		getContentPane().add(jtfPrazoEntrega);

		jlbValor = new JLabel("Valor Serviço : ");
		jlbValor.setBounds(5, 215, 180, 25);
		getContentPane().add(jlbValor);

		jtfValor = new JTextField();
		jtfValor.setBounds(130, 215, 180, 25);
		getContentPane().add(jtfValor);

		SetaClientes();

		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setBounds(150, 260, 100, 30);
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				OrdemInterna oredenInt = new OrdemInterna();
				ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);

				for (Cliente cliente : clientes) {
					if (cliente.getNome().equals(
							String.valueOf(jcbNomeCliente.getSelectedItem()))) {
						oredenInt.setCliente(cliente);
					}

				}

				oredenInt.setDescricao(jtfDescricao.getText());
				oredenInt.setData(jtfData.getText());
				oredenInt.setModelo(jtfModelo.getText());
				oredenInt.setPrazoEntrega(jtfPrazoEntrega.getText());
				oredenInt.setProblema(jtfProblema.getText());				
				oredenInt.setValor(Double.valueOf((jtfValor.getText())));
				oredenInt.setStatus(Status.NaoFeito);
				

				bancoDeDados.store(oredenInt);
				JOptionPane.showMessageDialog(null, "Ordem Salva!! ");
				bancoDeDados.close();
			dispose();
			new CadastraOrdenInt();
			}
			
		});
		getContentPane().add(jbtSalvar);

		

		jbtSair = new JButton("Sair");
		jbtSair.setBounds(600, 260, 70, 30);
		jbtSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				bancoDeDados.close();
				dispose();
			}
		});
		getContentPane().add(jbtSair);

		setSize(740, 350);
		setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.lightGray);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}

	public void SetaClientes() {

		ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);
		jcbNomeCliente.addItem(null);
		for (Cliente cliente : clientes) {
			jcbNomeCliente.addItem(cliente.getNome());

		}

	}

	public static void main(String[] args) {
		CadastraOrdenInt cadastra = new CadastraOrdenInt();
	}

}
