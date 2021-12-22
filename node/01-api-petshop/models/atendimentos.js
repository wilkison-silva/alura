const conexao = require('../infraestrutura/conexao');

// eslint-disable-next-line padded-blocks
class Atendimento {
  adiciona(atendimento, res) {
    const sql = 'INSERT INTO Atendimentos SET ?';

    conexao.query(sql, atendimento, (erro, resultado) => {
      if (erro) {
        const messagemErro = {
          mensagem: erro.sqlMessage,
        };
        res.status(400).json(messagemErro);
      } else {
        res.status(201).json({ ...atendimento, id: resultado.insertId });
      }
    });
  }
}

module.exports = new Atendimento;
