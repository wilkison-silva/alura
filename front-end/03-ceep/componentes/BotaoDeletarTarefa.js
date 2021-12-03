const BotaoDeletarTarefa = () => {
  const botaoDeletarTarefa = document.createElement('button');
  botaoDeletarTarefa.innerText = 'deletar';
  botaoDeletarTarefa.addEventListener('click', (evento) => {
    const itemDaListaParaExcluir = evento.target.parentNode;
    itemDaListaParaExcluir.remove();
  });

  return botaoDeletarTarefa;
}

export default BotaoDeletarTarefa;