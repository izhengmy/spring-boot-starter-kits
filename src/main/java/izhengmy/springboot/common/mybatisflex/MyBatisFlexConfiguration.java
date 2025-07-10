package izhengmy.springboot.common.mybatisflex;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.logicdelete.LogicDeleteProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j(topic = "mybatis-flex-sql")
public class MyBatisFlexConfiguration {

    public MyBatisFlexConfiguration() {
        AuditManager.setAuditEnable(true);

        AuditManager.setMessageCollector(
                auditMessage -> log.debug("[{}ms] {}", auditMessage.getElapsedTime(), auditMessage.getFullSql())
        );
    }

    @Bean
    public LogicDeleteProcessor logicDeleteProcessor() {
        return new DateTimeLogicDeleteProcessor();
    }

}
