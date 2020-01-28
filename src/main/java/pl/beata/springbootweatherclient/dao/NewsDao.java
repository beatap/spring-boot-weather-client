package pl.beata.springbootweatherclient.dao;

import pl.beata.springbootweatherclient.model.News;

import java.util.List;

public interface NewsDao {

    List<News> findAll();
    News findById(Integer id);
    void save(News news);
    void modify(News news);
}
