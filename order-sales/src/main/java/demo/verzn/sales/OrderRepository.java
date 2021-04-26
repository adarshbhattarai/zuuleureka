package demo.verzn.sales;

import org.springframework.data.repository.CrudRepository;

/**
 * @author adarshbhattarai on 2021-04-26
 * @project zuuleureka
 */
public interface OrderRepository extends CrudRepository<Sorder,Long> {
}
