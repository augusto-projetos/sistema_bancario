package sistemabancario;

public class Sistema {
    
    String nome;
    double money;
    boolean opcaoEmprestimo;
    boolean fugirEmprestimo;
    int opcao;
    double saque;
    double deposito;
    double emprestimo;
    double emprestimoJuros;
    
    void saque() {
        
        money -= saque;
        System.out.println("Sucesso. Voce sacou R$" + saque + " da sua conta.");
        System.out.println("Agora voce tem um total de R$" + money);
        System.out.println(" ");
    }
    
    void deposito() {
        
        money += deposito;
        System.out.println("Sucesso. Voce depositou R$" + deposito + " da sua conta.");
        System.out.println("Agora voce tem um total de R$" + money);
        System.out.println(" ");
    }
    
    void emprestimo() {
        
        money += emprestimo;
        emprestimoJuros += emprestimo * 1.05;
        System.out.println("Sucesso. Voce pegou um emprestimo de R$" + emprestimo);
        System.out.println("Agora voce deve ao banco um total de R$" + emprestimoJuros);
        System.out.println("Agora voce tem um total de R$" + money);
        System.out.println(" ");
    }
    
    void pagaEmprestimo() {
        money -= emprestimoJuros;
    }
}
