//Classe abstrata
class Conta {

  constructor(saldoInicial, agencia, cliente){
    if(this.constructor == Conta){
      throw new Error("Você não deve instanciar esta classe diretamente, pois ela é abstrata");
    }

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

  //método abstrato
  sacar(valor){

  }

  _sacar(valor, taxa){
    const valorASacar = taxa * valor;
    if(this._saldo >= valorASacar){
      this._saldo -= valorASacar;
      return this._saldo;
    }
    return 0;
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
