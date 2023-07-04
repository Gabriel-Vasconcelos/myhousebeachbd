<%-- 
    Document   : index
    Created on : 4 de jul. de 2023, 11:43:37
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>My House Beach</title>
    </head>
    <body>
            <nav class="navbar bg-body-tertiary">
            <div class="container-fluid container">
              <a class="navbar-brand" href="./index.jsp">
                MYHOUSEBEACH
              </a>
               
                <div>
                    
                </div>
                <div class="d-flex">
                    <a class="btn btn-outline-success me-3" href="./login-cliente.jsp">Logar</a>
                    <a class="btn btn-outline-secondary ">Cadastrar</a>
                </div>

            </div>
          </nav>
        
        <div class="container">
            <form class="mt-4">
                <div class=" mb-3">
                  <label for="exampleInputEmail1" class="form-label">Nome</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                
                <div class=" mb-3">
                  <label for="exampleInputEmail1" class="form-label">Email</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                
                <div class=" mb-3">
                  <label for="exampleInputEmail1" class="form-label">CPF</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                
                <div class=" mb-3">
                  <label for="exampleInputEmail1" class="form-label">Gênero</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  
                </div>
                
                <div class=" mb-3">
                  <label for="exampleInputEmail1" class="form-label">Rua</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                
                <div class="mb-3">
                  <label for="endereco-numero" class="form-label">Número</label>
                  <input type="number" class="form-control" id="endereco-numero" aria-describedby="emailHelp">  
                </div>
                
                <div class="mb-3">
                  <label for="endereco-numero" class="form-label">Complemento</label>
                  <input type="text" class="form-control" id="endereco-numero" aria-describedby="emailHelp">  
                </div>
                
                <div class="mb-3">
                  <label for="endereco-numero" class="form-label">Cidade</label>
                  <input type="text" class="form-control" id="endereco-numero" aria-describedby="emailHelp">  
                </div>
                
                <div class="mb-3">
                  <label for="endereco-numero" class="form-label">Estado</label>
                  <input type="text" class="form-control" id="endereco-numero" aria-describedby="emailHelp">  
                </div>
                
                <div class="mb-3">
                  <label for="endereco-numero" class="form-label">CEP</label>
                  <input type="number" class="form-control" id="endereco-numero" aria-describedby="emailHelp">  
                </div>
                
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Login</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Senha</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                
                
                <button type="submit" class="btn btn-primary mb-4">Enviar</button>
             </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

    </body>
</html>
