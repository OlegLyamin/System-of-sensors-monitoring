package ru.admin.oleg.simulator;

import ru.admin.oleg.core.Sensors;


public class SensorsSimulator implements Sensors {

    private String emai;
    private int status;
    private int value;
    private String name;


    @Override
    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    @Override
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
