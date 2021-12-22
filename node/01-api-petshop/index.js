const customExpress = require('./config/customExpress');
const conexao = require('./infraestrutura/conexao');

conexao.connect((erro) => {
  if (erro) {
    console.log(erro);
  } else {
    console.log('conectado ao banco de dados com sucesso');
    const app = customExpress();
    app.listen(3000, () => console.log('listening on localhost:3000'));
  }
});
