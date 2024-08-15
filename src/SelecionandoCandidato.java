import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class SelecionandoCandidato {
    private final static int SELECIONADOS_POR_VAGA = 5;
    public static void main(String[] args) {
        selecaoCandidatos();
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"CARLOS", "JOAO", "MARCOS", "ANTONIO", "PEDRO", "JOSE", "MATHEUS", "ALEX", "FERNANDO", "FRANKLEY", "BERNARDO"};

        Map<Integer, Candidato> candidatosValor = new HashMap<>();
        double salarioBase = 2000.0;
        int selecionados = 0;

        for (int i = 0; i < candidatos.length; i++) {
            double valorPretendido = valorPretendido();
            DecimalFormat df = new DecimalFormat("#.00");
            String formattedValue = df.format(valorPretendido);
            valorPretendido = Double.parseDouble(formattedValue.replace(',', '.'));

            if (salarioBase >= valorPretendido) {
                candidatosValor.put(i, new Candidato(candidatos[i], valorPretendido));
                selecionados += 1;
                if (selecionados == SELECIONADOS_POR_VAGA) {
                    break;
                }
            }
            
        }
        
        String message = "";

        for (Map.Entry<Integer, Candidato> candidato : candidatosValor.entrySet()) {
            Candidato value = candidato.getValue();
                       
            // analisandoCandidato(value.getValor());
            if (atender()) {
                value.setAtendimento("atendeu a ligação");
                System.out.println("atendeu");
            } else {
                value.setAtendimento("não atendeu a ligação");
            }
            message += "Candidato: " + value.getNome() + " valor: " + value.getValor() + " " + value.atendeuLigacao() + "\n";
        }

        JOptionPane.showMessageDialog(null, "Ligar para os candidatos:\n" + message);
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1400, 2500);
    }

    static void analisandoCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if ( salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }

    static boolean atender() {
        return new Random().nextInt(5) == 1;
    }
}
