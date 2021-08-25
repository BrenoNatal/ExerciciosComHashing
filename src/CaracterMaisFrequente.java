import java.util.HashMap;

public class CaracterMaisFrequente {

    public static char encontrarCaracterMaisFrequente(String texto) {
        HashMap<Character, Integer> caracterByOcorrencias = new HashMap<>();

        // Algoritmo ineficiente (quadrático):

        long inicio = System.currentTimeMillis();
        char maisFrequente = texto.charAt(0);
        int ocorrenciasDoMaisFrequente = 1;

        for (int i = 0; i < texto.length(); i++) {
            char caracterDaVez = texto.charAt(i);
            int contOcorrencias = 1;
            for (int j = i + 1; j < texto.length(); j++) {
                if (texto.charAt(j) == caracterDaVez) {
                    contOcorrencias++;
                }
            }

            if (contOcorrencias > ocorrenciasDoMaisFrequente) {
                maisFrequente = caracterDaVez;
                ocorrenciasDoMaisFrequente = contOcorrencias;
            }
        }

        long duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuracao quadratica = %.3f segundos", duracao / 1000.0);


        // Algoritmo eficiente (linear):

        maisFrequente = texto.charAt(0);

        inicio = System.currentTimeMillis();

        for (int i = 0; i < texto.length(); i++) {
            char caracterDaVez = texto.charAt(i);
            int contOcorrencias = 1;
            if (caracterByOcorrencias.containsKey(caracterDaVez)) {
                caracterByOcorrencias.put(caracterDaVez, caracterByOcorrencias.get(caracterDaVez) + 1);
            }
            else {
                caracterByOcorrencias.put(caracterDaVez, contOcorrencias);
            }
        }

        int ocorrenciasDoMaisFrequnte = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caracterDaVez = texto.charAt(i);
            if (caracterByOcorrencias.get(caracterDaVez) > ocorrenciasDoMaisFrequnte) {
                maisFrequente = caracterDaVez;
                ocorrenciasDoMaisFrequnte = caracterByOcorrencias.get(caracterDaVez);
            }
        }

        duracao = System.currentTimeMillis() - inicio;
        System.out.printf("\nDuracao linear = %.3f segundos", duracao / 1000.0);

        return maisFrequente;

    }
}
