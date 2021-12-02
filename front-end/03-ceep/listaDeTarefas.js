const botaoNovoItem = document.querySelector('#botao-novo-item');

const criarNovaTarefa = (evento) => {
  evento.preventDefault();

  const inputDescricaoTarefa = document.querySelector('#input-descricao-tarefa');
  const textoTarefa = inputDescricaoTarefa.value;
  inputDescricaoTarefa.value = "";

  const itemLista = document.querySelector('#item-lista');
  const conteudo = `<p class="content">${textoTarefa}</p>`
  itemLista.innerHTML = conteudo;


}

botaoNovoItem.addEventListener('click',criarNovaTarefa);