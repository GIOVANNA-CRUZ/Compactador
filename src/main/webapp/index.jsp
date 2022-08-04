<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Compactador</title>
    <meta charset="utf-8">
    <link rel = "stylesheet" href = "style.css">
  </head>
  <body>
   
   <form method = "POST" action = "respostaCompactador.jsp" class = "formulario">
   <h2 id = "compactador">Compactador</h2>
   <input type = "text" name = "arquivoOrigem" placeholder = "Insira aqui o arquivo de origem" class = "input">
   <input type = "text" name = "arquivoDestino" placeholder = "Insira aqui o arquivo de destino"  class = "input">
   
   <div id = "opcao">
   <label>Escolha a opção 1 para compactar e a opção 2 para descompactar</label>
   <select name="decisao">
   		<option value="1">1</option>
  		<option value="2" selected>2</option>
  </select>
  </div>
   <input type = "submit" value = "Enviar" id = "enviar">
   
   </form>
  </body>
</html>