package ru.admin.oleg.core;

import java.util.Date;
import java.util.List;

public interface JSONSchema {
    default String getTitle() {
        return null;
    }
    default long getTimeStamp() {
        return new Date().getTime();
    }
    default List<Sensor> getSensors() {
        return null;
    }
}
