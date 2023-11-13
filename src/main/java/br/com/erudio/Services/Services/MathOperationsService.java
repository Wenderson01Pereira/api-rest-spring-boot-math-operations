package br.com.erudio.Services.Services;

import br.com.erudio.Domain.Model.Enums.MathEnum;
import br.com.erudio.Domain.Model.Exception.UnsupportedMathOperationException;
import br.com.erudio.Services.Interfaces.MathOperationsInterface;
import org.springframework.stereotype.Service;

@Service
public class MathOperationsService implements MathOperationsInterface {
    @Override
    public Double retrieveValueOperation(
            String numberOne, String numberTwo, MathEnum enumOps
    ) {
        try{
            return switch (enumOps){
                case SUM -> convertToDouble(numberOne) + convertToDouble(numberOne);
                case SUBTRACTION -> convertToDouble(numberOne) - convertToDouble(numberOne);
                case MULTIPLICATION -> convertToDouble(numberOne) * convertToDouble(numberOne);
                case DIVISION -> convertToDouble(numberOne) / convertToDouble(numberOne);
            };
        }catch (Exception e){
            throw new UnsupportedMathOperationException(e.getMessage());
        }
    }

    private Double convertToDouble(String number) {
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
