import ItemLista from "../componentes/ItemLista.js";
import { salvarItem } from "./persistirDados.js";
import {carregarListaDeTarefas} from './carregarListaDeTarefas.js';

const criarNovaTarefa = (evento) => {
  evento.preventDefault();
  const inputDescricaoTarefa = document.querySelector(
    "#input-descricao-tarefa"
  );
  const textoTarefa = inputDescricaoTarefa.value.trim();
  const dataTarefa = moment(
    document.querySelector("#input-data-tarefa").value
  ).format("DD-MM-YYYY");

  if (textoTarefa) {
    inputDescricaoTarefa.value = "";
    const lista = document.querySelector("#lista-de-tarefas");
    const estadoTarefaConcluida = false;
    const dados = { textoTarefa, dataTarefa, estadoTarefaConcluida };
    lista.appendChild(ItemLista(dados));
    salvarItem(dados);
    carregarListaDeTarefas();
  }
};

export default criarNovaTarefa;
