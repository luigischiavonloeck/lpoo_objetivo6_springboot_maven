package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.pessoas;

import br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven.alugueis.AluguelService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MotoristaController {
    private static final Scanner input = new Scanner(System.in);
    private static MotoristaService MotoristaService;
    private static AluguelService AluguelService;

    public MotoristaController (MotoristaService MotoristaService){
        MotoristaController.MotoristaService = MotoristaService;
    }

    public MotoristaController (AluguelService AluguelService){
        MotoristaController.AluguelService = AluguelService;
    }

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n========  Menu Motorista  ========");
            System.out.println("""
                    
                    1. Criar Motorista
                    2. Atualizar Motorista
                    3. Excluir Motorista
                    4. Listar todos Motoristas
                    5. Buscar por codigo
                    6. Buscar por nome
                    7. Buscar por sexo
                    8. Buscar por cnh
                    9. Adicionar aluguel
                    10. Remover aluguel
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
                case 7 -> searchSexo();
                case 8 -> searchCNH();
                case 9 -> addRental();
                case 10 -> removeRental();
                default -> {
                    if (option != 0) System.out.println("Opção Inválida");
                }
            }
        } while (option != 0);
    }

    private static void create(){
        Motorista motorista = new Motorista();
        System.out.println("\n--------  Cadastrar Motorista  --------");
        System.out.print("Nome do motorista: ");
        motorista.setNome(input.nextLine());
        System.out.print("Cpf do motorista: ");
        motorista.setCpf(input.nextLine());
        System.out.print("Nascimento do motorista(dd/mm/yyyy): ");
        motorista.setDataNascimento(dateInput(input.nextLine()));
        System.out.print("Sexo do motorista(MASCULINO - FEMININO): ");
        motorista.setSexo(Sexo.valueOf(input.nextLine()));
        System.out.print("CNH do motorista: ");
        motorista.setNumeroCNH(input.nextLine());
        System.out.println("Motorista criado com sucesso" + MotoristaService.insert(motorista));
    }

    private static void update(){
        Motorista motorista;
        System.out.println("\n--------  Atualizar Motorista  --------");
        int opcao = 0;
        do {
            System.out.print("Digite o codigo do motorista (0 = sair): ");
            long id = input.nextLong();
            input.nextLine();
            if (id == 0){
                opcao = 0;
            } else {
                motorista = MotoristaService.getMotoristaById(id);
                if (motorista == null){
                    System.out.println("Codigo inválido");
                } else {

                    System.out.println("Nome: "+motorista.getNome());
                    System.out.print("Deseja alterar o nome? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo nome: ");
                        motorista.setNome(input.nextLine());
                    }

                    System.out.println("CPF: "+motorista.getCpf());
                    System.out.print("Deseja alterar o cpf? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo cpf: ");
                        motorista.setCpf(input.nextLine());
                    }

                    System.out.println("Data de nascimento: "+motorista.getDataNascimento());
                    System.out.print("Deseja alterar a data de nascimento? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a nova data de nascimento(dd/mm/yyyy): ");
                        motorista.setDataNascimento(dateInput(input.nextLine()));
                    }

                    System.out.println("Sexo: "+motorista.getSexo());
                    System.out.print("Deseja alterar o sexo? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo sexo(MASCULINO - FEMININO): ");
                        motorista.setSexo(Sexo.valueOf(input.nextLine()));
                    }

                    System.out.println("CNH: "+motorista.getNumeroCNH());
                    System.out.print("Deseja alterar o CNH? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo CNH: ");
                        motorista.setNumeroCNH(input.nextLine());
                    }

                    if(MotoristaService.update(motorista) != null){
                        System.out.println("Motorista atualizado com sucesso. "+ MotoristaService.getMotoristaById(motorista.getId()));
                    } else {
                        System.out.println("Não foi possivel atualizar o motorista");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void delete(){
        Motorista motorista;
        System.out.println("\n--------  Excluir Motorista  --------");
        int opcao = 0;
        do {
            System.out.print("Digite o codigo do motorista (0 = sair): ");
            long id = input.nextLong();
            input.nextLine();
            if (id == 0){
                opcao = 0;
            } else if(id > 0){
                motorista = MotoristaService.getMotoristaById(id);
                if (motorista == null){
                    System.out.println("Codigo inválido");
                } else {
                    System.out.println(motorista);
                    System.out.print("Deseja excluir o motorista? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        MotoristaService.delete(motorista.getId());
                        System.out.println("Motorista excluido com sucesso. "+motorista);
                    }
                }
            } else {
                System.out.println("Codigo inválido");
            }
        } while (opcao != 0);
    }

    private static void list(){
        System.out.println("Lista de fabricantes: "+ MotoristaService.getMotoristas());
    }

    private static void searchId(){
        System.out.print("Digite o codigo do motorista: ");
        Motorista motorista = MotoristaService.getMotoristaById(input.nextLong());
        if (motorista != null){
            System.out.println("Motorista encontrado. " + motorista);
        } else {
            System.out.println("Motorista inexistente");
        }
    }

    private static void searchName(){
        System.out.print("Digite o nome do motorista: ");
        String name = input.nextLine();
        List<Motorista> motoristas = MotoristaService.getMotoristaByName(name + "%");
        if (motoristas != null){
            System.out.println("Motorista encontrado. " + motoristas);
        } else {
            System.out.println("Motorista inexistente");
        }
    }

    private static void searchSexo(){
        System.out.print("Digite o sexo para filtrar(MASCULINO - FEMININO): ");
        String sexo = input.nextLine();
        List<Motorista> motoristas = MotoristaService.getMotoristaBySex(Sexo.valueOf(sexo));
        if (motoristas != null){
            System.out.println("Motoristas encontrados. " + motoristas);
        } else {
            System.out.println("Motorista inexistente");
        }
    }

    private static void searchCNH(){
        System.out.print("Digite a cnh do motorista: ");
        String cnh = input.nextLine();
        Motorista motoristas = MotoristaService.getMotoristaByCnh(cnh);
        if (motoristas != null){
            System.out.println("Motorista encontrado. " + motoristas);
        } else {
            System.out.println("Motorista inexistente");
        }
    }

    private static void addRental(){
        Motorista motorista;
        System.out.println("\n--------  Adicionar aluguel a Motorista  --------");
        int opcao = 0;
        do {
            System.out.print("Digite o codigo do motorista (0 = sair): ");
            long id = input.nextLong();
            input.nextLine();
            if (id == 0){
                opcao = 0;
            } else {
                motorista = MotoristaService.getMotoristaById(id);
                if (motorista == null){
                    System.out.println("Codigo inválido");
                } else {
                    do {
                    System.out.println("Nome: "+motorista.getNome());
                    System.out.print("Alugeis: "+motorista.getAlugueis());
                    System.out.println("Digite o id do aluguel a adicionar(0 = sair): ");
                    id = input.nextLong();
                    input.nextLine();
                    if(id != 0){
                        System.out.print(AluguelService.getAluguelById(id));
                        System.out.println("Adicionar aluguel ao motorista? (0-sim/1-nao): ");
                        id = input.nextLong();
                        input.nextLine();
                        if(id == 0){
                            motorista.getAlugueis().add(AluguelService.getAluguelById(id));
                        }
                    }
                    } while (id != 0);

                    if(MotoristaService.update(motorista) != null){
                        System.out.println("Motorista atualizado com sucesso. "+ MotoristaService.getMotoristaById(motorista.getId()));
                    } else {
                        System.out.println("Não foi possivel atualizar o motorista");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void removeRental(){
        Motorista motorista;
        System.out.println("\n--------  Remover aluguel de Motorista  --------");
        int opcao = 0;
        do {
            System.out.print("Digite o codigo do motorista (0 = sair): ");
            long id = input.nextLong();
            input.nextLine();
            if (id == 0){
                opcao = 0;
            } else {
                motorista = MotoristaService.getMotoristaById(id);
                if (motorista == null){
                    System.out.println("Codigo inválido");
                } else {
                    do {
                        System.out.println("Nome: "+motorista.getNome());
                        System.out.print("Alugeis: "+motorista.getAlugueis());
                        System.out.println("Digite o id do aluguel para remover(0 = sair): ");
                        motorista.getAlugueis().stream().filter(aluguel -> aluguel.getId()==input.nextLong()).findAny();
                        input.nextLine();
                        if(id != 0){
                            System.out.print(AluguelService.getAluguelById(id));
                            System.out.println("Adicionar aluguel ao motorista? (0-sim/1-nao): ");
                            id = input.nextLong();
                            input.nextLine();
                            if(id == 0){
                                motorista.getAlugueis().add(AluguelService.getAluguelById(id));
                            }
                        }
                    } while (id != 0);

                    if(MotoristaService.update(motorista) != null){
                        System.out.println("Motorista atualizado com sucesso. "+ MotoristaService.getMotoristaById(motorista.getId()));
                    } else {
                        System.out.println("Não foi possivel atualizar o motorista");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static LocalDate dateInput(String userInput){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);

        return date;
    }
}
