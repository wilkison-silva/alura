import ItemListaClientesCadastrados from '../componentes/ItemListaClientesCadastrados.js';
import { getListaClientesCadastrados } from '../service/cliente-service.js';
import { deletarCliente } from '../service/cliente-service.js';

const listaClientesCadastrados = document.querySelector(
  '#tbody-clientes-cadastrados',
);

listaClientesCadastrados.addEventListener('click', async (evento) =>{
  if(evento.target.className === "botao-simples botao-simples--excluir") {
    const linhaCliente = evento.target.closest('[data-id]');
    let id = linhaCliente.dataset.id;
    console.log(id);
    await deletarCliente(id);
    linhaCliente.remove();
  }
});

const mapClientsList = async () => {
  const clients = await getListaClientesCadastrados();

  clients.forEach(cliente => {
    listaClientesCadastrados
      .appendChild(ItemListaClientesCadastrados(cliente.nome, cliente.email, cliente.id));
  });
}

mapClientsList();
