
const ItemData = (dataTarefa) => {
  const novoItemData = document.createElement('li');
  // novoItemData.classList.add('content');
  novoItemData.innerHTML = `<p class='content-data'>${dataTarefa}</p>`;

  return novoItemData;

};

export default ItemData;
