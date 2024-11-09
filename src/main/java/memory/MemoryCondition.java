package memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


@Slf4j
public class MemoryCondition implements Condition {

    /**
     * 환경정보에
     * -Dmemory=on
     * 이라고 되어있을 때만 'true' 반환
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // -Dmemory=on 일때 적용되도록.
        String memory = context.getEnvironment().getProperty("memory");
        log.info("memory = {}", memory);
        return "on".equals(memory);
    }
}
