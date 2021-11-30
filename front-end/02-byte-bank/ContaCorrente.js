class ContaCorrente {
  static numeroDeContas = 0;
  agencia;
  _cliente;
  _saldo = 0;

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

  constructor(agencia, cliente){
    this.agencia = agencia;
    this._cliente = cliente;
    ContaCorrente.numeroDeContas += 1;
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

export default ContaCorrente;
