import ItemLista from './componentes/ItemLista.js';

const botaoNovoItem = document.querySelector('#botao-novo-item');

const criarNovaTarefa = (evento) => {
  evento.preventDefault();
  const inputDescricaoTarefa = document.querySelector(
    '#input-descricao-tarefa'
  );
  const textoTarefa = inputDescricaoTarefa.value.trim();
  if (textoTarefa) {
    inputDescricaoTarefa.value = '';
    const lista = document.querySelector('#lista-de-tarefas');
    const dataTarefa = moment(document.querySelector('#input-data-tarefa').value).format('DD-MM-YYYY');
    lista.appendChild(ItemLista(textoTarefa, dataTarefa));
  }
};

botaoNovoItem.addEventListener('click', criarNovaTarefa);
