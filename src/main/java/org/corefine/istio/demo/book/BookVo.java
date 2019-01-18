package org.corefine.istio.demo.book;

import java.util.List;

public class BookVo {
    private Long id;
    private String name;
    private String version;
    private List<ChapterVo> chapters;

    public Long getId() {
        return id;
    }

    public BookVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public BookVo setVersion(String version) {
        this.version = version;
        return this;
    }

    public List<ChapterVo> getChapters() {
        return chapters;
    }

    public BookVo setChapters(List<ChapterVo> chapters) {
        this.chapters = chapters;
        return this;
    }
}
