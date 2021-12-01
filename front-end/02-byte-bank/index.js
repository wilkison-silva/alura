import Cliente from "./Cliente.js"
import Gerente from "./Funcionario/Gerente.js"
import Diretor from "./Funcionario/Diretor.js"
import SistemaAutenticacao from "./SistemaAutenticacao.js"

const diretor = new Diretor("Rodrigo", 10000, 12345678900);
const gerente = new Gerente("Ricardo", 5000, 11122233300);


diretor.cadastrarSenha("123456");
const estaLogado = SistemaAutenticacao.login(diretor,"123456");

console.log(estaLogado);