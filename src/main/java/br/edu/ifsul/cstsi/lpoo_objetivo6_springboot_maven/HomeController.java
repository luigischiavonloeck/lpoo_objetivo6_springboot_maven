package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.acessorios.AcessorioController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis.AluguelController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.apolices.ApoliceSeguroController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.carros.CarroController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes.FabricanteController;
import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.modelosCarros.ModeloCarroController;

import java.util.Scanner;

public class HomeController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            //System.out.println("\\033[H\\033[2J");
            //System.out.flush();
            System.out.println("\n========  Home  ========");
            System.out.println("""
                    
                    1. Manter Funcionario
                    2. Manter Motorista
                    3. Manter Aluguel
                    4. Manter Apolice
                    5. Manter Carro
                    6. Manter Acessorio
                    7. Manter ModeloCarro
                    8. Manter Fabricante
                    0. Sair\s""");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1 -> System.out.println("a");
                case 2 -> System.out.println("b");
                case 3 -> AluguelController.main(null);
                case 4 -> ApoliceSeguroController.main(null);
                case 5 -> CarroController.main(null);
                case 6 -> AcessorioController.main(null);
                case 7 -> ModeloCarroController.main(null);
                case 8 -> FabricanteController.main(null);
                default -> {
                    if (option != 0) System.out.println("Opção Inválida");
                }
            }
        } while (option != 0);
        System.out.println("\n\nFim da execução");
        input.close();
    }
}
