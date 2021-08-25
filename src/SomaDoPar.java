import java.util.ArrayList;
import java.util.HashSet;

public class SomaDoPar {

    /**
     * Percorre a lista dada para encontrar um par de elementos
     * cuja soma seja o valor desejado.
     *
     * @param numeros uma lista de inteiros
     * @param somaDesejada a soma desejada
     *
     * @return O menor dos elementos do par encontrado;
     *         ou null, caso nenhum par de elementos some o valor desejado
     */
    public static Integer encontrarParComSomaDada(
            ArrayList<Integer> numeros, int somaDesejada) {
        HashSet<Integer> hashSetNumeros = new HashSet<>();

        // Algoritmo ineficiente (quadrático):

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                int x = numeros.get(i);
                int y = numeros.get(j);
                if (x + y == somaDesejada) {
                    return Math.min(x, y);
                }
            }
        }
        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuracao quadratica = %.3f segundos", duracao / 1000.0);

        // Algoritmo eficiente (linear):

    /*
        1) pré-processa: joga toda a lista num hash set
        2) para cada elemento da lista...
              computa o complemento dele
              pergunta pro hash set se contém o complemento
     */

        // Outra proposta (Ana Vitória):

    /*
        1) cria um hash set vazio
        2) para cada elemento x da lista...
             computa o complemento y dele
             pergunta pro hash set se contém y
             se contiver y, lindo, encontrou, fim
             senão, coloca x no hash set
    */

        inicio = System.currentTimeMillis();

        for (Integer elementosDeNumeros : numeros) {
            Integer complemento = somaDesejada - elementosDeNumeros;
            if (hashSetNumeros.contains(complemento)) {
                return Math.min(complemento, elementosDeNumeros);
            }
            hashSetNumeros.add(elementosDeNumeros);
        }
        duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuracao linear = %.3f segundos", duracao / 1000.0);

        return null;  // ToDo IMPLEMENT ME!!!!
    }
}