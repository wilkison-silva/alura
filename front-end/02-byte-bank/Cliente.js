class Cliente {

  constructor(nome, cpf) {
    this.nome = nome;
    this._cpf = cpf;
  }

  get cpf() {
    return this._cpf;
  }

  set cpf(cpf){
    this._cpf = cpf;
  }

}

export default Cliente;
