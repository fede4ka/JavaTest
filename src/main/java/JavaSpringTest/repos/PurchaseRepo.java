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


}

