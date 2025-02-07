package sintesis.text2me.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sintesis.text2me.models.AppUser;
import sintesis.text2me.models.RegisterDto;
import sintesis.text2me.repositories.AppUserRepository;

@Controller
public class AccountController {

	@Autowired
	private AppUserRepository repo;



	@GetMapping("/profile")
	public String profile(Authentication auth, Model model) {
		AppUser user = repo.findByEmail(auth.getName());
		model.addAttribute("appUser", user);

		return "profile";
	}


	@GetMapping("/login")
	public String login() {
		return "login";
	}


	@GetMapping("/register")
	public String register(Model model) {
		RegisterDto registerDto = new RegisterDto();
		model.addAttribute(registerDto);
		model.addAttribute("success", false);
		return "register";
	}


	@PostMapping("/register")
	public String register(
			Model model,
			@Valid @ModelAttribute RegisterDto registerDto,
            BindingResult result
			) {

		if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
    		result.addError(
    				new FieldError("registerDto", "confirmPassword"
    						, "Els passwords han de coincidir!")
    		);
    	}


		AppUser appUser = repo.findByEmail(registerDto.getEmail());
		if (appUser != null) {
			result.addError(
    				new FieldError("registerDto", "email"
    						, "Aquest email ja esta registrat!")
    		);
		}


		if (result.hasErrors()) {
    		return "register";
    	}


		try {
			var bCryptEncoder = new BCryptPasswordEncoder();


			AppUser newUser = new AppUser();
			newUser.setFirstName(registerDto.getFirstName());
			newUser.setLastName(registerDto.getLastName());
			newUser.setEmail(registerDto.getEmail());
			newUser.setPhone(registerDto.getPhone());
			newUser.setAddress(registerDto.getAddress());
			newUser.setRole("user");
			newUser.setCreatedAt(new Date());
			newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));

			repo.save(newUser);


			model.addAttribute("registerDto", new RegisterDto());
			model.addAttribute("success", true);
		}
		catch(Exception ex) {
			result.addError(
    				new FieldError("registerDto", "firstName"
    						, ex.getMessage())
    		);
		}

		return "register";
	}
}

































