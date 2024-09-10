/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho.tlp;

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
        int opcao = 0;
        System.out.println("------SEJA BEM-VINDO USUÁRIO------");
        System.out.println("------FEITO POR:\n-Davi Figueiredo\n-Gutemberg Souza\n-João Chaparro");
        
        
        
        //cadastro automático de centros cirurgicos, médicos e pacientes
        do
        {
            System.out.println("------OPÇÕES------");
            System.out.println("0- Sair!");
            System.out.println("1- Cadastrar uma cirurgia");
            System.out.println("2- Listar Cirurgias");
            System.out.println("3- Alterar médico da cirurgia");
            
            switch(opcao)
            {
                case 0:
                    System.out.println("Até mais professora Lia");
                    break;
                case 1:
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
