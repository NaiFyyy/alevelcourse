import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PollRepository {
    private final DataSource dataSource;

    public PollRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Long save(Poll entity) throws PollException {
        String insert = "INSERT INTO pollbase (question) VALUE (?)";
        String select = "SELECT LAST_INSERT_ID()";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement update = connection.prepareStatement(insert);
             PreparedStatement query = connection.prepareStatement(select)
        ) {
            update.setString(1, entity.getQuestion());
            update.executeUpdate();
            ResultSet resultSet = query.executeQuery();
            resultSet.first();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new PollException(e);
        }
    }

    public void update(Poll entity) throws PollException {
        String sql = "UPDATE pollabase SET question = ?, answer = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(sql)
        ) {
            query.setString(1, entity.getQuestion());
            query.setString(2, entity.getAnswer());
            query.setLong(3, entity.getId());
            query.executeUpdate();
        } catch (SQLException e) {
            throw new PollException(e);
        }
    }

    public void batchUpdate(Iterable<Poll> batch) throws PollException {
        String sql = "UPDATE pollbase SET question = ?, answer = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(sql)
        ) {
            for (Poll poll : batch) {
                query.setString(1, poll.getQuestion());
                query.setString(2, poll.getQuestion());
                query.setLong(3, poll.getId());
                query.addBatch();
            }
            query.executeBatch();
        } catch (SQLException e) {
            throw new PollException(e);
        }
    }

    public List<Poll> listAnswers() throws PollException {
        String sql = "SELECT * FROM pollabase WHERE answer = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(sql)
        ) {
            ResultSet resultSet = query.executeQuery();
            List<Poll> poll = new LinkedList<>();
            while (resultSet.next()) {
                poll.add(new Poll(
                        resultSet.getLong("id"),
                        resultSet.getString("question"),
                        resultSet.getString("answer")
                ));
            }
            return poll;
        } catch (SQLException e) {
            throw new PollException(e);
        }
    }
}
