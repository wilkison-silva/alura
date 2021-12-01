import Funcionario from "./Funcionario.js"

class Diretor extends Funcionario{

  constructor(nome,salario,cpf) {

    super(nome,salario,cpf);
    this._bonificacao = 2;
  }

}

export default Diretor;
