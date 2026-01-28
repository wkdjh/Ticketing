package Test.Toyproject.show.controller;

import Test.Toyproject.show.domain.SortType;
import Test.Toyproject.show.dto.GetShowResponseDto;
import Test.Toyproject.show.entity.Show;
import Test.Toyproject.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    /*
    1. 메인 페이지에서 공연 조회
    - 반환 타입은 ResponseEntity 형식이고 여러 개의 Dto를 List로 반환
    - @RequestParam 이용해서 쿼리 스트링에서 정렬 기준 가져오기
    -

     */

    @GetMapping("/show/musical")
    public ResponseEntity<List<GetShowResponseDto>> getShow(
            @RequestParam(name = "sort") String sortParam) {

        // 로직
        // 쿼리 스트링에 있는 걸 sortParam에 저장하는 건가? 뭐지??
        SortType sort = SortType.from(sortParam);

        List<GetShowResponseDto> response = showService.getShow(sort);

        return ResponseEntity.ok(response);
    }

}
