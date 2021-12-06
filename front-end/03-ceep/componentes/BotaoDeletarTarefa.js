import {carregarListaDeTarefas} from '../actions/carregarListaDeTarefas.js';
const BotaoDeletarTarefa = () => {
  const botaoDeletarTarefa = document.createElement('button');
  botaoDeletarTarefa.classList.add('delete-button')
  botaoDeletarTarefa.innerText = 'deletar';
  botaoDeletarTarefa.addEventListener('click', (evento) => {
    const itemDaListaParaExcluir = evento.target.parentNode;
    itemDaListaParaExcluir.remove();
    carregarListaDeTarefas();
  });

  return botaoDeletarTarefa;
}

export default BotaoDeletarTarefa;
