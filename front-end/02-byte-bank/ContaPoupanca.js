import Conta from "./Conta.js"

class ContaPoupanca extends Conta{

  static numeroDeContas = 0;

  constructor(saldoInicial, agencia, cliente){
    super(saldoInicial, agencia, cliente);
    ContaPoupanca.numeroDeContas += 1;
  }

}

export default ContaPoupanca;
