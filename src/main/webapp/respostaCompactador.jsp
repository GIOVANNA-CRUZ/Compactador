<%@page import="dados.Zipador"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Resposta Compactador</title>
<meta charset="utf-8">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%

		String arquivoOrigem = request.getParameter("arquivoOrigem");
		String arquivoDestino = request.getParameter("arquivoDestino");
		String decisao = request.getParameter("decisao");
		byte[] bytesProcessados;

		Zipador app = new Zipador();

		boolean compactar = false;

		switch(decisao)
		{
		case "1":
			compactar = true;
			break;
		case "2":
			compactar = false;
			break;
		default:
			System.out.println("Digite uma opção valida.");
		}

		if(compactar)
		{
			bytesProcessados = app.compactarBytes(arquivoOrigem, arquivoDestino);
	%>

	<p>Arquivo Compactado com sucesso!</p>

	<%
	}else{
	bytesProcessados = app.descompactarBytes(arquivoOrigem, arquivoDestino);
	%>

	<p>Arquivo Descompactado com sucesso!</p>
	
	<%
	}
	%>




</body>


</html>