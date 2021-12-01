import Conta from "./Conta.js"

class ContaCorrente extends Conta {

  constructor(agencia, cliente){
    super(0, agencia, cliente);
    ContaCorrente.numeroDeContas += 1;
  }

  sacar(valor){
    let taxa = 1.1;
    const valorASacar = taxa * valor;
    if(this._saldo >= valorASacar){
      this._saldo -= valorASacar;
      return this._saldo;
    }
  }

}

export default ContaCorrente;
