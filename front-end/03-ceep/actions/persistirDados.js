export const buscarItems = () => {
  const itemsSalvos = JSON.parse(localStorage.getItem('itemsLista')) || [];
  itemsSalvos.sort((a, b) => {
    const primeiraData = moment(a.dataTarefa,'DD/MM/YYYY').format('YYYYMMDD');
    const segundaData = moment(b.dataTarefa,'DD/MM/YYYY').format('YYYYMMDD');

    return primeiraData-segundaData;
  });
  return itemsSalvos;
}

export const salvarItem = (dados) => {
  const itemsListaAtualizados = buscarItems();
  itemsListaAtualizados.push(dados);
  localStorage.setItem('itemsLista',JSON.stringify(itemsListaAtualizados));
}