package com.ashutka.app.help;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PagedResult<T> {

    private int page;
    private long totalElements;
    private List<T> elements;

    public PagedResult(List<T> elements, long totalElements, int page) {
        this.elements = elements;
        this.totalElements = totalElements;
        this.page = page;
    }

}
