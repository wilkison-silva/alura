import {buscarItems} from './persistirDados.js';
import ItemLista from '../componentes/ItemLista.js';

export const carregarListaDeTarefas = () => {
  const itemSalvos = buscarItems();
  const lista = document.querySelector('#lista-de-tarefas');

  itemSalvos.forEach(item => lista.appendChild(ItemLista(item)));
}
