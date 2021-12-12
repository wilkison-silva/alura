export const getListaClientesCadastrados = () => fetch('http://localhost:3000/profile')
  .then((response) => response.json())
  .catch((erro) => console.error(erro));

export const deletarCliente = (id) => {
  fetch(`http://localhost:3000/profile/${id}`, {
    method: 'DELETE'
  })
};

export const cadastrarCliente = (nome, email) =>{

  return fetch('http://localhost:3000/profile', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ nome, email }),
  });
};

export const getClienteCadastrado = async (id) => {
  const response = await fetch(`http://localhost:3000/profile/${id}`);
  return await response.json();
}

export const atualizarCliente = async (id, nome, email) => {
  fetch(`http://localhost:3000/profile/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ nome, email }),
  });
}