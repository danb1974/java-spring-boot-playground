package com.example.movielibrary.interfaces;

import com.example.movielibrary.dto.BaseDto;

public interface IDtoEntity {
    BaseDto toDto() throws Exception;
}
