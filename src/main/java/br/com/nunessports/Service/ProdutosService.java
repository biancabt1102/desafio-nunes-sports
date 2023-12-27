package br.com.nunessports.Service;

import br.com.nunessports.Models.Produtos;
import br.com.nunessports.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {
    @Autowired
    ProdutosRepository repository;

    public Produtos create(Produtos produtos){
        return repository.save(produtos);
    }

    public List<Produtos> findAllProdutos(){
        return repository.findAll();
    }

    public void deleteProduto(Long id){
        repository.deleteById(id);
    }

    public Optional<Produtos> findByProduto(Long id){
        return repository.findById(id);
    }

//    public boolean updateProduto(Long id, Produtos produto){
//        Optional<Produtos> existeProduto = repository.findById(id);
//
//        if(existeProduto.isPresent()){
//            Produtos novoProduto = existeProduto.get();
//
//            if (produto.getNomeProduto() != null && !produto.getNomeProduto().isEmpty()) {
//                novoProduto.setNomeProduto(produto.getNomeProduto());
//            }
//
//            if (produto.getPrecoProduto() >= 0) {
//                novoProduto.setPrecoProduto(produto.getPrecoProduto());
//            }
//
//            if (produto.getDescricaoProduto() != null && !produto.getDescricaoProduto().isEmpty()) {
//                novoProduto.setDescricaoProduto(produto.getDescricaoProduto());
//            }
//
//            repository.save(novoProduto);
//            return true;
//        }
//        return false;
//    }
    public boolean updateProduto(Long id, Produtos produto){
        Optional<Produtos> existeProduto = repository.findById(id);

        if(existeProduto.isPresent()){
            Produtos novoProduto = existeProduto.get();

            if (produto.getNomeProduto() != null && !produto.getNomeProduto().isEmpty()) {
                novoProduto.setNomeProduto(produto.getNomeProduto());
            }

            if (produto.getPrecoProduto() >= 0) {
                novoProduto.setPrecoProduto(produto.getPrecoProduto());
            }

            if (produto.getDescricaoProduto() != null && !produto.getDescricaoProduto().isEmpty()) {
                novoProduto.setDescricaoProduto(produto.getDescricaoProduto());
            }

            repository.save(novoProduto);
            return true;
        }
        return false;
    }

}
