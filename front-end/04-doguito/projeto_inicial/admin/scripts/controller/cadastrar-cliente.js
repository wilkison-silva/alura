import {cadastrarCliente} from '../service/cliente-service.js';

const formularioCadastrarCliente = document.querySelector('#formulario-cadastro-cliente');

formularioCadastrarCliente.addEventListener('submit', async (evento) => {
  evento.preventDefault();
  const nomeCliente = evento.target.querySelector('#nome').value;
  const emailCliente = evento.target.querySelector('#email').value;

  await cadastrarCliente(nomeCliente, emailCliente)
  window.location.href = '../telas/cadastro_concluido.html';

});
