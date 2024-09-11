/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho.tlp;

import java.util.Scanner;
import banco.PacienteBanco;
import banco.MedicoBanco;
import banco.ReservaBanco;
import banco.CirurgiaBanco;
import banco.CcBanco;

/**
 *
 * @author davi
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        MedicoBanco man_medico = new MedicoBanco();
        PacienteBanco man_paciente = new PacienteBanco();
        
        int opcao = 0;
        System.out.println("------SEJA BEM-VINDO USUÁRIO------");
        System.out.println("------FEITO POR:\n-Davi Figueiredo\n-Gutemberg Souza\n-João Chaparro");
        
        do
        {
            System.out.println("------OPÇÕES------");
            System.out.println("0- Sair!");
            System.out.println("1- Cadastrar uma cirurgia");
            System.out.println("2- Listar Cirurgias");
            System.out.println("3- Alterar médico da cirurgia");
            
            opcao = input.nextInt();
            switch(opcao)
            {
                case 0:
                    System.out.println("Até mais professora Lia");
                    break;
                    
                case 1:
                    
                    CirurgiaBanco cb = new CirurgiaBanco();
                    Medico medico = new Medico();
                    Paciente paciente = new Paciente();
                    Cc cc = new Cc();
                    Reserva reserva = new Reserva();
                    
                    Cirurgia cirurgia = new Cirurgia();
                    System.out.println("\n------OPCÃO 1------");
                    System.out.println("Qual o nome do médico que fará a cirurgia ?: ");
                    medico.setId(man_medico.buscar_por_nome(input.next()));
                    System.out.println("Qual o nome do paciente ?: ");
                    paciente.setId(man_paciente.buscar_por_nome(input.next()));
                    System.out.println("Qual o codigo da reserva?: ");
                    reserva.setId(input.nextInt());
                    System.out.println("Qual o número/id do Centro Cirúrgico?: ");
                    cc.setId(input.nextInt());
                    
                    cb.adicionar(medico, paciente, reserva,cc);
                                     
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                    
                default:
                    System.out.println("Opção não existe!");
                    break;
                                
            }
        }while(opcao !=0);
        // TODO code application logic here
    }
    
}
