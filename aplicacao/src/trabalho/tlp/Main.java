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
        
        //objetos que manipulam o banco de dados
        
        MedicoBanco man_medico = new MedicoBanco();
        PacienteBanco man_paciente = new PacienteBanco();
        CirurgiaBanco man_cirurgia = new CirurgiaBanco();
        
        
        
        int opcao = 0;
        System.out.println("------SEJA BEM-VINDO USUÁRIO------");
        System.out.println("------FEITO POR:\n-Davi Figueiredo\n-Gutemberg Souza\n-João Chaparro\n\n");
        
        do
        {
            
            Medico medico = new Medico();
            Paciente paciente = new Paciente();
            Reserva reserva = new Reserva();             
            Cirurgia cirurgia = new Cirurgia();
            
            System.out.println("\n\n---------OPÇÕES---------");
            System.out.println("0- Sair!");
            System.out.println("1- Cadastrar uma cirurgia");
            System.out.println("2- Listar Cirurgias");
            System.out.println("3- Alterar médico da cirurgia\n: ");
            System.out.println("----------NÃO OBRIGATÓRIOS---------");
            System.out.println("4- Adicionar médico");
            System.out.println("6- Adicionar paciente");
            System.out.println("7- Adicionar reserva");
            
            opcao = input.nextInt();
            
            switch(opcao)
            {
                case 0:
                    System.out.println("Até mais professora Lia");
                    break;
                    
                case 1:                
                   
                    
                    System.out.println("\n---------OPCÃO 1---------");
                    
                    System.out.println("Qual o nome do médico que fará a cirurgia ?: ");                 
                    medico.setId(man_medico.buscar_por_nome(input.next()));
                    
                    System.out.println("Qual o nome do paciente ?: ");
                    paciente.setId(man_paciente.buscar_por_nome(input.next()));
                    
                    System.out.println("Qual o codigo da reserva?: ");//numero do centro cirurgico está dentro da reserva
                    reserva.setId(input.nextInt());
                    
                    cirurgia.setPaciente(paciente); cirurgia.setMedico(medico); cirurgia.setReserva(reserva);
                    man_cirurgia.adicionar(cirurgia);
                    
                    break;
                    
                case 2:
                    Cc cc = new Cc();
                    System.out.println("\n---------OPÇÃO 2---------");
                    
                    System.out.println("Digite o número/id do centro cirúrgico: ");
                    cc.setId(input.nextInt());
                    man_cirurgia.listar_cirurgias(cc.getId());
                                          
                    break;
                    
                case 3:
                    //alterar médico da cirurgia
                    break;
                    
                //não obrigatórios
                case 4:
                    
                    System.out.println("Nome do médico: ");
                    medico.setNome(input.next());
                    System.out.println("Crm do médico: ");
                    medico.setNum_crm(input.nextInt());
                    System.out.println("Especialidade: ");
                    medico.setEspecialidade(input.next());
                    
                    man_medico.adicionar(medico);
                    
                    
                    //alterar médico da cirurgia
                    break;
                case 5:
                    //alterar médico da cirurgia
                    break;
                case 6:
                    //alterar médico da cirurgia
                    break;
                    
                    
                default:
                    System.out.println("Opção não existe!");
                    break;
                                
            }
        }while(opcao !=0);
        // TODO code application logic here
    }
    
}
