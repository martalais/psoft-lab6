package inst;

import obj.Pessoa;

public class Dose1 extends Situacao {

	@Override
	public void mudaSituacao(Pessoa pessoa) {
        System.out.println(pessoa.getNome() + ": So podera passar para a proxima fase quando tomar a primeira dose.\n\n");		
	}

	@Override
	public void tomaVacina(Pessoa pessoa) {
		pessoa.setSituacao(new TomouDose1());
        System.out.println(pessoa.getNome() + ": Primeira dose da vacina recebida, aguardando a segunda dose.\n\n");		
	}
	
    @Override
    public String toString(){
        return "Pessoa habilitada para a Primeira Dose; ";
    }

}
