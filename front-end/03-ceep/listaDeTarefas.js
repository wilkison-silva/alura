
(() => {

  const botaoNovoItem = document.querySelector('#botao-novo-item');

  const criarNovaTarefa = (evento) => {
    evento.preventDefault();
    const inputDescricaoTarefa = document.querySelector('#input-descricao-tarefa');
    const textoTarefa = inputDescricaoTarefa.value;
    const conteudo = `<p class="content">${textoTarefa}</p>`;

    const lista = document.querySelector('#lista-de-tarefas');
    const novoItemLista = document.createElement('li');
    novoItemLista.classList.add('task');
    novoItemLista.innerHTML = conteudo;
    novoItemLista.appendChild(BotaoConcluirTarefa());
    novoItemLista.appendChild(BotaoDeletarTarefa());
    lista.appendChild(novoItemLista);

    inputDescricaoTarefa.value = "";
  }

  botaoNovoItem.addEventListener('click',criarNovaTarefa);

  const BotaoConcluirTarefa = () => {
    const botaoConcluirTarefa = document.createElement('button');
    botaoConcluirTarefa.innerText = 'concluir';
    botaoConcluirTarefa.addEventListener('click', (evento) => {
      const itemDaListaFinalizada = evento.target.parentNode;
      itemDaListaFinalizada.classList.toggle('done');
    });

    return botaoConcluirTarefa;
  }

  const BotaoDeletarTarefa = () => {
    const botaoDeletarTarefa = document.createElement('button');
    botaoDeletarTarefa.innerText = 'deletar';
    botaoDeletarTarefa.addEventListener('click', (evento) => {
      const itemDaListaParaExcluir = evento.target.parentNode;
      itemDaListaParaExcluir.remove();
    });

    return botaoDeletarTarefa;
  }

})();
