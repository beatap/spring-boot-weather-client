package pl.beata.springbootweatherclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.beata.springbootweatherclient.model.News;
import pl.beata.springbootweatherclient.service.NewsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NewsController {

    private final RestTemplate restTemplate = new RestTemplate();
    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsServices) {
        this.newsService = newsServices;
    }



//    @GetMapping
//    public String index() {
//        return "news";
//    }

    @GetMapping("/news")
    public String getNews(Model model) {
        init();
        List<News> news = newsService.getAllNews();

        model.addAttribute("news", news);

        return "news";
    }

    @GetMapping("/modify/{newId}")
    public String modifyNewsById(@PathVariable Integer newId, Model model) {
        News news = newsService.getNewsById(newId);
        model.addAttribute("news", news);

        return "update-news";
    }

    @PostMapping("/update")
    public String updateNews(News news) {

        newsService.modifyNews(news);

        return "redirect:/news";
    }

    private List<String> getNews() {
        String[] news = restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/newstories.json",
                            String[].class);

        return Arrays.asList(news).subList(0, 10);
    }

    private News getItemNews(Integer id) {

        return restTemplate.getForObject("https://hacker-news.firebaseio.com/v0/item/{id}.json",
                News.class,
                id);
    }

    private void init(){
        List<String> news = getNews();
        List<News> itemsNew = new ArrayList<>();

        news.stream().forEach( n -> {
            itemsNew.add(getItemNews(Integer.parseInt(n)));
        });

        newsService.addNews(itemsNew);
    }
}
