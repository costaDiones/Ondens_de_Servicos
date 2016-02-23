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

import Trabalho.model.OrdemExterna;
import Trabalho.model.Status;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ListaOrdenExt extends JFrame {

	private JButton jbtOk, jbtSair, jbtfeito;
	private JPanel Painel;
	private JTable jtblista;
	private DefaultTableModel dtmlista;
	int linha = 0, linhadata = 0, linhadescricao = 0, linhaproblema = 0,
			linhamodelo = 0, linhavalor = 0, linhaprazo = 0,
			 linhalocal = 0, linhacliente = 0, linhasattus=0;
	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");

	ListaOrdenExt() {

		setTitle("Lista Ordem Externa");
		setLayout(null);

		String[] Nomes = new String[] { "Cliente ", "Data Entrada",
				"Descriçao", "Problema", "Modelo", "Valor Aproximado",
				"Prazo Entrega", "Prazo Entrega", "Status" };

		dtmlista = new DefaultTableModel(null, Nomes);

		dtmlista.setColumnCount(9);

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

				ObjectSet<OrdemExterna> ordenExt = bancoDeDados.query(OrdemExterna.class);
				

				bancoDeDados.delete(ordenExt.get(jtblista.getSelectedRow()));

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
				OrdemExterna ordem = new OrdemExterna();
				ObjectSet<OrdemExterna> ordenExt = bancoDeDados.query(OrdemExterna.class);
				ordem = ordenExt.get(jtblista.getSelectedRow());
				ordem.setStatus(Status.Feito);
				
				bancoDeDados.store(ordem);
				bancoDeDados.close();
				dispose();
				new ListaOrdenExt();

			}
		});
		getContentPane().add(jbtfeito);
		
		

		ImprimeOrdExt();

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

		setSize(1000, 330);
		setVisible(true);
		this.getContentPane().setBackground(Color.lightGray);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void ImprimeOrdExt() {
		ObjectSet<OrdemExterna> ordenExt = bancoDeDados
				.query(OrdemExterna.class);
		ListaOrdExt(ordenExt);
	}

	public void ListaOrdExt(ObjectSet<OrdemExterna> ordenExt) {
		for (OrdemExterna ordemexterna : ordenExt) {
			linha++;
			dtmlista.setRowCount(linha);
			dtmlista.setValueAt(ordemexterna.getCliente().getNome(),linhacliente, 0);
			dtmlista.setValueAt(ordemexterna.getData(), linhadata, 1);
			dtmlista.setValueAt(ordemexterna.getDescricao(), linhadescricao, 2);
			dtmlista.setValueAt(ordemexterna.getProblema(), linhaproblema, 3);
			dtmlista.setValueAt(ordemexterna.getModelo(), linhamodelo, 4);
			dtmlista.setValueAt(ordemexterna.getValor(), linhavalor, 5);
			dtmlista.setValueAt(ordemexterna.getPrazoEntrega(), linhaprazo, 6);
			dtmlista.setValueAt(ordemexterna.getLocal(), linhalocal, 7);
			dtmlista.setValueAt(ordemexterna.getStatus(), linhasattus, 8);
			linhasattus++;
			linhacliente++;
			linhadata++;
			linhadescricao++;
			linhaproblema++;
			linhamodelo++;
			linhavalor++;
			linhaprazo++;
			linhalocal++;
		}

	}

	public static void main(String[] args) {
		ListaOrdenExt lista = new ListaOrdenExt();
	}

}
