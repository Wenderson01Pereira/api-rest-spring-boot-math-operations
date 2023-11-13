package br.com.erudio.Controller;

import br.com.erudio.Domain.Model.Enums.MathEnum;
import br.com.erudio.Services.Services.MathOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    @Autowired
    MathOperationsService mathOperationsService;

    @GetMapping(value = "{numberOne}/{numberTwo}/{mathEnum}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo,
            @PathVariable(value = "mathEnum") MathEnum mathEnum
    ){
        return mathOperationsService.retrieveValueOperation(numberOne, numberTwo, mathEnum);
    }
}
