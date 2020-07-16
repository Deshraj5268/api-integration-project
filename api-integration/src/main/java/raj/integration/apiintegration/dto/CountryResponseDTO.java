package raj.integration.apiintegration.dto;

import java.util.List;

public class CountryResponseDTO {

    private List<String> countryList;

    //must if many constructor
    public CountryResponseDTO() {
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<String> countryList) {
        this.countryList = countryList;
    }
}
