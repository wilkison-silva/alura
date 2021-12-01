import Conta from "./Conta.js"

class ContaSalario extends Conta{

  static numeroDeContas = 0;

  constructor(agencia, cliente){
    super(0, agencia, cliente);
    ContaPoupanca.numeroDeContas += 1;
  }

  sacar(valor){
    const taxa = 1.01;
    return super._sacar(valor, taxa);
  }

}

export default ContaPoupanca;
