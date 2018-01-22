package br.com.msf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.msf.model.Cliente;
import br.com.msf.service.ClienteService;
import br.com.msf.validator.ClienteValidator;

@Controller
@RequestMapping("/agendamento")
public class ClienteController extends WebMvcConfigurerAdapter {

	@Autowired
	ClienteService clienteService;

	@Autowired
	ClienteValidator clienteValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(clienteValidator);
	}

	@RequestMapping("/clientes")
	public ModelAndView lista(ModelMap model) {
		List<Cliente> clientes = clienteService.listar();
		model.addAttribute("clientes", clientes);
		return new ModelAndView("/cliente/lista", model);
	}

	@RequestMapping("/clientes/edit/{id}")
	public ModelAndView loadForm(@PathVariable(name = "id") Long id, ModelMap model) {
		Cliente cliente;
		if (id == null) {
			cliente = new Cliente();
		} else {
			cliente = clienteService.pesquisaPorId(id);
		}
		model.addAttribute("cliente", cliente);
		return new ModelAndView("/cliente/form", model);
	}

	@RequestMapping("/clientes/new/")
	public ModelAndView loadForm(Cliente cliente) {
		ModelAndView modelAndView = new ModelAndView("/cliente/form");
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/clientes/save")
	public ModelAndView save(@Validated Cliente cliente, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()){
			return loadForm(cliente);
		} else {
			clienteService.salvar(cliente);
			ModelAndView modelAndView = new ModelAndView("redirect:/agendamento/clientes/");
			return modelAndView;
		}
	}

	@RequestMapping("/clientes/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, ModelMap model) {
		Cliente cliente = clienteService.pesquisaPorId(id);

		if (cliente != null) {
			clienteService.deletar(cliente);
		}

		return new ModelAndView("redirect:/agendamento/clientes/", model);
	}
}