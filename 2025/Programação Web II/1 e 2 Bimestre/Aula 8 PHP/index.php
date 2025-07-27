<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </head>
  <body>
    <div class="container">
                <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
                <div class="container-fluid">
                  <a class="navbar-brand" href="#">SISTEMA WEB</a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarColor02">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                      <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Cadastrar</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">Consultar</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </nav>
                    <div class="mb-3">
                        <br>
                        <p class="fs-5">Cadastrar - Agendamento de Potenciais Clientes</p>
                        <label for="formGroupExampleInput" class="form-label">Sistema Utilizado para agendamento de servições</label>
                        <br>
                        <form method="post" action="controller/ControllerCadastro.php" id="form" name="form">
                        <label for="formGroupExampleInput" class="form-label">Nome:</label>
                        <input type="name" name="txtNome" class="form-control" id="formGroupExampleInput">
                      </div>
                      <div class="mb-3">
                        <label for="formGroupExampleInput2" class="form-label">Telefone:</label>
                        <input type="number" name="txtTelefone" placeholder="(00)-0000-0000" class="form-control" id="formGroupExampleInput2">
                      </div>
                      <div class="mb-3">
                        <label for="formGroupExampleInput" class="form-label">Origem:</label>
                        <select name="txtOrigem" class="form-select form-select-sm" aria-label="Small select example">
                            <option value="1">Celular</option>
                            <option value="2">WhatsApp</option>
                            <option value="3">Telefone Fixo</option>
                          </select>
                      </div>
                      <div class="mb-3">
                        <label for="formGroupExampleInput" class="form-label">Data de Contato:</label>
                        <input type="date" name="txtDataContato" class="form-control" id="formGroupExampleInput">
                      </div>
                      <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">Observação:</label>
                        <textarea class="form-control" name="txtObservacao" id="observacao" rows="3"></textarea>
                      </div>
                               
            </div>
            <div class="container text-left">
                    <div class="row">
                        <div class="col">
                            <p></p>
                            <button type="submit" id="btnInserir" class="btn btn-primary">Cadastrar</button></form>  
                        </div>
                    </div>
                </div>
  </body>
</html>