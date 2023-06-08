package com.example.movielibrary.classes.mappers;

import com.example.movielibrary.dtos.BaseDto;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ListEntityToDtoMapper {
    public static <E, D extends BaseDto> List<D> entityListToDtoList(List<E> entities, Class<E> entityClass, Class<D> dtoClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<D> dtos = new ArrayList<>();

        for (E entity : entities) {
            D dto = dtoClass.getDeclaredConstructor(entityClass).newInstance(entity);
            dtos.add(dto);
        }

        return dtos;
    }
}
