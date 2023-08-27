package Entities;

public class CifraDeCesar {

    public static String encriptar(String mensagem, int deslocador) {
        String resultado = "";

        for (char letra : mensagem.toLowerCase().toCharArray()) {
            if (letra == ' ') {
                resultado += ' ';
                continue;
            }

            int deslocamento = letra + deslocador;
            if (deslocamento > 'z')
                deslocamento -= 26;

            resultado += (char) deslocamento;
        }

        return resultado;
    }

    public static String decriptar(String mensagem, int deslocador) {
        String resultado = "";

        for (char letra : mensagem.toLowerCase().toCharArray()) {
            if (letra == ' ') {
                resultado += ' ';
                continue;
            }

            int deslocamento = letra - deslocador;
            if (deslocamento < 'a')
                deslocamento += 26;

            resultado += (char) deslocamento;
        }

        return resultado;
    }

    public static String quebrarCodigo(String mensagem, String palavraConhecida) {
        int deslocador = -1;

        for (String palavra : mensagem.split(" ")) {
            if (palavra.length() == palavraConhecida.length()) {
                int temp = getDeslocador(palavra, palavraConhecida);
                if (temp != -1) {
                    deslocador = temp;
                    break;
                }
            }
        }

        if (deslocador == -1) {
            return "Palavra conhecida não está presente na mensagem";
        }

        System.out.println("Deslocador: " + deslocador);

        return decriptar(mensagem, deslocador);
    }

    public static int getDeslocador(String palavra, String palavraConhecida) {
        for (int i = 1; i < 26; i++) {
            if (decriptar(palavra, i).equals(palavraConhecida)) {
                return i;
            }
        }
        return -1;
    }
}