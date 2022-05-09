package vn.techmaster.job_hunt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.techmaster.job_hunt.model.City;

public record SearchRequest(
    String keywords,
    City city) {

}
