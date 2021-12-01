class SistemaAutenticacao {


  static login(funcionario, senha){
    return funcionario.senha == senha;
  }

}

export default SistemaAutenticacao;