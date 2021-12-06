import BotaoConcluirTarefa from './BotaoConcluirTarefa.js';
import BotaoDeletarTarefa from './BotaoDeletarTarefa.js';

const ItemLista = ({textoTarefa, dataTarefa, estadoTarefaConcluida}, index) => {
  const novoItemLista = document.createElement('li');
  if(estadoTarefaConcluida){
    novoItemLista.classList.add('task','done');
  } else {
    novoItemLista.classList.add('task');
  }
  novoItemLista.innerHTML = `<p class='content'>${textoTarefa}</p>`;
  novoItemLista.appendChild(BotaoConcluirTarefa(index));
  novoItemLista.appendChild(BotaoDeletarTarefa(index));

  return novoItemLista;
}

export default ItemLista;
