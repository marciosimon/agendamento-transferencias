package br.com.msf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.msf.model.Conta;
import br.com.msf.service.ClienteService;
import br.com.msf.service.ContaService;
import br.com.msf.validator.ContaValidator;

@Controller
@RequestMapping("/agendamento")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@Autowired
	ClienteService clienteService;

	@Autowired
	ContaValidator contaValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(contaValidator);
	}
	
	@RequestMapping("/contas")
	public ModelAndView lista(ModelMap model) {
		List<Conta> contas = contaService.listar();
		model.addAttribute("contas",contas);
		return new ModelAndView("/conta/lista", model);
	}

	@RequestMapping("/contas/edit/{id}")
	public ModelAndView loadForm(@PathVariable(name="id") Long id, ModelMap model) {
		Conta conta;
		if (id == null) {
			conta = new Conta();
		} else {
			conta = contaService.pesquisaPorId(id);
		}
		model.addAttribute("conta",conta);
		model.addAttribute("clientes", clienteService.listar());

		return new ModelAndView("/conta/form", model);
	}

	@RequestMapping("/contas/new/")
	public ModelAndView loadForm(ModelMap model) {
		Conta conta = new Conta();
		model.addAttribute("conta",conta);
		model.addAttribute("clientes", clienteService.listar());

		return new ModelAndView("/conta/form", model);
	}

	@RequestMapping(method = RequestMethod.POST, path="/contas/save")
	public ModelAndView save(@Valid Conta conta, BindingResult bindingResult, 
            RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()){
			ModelMap model = new ModelMap();
			model.addAttribute("conta", conta);
			model.addAttribute("clientes", clienteService.listar());

			return new ModelAndView("/conta/form", model);
		} else {
			contaService.salvar(conta);
			return new ModelAndView("redirect:/agendamento/contas/");
		}
	}

	@RequestMapping("/contas/delete/{id}")
	public ModelAndView delete(@PathVariable(name="id") Long id, ModelMap model) {
		Conta conta = contaService.pesquisaPorId(id);

		if (conta != null) {
			contaService.deletar(conta);			
		}

		return new ModelAndView("redirect:/agendamento/contas/", model);
	}
}