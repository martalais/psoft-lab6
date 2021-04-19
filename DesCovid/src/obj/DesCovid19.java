package obj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import inst.*;

public class DesCovid19 {
	
	private Map<String, Pessoa> pessoasCadastradas;
    private Set<String> comorbidades;
    private Set<String> profissoes;
    private int idadeMinima;

    public DesCovid19(){
   
    	this.pessoasCadastradas = new HashMap<String, Pessoa>();
        this.comorbidades = new TreeSet<String>();
        this.profissoes = new TreeSet<String>();
        this.idadeMinima = 75;
        
    }

    //adicionar
    public void adicionaPessoa(String nome, String cpf, int idade,String endereco,
    		String cartaoSUS, String email, String telefone, String profissao, String comorbidades){
        
    	if(pessoasCadastradas.containsKey(cpf)){
            System.out.println("CPF: " + cpf + " ja cadastrado.\n\n");
        } else {            
            Pessoa pessoa = new Pessoa(nome, cpf, idade, endereco, cartaoSUS,  email,  
            		telefone,  profissao, comorbidades);
            atualizaSituacao(pessoa);
            pessoasCadastradas.put(cpf, pessoa);
        }
    	
    }

    public void adicionaComorbidade(String comorbidade){
        this.comorbidades.add(comorbidade);
        atualizaSituacoes();
    }
    
    public void adicionaProfissaoHabilitada(String profissao){
        this.profissoes.add(profissao);
        atualizaSituacoes();
    }
    
    
    //acoes
    public void passaEtapa(String cpf){
      
    	if (!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("CPF: " + cpf +" nao cadastrado.");
        } else if (verificaHabilitado(this.pessoasCadastradas.get(cpf))){
            this.pessoasCadastradas.get(cpf).avancarEtapa();
        } else {
            System.out.println("Nao habilitada para receber vacina.");
        }
    	
    }
    
    public void tomaVacina(String cpf){
       
    	if (!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("CPF: " + cpf +" nao cadastrado.");
        } else{
            this.pessoasCadastradas.get(cpf).tomarVacina();
        }
    	
    }
    
    private void atualizaSituacao(Pessoa pessoa) {
      
    	if (pessoa.getSituacao() instanceof NaoHabilitada && verificaHabilitado(pessoa)){
            pessoa.getSituacao().mudaSituacao(pessoa);
        }
    	
    }
    
    private void atualizaSituacoes() {
       
    	for (Pessoa pessoa : this.pessoasCadastradas.values()){
            atualizaSituacao(pessoa);
        }
    	
    }
    
    private boolean verificaHabilitado(Pessoa pessoa) {
       
    	if (pessoa.getIdade() >= idadeMinima) 
    		return true;
        if ( this.profissoes.contains(pessoa.getProfissao()))
        	return true;
        
        for(String comorbidade : pessoa.getComorbidades()){
            if(comorbidades.contains(comorbidade))
            	return true;
        }
        return false;        
    }
    

    //listar
    public void listaHabilitadasDose1(){
        
    	String output = "";
        
    	for (Pessoa pessoa : pessoasCadastradas.values()){
            if (pessoa.getSituacao() instanceof Dose1) 
            	output += pessoa.toString();
        }
        
    	System.out.print(output);
    }

    public void listaHabilitadasDose2(){
        
    	String output = "";
        
    	for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof Dose2) 
            	output += pessoa.toString();
        }
        
    	System.out.print(output);
    }

    public void listaNaoHabilitadas(){
        
    	String output = "";
        
    	for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof NaoHabilitada)
            	output += pessoa.toString();
        }
        
    	System.out.print(output);
    }
    
    public void listaTomaramDose1(){
        
    	String output = "";
        
    	for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof TomouDose1)
            	output += pessoa.toString();
        }
        
    	System.out.print(output);
    }
    
    public void listaImunizadas(){
       
    	String output = "";
        
    	for(Pessoa pessoa : pessoasCadastradas.values()){
            if(pessoa.getSituacao() instanceof Imunizada)
            	output += pessoa.toString();
        }
        
    	System.out.print(output);
    }
    
    public void listaComorbidadesHabilitadas(){
        
    	String output = "Comorbidades habilitadas a receber a vacina: \n";
        
    	for(String comorbidade : this.comorbidades){
    		output += comorbidade + "\n";
        }
        
    	System.out.print(output);
    }

    public void listaProfissoesHabilitadas(){
        
    	String output = "Profissoes habilitadas a receber a vacina: \n";
        
    	for(String profissao : this.profissoes){
    		output += profissao + "\n";
        }
        
    	System.out.print(output);
    }

    
    //gets
    public void getSituacaoAtual(String cpf) {
        
    	if (!this.pessoasCadastradas.containsKey(cpf)){
            System.out.println("Pessoa (CPF) nao cadastrado.\n\n");
        } else {
            System.out.println(this.pessoasCadastradas.get(cpf).toString() + " \n\n");
        }
    	
    }
    
    public void getIdadeMinimaVacinacao(){
        System.out.println("Idade minima atual para vacinacao: a partir de " + this.idadeMinima + " anos.");
    }

    public void getDetalhesVacinacao(){
    	System.out.println("Lista de Comorbidades Habilitadas Atualmente: \n");
        listaComorbidadesHabilitadas();
        System.out.println("\n\nLista de Profissoes Habilitadas Atualmente: \n");
        listaProfissoesHabilitadas();
        System.out.println("\n\nIdade Minima Atual: \n");
        getIdadeMinima();
        System.out.println("\n\n_______________________________________");
    }
    
    public Map<String, Pessoa> getPessoasCadastradas() {
        return this.pessoasCadastradas;
    }
    
    public int getIdadeMinima() {
        return this.idadeMinima;
    }
    
    public Set<String> getComorbidades() {
        return this.comorbidades;
    }
    
    public Set<String> getProfissoes() {
        return this.profissoes;
    }
    
    
    //sets
    public void setIdadeMinima(int idade){
        this.idadeMinima = idade;
        atualizaSituacoes();
    }

    public void setComorbidades(String cpf, String comorbidades){
        this.pessoasCadastradas.get(cpf).setComorbidades(comorbidades);
    }

    public void setProfissaoPessoa(String cpf, String profissao){
        this.pessoasCadastradas.get(cpf).setProfissao(profissao);
    }

    public void setPessoasCadastradas(Map<String, Pessoa> pessoasCadastradas) {
        this.pessoasCadastradas = pessoasCadastradas;
    }
    
    public void setComorbidades(Set<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public void setProfissoes(Set<String> profissoes) {
        this.profissoes = profissoes;
    }
    
}
