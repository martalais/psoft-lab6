package inst;

import obj.Pessoa;

public class Imunizada extends Situacao {

	@Override
    public void mudaSituacao(Pessoa pessoa) {
        System.out.println("Processo de vacinacao finalizado.\n\n");        
    }

    @Override
    public void tomaVacina(Pessoa pessoa) {
        System.out.println("Processo de vacinacao finalizado.\n\n");
    }

    @Override
    public String toString(){
        return "Processo de vacinacao finalizado, pessoa imunizada!";
    }

}
