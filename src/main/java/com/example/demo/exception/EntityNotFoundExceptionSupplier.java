package com.example.demo.exception;

import org.apache.commons.text.CaseUtils;

import javax.persistence.EntityNotFoundException;
import java.util.function.Supplier;

public class EntityNotFoundExceptionSupplier implements Supplier<EntityNotFoundException> {
    private final String entityName;
    private String message = null;

    public EntityNotFoundExceptionSupplier(String entityName) {
        this.entityName = CaseUtils.toCamelCase(entityName, true, ' ');
    }

    /**
     * Return the exception handler with the message updated based on the given ID.
     *
     * @param id The ID to use in the message.
     * @return Object with updated message.
     */
    public EntityNotFoundExceptionSupplier setId(Long id) {
        this.message = String.format("%s with ID %d not found.", this.entityName, id);
        return this;
    }

    @Override
    public EntityNotFoundException get() {
        // Set message back to null to clean the state of the object once an exception is generated.
        String message = this.message;
        this.message = null;
        return new EntityNotFoundException(message);
    }
}
