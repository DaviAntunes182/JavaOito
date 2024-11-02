import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {
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

//        palavras.sort((s1, s2) ->
//                //Compara dois inteiros
//                Integer.compare(s1.length(), s2.length())
//        );

        //Método que compara o tamanho de cada palavra
        //Entra uma String Retorna um Int, para cada s retorna o tamanho
        Function<String, Integer> funcao = s -> s.length();
        Function<String, Integer> funcao2 = String::length;
        Comparator<String> comparator = Comparator.comparing(funcao);
        palavras.sort(comparator);
        // São a mesma coisa
        palavras.sort(Comparator.comparing(s -> s.length()));
        // São a mesma coisa
        // Da string invoque o método length
        palavras.sort(Comparator.comparing(String::length));

        //Lambda só funciona com interfaces funcionais compativeis
        //devem receber argumentos e devolver parâmetros na mesma que a lambda
        //É boom usar quando não há necessidade de usar muita lógica


        palavras.forEach(s -> System.out.println(s));
        palavras.forEach(System.out::println);

    }
}
