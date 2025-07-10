package izhengmy.springboot.common.mybatisflex;

import com.mybatisflex.core.logicdelete.NullableColumnLogicDeleteProcessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeLogicDeleteProcessor extends NullableColumnLogicDeleteProcessor {

    @Override
    public Object getLogicDeletedValue() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "'" + now.format(formatter) + "'";
    }

}
