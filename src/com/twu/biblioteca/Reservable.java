package com.twu.biblioteca;

public interface Reservable {

    public boolean reserve();

    public String failureMessage();

    public String successMessage();

}
