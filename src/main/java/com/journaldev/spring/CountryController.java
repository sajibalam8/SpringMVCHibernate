package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Country;
import com.journaldev.spring.service.CountryService;

@Controller
public class CountryController {
	
	private CountryService countryService;
	
	@Autowired(required=true)
	@Qualifier(value="countryService")
	public void setCountryService(CountryService cs){
		this.countryService = cs;
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public String getAllCountries (Model model) {
		model.addAttribute("country", new Country());
		model.addAttribute("listOfCountries", this.countryService.getAllCountries());
		return "country";
	}
	
	//For add and update person both
	@RequestMapping(value= "/country/add", method = RequestMethod.POST)
	public String addCountry(@ModelAttribute("country") Country c){
		
		if(c.getId() == 0){
			//new person, add it
			this.countryService.addCountry(c);
		}else{
			//existing person, call update
			this.countryService.updateCountry(c);
		}
		
		return "redirect:/countries";
		
	}
	
	@RequestMapping("/delete/{id}")
    public String deleteCountry(@PathVariable("id") int id){
		
        this.countryService.deleteCountry(id);
        return "redirect:/countries";
    }
 
    @RequestMapping("/edit/{id}")
    public String editCountry(@PathVariable("id") int id, Model model){
        model.addAttribute("country", this.countryService.getCountry(id));
        model.addAttribute("listOfCountries", this.countryService.getAllCountries());
        return "country";
    }
	
}
