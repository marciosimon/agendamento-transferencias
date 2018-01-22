package br.com.msf.controller;

import java.time.LocalDate;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.msf.exception.CalculoTaxaAgendamentoException;
import br.com.msf.model.Agendamento;
import br.com.msf.service.AgendamentoService;
import br.com.msf.service.ContaService;
import br.com.msf.validator.AgendamentoValidator;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	AgendamentoService agendamentoService;

	@Autowired
	ContaService contaService;
	
	@Autowired
	AgendamentoValidator agendamentoValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(agendamentoValidator);
	}
	
	@RequestMapping("/agendamentos")
	public ModelAndView lista(ModelMap model) {
		List<Agendamento> agendamentos = agendamentoService.listar();
		model.addAttribute("agendamentos",agendamentos);
		return new ModelAndView("/agendamento/lista", model);
	}

	@RequestMapping("/agendamentos/edit/{id}")
	public ModelAndView loadForm(@PathVariable(name="id") Long id, ModelMap model) {
		Agendamento agendamento;
		if (id == null) {
			agendamento = new Agendamento();
			agendamento.setDataAgendamento(LocalDate.now());
		} else {
			agendamento = agendamentoService.pesquisaPorId(id);
		}
		model.addAttribute("agendamento",agendamento);
		model.addAttribute("contas", contaService.listar());
		return new ModelAndView("/agendamento/form", model);
	}

	@RequestMapping("/agendamentos/new/")
	public ModelAndView loadForm(ModelMap model) {
		Agendamento agendamento = new Agendamento();
		agendamento.setDataAgendamento(LocalDate.now());
		model.addAttribute("agendamento",agendamento);
		model.addAttribute("contas", contaService.listar());
		return new ModelAndView("/agendamento/form", model);
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/agendamentos/save")
	public ModelAndView save(@Validated Agendamento agendamento, BindingResult bindingResult, 
            RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()){
			ModelMap model = new ModelMap();
			model.addAttribute("agendamento",agendamento);
			model.addAttribute("contas", contaService.listar());

			return new ModelAndView("/agendamento/form", model);
		} else {
			try {
				agendamentoService.salvar(agendamento);
			} catch (CalculoTaxaAgendamentoException e) {
				bindingResult.reject("error", e.getMessage());

				ModelMap model = new ModelMap();
				model.addAttribute("agendamento",agendamento);
				model.addAttribute("contas", contaService.listar());
				model.addAttribute("error", e.getMessage());

				return new ModelAndView("/agendamento/form", model);

			}
			return new ModelAndView("redirect:/agendamento/agendamentos/");
		}		
	}

	@RequestMapping("/agendamentos/delete/{id}")
	public ModelAndView delete(@PathVariable(name="id") Long id, ModelMap model) {
		Agendamento agendamento = agendamentoService.pesquisaPorId(id);

		if (agendamento != null) {
			agendamentoService.deletar(agendamento);			
		}
		return new ModelAndView("redirect:/agendamento/agendamentos/", model);
	}
}