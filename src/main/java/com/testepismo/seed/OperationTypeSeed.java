package com.testepismo.seed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.testepismo.model.OperationType;
import com.testepismo.repository.OperationTypeRepository;

@Component
public class OperationTypeSeed implements CommandLineRunner {
    @Autowired
    private OperationTypeRepository operationTypeRepository;


    @Override
    public void run(String... args) throws Exception {
        var operationsTypes = new ArrayList<OperationType>();

        operationsTypes.add(new OperationType(Long.valueOf(1), "COMPRA A VISTA"));
        operationsTypes.add(new OperationType(Long.valueOf(2), "COMPRA PARCELADA"));
        operationsTypes.add(new OperationType(Long.valueOf(3), "SAQUE"));
        operationsTypes.add(new OperationType(Long.valueOf(4), "PAGAMENTO"));

        var operationsTypesId = operationsTypes.stream().map(OperationType::getOperationType_id).collect(Collectors.toList());
        var exists = operationTypeRepository.findAllById(operationsTypesId);

        if (exists instanceof Collection) {
            var size = ((Collection<?>) exists).size();
            
            if (size <= 0) {
                operationTypeRepository.saveAll(operationsTypes);
            }
        }
    }
    
}
