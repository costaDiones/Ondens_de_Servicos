package Trabalho.desktop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Trabalho.model.Cliente;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class CadastraCliente extends JFrame {
	
	
	private JLabel jlbNome, jlbCodigo, jlbEndereco, jlbTelefone, jlbCpf, jlbEnd;
	private JTextField jtfNome, jtfCodigo, jtfEndereco, jtfTelefone, jtfCpf;
	private JButton jbtOK, jbtSair;
	
	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");
	public CadastraCliente(){
		setTitle("Cadastra Cliente");
		setLayout(null);
		
		
		
		
		jlbNome = new JLabel("None Cliente: ");
		jlbNome.setBounds(5, 5, 90, 25);
		getContentPane().add(jlbNome);
	
	
		jtfNome = new JTextField();
		jtfNome.setBounds(90, 5, 280, 25);
		getContentPane().add(jtfNome);
		
		
		jlbCodigo = new JLabel("RG do CLiente: ");
		jlbCodigo.setBounds(5, 40, 90, 25);
		getContentPane().add(jlbCodigo);
	
	
		jtfCodigo = new JTextField();
		jtfCodigo.setBounds(90, 40, 280, 25);
		getContentPane().add(jtfCodigo);
		
		
		jlbEndereco = new JLabel("Endereço: ");
		jlbEndereco.setBounds(5, 170, 90, 25);
		getContentPane().add(jlbEndereco);
	
	
		jtfEndereco = new JTextField();
		jtfEndereco.setBounds(90, 170, 380, 25);
		getContentPane().add(jtfEndereco);
		
		
		jlbTelefone = new JLabel("Telefone: ");
		jlbTelefone.setBounds(5, 80, 90, 25);
		getContentPane().add(jlbTelefone);
	
	
		jtfTelefone = new JTextField();
		jtfTelefone.setBounds(90, 80, 280, 25);
		getContentPane().add(jtfTelefone);
		
		jlbCpf = new JLabel("Cpf Cliente:  ");
		jlbCpf.setBounds(5, 120, 90, 25);
		getContentPane().add(jlbCpf);
	
	
		jtfCpf = new JTextField();
		jtfCpf.setBounds(90, 120, 280, 25);
		getContentPane().add(jtfCpf);
		
		jlbEnd = new JLabel("Cidade             -               Rua         -          Bairro           -         Número ");
		jlbEnd.setBounds(90, 150, 380, 25); 
		getContentPane().add(jlbEnd);
		
		jbtOK = new JButton("Salvar");
		jbtOK.setBounds(140, 230, 100, 40);
		jbtOK.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();				
				cliente.setNome(jtfNome.getText());		
				cliente.setCodigo(Integer.valueOf((jtfCodigo.getText())));
				cliente.setEndereco(jtfEndereco.getText());
				cliente.setTelefone(jtfTelefone.getText());
				cliente.setCpf(jtfCpf.getText());
				
				
				
				
				 if(jtfNome.getText().equals("")){
	                    JOptionPane.showMessageDialog(null,"Insira o  Nome ");
	                 
	                }
				 if(jtfCpf.getText().equals("")){
	                    JOptionPane.showMessageDialog(null,"Insira o  CPF");
	                 
	                }
				
				 else{
				bancoDeDados.store(cliente);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				bancoDeDados.close();
				dispose();
				new CadastraCliente();
				 }
				
			}
		});
		getContentPane().add(jbtOK);
		
		
		
		jbtSair = new JButton("Sair");
		jbtSair.setBounds(400, 290, 70, 30);
		jbtSair.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bancoDeDados.close();
				dispose();
			}
		});
		getContentPane().add(jbtSair);

		
		setSize(500,380 );
		setLocationRelativeTo(null);
		setVisible(true);		
		this.getContentPane().setBackground(Color.lightGray);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	
	
	
	
	}
	
	
	
	public static void main(String[] args) {
		CadastraCliente tela = new CadastraCliente();
	
		
		
	}
}
