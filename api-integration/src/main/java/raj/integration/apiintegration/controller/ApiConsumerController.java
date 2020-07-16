package raj.integration.apiintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import raj.integration.apiintegration.dto.CountryResponseDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public List<String> test(){
        String url = "http://localhost:8991/countries";
        String [] objects = restTemplate.getForObject(url,String[].class);
        //List<String> list = Arrays.asList(objects);
        return  Arrays.asList(objects);
    }
    @GetMapping("/testing")
    public String testing(){
        return "success";
    }

    @GetMapping("/countries")
    public List<String> getCountries(){
        List<String> countriesList = new ArrayList<>();
        countriesList.add("india");
        countriesList.add("US");
        countriesList.add("UK");
        countriesList.add("AU");
        return countriesList; // never return list , compatibility issue will come in future if you add extra param
    }

    @GetMapping("v2/countries")
    public CountryResponseDTO getCountriesV2(){
        List<String> countriesList = new ArrayList<>();
        countriesList.add("india");
        countriesList.add("US");
        countriesList.add("UK");
        countriesList.add("AU");
        CountryResponseDTO countryResponseDTO = new CountryResponseDTO();
        countryResponseDTO.setCountryList(countriesList);
        return countryResponseDTO;
    }
}
