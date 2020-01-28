package pl.beata.springbootweatherclient.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.beata.springbootweatherclient.model.News;

import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    private JdbcTemplate jdbcTemplate;
    private static final String TABLE_NAME = "news";
    private String sql = "";

    @Autowired
    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<News> findAll() {
        sql = "SELECT * FROM " + TABLE_NAME;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(News.class));
    }

    @Override
    public News findById(Integer id) {
        sql = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";

        return (News) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(News.class), id);
    }

    @Override
    public void save(News news) {
        sql = "INSERT IGNORE INTO " + TABLE_NAME + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, null, news.getBy(), news.getDescendants(), news.getId(),
                news.getScore(), news.getText(), news.getTime(), news.getTitle(), news.getType(), news.getUrl());

    }

    @Override
    public void modify(News news) {
        sql = "UPDATE news SET descendants = ?, score = ?, text = ?, title = ?, " +
                "type = ?, url = ? WHERE id = ?";

        jdbcTemplate.update(sql, news.getDescendants(), news.getScore(), news.getText(),
                news.getTitle(), news.getType(), news.getUrl(), news.getId());
    }
}
