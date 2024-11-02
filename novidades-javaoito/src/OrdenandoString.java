import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenandoString {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();
        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("coelum");

        Comparator<String> comparador = new ComparadorPorTamanho();

        //Novo método de ordenação
        palavras.sort(comparador);

        Consumer<String> consumidor = new ImprimeNaLinha();
        //Novo método de iteração
        palavras.forEach(consumidor);

        System.out.println(palavras);
    }
}

class ComparadorPorTamanho implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()){
            return  -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}

class ImprimeNaLinha implements Consumer<String>{
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}