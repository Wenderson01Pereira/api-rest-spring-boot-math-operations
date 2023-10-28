package br.com.erudio.Controller;

import br.com.erudio.Domain.Model.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
    method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please, set a numeric a value.");
        }
        return ConvertToDouble(numberOne) + ConvertToDouble(numberTwo);
    }

    private Double ConvertToDouble(String number) {
        if(number == null) return 0D;

        String replacedNumber = number.replaceAll(",", ".");

        return isNumeric(number)
            ? Double.parseDouble(replacedNumber) : 0D;
    }

    private boolean isNumeric(String number) {
        if(number == null) return false;
        String replacedNumber = number.replaceAll(",", ".");
        return replacedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
