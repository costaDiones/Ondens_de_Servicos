package Trabalho.desktop;

import java.awt.Color;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Trabalho.model.Cliente;
import Trabalho.model.OrdemExterna;
import Trabalho.model.OrdemInterna;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;



public class Lista extends JFrame implements ActionListener {

	
	private JButton jbtOk, jbtSair;
	private JPanel jpnlista;
	private JTable jtblista;
	private DefaultTableModel dtmlista;
	int linha=0;
	int linhaCod=0, linhaNome=0, linhaEnd=0, linhaTel=0, linhaCPF=0;
	
	
	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");
	
	Lista(){
		setTitle("Lista Cliente");
		setLayout(null);
		
		
		String [] Nomes = new String[]{"Nome", "RG", "Endereço", "Telefone", "CPF"	};
		
		dtmlista = new DefaultTableModel(null, Nomes);
		
		dtmlista.setColumnCount(5);
		
		jpnlista = new JPanel();
		jpnlista.setLayout(null);
		jpnlista.setBackground(Color.BLACK);
		jpnlista.setBounds(0, 10, 960, 200);
		getContentPane().add(jpnlista);
		
		jtblista = new JTable(dtmlista);
		jtblista.setBounds(0, 0, 945, 200);
		getContentPane().add(jtblista);
		jpnlista.add(jtblista);
		
		
		JScrollPane jsplista = new JScrollPane();
		jsplista.setBounds(0, 0, 960, 200);
		getContentPane().add(jsplista);
		jpnlista.add(jsplista);
		jsplista.setViewportView(jtblista);
		
			
		
		
		
		jbtOk = new JButton("Remover");
		jbtOk.setBounds(10,250,90,25);
		jbtOk.addActionListener(this);
		jbtOk.addActionListener( new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				ObjectSet<Cliente>clientes=bancoDeDados.query(Cliente.class);
				ObjectSet<OrdemExterna> ordenExt= bancoDeDados.query(OrdemExterna.class);
				ObjectSet<OrdemInterna> ordenInt= bancoDeDados.query(OrdemInterna.class);

				
				for(OrdemExterna ordem: ordenExt){
					if(ordem.getCliente().getNome().equals(clientes.get(jtblista.getSelectedRow()).getNome())){
						bancoDeDados.delete(ordem);
						
					}
				}
				
				for(OrdemInterna ordem: ordenInt){
					if(ordem.getCliente().getNome().equals(clientes.get(jtblista.getSelectedRow()).getNome())){
						bancoDeDados.delete(ordem);
						
					}
				}
				
				
				bancoDeDados.delete(clientes.get(jtblista.getSelectedRow()));
				
				
				
				
				
				bancoDeDados.close();
				dispose();
				new Lista();
			}
		});
		getContentPane().add(jbtOk);
		
		ImprimeClientes();
		
		
		jbtSair = new JButton("Sair");
		jbtSair.setBounds(900,250, 70, 30);
		jbtSair.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bancoDeDados.close();
				dispose();
			}
		});
		getContentPane().add(jbtSair);
		
		
		
		
		
		setSize(1000, 330);
		setVisible(true);
		this.getContentPane().setBackground(Color.lightGray);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
		
	public void ImprimeClientes(){
		ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);
		ListaClientes(clientes);
		
		
		
	}
	
	public void ListaClientes(ObjectSet<Cliente> clientes){
		for(Cliente cliente: clientes){
			linha++;
			dtmlista.setRowCount(linha);
			dtmlista.setValueAt(cliente.getCodigo(),linhaCod , 1);
			dtmlista.setValueAt(cliente.getNome(),linhaNome , 0);
			dtmlista.setValueAt(cliente.getEndereco(),linhaEnd , 2);
			dtmlista.setValueAt(cliente.getTelefone(),linhaTel , 3);
			dtmlista.setValueAt(cliente.getCpf(),linhaCPF , 4);
			linhaCod++;
			linhaNome++;
			linhaEnd++;
			linhaTel++;
			linhaCPF++;
		}
	}
		
	public static void main(String[] args) {
		Lista lista = new Lista();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	
	
	
	
	
	
}
