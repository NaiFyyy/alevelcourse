import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@WebServlet("/poll")
public class PollServlet extends HttpServlet {
    private ObjectMapper objectMapper;
    private HikariDataSource dataSource;
    private PollRepository pollRepository;

    @Override
    public void init() {
        HikariConfig hikariConfig = new HikariConfig("/hikary.properties");
        dataSource = new HikariDataSource(hikariConfig);
        pollRepository = new PollRepository(dataSource);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Poll> polls;
        try {
            polls = pollRepository.listAnswers();
        } catch (PollException e) {
            resp.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
            return;
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json;charset=utf8");
        objectMapper.writeValue(resp.getOutputStream(), polls);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Poll todo = objectMapper.readValue(req.getInputStream(), Poll.class);
        Long id;
        try {
            id = pollRepository.save(todo);
        } catch (PollException e) {
            resp.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
            return;
        }
        Map<String, Long> responseData = Collections.singletonMap("id", id);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json;charset=utf8");
        objectMapper.writeValue(resp.getOutputStream(), responseData);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Poll[] polls = objectMapper.readValue(req.getInputStream(), Poll[].class);
        try {
            pollRepository.batchUpdate(Arrays.asList(polls));
        } catch (PollException e) {
            resp.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
            return;
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void destroy() {
        dataSource.close();
    }
}

