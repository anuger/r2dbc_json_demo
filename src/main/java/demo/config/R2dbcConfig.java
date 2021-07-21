package demo.config;

import demo.entity.MessageBody;
import demo.utils.JsonUtils;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class R2dbcConfig {

    @Bean
    public R2dbcCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new MessageBodyReadConverter());
        converters.add(new MessageBodyWriteConverter());
        return R2dbcCustomConversions.of(PostgresDialect.INSTANCE, converters);
    }

    @ReadingConverter
    static class MessageBodyReadConverter implements Converter<Json, MessageBody> {
        @Override
        public MessageBody convert(Json json) {
            return JsonUtils.parse(json.asString(), MessageBody.class);
        }
    }

    @WritingConverter
    static class MessageBodyWriteConverter implements Converter<MessageBody, Json> {

        @Override
        public Json convert(MessageBody messageBody) {
            return Json.of(JsonUtils.toJson(messageBody));
        }
    }

}
