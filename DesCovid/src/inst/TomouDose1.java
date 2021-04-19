package inst;

import obj.Pessoa;

public class TomouDose1 extends Situacao {
	@Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new Dose2());
        System.out.print(pessoa.getNome() + ": esta habilitada para receber a segunda dose agora.\n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + ": nao esta habilida para receber a segunda dose agora.\n\n");    
    }

    @Override
    public String toString(){
        return "Ja recebeu a Primeira Dose e esta aguardando a Segunda Dose.";
    }

}
