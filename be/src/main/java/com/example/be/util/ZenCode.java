package com.example.be.util;

import java.util.List;

public class ZenCode {
    public String zenMa(String ten, List<?> number) {
        return ten + (number.size() + 1);
    }
}
