package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Informe o caminho do arquivo: ");
		String caminho = sc.next();

		List<Produto> list = new ArrayList<>();

		try (BufferedReader bf = new BufferedReader(new FileReader(caminho))) {

			String linha = bf.readLine();
			while (linha != null) {
				String[] campos = linha.split(",");
				String descricao = campos[0];
				Double preco = Double.parseDouble(campos[1]);
				list.add(new Produto(descricao, preco));
				linha = bf.readLine();

			}

			double media = list.stream().map(p -> p.getPreco()).reduce(0.0, (x, y) -> x + y) / list.size();
			System.out.println("Preço Médio: " + media);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		sc.close();

	}

}
