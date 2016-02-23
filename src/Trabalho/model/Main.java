package Trabalho.model;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import javax.swing.JFrame;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class Main {
	
	private Scanner sc = new Scanner(System.in);
	private ObjectContainer bancoDeDados = Db4oEmbedded.openFile(
			Db4oEmbedded.newConfiguration(), "trabalho.db4o");
	
	public static void main(String[] args) {
		
		
		Main main = new Main();
		
		
		try{
			int opcao = 0;

			do {
				System.out.println("1 - Novo Cliente ");
				System.out.println("2- Listar Cliente ");
				
				System.out.println("0 - Sair ");
				opcao = Integer.valueOf(main.sc.nextLine());
				switch (opcao) {
				case 1:
					main.novoCliente();
					break;
				case 2:
					main.listarClientes();
					break;
				default:
					main.sair();
					break;
				}

			} while (opcao > 0);
		}catch (Exception e){
			e.printStackTrace();
			main.sair();
		
		}finally{
			main.sair();
		}
		}

		
		
		
		
		

		public void novoCliente() {

			Cliente cliente = new Cliente();
			System.out.println("Digite o Nome do Cliente");
			cliente.setNome(sc.nextLine());
			System.out.println("Digite o Codigo do cliente");
			cliente.setCodigo(Integer.valueOf(sc.nextLine()));
			System.out.println("Digite o Endereço");
			cliente.setEndereco(sc.nextLine());
			System.out.println("Digite o Telefone");
			cliente.setTelefone(sc.nextLine());
			System.out.println("Digite o CPF");
			cliente.setCpf(sc.nextLine());
			bancoDeDados.store(cliente);
		}
		

		public void listarClientes() {
			ObjectSet<Cliente> clientes = bancoDeDados.query(Cliente.class);
			imprimirCliente(clientes);

		}
		

		public void imprimirCliente(ObjectSet<Cliente> clientes) {
		for (Cliente clienteBD : clientes) {
			System.out.println(clienteBD.getNome());
			System.out.println(clienteBD.getCodigo());
			System.out.println(clienteBD.getEndereco());
			System.out.println(clienteBD.getTelefone());
			System.out.println(clienteBD.getCpf());
		}
	}







		public void sair() {
			bancoDeDados.close();
			sc.close();
		
		
		
		
		
	}
	
	
	

}
