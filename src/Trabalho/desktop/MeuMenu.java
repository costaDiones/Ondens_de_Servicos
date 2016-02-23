package Trabalho.desktop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MeuMenu extends JFrame {

	private JMenuBar jmbMenu;
	private JMenu jmnCliente, jmnordem, jmnSair;
	private JMenuItem jmiNovoCliente, jmiListaCliente, jmiordemInt,
			jmiordemExt, jmicontato;
	private JLabel jlbimagem, jlbimagem1, jlbimagem2, jlbCliente, jlbListaCliente, jlbCadOrdInt, jlbLisOrdInt, jlbCaOrdExt, jlbLiOrdExt;
	private JButton jbtClientes, jbtListarClientes, jbtSair, jbtOrdemInterna, jbtOrdemExterna, jbtListaInt, jbtListaExt;
	
	MeuMenu() {

		setTitle("Controle de Manutenção");
		setLayout(null);
		

		// criando MenuBar
		jmbMenu = new JMenuBar();

		jmnCliente = new JMenu("Cliente");
		jmiNovoCliente = new JMenuItem("NovoCliente");
		jmiNovoCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new CadastraCliente();

			}
		});

		jmiListaCliente = new JMenuItem("Listar Clientes");
		jmiListaCliente.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new Lista();
			}
		});

		jmnordem = new JMenu("Ordens");
		jmiordemInt = new JMenuItem("Ordem Interna");
		jmiordemInt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastraOrdenInt();

			}
		});
		jmiordemExt = new JMenuItem("Ordem Externa");
		jmiordemExt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadastraOrdenExt();
				
			}
		});
		
		jmnSair = new JMenu("Suporte");
		jmicontato = new JMenuItem("Contato");
		
		jmicontato.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
					new Suporte();
			}
		});
		getContentPane().add(jmicontato);
		
		jbtClientes = new JButton(new ImageIcon("cliente.PNG"));
		jbtClientes.setBounds(5, 5, 100, 100);
		jbtClientes.setBackground(Color.white);
		jbtClientes.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CadastraCliente  cadastra = new CadastraCliente();
			}
		});
		getContentPane().add(jbtClientes);

		
		jbtListarClientes = new JButton(new ImageIcon("listacliente.PNG"));
		jbtListarClientes.setBounds(170, 5,100,100);
		jbtListarClientes.setBackground(Color.white);
		jbtListarClientes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new Lista();
			}
		});
		getContentPane().add(jbtListarClientes);
		
		
		jbtOrdemInterna = new JButton(new ImageIcon("ordem.PNG"));
		jbtOrdemInterna.setBounds(335, 5, 100, 100);
		jbtOrdemInterna.setBackground(Color.white);
		jbtOrdemInterna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastraOrdenInt();

			}
		});
		getContentPane().add(jbtOrdemInterna);
		
		jbtOrdemExterna = new JButton(new ImageIcon("orde.JPG"));
		jbtOrdemExterna.setBounds(665, 5, 100, 100);
		jbtOrdemInterna.setBackground(Color.white);
		jbtOrdemExterna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastraOrdenExt();

			}
		});
		getContentPane().add(jbtOrdemExterna);
		
		jbtListaInt = new JButton(new ImageIcon("lista.PNG"));
		jbtListaInt.setBounds(500, 5, 100, 100);
		jbtListaInt.setBackground(Color.white);
		jbtListaInt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				new ListaOdensInt();
				
			}
		});
		getContentPane().add(jbtListaInt);
		
		
		
		jbtListaExt = new JButton(new ImageIcon("lista.PNG"));
		jbtListaExt.setBounds(830, 5, 100, 100);
		jbtListaExt.setBackground(Color.white);
		jbtListaExt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				new ListaOrdenExt();
				
			}
		});
		getContentPane().add(jbtListaExt);
		
		jmbMenu.add(jmnCliente);
		jmnCliente.add(jmiNovoCliente);
		jmnCliente.add(jmiListaCliente);

		jmbMenu.add(jmnordem);
		jmnordem.add(jmiordemInt);
		jmnordem.add(jmiordemExt);
		
		
		jmbMenu.add(jmnSair);
		jmnSair.add(jmicontato);
		
		
		
		
		jlbimagem = new JLabel(new ImageIcon("tela.PNG"));
		jlbimagem.setBounds(200, 280, 500, 425);
		getContentPane().add(jlbimagem);
		
		
		jlbimagem1 = new JLabel(new ImageIcon("vc.PNG"));
		jlbimagem1.setBounds(750, 280, 400, 400);		
		getContentPane().add(jlbimagem1);
		
		jlbimagem2 = new JLabel(new ImageIcon("dc.PNG"));
		jlbimagem2.setBounds(280, 150, 768, 115);		
		getContentPane().add(jlbimagem2);
		
		
		
		
		jlbCliente = new JLabel("Cadastra Cliente");
		jlbCliente.setBounds(5, 110, 100, 25);
		getContentPane().add(jlbCliente);
		
		jlbListaCliente = new JLabel("Lista Cliente");
		jlbListaCliente.setBounds(180, 110, 100, 25);
		getContentPane().add(jlbListaCliente);
		
		
		jlbCadOrdInt = new JLabel("Cadastra Ordem Interna");
		jlbCadOrdInt.setBounds(315, 110, 150, 25);
		getContentPane().add(jlbCadOrdInt);
		
		jlbLisOrdInt = new JLabel("Lista Ordem Interna");
		jlbLisOrdInt.setBounds(495, 110, 150, 25);
		getContentPane().add(jlbLisOrdInt);
		
		jlbCaOrdExt = new JLabel("Cadastra Ordem Externa");
		jlbCaOrdExt.setBounds(645, 110, 150, 25);
		getContentPane().add(jlbCaOrdExt);
		
		jlbLiOrdExt = new JLabel("Lista Ordem Externa");
		jlbLiOrdExt.setBounds(820, 110, 150, 25);
		getContentPane().add(jlbLiOrdExt);
		
		jbtSair = new JButton(new ImageIcon("sair.PNG"));
		jbtSair.setBounds(1290, 5, 50, 50);
		jbtListarClientes.setBackground(Color.white);
		jbtSair.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(jbtSair);
		

		setJMenuBar(jmbMenu);

		setSize(1366, 728);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}

	public static void main(String[] args) {
		MeuMenu tela = new MeuMenu();

	}

}
