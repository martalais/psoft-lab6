package main;

import java.util.Scanner;
import obj.DesCovid19;

public class Main {
	
	public static void main(String[] args){
		
		DesCovid19 app = new DesCovid19();
		
        String menu =  "\nBem-vinde ao DesCovid19!\n" +
        			   "_________________________________________" +
        			   "Vamos Desconvidar o Covid19 do seu Corpo? " +
        			   "_________________________________________ \n\n\n" +
        
        			   "Selecione sua opcao desejada:" + 
        			   "______________________________________________________________\n\n" +
        			   "\nPara cadastro e vacinacao: " +
        			   "[1] - Cadastrar; \n" +
        			   "[2] - Vacinar; \n" +
        			   
        			   "\n\nPara adicao de comorbidades e profissoes habilitadas: " +
        			   "[3] - Adicionar comorbidade habilitada para vacinacao; \n" +
        			   "[4] - Adicionar profissao habilitada para vacinacao; \n" +
        			   
					   "\n\nPara atualizar a idade minina necessaria para vacinacao: " +
        			   "[5] - Atualizar idade minima para vacinacao; \n" +   
					   
					   "\n\nPara alteracao de comorbidades e profissoes pessoais: " +
        			   "[6] - Alterar comorbidades; \n" + 
        			   "[7] - Alterar profissao; \n" +
        			   
					   "\n\nPara passar para a proxima fase de vacinacao: " +
        			   "[8] - Passar para proxima etapa de vacinacao; \n" +
					   
					   "\n\nPara listar informacoes: " +
        			   "[9] - Listar pessoas que nao estao habilitadas; \n" +
        			   "[10] - Listar pessoas habilitadas para proxima dose (1); \n" +
        			   "[11] - Listar pessoas habilitadas para proxima dose (2); \n" + 
        			   "[12] - Listar pessoas que tomaram a primeira dose; \n" + 
        			   "[13] - Listar pessoas que tomaram a segunda dose (imunizades); \n" +
        			   
					   "\n\nPara checar status atual: " +
        			   "[14] - Checar situacao atual; \n" +
					   
					   "\n\nPara mais detalhes sobre a vacinacao: " +
        			   "[15] - Detalhes sobre a Vacinacao; \n" + 

					   "\n\nPara sair do DesCovid19: " +
        			   "[0] - Sair;";
        
        
        Scanner input = new Scanner(System.in);
        int opcao;
        
        while(true){
            
        	System.out.println(menu);
            System.out.println("Insira aqui sua opcao: ");
            
            opcao = input.nextInt();
            input.nextLine();
            
            String cpf;            
            String profissao;
            String comorbidades;
            
            switch(opcao){
                
            	//cadastro;
            	case(1):
                    cadastraPessoa(input, app);
                    break;
                    
                //vacinar;
            	case(2):
                    System.out.println("Digite o CPF: ");
                    cpf = input.nextLine();
                    app.tomaVacina(cpf);
                    break;
                    
                //Adicionar comorbidade habilitada para vacinacao;
            	case(3):
            		System.out.println("Informe a comorbidade habilitada: ");
            		comorbidades = input.nextLine();
            		app.adicionaComorbidade(comorbidades);
                	break;
            	
                    
                //Adicionar profissao habilitada para vacinacao;
            	case(4):
            		System.out.println("Informea a profiss�o que ser� habilitada");
            		profissao = input.nextLine();
            		app.adicionaProfissaoHabilitada(profissao);
                	break;
            	
                
                //Atualizar idade minima para vacinacao;
            	case(5):
                    System.out.println("Digite a nova idade minima para vacinacao: ");
                    int idade = input.nextInt();
                    input.nextLine();
                    app.setIdadeMinima(idade);
                    break;
            	
                
                //Alterar comorbidades;
            	case(6):
            		System.out.println("Digite o CPF: ");
            		cpf = input.nextLine();
            		System.out.println("Informe as comorbidades: (separe por espaco)");
            		comorbidades = input.nextLine();
            		app.setComorbidades(cpf, comorbidades);
            		break;
                
                //Alterar profissao;
            	case(7):
            		System.out.println("Digite o CPF: ");
            		cpf = input.nextLine();
            		System.out.println("Informe a profissao: ");
            		profissao = input.nextLine();
            		app.setProfissaoPessoa(cpf, profissao);
            		break;
               
                //Passar para proxima etapa de vacinacao;
            	case(8):
                    System.out.println("Digite o CPF: ");
                    cpf = input.nextLine();
                    app.passaEtapa(cpf);
                    break;            	
              
                //Listar pessoas que nao estao habilitadas;
            	case(9):
            		app.listaNaoHabilitadas();
                    break;
                    
                //Listar pessoas habilitadas para proxima dose (1);
            	case(10):
                    app.listaHabilitadasDose1();
                    break;            	
                    
                //Listar pessoas habilitadas para proxima dose (2);
            	case(11):
                    app.listaHabilitadasDose2();
                    break;
                
                //Listar pessoas que tomaram a primeira dose;
            	case(12):
                    app.listaTomaramDose1();
                    break;            	
                
                //Listar pessoas que tomaram a segunda dose (imunizades);    
            	case(13):
                    app.listaImunizadas();
                    break;
                
                //Checar situacao atual;
            	case(14):
            		System.out.println("Informe o cpf da pessoa");
            		cpf = input.nextLine();
            		app.getSituacaoAtual(cpf);
            		break;
                    
                //Detalhes sobre a Vacinacao;
            	case(15):
                    app.getDetalhesVacinacao();
                    break;
            	                
                //Sair;
            	case(0):
                    break;
                default: 
                    System.out.println("Ops! Opcao Invalida! :( \n\n");
            }
        
            if (opcao == 0){
                System.out.println("Ate a proxima e use mascara :D");
                break;
            }
        }    
    }
	
    public static void cadastraPessoa(Scanner input, DesCovid19 app){
        
        String nome;
        String cpf;
        int idade;
        String endereco;
        String cartaoSUS;
        String email;
        String telefone;
        String profissao;
        String comorbidades;

        System.out.println("Digite o numero do CartaoSUS:_");
        cartaoSUS = input.nextLine();
        
        System.out.println("Digite o nome:_");
        nome = input.nextLine();

        System.out.println("Digite o CPF:_");
        cpf = input.nextLine();

        System.out.println("Digite a idade:_");
        idade = input.nextInt();
        input.nextLine();
        
        System.out.println("Digite a profissao:_");
        profissao = input.nextLine();

        System.out.println("Digite as comorbidades:_ (separe por espaco) ");
        comorbidades = input.nextLine();

        System.out.println("Digite o endereco:_");
        endereco = input.nextLine();        

        System.out.println("Digite o telefone pessoal:_");
        telefone = input.nextLine();
        
        System.out.println("Digite o email pessoal:_");
        email = input.nextLine();                

        app.adicionaPessoa(nome, cpf, idade, endereco, cartaoSUS, email, telefone, profissao, comorbidades);
    }	
}
