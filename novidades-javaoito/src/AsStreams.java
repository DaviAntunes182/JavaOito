import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AsStreams {
    public static void main(String[] args) {
        List<CursoStreams> cursos = new ArrayList<>();

        cursos.add(new CursoStreams("Python", 45));
        cursos.add(new CursoStreams("JS", 150));
        cursos.add(new CursoStreams("Java", 113));
        cursos.add(new CursoStreams("C", 55));

        cursos.sort(Comparator.comparing(c -> c.getAlunos()));
        cursos.sort(Comparator.comparing(CursoStreams::getAlunos));

        cursos.forEach(System.out::println);
        cursos.forEach(c -> System.out.println(c.getNome()));

        //Apenas quem tem mais de 100 alunos
        //O metodo Stream() devolve uma corrente de objetos a qual podemos exercer metodos
        cursos.stream() //Metodo filter retorna uma outra stream que podemos utilizar mais metodos
                .filter(c -> c.getAlunos() >= 100)// Não altera a coleção original
                .forEach(c -> System.out.println(c.getNome()));// Printa a coleção filtrada

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                //Map retorna uma stream do tipo do retorno do metodo do predicado
                .map(CursoStreams::getAlunos)
                .forEach(System.out::println);

        // Não há necessidade de criar uma variável IntStream
        IntStream intStream = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                //Map retorna uma stream do tipo do retorno do metodo do predicado
                .mapToInt(CursoStreams::getAlunos);
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                //Map retorna uma stream do tipo do retorno do metodo do predicado
                .mapToInt(CursoStreams::getAlunos) //MapToInt tem vários métodos únicos
                .sum();

        System.out.println(sum);

        //Optional é uma classe que nos ajuda a trabalhar com null
        //Pode existir ou não
        Optional<CursoStreams> cursoOpt = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny();

//        Pode causar erro
//        CursoStreams curso = cursoOpt.orElse(null);
//        System.out.println(curso.getNome());

        // Se existir imprima, se não faça nada
        cursoOpt.ifPresent(c -> System.out.println(c.getNome()));

        //Dá para utilizar diretamente
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));
    // Podem existir cursos ou não, se não retornaria uma divisão por zero gerandoe erro
    OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
            .mapToInt(CursoStreams::getAlunos)
            .average();

    //Collector, nos retornam colections as quais podemos trabalhar da forma antiga
    List<CursoStreams> cursosMaisCem = cursos.stream()
            .filter(c -> c.getAlunos() >= 100)
            .collect(Collectors.toList());

    cursos.stream().forEach(c -> System.out.println(c.getNome() + " Mais de Cem"));

    Map<String, Integer> cursosMap = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()
                ));
    System.out.println(cursosMap);
    cursos.stream()
            .filter(c -> c.getAlunos() >= 100)
            .collect(Collectors.toMap(
                        c -> c.getNome(),
                        c -> c.getAlunos()
            ))
            .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

    }
}
