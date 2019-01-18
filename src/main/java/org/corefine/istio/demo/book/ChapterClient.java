package org.corefine.istio.demo.book;

import org.corefine.common.feign.FeignClient;

import java.util.List;

import feign.Param;
import feign.RequestLine;

@FeignClient("chapter")
public interface ChapterClient {
    @RequestLine("GET /chapter/{id}")
    ChapterVo get(@Param("id") Long id);

    @RequestLine("GET /chapter/list/{type}")
    List<ChapterVo> list(@Param("type") String type);
}
