package br.com.algaworks.brewer;

import com.algaworks.brewer.model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CervejasController extends WebMvcConfigurerAdapter {

    @RequestMapping("/cervejas/novo")
    public String novo() {
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("mensagem", "Erro no formulário");
            return "cerveja/CadastroCerveja";
        }

        // Salvar no banco de dados...
        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
        System.out.println(">>> sku: " + cerveja.getSku());
        return "redirect:/cervejas/novo";
    }

}