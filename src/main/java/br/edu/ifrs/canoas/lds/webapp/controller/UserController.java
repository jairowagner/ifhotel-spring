package br.edu.ifrs.canoas.lds.webapp.controller;

import br.edu.ifrs.canoas.lds.webapp.config.Messages;
import br.edu.ifrs.canoas.lds.webapp.config.auth.UserImpl;
import br.edu.ifrs.canoas.lds.webapp.domain.Usuario;
import br.edu.ifrs.canoas.lds.webapp.service.UsuarioService;
import lombok.AllArgsConstructor;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private final Messages messages;
	private final UsuarioService userService;

	@GetMapping("/profile")
    public ModelAndView viewProfile(@AuthenticationPrincipal UserImpl activeUser){
        ModelAndView mav = new ModelAndView("/user/profile");
        mav.addObject("user", userService.getOne(activeUser.getUser()));
        return mav;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Usuario user, BindingResult bindingResult,
            RedirectAttributes redirectAttr, Locale locale){

    	if (bindingResult.hasErrors()) {
            return new ModelAndView("/user/profile");
        }

    	ModelAndView mav = new ModelAndView("redirect:/user/profile");
        mav.addObject("user", userService.save(user));
        redirectAttr.addFlashAttribute("message", messages.get("field.saved"));

        return mav;
    }
}
