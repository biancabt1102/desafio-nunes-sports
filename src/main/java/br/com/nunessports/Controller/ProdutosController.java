package br.com.nunessports.Controller;

import br.com.nunessports.Models.Produtos;
import br.com.nunessports.Repository.ProdutosRepository;
import br.com.nunessports.Service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nunes-sports/produtos")
public class ProdutosController {
    @Autowired
    ProdutosRepository repository;

    @Autowired
    ProdutosService service;

    @GetMapping
    public String home() {
        return "produtos/index";
    }

    // Cria um produto (página de formulário)
    @GetMapping("/novo")
    public String createForm(Model model) {
        model.addAttribute("produto", new Produtos());
        return "produtos/formulario";
    }

    // Cria um produto (processamento do formulário)
    @PostMapping
    public String create(@RequestBody @ModelAttribute Produtos produto) {
        service.create(produto);
        return "redirect:/nunes-sports/produtos";
    }

    @GetMapping("/detalhes")
    public String list(Model model){
        model.addAttribute("produtos", service.findAllProdutos());
        return "produtos/detalhes";
    }

    // Retorna um produto pelo id
    @GetMapping("/detalhes/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Optional<Produtos> produto = repository.findById(id);

        produto.ifPresent(p -> model.addAttribute("produto", p));

        return produto.map(p -> "produtos/detalhes").orElse("redirect:/nunes-sports/produtos");
    }

    // Edita um produto (página de formulário)
    @GetMapping("/{id}/editar")
    public String updateForm(@PathVariable Long id, Model model) {

        Optional<Produtos> produto = service.findByProduto(id);
        produto.ifPresent(p -> model.addAttribute("produto", p));

        return produto.map(p -> "produtos/formulario").orElse("redirect:/nunes-sports/produtos");
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Produtos produto, Model model) {

        boolean sucessoAtualizacao = service.updateProduto(id, produto);

        if (sucessoAtualizacao) {
            model.addAttribute("produtos", service.findByProduto(id));
            return "redirect:/nunes-sports/produtos/detalhes";
        } else {
            return "redirect:/nunes-sports/produtos";
        }
    }

    // Deleta um produto
    @GetMapping("/{id}/excluir")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/nunes-sports/produtos/detalhes";
    }

}
