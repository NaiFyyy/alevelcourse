import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Poll {
    private final Long id;
    private String question;
    private String answer;

    public Long getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }


    @JsonCreator
    public Poll(
            @JsonProperty("id") Long id,
            @JsonProperty("question") String question,
            @JsonProperty("answer") String answer
    ) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poll poll = (Poll) o;
        return Objects.equals(id, poll.id) &&
                Objects.equals(question, poll.question) &&
                Objects.equals(answer, poll.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }
}
