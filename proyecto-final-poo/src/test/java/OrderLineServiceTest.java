import org.example.dao.CustomerRepository;
import org.example.dao.OrderLineRepository;
import org.example.model.OrderLine;
import org.example.model.Product;
import org.example.service.CustomerService;
import org.example.service.OrderLineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class OrderLineServiceTest {
    @Mock
    public OrderLineRepository orderLineRepository;
    @InjectMocks
    public OrderLineService orderLineService;

    @Test
    public void saveOrderLine(){
        OrderLine orderline = new OrderLine(null,4);

        when(orderLineRepository.create(orderline)).thenReturn(orderline);



        OrderLine orderLineResult = orderLineService.save(orderline);

        assertNull(orderLineResult.getProduct());
        assertEquals(orderLineResult.getQuantity(),4);


    }
}
