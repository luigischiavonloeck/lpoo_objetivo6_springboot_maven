package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.fabricantes;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class FabricanteController {
    private static final Scanner input = new Scanner(System.in);
    private static FabricanteService FabricanteService;

    public FabricanteController (FabricanteService FabricanteService){
        FabricanteController.FabricanteService = FabricanteService;
    }

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n========  Menu Fabricante  ========");
            System.out.println("""
                    
                    1. Criar Fabricante
                    2. Atualizar Fabricante
                    3. Excluir Fabricante
                    4. Listar todos Fabricantes
                    5. Buscar por codigo
                    6. Buscar por nome
                    0. Sair\s""");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1 -> create();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> list();
                case 5 -> searchId();
                case 6 -> searchName();
                default -> {
                    if (option != 0) System.out.println("Opção Inválida");
                }
            }
        } while (option != 0);
    }

    private static void create(){
        Fabricante fabricante = new Fabricante();
        System.out.println("\n--------  Cadastrar Fabricante  --------");
        System.out.print("Nome do fabricante: ");
        fabricante.setNome(input.nextLine());
        System.out.println("Fabricante criado com sucesso" + FabricanteService.insert(fabricante));
    }

    private static void update(){
        Fabricante fabricante;
        System.out.println("\n--------  Atualizar Fabricante  --------");
        int opcao = 0;
        do {
            System.out.print("Digite o codigo do fabricante (0 = sair): ");
            long id = input.nextLong();
            input.nextLine();
            if (id == 0){
                opcao = 0;
            } else {
                fabricante = FabricanteService.getFabricanteById(id);
                if (fabricante == null){
                    System.out.println("Codigo inválido");
                } else {
                    System.out.println("Nome: "+fabricante.getNome());
                    System.out.print("Deseja alterar o nome? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo nome: ");
                        fabricante.setNome(input.nextLine());
                    }
                    if(FabricanteService.update(fabricante) != null){
                        System.out.println("Fabricante atualizado com sucesso. "+ FabricanteService.getFabricanteById(fabricante.getId()));
                    } else {
                        System.out.println("Não foi possivel atualizar o fabricante");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void delete(){
        Fabricante fabricante;
        System.out.println("\n--------  Excluir Fabricante  --------");
        int opcao = 0;
        do {
            System.out.print("Digite o codigo do fabricante (0 = sair): ");
            long id = input.nextLong();
            input.nextLine();
            if (id == 0){
                opcao = 0;
            } else if(id > 0){
                fabricante = FabricanteService.getFabricanteById(id);
                if (fabricante == null){
                    System.out.println("Codigo inválido");
                } else {
                    System.out.println(fabricante);
                    System.out.print("Deseja excluir o fabricante? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        FabricanteService.delete(fabricante.getId());
                        System.out.println("Fabricante excluido com sucesso. "+fabricante);
                    }
                }
            } else {
                System.out.println("Codigo inválido");
            }
        } while (opcao != 0);
    }

    private static void list(){
        System.out.println("Lista de fabricantes: "+ FabricanteService.getFabricantes());
    }

    private static void searchId(){
        System.out.print("Digite o codigo do fabricante: ");
        Fabricante fabricante = FabricanteService.getFabricanteById(input.nextLong());
        if (fabricante != null){
            System.out.println("Fabricante encontrado. " + fabricante);
        } else {
            System.out.println("Fabricante inexistente");
        }
    }

    private static void searchName(){
        System.out.print("Digite o nome do fabricante: ");
        String name = input.nextLine();
        List<Fabricante> fabricantes = FabricanteService.getFabricanteByName(name + "%");
        if (fabricantes != null){
            System.out.println("Fabricante encontrado. " + fabricantes);
        } else {
            System.out.println("Fabricante inexistente");
        }
    }
}
