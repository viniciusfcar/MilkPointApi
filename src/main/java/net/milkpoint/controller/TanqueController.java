package net.milkpoint.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.milkpoint.model.Tanque;
import net.milkpoint.service.ResponsavelService;
import net.milkpoint.service.TanqueService;

@Controller
@RequestMapping("/tanque")
public class TanqueController {

	@Autowired
	private TanqueService tanqueService;

	@Autowired
	private ResponsavelService responsavelService;

	@GetMapping("/add")
	public ModelAndView add(Tanque tanque) {

		ModelAndView mv = new ModelAndView("tanque/form");
		mv.addObject("responsaveis", responsavelService.findAll());
		mv.addObject("tanque", tanque);

		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Tanque tanque, BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return add(tanque);
		}
		tanque.setQtdRestante(tanque.getCapacidade() - tanque.getQtdAtual());
		tanqueService.save(tanque);

		return findAll();
	}

	@GetMapping("/listar")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("tanque/listar");
		mv.addObject("tanques", tanqueService.findAll());

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(tanqueService.findOne(id));
	}

	@GetMapping("/details/{id}")
	public ModelAndView details(@PathVariable("id") Long id) {

		ModelAndView mv = new ModelAndView("Tanque/detalhes");
		mv.addObject("tanque", tanqueService.findOne(id));
		return mv;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		tanqueService.delete(id);
		return findAll();
	}

}
