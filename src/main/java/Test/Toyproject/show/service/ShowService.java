package Test.Toyproject.show.service;

import Test.Toyproject.show.domain.SortType;
import Test.Toyproject.show.dto.GetShowResponseDto;
import Test.Toyproject.show.entity.Show;
import Test.Toyproject.show.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    public List<GetShowResponseDto> getShow(SortType sort) {
        // sort에 따라 분류
        // 1.인기 많은 순(예약 기준) 2. (등록)최신 순 3.공연 임박 순
        List<Show> shows = switch (sort) {
            case LATEST -> showRepository.findAllByOrderByCreatedAtDesc();
            case POPULAR -> showRepository.findAllOrderByReservationCountDesc();
            case SOONEST -> showRepository.findAllByOrderByStartDateTimeAsc();
        };
        /*
          repository에서는 show라는 entity가 반환되는데, service에서는 dto가 반환되고 있다
          그래서 entity에서 dto로 매핑이 필요
        */
        return shows.stream()
                .map(GetShowResponseDto::from)
                .toList();
    }
}
