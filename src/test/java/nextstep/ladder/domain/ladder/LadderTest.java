package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.game.Destination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void create() {
        Ladder ladder = new Ladder(Height.from(5), 3, new DirectionRandomPredicate());
        assertThat(ladder.getLines()).hasSize(5);
        assertThat(ladder.getLines().get(0).getPositions()).isNotNull();
        assertThat(ladder.getHeight()).isEqualTo(5);
    }


    @ValueSource(ints = {0, 1, 2, 3,})
    @ParameterizedTest
    @DisplayName("사다리 도착지 메소드 테스트")
    void findDestination(int order) {
        Ladder ladder = new Ladder(Height.from(5), 3, new DirectionRandomPredicate());
        Destination destination = ladder.findDestination(order);
        assertThat(destination).isNotNull();
        assertThat(destination.getOrder()).isLessThanOrEqualTo(order);
    }
}
