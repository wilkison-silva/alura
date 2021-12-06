
const ItemData = (dataTarefa) => {
  const novoItemData = document.createElement('li');
  novoItemData.classList.add('task');
  novoItemData.innerHTML = `<p class='content'>${dataTarefa}</p>`;

  return novoItemData;

};

export default ItemData;
