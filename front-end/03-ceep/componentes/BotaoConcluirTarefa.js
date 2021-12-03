const BotaoConcluirTarefa = () => {
  const botaoConcluirTarefa = document.createElement('button');
  botaoConcluirTarefa.innerText = 'concluir';
  botaoConcluirTarefa.addEventListener('click', (evento) => {
    const itemDaListaFinalizada = evento.target.parentNode;
    itemDaListaFinalizada.classList.toggle('done');
  });

  return botaoConcluirTarefa;
}

export default BotaoConcluirTarefa;
