import {deletarItem} from '../actions/persistirDados.js';
import {carregarListaDeTarefas} from '../actions/carregarListaDeTarefas.js';

const BotaoDeletarTarefa = (index) => {
  const botaoDeletarTarefa = document.createElement('button');
  botaoDeletarTarefa.classList.add('delete-button')
  botaoDeletarTarefa.innerText = 'deletar';
  botaoDeletarTarefa.addEventListener('click', (evento) => {
    const itemDaListaParaExcluir = evento.target.parentNode;
    itemDaListaParaExcluir.remove();
    deletarItem(index);
    carregarListaDeTarefas();

  });

  return botaoDeletarTarefa;
}

export default BotaoDeletarTarefa;
