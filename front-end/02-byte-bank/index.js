import Cliente from "./Cliente.js"
import ContaCorrente from "./ContaCorrente.js"
import ContaPoupanca from "./ContaPoupanca.js"

const cliente1 = new Cliente("Ricardo", 11122233309);

const contaCorrenteRicardo = new ContaCorrente(1001, cliente1);
contaCorrenteRicardo.depositar(500);
contaCorrenteRicardo.sacar(50);

const contaPoupanca = new ContaPoupanca(50,1001,cliente1);
contaPoupanca.sacar(10);

console.log(contaPoupanca);
console.log(contaCorrenteRicardo);