package sistemabancario;

import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Sistema bank = new Sistema();
        bank.opcao = 0;
        
        System.out.println("Qual o seu nome:");
        bank.nome = scan.nextLine();
        
        System.out.println("Quantos reais voce tem na conta:");
        bank.money = scan.nextDouble();
        
        System.out.println("Futuramente, voce gostaria de fazer algum emprestimo?");
        System.out.println("Digite 'true' para SIM ou 'false' para NAO:");
        bank.opcaoEmprestimo = scan.nextBoolean();
        
        // Looping para repetir as ações
        while (bank.opcao != 4) {
            
            System.out.println("Qual acao voce deseja fazer:");
            System.out.println("1- Saque");
            System.out.println("2- Deposito");
            if (bank.opcaoEmprestimo == true) {
                System.out.println("3- Emprestimo");
            } else {
                System.out.println("3- Voce nao possui a opcao de emprestimo");
            }
            System.out.println("4- Sair");
            bank.opcao = scan.nextInt();
            
            switch (bank.opcao) {
                
                case 1: // Saque
                    if (bank.money > 0) {
                        System.out.println("Quantos reais voce quer sacar da sua conta:");
                        bank.saque = scan.nextDouble();
                        
                        while (bank.saque > bank.money) {
                            System.out.println("Nao foi possivel sacar essa quantidade. Tente novamente:");
                            bank.saque = scan.nextDouble();
                        }
                        
                        bank.saque();
                    } else {
                        System.out.println("Voce nao tem dinheiro na conta, deposite primeiro para fazer o saque.");
                    }
                break;
                
                case 2: // Deposito
                    System.out.println("Quantos reais voce quer depositar na sua conta:");
                    bank.deposito = scan.nextDouble();
                    
                    bank.deposito();
                break;
                
                case 3: // Emprestimo
                    if (bank.opcaoEmprestimo == false) {
                        System.out.println("Voce nao pode fazer emprestimo, escolha outra opcao.");
                        System.out.println(" ");
                        break;
                    } else {
                        
                        System.out.println("Lembre-se, ha juros de 5% por emprestimo que voce fizer");
                        System.out.println("Voce quer continuar na opcao Emprestimo?");
                        System.out.println("Digite 'true' para SIM ou 'false' para NAO:");
                        bank.fugirEmprestimo = scan.nextBoolean();
                        
                        if (bank.fugirEmprestimo == true) {
                            System.out.println("Quantos reais voce quer pegar de emprestimo:");
                            bank.emprestimo = scan.nextDouble();
                            
                            bank.emprestimo();
                        } else {
                            
                            System.out.println("Saindo do emprestimo...");
                            break;
                        }
                    }
                break;
                
                case 4:
                    System.out.println("Saindo...");
                break;
                
                default:
                    System.out.println("Voce escolheu uma opcao invalida. Tente novamente:");
            }
        }
        
        // Situação da conta
        System.out.println(" ");
        System.out.println("Situacao da conta:");
        System.out.println("Proprietario: " + bank.nome);
        
        if (bank.emprestimoJuros > 0) { // Paga o emprestimo
            bank.pagaEmprestimo();
        }
        
        System.out.println("Voce possui um total de R$" + bank.money);
        System.out.println("Voce pagou um total de R$" + bank.emprestimoJuros + " de emprestimo");
    }
    
}
