import ItemListaClientesCadastrados from '../componentes/ItemListaClientesCadastrados.js';
import { getListaClientesCadastrados } from '../service/cliente-service.js';

const listaClientesCadastrados = document.querySelector(
  '#tbody-clientes-cadastrados',
);

const lista = await getListaClientesCadastrados();
lista.forEach((cliente) => {
  listaClientesCadastrados.appendChild(
    ItemListaClientesCadastrados(cliente.nome, cliente.email),
  );
});

// const mapClientsList = async () => {
//   const clients = await getListaClientesCadastrados();

//   clients.forEach(cliente => {
//     listaClientesCadastrados
//       .appendChild(ItemListaClientesCadastrados(cliente.nome, cliente.email));
//   });
// }

// getListaClientesCadastrados()
//   .then(clientesCadastrados => {
//     clientesCadastrados.forEach(cliente => {
//       console.log(cliente);
//       listaClientesCadastrados
//         .appendChild(ItemListaClientesCadastrados(cliente.nome, cliente.email));
//     });
//   });
