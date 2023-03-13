package com.example.movielibrary.dtos;

import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BaseDto {
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BaseDto(long id) {
        this.id = id;
    }

    public void copyProperties(Object src, Object dst, String... properties) throws Exception {
        Method[] srcMethods = src.getClass().getMethods();
        Method[] dstMethods = dst.getClass().getMethods();

        for (String property : properties) {
            List<String> srcGetters = new ArrayList<>();
            for (String prefix: new String[]{"get", "is", "has"}) {
                srcGetters.add(prefix + StringUtils.capitalize(property));
            }
            
            List<String> dstSetters = new ArrayList<>();
            for (String prefix: new String[]{"set"}) {
                dstSetters.add(prefix + StringUtils.capitalize(property));
            }
            
            Optional<Method> srcGetter = Arrays.stream(srcMethods).filter(method -> srcGetters.contains(method.getName())).findFirst();
            Optional<Method> dstSetter = Arrays.stream(dstMethods).filter(method -> dstSetters.contains(method.getName())).findFirst();

            if (srcGetter.isEmpty() || dstSetter.isEmpty()) {
                throw new Exception("Unable to determine getter and setter for property {property}");
            }

            dstSetter.get().invoke(dst, srcGetter.get().invoke(src));
        }
    }
}
