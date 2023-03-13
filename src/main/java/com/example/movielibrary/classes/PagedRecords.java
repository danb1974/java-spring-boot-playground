package com.example.movielibrary.classes;

import org.springframework.data.domain.Page;

import java.util.List;

public class PagedRecords<T> {
    private final List<T> records;

    private final int total;

    public PagedRecords(List<T> records, int total) {
        this.records = records;
        this.total = total;
    }

    public PagedRecords(Page<T> page) {
        this(page.getContent(), (int) page.getTotalElements());
    }

    public void addRecord(T record) {
        records.add(record);
    }

    public List<T> getRecords() {
        return records;
    }

    public int getCount() {
        return records.size();
    }

    public int getTotal() {
        return total;
    }
}
