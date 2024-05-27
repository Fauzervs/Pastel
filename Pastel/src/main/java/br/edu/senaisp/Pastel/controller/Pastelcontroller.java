package br.edu.senaisp.Pastel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Pastel.model.Sabor;
import br.edu.senaisp.Pastel.repository.PastelRepository;

@RestController
@RequestMapping("/pastel")
public class Pastelcontroller {

	@Autowired
	PastelRepository repository;
	
	
	@GetMapping()
	public String ListaSabor() {
	    StringBuilder tmp = new StringBuilder();
	    
	    for(Sabor sabor : repository.lista()) {
	        tmp.append(sabor.getSabor()).append("<br>");
	    }
	    
	    return tmp.toString();
	}



	
	@GetMapping("/{id}")
	public String BuscaPorId(@PathVariable int id) {
	
		return repository.buscaPorId(id).getSabor();
}
	
	
	@PutMapping("/{id}")
    public String AlteraSabor(@RequestBody Sabor sabor, @PathVariable int id) {
        Sabor saborAtualizada = repository.altera(sabor, id);
        
        if (saborAtualizada != null) {
            return "Sabor atualizada com sucesso";
        } else {
            return "Não foi possível atualizar a sabor";
        }
        }
        
	
	
        
	@PostMapping()
	public String InsereSabor(@RequestBody Sabor sabor) {
	   int linhasAfetadas = repository.insere(sabor);
	    
	    if (linhasAfetadas > 0) {
	        return "Sabor inserida com sucesso";
	    } else {
	        return "Não foi possível inserir a Sabor";
	    }
	}


        // 
        @DeleteMapping("/{id}")
        public String ExcluiSabor(@PathVariable int id) {
            boolean excluiu = repository.exclui(id);
            
            if (excluiu) {
                return "Sabor excluída com sucesso";
            } else {
                return "Não foi possível excluir a sabor";
            }
    }
	

}

