import BotaoConcluirTarefa from "./componentes/BotaoConcluirTarefa.js";
import BotaoDeletarTarefa from "./componentes/BotaoDeletarTarefa.js";

const botaoNovoItem = document.querySelector("#botao-novo-item");

const criarNovaTarefa = (evento) => {
  evento.preventDefault();
  const inputDescricaoTarefa = document.querySelector(
    "#input-descricao-tarefa"
  );
  const textoTarefa = inputDescricaoTarefa.value;
  const conteudo = `<p class="content">${textoTarefa}</p>`;

  const lista = document.querySelector("#lista-de-tarefas");
  const novoItemLista = document.createElement("li");
  novoItemLista.classList.add("task");
  novoItemLista.innerHTML = conteudo;
  novoItemLista.appendChild(BotaoConcluirTarefa());
  novoItemLista.appendChild(BotaoDeletarTarefa());
  lista.appendChild(novoItemLista);


  inputDescricaoTarefa.value = "";
};

botaoNovoItem.addEventListener("click", criarNovaTarefa);
