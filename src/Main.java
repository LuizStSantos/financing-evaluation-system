import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem emprego sim ou não?: ");
        boolean temEmprego = SimNao(scanner.next());
        System.out.println("Tem empresa sim ou não?: ");
        boolean temEmpresa = SimNao(scanner.next());
        System.out.println("Tem entrada maior ou igual a 50K, sim ou não?; ");
        boolean tem50K = SimNao(scanner.next());
        System.out.println("Tem o nome no Serasa ?, sim ou não: ");
        boolean temSerasa = SimNao(scanner.next());
        boolean podeFinanciar = (temEmprego || temEmpresa) && tem50K && !temSerasa;
        if (podeFinanciar){
            System.out.println("Pode financiar !");
        }else {
            System.out.println("Não pode financiar !");
        }
        scanner.close();
    }
    public static boolean SimNao(String resposta){
        return resposta.equalsIgnoreCase("Sim");
    }
}