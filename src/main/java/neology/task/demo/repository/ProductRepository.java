package neology.task.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String QUERY_SCRIPT = read("get_product_names.sql");

    public List<String> getProductName(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name.toLowerCase());
        return jdbcTemplate.queryForList(QUERY_SCRIPT, params, String.class);
    }
}