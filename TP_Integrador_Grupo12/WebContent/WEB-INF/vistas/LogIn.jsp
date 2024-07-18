<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Log In</title>
<style>
  body, html {
    height: 100%;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #BFDDFF; 
  }
  .LogInContenedor {
   margin-top: -200px;
    width: 400px;
    height: 300px;
    background-color: #52A2FC;
    display: flex;
    flex-direction: column;
    align-items: center; 
    justify-content: center; 
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.2);
  }
  .btnAcceder {
    min-width: 130px;
    height: 40px;
    color: #fff;
    padding: 5px 10px;
    font-weight: bold;
    cursor: pointer;
    transition: all 0.3s ease;
    outline: none;
    border-radius: 5px;
    border: none;
    background: #3a86ff;
    box-shadow: 0 5px #4433ff;
    margin-top: 20px; 
  }
  .btnAcceder:hover {
    box-shadow: 0 3px #4433ff;
    top: 1px;
  }
  .btnAcceder:active {
    box-shadow: 0 0 #4433ff;
    top: 5px;
  }
  
  
 
  
</style>
</head>
<body>
  <form action="redireccionar_LogIn.html" method="post">
    <div class="LogInContenedor">
      Ingrese Nombre Usuario: <input type="text" name="txtNombre" class="texto"><br>
      Ingrese Contraseña: <input type="password" name="txtContrasena" class="texto"><br>
      <input type="submit" value="Acceder" name="btnAcceder" class="btnAcceder">
      <div class="error-message"><br>
        <p style="color:red;">${mensajeError}</p>
      </div>
    </div>
  </form>
</body>
</html>
