package Trabalho.desktop;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Suporte extends JFrame {
	
	
	
	
	private JLabel jlbimagem2, jlbimagem;
	
	Suporte(){
		
		setTitle("Suporte");
		setLayout(null);
		
		jlbimagem2 = new JLabel(new ImageIcon("supor.PNG"));
		jlbimagem2.setBounds(200, 100, 1000, 150);		
		getContentPane().add(jlbimagem2);
		
		
		
		jlbimagem = new JLabel(new ImageIcon("suporte.PNG"));
		jlbimagem.setBounds(150, 230, 888, 492);		
		getContentPane().add(jlbimagem);
	
	
		setSize(1366, 728);
		setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		
		
		
		
	}
		
	
	
	public static void main(String[] args) {
		Suporte suporte = new Suporte();
	}
	
}
