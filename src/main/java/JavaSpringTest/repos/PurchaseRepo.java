package JavaSpringTest.repos;

import JavaSpringTest.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {
    boolean existsBypid(int pid );

   @Query(nativeQuery = true,value = " SELECT * FROM purchases WHERE pdate >= current_date - 7")
    List<Purchase> lastweek();

    @Query(nativeQuery = true,value = " SELECT * FROM purchases WHERE pdate >= current_date - 30")
    List<Purchase> lastMonth();

    @Query(nativeQuery = true,value = " SELECT * FROM purchases WHERE pdate >= current_date - 180")
    List<Purchase> lastHalfYear();

    //most purchased item per month
    @Query(nativeQuery = true,value = " SELECT i.name\n" +
            "FROM purchases p\n" +
            "JOIN usr u on p.uid = u.id\n" +
            "JOIN items i on p.pid = i.ig_id\n" +
            "WHERE pdate >= current_date - 30\n" +
            "GROUP BY i.name\n" +
            "ORDER BY count(*) desc\n" +
            "\tLIMIT 1\n")
    String mpipermonth();

    @Query(nativeQuery = true,value = " SELECT name,lastname from usr_info\n" +
            "WHERE user_info_id = (\n" +
            "SELECT p.uid\n" +
            "FROM purchases p\n" +
            "JOIN usr u on p.uid = u.id\n" +
            "WHERE pdate >= current_date - 180\n" +
            "GROUP BY p.uid\n" +
            "ORDER BY count(*) desc\n" +
            "LIMIT 1)")
    String buratino();

    @Query(nativeQuery = true,value = "SELECT i.name\n" +
            "FROM purchases p\n" +
            "JOIN usr u on p.uid = u.id\n" +
            "JOIN items i on p.pid = i.ig_id\n" +
            "JOIN usr_info info on u.id = info.user_info_id\n" +
            "WHERE age=18\n" +
            "GROUP BY i.name\n" +
            "ORDER BY count(*) desc\n" +
            "LIMIT 1")
    String mfi18yo();

}

