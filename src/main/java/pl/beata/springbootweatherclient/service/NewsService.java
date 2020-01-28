package pl.beata.springbootweatherclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.beata.springbootweatherclient.dao.NewsDao;
import pl.beata.springbootweatherclient.model.News;

import java.util.List;

@Service
public class NewsService {

    private NewsDao newsDao;

    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }


    public List<News> getAllNews() {
        return newsDao.findAll();
    }

    public void addNews(List<News> news) {
        news.stream().forEach(n -> newsDao.save(n));
    }

    public News getNewsById(Integer id) {
        return newsDao.findById(id);
    }

    public void modifyNews(News news) {
        newsDao.modify(news);
    }
}
