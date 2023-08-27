package Main;

import java.util.Scanner;

import Entities.CifraDeCesar;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a mensagem encriptada: ");
        String mensagem = scan.nextLine();

        System.out.print("Digite a palavra conhecida: ");
        String palavraConhecida = scan.nextLine();

        System.out.println("--------------------------------------------------------------");

        String mensagemDecriptada = CifraDeCesar.quebrarCodigo(mensagem, palavraConhecida);

        System.out.println("Mensagem decriptada: " + mensagemDecriptada);

        scan.close();
    }
}