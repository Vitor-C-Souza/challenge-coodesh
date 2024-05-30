package com.example.TASK4;

public interface IConverteDados {
    <T> T converte(String json, Class<T> classe);
}
