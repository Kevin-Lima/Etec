public class Exercicio3 {

    public static void main(String[] args) {
        int i = 4001; // Começa a partir de 4001, para excluir 4000
        
        // Loop que vai de 4001 até 5999 (não inclui 6000)
        for(; i < 6000; i++) {
            // O loop só incrementa i até 5999
        }
        
        // Calcula quantos números têm entre 4001 e 5999 (excluindo 4000 e 6000)
        int q = i - 4001; // Subtrai 4001 para contar corretamente os números entre 4000 e 6000
        
        // Mostra a quantidade de números
        System.out.println("Quantidade de números entre 4000 e 6000: " + q);
    }
}
