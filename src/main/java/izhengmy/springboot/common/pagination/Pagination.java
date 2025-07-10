package izhengmy.springboot.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pagination {

    private long total;

    private long perPage;

    private long currentPage;

    private long lastPage;

}
