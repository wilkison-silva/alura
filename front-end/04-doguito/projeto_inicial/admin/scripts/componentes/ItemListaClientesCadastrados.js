export default (nome, email) => {
  const novaLinha = document.createElement("tr");
  novaLinha.innerHTML = `<td class="td" data-td>${nome}</td>
                        <td>${email}</td>
                        <td>
                          <ul class="tabela__botoes-controle">
                            <li><a href="../telas/edita_cliente.html" class="botao-simples botao-simples--editar">Editar</a></li>
                            <li><button class="botao-simples botao-simples--excluir" type="button">Excluir</button></li>
                          </ul>
                        </td>`;


  return novaLinha;
};
