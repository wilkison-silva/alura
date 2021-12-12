export const getListaClientesCadastrados = () => fetch('http://localhost:3000/profile')
  .then((response) => response.json())
  .catch((erro) => console.error(erro));

export const deletarCliente = () => {

};

export const cadastrarCliente = (nome, email) =>{

  fetch('http://localhost:3000/profile', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({
      nome: nome,
      email: email
    })
  })
  //.then((response) => response.body);

};