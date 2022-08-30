package control;

import java.util.Scanner;

public class HomeController {
	
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcao = 0;
		do {
			System.out.print("\n-------  Home -------");
			System.out.print(		
				"\n1. Vender" +
				"\n2. Manter Produtos" +
				"\n3. Manter Clientes" +
				"\n4. Manter Itens" +
				"\n5. Manter Pedidos" +
				"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch(opcao) {
				case 1:
					VendasController.main(null);
					break;
				case 2:
                    ProdutoController.main(null);
					break;
				case 3:
					ClienteController.main(null);
					break;
				case 4:
					System.out.println("Em implementação.");
					break;
				case 5:
					PedidoController.main(null);
					break;	
				default:
					if(opcao != 0) System.out.println("Opção inválida.");
			}
		} while(opcao != 0) ;
		System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
		input.close(); //libera o recurso
	}

}//fim classe
