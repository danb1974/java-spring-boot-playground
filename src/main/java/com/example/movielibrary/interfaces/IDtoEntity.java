package com.example.movielibrary.interfaces;

import com.example.movielibrary.dtos.BaseDto;

public interface IDtoEntity {
    BaseDto toDto() throws Exception;
}
