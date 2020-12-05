package br.edu.usj.ads.lpii.controlefrota;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrotaController {
    
    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    MotoristaRepository motoristaRepository;

    @GetMapping(value="/")
    public ModelAndView getListaTodos() {
        List<Veiculo> lista = veiculoRepository.findAll();
        List<Motorista> lista2 = motoristaRepository.findAll();
      
        ModelAndView modelAndView = new ModelAndView("index");
        
        modelAndView.addObject("lista", lista);
        modelAndView.addObject("lista2", lista2);
        return modelAndView;
    }

    @GetMapping(value="/registro/{id}")
    public ModelAndView getRegistroVeiculo(@PathVariable Long id) {
        
        Veiculo veiculo = veiculoRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("registro");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }

    @GetMapping(value="/cadastro")
    public ModelAndView getinsert() {
        Veiculo veiculo = new Veiculo();
        
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }


    @PostMapping(value="/adicionar")
    public String postAdicionString(Veiculo veiculo) {
        veiculoRepository.save(veiculo); 
        return "redirect:/";
    }
    
    
    @GetMapping(value="/excluir/{id}")
    public String getExcluirVeiculo(@PathVariable Long id) {
       veiculoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditarVeiculo(@PathVariable Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).get();

        
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }
   
    @GetMapping(value="/consultar")
    public String getConsultar() {
        return "consultar";
    }
    
    @PostMapping(value="/consultar")
    public ModelAndView postConsultar(@RequestParam String placa) {
    
        List<Veiculo> lista = veiculoRepository.findByPlacaContainingIgnoreCaseOrderByPlaca(placa);

        
        ModelAndView modelAndView = new ModelAndView("consultar");
        modelAndView.addObject("placa", placa);
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }


    @GetMapping(value="/cadastrosegundo")
    public ModelAndView getinsertsegundo() {
        Motorista motorista = new Motorista();
        
        ModelAndView modelAndView2 = new ModelAndView("cadastrosegundo");
        modelAndView2.addObject("motorista", motorista);
        return modelAndView2;
    }

    @PostMapping(value="/adicionarsegundo")
    public String postAdicionaString(Motorista motorista) {

        

        motoristaRepository.save(motorista); 
        return "redirect:/";
    }

    @GetMapping(value="/consultarsegundo")
    public String getConsultarsegundo() {
        return "consultarsegundo";
    }
    
    @PostMapping(value="/consultarsegundo")
    public ModelAndView postConsultarsegundo(@RequestParam String cnh) {
    
        List<Motorista> lista = motoristaRepository.findAll();

        
        ModelAndView modelAndView2 = new ModelAndView("consultarsegundo");
        modelAndView2.addObject("cnh", cnh);
        modelAndView2.addObject("lista2", lista);
        return modelAndView2;

    }


    @GetMapping(value="/registrosegundo/{id}")
    public ModelAndView getRegistroMotorista(@PathVariable Long id) {
        
        Motorista motorista = motoristaRepository.findById(id).get();

        ModelAndView modelAndView2 = new ModelAndView("registrosegundo");
        modelAndView2.addObject("motorista", motorista);
        return modelAndView2;
    }


    @GetMapping(value="/excluirsegundo/{id}")
    public String getExcluirMotorista(@PathVariable Long id) {
       motoristaRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value="/editarsegundo/{id}")
    public ModelAndView getEditarMotorista(@PathVariable Long id) {
        Motorista motorista = motoristaRepository.findById(id).get();

        
        ModelAndView modelAndView2 = new ModelAndView("cadastrosegundo");
        modelAndView2.addObject("motorista", motorista);
        return modelAndView2;
    }

}


