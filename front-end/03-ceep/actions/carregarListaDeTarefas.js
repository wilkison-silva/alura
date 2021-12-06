import {buscarItems} from './persistirDados.js';
import ItemLista from '../componentes/ItemLista.js';
import ItemData from "../componentes/ItemData.js";

export const carregarListaDeTarefas = () => {
  const itemSalvos = buscarItems();

  const lista = document.querySelector('#lista-de-tarefas');
  lista.innerHTML = "";
  const datasCarregadas = [];
  itemSalvos.forEach((item, index) => {
    if(datasCarregadas.indexOf(item.dataTarefa) === -1) {
      lista.appendChild(ItemData(item.dataTarefa));
      datasCarregadas.push(item.dataTarefa);
    }
    lista.appendChild(ItemLista(item, index));
  });
}
