package com.example.movielibrary.classes;

import com.example.movielibrary.dto.BaseDto;
import com.example.movielibrary.interfaces.IDtoEntity;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PagedRecords<T> {
    private List<T> records = new ArrayList<>();

    private int count;

    private final int total;

    public PagedRecords(List<T> records, int total) {
        this.records = records;
        this.count = records.size();
        this.total = total;
    }

    public PagedRecords(Page<T> page) {
        this(page.getContent(), (int)page.getTotalElements());
    }

    public PagedRecords(int total) {
        this.total = total;
    }

    public void addRecord(T record) {
        records.add(record);
        count++;
    }

    public List<T> getRecords() {
        return records;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
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
