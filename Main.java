package InterfacesFuncionalesYStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        String palabra = "hola";
        a.add(palabra);
        a.add("cometa");
        a.add("cheque");
        a.add("canaleta");
        a.add("quererere");


        Operacion transformador = (s) -> s.toUpperCase(); // 2do paso de uso de Interfaz Funcional
        Operacion otroTransformador = (s) -> s.toLowerCase(); // Puedo hacer diferentes instancias de la misma interfaz con funciones diferentes.

        ArrayList<String> b = new ArrayList<>();
        for (String elemento : a) {
            b.add(transformador.convertirAMayuscula(elemento)); //3er paso uso el metodo de la interfaz en la instancia q cree anteriormente
        }
        List<String> c = a.stream().map((elemento) ->
                elemento.toUpperCase()).collect(Collectors.toList()); //mismo resultado pero usando stream().map().collect()
        
        System.out.println(b.toString());
        System.out.println(c.toString());

        List<String> d = new ArrayList<>();
        for (String elemento : b) {
            d.add(otroTransformador.convertirAMayuscula(elemento));
        }
        System.out.println(d.toString());
        System.out.println(metodoConcat(b, 7));


    }

    public static String metodoConcat (ArrayList<String> lista, int n){ //uso de stream para filtrar un array solo con los caracteres de determinado minimo de longitud
        List<String> resultado = lista.stream().filter(s -> s.length() > n ).toList();
        String texto = resultado.stream().collect(Collectors.joining(", ")); // retornar esa lista en forma de string con .joining()
        return texto;
    }



}
