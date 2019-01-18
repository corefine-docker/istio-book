package org.corefine.istio.demo.book;

import org.corefine.common.feign.FeignClient;

import java.util.List;

import feign.Param;
import feign.RequestLine;

@FeignClient("chapter")
public interface ContentClient {
    @RequestLine("GET /chapter/{id}")
    ContentVo get(@Param("id") Long id);

    @RequestLine("GET /chapter/list/{type}")
    List<ContentVo> list(@Param("type") String type);
}
