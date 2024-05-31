package com.example.TASK5.service;

public interface IConverteDados {
    <T> T converte(String json, Class<T> classe);
}
