package obj;

import java.util.Set;
import java.util.TreeSet;

import inst.*;

public class Pessoa {
	
    private String nome;
    private String cpf;
    private int idade;
    private String endereco;
    private String cartaoSUS;
    private String email;
    private String telefone;
    private String profissao;
    
    private Set<String> comorbidades; 
    private Situacao situacao;

    public Pessoa(String nome, String cpf, int idade, String endereco, String cartaoSUS, 
    		String email, String telefone, String profissao, String comorbidades) {
        
    	this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.cartaoSUS = cartaoSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        
        this.situacao = new NaoHabilitada();
        
        setComorbidades(comorbidades);
    }
    
    
    //acoes    
    public void addComorbidade(String comorbidade) {
        this.comorbidades.add(comorbidade);
    }
    
    public void avancarEtapa(){
        this.situacao.mudaSituacao(this);
    }
    
    public void tomarVacina(){
        this.situacao.tomaVacina(this);
    }

    
    //gets
    public String getNome() {
        return this.nome;
    }

    public String getSituacaoTextual(){
        return "A pessoa " + this.nome + "se encontra na situa��o: " + this.situacao.toString() + "\n\n";
    }
    
    public Situacao getSituacao(){
        return this.situacao;
    }
    
    public int getIdade(){
        return this.idade;
    }   

    public String getCpf() {
        return this.cpf;
    }
   
    public String getEndereco() {
        return this.endereco;
    }

    public String getCartaoSUS() {
        return this.cartaoSUS;
    }    

    public String getEmail() {
        return this.email;
    }   

    public String getTelefone() {
        return this.telefone;
    }    

    public String getProfissao() {
        return this.profissao;
    }    

    public Set<String> getComorbidades() {
        return this.comorbidades;
    }
    

    //sets
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setComorbidades(String comorbidades){
      
    	Set<String> aux = new TreeSet<String>();
    
    	for (String comorbidade : comorbidades.split(" ")){
            aux.add(comorbidade);
        }
       
    	this.comorbidades = aux;
    }
    
    public void setSituacao(Situacao situacao){
        this.situacao = situacao;
    }
    
    public void setIdade(int idade){
        this.idade =idade;
    }

    @Override
    public String toString(){
        return this.nome + "\n" +
        "cpf: " + this.cpf + "\n" +
        "situacao: " + this.situacao.toString() + "\n";
    }

}
