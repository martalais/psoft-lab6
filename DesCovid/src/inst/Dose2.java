package inst;

import obj.Pessoa;

public class Dose2 extends Situacao {

	@Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + ": So podera passar para a proxima fase quando tomar a segunda dose.\n\n");        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        pessoa.setSituacao(new Imunizada());
        System.out.println(pessoa.getNome() + ": Segunda dose da vacina recebida, parabens! Voce esta imunizade!.\n\n");        
    }

    @Override
    public String toString(){
        return "Pessoa habilitada para a Segunda Dose.";
    }
    
}
