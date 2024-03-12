package br.edu.fatecsjc.lgnspringapi.converter;

import java.util.List;

public interface Converter<E, D> {
    E convertToEntity(D dto);
    E convertToEntity(D dto, E entity);
    D convertToDto(E entity);
    List<E> convertToEntity(List<D> dtos);
    List<D> convertToDto(List<E> entities);
}
