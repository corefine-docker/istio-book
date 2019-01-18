package org.corefine.istio.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("book")
public class Controller {
    @Autowired
    private ChapterClient chapterClient;
    @Value("${book.version}")
    private String version;
    @Autowired
    private ContentClient contentClient;

    @GetMapping("{id}")
    public Object get(@PathVariable Long id) {
        return getChapter(id, null);
    }

    @GetMapping("list/{type}")
    public Object list(@PathVariable String type) {
        List<BookVo> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list.add(getChapter(null, type));
        }
        return list;
    }

    private BookVo getChapter(Long id, String type) {
        List<ChapterVo> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            if (type == null) {
                list.add(chapterClient.get((long) i));
            } else {
                list.addAll(chapterClient.list(type));
            }
        }
        return new BookVo().setChapters(list).setId(id).setName("book " + id).setVersion(version);
    }
}
