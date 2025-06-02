
package com.mycompany.atividade1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Atividade1 {

    public static void main(String[] args) {
          double nota1=0, nota2=0, nota3=0, nota4=0, nota5=0, media=0;
        
        nota1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 1 nota"));
        nota2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 2 nota"));
        nota3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 3 nota"));
        nota4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 4 nota"));
        nota5 = Double.parseDouble(JOptionPane.showInputDialog("Digite a 5 nota"));

        media=(nota1+nota2+nota3+nota4+nota5)/5;
        
        if(media >=5){
            
            JOptionPane.showMessageDialog(null, "O aluno foi aprovado com media: " + media);
        }
        else{
            
            JOptionPane.showMessageDialog(null, "O aluno não foi aprovado. media: " + media);
            
        }

    }
}
