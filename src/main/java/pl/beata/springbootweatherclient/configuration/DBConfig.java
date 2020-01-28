package pl.beata.springbootweatherclient.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    private DataSource dataSource;

    @Autowired
    public DBConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        String sql = "CREATE TABLE news(news_id int, author varchar(256), descendants int, id int, score int, " +
//                " text varchar(1000), time int, title varchar(256), type varchar(100), url varchar(256), PRIMARY KEY (news_id))";
//
//        getJdbcTemplate().update(sql);
//    }
}
