
const ItemData = (dataTarefa) => {
  const novoItemData = document.createElement('li');
  novoItemData.innerHTML = `<p class='content-data'>${dataTarefa}</p>`;

  return novoItemData;

};

export default ItemData;
