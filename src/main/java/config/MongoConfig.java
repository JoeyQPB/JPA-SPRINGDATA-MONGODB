package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "repository")
public class MongoConfig {

	@Bean
    public MongoClient mongo() throws Exception {
		final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/JPA-EBAC?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "JPA-EBAC");
    }

}