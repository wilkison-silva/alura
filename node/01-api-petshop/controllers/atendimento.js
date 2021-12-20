module.exports = (app) => {
  app.get('/atendimentos', (req, res) => {
    res.send('rodando atendimentos');
  });
};
