package izhengmy.springboot.pagination;

import com.mybatisflex.core.paginate.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class Paginator<T> {

    private List<T> items;

    private Pagination pagination;

    public static <T> Paginator<T> of(Page<T> page) {
        long total = page.getTotalRow();
        long perPage = page.getPageSize();
        long currentPage = page.getPageNumber();
        long lastPage = page.getTotalPage();

        Paginator<T> paginator = new Paginator<>();
        paginator.items = page.getRecords();
        paginator.pagination = new Pagination(total, perPage, currentPage, lastPage);

        return paginator;
    }

}
