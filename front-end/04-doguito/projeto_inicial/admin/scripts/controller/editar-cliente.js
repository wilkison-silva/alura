import {getClienteCadastrado} from '../service/cliente-service.js';
import {atualizarCliente} from '../service/cliente-service.js';

const url = new URL(window.location);
const id = url.searchParams.get('id');

const inputNome = document.querySelector('#nome');
const inputEmail = document.querySelector('#email');

const cliente = await getClienteCadastrado(id);
inputNome.value = cliente.nome;
inputEmail.value = cliente.email;

const formulario = document.querySelector('[data-form]');
formulario.addEventListener('submit',async (evento) => {
  evento.preventDefault();
  await atualizarCliente(id, inputNome.value, inputEmail.value);
  window.location.href = '../telas/edicao_concluida.html';
})