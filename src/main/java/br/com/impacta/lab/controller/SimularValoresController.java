package br.com.impacta.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simular")
public class SimularValoresController {

	@GetMapping("/valorFuturo")
	public ResponseEntity<String> simularValores(@RequestParam(name="codigoProduto") int codigoProduto,
			@RequestParam(name="ano") int ano) {
		/*
		 * Elabore um algoritmo para calcular o valor futuro de um produto com base em seu valor REAL
		 *  e o ano que desejado.
		 *  
		 *  A escolha do produto da-se através de seus códigos, como no exercicio anterior.
		 *  
		 *  considerando o ano atual 2021, para cada ano subsequente acrescente 5% ao valor do produto 
		 *  (não esqueça que o valor a ser considerado é sempre o do ano atual).
		 *  
		 *  Usar as estruturas de repetição.
		 *  
		 *  Tabela de produto
		 *  
		 *  CodigoProduto	descrição do Produto		Valor do Produto
		 * 	1				Camisa						70.00
		 * 	2				Shorts						57.50
		 * 	3				Meia						9.99
		 * 	4				Toca						35.00
		 * 	5				Luvas						19.50
		 * 
		 * -----------------------------------------------------------------
		 * 
		 * 
		 * 
		 * <descrição do produto> custará <valor final do produto> reais em <ano-recebido-como-parametro>
		 * 
		 * Ex.: Camisa custará 73.50 reais em 2022
		 * 
		 */
		
		
		return ResponseEntity.ok(getDescricaoProduto(codigoProduto) + " custará " + valorFuturo(ano, codigoProduto) 
									+ " reais em " + ano);
	}

	private Double valorFuturo(Integer ano, Integer codigoProduto){
		double result = getValorProduto(codigoProduto);
		for (int i = 2021; i < ano; i++){
			result = result * 1.05;
		}
		return Math.round(result * 100.0) /100.0;
	}

	private String getDescricaoProduto(Integer codigoProduto){
		if (codigoProduto == 1) return "Camisa";
		if (codigoProduto == 2) return "Shorts";
		if (codigoProduto == 3) return "Meia";	
		if (codigoProduto == 4) return "Toca";
		if (codigoProduto == 5) return "Luvas";
		return "###";
	}
	private Double getValorProduto(Integer codigoProduto){
		if (codigoProduto == 1) return 70.00;
		if (codigoProduto == 2) return 57.50;
		if (codigoProduto == 3) return 9.99;	
		if (codigoProduto == 4) return 35.00;
		if (codigoProduto == 5) return 19.50;
		return 0.00;
	}
	
}
