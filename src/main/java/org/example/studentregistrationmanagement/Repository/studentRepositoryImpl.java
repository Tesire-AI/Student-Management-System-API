package org.example.studentregistrationmanagement.Repository;

import org.example.studentregistrationmanagement.model.Student;
import org.example.studentregistrationmanagement.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class studentRepositoryImpl implements studentRepository {
     private final DatabaseConnection db;

    public studentRepositoryImpl(DatabaseConnection db) {
        this.db = db;
    }

    @Override
    public void save(Student student) {
        String fullName = student.getFirstName() + " " + student.getLastName();
        String selectSql = "INSERT INTO students (full_name, email, age) VALUES (?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(selectSql)) {

            ps.setString(1, fullName);
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error saving student", e);
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();


        String sql = "SELECT id, full_name, email, age FROM students ORDER BY id";

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));

                String fullName = rs.getString("full_name");
                if (fullName != null && fullName.contains(" ")) {
                    String[] nameParts = fullName.split(" ", 2);
                    student.setFirstName(nameParts[0]);
                    student.setLastName(nameParts[1]);
                } else {
                    student.setFirstName(fullName != null ? fullName : "");
                    student.setLastName("");
                }

                student.setEmail(rs.getString("email"));
                student.setAge(rs.getInt("age"));

                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException( e.getMessage());
        }

        return students;
    }
}
