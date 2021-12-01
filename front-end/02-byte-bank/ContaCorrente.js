import Conta from "./Conta.js"

class ContaCorrente extends Conta {

  constructor(agencia, cliente){
    super(0, agencia, cliente);
    ContaCorrente.numeroDeContas += 1;
  }

  sacar(valor){
    let taxa = 1.1;
    return super._sacar(valor, taxa);
  }

}

export default ContaCorrente;
