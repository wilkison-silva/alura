import Conta from "./Conta.js"

class ContaPoupanca extends Conta{

  static numeroDeContas = 0;

  constructor(saldoInicial, agencia, cliente){
    super(saldoInicial, agencia, cliente);
    ContaPoupanca.numeroDeContas += 1;
  }

  sacar(valor){
    const taxa = 1.02;
    return super._sacar(valor, taxa);
  }

}

export default ContaPoupanca;
