/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/config/MongoDBConfig.java.hbs
 */
package cn.ibizlab.plm.util.config;

import cn.ibizlab.util.helper.JSR310DateConverters;
import cn.ibizlab.util.repository.IBZMongoSimpleRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author generator
 */
@Configuration
@ConditionalOnProperty(name = "ibiz.mongodb.enabled", havingValue = "true", matchIfMissing = false)
@EnableMongoRepositories(basePackages = "cn.ibizlab.plm.core.*.repository", repositoryBaseClass = IBZMongoSimpleRepository.class)
public class MongoDBConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(JSR310DateConverters.DateToZonedDateTimeConverter.INSTANCE);
        converterList.add(JSR310DateConverters.ZonedDateTimeToDateConverter.INSTANCE);
        converterList.add(JSR310DateConverters.DurationToLongConverter.INSTANCE);
        converterList.add(JSR310DateConverters.TimestampToDateConverter.INSTANCE);
        converterList.add(JSR310DateConverters.DateToTimestampConverter.INSTANCE);
        return new MongoCustomConversions(converterList);
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory factory, MongoMappingContext context, BeanFactory beanFactory) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        try {
            mappingConverter.setCustomConversions(customConversions());
        } catch (NoSuchBeanDefinitionException ignore) {

        }
        //移除插入是附带的_class属性
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingConverter;
    }

}