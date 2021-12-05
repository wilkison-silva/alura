import ItemLista from "./componentes/ItemLista.js";

const botaoNovoItem = document.querySelector("#botao-novo-item");

const criarNovaTarefa = (evento) => {
  evento.preventDefault();
  const inputDescricaoTarefa = document.querySelector("#input-descricao-tarefa");
  const textoTarefa = inputDescricaoTarefa.value;
  inputDescricaoTarefa.value = "";

  const lista = document.querySelector("#lista-de-tarefas");
  lista.appendChild(ItemLista(textoTarefa));
};

botaoNovoItem.addEventListener("click", criarNovaTarefa);
