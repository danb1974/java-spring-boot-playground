package com.example.movielibrary.interfaces;

import com.example.movielibrary.dto.BaseDto;

public interface IDtoEntity {
    public abstract BaseDto toDto() throws Exception;
}
