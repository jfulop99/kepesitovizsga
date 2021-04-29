package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> checkOverpopulation() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed")){
            return getResult(ps);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }

    }

    private List<String> getResult(PreparedStatement ps) throws SQLException {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                result.add(rs.getString("breed"));
            }
        }
        return result;
    }
}
