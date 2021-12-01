class Conta {

  constructor(saldoInicial, agencia, cliente){
    this._saldo = saldoInicial;
    this._agencia = agencia;
    this._cliente = cliente;
  }

  set cliente(cliente){
    if(cliente instanceof Cliente){
      this._cliente = cliente;
    }
  }

  get cliente(){
    return this._cliente;
  }

  get saldo() {
    return this._saldo;
  }

  sacar(valor){
    if(this._saldo >= valor){
      this._saldo -= valor;
      return this._saldo;
    }
  }

  depositar(valor){
    if(valor <= 0){
      return;
    }
    this._saldo += valor;
  }

  transferir(valor, conta){
    const valorSacado = this.sacar(valor);
    conta.depositar(valorSacado);
  }

}

export default Conta;
