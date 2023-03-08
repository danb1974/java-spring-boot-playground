package com.example.movielibrary.classes;

public class Pager {
    private final int pageSize;

    private final int totalRecords;

    private final int currentPage;

    private int firstPage;

    private int lastPage;

    private boolean showPrev;

    private boolean showNext;

    public Pager(int currentPage, int pageSize, int totalRecords) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;

        calculatePager();
    }

    private void calculatePager() {
        int totalPages = (int) Math.ceil((float) totalRecords / pageSize);

        firstPage = Math.max(1, currentPage - 2);
        lastPage = Math.min(firstPage + 4, totalPages);
        showPrev = firstPage != 1;
        showNext = lastPage != totalPages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }
}
