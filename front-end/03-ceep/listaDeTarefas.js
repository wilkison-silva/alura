
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
    lista.appendChild(novoItemLista);

    inputDescricaoTarefa.value = "";
  }

  botaoNovoItem.addEventListener('click',criarNovaTarefa);

  const BotaoConcluirTarefa = () => {
    const botaoConcluirTarefa = document.createElement('button');

    botaoConcluirTarefa.addEventListener('click', (evento) => {
      const itemDaListaFinalizada = evento.target.parentNode;
      itemDaListaFinalizada.classList.toggle('done');
    });

    return botaoConcluirTarefa;
  }
})();
