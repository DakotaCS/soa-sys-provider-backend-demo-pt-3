package com.cs4471.cspsp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.dozer.DozerBeanMapper;

public class BeanMapper {

    private static final DozerBeanMapper dozer = new DozerBeanMapper();

    private BeanMapper() {
    }

    static {
        List<String> mappingFiles = Collections.singletonList("dozer-global-configuration.xml");

        dozer.setMappingFiles(mappingFiles);
    }

    public static <T> T map(Object source, Class<T> destinationClass) {
        return dozer.map(source, destinationClass);
    }

    @SuppressWarnings("unused")
    public static <T> List<T> mapList(Collection<? extends Object> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public static void copy(Object source, Object destinationObject) {
        dozer.map(source, destinationObject);
    }
}
