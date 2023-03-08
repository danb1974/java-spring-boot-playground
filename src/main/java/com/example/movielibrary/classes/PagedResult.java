package com.example.movielibrary.classes;

import com.example.movielibrary.dto.BaseDto;
import com.example.movielibrary.interfaces.IDtoEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PagedResult<T> {
    List<T> records = new ArrayList<>();

    int count = 0;

    int total = 0;

    public PagedResult(List<T> records, int total) {
        this.records = records;
        this.count = records.size();

        this.total = total;
    }

    public PagedResult(Page<T> page) {
        this(page.getContent(), (int)page.getTotalElements());
    }

    public PagedResult(int total) {
        this.total = total;
    }

    public void addRecord(T result) {
        records.add(result);
        count++;
    }

    public List<T> getRecords() {
        return records;
    }

    public int getCount() {
        return count;
    }

    public List<BaseDto> getRecordsDto() throws Exception {
        List<BaseDto> recordsDto = new ArrayList<>();

        for (Object record : records) {
            if (!(record instanceof IDtoEntity)) {
                throw new Exception("Object is not an instance of IDtoEntity");
            }

            recordsDto.add(((IDtoEntity) record).toDto());
        }

        return recordsDto;
    }
}
