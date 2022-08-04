package dados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zipador {

	public byte[] compactarBytes(String arquivoOrigem, String arquivoDestino) throws IOException {

		// LEITURA
		File arquivo = new File(arquivoOrigem);
		byte[] bytes = Files.readAllBytes(arquivo.toPath());

		// ESCRITA
		FileOutputStream writer = new FileOutputStream(arquivoDestino);

		char contador = 0;
		int byteAtual = 0;
		List<Byte> arquivoCompactado = new ArrayList<Byte>();

		for (int i = 0; i < bytes.length; i++) {

			// Se caracteres forem iguais, incremento contador
			if (bytes[i] == bytes[byteAtual]) {
				contador++;

				if (contador == ' ') {
					arquivoCompactado.add(arquivoCompactado.size(), ((byte) contador));
					arquivoCompactado.add(arquivoCompactado.size(), bytes[byteAtual]);
					contador = 0;
				}

			} else { // senao concateno os caracteres e zero contador
				arquivoCompactado.add(arquivoCompactado.size(), ((byte) contador));
				arquivoCompactado.add(arquivoCompactado.size(), bytes[byteAtual]);
				contador = 1;
			}
			byteAtual = i;
		}

		arquivoCompactado.add(arquivoCompactado.size(), ((byte) contador));
		arquivoCompactado.add(arquivoCompactado.size(), bytes[bytes.length - 1]);

		byte[] bytesCompactados = new byte[arquivoCompactado.size()];
		for (int x = 0; x < bytesCompactados.length; x++) {
			bytesCompactados[x] = arquivoCompactado.get(x);
		}

		writer.write(bytesCompactados);
		writer.close();
		return bytesCompactados;
	}

	public byte[] descompactarBytes(String arquivoOrigem, String arquivoDestino) throws IOException {

		// LEITURA
		File arquivo = new File(arquivoOrigem);
		byte[] bytes = Files.readAllBytes(arquivo.toPath());

		// ESCRITA
		FileOutputStream writer = new FileOutputStream(arquivoDestino);

		List<Byte> arquivoDescompactado = new ArrayList<Byte>();
		int contadorInt = 0;

		// para cada byte do arquivo compactado
		for (int i = 0; i < bytes.length - 1; i++) {

			contadorInt = bytes[i] & 0xFF;

			for (int repeticao = 0; repeticao < contadorInt; repeticao++) {
				arquivoDescompactado.add(arquivoDescompactado.size(), bytes[i + 1]);
			}

			i += 1;
		}

		byte[] bytesDescompactados = new byte[arquivoDescompactado.size()];

		for (int x = 0; x < bytesDescompactados.length; x++) {
			bytesDescompactados[x] = arquivoDescompactado.get(x);
		}

		writer.write(bytesDescompactados);
		writer.close();

		return bytesDescompactados;
	}

}
