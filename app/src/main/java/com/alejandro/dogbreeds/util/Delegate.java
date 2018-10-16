package com.alejandro.dogbreeds.util;

public interface Delegate<T> {

    void execute(T objectValue, Exception e);

}
