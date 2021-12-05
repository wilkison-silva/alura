
import criarNovaTarefa from './actions/criarNovaTarefa.js';
import {carregarListaDeTarefas} from './actions/carregarListaDeTarefas.js';

const botaoNovoItem = document.querySelector('#botao-novo-item');
botaoNovoItem.addEventListener('click', criarNovaTarefa);

window.onload = carregarListaDeTarefas;