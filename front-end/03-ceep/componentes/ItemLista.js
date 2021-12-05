import BotaoConcluirTarefa from './BotaoConcluirTarefa.js';
import BotaoDeletarTarefa from './BotaoDeletarTarefa.js';

const ItemLista = (textoTarefa, dataTarefa) => {
  const novoItemLista = document.createElement('li');
  novoItemLista.classList.add('task');
  novoItemLista.innerHTML = `<p class='content'>${dataTarefa} * ${textoTarefa}</p>`;
  novoItemLista.appendChild(BotaoConcluirTarefa());
  novoItemLista.appendChild(BotaoDeletarTarefa());

  return novoItemLista;
}

export default ItemLista;
