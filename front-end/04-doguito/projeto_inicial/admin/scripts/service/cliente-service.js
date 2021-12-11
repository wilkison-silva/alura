export const getListaClientesCadastrados = () => fetch('http://localhost:3000/profile')
  .then((response) => response.json())
  .catch((erro) => console.error(erro));

export const deletarCliente = () => {

};
