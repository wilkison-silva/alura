class SistemaAutenticacao {


  static login(autenticavel, senha){
    return autenticavel.autenticar(senha);
  }

}

export default SistemaAutenticacao;