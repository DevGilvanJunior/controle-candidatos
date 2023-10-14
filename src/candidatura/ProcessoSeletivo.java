package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        //selecaoCandidatos();
        //imprimirSelecionados();
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean contiuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            contiuaTentando = !atendeu;
            if (contiuaTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }
        }while(contiuaTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MAXIMO DE TENTATIVAS: " + tentativasRealizadas);
        }else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MAXIMO DE TENTATIVAS: " + tentativasRealizadas);
        }
    }

    //metodo auxiliar "atender"
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};

        //abaixo duas formas de usar o for para buscar os candidatos - a segunda esta comentada

        //forma normal
        System.out.println("Utilizando o índice do Array");
        for(int indice = 0; indice < candidatos.length; indice++ ){
            System.out.println("O candidato " + (indice + 1) + " é " + candidatos[indice]);
        }

        //forma abreviada
        // System.out.println("Forma abreviada - Utilizando for each");
        // for(String candidato:candidatos){
        //     System.out.println("O candidato selecionado foi " + candidato);
        // }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
                candidatosSelecionados++;
            }else{
                System.out.println("O candidato " + candidato + " NÃO foi selecionado!");
            }
            candidatosAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO!");
        }else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA!");
        }else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS!");
        }

    }


}