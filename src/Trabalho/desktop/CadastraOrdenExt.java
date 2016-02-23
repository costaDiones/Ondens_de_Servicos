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
import Trabalho.model.OrdemExterna;
import Trabalho.model.Status;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class CadastraOrdenExt extends JFrame {

	private JLabel jlbDescricao, jlbNomeCliente, jlbData, jlbProblema,
			jlbModelo, jlbPrazoEntrega, jlbCodOrdInt, jlbValor, jlbLocal, jlbEnd;
	private JTextField jtfDescricao, jtfNomeCliente, jtfData, jtfProblema,
			jtfModelo, jtfPrazoEntrega, jtfCodOrdExt, jtfValor, jtfLocal;
	private JButton jbtSalvar, jbtSair;
	private JComboBox jcbNomeCliente;
	
	
	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");

	public CadastraOrdenExt() {
		setTitle("Cadastra Ordem Externa");
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

		jlbPrazoEntrega = new JLabel("Prazo ser Feito : ");
		jlbPrazoEntrega.setBounds(5, 185, 180, 25);
		getContentPane().add(jlbPrazoEntrega);

		jtfPrazoEntrega = new JTextField(" / /");
		jtfPrazoEntrega.setBounds(130, 185, 180, 25);
		getContentPane().add(jtfPrazoEntrega);


		jlbValor = new JLabel("Valor Serviço : ");
		jlbValor.setBounds(5, 270, 180, 25);
		getContentPane().add(jlbValor);

		jtfValor = new JTextField();
		jtfValor.setBounds(130, 270, 180, 25);
		getContentPane().add(jtfValor);

		jlbLocal = new JLabel("Local Serviço : ");
		jlbLocal.setBounds(5, 235, 180, 25);
		getContentPane().add(jlbLocal);

		jtfLocal = new JTextField();
		jtfLocal.setBounds(130, 235, 580, 25);
		getContentPane().add(jtfLocal);

		jlbEnd = new JLabel("Cidade                -                  Rua            -             Bairro              -            Número ");
		jlbEnd.setBounds(130, 215, 580, 25); 
		getContentPane().add(jlbEnd);
		
		
		jbtSalvar = new JButton("Salvar");
		jbtSalvar.setBounds(150, 330, 100, 30);
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrdemExterna ordenExt = new OrdemExterna();
				ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);
				
				for(Cliente cliente: clientes){
					if(cliente.getNome().equals(String.valueOf(jcbNomeCliente.getSelectedItem()))){
						ordenExt.setCliente(cliente);
					}
				}
				
				
				
				ordenExt.setDescricao(jtfDescricao.getText());
				ordenExt.setData(jtfData.getText());
				ordenExt.setModelo(jtfModelo.getText());
				ordenExt.setPrazoEntrega(jtfPrazoEntrega.getText());
				ordenExt.setProblema(jtfProblema.getText());
				ordenExt.setValor(Double.valueOf((jtfValor.getText())));
				ordenExt.setLocal(jtfLocal.getText());
				
				ordenExt.setStatus(Status.NaoFeito);

				bancoDeDados.store(ordenExt);
				JOptionPane.showMessageDialog(null, "Ordem Salva!! ");
				bancoDeDados.close();
				dispose();
				new CadastraOrdenExt();
			}
		});
		getContentPane().add(jbtSalvar);

		

		jbtSair = new JButton("Sair");
		jbtSair.setBounds(600, 330, 70, 30);
		jbtSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				bancoDeDados.close();
				dispose();
			}
		});
		getContentPane().add(jbtSair);

		
		SetaClientes();
		
		
		
		setSize(740, 410);
		setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.lightGray);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}
	
	public void SetaClientes() {
		
		ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);
		
		jcbNomeCliente.addItem(null);
		for(Cliente cliente: clientes){
			jcbNomeCliente.addItem(cliente.getNome());
			
		}
		
}

	public static void main(String[] args) {

		CadastraOrdenExt cadastra = new CadastraOrdenExt();
	}

}
