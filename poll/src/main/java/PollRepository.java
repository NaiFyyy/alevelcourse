import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


class PollRepository {

    private final DataSource dataSource;

    PollRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    Long save(Poll entity) throws PollException {
        String insert = "INSERT INTO poll (question, answer) VALUE (?,?)";
        String select = "SELECT LAST_INSERT_ID()";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement update = connection.prepareStatement(insert);
             PreparedStatement query = connection.prepareStatement(select)
        ) {
            update.setString(1, entity.getQuestion());
            update.setString(2, entity.getAnswer());
            update.executeUpdate();
            ResultSet resultSet = query.executeQuery();
            resultSet.first();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new PollException(e);
        }
    }

    String getAnswer(String question) throws PollException {
        String insert = "SELECT answer FROM poll WHERE question = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, question);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            return resultSet.getString("answer");
        } catch (SQLException e) {
            throw new PollException(e);
        }
    }


}

