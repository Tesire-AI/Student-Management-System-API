package Repository;

import org.example.studentregistrationmanagement.DatabaseConnection;
import org.springframework.stereotype.Repository;

@Repository
public class studentRepositoryImpl implements studentRepository {
     DatabaseConnection db;

}
