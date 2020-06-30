package org.xyz.mapstruct.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.factory.Mappers;

import java.util.List;


public interface CommonMapper<S, T> {

    @InheritConfiguration
    T sourceToTarget(S s);
    @InheritConfiguration
    S targetToSource(T t);
    @InheritConfiguration
    List<T> sourceToTarget(List<S> s);
    @InheritConfiguration
    List<S> targetToSource(List<T> t);


}
