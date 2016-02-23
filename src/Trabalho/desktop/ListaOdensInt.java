package Trabalho.desktop;

import java.awt.Color;
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

import Trabalho.model.OrdemInterna;
import Trabalho.model.Status;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ListaOdensInt extends JFrame implements ActionListener {

	private JButton jbtOk, jbtSair, jbtfeito;
	private JPanel Painel;
	private JTable jtblista;
	private DefaultTableModel dtmlista;
	int linha = 0, linhadata = 0, linhadescricao = 0, linhaproblema = 0,
			linhamodelo = 0, linhavalor = 0, linhaprazo = 0,
			 linhacliente=0, linhaStatus=0;

	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");

	ListaOdensInt() {
		setTitle("Lista Ordem Interna");
		setLayout(null);

		String[] Nomes = new String[] { "Cliente", "Data Entrada", "Descriçao",
				"Problema", "Modelo", "Valor Aproximado", "Prazo Entrega","Status",
				 };

		dtmlista = new DefaultTableModel(null, Nomes);

		dtmlista.setColumnCount(8);

		Painel = new JPanel();
		Painel.setLayout(null);
		Painel.setBackground(Color.BLACK);
		Painel.setBounds(10, 10, 960, 200);
		getContentPane().add(Painel);

		jtblista = new JTable(dtmlista);
		jtblista.setBounds(10, 10, 945, 200);
		getContentPane().add(jtblista);
		Painel.add(jtblista);

		JScrollPane jsplista = new JScrollPane();
		jsplista.setBounds(0, 0, 960, 200);
		getContentPane().add(jsplista);
		Painel.add(jsplista);
		jsplista.setViewportView(jtblista);

		jbtOk = new JButton("Remover");
		jbtOk.setBounds(10, 250, 90, 25);
		jbtOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				ObjectSet<OrdemInterna> ordenInt = bancoDeDados.query(OrdemInterna.class);
				

				bancoDeDados.delete(ordenInt.get(jtblista.getSelectedRow()));

				bancoDeDados.close();
				dispose();
				new ListaOrdenExt();

			}
		});
		
		getContentPane().add(jbtOk);
		
		
		jbtfeito = new JButton("Concluida");
		jbtfeito.setBounds(200, 250, 90, 25);
		jbtfeito.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				OrdemInterna ordem = new OrdemInterna();
				ObjectSet<OrdemInterna> ordenInt = bancoDeDados.query(OrdemInterna.class);
				ordem = ordenInt.get(jtblista.getSelectedRow());
				ordem.setStatus(Status.Feito);
				
				bancoDeDados.store(ordem);
				bancoDeDados.close();
				dispose();
				new ListaOdensInt();

			}
		});
		getContentPane().add(jbtfeito);

		jbtSair = new JButton("Sair");
		jbtSair.setBounds(900, 250, 70, 30);
		jbtSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				bancoDeDados.close();
				dispose();
			}
		});
		getContentPane().add(jbtSair);

		ImprimeOrdInt();

		setSize(1000, 330);
		setVisible(true);
		this.getContentPane().setBackground(Color.lightGray);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void ImprimeOrdInt() {
		ObjectSet<OrdemInterna> ordenInt = bancoDeDados
				.query(OrdemInterna.class);
		ListaOrdInt(ordenInt);
	}

	public void ListaOrdInt(ObjectSet<OrdemInterna> ordenInt) {
		for (OrdemInterna ordeminterna : ordenInt) {
			linha++;
			dtmlista.setRowCount(linha);
			dtmlista.setValueAt(ordeminterna.getCliente().getNome(),linhacliente, 0);
			dtmlista.setValueAt(ordeminterna.getData(), linhadata, 1);
			dtmlista.setValueAt(ordeminterna.getDescricao(), linhadescricao, 2);
			dtmlista.setValueAt(ordeminterna.getProblema(), linhaproblema, 3);
			dtmlista.setValueAt(ordeminterna.getModelo(), linhamodelo, 4);
			dtmlista.setValueAt(ordeminterna.getValor(), linhavalor, 5);
			dtmlista.setValueAt(ordeminterna.getPrazoEntrega(), linhaprazo, 6);	
			dtmlista.setValueAt(ordeminterna.getStatus(), linhaStatus, 7);
			linhaStatus++;
			linhacliente++;
			linhadata++;
			linhadescricao++;
			linhaproblema++;
			linhamodelo++;
			linhavalor++;
			linhaprazo++;
			
		}

	}

	public static void main(String[] args) {
		ListaOdensInt lista = new ListaOdensInt();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}