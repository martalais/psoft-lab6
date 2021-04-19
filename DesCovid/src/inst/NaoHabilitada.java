package inst;

import obj.Pessoa;

public class NaoHabilitada extends Situacao {

	@Override
    public void mudaSituacao(Pessoa pessoa) {
        pessoa.setSituacao(new Dose1());
        System.out.println(pessoa.getNome() + ": esta habilitada para receber a Primeira Dose agora.\n\n");
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println(pessoa.getNome()+ ": ainda nao esta habilitada para receber a Primeira Dose agora.\n\n");
        
    }
    @Override
    public String toString() {
        return "Nao habilitada para a Primeira Dose da vacina.";
    }

}
