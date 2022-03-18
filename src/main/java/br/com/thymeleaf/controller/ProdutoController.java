package br.com.thymeleaf.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.thymeleaf.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private static final List<Produto> DADOS = new ArrayList<>(Arrays.asList(
			new Produto(1L, "Smartphone Samsung Galaxy On 7", new BigDecimal(849.99)),
			new Produto(2L, "Geladeira Consul", new BigDecimal(2268.99)),
			new Produto(3L, "Purificador Midea", new BigDecimal(550.45)),
			new Produto(4L, "Smart Watch", new BigDecimal(299.99)),
			new Produto(5L, "Smart TV", new BigDecimal(1299.19)),
			new Produto(6L, "Kit Pneu Aro 15", new BigDecimal(759.00))
	));
	
	
	@GetMapping
	public ModelAndView lista(Produto produto) {
		ModelAndView mv = new ModelAndView("/produto-lista.html");
		
		List<Produto> lista = DADOS.stream().filter(p -> null == produto.getId() || produto.getId().equals(p.getId()))
				.filter(p -> StringUtils.isEmpty(produto.getDescricao()) || p.getDescricao().startsWith(produto.getDescricao()))
				.collect(Collectors.toList());
		
		return mv.addObject("produtos", lista);
	}
}
