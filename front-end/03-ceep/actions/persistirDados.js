export const buscarItems = () => {
  const itemsSalvos = JSON.parse(localStorage.getItem('itemsLista')) || [];
  const ItemsOrdenadosPorData = organizarTarefasPorData(itemsSalvos);

  return ItemsOrdenadosPorData;
}

export const salvarItem = (dados) => {
  const itemsListaAtualizados = buscarItems();
  itemsListaAtualizados.push(dados);
  localStorage.setItem('itemsLista',JSON.stringify(itemsListaAtualizados));
}

const organizarTarefasPorData = (dados) => {
  dados.sort((a, b) => {
    const primeiraData = moment(a.dataTarefa,'DD/MM/YYYY').format('YYYYMMDD');
    const segundaData = moment(b.dataTarefa,'DD/MM/YYYY').format('YYYYMMDD');

    return primeiraData-segundaData;
  });
  return dados;
}

export const deletarItem = (index) => {
  const itemsListaAtualizados = buscarItems();
  itemsListaAtualizados.splice(index, 1);
  localStorage.setItem('itemsLista',JSON.stringify(itemsListaAtualizados));
}

export const atualizarEstadoTarefa = (index) => {
  const itemsListaAtualizados = buscarItems();
  itemsListaAtualizados[index].estadoTarefaConcluida = !itemsListaAtualizados[index].estadoTarefaConcluida;
  localStorage.setItem('itemsLista',JSON.stringify(itemsListaAtualizados));
}