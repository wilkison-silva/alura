module.exports = (app) => {
  app.get('/atendimentos', (req, res) => {
    res.send('rodando atendimentos..........................');
  });

  app.post('/atendimentos', (req, res) => {
    res.send(req.body.nome);
  });
};
