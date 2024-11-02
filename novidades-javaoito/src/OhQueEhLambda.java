import java.util.ArrayList;
import java.util.List;

public class OhQueEhLambda {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("coelum");

        //Para substituir as classes anônimas, simplificando o código
        //Desde que não utilizaremos ela novamente

        // Se dentro das chaves existir apenas 1 statement,
        // não há necessidade delas existirem

        // O Java infere o tipo da variável passada
        palavras.forEach(s -> System.out.println(s));

        palavras.sort((s1, s2) ->
            //Compara dois inteiros
            Integer.compare(s1.length(), s2.length())
        );
        //Lambda só funciona com interfaces funcionais compativeis
        //devem receber argumentos e devolver parâmetros na mesma que a lambda

        palavras.forEach(s -> System.out.println(s));

    }
}
