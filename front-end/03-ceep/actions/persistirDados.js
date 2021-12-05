export const buscarItems = () => (
  JSON.parse(localStorage.getItem('itemsLista')) || []
);

export const salvarItem = (dados) => {
  const itemsListaAtualizados = buscarItems();
  itemsListaAtualizados.push(dados);
  localStorage.setItem('itemsLista',JSON.stringify(itemsListaAtualizados));
}
