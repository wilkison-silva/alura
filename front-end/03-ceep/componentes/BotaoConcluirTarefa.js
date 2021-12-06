import {atualizarEstadoTarefa} from '../actions/persistirDados.js';
import {carregarListaDeTarefas} from '../actions/carregarListaDeTarefas.js';

const BotaoConcluirTarefa = (index) => {
  const botaoConcluirTarefa = document.createElement('button');
  botaoConcluirTarefa.innerText = 'concluir';
  botaoConcluirTarefa.classList.add('check-button');

  botaoConcluirTarefa.addEventListener('click', (evento) => {
    const itemDaListaFinalizada = evento.target.parentNode;
    console.log(itemDaListaFinalizada);
    itemDaListaFinalizada.classList.toggle('done');
    atualizarEstadoTarefa(index);
    carregarListaDeTarefas();

  });

  return botaoConcluirTarefa;
}

export default BotaoConcluirTarefa;
