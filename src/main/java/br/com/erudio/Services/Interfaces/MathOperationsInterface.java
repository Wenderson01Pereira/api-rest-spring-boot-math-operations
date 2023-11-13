package br.com.erudio.Services.Interfaces;

import br.com.erudio.Domain.Model.Enums.MathEnum;

public interface MathOperationsInterface {
    Double retrieveValueOperation(String numberOne, String numberTwo, MathEnum enumOps);
}
